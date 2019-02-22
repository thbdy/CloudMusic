package com.from206.cloudmusic.module.main.model;

import java.util.List;

/**
 * Created by 75232 on 2019/2/21
 * Email：752323877@qq.com
 */
public class SearchSuggestResult {

    /**
     * result : {"allMatch":[{"keyword":"张学友","type":1,"alg":"alg_psug_a","lastKeyword":""},{"keyword":"张艺兴","type":1,"alg":"alg_psug_a","lastKeyword":""},{"keyword":"张靓颖","type":1,"alg":"alg_psug_a","lastKeyword":""},{"keyword":"张国荣","type":1,"alg":"alg_psug_a","lastKeyword":""},{"keyword":"张韶涵","type":1,"alg":"alg_psug_a","lastKeyword":""},{"keyword":"张宇","type":1,"alg":"alg_psug_a","lastKeyword":""}]}
     * code : 200
     */

    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean {
        private List<AllMatchBean> allMatch;

        public List<AllMatchBean> getAllMatch() {
            return allMatch;
        }

        public void setAllMatch(List<AllMatchBean> allMatch) {
            this.allMatch = allMatch;
        }

        public static class AllMatchBean {
            /**
             * keyword : 张学友
             * type : 1
             * alg : alg_psug_a
             * lastKeyword :
             */

            private String keyword;
            private int type;
            private String alg;
            private String lastKeyword;

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getAlg() {
                return alg;
            }

            public void setAlg(String alg) {
                this.alg = alg;
            }

            public String getLastKeyword() {
                return lastKeyword;
            }

            public void setLastKeyword(String lastKeyword) {
                this.lastKeyword = lastKeyword;
            }
        }
    }
}
