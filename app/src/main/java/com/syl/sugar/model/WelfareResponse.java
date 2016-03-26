package com.syl.sugar.model;

import java.util.List;

/**
 * 福利
 *
 * Created by syl on 16/3/1.
 */
public class WelfareResponse {
    /**
     * error : false
     * results : [{"_id":"56d4f4f9421aa9647be5f908","_ns":"ganhuo","createdAt":"2016-03-01T09:48:41.472Z","desc":"3.1","publishedAt":"2016-03-01T12:09:30.687Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1f1h4f51wbcj20f00lddih.jpg","used":true,"who":"张涵宇"},{"_id":"56d3c506421aa93cbc97e25c","_ns":"ganhuo","createdAt":"2016-02-29T12:11:50.467Z","desc":"2.29-1","publishedAt":"2016-02-29T12:19:00.15Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bjw1f1g2xpx9ehj20ez0mi0vc.jpg","used":true,"who":"张涵宇"},{"_id":"56cfcaba421aa909db4d6ab0","_ns":"ganhuo","createdAt":"2016-02-26T03:37:44.552Z","desc":"2.26","publishedAt":"2016-02-26T11:58:08.172Z","type":"福利","url":"http://ww1.sinaimg.cn/large/7a8aed7bjw1f1cl3c7rfgj20dw0ku76t.jpg","used":true,"who":"张涵宇"},{"_id":"56ce83f8421aa910e89d4379","_ns":"ganhuo","createdAt":"2016-02-25T02:22:18.992Z","desc":"2.25","publishedAt":"2016-02-25T12:34:54.0Z","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1f1bdal8i3nj20f00lf77g.jpg","used":true,"who":"张涵宇"},{"_id":"56ccf89e421aa92e1da900be","_ns":"ganhuo","createdAt":"2016-02-24T00:22:24.855Z","desc":"2.24","publishedAt":"2016-02-24T04:42:32.66Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1f1a47fpjacj20f00imtam.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d29421aa95caa708336","_ns":"ganhuo","createdAt":"2016-02-23T02:24:19.518Z","desc":"2.23","publishedAt":"2016-02-23T05:08:46.837Z","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1f19241kkpwj20f00hfabt.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d29421aa95caa70831a","_ns":"ganhuo","createdAt":"2016-02-22T02:48:39.585Z","desc":"2.22","publishedAt":"2016-02-22T04:20:23.542Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1f17x6wmh09j20f00m1mzh.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d29421aa95caa7082f7","_ns":"ganhuo","createdAt":"2016-02-19T02:15:50.180Z","desc":"2.19","publishedAt":"2016-02-19T03:45:05.172Z","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1f14fbwrfptj20zk0npgtu.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d29421aa95caa7082df","_ns":"ganhuo","createdAt":"2016-02-18T01:35:05.348Z","desc":"2.18","publishedAt":"2016-02-18T04:12:05.777Z","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1f138l9egrmj20f00mbdij.jpg","used":true,"who":"张涵宇"},{"_id":"56cc6d29421aa95caa7082b9","_ns":"ganhuo","createdAt":"2016-02-15T09:16:22.91Z","desc":"2.16","publishedAt":"2016-02-16T04:46:45.140Z","type":"福利","url":"http://ww4.sinaimg.cn/large/7a8aed7bjw1f1052bhjauj20f00l6q4o.jpg","used":true,"who":"张涵宇"}]
     */

    private boolean error;
    /**
     * _id : 56d4f4f9421aa9647be5f908
     * _ns : ganhuo
     * createdAt : 2016-03-01T09:48:41.472Z
     * desc : 3.1
     * publishedAt : 2016-03-01T12:09:30.687Z
     * source : chrome
     * type : 福利
     * url : http://ww3.sinaimg.cn/large/7a8aed7bjw1f1h4f51wbcj20f00lddih.jpg
     * used : true
     * who : 张涵宇
     */

    private List<Welfare> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(List<Welfare> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public List<Welfare> getResults() {
        return results;
    }

    public static class Welfare {
        private String _id;
        private String _ns;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public void set_id(String _id) {
            this._id = _id;
        }

        public void set_ns(String _ns) {
            this._ns = _ns;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public String get_id() {
            return _id;
        }

        public String get_ns() {
            return _ns;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String getSource() {
            return source;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public boolean isUsed() {
            return used;
        }

        public String getWho() {
            return who;
        }
    }
}
