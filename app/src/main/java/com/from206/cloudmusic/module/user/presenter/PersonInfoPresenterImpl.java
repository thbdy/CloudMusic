package com.from206.cloudmusic.module.user.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.user.model.PersonInfoResult;
import com.from206.cloudmusic.module.user.model.UserPlayListResult;
import com.from206.cloudmusic.module.user.model.UserSubCountResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class PersonInfoPresenterImpl extends BasePresenter<PersonInfoPresenter.View> implements PersonInfoPresenter.Presenter {
    private NetService service;

    @Inject
    public PersonInfoPresenterImpl(NetService service) {
        this.service = service;
    }



    @Override
    public void fetchPersonInfo(String uid) {
        invoke(service.fetchPersonInfo(uid),new Callback<PersonInfoResult>(){
            @Override
            public void onResponse(PersonInfoResult data) {
                mView.loadPersonInfo(data);
            }
        });
    }

    @Override
    public void fetchUserSubCount() {
        invoke(service.fetchUserSubCount(),new Callback<UserSubCountResult>(){
            @Override
            public void onResponse(UserSubCountResult data) {
                mView.loadUserSubCount(data);
            }
        });
    }

    @Override
    public void fetchUserPlayList(String uid) {
        invoke(service.fetchUserPlayList(uid),new Callback<UserPlayListResult>(){
            @Override
            public void onResponse(UserPlayListResult data) {
                mView.loadUserPlayList(data);
            }
        });
    }
}
