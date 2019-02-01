package com.from206.cloudmusic.module.music.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.music.model.MusicVideoResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class MusicVideoPresenterImpl extends BasePresenter<MusicVideoPresenter.View> implements MusicVideoPresenter.Presenter {
    private NetService service;

    @Inject
    public MusicVideoPresenterImpl(NetService service) {
        this.service = service;
    }


    @Override
    public void fetchMusicVideo(String id) {
        invoke(service.fetchMusicVideo(id),new Callback<MusicVideoResult>(){
            @Override
            public void onResponse(MusicVideoResult data) {
                mView.loadMusicVideo(data);
            }
        });
    }
}
