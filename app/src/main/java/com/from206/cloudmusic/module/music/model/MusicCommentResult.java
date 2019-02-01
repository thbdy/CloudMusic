package com.from206.cloudmusic.module.music.model;

import java.util.List;

/**
 * Created by 75232 on 2019/2/1
 * Email：752323877@qq.com
 */
public class MusicCommentResult  {


    public boolean isMusician() {
        return isMusician;
    }

    public void setMusician(boolean musician) {
        isMusician = musician;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isMoreHot() {
        return moreHot;
    }

    public void setMoreHot(boolean moreHot) {
        this.moreHot = moreHot;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public List<?> getTopComments() {
        return topComments;
    }

    public void setTopComments(List<?> topComments) {
        this.topComments = topComments;
    }

    public List<HotCommentsBean> getHotComments() {
        return hotComments;
    }

    public void setHotComments(List<HotCommentsBean> hotComments) {
        this.hotComments = hotComments;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }


    private boolean isMusician;
    private int userId;
    private boolean moreHot;
    private int code;
    private int total;
    private boolean more;
    private java.util.List<?> topComments;
    private java.util.List<HotCommentsBean> hotComments;
    private java.util.List<CommentsBean> comments;

    public static class HotCommentsBean {
        /**
         * user : {"locationInfo":null,"nickname":"凌凌凌凌凌凌","authStatus":0,"avatarUrl":"https://p4.music.126.net/23r7O7kwjX_FiBwLi3FiEA==/3242459793401427.jpg","experts":null,"expertTags":null,"remarkName":null,"userId":38655472,"vipRights":null,"userType":0,"vipType":0}
         * beReplied : []
         * pendantData : null
         * showFloorComment : null
         * status : 0
         * commentLocationType : 0
         * parentCommentId : 0
         * decoration : null
         * repliedMark : false
         * liked : false
         * commentId : 8188895
         * likedCount : 3455
         * time : 1420426038811
         * expressionUrl : null
         * content : 我喜欢网易云这种边听歌边看评论的模式，让我知道懂这首歌的不止我一个
         */

        private UserBean user;
        private Object pendantData;
        private Object showFloorComment;
        private int status;
        private int commentLocationType;
        private int parentCommentId;
        private Object decoration;
        private boolean repliedMark;
        private boolean liked;
        private int commentId;
        private int likedCount;
        private long time;
        private Object expressionUrl;
        private String content;
        private java.util.List<?> beReplied;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public Object getPendantData() {
            return pendantData;
        }

        public void setPendantData(Object pendantData) {
            this.pendantData = pendantData;
        }

        public Object getShowFloorComment() {
            return showFloorComment;
        }

        public void setShowFloorComment(Object showFloorComment) {
            this.showFloorComment = showFloorComment;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getCommentLocationType() {
            return commentLocationType;
        }

        public void setCommentLocationType(int commentLocationType) {
            this.commentLocationType = commentLocationType;
        }

        public int getParentCommentId() {
            return parentCommentId;
        }

        public void setParentCommentId(int parentCommentId) {
            this.parentCommentId = parentCommentId;
        }

        public Object getDecoration() {
            return decoration;
        }

        public void setDecoration(Object decoration) {
            this.decoration = decoration;
        }

        public boolean isRepliedMark() {
            return repliedMark;
        }

        public void setRepliedMark(boolean repliedMark) {
            this.repliedMark = repliedMark;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public int getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(int likedCount) {
            this.likedCount = likedCount;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public Object getExpressionUrl() {
            return expressionUrl;
        }

        public void setExpressionUrl(Object expressionUrl) {
            this.expressionUrl = expressionUrl;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<?> getBeReplied() {
            return beReplied;
        }

        public void setBeReplied(List<?> beReplied) {
            this.beReplied = beReplied;
        }

        public static class UserBean {
            /**
             * locationInfo : null
             * nickname : 凌凌凌凌凌凌
             * authStatus : 0
             * avatarUrl : https://p4.music.126.net/23r7O7kwjX_FiBwLi3FiEA==/3242459793401427.jpg
             * experts : null
             * expertTags : null
             * remarkName : null
             * userId : 38655472
             * vipRights : null
             * userType : 0
             * vipType : 0
             */

            private Object locationInfo;
            private String nickname;
            private int authStatus;
            private String avatarUrl;
            private Object experts;
            private Object expertTags;
            private Object remarkName;
            private int userId;
            private Object vipRights;
            private int userType;
            private int vipType;

            public Object getLocationInfo() {
                return locationInfo;
            }

            public void setLocationInfo(Object locationInfo) {
                this.locationInfo = locationInfo;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public Object getExperts() {
                return experts;
            }

            public void setExperts(Object experts) {
                this.experts = experts;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Object getVipRights() {
                return vipRights;
            }

            public void setVipRights(Object vipRights) {
                this.vipRights = vipRights;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }
        }
    }

    public static class CommentsBean {
        /**
         * user : {"locationInfo":null,"nickname":"凌凌凌凌凌凌","authStatus":0,"avatarUrl":"https://p4.music.126.net/23r7O7kwjX_FiBwLi3FiEA==/3242459793401427.jpg","experts":null,"expertTags":null,"remarkName":null,"userId":38655472,"vipRights":null,"userType":0,"vipType":0}
         * beReplied : []
         * pendantData : null
         * showFloorComment : null
         * status : 0
         * commentLocationType : 0
         * parentCommentId : 0
         * decoration : null
         * repliedMark : false
         * liked : false
         * commentId : 8188895
         * likedCount : 3455
         * time : 1420426038811
         * expressionUrl : null
         * content : 我喜欢网易云这种边听歌边看评论的模式，让我知道懂这首歌的不止我一个
         */

        private UserBean user;
        private Object pendantData;
        private Object showFloorComment;
        private int status;
        private int commentLocationType;
        private int parentCommentId;
        private Object decoration;
        private boolean repliedMark;
        private boolean liked;
        private int commentId;
        private int likedCount;
        private long time;
        private Object expressionUrl;
        private String content;
        private java.util.List<?> beReplied;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public Object getPendantData() {
            return pendantData;
        }

        public void setPendantData(Object pendantData) {
            this.pendantData = pendantData;
        }

        public Object getShowFloorComment() {
            return showFloorComment;
        }

        public void setShowFloorComment(Object showFloorComment) {
            this.showFloorComment = showFloorComment;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getCommentLocationType() {
            return commentLocationType;
        }

        public void setCommentLocationType(int commentLocationType) {
            this.commentLocationType = commentLocationType;
        }

        public int getParentCommentId() {
            return parentCommentId;
        }

        public void setParentCommentId(int parentCommentId) {
            this.parentCommentId = parentCommentId;
        }

        public Object getDecoration() {
            return decoration;
        }

        public void setDecoration(Object decoration) {
            this.decoration = decoration;
        }

        public boolean isRepliedMark() {
            return repliedMark;
        }

        public void setRepliedMark(boolean repliedMark) {
            this.repliedMark = repliedMark;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public int getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(int likedCount) {
            this.likedCount = likedCount;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public Object getExpressionUrl() {
            return expressionUrl;
        }

        public void setExpressionUrl(Object expressionUrl) {
            this.expressionUrl = expressionUrl;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<?> getBeReplied() {
            return beReplied;
        }

        public void setBeReplied(List<?> beReplied) {
            this.beReplied = beReplied;
        }

        public static class UserBean {
            /**
             * locationInfo : null
             * nickname : 凌凌凌凌凌凌
             * authStatus : 0
             * avatarUrl : https://p4.music.126.net/23r7O7kwjX_FiBwLi3FiEA==/3242459793401427.jpg
             * experts : null
             * expertTags : null
             * remarkName : null
             * userId : 38655472
             * vipRights : null
             * userType : 0
             * vipType : 0
             */

            private Object locationInfo;
            private String nickname;
            private int authStatus;
            private String avatarUrl;
            private Object experts;
            private Object expertTags;
            private Object remarkName;
            private int userId;
            private Object vipRights;
            private int userType;
            private int vipType;

            public Object getLocationInfo() {
                return locationInfo;
            }

            public void setLocationInfo(Object locationInfo) {
                this.locationInfo = locationInfo;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public Object getExperts() {
                return experts;
            }

            public void setExperts(Object experts) {
                this.experts = experts;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Object getVipRights() {
                return vipRights;
            }

            public void setVipRights(Object vipRights) {
                this.vipRights = vipRights;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }
        }
    }
}
