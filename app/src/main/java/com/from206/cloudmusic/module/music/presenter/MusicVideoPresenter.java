package com.from206.cloudmusic.module.music.presenter;

import com.from206.cloudmusic.base.BaseView;
import com.from206.cloudmusic.module.music.model.MusicVideoResult;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public interface MusicVideoPresenter {
    interface Presenter {
        void fetchMusicVideo(String id);
    }
    interface View extends BaseView {
        void loadMusicVideo(MusicVideoResult result);
    }
}
