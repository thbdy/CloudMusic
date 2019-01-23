package com.from206.cloudmusic.module.login.view;

import android.content.Intent;
import android.view.View;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.BaseActivity;

import butterknife.OnClick;

/**
 * Created by 75232 on 2019/1/23
 * Email：752323877@qq.com
 */
public class LoginMainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_main;
    }

    @Override
    protected void initViews() {


    }
    @OnClick({R.id.tv_phone_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_phone_login:
                startActivity(new Intent(mContext,LoginActivity.class));
                overridePendingTransition(0,0);
                break;
        }
    }
}
