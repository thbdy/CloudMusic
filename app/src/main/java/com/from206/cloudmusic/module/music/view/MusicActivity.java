package com.from206.cloudmusic.module.music.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.widget.AppCompatSeekBar;
import android.text.format.DateUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.from206.cloudmusic.AppCache;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.music.model.Music;
import com.from206.cloudmusic.module.music.model.MusicUrlResult;
import com.from206.cloudmusic.module.music.model.PlayListDetailResult;
import com.from206.cloudmusic.module.music.presenter.MusicPresenter;
import com.from206.cloudmusic.module.music.presenter.MusicPresenterImpl;
import com.from206.cloudmusic.service.OnPlayerEventListener;
import com.from206.cloudmusic.service.PlayService;
import com.from206.cloudmusic.utils.HttpCode;
import com.from206.cloudmusic.utils.TimeUtil;
import com.from206.cloudmusic.view.CommonHeaderView;

import butterknife.BindView;
import butterknife.OnClick;

import static com.from206.cloudmusic.AppCache.getPlayService;

/**
 * 音乐播放页面
 * Created by 75232 on 2019/1/28
 * Email：752323877@qq.com
 */
public class MusicActivity extends LoadingBaseActivity<MusicPresenterImpl> implements MusicPresenter.View, OnPlayerEventListener, SeekBar.OnSeekBarChangeListener {
    private PlayListDetailResult.PlaylistBean.TracksBean musicBean;
    @BindView(R.id.head_view)
    CommonHeaderView headerView;
    @BindView(R.id.tv_play)
    TextView tvPlay;
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    @BindView(R.id.tv_current_time)
    TextView tvCurrentTime;
    @BindView(R.id.tv_total_time)
    TextView tvTotalTime;
    @BindView(R.id.seek_bar)
    AppCompatSeekBar mSeekBar;
    private ServiceConnection mPlayServiceConnection;
    private Music music = new Music();
    private boolean isDraggingProgress;
    private int mLastProgress;
    /**
     * 圆盘旋转动画
     */
    private ObjectAnimator discAnimation;



    @Override
    public void fetchData() {
        mPresenter.fetchMusicUrl(String.valueOf(musicBean.getId()));
//        mPresenter.fetchMusicUrl(String.valueOf("5052317"));

    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectMusicActivity(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_music;
    }

    @Override
    protected void initViews() {
        musicBean = (PlayListDetailResult.PlaylistBean.TracksBean) getIntent().getSerializableExtra("bean");
        checkService();
        initUI();
        initAni();
    }

    /**
     * 初始化动画
     */
    private void initAni() {
        discAnimation = ObjectAnimator.ofFloat(ivCover, "rotation", 0f, 360f);
        discAnimation.setDuration(20000);//设置转一圈需要的时间
        discAnimation.setInterpolator(new LinearInterpolator() );//设置插速器
        discAnimation.setRepeatCount(-1);//设置旋转次数
        discAnimation.setRepeatMode(ValueAnimator.RESTART);//设置旋转重复模
    }

    /**
     * 初始化UI
     */
    private void initUI() {
        headerView.setTitle(musicBean.getName());
        Glide.with(mContext).load(musicBean.getAl().getPicUrl()).into(ivCover);
        mSeekBar.setOnSeekBarChangeListener(this);
    }

    /**
     * 检测服务有没有运行
     */
    private void checkService() {
        if (getPlayService() == null) {
            startService();
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    bindService();
                }
            }, 1000);
        }
    }
    private void startService() {
        Intent intent = new Intent(this, PlayService.class);
        startService(intent);
    }
    private void bindService() {
        Intent intent = new Intent();
        intent.setClass(this, PlayService.class);
        mPlayServiceConnection = new PlayServiceConnection();
        bindService(intent, mPlayServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void setState(int state, String msg) {

    }

    @Override
    public void loadMusicUrl(MusicUrlResult result) {
        if(result.getCode() == HttpCode.SUCCESS){
            music.setId( result.getData().get(0).getId());
            music.setPath( result.getData().get(0).getUrl());
        }

    }
    @OnClick({R.id.iv_back,R.id.tv_play})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_play:
                if(getPlayService().isPausing()|| getPlayService().isPlaying()){
                    AppCache.getPlayService().playPause();
                }else {
                    AppCache.getPlayService().play(music);
                    discAnimation.start();//开始动画
                }
                break;
        }
    }

    @Override
    public void onChange(Music music) {
        onChangeImpl(music);

    }
    /**
     * 更新播放信息
     * @param music
     */
    private void onChangeImpl(Music music) {
        if (music == null) {
            return;
        }
        mLastProgress = 0;
        tvCurrentTime.setText("00:00");
        tvTotalTime.setText(TimeUtil.duration2Time((int)getPlayService().getDuration()));
        mSeekBar.setProgress((int) getPlayService().getCurrentPosition());
        mSeekBar.setMax((int) getPlayService().getDuration());
        if (getPlayService().isPlaying() || getPlayService().isPreparing()) {
//            btnPlay.setText("暂停");
            tvPlay.setActivated(true);
        } else {
            tvPlay.setActivated(false);
//            btnPlay.setText("播放");
        }
    }

    @Override
    public void onPlayerStart() {
        tvPlay.setActivated(true);
        discAnimation.resume();
    }

    @Override
    public void onPlayerPause() {
        tvPlay.setActivated(false);
        discAnimation.pause();
    }

    @Override
    public void onPublish(int progress) {
        if (!isDraggingProgress) {
            mSeekBar.setProgress(progress);

        }
    }

    @Override
    public void onBufferingUpdate(int percent) {

    }

    @Override
    public void onGetDuration(long duration) {
        mSeekBar.setMax((int) duration);
        tvTotalTime.setText(TimeUtil.duration2Time((int)duration));


    }

    @Override
    public void onTimer(long remain) {

    }

    @Override
    public void onMusicListUpdate() {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == mSeekBar) {
            if (Math.abs(progress - mLastProgress) >= DateUtils.SECOND_IN_MILLIS) {
                tvCurrentTime.setText(TimeUtil.duration2Time(progress));
                mLastProgress = progress;
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (seekBar == mSeekBar) {
            isDraggingProgress = true;
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar == mSeekBar) {
            isDraggingProgress = false;
            if (getPlayService().isPlaying() || getPlayService().isPausing()) {
                int progress = seekBar.getProgress();
                getPlayService().seekTo(progress);
            } else {
                seekBar.setProgress(0);
            }
        }
    }

    private  class PlayServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            final PlayService playService = ((PlayService.PlayBinder) service).getService();
            AppCache.setPlayService(playService);
            AppCache.getPlayService().setOnPlayEventListener(MusicActivity.this);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }
}
