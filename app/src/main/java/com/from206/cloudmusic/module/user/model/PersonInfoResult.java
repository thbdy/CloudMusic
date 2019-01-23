package com.from206.cloudmusic.module.user.model;

import java.util.List;

/**
 * Created by 75232 on 2019/1/23
 * Email：752323877@qq.com
 */
public class PersonInfoResult {

    /**
     * level : 8
     * listenSongs : 4064
     * userPoint : {"userId":12883400,"balance":204,"updateTime":1548229801396,"version":10,"status":0,"blockBalance":0}
     * mobileSign : false
     * pcSign : false
     * profile : {"detailDescription":"","followed":false,"backgroundUrl":"http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg","djStatus":10,"userId":12883400,"experts":{},"backgroundImgId":2002210674180198,"userType":0,"province":350000,"defaultAvatar":false,"avatarUrl":"https://p2.music.126.net/Wt_FGs6eguiyPmv1ecB1wg==/6055010534366155.jpg","mutual":false,"remarkName":null,"expertTags":null,"authStatus":0,"vipType":0,"avatarImgId":6055010534366155,"birthday":612979200000,"gender":0,"accountStatus":0,"nickname":"猪八戒之歌-","city":350400,"description":"","avatarImgIdStr":"6055010534366155","backgroundImgIdStr":"2002210674180198","signature":"","authority":0,"artistIdentity":[],"followeds":3,"follows":7,"cCount":0,"blacklist":false,"eventCount":0,"sDJPCount":0,"allSubscribedCount":0,"playlistCount":6,"playlistBeSubscribedCount":0,"sCount":0}
     * peopleCanSeeMyPlayRecord : false
     * bindings : [{"refreshTime":1514187129,"expiresIn":2147483647,"expired":false,"userId":12883400,"tokenJsonStr":null,"url":"","id":6510692411,"type":1}]
     * adValid : true
     * code : 200
     * createTime : 0
     * createDays : 17920
     */

    private int level;
    private int listenSongs;
    private UserPointBean userPoint;
    private boolean mobileSign;
    private boolean pcSign;
    private ProfileBean profile;
    private boolean peopleCanSeeMyPlayRecord;
    private boolean adValid;
    private int code;
    private int createTime;
    private int createDays;
    private List<BindingsBean> bindings;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getListenSongs() {
        return listenSongs;
    }

    public void setListenSongs(int listenSongs) {
        this.listenSongs = listenSongs;
    }

    public UserPointBean getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(UserPointBean userPoint) {
        this.userPoint = userPoint;
    }

    public boolean isMobileSign() {
        return mobileSign;
    }

    public void setMobileSign(boolean mobileSign) {
        this.mobileSign = mobileSign;
    }

    public boolean isPcSign() {
        return pcSign;
    }

    public void setPcSign(boolean pcSign) {
        this.pcSign = pcSign;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public boolean isPeopleCanSeeMyPlayRecord() {
        return peopleCanSeeMyPlayRecord;
    }

    public void setPeopleCanSeeMyPlayRecord(boolean peopleCanSeeMyPlayRecord) {
        this.peopleCanSeeMyPlayRecord = peopleCanSeeMyPlayRecord;
    }

    public boolean isAdValid() {
        return adValid;
    }

    public void setAdValid(boolean adValid) {
        this.adValid = adValid;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getCreateDays() {
        return createDays;
    }

    public void setCreateDays(int createDays) {
        this.createDays = createDays;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    public static class UserPointBean {
        /**
         * userId : 12883400
         * balance : 204
         * updateTime : 1548229801396
         * version : 10
         * status : 0
         * blockBalance : 0
         */

        private int userId;
        private int balance;
        private long updateTime;
        private int version;
        private int status;
        private int blockBalance;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getBlockBalance() {
            return blockBalance;
        }

        public void setBlockBalance(int blockBalance) {
            this.blockBalance = blockBalance;
        }
    }

    public static class ProfileBean {
        /**
         * detailDescription :
         * followed : false
         * backgroundUrl : http://p1.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg
         * djStatus : 10
         * userId : 12883400
         * experts : {}
         * backgroundImgId : 2002210674180198
         * userType : 0
         * province : 350000
         * defaultAvatar : false
         * avatarUrl : https://p2.music.126.net/Wt_FGs6eguiyPmv1ecB1wg==/6055010534366155.jpg
         * mutual : false
         * remarkName : null
         * expertTags : null
         * authStatus : 0
         * vipType : 0
         * avatarImgId : 6055010534366155
         * birthday : 612979200000
         * gender : 0
         * accountStatus : 0
         * nickname : 猪八戒之歌-
         * city : 350400
         * description :
         * avatarImgIdStr : 6055010534366155
         * backgroundImgIdStr : 2002210674180198
         * signature :
         * authority : 0
         * artistIdentity : []
         * followeds : 3
         * follows : 7
         * cCount : 0
         * blacklist : false
         * eventCount : 0
         * sDJPCount : 0
         * allSubscribedCount : 0
         * playlistCount : 6
         * playlistBeSubscribedCount : 0
         * sCount : 0
         */

        private String detailDescription;
        private boolean followed;
        private String backgroundUrl;
        private int djStatus;
        private int userId;
        private ExpertsBean experts;
        private long backgroundImgId;
        private int userType;
        private int province;
        private boolean defaultAvatar;
        private String avatarUrl;
        private boolean mutual;
        private Object remarkName;
        private Object expertTags;
        private int authStatus;
        private int vipType;
        private long avatarImgId;
        private long birthday;
        private int gender;
        private int accountStatus;
        private String nickname;
        private int city;
        private String description;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String signature;
        private int authority;
        private int followeds;
        private int follows;
        private int cCount;
        private boolean blacklist;
        private int eventCount;
        private int sDJPCount;
        private int allSubscribedCount;
        private int playlistCount;
        private int playlistBeSubscribedCount;
        private int sCount;
        private List<?> artistIdentity;

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public ExpertsBean getExperts() {
            return experts;
        }

        public void setExperts(ExpertsBean experts) {
            this.experts = experts;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public int getCCount() {
            return cCount;
        }

        public void setCCount(int cCount) {
            this.cCount = cCount;
        }

        public boolean isBlacklist() {
            return blacklist;
        }

        public void setBlacklist(boolean blacklist) {
            this.blacklist = blacklist;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public int getSDJPCount() {
            return sDJPCount;
        }

        public void setSDJPCount(int sDJPCount) {
            this.sDJPCount = sDJPCount;
        }

        public int getAllSubscribedCount() {
            return allSubscribedCount;
        }

        public void setAllSubscribedCount(int allSubscribedCount) {
            this.allSubscribedCount = allSubscribedCount;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public int getPlaylistBeSubscribedCount() {
            return playlistBeSubscribedCount;
        }

        public void setPlaylistBeSubscribedCount(int playlistBeSubscribedCount) {
            this.playlistBeSubscribedCount = playlistBeSubscribedCount;
        }

        public int getSCount() {
            return sCount;
        }

        public void setSCount(int sCount) {
            this.sCount = sCount;
        }

        public List<?> getArtistIdentity() {
            return artistIdentity;
        }

        public void setArtistIdentity(List<?> artistIdentity) {
            this.artistIdentity = artistIdentity;
        }

        public static class ExpertsBean {
        }
    }

    public static class BindingsBean {
        /**
         * refreshTime : 1514187129
         * expiresIn : 2147483647
         * expired : false
         * userId : 12883400
         * tokenJsonStr : null
         * url :
         * id : 6510692411
         * type : 1
         */

        private int refreshTime;
        private int expiresIn;
        private boolean expired;
        private int userId;
        private Object tokenJsonStr;
        private String url;
        private long id;
        private int type;

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(Object tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
