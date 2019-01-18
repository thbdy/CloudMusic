package com.from206.cloudmusic.http.injector.component;


import com.from206.cloudmusic.http.injector.module.NetServiceModule;
import com.from206.cloudmusic.module.login.view.LoginActivity;
import com.from206.cloudmusic.module.main.view.RecommendFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetServiceModule.class})
public interface NetServiceComponent {
    void injectLoginActivity(LoginActivity activity);
    void injectRecommendFragment(RecommendFragment fragment);
}
