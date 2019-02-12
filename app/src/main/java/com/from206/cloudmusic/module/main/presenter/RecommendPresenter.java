package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.main.model.BannerResult;
import com.from206.cloudmusic.module.main.model.DJProgramResult;
import com.from206.cloudmusic.module.main.model.RecommendResourceResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface RecommendPresenter {
    interface Presenter {
        void fetchBanner();
        void fetchRecommendResource();
        void fetchDJProgram();
    }
    interface View extends BaseView {
        void loadBannerInfo(BannerResult result);
        void loadRecommendResource(RecommendResourceResult recommendResourceResult);
        void loadDJProgram(DJProgramResult result);
    }
}
