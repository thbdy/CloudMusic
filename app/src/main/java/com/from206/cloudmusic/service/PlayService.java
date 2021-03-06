package com.from206.cloudmusic.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.blankj.utilcode.util.ToastUtils;
import com.from206.cloudmusic.AppCache;
import com.from206.cloudmusic.module.music.model.Music;
import com.from206.cloudmusic.service.enums.Actions;
import com.from206.cloudmusic.service.enums.PlayModeEnum;
import com.from206.cloudmusic.service.event.GetDurationEvent;
import com.from206.cloudmusic.service.event.OnChangeEvent;
import com.from206.cloudmusic.service.event.OnPublishEvent;
import com.from206.cloudmusic.service.event.PlayerStartEvent;
import com.from206.cloudmusic.service.event.PlayerStopEvent;
import com.from206.cloudmusic.utils.Preferences;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Random;





/**
 * 音乐播放后台服务
 */
public class PlayService extends Service implements MediaPlayer.OnCompletionListener {
    private static final String TAG = "Service";
    private static final long TIME_UPDATE = 100L;

    private static final int STATE_IDLE = 0;
    private static final int STATE_PREPARING = 1;
    private static final int STATE_PLAYING = 2;
    private static final int STATE_PAUSE = 3;

    private final IntentFilter mNoisyFilter = new IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY);
    private final Handler mHandler = new Handler();
    private MediaPlayer mPlayer = new MediaPlayer();
    private AudioFocusManager mAudioFocusManager;
//    private MediaSessionManager mMediaSessionManager;
    private OnPlayerEventListener mListener;
    // 正在播放的歌曲[本地|网络]
    private Music mPlayingMusic;
    // 正在播放的本地歌曲的序号
    private int mPlayingPosition = -1;
    private int mPlayState = STATE_IDLE;
    private long mDuration = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        mAudioFocusManager = new AudioFocusManager(this);
//        mMediaSessionManager = new MediaSessionManager(this);
        mPlayer.setOnCompletionListener(this);
//        Notifier.init(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new PlayBinder();
    }

    public static void startCommand(Context context, String action) {
        Intent intent = new Intent(context, PlayService.class);
        intent.setAction(action);
        context.startService(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            switch (intent.getAction()) {
                case Actions.ACTION_MEDIA_PLAY_PAUSE:
                    playPause();
                    break;
                case Actions.ACTION_MEDIA_NEXT:
                    next();
                    break;
                case Actions.ACTION_MEDIA_PREVIOUS:
                    prev();
                    break;
            }
        }
        return START_NOT_STICKY;
    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        next();
    }

    public OnPlayerEventListener getOnPlayEventListener() {
        return mListener;
    }

    public void setOnPlayEventListener(OnPlayerEventListener listener) {
        mListener = listener;
    }

    public void play(int position) {
        if (AppCache.getMusicList().isEmpty()) {
            return;
        }

        if (position < 0) {
            position = AppCache.getMusicList().size() - 1;
        } else if (position >= AppCache.getMusicList().size()) {
            position = 0;
        }

        mPlayingPosition = position;
        Music music = AppCache.getMusicList().get(mPlayingPosition);
        Preferences.saveCurrentSongId(music.getId());
        play(music);
    }

    public void play(Music music) {
        mPlayingMusic = music;
        try {
            mPlayer.reset();
//            Uri mUri = Uri.parse("android.resource://" + getPackageName() + "/"+ R.raw.video);
//            mPlayer.setDataSource(this,mUri);
            Log.e(TAG, "play: "+music.getPath() );
            mPlayer.setDataSource(music.getPath());
            mPlayer.prepareAsync();
            mPlayState = STATE_PREPARING;
            mPlayer.setOnPreparedListener(mPreparedListener);
            mPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
            if (mListener != null) {
                mListener.onChange(music);
                EventBus.getDefault().post(new OnChangeEvent(music));
            }
            AppCache.addMusicList(music);//添加到播放列表里
//            Notifier.showPlay(music);
//            mMediaSessionManager.updateMetaData(mPlayingMusic);
//            mMediaSessionManager.updatePlaybackState();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MediaPlayer.OnPreparedListener mPreparedListener = new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            if (isPreparing()) {
                start();
                if(mListener != null){
                    mDuration = mp.getDuration();
                    mListener.onGetDuration(mp.getDuration());
                    EventBus.getDefault().post(new GetDurationEvent(mp.getDuration()));
                }
            }
        }
    };

    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
        @Override
        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            if (mListener != null) {
                mListener.onBufferingUpdate(percent);
            }
        }
    };

    public void playPause() {
        if (isPreparing()) {
            stop();
        } else if (isPlaying()) {
            pause();
        } else if (isPausing()) {
            start();
        } else {
            play(getPlayingPosition());
        }
    }

    void start() {
        if (!isPreparing() && !isPausing()) {
            return;
        }

        if (mAudioFocusManager.requestAudioFocus()) {
            mPlayer.start();
            mPlayState = STATE_PLAYING;
            mHandler.post(mPublishRunnable);
//            Notifier.showPlay(mPlayingMusic);
//            mMediaSessionManager.updatePlaybackState();

            if (mListener != null) {
                mListener.onPlayerStart();
                EventBus.getDefault().post(new PlayerStartEvent());

            }
        }
    }

    void pause() {
        if (!isPlaying()) {
            return;
        }

        mPlayer.pause();
        mPlayState = STATE_PAUSE;
        mHandler.removeCallbacks(mPublishRunnable);
//        Notifier.showPause(mPlayingMusic);
//        mMediaSessionManager.updatePlaybackState();

        if (mListener != null) {
            mListener.onPlayerPause();
            EventBus.getDefault().post(new PlayerStopEvent());
        }
    }

    public void stop() {
        if (isIdle()) {
            return;
        }

        pause();
        mPlayer.reset();
        mPlayState = STATE_IDLE;
    }

    public void next() {
        if (AppCache.getMusicList().isEmpty()) {
            ToastUtils.showShort("没有下一首了");
            return;
        }
        PlayModeEnum mode = PlayModeEnum.valueOf(Preferences.getPlayMode());
        switch (mode) {
            case SHUFFLE:
                mPlayingPosition = new Random().nextInt(AppCache.getMusicList().size());
                play(mPlayingPosition);
                break;
            case SINGLE:
                play(mPlayingPosition);
                break;
            case LOOP:
            default:
                play(mPlayingPosition + 1);
                break;
        }
    }



    public void prev() {
        if (AppCache.getMusicList().isEmpty()) {
            ToastUtils.showShort("没有上一首了");
            return;
        }

        PlayModeEnum mode = PlayModeEnum.valueOf(Preferences.getPlayMode());
        switch (mode) {
            case SHUFFLE:
                mPlayingPosition = new Random().nextInt(AppCache.getMusicList().size());
                play(mPlayingPosition);
                break;
            case SINGLE:
                play(mPlayingPosition);
                break;
            case LOOP:
            default:
                play(mPlayingPosition - 1);
                break;
        }
    }

    /**
     * 跳转到指定的时间位置
     *
     * @param msec 时间
     */
    public void seekTo(int msec) {
        if (isPlaying() || isPausing()) {
            mPlayer.seekTo(msec);
//            mMediaSessionManager.updatePlaybackState();
            if (mListener != null) {
                mListener.onPublish(msec);
                EventBus.getDefault().post(new OnPublishEvent(msec));
            }
        }
    }
    public long getDuration(){
        return  mDuration;
    }

    public boolean isPlaying() {
        return mPlayState == STATE_PLAYING;
    }

    public boolean isPausing() {
        return mPlayState == STATE_PAUSE;
    }

    public boolean isPreparing() {
        return mPlayState == STATE_PREPARING;
    }

    public boolean isIdle() {
        return mPlayState == STATE_IDLE;
    }

    /**
     * 获取正在播放的本地歌曲的序号
     */
    public int getPlayingPosition() {
        return mPlayingPosition;
    }

    /**
     * 获取正在播放的歌曲[本地|网络]
     */
    public Music getPlayingMusic() {
        return mPlayingMusic;
    }

//    /**
//     * 删除或下载歌曲后刷新正在播放的本地歌曲的序号
//     */
//    public void updatePlayingPosition() {
//        int position = 0;
//        long id = Preferences.getCurrentSongId();
//        for (int i = 0; i < AppCache.getMusicList().size(); i++) {
//            if (AppCache.getMusicList().get(i).getId() == id) {
//                position = i;
//                break;
//            }
//        }
//        mPlayingPosition = position;
//        Preferences.saveCurrentSongId(AppCache.getMusicList().get(mPlayingPosition).getId());
//    }

    public int getAudioSessionId() {
        return mPlayer.getAudioSessionId();
    }

    public long getCurrentPosition() {
        if (isPlaying() || isPausing()) {
            return mPlayer.getCurrentPosition();
        } else {
            return 0;
        }
    }

    private Runnable mPublishRunnable = new Runnable() {
        @Override
        public void run() {
            if (isPlaying() && mListener != null) {
                mListener.onPublish(mPlayer.getCurrentPosition());
                EventBus.getDefault().post(new OnPublishEvent(mPlayer.getCurrentPosition()));

            }
            mHandler.postDelayed(this, TIME_UPDATE);
        }
    };

    @Override
    public void onDestroy() {
        mPlayer.reset();
        mPlayer.release();
        mPlayer = null;
        mAudioFocusManager.abandonAudioFocus();
//        mMediaSessionManager.release();
//        Notifier.cancelAll();
        AppCache.setPlayService(null);
        super.onDestroy();
    }

    public void quit() {
        stop();
        stopSelf();
    }

    public class PlayBinder extends Binder {
        public PlayService getService() {
            return PlayService.this;
        }
    }
}
