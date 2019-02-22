package com.from206.cloudmusic.module.music.model;

/**
 * Created by 75232 on 2019/2/13
 * Email：752323877@qq.com
 */
public class LyricResult {

    /**
     * sgc : false
     * sfy : false
     * qfy : false
     * lrc : {"version":5,"lyric":"[00:00.00] 作曲 : G.E.M. 邓紫棋/Lupo Groinig\n[00:01.00] 作词 : G.E.M. 邓紫棋\n[00:07.210]编曲：Lupo Groinig\n[00:08.820]\n[00:12.240]还没到的樱花季  还没用的照相机\n[00:17.480]还没光临的餐厅  还在期待  有着你的旅行\n[00:23.240]等待日落的巴黎  铁塔之下牵着你\n[00:29.580]等待说着我愿意  等待未来  每天身边有你\n[00:35.100]一点一滴每一天珍惜\n[00:39.220]怕突然来不及  好好的爱你\n[00:45.150]时针一直倒数着  我们剩下的快乐\n[00:50.700]此刻相拥的狂热  却永远都深刻\n[00:56.700]心跳一直倒数着  生命剩下的温热\n[01:02.440]至少用力地爱着  还乌黑的头发  有你就不怕白了\n[01:10.690]漆黑过后是旭日  泪流以后是坚持\n[01:16.320]真的爱是日复日  从不放弃  重复说你愿意\n[01:21.750]还没退化的眼睛  抓紧时间看看你\n[01:28.090]爱是从来不止息  一个风景  每天新的生命\n[01:33.810]一点一滴每一天珍惜\n[01:37.720]用尽每一口气  好好的爱你\n[01:43.690]时针一直倒数着  我们剩下的快乐\n[01:49.420]此刻相拥的狂热  却永远都深刻\n[01:55.060]心跳一直倒数着  生命剩下的温热\n[02:01.100]至少用力地爱着  还乌黑的头发  有你就不怕白了\n[02:09.760]咖啡再不喝就酸了  晚餐再不吃就冷了\n[02:15.440]爱着为什么不说呢  难道错过了才来后悔着\n[02:21.020]谁梦未实现就醒了  谁心没开过就灰了\n[02:27.180]追逐爱的旅途曲折  就算再曲折为你都值得\n[02:32.350]一点一滴每一天珍惜\n[02:36.170]用尽每一口气  好好的爱你\n[02:42.260]时针一直倒数着  我们剩下的快乐\n[02:47.840]此刻相拥的狂热  却永远都深刻\n[02:53.730]心跳一直倒数着  生命剩下的温热\n[02:59.850]至少痛并快乐着  爱过才算活着  有你别无所求了\n[03:11.120]有你别无所求了  有你别无所求了\n[03:22.410]有你别无所求了  有你别无所求了\n[03:34.020]有你别无所求了\n[03:43.260]\n[03:44.800]监制：Lupo Groinig\n"}
     * klyric : {"version":0,"lyric":null}
     * tlyric : {"version":0,"lyric":null}
     * code : 200
     */

    private boolean sgc;
    private boolean sfy;
    private boolean qfy;
    private LrcBean lrc;
    private KlyricBean klyric;
    private TlyricBean tlyric;
    private int code;

    public boolean isSgc() {
        return sgc;
    }

    public void setSgc(boolean sgc) {
        this.sgc = sgc;
    }

    public boolean isSfy() {
        return sfy;
    }

    public void setSfy(boolean sfy) {
        this.sfy = sfy;
    }

    public boolean isQfy() {
        return qfy;
    }

    public void setQfy(boolean qfy) {
        this.qfy = qfy;
    }

    public LrcBean getLrc() {
        return lrc;
    }

    public void setLrc(LrcBean lrc) {
        this.lrc = lrc;
    }

    public KlyricBean getKlyric() {
        return klyric;
    }

    public void setKlyric(KlyricBean klyric) {
        this.klyric = klyric;
    }

    public TlyricBean getTlyric() {
        return tlyric;
    }

    public void setTlyric(TlyricBean tlyric) {
        this.tlyric = tlyric;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class LrcBean {
        /**
         * version : 5
         * lyric : [00:00.00] 作曲 : G.E.M. 邓紫棋/Lupo Groinig
         [00:01.00] 作词 : G.E.M. 邓紫棋
         [00:07.210]编曲：Lupo Groinig
         [00:08.820]
         [00:12.240]还没到的樱花季  还没用的照相机
         [00:17.480]还没光临的餐厅  还在期待  有着你的旅行
         [00:23.240]等待日落的巴黎  铁塔之下牵着你
         [00:29.580]等待说着我愿意  等待未来  每天身边有你
         [00:35.100]一点一滴每一天珍惜
         [00:39.220]怕突然来不及  好好的爱你
         [00:45.150]时针一直倒数着  我们剩下的快乐
         [00:50.700]此刻相拥的狂热  却永远都深刻
         [00:56.700]心跳一直倒数着  生命剩下的温热
         [01:02.440]至少用力地爱着  还乌黑的头发  有你就不怕白了
         [01:10.690]漆黑过后是旭日  泪流以后是坚持
         [01:16.320]真的爱是日复日  从不放弃  重复说你愿意
         [01:21.750]还没退化的眼睛  抓紧时间看看你
         [01:28.090]爱是从来不止息  一个风景  每天新的生命
         [01:33.810]一点一滴每一天珍惜
         [01:37.720]用尽每一口气  好好的爱你
         [01:43.690]时针一直倒数着  我们剩下的快乐
         [01:49.420]此刻相拥的狂热  却永远都深刻
         [01:55.060]心跳一直倒数着  生命剩下的温热
         [02:01.100]至少用力地爱着  还乌黑的头发  有你就不怕白了
         [02:09.760]咖啡再不喝就酸了  晚餐再不吃就冷了
         [02:15.440]爱着为什么不说呢  难道错过了才来后悔着
         [02:21.020]谁梦未实现就醒了  谁心没开过就灰了
         [02:27.180]追逐爱的旅途曲折  就算再曲折为你都值得
         [02:32.350]一点一滴每一天珍惜
         [02:36.170]用尽每一口气  好好的爱你
         [02:42.260]时针一直倒数着  我们剩下的快乐
         [02:47.840]此刻相拥的狂热  却永远都深刻
         [02:53.730]心跳一直倒数着  生命剩下的温热
         [02:59.850]至少痛并快乐着  爱过才算活着  有你别无所求了
         [03:11.120]有你别无所求了  有你别无所求了
         [03:22.410]有你别无所求了  有你别无所求了
         [03:34.020]有你别无所求了
         [03:43.260]
         [03:44.800]监制：Lupo Groinig

         */

        private int version;
        private String lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
    }

    public static class KlyricBean {
        /**
         * version : 0
         * lyric : null
         */

        private int version;
        private Object lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public Object getLyric() {
            return lyric;
        }

        public void setLyric(Object lyric) {
            this.lyric = lyric;
        }
    }

    public static class TlyricBean {
        /**
         * version : 0
         * lyric : null
         */

        private int version;
        private String lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
    }
}
