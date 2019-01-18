package com.from206.cloudmusic.module.login.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.login.model.LoginResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface LoginPresenter {
    interface Presenter {
        void fetchLogin(String phone,String password);
    }
    interface View extends BaseView {
        void loadLoginInfo(LoginResult result);
    }
}
