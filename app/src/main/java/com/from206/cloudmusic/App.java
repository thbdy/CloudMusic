package com.from206.cloudmusic;

import android.app.Application;

import com.from206.cloudmusic.utils.SaveCookiesUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class App extends Application {
    public void clearCookies() {
        cookieList.clear();
    }

    private static final List<Cookie> cookieList = new ArrayList<>();
    private static App instance;
    public static App getApp() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppCache.init(this);
    }

    /**
     * 存储cookie
     *
     * @param cookies
     */
    public void saveCookie(List<Cookie> cookies) {
//        synchronized (cookieList) {
            for (int i = 0; i < cookies.size(); i++) {
                for (int k = 0; k < cookieList.size(); k++) {
                    if (cookieList.get(k).name().equals(cookies.get(i).name())) {
                        cookieList.remove(k);
                    }
                }
            }
//            for(Cookie cookie:cookies){
//                Log.e(TAG, "saveCookie: "+cookie.toString());
//            }
            cookieList.addAll(cookies);
            for (Cookie cookie : cookieList) {
                SaveCookiesUtils.put(this, cookie.name(), new Gson().toJson(cookie));
            }
//        }
    }


    /**
     * 获取cookie
     *
     * @return
     */
    public List<Cookie> getCookie() {
//        synchronized (cookieList){
            if ( cookieList.size() <= 0) {
                Map<String, ?> cookies = SaveCookiesUtils.getAll(this);
                for (Object o : cookies.entrySet()) {
                    Map.Entry entry = (Map.Entry) o;
                    String val = (String) entry.getValue();
                    cookieList.add(new Gson().fromJson(val, Cookie.class));
                }
            }
//            for(Cookie cookie: cookieList){
//                Log.e(TAG, "getCookie: "+cookie.toString());
//            }
            return cookieList;
//        }
    }
}
