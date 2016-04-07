package com.syl.data.model;

/**
 * 数据层User实体
 *
 * Created by shenyunlong on 4/7/16.
 */
public class UserEntity {

    private int id;
    private String cover_url;
    private String full_name;
    private String description;
    private int followers;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "cover_url='" + cover_url + '\'' +
                ", id=" + id +
                ", full_name='" + full_name + '\'' +
                ", description='" + description + '\'' +
                ", followers=" + followers +
                ", email='" + email + '\'' +
                '}';
    }
}
