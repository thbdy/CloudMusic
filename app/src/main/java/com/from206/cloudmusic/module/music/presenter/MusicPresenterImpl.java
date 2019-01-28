package com.from206.cloudmusic.module.music.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.music.model.MusicUrlResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class MusicPresenterImpl extends BasePresenter<MusicPresenter.View> implements MusicPresenter.Presenter {
    private NetService service;

    @Inject
    public MusicPresenterImpl(NetService service) {
        this.service = service;
    }

    @Override
    public void fetchMusicUrl(String id) {
        invoke(service.fetchMusicUrl(id),new Callback<MusicUrlResult>(){
            @Override
            public void onResponse(MusicUrlResult data) {
                mView.loadMusicUrl(data);
            }
        });
    }
}
