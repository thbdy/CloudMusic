package com.from206.cloudmusic.module.login.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;

import com.blankj.utilcode.util.SPUtils;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.BaseActivity;
import com.from206.cloudmusic.module.main.view.MainActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_splash;
    }


    @Override
    protected void initViews() {
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onCompleted() {
                String str = SPUtils.getInstance().getString("personInfo");
                if(!TextUtils.isEmpty(str)){
                    finish();
                    startActivity(new Intent(mContext,MainActivity.class));
                }else {
                    finish();
                    startActivity(new Intent(mContext,LoginActivity.class));
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


}
