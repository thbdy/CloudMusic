package com.from206.cloudmusic.service.event;

/**
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class GetDurationEvent {
    public GetDurationEvent(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int duration;
}
