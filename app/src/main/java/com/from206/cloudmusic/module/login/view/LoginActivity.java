package com.from206.cloudmusic.module.login.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.login.model.LoginResult;
import com.from206.cloudmusic.module.login.presenter.LoginPresenter;
import com.from206.cloudmusic.module.login.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class LoginActivity extends LoadingBaseActivity<LoginPresenterImpl> implements LoginPresenter.View {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }



    @Override
    protected void initViews() {

    }

    @Override
    public void fetchData() {

    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectLoginActivity(this);

    }

    @OnClick({R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mPresenter.fetchLogin("13107610605","111");
                break;
        }
    }

    @Override
    public void setState(String state, String msg) {

    }

    @Override
    public void loadLoginInfo(LoginResult result) {

    }
}
