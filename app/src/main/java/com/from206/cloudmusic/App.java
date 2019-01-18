package com.from206.cloudmusic;

import android.app.Application;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class App extends Application {
    private static App instance;
    public static App getApp() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
