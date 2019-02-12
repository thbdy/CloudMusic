package com.from206.cloudmusic.service.event;

/**
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class OnPublishEvent {
    public OnPublishEvent(int desc) {
        this.desc = desc;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    private int desc;
}
