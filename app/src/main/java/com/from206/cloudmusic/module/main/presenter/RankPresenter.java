package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.main.model.BannerResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface RankPresenter {
    interface Presenter {
        void fetchBanner();
    }
    interface View extends BaseView {
        void loadBannerInfo(BannerResult result);
    }
}
