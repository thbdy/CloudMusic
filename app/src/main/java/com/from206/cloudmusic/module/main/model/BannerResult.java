package com.from206.cloudmusic.module.main.model;

import java.util.List;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class BannerResult {

    /**
     * banners : [{"imageUrl":"http://p1.music.126.net/vSFxFZ1coCImt9qZ84IBAA==/109951163801068492.jpg","targetId":75222040,"adid":null,"targetType":10,"titleColor":"red","typeTitle":"独家","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"75222040","program":null,"event":null,"video":null,"song":null},{"imageUrl":"http://p1.music.126.net/4ty6ci2WykGV2n_tjh7hkQ==/109951163800698578.jpg","targetId":0,"adid":null,"targetType":3000,"titleColor":"blue","typeTitle":"独家","url":"https://music.163.com/store/newalbum/detail?id=75196576","exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"0","program":null,"event":null,"video":null,"song":null},{"imageUrl":"http://p1.music.126.net/dBYKeMYnyaQqgRrvidbx3w==/109951163801097350.jpg","targetId":75207317,"adid":null,"targetType":10,"titleColor":"red","typeTitle":"新碟首发","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"75207317","program":null,"event":null,"video":null,"song":null},{"imageUrl":"http://p1.music.126.net/qnaUGPosdCMVau9GxdHMBQ==/109951163801108554.jpg","targetId":10850153,"adid":null,"targetType":1004,"titleColor":"red","typeTitle":"独家专访","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"10850153","program":null,"event":null,"video":null,"song":null},{"imageUrl":"http://p1.music.126.net/t-FNL6TwtGpVJJbYsyTEEg==/109951163801113024.jpg","targetId":2289763322,"adid":null,"targetType":1000,"titleColor":"red","typeTitle":"独家","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"2289763322","program":null,"event":null,"video":null,"song":null},{"imageUrl":"http://p1.music.126.net/5xptLVr5SYSbLRi80US7oQ==/109951163800703484.jpg","targetId":1340400140,"adid":null,"targetType":1,"titleColor":"red","typeTitle":"新歌首发","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"1340400140","program":null,"event":null,"video":null,"song":null},{"imageUrl":"http://p1.music.126.net/yxJ9PcGhUC9Ogu0dksrdVw==/109951163801114071.jpg","targetId":1338586215,"adid":null,"targetType":1,"titleColor":"red","typeTitle":"独家","url":null,"exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"1338586215","program":null,"event":null,"video":null,"song":null},{"imageUrl":"http://p1.music.126.net/g_p6iDFOvZushw2KIW0yoQ==/109951163800721493.jpg","targetId":0,"adid":null,"targetType":3000,"titleColor":"blue","typeTitle":"商城","url":"https://music.163.com/m/at/5c3fe74bdaaddf9c8e351f13","exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"0","program":null,"event":null,"video":null,"song":null},{"imageUrl":"http://p1.music.126.net/geRZ-E4I3Q-tHG9zSfbf3A==/109951163800727783.jpg","targetId":0,"adid":null,"targetType":3000,"titleColor":"blue","typeTitle":"活动","url":"https://music.163.com/m/at/5c3c5b84daaddf9c8e351521","exclusive":false,"monitorImpress":null,"monitorClick":null,"monitorType":null,"monitorImpressList":null,"monitorClickList":null,"monitorBlackList":null,"extMonitor":null,"extMonitorInfo":null,"adSource":null,"adLocation":null,"encodeId":"0","program":null,"event":null,"video":null,"song":null}]
     * code : 200
     */

    private int code;
    private List<BannersBean> banners;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public static class BannersBean {
        /**
         * imageUrl : http://p1.music.126.net/vSFxFZ1coCImt9qZ84IBAA==/109951163801068492.jpg
         * targetId : 75222040
         * adid : null
         * targetType : 10
         * titleColor : red
         * typeTitle : 独家
         * url : null
         * exclusive : false
         * monitorImpress : null
         * monitorClick : null
         * monitorType : null
         * monitorImpressList : null
         * monitorClickList : null
         * monitorBlackList : null
         * extMonitor : null
         * extMonitorInfo : null
         * adSource : null
         * adLocation : null
         * encodeId : 75222040
         * program : null
         * event : null
         * video : null
         * song : null
         */

        private String imageUrl;
        private long targetId;
        private Object adid;
        private int targetType;
        private String titleColor;
        private String typeTitle;
        private String url;
        private boolean exclusive;
        private Object monitorImpress;
        private Object monitorClick;
        private Object monitorType;
        private Object monitorImpressList;
        private Object monitorClickList;
        private Object monitorBlackList;
        private Object extMonitor;
        private Object extMonitorInfo;
        private Object adSource;
        private Object adLocation;
        private String encodeId;
        private Object program;
        private Object event;
        private Object video;
        private Object song;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public long getTargetId() {
            return targetId;
        }

        public void setTargetId(long targetId) {
            this.targetId = targetId;
        }

        public Object getAdid() {
            return adid;
        }

        public void setAdid(Object adid) {
            this.adid = adid;
        }

        public int getTargetType() {
            return targetType;
        }

        public void setTargetType(int targetType) {
            this.targetType = targetType;
        }

        public String getTitleColor() {
            return titleColor;
        }

        public void setTitleColor(String titleColor) {
            this.titleColor = titleColor;
        }

        public String getTypeTitle() {
            return typeTitle;
        }

        public void setTypeTitle(String typeTitle) {
            this.typeTitle = typeTitle;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isExclusive() {
            return exclusive;
        }

        public void setExclusive(boolean exclusive) {
            this.exclusive = exclusive;
        }

        public Object getMonitorImpress() {
            return monitorImpress;
        }

        public void setMonitorImpress(Object monitorImpress) {
            this.monitorImpress = monitorImpress;
        }

        public Object getMonitorClick() {
            return monitorClick;
        }

        public void setMonitorClick(Object monitorClick) {
            this.monitorClick = monitorClick;
        }

        public Object getMonitorType() {
            return monitorType;
        }

        public void setMonitorType(Object monitorType) {
            this.monitorType = monitorType;
        }

        public Object getMonitorImpressList() {
            return monitorImpressList;
        }

        public void setMonitorImpressList(Object monitorImpressList) {
            this.monitorImpressList = monitorImpressList;
        }

        public Object getMonitorClickList() {
            return monitorClickList;
        }

        public void setMonitorClickList(Object monitorClickList) {
            this.monitorClickList = monitorClickList;
        }

        public Object getMonitorBlackList() {
            return monitorBlackList;
        }

        public void setMonitorBlackList(Object monitorBlackList) {
            this.monitorBlackList = monitorBlackList;
        }

        public Object getExtMonitor() {
            return extMonitor;
        }

        public void setExtMonitor(Object extMonitor) {
            this.extMonitor = extMonitor;
        }

        public Object getExtMonitorInfo() {
            return extMonitorInfo;
        }

        public void setExtMonitorInfo(Object extMonitorInfo) {
            this.extMonitorInfo = extMonitorInfo;
        }

        public Object getAdSource() {
            return adSource;
        }

        public void setAdSource(Object adSource) {
            this.adSource = adSource;
        }

        public Object getAdLocation() {
            return adLocation;
        }

        public void setAdLocation(Object adLocation) {
            this.adLocation = adLocation;
        }

        public String getEncodeId() {
            return encodeId;
        }

        public void setEncodeId(String encodeId) {
            this.encodeId = encodeId;
        }

        public Object getProgram() {
            return program;
        }

        public void setProgram(Object program) {
            this.program = program;
        }

        public Object getEvent() {
            return event;
        }

        public void setEvent(Object event) {
            this.event = event;
        }

        public Object getVideo() {
            return video;
        }

        public void setVideo(Object video) {
            this.video = video;
        }

        public Object getSong() {
            return song;
        }

        public void setSong(Object song) {
            this.song = song;
        }
    }
}
