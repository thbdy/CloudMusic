package com.from206.cloudmusic.module.login.view;

import android.view.WindowManager;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.BaseActivity;

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

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
