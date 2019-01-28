package com.from206.cloudmusic.module.music.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.music.model.PlayListDetailResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class SongSheetPresenterImpl extends BasePresenter<SongSheetPresenter.View> implements SongSheetPresenter.Presenter {
    private NetService service;

    @Inject
    public SongSheetPresenterImpl(NetService service) {
        this.service = service;
    }

    @Override
    public void fetchPlayListDetail(String id) {
        invoke(service.fetchPlayListDetail(id),new Callback<PlayListDetailResult>(){
            @Override
            public void onResponse(PlayListDetailResult data) {
                mView.loadPlayListDetail(data);
            }
        });
    }
}
