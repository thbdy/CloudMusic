package com.from206.cloudmusic.base;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.from206.cloudmusic.AppCache;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.http.LifeSubscription;
import com.from206.cloudmusic.module.login.view.LoginActivity;
import com.from206.cloudmusic.module.music.model.Music;
import com.from206.cloudmusic.module.music.view.MusicActivity;
import com.from206.cloudmusic.service.PlayService;
import com.from206.cloudmusic.service.event.OnChangeEvent;
import com.from206.cloudmusic.service.event.OnPublishEvent;
import com.from206.cloudmusic.service.event.PlayerStartEvent;
import com.from206.cloudmusic.service.event.PlayerStopEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.from206.cloudmusic.AppCache.getPlayService;

public  abstract class BaseActivity extends AppCompatActivity implements LifeSubscription, View.OnClickListener {
    private static final String TAG = "BaseActivity";
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    protected Context mContext;
    protected abstract int getLayoutId();
    /**
     * 根视野
     */
    private FrameLayout mContentContainer;
    /**
     * 浮动视野
     */
    private View mFloatView;
    private ServiceConnection mPlayServiceConnection;
    private TextView tvName;
    private RelativeLayout rlLayout;
    private ImageView ivCover;
    private TextView tvAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        initViews();
        ViewGroup mDecorView = (ViewGroup) getWindow().getDecorView();
        mContentContainer = (FrameLayout) ((ViewGroup) mDecorView.getChildAt(0)).getChildAt(1);
        mFloatView =  LayoutInflater.from(getBaseContext()).inflate(R.layout.layout_media_control_bottom, null);
        bindView(mFloatView);
        EventBus.getDefault().register(this);
    }

    private void bindView(View mFloatView) {
        tvName = mFloatView.findViewById(R.id.tv_name);
        rlLayout = mFloatView.findViewById(R.id.rl_layout);
        ivCover = mFloatView.findViewById(R.id.iv_cover);
        tvAuthor = mFloatView.findViewById(R.id.tv_author);
        rlLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!getPlayService().isIdle() && getPlayService().getPlayingMusic() != null){
                    Intent intent = new Intent(mContext,MusicActivity.class);
                    intent.putExtra("music",getPlayService().getPlayingMusic());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.BOTTOM;
        mFloatView.setLayoutParams(layoutParams);
        mContentContainer.addView(mFloatView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(this.getClass().getSimpleName().equals("MusicActivity")){
            mFloatView.setVisibility(View.GONE);
        }else {
            checkService();
        }
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
            if(!getPlayService().isIdle() && getPlayService().getPlayingMusic() != null){
                EventBus.getDefault().post(new OnChangeEvent(getPlayService().getPlayingMusic()));
                mFloatView.setVisibility(View.VISIBLE);
            }else {
                mFloatView.setVisibility(View.GONE);
            }
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


    protected abstract void initViews();

    private CompositeSubscription mCompositeSubscription;

    //用于添加rx的监听的在onDestroy中记得关闭不然会内存泄漏。
    @Override
    public void bindSubscription(Subscription subscription) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(subscription);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
        if( mPlayServiceConnection != null){
            unbindService(mPlayServiceConnection);
        }
        EventBus.getDefault().unregister(this);

    }

    /**
     * 前往登录页面
     */
    public void goLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }




//    @Override
//    public void onClick(View view) {
//        Log.e(TAG, "onClick: " );
//        switch (view.getId()){
//            case R.id.rl_layout:
//                ToastUtils.showShort("点击了底部");
//                if(!getPlayService().isIdle()){
//                    Intent intent = new Intent(mContext,MusicActivity.class);
//                    intent.putExtra("music",getPlayService().getPlayingMusic());
//                    startActivity(intent);
//                }
//                break;
//        }
//    }

    private  class PlayServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            final PlayService playService = ((PlayService.PlayBinder) service).getService();
            AppCache.setPlayService(playService);
            if(!getPlayService().isIdle() && getPlayService().getPlayingMusic() != null){
                EventBus.getDefault().post(new OnChangeEvent(getPlayService().getPlayingMusic()));
                mFloatView.setVisibility(View.VISIBLE);
            }else {
                mFloatView.setVisibility(View.GONE);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChange(OnChangeEvent onChangeEvent) {
        Music music = onChangeEvent.getMusic();
        tvName.setText(music.getName());
        Glide.with(mContext).load(music.getPicUrl()).into(ivCover);
        tvAuthor.setText(music.getAuthor());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getDUration(OnChangeEvent onChangeEvent) {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void playerStop(PlayerStopEvent event) {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void playerStart(PlayerStartEvent event) {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPublish(OnPublishEvent event) {

    }
}
