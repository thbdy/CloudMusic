package com.from206.cloudmusic.module.music.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.music.model.MusicUrlResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface MusicPresenter {
    interface Presenter {
        void fetchMusicUrl(String id);
    }
    interface View extends BaseView {
        void loadMusicUrl(MusicUrlResult result);
    }
}
