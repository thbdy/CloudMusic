package com.from206.cloudmusic.module.music.model;

import java.util.List;

/**
 * Created by 75232 on 2019/1/28
 * Email：752323877@qq.com
 */
public class MusicUrlResult {

    /**
     * data : [{"id":5052317,"url":"http://m10.music.126.net/20190128121140/a23631ce4b8d14817ba28b92260749cd/ymusic/cda1/9df5/89bc/0bace021859e0e310e6b10b7359e0afc.mp3","br":128000,"size":5125895,"md5":"0bace021859e0e310e6b10b7359e0afc","code":200,"expi":1200,"type":"mp3","gain":-2.68,"fee":8,"uf":null,"payed":0,"flag":4,"canExtend":false,"freeTrialInfo":null}]
     * code : 200
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5052317
         * url : http://m10.music.126.net/20190128121140/a23631ce4b8d14817ba28b92260749cd/ymusic/cda1/9df5/89bc/0bace021859e0e310e6b10b7359e0afc.mp3
         * br : 128000
         * size : 5125895
         * md5 : 0bace021859e0e310e6b10b7359e0afc
         * code : 200
         * expi : 1200
         * type : mp3
         * gain : -2.68
         * fee : 8
         * uf : null
         * payed : 0
         * flag : 4
         * canExtend : false
         * freeTrialInfo : null
         */

        private int id;
        private String url;
        private int br;
        private int size;
        private String md5;
        private int code;
        private int expi;
        private String type;
        private double gain;
        private int fee;
        private Object uf;
        private int payed;
        private int flag;
        private boolean canExtend;
        private Object freeTrialInfo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getBr() {
            return br;
        }

        public void setBr(int br) {
            this.br = br;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getExpi() {
            return expi;
        }

        public void setExpi(int expi) {
            this.expi = expi;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getGain() {
            return gain;
        }

        public void setGain(double gain) {
            this.gain = gain;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public Object getUf() {
            return uf;
        }

        public void setUf(Object uf) {
            this.uf = uf;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public boolean isCanExtend() {
            return canExtend;
        }

        public void setCanExtend(boolean canExtend) {
            this.canExtend = canExtend;
        }

        public Object getFreeTrialInfo() {
            return freeTrialInfo;
        }

        public void setFreeTrialInfo(Object freeTrialInfo) {
            this.freeTrialInfo = freeTrialInfo;
        }
    }
}
