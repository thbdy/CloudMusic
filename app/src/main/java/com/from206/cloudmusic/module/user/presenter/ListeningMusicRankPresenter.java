package com.from206.cloudmusic.module.user.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.user.model.UserRecordResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface ListeningMusicRankPresenter {
    interface Presenter {
        void fetchUserRecord(String uid,String type);
    }
    interface View extends BaseView {
        void loadUserRecord(UserRecordResult result);
    }
}
