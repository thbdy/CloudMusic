package com.from206.cloudmusic.utils;

/**
 * Created by 75232 on 2019/1/28
 * Email：752323877@qq.com
 */
public class TimeUtil {
    /*根据时长格式化称时间文本*/
    public static String duration2Time(int duration) {
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;

        return (min < 10 ? "0" + min : min + "") + ":" + (sec < 10 ? "0" + sec : sec + "");
    }
}
