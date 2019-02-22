package com.from206.cloudmusic.http.injector.component;


import com.from206.cloudmusic.http.injector.module.NetServiceModule;
import com.from206.cloudmusic.module.login.view.LoginActivity;
import com.from206.cloudmusic.module.main.view.DailyRecommendActivity;
import com.from206.cloudmusic.module.main.view.MainActivity;
import com.from206.cloudmusic.module.main.view.PersonalFmActivity;
import com.from206.cloudmusic.module.main.view.RankActivity;
import com.from206.cloudmusic.module.main.view.RecommendFragment;
import com.from206.cloudmusic.module.main.view.SearchActivity;
import com.from206.cloudmusic.module.main.view.SearchTypeFragment;
import com.from206.cloudmusic.module.music.view.MusicActivity;
import com.from206.cloudmusic.module.music.view.MusicCommentActivity;
import com.from206.cloudmusic.module.music.view.MusicVideoActivity;
import com.from206.cloudmusic.module.music.view.SongSheetActivity;
import com.from206.cloudmusic.module.user.view.ListeningMusicRankActivity;
import com.from206.cloudmusic.module.user.view.PersonInfoActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetServiceModule.class})
public interface NetServiceComponent {
    void injectMainActivity(MainActivity activity);
    void injectLoginActivity(LoginActivity activity);
    void injectRecommendFragment(RecommendFragment fragment);
    void injectRankActivity(RankActivity activity);
    void injectPersonalFmActivity(PersonalFmActivity activity);
    void injectPersonInfoActivity(PersonInfoActivity activity);
    void injectSongSheetActivity(SongSheetActivity activity);
    void injectMusicActivity(MusicActivity activity);
    void injectMusicVideoActivity(MusicVideoActivity activity);
    void injectMusicCommentActivity(MusicCommentActivity activity);
    void injectDailyRecommendActivity(DailyRecommendActivity activity);
    void injectListeningMusicRankActivity(ListeningMusicRankActivity activity);
    void injectSearchActivity(SearchActivity activity);
    void injectSearchTypeFragment(SearchTypeFragment activity);
}
