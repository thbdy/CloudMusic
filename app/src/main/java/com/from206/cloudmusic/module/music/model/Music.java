package com.from206.cloudmusic.module.music.model;

/**
 * Created by 75232 on 2019/1/28
 * Email：752323877@qq.com
 */
public class Music {
    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    long id;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    String path;
}
