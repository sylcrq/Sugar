package com.syl.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Model Event
 * <p/>
 * Created by Shen YunLong on 2016/04/27.
 */
public abstract class EventEntity {

    private String type;
    @SerializedName("public")
    private boolean publicX;
    private RepositoryEntity repo;
    private UserEntity actor;
    private OrganizationEntity org;
    private String created_at;
    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPublicX() {
        return publicX;
    }

    public void setPublicX(boolean publicX) {
        this.publicX = publicX;
    }

    public RepositoryEntity getRepo() {
        return repo;
    }

    public void setRepo(RepositoryEntity repo) {
        this.repo = repo;
    }

    public UserEntity getActor() {
        return actor;
    }

    public void setActor(UserEntity actor) {
        this.actor = actor;
    }

    public OrganizationEntity getOrg() {
        return org;
    }

    public void setOrg(OrganizationEntity org) {
        this.org = org;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
