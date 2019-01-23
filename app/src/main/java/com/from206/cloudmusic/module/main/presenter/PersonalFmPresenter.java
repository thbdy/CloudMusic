package com.from206.cloudmusic.module.main.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.main.model.PersonalFmResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface PersonalFmPresenter {
    interface Presenter {
        void fetchPersonalFm();
    }
    interface View extends BaseView {
        void loadPersonalFm(PersonalFmResult result);
    }
}
