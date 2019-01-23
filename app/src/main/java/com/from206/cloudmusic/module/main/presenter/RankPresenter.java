package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.main.model.RankResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface RankPresenter {
    interface Presenter {
        void fetchRank();
    }
    interface View extends BaseView {
        void loadRankInfo(RankResult result);
    }
}
