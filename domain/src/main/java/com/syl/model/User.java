package com.syl.model;

/**
 * 业务逻辑层User Model
 *
 */
public class User {

    private int mUserId;
    private String mCoverUrl;
    private String mFullName;
    private String mDescription;
    private int mFollowers;
    private String mEmail;

    public String getCoverUrl() {
        return mCoverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        mCoverUrl = coverUrl;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public int getFollowers() {
        return mFollowers;
    }

    public void setFollowers(int followers) {
        mFollowers = followers;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "mCoverUrl='" + mCoverUrl + '\'' +
                ", mUserId=" + mUserId +
                ", mFullName='" + mFullName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mFollowers=" + mFollowers +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }
}
