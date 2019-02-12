package com.from206.cloudmusic.service.event;

import com.from206.cloudmusic.module.music.model.Music;

/**
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class OnChangeEvent {
    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    private Music music;
    public OnChangeEvent(Music music){
        this.music=music;
    }

}
