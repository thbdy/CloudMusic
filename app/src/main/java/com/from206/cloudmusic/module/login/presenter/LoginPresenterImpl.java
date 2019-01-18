package com.from206.cloudmusic.module.login.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.login.model.LoginResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class LoginPresenterImpl extends BasePresenter<LoginPresenter.View> implements LoginPresenter.Presenter {
    private NetService service;

    @Inject
    public LoginPresenterImpl(NetService service) {
        this.service = service;
    }

    @Override
    public void fetchLogin(String phone,String password) {
        invoke(service.fetchLoginInfo(phone, password),new Callback<LoginResult>(){
            @Override
            public void onResponse(LoginResult data) {
                mView.loadLoginInfo(data);
            }
        });
    }
}
