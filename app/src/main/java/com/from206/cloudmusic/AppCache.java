package com.from206.cloudmusic;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.from206.cloudmusic.module.music.model.Music;
import com.from206.cloudmusic.service.PlayService;
import com.from206.cloudmusic.utils.Preferences;
import com.from206.cloudmusic.utils.SdCardUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Appche-app管理类
 */
public class AppCache {
    private Context mContext;
    private PlayService mPlayService;
    // 本地歌曲列表
    private final List<Music> mMusicList = new ArrayList<>();
    // 歌单列表
//    private final List<SongListInfo> mSongListInfos = new ArrayList<>();
    private final List<Activity> mActivityStack = new ArrayList<>();
//    private final LongSparseArray<DownloadMusicInfo> mDownloadList = new LongSparseArray<>();

    private AppCache() {
    }

    private static class SingletonHolder {
        private static AppCache sAppCache = new AppCache();
    }

    private static AppCache getInstance() {
        return SingletonHolder.sAppCache;
    }

    public static void init(Application application) {
        getInstance().onInit(application);
    }

    private void onInit(Application application) {
        mContext = application.getApplicationContext();
        Preferences.init(mContext);
        initDir();
//        LogToFile.init(mContext);
//        CoverLoader.getInstance().init(mContext);
        application.registerActivityLifecycleCallbacks(new ActivityLifecycle());
    }

    private void initDir(){
        if (SdCardUtil.checkSdCard()) {
            SdCardUtil.createFileDir(SdCardUtil.FILEDIR);
            SdCardUtil.createFileDir(SdCardUtil.FILEDIR + "/" + SdCardUtil.FILEMUSIC);
            SdCardUtil.createFileDir(SdCardUtil.FILEDIR + "/" + SdCardUtil.FILEIMAGE);
            SdCardUtil.createFileDir(SdCardUtil.FILEDIR + "/" + SdCardUtil.FILECACHE);
            SdCardUtil.createFileDir(SdCardUtil.FILEDIR + "/" + SdCardUtil.FILEUSER + "/icon");
        } else {
            System.out.println("创建文件夹失败SD卡不可用");
        }
    }

    public static Context getContext() {
        return getInstance().mContext;
    }

    public static PlayService getPlayService() {
        return getInstance().mPlayService;
    }

    public static void setPlayService(PlayService service) {
        getInstance().mPlayService = service;
    }

    public static List<Music> getMusicList() {
        return getInstance().mMusicList;
    }



    public static void clearStack() {
        List<Activity> activityStack = getInstance().mActivityStack;
        for (int i = activityStack.size() - 1; i >= 0; i--) {
            Activity activity = activityStack.get(i);
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activityStack.clear();
    }



    private static class ActivityLifecycle implements Application.ActivityLifecycleCallbacks {
        private static final String TAG = "Activity";

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            getInstance().mActivityStack.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
        }

        @Override
        public void onActivityResumed(Activity activity) {
        }

        @Override
        public void onActivityPaused(Activity activity) {
        }

        @Override
        public void onActivityStopped(Activity activity) {
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            getInstance().mActivityStack.remove(activity);
        }
    }

}
