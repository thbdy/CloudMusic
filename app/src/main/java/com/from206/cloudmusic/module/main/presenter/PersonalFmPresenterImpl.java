package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.main.model.PersonalFmResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class PersonalFmPresenterImpl extends BasePresenter<PersonalFmPresenter.View> implements PersonalFmPresenter.Presenter {
    private NetService service;

    @Inject
    public PersonalFmPresenterImpl(NetService service) {
        this.service = service;
    }



    @Override
    public void fetchPersonalFm() {
        invoke(service.fetchPersonalFm(),new Callback<PersonalFmResult>(){
            @Override
            public void onResponse(PersonalFmResult data) {
                mView.loadPersonalFm(data);
            }
        });
    }
}
