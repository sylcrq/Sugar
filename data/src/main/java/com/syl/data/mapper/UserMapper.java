package com.syl.data.mapper;

import com.syl.data.model.UserEntity;
import com.syl.domain.model.User;


/**
 * Created by shenyunlong on 4/7/16.
 */
public class UserMapper {

    public static User transform(UserEntity entity) {
        User user = new User();

        user.setLogin(entity.getLogin());
        user.setId(entity.getId());
        user.setAvatar_url(entity.getAvatar_url());
        user.setGravatar_id(entity.getGravatar_id());
        user.setUrl(entity.getUrl());
        user.setHtml_url(entity.getHtml_url());
        user.setFollowers_url(entity.getFollowers_url());
        user.setFollowing_url(entity.getFollowing_url());
        user.setGists_url(entity.getGists_url());
        user.setStarred_url(entity.getStarred_url());
        user.setSubscriptions_url(entity.getSubscriptions_url());
        user.setOrganizations_url(entity.getOrganizations_url());
        user.setRepos_url(entity.getRepos_url());
        user.setEvents_url(entity.getEvents_url());
        user.setReceived_events_url(entity.getReceived_events_url());
        user.setType(entity.getType());
        user.setSite_admin(entity.isSite_admin());
        user.setName(entity.getName());
        user.setCompany(entity.getCompany());
        user.setBlog(entity.getBlog());
        user.setLocation(entity.getLocation());
        user.setEmail(entity.getEmail());
        user.setHireable(entity.getHireable());
        user.setBio(entity.getBio());
        user.setPublic_repos(entity.getPublic_repos());
        user.setPublic_gists(entity.getPublic_gists());
        user.setFollowers(entity.getFollowers());
        user.setFollowing(entity.getFollowing());
        user.setCreated_at(entity.getCreated_at());
        user.setUpdated_at(entity.getUpdated_at());

        return user;
    }

}
