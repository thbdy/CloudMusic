package com.from206.cloudmusic.module.music.model;

import java.io.Serializable;

/**
 * 歌单
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class SongSheet implements Serializable {
    /**
     * 创建者名称
     */
    private String createdName;
    /**
     * 歌单名称
     */
    private String name;
    /**
     * 创建者头像
     */
    private String createdIcon;
    /**
     * 歌单封面
     */
    private String picUrl;



    /**
     * 歌单ID
     */
    private long id;








    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedIcon() {
        return createdIcon;
    }

    public void setCreatedIcon(String createdIcon) {
        this.createdIcon = createdIcon;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
