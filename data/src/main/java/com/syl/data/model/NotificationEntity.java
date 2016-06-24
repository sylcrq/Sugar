package com.syl.data.model;


/**
 * Model Notification
 * <p/>
 * Created by Shen YunLong on 2016/06/23.
 */
public class NotificationEntity {

    private String id;
    private RepositoryEntity repository;
    private SubjectBean subject;
    private String reason;
    private boolean unread;
    private String updated_at;
    private String last_read_at;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RepositoryEntity getRepository() {
        return repository;
    }

    public void setRepository(RepositoryEntity repository) {
        this.repository = repository;
    }

    public SubjectBean getSubject() {
        return subject;
    }

    public void setSubject(SubjectBean subject) {
        this.subject = subject;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLast_read_at() {
        return last_read_at;
    }

    public void setLast_read_at(String last_read_at) {
        this.last_read_at = last_read_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class SubjectBean {
        private String title;
        private String url;
        private String latest_comment_url;
        private String type;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getLatest_comment_url() {
            return latest_comment_url;
        }

        public void setLatest_comment_url(String latest_comment_url) {
            this.latest_comment_url = latest_comment_url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
