package com.from206.cloudmusic.http;


import com.from206.cloudmusic.module.login.model.LoginResult;
import com.from206.cloudmusic.module.main.model.BannerResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface NetService {
    String BASE_URL = "http://192.168.1.17:3000/";

    @GET("login/cellphone")
    Observable<LoginResult> fetchLoginInfo(@Query("phone")String phone,
                                           @Query("password")String password);

    //获取首页banner
    @GET("banner")
    Observable<BannerResult> fetchBanner();
}
