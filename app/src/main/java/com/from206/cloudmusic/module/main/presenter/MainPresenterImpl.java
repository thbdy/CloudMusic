package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.main.model.RefreshLoginResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class MainPresenterImpl extends BasePresenter<MainPresenter.View> implements MainPresenter.Presenter {
    private NetService service;

    @Inject
    public MainPresenterImpl(NetService service) {
        this.service = service;
    }

    @Override
    public void fetchRefreshLogin() {
        invoke(service.fetchRefreshLogin(),new Callback<RefreshLoginResult>(){
            @Override
            public void onResponse(RefreshLoginResult data) {
                mView.loadRefreshLogin(data);
            }
        });
    }
}
