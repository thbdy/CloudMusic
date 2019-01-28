package com.from206.cloudmusic.module.music.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 75232 on 2019/1/25
 * Email：752323877@qq.com
 */
public class PlayListDetailResult implements Serializable{

    /**
     * playlist : {"subscribers":[],"subscribed":false,"creator":{"defaultAvatar":false,"province":350000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/Wt_FGs6eguiyPmv1ecB1wg==/6055010534366155.jpg","accountStatus":0,"gender":0,"city":350400,"birthday":612979200000,"userId":12883400,"userType":0,"nickname":"猪八戒之歌-","signature":"","description":"","detailDescription":"","avatarImgId":6055010534366155,"backgroundImgId":2002210674180198,"backgroundUrl":"http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":0,"remarkName":null,"backgroundImgIdStr":"2002210674180198","avatarImgIdStr":"6055010534366155"},"tracks":[{"name":"ハテヌイノチ","id":1325938632,"pst":0,"t":0,"ar":[{"id":16823,"name":"小林未郁","tns":[],"alias":[]}],"alia":[],"pop":75,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":74266971,"name":"ハテヌイノチ","picUrl":"http://p2.music.126.net/glUMQ8zYPFDCggIvalgAxw==/109951163669346856.jpg","tns":[],"pic_str":"109951163669346856","pic":109951163669346850},"dt":298051,"h":{"br":320000,"fid":0,"size":11924419,"vd":-14600},"m":{"br":192000,"fid":0,"size":7154669,"vd":-12000},"l":{"br":128000,"fid":0,"size":4769794,"vd":-10200},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"rtype":0,"rurl":null,"mst":9,"cp":1370829,"mv":0,"publishTime":1542297600007},{"name":"爱啦啦","id":245625,"pst":0,"t":0,"ar":[{"id":7993,"name":"海楠","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"600902000008722610","fee":0,"v":5,"crbt":"2a253d49f1d53ca0baecd7dd5e75c376","cf":"","al":{"id":24565,"name":"爱啦啦","picUrl":"http://p2.music.126.net/xDRjTqGSDfP67wo5giZWFw==/119846767428537.jpg","tns":[],"pic":119846767428537},"dt":175177,"h":{"br":192000,"fid":0,"size":4234265,"vd":-2.93},"m":{"br":160000,"fid":0,"size":3540896,"vd":-2.43},"l":{"br":96000,"fid":0,"size":2139061,"vd":-2.52},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1204992000000}],"trackIds":[{"id":1325938632,"v":5},{"id":230407,"v":22}],"subscribedCount":0,"cloudTrackCount":0,"privacy":0,"trackUpdateTime":1548305184107,"coverImgId":109951163669456350,"newImported":false,"updateTime":1544269112114,"trackCount":198,"commentThreadId":"A_PL_0_10853804","specialType":5,"createTime":1396433768327,"highQuality":false,"userId":12883400,"playCount":349,"coverImgUrl":"http://p2.music.126.net/cseAwz7Z3TVqPJKlJYe3Ng==/109951163669456352.jpg","adType":0,"trackNumberUpdateTime":1544269112114,"ordered":true,"tags":[],"description":null,"status":0,"name":"猪八戒之歌-喜欢的音乐","id":10853804,"shareCount":0,"coverImgId_str":"109951163669456352","commentCount":0}
     * code : 200
     * privileges : [{"id":1325938632,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":320000,"toast":false,"flag":128,"preSell":false},{"id":67381,"fee":0,"payed":0,"st":-200,"pl":0,"dl":0,"sp":0,"cp":0,"subp":0,"cs":false,"maxbr":999000,"fl":0,"toast":false,"flag":128,"preSell":false}]
     */

    private PlaylistBean playlist;
    private int code;
    private List<PrivilegesBean> privileges;

    public PlaylistBean getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistBean playlist) {
        this.playlist = playlist;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<PrivilegesBean> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegesBean> privileges) {
        this.privileges = privileges;
    }

    public static class PlaylistBean implements Serializable{
        /**
         * subscribers : []
         * subscribed : false
         * creator : {"defaultAvatar":false,"province":350000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/Wt_FGs6eguiyPmv1ecB1wg==/6055010534366155.jpg","accountStatus":0,"gender":0,"city":350400,"birthday":612979200000,"userId":12883400,"userType":0,"nickname":"猪八戒之歌-","signature":"","description":"","detailDescription":"","avatarImgId":6055010534366155,"backgroundImgId":2002210674180198,"backgroundUrl":"http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":10,"vipType":0,"remarkName":null,"backgroundImgIdStr":"2002210674180198","avatarImgIdStr":"6055010534366155"}
         * tracks : [{"name":"ハテヌイノチ","id":1325938632,"pst":0,"t":0,"ar":[{"id":16823,"name":"小林未郁","tns":[],"alias":[]}],"alia":[],"pop":75,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":74266971,"name":"ハテヌイノチ","picUrl":"http://p2.music.126.net/glUMQ8zYPFDCggIvalgAxw==/109951163669346856.jpg","tns":[],"pic_str":"109951163669346856","pic":109951163669346850},"dt":298051,"h":{"br":320000,"fid":0,"size":11924419,"vd":-14600},"m":{"br":192000,"fid":0,"size":7154669,"vd":-12000},"l":{"br":128000,"fid":0,"size":4769794,"vd":-10200},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"rtype":0,"rurl":null,"mst":9,"cp":1370829,"mv":0,"publishTime":1542297600007},{"name":"爱啦啦","id":245625,"pst":0,"t":0,"ar":[{"id":7993,"name":"海楠","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"600902000008722610","fee":0,"v":5,"crbt":"2a253d49f1d53ca0baecd7dd5e75c376","cf":"","al":{"id":24565,"name":"爱啦啦","picUrl":"http://p2.music.126.net/xDRjTqGSDfP67wo5giZWFw==/119846767428537.jpg","tns":[],"pic":119846767428537},"dt":175177,"h":{"br":192000,"fid":0,"size":4234265,"vd":-2.93},"m":{"br":160000,"fid":0,"size":3540896,"vd":-2.43},"l":{"br":96000,"fid":0,"size":2139061,"vd":-2.52},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1204992000000}]
         * trackIds : [{"id":1325938632,"v":5},{"id":230407,"v":22}]
         * subscribedCount : 0
         * cloudTrackCount : 0
         * privacy : 0
         * trackUpdateTime : 1548305184107
         * coverImgId : 109951163669456350
         * newImported : false
         * updateTime : 1544269112114
         * trackCount : 198
         * commentThreadId : A_PL_0_10853804
         * specialType : 5
         * createTime : 1396433768327
         * highQuality : false
         * userId : 12883400
         * playCount : 349
         * coverImgUrl : http://p2.music.126.net/cseAwz7Z3TVqPJKlJYe3Ng==/109951163669456352.jpg
         * adType : 0
         * trackNumberUpdateTime : 1544269112114
         * ordered : true
         * tags : []
         * description : null
         * status : 0
         * name : 猪八戒之歌-喜欢的音乐
         * id : 10853804
         * shareCount : 0
         * coverImgId_str : 109951163669456352
         * commentCount : 0
         */

        private boolean subscribed;
        private CreatorBean creator;
        private int subscribedCount;
        private int cloudTrackCount;
        private int privacy;
        private long trackUpdateTime;
        private long coverImgId;
        private boolean newImported;
        private long updateTime;
        private int trackCount;
        private String commentThreadId;
        private int specialType;
        private long createTime;
        private boolean highQuality;
        private int userId;
        private int playCount;
        private String coverImgUrl;
        private int adType;
        private long trackNumberUpdateTime;
        private boolean ordered;
        private Object description;
        private int status;
        private String name;
        private long id;
        private int shareCount;
        private String coverImgId_str;
        private int commentCount;
        private List<?> subscribers;
        private List<TracksBean> tracks;
        private List<TrackIdsBean> trackIds;
        private List<?> tags;

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public int getCloudTrackCount() {
            return cloudTrackCount;
        }

        public void setCloudTrackCount(int cloudTrackCount) {
            this.cloudTrackCount = cloudTrackCount;
        }

        public int getPrivacy() {
            return privacy;
        }

        public void setPrivacy(int privacy) {
            this.privacy = privacy;
        }

        public long getTrackUpdateTime() {
            return trackUpdateTime;
        }

        public void setTrackUpdateTime(long trackUpdateTime) {
            this.trackUpdateTime = trackUpdateTime;
        }

        public long getCoverImgId() {
            return coverImgId;
        }

        public void setCoverImgId(long coverImgId) {
            this.coverImgId = coverImgId;
        }

        public boolean isNewImported() {
            return newImported;
        }

        public void setNewImported(boolean newImported) {
            this.newImported = newImported;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public int getSpecialType() {
            return specialType;
        }

        public void setSpecialType(int specialType) {
            this.specialType = specialType;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public boolean isOrdered() {
            return ordered;
        }

        public void setOrdered(boolean ordered) {
            this.ordered = ordered;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public String getCoverImgId_str() {
            return coverImgId_str;
        }

        public void setCoverImgId_str(String coverImgId_str) {
            this.coverImgId_str = coverImgId_str;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public List<?> getSubscribers() {
            return subscribers;
        }

        public void setSubscribers(List<?> subscribers) {
            this.subscribers = subscribers;
        }

        public List<TracksBean> getTracks() {
            return tracks;
        }

        public void setTracks(List<TracksBean> tracks) {
            this.tracks = tracks;
        }

        public List<TrackIdsBean> getTrackIds() {
            return trackIds;
        }

        public void setTrackIds(List<TrackIdsBean> trackIds) {
            this.trackIds = trackIds;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public static class CreatorBean implements Serializable{
            /**
             * defaultAvatar : false
             * province : 350000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/Wt_FGs6eguiyPmv1ecB1wg==/6055010534366155.jpg
             * accountStatus : 0
             * gender : 0
             * city : 350400
             * birthday : 612979200000
             * userId : 12883400
             * userType : 0
             * nickname : 猪八戒之歌-
             * signature :
             * description :
             * detailDescription :
             * avatarImgId : 6055010534366155
             * backgroundImgId : 2002210674180198
             * backgroundUrl : http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 10
             * vipType : 0
             * remarkName : null
             * backgroundImgIdStr : 2002210674180198
             * avatarImgIdStr : 6055010534366155
             */

            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private long birthday;
            private int userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private String backgroundImgIdStr;
            private String avatarImgIdStr;

            public boolean isDefaultAvatar() {
                return defaultAvatar;
            }

            public void setDefaultAvatar(boolean defaultAvatar) {
                this.defaultAvatar = defaultAvatar;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public int getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(int accountStatus) {
                this.accountStatus = accountStatus;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetailDescription() {
                return detailDescription;
            }

            public void setDetailDescription(String detailDescription) {
                this.detailDescription = detailDescription;
            }

            public long getAvatarImgId() {
                return avatarImgId;
            }

            public void setAvatarImgId(long avatarImgId) {
                this.avatarImgId = avatarImgId;
            }

            public long getBackgroundImgId() {
                return backgroundImgId;
            }

            public void setBackgroundImgId(long backgroundImgId) {
                this.backgroundImgId = backgroundImgId;
            }

            public String getBackgroundUrl() {
                return backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }

            public int getAuthority() {
                return authority;
            }

            public void setAuthority(int authority) {
                this.authority = authority;
            }

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public Object getExperts() {
                return experts;
            }

            public void setExperts(Object experts) {
                this.experts = experts;
            }

            public int getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(int djStatus) {
                this.djStatus = djStatus;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }
        }

        public static class TracksBean implements Serializable {
            /**
             * name : ハテヌイノチ
             * id : 1325938632
             * pst : 0
             * t : 0
             * ar : [{"id":16823,"name":"小林未郁","tns":[],"alias":[]}]
             * alia : []
             * pop : 75
             * st : 0
             * rt :
             * fee : 0
             * v : 4
             * crbt : null
             * cf :
             * al : {"id":74266971,"name":"ハテヌイノチ","picUrl":"http://p2.music.126.net/glUMQ8zYPFDCggIvalgAxw==/109951163669346856.jpg","tns":[],"pic_str":"109951163669346856","pic":109951163669346850}
             * dt : 298051
             * h : {"br":320000,"fid":0,"size":11924419,"vd":-14600}
             * m : {"br":192000,"fid":0,"size":7154669,"vd":-12000}
             * l : {"br":128000,"fid":0,"size":4769794,"vd":-10200}
             * a : null
             * cd : 1
             * no : 1
             * rtUrl : null
             * ftype : 0
             * rtUrls : []
             * djId : 0
             * copyright : 0
             * s_id : 0
             * rtype : 0
             * rurl : null
             * mst : 9
             * cp : 1370829
             * mv : 0
             * publishTime : 1542297600007
             */

            private String name;
            private long id;
            private int pst;
            private int t;
            private int pop;
            private int st;
            private String rt;
            private int fee;
            private int v;
            private Object crbt;
            private String cf;
            private AlBean al;
            private int dt;
            private HBean h;
            private MBean m;
            private LBean l;
            private Object a;
            private String cd;
            private int no;
            private Object rtUrl;
            private int ftype;
            private int djId;
            private int copyright;
            private int s_id;
            private int rtype;
            private Object rurl;
            private int mst;
            private int cp;
            private int mv;
            private long publishTime;
            private List<ArBean> ar;
            private List<?> alia;
            private List<?> rtUrls;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getPst() {
                return pst;
            }

            public void setPst(int pst) {
                this.pst = pst;
            }

            public int getT() {
                return t;
            }

            public void setT(int t) {
                this.t = t;
            }

            public int getPop() {
                return pop;
            }

            public void setPop(int pop) {
                this.pop = pop;
            }

            public int getSt() {
                return st;
            }

            public void setSt(int st) {
                this.st = st;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public int getV() {
                return v;
            }

            public void setV(int v) {
                this.v = v;
            }

            public Object getCrbt() {
                return crbt;
            }

            public void setCrbt(Object crbt) {
                this.crbt = crbt;
            }

            public String getCf() {
                return cf;
            }

            public void setCf(String cf) {
                this.cf = cf;
            }

            public AlBean getAl() {
                return al;
            }

            public void setAl(AlBean al) {
                this.al = al;
            }

            public int getDt() {
                return dt;
            }

            public void setDt(int dt) {
                this.dt = dt;
            }

            public HBean getH() {
                return h;
            }

            public void setH(HBean h) {
                this.h = h;
            }

            public MBean getM() {
                return m;
            }

            public void setM(MBean m) {
                this.m = m;
            }

            public LBean getL() {
                return l;
            }

            public void setL(LBean l) {
                this.l = l;
            }

            public Object getA() {
                return a;
            }

            public void setA(Object a) {
                this.a = a;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public Object getRtUrl() {
                return rtUrl;
            }

            public void setRtUrl(Object rtUrl) {
                this.rtUrl = rtUrl;
            }

            public int getFtype() {
                return ftype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public int getDjId() {
                return djId;
            }

            public void setDjId(int djId) {
                this.djId = djId;
            }

            public int getCopyright() {
                return copyright;
            }

            public void setCopyright(int copyright) {
                this.copyright = copyright;
            }

            public int getS_id() {
                return s_id;
            }

            public void setS_id(int s_id) {
                this.s_id = s_id;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public Object getRurl() {
                return rurl;
            }

            public void setRurl(Object rurl) {
                this.rurl = rurl;
            }

            public int getMst() {
                return mst;
            }

            public void setMst(int mst) {
                this.mst = mst;
            }

            public int getCp() {
                return cp;
            }

            public void setCp(int cp) {
                this.cp = cp;
            }

            public int getMv() {
                return mv;
            }

            public void setMv(int mv) {
                this.mv = mv;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public List<ArBean> getAr() {
                return ar;
            }

            public void setAr(List<ArBean> ar) {
                this.ar = ar;
            }

            public List<?> getAlia() {
                return alia;
            }

            public void setAlia(List<?> alia) {
                this.alia = alia;
            }

            public List<?> getRtUrls() {
                return rtUrls;
            }

            public void setRtUrls(List<?> rtUrls) {
                this.rtUrls = rtUrls;
            }

            public static class AlBean implements Serializable{
                /**
                 * id : 74266971
                 * name : ハテヌイノチ
                 * picUrl : http://p2.music.126.net/glUMQ8zYPFDCggIvalgAxw==/109951163669346856.jpg
                 * tns : []
                 * pic_str : 109951163669346856
                 * pic : 109951163669346850
                 */

                private long id;
                private String name;
                private String picUrl;
                private String pic_str;
                private long pic;
                private List<?> tns;

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getPic_str() {
                    return pic_str;
                }

                public void setPic_str(String pic_str) {
                    this.pic_str = pic_str;
                }

                public long getPic() {
                    return pic;
                }

                public void setPic(long pic) {
                    this.pic = pic;
                }

                public List<?> getTns() {
                    return tns;
                }

                public void setTns(List<?> tns) {
                    this.tns = tns;
                }
            }

            public static class HBean implements Serializable{
                /**
                 * br : 320000
                 * fid : 0
                 * size : 11924419
                 * vd : -14600
                 */

                private int br;
                private int fid;
                private int size;
                private float vd;

                public int getBr() {
                    return br;
                }

                public void setBr(int br) {
                    this.br = br;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public float getVd() {
                    return vd;
                }

                public void setVd(float vd) {
                    this.vd = vd;
                }
            }

            public static class MBean implements Serializable{
                /**
                 * br : 192000
                 * fid : 0
                 * size : 7154669
                 * vd : -12000
                 */

                private int br;
                private int fid;
                private int size;
                private float vd;

                public int getBr() {
                    return br;
                }

                public void setBr(int br) {
                    this.br = br;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public float getVd() {
                    return vd;
                }

                public void setVd(float vd) {
                    this.vd = vd;
                }
            }

            public static class LBean implements Serializable{
                /**
                 * br : 128000
                 * fid : 0
                 * size : 4769794
                 * vd : -10200
                 */

                private int br;
                private int fid;
                private int size;
                private float vd;

                public int getBr() {
                    return br;
                }

                public void setBr(int br) {
                    this.br = br;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public float getVd() {
                    return vd;
                }

                public void setVd(float vd) {
                    this.vd = vd;
                }
            }

            public static class ArBean implements Serializable{
                /**
                 * id : 16823
                 * name : 小林未郁
                 * tns : []
                 * alias : []
                 */

                private long id;
                private String name;
                private List<?> tns;
                private List<?> alias;

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<?> getTns() {
                    return tns;
                }

                public void setTns(List<?> tns) {
                    this.tns = tns;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }

        public static class TrackIdsBean implements Serializable{
            /**
             * id : 1325938632
             * v : 5
             */

            private long id;
            private int v;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getV() {
                return v;
            }

            public void setV(int v) {
                this.v = v;
            }
        }
    }

    public static class PrivilegesBean implements Serializable{
        /**
         * id : 1325938632
         * fee : 0
         * payed : 0
         * st : 0
         * pl : 320000
         * dl : 320000
         * sp : 7
         * cp : 1
         * subp : 1
         * cs : false
         * maxbr : 999000
         * fl : 320000
         * toast : false
         * flag : 128
         * preSell : false
         */

        private long id;
        private int fee;
        private int payed;
        private int st;
        private int pl;
        private int dl;
        private int sp;
        private int cp;
        private int subp;
        private boolean cs;
        private int maxbr;
        private int fl;
        private boolean toast;
        private int flag;
        private boolean preSell;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public int getPl() {
            return pl;
        }

        public void setPl(int pl) {
            this.pl = pl;
        }

        public int getDl() {
            return dl;
        }

        public void setDl(int dl) {
            this.dl = dl;
        }

        public int getSp() {
            return sp;
        }

        public void setSp(int sp) {
            this.sp = sp;
        }

        public int getCp() {
            return cp;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public int getSubp() {
            return subp;
        }

        public void setSubp(int subp) {
            this.subp = subp;
        }

        public boolean isCs() {
            return cs;
        }

        public void setCs(boolean cs) {
            this.cs = cs;
        }

        public int getMaxbr() {
            return maxbr;
        }

        public void setMaxbr(int maxbr) {
            this.maxbr = maxbr;
        }

        public int getFl() {
            return fl;
        }

        public void setFl(int fl) {
            this.fl = fl;
        }

        public boolean isToast() {
            return toast;
        }

        public void setToast(boolean toast) {
            this.toast = toast;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public boolean isPreSell() {
            return preSell;
        }

        public void setPreSell(boolean preSell) {
            this.preSell = preSell;
        }
    }
}
