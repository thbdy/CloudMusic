package com.from206.cloudmusic.module.user.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class ListeningMusicRankPresenterImpl extends BasePresenter<ListeningMusicRankPresenter.View> implements ListeningMusicRankPresenter.Presenter {
    private NetService service;

    @Inject
    public ListeningMusicRankPresenterImpl(NetService service) {
        this.service = service;
    }



    @Override
    public void fetchUserRecord(String uid, String type) {

    }
}
