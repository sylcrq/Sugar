package com.syl.data.model;

import com.google.gson.annotations.SerializedName;
import com.syl.domain.model.Event;

/**
 * Event Base Class
 *
 * @see Event
 * <p/>
 * Created by Shen YunLong on 2016/04/27.
 */
public abstract class EventEntity {

    private String id;
    private String type;
    private ActorBean actor;
    private RepoBean repo;
    @SerializedName("public")
    private boolean publicX;
    private String created_at;
    private OrgBean org;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ActorBean getActor() {
        return actor;
    }

    public void setActor(ActorBean actor) {
        this.actor = actor;
    }

    public RepoBean getRepo() {
        return repo;
    }

    public void setRepo(RepoBean repo) {
        this.repo = repo;
    }

    public boolean isPublicX() {
        return publicX;
    }

    public void setPublicX(boolean publicX) {
        this.publicX = publicX;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public OrgBean getOrg() {
        return org;
    }

    public void setOrg(OrgBean org) {
        this.org = org;
    }

    public static class ActorBean {
        private int id;
        private String login;
        private String gravatar_id;
        private String url;
        private String avatar_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getGravatar_id() {
            return gravatar_id;
        }

        public void setGravatar_id(String gravatar_id) {
            this.gravatar_id = gravatar_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }
    }

    public static class RepoBean {
        private int id;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class OrgBean {
        private int id;
        private String login;
        private String gravatar_id;
        private String url;
        private String avatar_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getGravatar_id() {
            return gravatar_id;
        }

        public void setGravatar_id(String gravatar_id) {
            this.gravatar_id = gravatar_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }
    }

    public void transform(EventEntity entity, Event event) {
        event.setId(entity.getId());
        event.setType(entity.getType());
        event.setPublicX(entity.isPublicX());
        event.setCreated_at(entity.getCreated_at());

        if (entity.getActor() != null) {
            Event.ActorBean actorBean = new Event.ActorBean();
            actorBean.setId(entity.getActor().getId());
            actorBean.setLogin(entity.getActor().getLogin());
            actorBean.setGravatar_id(entity.getActor().getGravatar_id());
            actorBean.setUrl(entity.getActor().getUrl());
            actorBean.setAvatar_url(entity.getActor().getAvatar_url());
            event.setActor(actorBean);
        }

        if (entity.getRepo() != null) {
            Event.RepoBean repoBean = new Event.RepoBean();
            repoBean.setId(entity.getRepo().getId());
            repoBean.setName(entity.getRepo().getName());
            repoBean.setUrl(entity.getRepo().getUrl());
            event.setRepo(repoBean);
        }

        if (entity.getOrg() != null) {
            Event.OrgBean orgBean = new Event.OrgBean();
            orgBean.setId(entity.getOrg().getId());
            orgBean.setLogin(entity.getOrg().getLogin());
            orgBean.setGravatar_id(entity.getOrg().getGravatar_id());
            orgBean.setAvatar_url(entity.getOrg().getAvatar_url());
            orgBean.setUrl(entity.getOrg().getUrl());
            event.setOrg(orgBean);
        }
    }
}
