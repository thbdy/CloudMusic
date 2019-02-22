package com.from206.cloudmusic.module.music.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.widget.AppCompatSeekBar;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.from206.cloudmusic.AppCache;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.music.model.LyricResult;
import com.from206.cloudmusic.module.music.model.Music;
import com.from206.cloudmusic.module.music.model.MusicUrlResult;
import com.from206.cloudmusic.module.music.presenter.MusicPresenter;
import com.from206.cloudmusic.module.music.presenter.MusicPresenterImpl;
import com.from206.cloudmusic.service.OnPlayerEventListener;
import com.from206.cloudmusic.service.PlayService;
import com.from206.cloudmusic.utils.HttpCode;
import com.from206.cloudmusic.utils.Preferences;
import com.from206.cloudmusic.utils.TimeUtil;
import com.from206.cloudmusic.view.CommonHeaderView;
import com.from206.cloudmusic.view.lric.LrcView;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;
import static com.from206.cloudmusic.AppCache.getPlayService;

/**
 * 音乐播放页面
 * Created by 75232 on 2019/1/28
 * Email：752323877@qq.com
 */
public class MusicActivity extends LoadingBaseActivity<MusicPresenterImpl> implements MusicPresenter.View, OnPlayerEventListener, SeekBar.OnSeekBarChangeListener, LrcView.OnPlayClickListener, LrcView.OnClickListener {
//    private PlayListDetailResult.PlaylistBean.TracksBean musicBean;
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
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.rl_music_tab_1)
    RelativeLayout rlMusicTab1;
    @BindView(R.id.rl_music_tab_2)
    RelativeLayout rlMusicTab2;
    @BindView(R.id.iv_mast)
    ImageView ivMast;
    @BindView(R.id.iv_play_mode)
    ImageView ivPlayMode;
    @BindView(R.id.lrc_view)
    LrcView lrcView;
    private ServiceConnection mPlayServiceConnection;
    private Music music = new Music();
    private boolean isDraggingProgress;
    private int mLastProgress;
    /**
     * 圆盘旋转动画
     */
    private ObjectAnimator discAnimation;
    /**
     * 唱针旋转动画
     */
    private ObjectAnimator mastRightAnimation;
    /**
     * 唱针旋转动画
     */
    private ObjectAnimator mastLeftAnimation;
    private static final String TAG = "MusicActivity";
    /**
     * 正在播放的音乐ID
     */
    private long mPlayingMusicId;



    @Override
    public void fetchData() {
        checkService();
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
            },500);
        }else {
            AppCache.getPlayService().setOnPlayEventListener(MusicActivity.this);
            initData();
        }
    }
    /**
     * 启动服务
     */
    private void startService() {
        Intent intent = new Intent(this, PlayService.class);
        startService(intent);
    }

    /**
     * 绑定服务
     */
    private void bindService() {
        Intent intent = new Intent();
        intent.setClass(this, PlayService.class);
        mPlayServiceConnection = new PlayServiceConnection();
        bindService(intent, mPlayServiceConnection, Context.BIND_AUTO_CREATE);
    }

    /**
     * 请求数据
     */
    private void initData(){
        if (!getPlayService().isIdle() && getPlayService().getPlayingMusic().getId() == music.getId()) {//同一首歌
            onChangeImpl(getPlayService().getPlayingMusic());
        } else {
            getPlayService().stop();
            mPresenter.fetchMusicUrl(String.valueOf(music.getId()));
        }
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        if( mPlayServiceConnection != null){
            unbindService(mPlayServiceConnection);
        }
    }

    @Override
    protected void initViews() {

        music = (Music) getIntent().getSerializableExtra("music");
        initAni();
        mastRightAnimation.start();
        mastRightAnimation.setDuration(500);
        initUI();
        changePlayMode(false);
        initListener();
        lrcView.setOnPlayClickListener(this);
        lrcView.setLrcViewClickListener(this);


    }
    /**
     * 初始化动画
     */
    private void initAni() {
        discAnimation = ObjectAnimator.ofFloat(ivCover, "rotation", 0f, 360f);
        discAnimation.setDuration(20000);//设置转一圈需要的时间
        discAnimation.setInterpolator(new LinearInterpolator() );//设置插速器
        discAnimation.setRepeatCount(-1);//设置重复次数
        discAnimation.setRepeatMode(ValueAnimator.RESTART);//设置旋转重复模式


        mastRightAnimation = ObjectAnimator.ofFloat(ivMast,"rotation",0f,-18f);
        mastRightAnimation.setDuration(1);//设置转一圈需要的时间
        ivMast.setPivotX(DensityUtil.dp2px(16));//设置指定旋转中心点X坐标
        ivMast.setPivotY(DensityUtil.dp2px(16));//设置指定旋转中心点Y坐标
        mastRightAnimation.setRepeatCount(Animation.ABSOLUTE);//设置重复次数


        mastLeftAnimation = ObjectAnimator.ofFloat(ivMast,"rotation",-18f,0f);
        mastLeftAnimation.setDuration(500);//设置转一圈需要的时间
        mastLeftAnimation.setRepeatCount(Animation.ABSOLUTE);//设置重复次数
    }
    /**
     * 初始化一些监听事件
     */
    private void initListener() {
        mSeekBar.setOnSeekBarChangeListener(this);
    }




    /**
     * 初始化UI
     */
    private void initUI() {
        headerView.setTitle(music.getName());
        Glide.with(mContext).load(music.getPicUrl()).into(ivCover);
        //虚化背景图片
        Glide.with(this).load(music.getPicUrl())
                .apply(bitmapTransform(new BlurTransformation(2,99)))
                .into(ivBg);
    }
    /**
     * 初始化UI
     */
    private void initUI(Music music) {
        headerView.setTitle(music.getName());
        Glide.with(mContext).load(music.getPicUrl()).into(ivCover);
        //虚化背景图片
        Glide.with(this).load(music.getPicUrl())
                .apply(bitmapTransform(new BlurTransformation(2,99)))
                .into(ivBg);
    }





    @Override
    public void setState(int state, String msg) {

    }

    @Override
    public void loadMusicUrl(MusicUrlResult result) {
        if(result.getCode() == HttpCode.SUCCESS){
            if(result.getData().get(0).getCode() == HttpCode.NOT_FOUND){
                ToastUtils.showShort("资源找不到");
                this.finish();
                return;
            }
            music.setPath( result.getData().get(0).getUrl());
            tvPlay.performClick();
        }

    }

    /**
     * 获取歌词回调
     * @param result
     */
    @Override
    public void loadLyric(LyricResult result) {
        if(result.getCode() == 200 && null != result.getLrc() && !TextUtils.isEmpty(result.getLrc().getLyric())){
            ToastUtils.showShort("获取到歌词");
            lrcView.loadLrc(result.getLrc().getLyric());
//            lrcView.loadTlLrc(result.getTlyric().getLyric());
        }else {
            ToastUtils.showShort("未获取到歌词");
        }

    }

    @OnClick({R.id.iv_back,R.id.tv_play,R.id.tv_next,R.id.tv_previous,R.id.iv_music_comment,
            R.id.rl_music_tab_1,R.id.rl_music_tab_2,R.id.iv_play_mode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_play_mode:
                changePlayMode(true);
                break;
            case R.id.rl_music_tab_1:
                rlMusicTab1.setVisibility(View.GONE);
                rlMusicTab2.setVisibility(View.VISIBLE);
                break;
            case R.id.rl_music_tab_2:
                rlMusicTab1.setVisibility(View.VISIBLE);
                rlMusicTab2.setVisibility(View.GONE);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_play:
                if(getPlayService().isPausing()|| getPlayService().isPlaying()){
                    AppCache.getPlayService().playPause();
                }else {
                    AppCache.getPlayService().play(music);
                    mPlayingMusicId = music.getId();
                }
                break;
            case R.id.tv_next:
                getPlayService().next();
                break;
            case R.id.tv_previous:
                getPlayService().prev();
                break;
                //评论
            case R.id.iv_music_comment:
                Intent intent = new Intent(mContext,MusicCommentActivity.class);
                intent.putExtra("music",getPlayService().getPlayingMusic());
                startActivity(intent);
                break;
        }
    }

    /**
     * 修改播放模式
     */
    private void changePlayMode(boolean flag) {
        int mode = Preferences.getPlayMode();
        if(flag){
            mode = mode < 2?mode+1:0;
            Preferences.savePlayMode(mode);
        }
        switch (mode){
            case 0:
                ivPlayMode.setBackground(getDrawable(R.drawable.selector_music_loop_all));
                if(flag){
                    ToastUtils.showShort("列表循环");
                }
                break;
            case 1:
                ivPlayMode.setBackground(getDrawable(R.drawable.selector_music_loop_random));
                if(flag){
                    ToastUtils.showShort("随机播放");
                }
                break;
            case 2:
                ivPlayMode.setBackground(getDrawable(R.drawable.selector_music_loop_single));
                if(flag){
                    ToastUtils.showShort("单曲循环");
                }
                break;
        }

    }

    @Override
    public void onChange(Music music) {
        //获取歌词
        mPresenter.fetchLyric(String.valueOf(music.getId()));
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
        tvTotalTime.setText(TimeUtil.duration2Time((int)getPlayService().getDuration()));
        mSeekBar.setMax((int) getPlayService().getDuration());
        mSeekBar.setProgress((int) getPlayService().getCurrentPosition());
        tvCurrentTime.setText(TimeUtil.duration2Time(mSeekBar.getProgress()));
        if (getPlayService().isPlaying() || getPlayService().isPreparing()) {
            mLastProgress = (int) getPlayService().getDuration();
            tvPlay.setActivated(true);
            if(getPlayService().isPlaying()){
                startAni();
            }
            initUI(music);
        } else {
            mLastProgress = 0;
            tvPlay.setActivated(false);
        }
    }

    /**
     * 启动动画
     */
    private void startAni(){
        mastLeftAnimation.start();
        if(discAnimation.isRunning()&& !discAnimation.isPaused()){
            return;
        }
        if(discAnimation.isPaused()){
            discAnimation.resume();
        }else {
            discAnimation.start();
        }

    }

    @Override
    public void onPlayerStart() {
        Log.e(TAG, "onPlayerStart: " );
        tvPlay.setActivated(true);
        startAni();


    }

    @Override
    public void onPlayerPause() {
        Log.e(TAG, "onPlayerPause: " );
        tvPlay.setActivated(false);
        discAnimation.pause();
        mastRightAnimation.start();
    }

    @Override
    public void onPublish(int progress) {
        if (!isDraggingProgress) {
            lrcView.updateTime(progress);
            mSeekBar.setProgress(progress);

        }
    }

    @Override
    public void onBufferingUpdate(int percent) {
//        Log.e(TAG, "onBufferingUpdate: "+percent );
//        Log.e(TAG, "onBufferingUpdate: "+mSeekBar.getMax()*(percent/100));
//        mSeekBar.setSecondaryProgress(mSeekBar.getMax()*(percent/100));

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

    @Override
    public boolean onPlayClick(long time) {
        Log.e(TAG, "onPlayClick: "+time );
        getPlayService().seekTo((int) time);

        return false;
    }

    @Override
    public void onClick() {
        rlMusicTab1.setVisibility(View.VISIBLE);
        rlMusicTab2.setVisibility(View.GONE);
    }

    private  class PlayServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("Service", "PlayServiceConnection onServiceConnected: " );
            final PlayService playService = ((PlayService.PlayBinder) service).getService();
            AppCache.setPlayService(playService);
            AppCache.getPlayService().setOnPlayEventListener(MusicActivity.this);
            initData();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("Service", "PlayServiceConnection onServiceDisconnected: " );
        }
    }
    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectMusicActivity(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_music;
    }
}
