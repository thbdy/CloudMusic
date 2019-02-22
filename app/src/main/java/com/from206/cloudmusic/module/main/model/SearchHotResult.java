package com.from206.cloudmusic.module.main.model;

import java.util.List;

/**
 * Created by 75232 on 2019/2/21
 * Email：752323877@qq.com
 */
public class SearchHotResult {

    /**
     * code : 200
     * result : {"hots":[{"first":"起风了","second":1,"third":null,"iconType":1},{"first":"蔡徐坤","second":1,"third":null,"iconType":0},{"first":"艾薇儿","second":1,"third":null,"iconType":0},{"first":"A妹新专辑","second":1,"third":null,"iconType":0},{"first":"默读","second":1,"third":null,"iconType":0},{"first":"流浪地球","second":1,"third":null,"iconType":0},{"first":"远东韵律Vava合作新歌","second":1,"third":null,"iconType":0},{"first":"ONE OK ROCK新歌","second":1,"third":null,"iconType":0},{"first":"戳爷六公主合作新歌","second":1,"third":null,"iconType":0},{"first":"RADWIMPS","second":1,"third":null,"iconType":0}]}
     */

    private int code;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private List<HotsBean> hots;

        public List<HotsBean> getHots() {
            return hots;
        }

        public void setHots(List<HotsBean> hots) {
            this.hots = hots;
        }

        public static class HotsBean {
            /**
             * first : 起风了
             * second : 1
             * third : null
             * iconType : 1
             */

            private String first;
            private int second;
            private Object third;
            private int iconType;

            public String getFirst() {
                return first;
            }

            public void setFirst(String first) {
                this.first = first;
            }

            public int getSecond() {
                return second;
            }

            public void setSecond(int second) {
                this.second = second;
            }

            public Object getThird() {
                return third;
            }

            public void setThird(Object third) {
                this.third = third;
            }

            public int getIconType() {
                return iconType;
            }

            public void setIconType(int iconType) {
                this.iconType = iconType;
            }
        }
    }
}
