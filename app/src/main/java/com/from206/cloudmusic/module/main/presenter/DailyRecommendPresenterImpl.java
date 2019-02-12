package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.main.model.DailyRecommendResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class DailyRecommendPresenterImpl extends BasePresenter<DailyRecommendPresenter.View> implements DailyRecommendPresenter.Presenter {
    private NetService service;

    @Inject
    public DailyRecommendPresenterImpl(NetService service) {
        this.service = service;
    }


    @Override
    public void fetchDailyRecommend() {
        invoke(service.fetchDailyRecommend(),new Callback<DailyRecommendResult>(){
            @Override
            public void onResponse(DailyRecommendResult data) {
                mView.loadDailyRecommend(data);
            }
        });
    }
}
