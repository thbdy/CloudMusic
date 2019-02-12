package com.from206.cloudmusic.module.main.model;

import java.util.List;

/**
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class DailyRecommendResult {


    private int code;
    private List<RecommendBean> recommend;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<RecommendBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<RecommendBean> recommend) {
        this.recommend = recommend;
    }

    public static class RecommendBean {
        /**
         * name : 魔鬼中的天使
         * id : 296837
         * position : 6
         * alias : []
         * status : 0
         * fee : 8
         * copyrightId : 677020
         * disc : 1
         * no : 6
         * artists : [{"name":"田馥甄","id":9548,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]
         * album : {"name":"My Love","id":29443,"type":"专辑","size":10,"picId":18956679974613468,"blurPicUrl":"http://p1.music.126.net/W9HqFsgMcjgWjW9SutIvrw==/18956679974613469.jpg","companyId":0,"pic":18956679974613468,"picUrl":"http://p1.music.126.net/W9HqFsgMcjgWjW9SutIvrw==/18956679974613469.jpg","publishTime":1314892800000,"description":"","tags":"","company":"华研国际","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":[],"status":40,"copyrightId":1004,"commentThreadId":"R_AL_3_29443","artists":[{"name":"田馥甄","id":9548,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"subType":"录音室版","transName":null,"picId_str":"18956679974613469"}
         * starred : false
         * popularity : 100
         * score : 100
         * starredNum : 0
         * duration : 238186
         * playedNum : 0
         * dayPlays : 0
         * hearTime : 0
         * ringtone : 600902000009050828
         * crbt : null
         * audition : null
         * copyFrom :
         * commentThreadId : R_SO_4_296837
         * rtUrl : null
         * ftype : 0
         * rtUrls : []
         * copyright : 2
         * transName : null
         * sign : null
         * rtype : 0
         * rurl : null
         * mvid : 5842901
         * bMusic : {"name":null,"id":1426549807,"size":3812249,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":238186,"volumeDelta":-9000}
         * mp3Url : null
         * hMusic : {"name":null,"id":1426549805,"size":9530558,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":320000,"playTime":238186,"volumeDelta":-13500}
         * mMusic : {"name":null,"id":1426549806,"size":5718352,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":192000,"playTime":238186,"volumeDelta":-10800}
         * lMusic : {"name":null,"id":1426549807,"size":3812249,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":238186,"volumeDelta":-9000}
         * reason : 根据你可能喜欢的单曲 我怀念的
         * privilege : {"id":296837,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":4,"preSell":false}
         * alg : itembased
         */

        private String name;
        private long id;
        private int position;
        private int status;
        private int fee;
        private int copyrightId;
        private String disc;
        private int no;
        private AlbumBean album;
        private boolean starred;
        private int popularity;
        private int score;
        private int starredNum;
        private int duration;
        private int playedNum;
        private int dayPlays;
        private int hearTime;
        private String ringtone;
        private Object crbt;
        private Object audition;
        private String copyFrom;
        private String commentThreadId;
        private Object rtUrl;
        private int ftype;
        private int copyright;
        private Object transName;
        private Object sign;
        private int rtype;
        private Object rurl;
        private int mvid;
        private BMusicBean bMusic;
        private Object mp3Url;
        private HMusicBean hMusic;
        private MMusicBean mMusic;
        private LMusicBean lMusic;
        private String reason;
        private PrivilegeBean privilege;
        private String alg;
        private List<?> alias;
        private List<ArtistsBeanX> artists;
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

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getCopyrightId() {
            return copyrightId;
        }

        public void setCopyrightId(int copyrightId) {
            this.copyrightId = copyrightId;
        }

        public String getDisc() {
            return disc;
        }

        public void setDisc(String disc) {
            this.disc = disc;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public AlbumBean getAlbum() {
            return album;
        }

        public void setAlbum(AlbumBean album) {
            this.album = album;
        }

        public boolean isStarred() {
            return starred;
        }

        public void setStarred(boolean starred) {
            this.starred = starred;
        }

        public int getPopularity() {
            return popularity;
        }

        public void setPopularity(int popularity) {
            this.popularity = popularity;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getStarredNum() {
            return starredNum;
        }

        public void setStarredNum(int starredNum) {
            this.starredNum = starredNum;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getPlayedNum() {
            return playedNum;
        }

        public void setPlayedNum(int playedNum) {
            this.playedNum = playedNum;
        }

        public int getDayPlays() {
            return dayPlays;
        }

        public void setDayPlays(int dayPlays) {
            this.dayPlays = dayPlays;
        }

        public int getHearTime() {
            return hearTime;
        }

        public void setHearTime(int hearTime) {
            this.hearTime = hearTime;
        }

        public String getRingtone() {
            return ringtone;
        }

        public void setRingtone(String ringtone) {
            this.ringtone = ringtone;
        }

        public Object getCrbt() {
            return crbt;
        }

        public void setCrbt(Object crbt) {
            this.crbt = crbt;
        }

        public Object getAudition() {
            return audition;
        }

        public void setAudition(Object audition) {
            this.audition = audition;
        }

        public String getCopyFrom() {
            return copyFrom;
        }

        public void setCopyFrom(String copyFrom) {
            this.copyFrom = copyFrom;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
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

        public int getCopyright() {
            return copyright;
        }

        public void setCopyright(int copyright) {
            this.copyright = copyright;
        }

        public Object getTransName() {
            return transName;
        }

        public void setTransName(Object transName) {
            this.transName = transName;
        }

        public Object getSign() {
            return sign;
        }

        public void setSign(Object sign) {
            this.sign = sign;
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

        public int getMvid() {
            return mvid;
        }

        public void setMvid(int mvid) {
            this.mvid = mvid;
        }

        public BMusicBean getBMusic() {
            return bMusic;
        }

        public void setBMusic(BMusicBean bMusic) {
            this.bMusic = bMusic;
        }

        public Object getMp3Url() {
            return mp3Url;
        }

        public void setMp3Url(Object mp3Url) {
            this.mp3Url = mp3Url;
        }

        public HMusicBean getHMusic() {
            return hMusic;
        }

        public void setHMusic(HMusicBean hMusic) {
            this.hMusic = hMusic;
        }

        public MMusicBean getMMusic() {
            return mMusic;
        }

        public void setMMusic(MMusicBean mMusic) {
            this.mMusic = mMusic;
        }

        public LMusicBean getLMusic() {
            return lMusic;
        }

        public void setLMusic(LMusicBean lMusic) {
            this.lMusic = lMusic;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public PrivilegeBean getPrivilege() {
            return privilege;
        }

        public void setPrivilege(PrivilegeBean privilege) {
            this.privilege = privilege;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public List<?> getAlias() {
            return alias;
        }

        public void setAlias(List<?> alias) {
            this.alias = alias;
        }

        public List<ArtistsBeanX> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBeanX> artists) {
            this.artists = artists;
        }

        public List<?> getRtUrls() {
            return rtUrls;
        }

        public void setRtUrls(List<?> rtUrls) {
            this.rtUrls = rtUrls;
        }

        public static class AlbumBean {
            /**
             * name : My Love
             * id : 29443
             * type : 专辑
             * size : 10
             * picId : 18956679974613468
             * blurPicUrl : http://p1.music.126.net/W9HqFsgMcjgWjW9SutIvrw==/18956679974613469.jpg
             * companyId : 0
             * pic : 18956679974613468
             * picUrl : http://p1.music.126.net/W9HqFsgMcjgWjW9SutIvrw==/18956679974613469.jpg
             * publishTime : 1314892800000
             * description :
             * tags :
             * company : 华研国际
             * briefDesc :
             * artist : {"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}
             * songs : []
             * alias : []
             * status : 40
             * copyrightId : 1004
             * commentThreadId : R_AL_3_29443
             * artists : [{"name":"田馥甄","id":9548,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]
             * subType : 录音室版
             * transName : null
             * picId_str : 18956679974613469
             */

            private String name;
            private long id;
            private String type;
            private int size;
            private long picId;
            private String blurPicUrl;
            private int companyId;
            private long pic;
            private String picUrl;
            private long publishTime;
            private String description;
            private String tags;
            private String company;
            private String briefDesc;
            private ArtistBean artist;
            private int status;
            private int copyrightId;
            private String commentThreadId;
            private String subType;
            private Object transName;
            private String picId_str;
            private List<?> songs;
            private List<?> alias;
            private List<ArtistsBean> artists;

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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public String getBlurPicUrl() {
                return blurPicUrl;
            }

            public void setBlurPicUrl(String blurPicUrl) {
                this.blurPicUrl = blurPicUrl;
            }

            public int getCompanyId() {
                return companyId;
            }

            public void setCompanyId(int companyId) {
                this.companyId = companyId;
            }

            public long getPic() {
                return pic;
            }

            public void setPic(long pic) {
                this.pic = pic;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public ArtistBean getArtist() {
                return artist;
            }

            public void setArtist(ArtistBean artist) {
                this.artist = artist;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public String getCommentThreadId() {
                return commentThreadId;
            }

            public void setCommentThreadId(String commentThreadId) {
                this.commentThreadId = commentThreadId;
            }

            public String getSubType() {
                return subType;
            }

            public void setSubType(String subType) {
                this.subType = subType;
            }

            public Object getTransName() {
                return transName;
            }

            public void setTransName(Object transName) {
                this.transName = transName;
            }

            public String getPicId_str() {
                return picId_str;
            }

            public void setPicId_str(String picId_str) {
                this.picId_str = picId_str;
            }

            public List<?> getSongs() {
                return songs;
            }

            public void setSongs(List<?> songs) {
                this.songs = songs;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public List<ArtistsBean> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBean> artists) {
                this.artists = artists;
            }

            public static class ArtistBean {
                /**
                 * name :
                 * id : 0
                 * picId : 0
                 * img1v1Id : 0
                 * briefDesc :
                 * picUrl : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1Url : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * albumSize : 0
                 * alias : []
                 * trans :
                 * musicSize : 0
                 */

                private String name;
                private long id;
                private int picId;
                private int img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private int albumSize;
                private String trans;
                private int musicSize;
                private List<?> alias;

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

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public int getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(int img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }

            public static class ArtistsBean {
                /**
                 * name : 田馥甄
                 * id : 9548
                 * picId : 0
                 * img1v1Id : 0
                 * briefDesc :
                 * picUrl : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1Url : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * albumSize : 0
                 * alias : []
                 * trans :
                 * musicSize : 0
                 */

                private String name;
                private long id;
                private int picId;
                private int img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private int albumSize;
                private String trans;
                private int musicSize;
                private List<?> alias;

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

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public int getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(int img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }

        public static class BMusicBean {
            /**
             * name : null
             * id : 1426549807
             * size : 3812249
             * extension : mp3
             * sr : 44100
             * dfsId : 0
             * bitrate : 128000
             * playTime : 238186
             * volumeDelta : -9000
             */

            private Object name;
            private long id;
            private int size;
            private String extension;
            private int sr;
            private int dfsId;
            private int bitrate;
            private int playTime;
            private float volumeDelta;

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public int getDfsId() {
                return dfsId;
            }

            public void setDfsId(int dfsId) {
                this.dfsId = dfsId;
            }

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public float getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(float volumeDelta) {
                this.volumeDelta = volumeDelta;
            }
        }

        public static class HMusicBean {
            /**
             * name : null
             * id : 1426549805
             * size : 9530558
             * extension : mp3
             * sr : 44100
             * dfsId : 0
             * bitrate : 320000
             * playTime : 238186
             * volumeDelta : -13500
             */

            private Object name;
            private long id;
            private int size;
            private String extension;
            private int sr;
            private int dfsId;
            private int bitrate;
            private int playTime;
            private float volumeDelta;

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public int getDfsId() {
                return dfsId;
            }

            public void setDfsId(int dfsId) {
                this.dfsId = dfsId;
            }

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public float getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(float volumeDelta) {
                this.volumeDelta = volumeDelta;
            }
        }

        public static class MMusicBean {
            /**
             * name : null
             * id : 1426549806
             * size : 5718352
             * extension : mp3
             * sr : 44100
             * dfsId : 0
             * bitrate : 192000
             * playTime : 238186
             * volumeDelta : -10800
             */

            private Object name;
            private long id;
            private int size;
            private String extension;
            private int sr;
            private int dfsId;
            private int bitrate;
            private int playTime;
            private float volumeDelta;

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public int getDfsId() {
                return dfsId;
            }

            public void setDfsId(int dfsId) {
                this.dfsId = dfsId;
            }

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public float getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(float volumeDelta) {
                this.volumeDelta = volumeDelta;
            }
        }

        public static class LMusicBean {
            /**
             * name : null
             * id : 1426549807
             * size : 3812249
             * extension : mp3
             * sr : 44100
             * dfsId : 0
             * bitrate : 128000
             * playTime : 238186
             * volumeDelta : -9000
             */

            private Object name;
            private long id;
            private int size;
            private String extension;
            private int sr;
            private int dfsId;
            private int bitrate;
            private int playTime;
            private float volumeDelta;

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public int getDfsId() {
                return dfsId;
            }

            public void setDfsId(int dfsId) {
                this.dfsId = dfsId;
            }

            public int getBitrate() {
                return bitrate;
            }

            public void setBitrate(int bitrate) {
                this.bitrate = bitrate;
            }

            public int getPlayTime() {
                return playTime;
            }

            public void setPlayTime(int playTime) {
                this.playTime = playTime;
            }

            public float getVolumeDelta() {
                return volumeDelta;
            }

            public void setVolumeDelta(float volumeDelta) {
                this.volumeDelta = volumeDelta;
            }
        }

        public static class PrivilegeBean {
            /**
             * id : 296837
             * fee : 8
             * payed : 0
             * st : 0
             * pl : 128000
             * dl : 0
             * sp : 7
             * cp : 1
             * subp : 1
             * cs : false
             * maxbr : 999000
             * fl : 128000
             * toast : false
             * flag : 4
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

        public static class ArtistsBeanX {
            /**
             * name : 田馥甄
             * id : 9548
             * picId : 0
             * img1v1Id : 0
             * briefDesc :
             * picUrl : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * img1v1Url : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * albumSize : 0
             * alias : []
             * trans :
             * musicSize : 0
             */

            private String name;
            private long id;
            private int picId;
            private int img1v1Id;
            private String briefDesc;
            private String picUrl;
            private String img1v1Url;
            private int albumSize;
            private String trans;
            private int musicSize;
            private List<?> alias;

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

            public int getPicId() {
                return picId;
            }

            public void setPicId(int picId) {
                this.picId = picId;
            }

            public int getImg1v1Id() {
                return img1v1Id;
            }

            public void setImg1v1Id(int img1v1Id) {
                this.img1v1Id = img1v1Id;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public String getTrans() {
                return trans;
            }

            public void setTrans(String trans) {
                this.trans = trans;
            }

            public int getMusicSize() {
                return musicSize;
            }

            public void setMusicSize(int musicSize) {
                this.musicSize = musicSize;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }
    }
}
