package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BasePresenter;
import com.from206.cloudmusic.http.NetService;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.module.main.model.BannerResult;

import javax.inject.Inject;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class RankPresenterImpl extends BasePresenter<RecommendPresenter.View> implements RecommendPresenter.Presenter {
    private NetService service;

    @Inject
    public RankPresenterImpl(NetService service) {
        this.service = service;
    }
    @Override
    public void fetchBanner() {
        invoke(service.fetchBanner(),new Callback<BannerResult>(){
            @Override
            public void onResponse(BannerResult data) {
                mView.loadBannerInfo(data);
            }
        });
    }
}
