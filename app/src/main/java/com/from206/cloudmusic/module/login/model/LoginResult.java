package com.from206.cloudmusic.module.login.model;

import java.util.List;

/**
 * Created by 75232 on 2019/1/18
 * Email：752323877@qq.com
 */
public class LoginResult {


    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    /**
     * loginType : 1
     * code : 200
     * account : {"id":12883400,"userName":"1_13107610605","type":1,"status":0,"whitelistAuthority":0,"createTime":0,"salt":"[B@c7f25ae","tokenVersion":0,"ban":0,"baoyueVersion":1,"donateVersion":0,"vipType":0,"viptypeVersion":1539533573353,"anonimousUser":false}
     * profile : {"avatarImgId":6055010534366155,"city":350400,"province":350000,"nickname":"猪八戒之歌-","birthday":612979200000,"djStatus":10,"detailDescription":"","followed":false,"backgroundImgId":2002210674180198,"userType":0,"experts":{},"mutual":false,"remarkName":null,"expertTags":null,"authStatus":0,"vipType":0,"gender":0,"accountStatus":0,"avatarImgIdStr":"6055010534366155","backgroundImgIdStr":"2002210674180198","backgroundUrl":"https://p2.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg","defaultAvatar":false,"avatarUrl":"https://p1.music.126.net/Wt_FGs6eguiyPmv1ecB1wg==/6055010534366155.jpg","description":"","userId":12883400,"signature":"","authority":0,"followeds":3,"follows":7,"eventCount":0,"playlistCount":6,"playlistBeSubscribedCount":0}
     * bindings : [{"url":"","refreshTime":1514187129,"tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"13107610605\",\"hasPassword\":true}","expiresIn":2147483647,"userId":12883400,"expired":false,"id":6510692411,"type":1},{"url":"","refreshTime":1476257816,"tokenJsonStr":"{\"access_token\":\"7722C852D19DE515259DCB3C25E0EF26\",\"refresh_token\":\"1934310BE554F87AD1CB8CEF59ACE178\",\"openid\":\"54F19E009E6708093035D8ED4E2B8690\",\"nickname\":\"猪八戒之歌\",\"expires_in\":7776000}","expiresIn":7776000,"userId":12883400,"expired":true,"id":2908318013,"type":5},{"url":"","refreshTime":1484648348,"tokenJsonStr":"{\"access_token\":\"n-pbASt-7MOdHLWgYv7AcfUcXmuAzC5CdU_Tm0dDqpl3GgSvK0u3B8UdW5AZh3cCf8UUewNoIrMQ1cxntrWHcWY9H-rkO1K2qz39pw-AUB0\",\"expires_in\":7200,\"refresh_token\":\"DNqZhiKSFhbU2Tq4IJhKBNhFx52816RviIuSVFURhLGAOyhJt3n1wIxrQttoxjTUS4Tvh_CaJ9xIbed2MStZcpai-Glde5iqCrbyVKt455g\",\"openid\":\"o5xcyt-MC4GfFlx1HcsjL1YLIm0g\",\"scope\":\"snsapi_login\",\"unionid\":\"oZoefuHJgIStwLNfVaVLLFxRdUf8\",\"nickname\":\"剑来\"}","expiresIn":7200,"userId":12883400,"expired":true,"id":2963887825,"type":10}]
     */

    private int loginType;
    private int code;
    private AccountBean account;
    private ProfileBean profile;
    private List<BindingsBean> bindings;

    public static class AccountBean {
        /**
         * id : 12883400
         * userName : 1_13107610605
         * type : 1
         * status : 0
         * whitelistAuthority : 0
         * createTime : 0
         * salt : [B@c7f25ae
         * tokenVersion : 0
         * ban : 0
         * baoyueVersion : 1
         * donateVersion : 0
         * vipType : 0
         * viptypeVersion : 1539533573353
         * anonimousUser : false
         */

        private int id;
        private String userName;
        private int type;
        private int status;
        private int whitelistAuthority;
        private int createTime;
        private String salt;
        private int tokenVersion;
        private int ban;
        private int baoyueVersion;
        private int donateVersion;
        private int vipType;
        private long viptypeVersion;
        private boolean anonimousUser;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getBan() {
            return ban;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public long getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(long viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }
    }

    public static class ProfileBean{

        /**
         * avatarImgId : 6055010534366155
         * city : 350400
         * province : 350000
         * nickname : 猪八戒之歌-
         * birthday : 612979200000
         * djStatus : 10
         * detailDescription :
         * followed : false
         * backgroundImgId : 2002210674180198
         * userType : 0
         * experts : {}
         * mutual : false
         * remarkName : null
         * expertTags : null
         * authStatus : 0
         * vipType : 0
         * gender : 0
         * accountStatus : 0
         * avatarImgIdStr : 6055010534366155
         * backgroundImgIdStr : 2002210674180198
         * backgroundUrl : https://p2.music.126.net/i0qi6mibX8gq2SaLF1bYbA==/2002210674180198.jpg
         * defaultAvatar : false
         * avatarUrl : https://p1.music.126.net/Wt_FGs6eguiyPmv1ecB1wg==/6055010534366155.jpg
         * description :
         * userId : 12883400
         * signature :
         * authority : 0
         * followeds : 3
         * follows : 7
         * eventCount : 0
         * playlistCount : 6
         * playlistBeSubscribedCount : 0
         */

        private long avatarImgId;
        private int city;
        private int province;
        private String nickname;
        private long birthday;
        private int djStatus;
        private String detailDescription;
        private boolean followed;
        private long backgroundImgId;
        private int userType;
        private ExpertsBean experts;
        private boolean mutual;
        private Object remarkName;
        private Object expertTags;
        private int authStatus;
        private int vipType;
        private int gender;
        private int accountStatus;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String backgroundUrl;
        private boolean defaultAvatar;
        private String avatarUrl;
        private String description;
        private int userId;
        private String signature;
        private int authority;
        private int followeds;
        private int follows;
        private int eventCount;
        private int playlistCount;
        private int playlistBeSubscribedCount;

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

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

        public ExpertsBean getExperts() {
            return experts;
        }

        public void setExperts(ExpertsBean experts) {
            this.experts = experts;
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

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
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

        public static class ExpertsBean {
        }
    }

    public static class BindingsBean{

        /**
         * url :
         * refreshTime : 1484648348
         * tokenJsonStr : {"access_token":"n-pbASt-7MOdHLWgYv7AcfUcXmuAzC5CdU_Tm0dDqpl3GgSvK0u3B8UdW5AZh3cCf8UUewNoIrMQ1cxntrWHcWY9H-rkO1K2qz39pw-AUB0","expires_in":7200,"refresh_token":"DNqZhiKSFhbU2Tq4IJhKBNhFx52816RviIuSVFURhLGAOyhJt3n1wIxrQttoxjTUS4Tvh_CaJ9xIbed2MStZcpai-Glde5iqCrbyVKt455g","openid":"o5xcyt-MC4GfFlx1HcsjL1YLIm0g","scope":"snsapi_login","unionid":"oZoefuHJgIStwLNfVaVLLFxRdUf8","nickname":"剑来"}
         * expiresIn : 7200
         * userId : 12883400
         * expired : true
         * id : 2963887825
         * type : 10
         */

        private String url;
        private int refreshTime;
        private String tokenJsonStr;
        private int expiresIn;
        private int userId;
        private boolean expired;
        private long id;
        private int type;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
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
