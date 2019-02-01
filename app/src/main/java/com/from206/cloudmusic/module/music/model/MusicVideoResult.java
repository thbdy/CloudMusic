package com.from206.cloudmusic.module.music.model;

/**
 * Created by 75232 on 2019/2/1
 * Email：752323877@qq.com
 */
public class MusicVideoResult {

    /**
     * code : 200
     * data : {"id":5622072,"url":"http://vodkgeyttp8.vod.126.net/cloudmusic/NCAgYCAzICIlMDEwJDQhMA==/mv/5622072/ef220b5b2aac5a89caad07c781f5048f.mp4?wsSecret=6acbe2e9ba086db15c6ea76664224385&wsTime=1548989676","r":720,"size":66548599,"md5":"","code":200,"expi":3600,"fee":0,"mvFee":0,"st":0,"msg":""}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 5622072
         * url : http://vodkgeyttp8.vod.126.net/cloudmusic/NCAgYCAzICIlMDEwJDQhMA==/mv/5622072/ef220b5b2aac5a89caad07c781f5048f.mp4?wsSecret=6acbe2e9ba086db15c6ea76664224385&wsTime=1548989676
         * r : 720
         * size : 66548599
         * md5 :
         * code : 200
         * expi : 3600
         * fee : 0
         * mvFee : 0
         * st : 0
         * msg :
         */

        private int id;
        private String url;
        private int r;
        private int size;
        private String md5;
        private int code;
        private int expi;
        private int fee;
        private int mvFee;
        private int st;
        private String msg;

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

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
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

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getMvFee() {
            return mvFee;
        }

        public void setMvFee(int mvFee) {
            this.mvFee = mvFee;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
