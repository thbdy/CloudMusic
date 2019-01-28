package com.from206.cloudmusic.http;


import com.from206.cloudmusic.module.login.model.LoginResult;
import com.from206.cloudmusic.module.main.model.BannerResult;
import com.from206.cloudmusic.module.main.model.PersonalFmResult;
import com.from206.cloudmusic.module.main.model.RankResult;
import com.from206.cloudmusic.module.main.model.RefreshLoginResult;
import com.from206.cloudmusic.module.music.model.MusicUrlResult;
import com.from206.cloudmusic.module.music.model.PlayListDetailResult;
import com.from206.cloudmusic.module.user.model.PersonInfoResult;
import com.from206.cloudmusic.module.user.model.UserPlayListResult;
import com.from206.cloudmusic.module.user.model.UserSubCountResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface NetService {
    String BASE_URL = "http://47.96.92.191:3000/";

    @GET("login/cellphone")
    Observable<LoginResult> fetchLoginInfo(@Query("phone")String phone,
                                           @Query("password")String password);

    //刷新登录
    //说明 : 调用此接口 , 可刷新登录状态
    @GET("login/refresh")
    Observable<RefreshLoginResult> fetchRefreshLogin();

    //获取首页banner
    @GET("banner")
    Observable<BannerResult> fetchBanner();

    //获取榜单详情
    @GET("toplist/detail")
    Observable<RankResult> fetchRank();

    //私人FM
    @GET("personal_fm")
    Observable<PersonalFmResult> fetchPersonalFm();

    //获取用户详情
    // 说明 : 登陆后调用此接口 , 传入用户 id, 可以获取用户详情
    @GET("user/detail")
    Observable<PersonInfoResult> fetchPersonInfo(@Query("uid")String uid);

    //获取用户信息 , 歌单，收藏，mv, dj 数量
    //说明 : 登陆后调用此接口 , 可以获取用户信息
    @GET("user/subcount")
    Observable<UserSubCountResult> fetchUserSubCount();

    //获取用户歌单
    //说明 : 登陆后调用此接口 , 传入用户 id, 可以获取用户歌单
    @GET("user/playlist")
    Observable<UserPlayListResult> fetchUserPlayList(@Query("uid")String uid);

    //获取歌单详情
    @GET("playlist/detail")
    Observable<PlayListDetailResult> fetchPlayListDetail(@Query("id")String id);

    //获取音乐URL
    @GET("song/url")
    Observable<MusicUrlResult> fetchMusicUrl(@Query("id")String id);


}
