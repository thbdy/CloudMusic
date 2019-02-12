package com.from206.cloudmusic.utils;

import com.from206.cloudmusic.module.main.model.DailyRecommendResult;
import com.from206.cloudmusic.module.music.model.Music;
import com.from206.cloudmusic.module.music.model.PlayListDetailResult;

/**
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class TypeChangeUtil {


    public static  Music chanToMusicType(PlayListDetailResult.PlaylistBean.TracksBean data){
        Music music = new Music();
        music.setName(data.getName());
        music.setPicUrl(data.getAl().getPicUrl());
        music.setId(data.getId());
        music.setAuthor(data.getAr().get(0).getName());
        return music;
    }

    public static  Music chanToMusicType(DailyRecommendResult.RecommendBean data){
        Music music = new Music();
        music.setName(data.getName());
        music.setPicUrl(data.getAlbum().getPicUrl());
        music.setId(data.getId());
        music.setAuthor(data.getArtists().get(0).getName());
        return music;
    }

}
