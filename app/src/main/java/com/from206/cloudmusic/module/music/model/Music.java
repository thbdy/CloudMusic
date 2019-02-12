package com.from206.cloudmusic.module.music.model;

import java.io.Serializable;

/**
 * Created by 75232 on 2019/1/28
 * Email：752323877@qq.com
 */
public class Music implements Serializable {
    /**
     * 歌曲iD
     */
    private long id;
    /**
     * 地址
     */
    private String path;
    /**
     * 歌曲名
     */
    private String name;
    /**
     * 作者
     */
    private String author;
    /**
     * 封面图片
     */
    private String picUrl;

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
