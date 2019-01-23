package com.from206.cloudmusic.module.user.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.user.model.PersonInfoResult;
import com.from206.cloudmusic.module.user.model.UserPlayListResult;
import com.from206.cloudmusic.module.user.model.UserSubCountResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface PersonInfoPresenter {
    interface Presenter {
        void fetchPersonInfo(String uid);
        void fetchUserSubCount();
        void fetchUserPlayList(String uid);
    }
    interface View extends BaseView {
        void loadPersonInfo(PersonInfoResult result);
        void loadUserSubCount(UserSubCountResult result);
        void loadUserPlayList(UserPlayListResult result);
    }
}
