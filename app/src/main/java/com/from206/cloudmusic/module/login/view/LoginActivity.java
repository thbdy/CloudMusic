package com.from206.cloudmusic.module.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.login.model.LoginResult;
import com.from206.cloudmusic.module.login.presenter.LoginPresenter;
import com.from206.cloudmusic.module.login.presenter.LoginPresenterImpl;
import com.from206.cloudmusic.module.main.view.MainActivity;
import com.from206.cloudmusic.utils.PersonInfoUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class LoginActivity extends LoadingBaseActivity<LoginPresenterImpl> implements LoginPresenter.View {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
//    @BindView(R.id.et_phone)
//    EditText etPhone;
//    @BindView(R.id.et_pwd)
//    EditText etPwd;
//    @BindView(R.id.btn_login)
//    Button btnLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.iv_back, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                overridePendingTransition(0, 0);
                break;
            case R.id.btn_login:
                doLogin();
                break;
        }
    }

    /**
     * 登录
     */
    private void doLogin() {
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        mPresenter.fetchLogin(phone,password);


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


    @Override
    public void setState(int state, String msg) {

    }

    /**
     * 登录回调
     * @param result
     */
    @Override
    public void loadLoginInfo(LoginResult result) {
        if(result.getCode() == 200 ){
            PersonInfoUtil.savPersonInfo(result);
            ToastUtils.showShort("登录成功");
            finish();
            startActivity(new Intent(mContext,MainActivity.class));
        }else {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
