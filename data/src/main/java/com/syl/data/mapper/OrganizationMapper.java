package com.syl.data.mapper;

import com.syl.data.model.OrganizationEntity;
import com.syl.domain.model.Organization;

/**
 * @see Organization
 * @see OrganizationEntity
 * Created by Shen YunLong on 2016/06/27.
 */
public class OrganizationMapper {

    public static Organization transform(OrganizationEntity entity) {
        if (entity == null) {
            return null;
        }

        Organization org = new Organization();

        org.setLogin(entity.getLogin());
        org.setId(entity.getId());
        org.setUrl(entity.getUrl());
        org.setRepos_url(entity.getRepos_url());
        org.setEvents_url(entity.getEvents_url());
        org.setHooks_url(entity.getHooks_url());
        org.setIssues_url(entity.getIssues_url());
        org.setMembers_url(entity.getMembers_url());
        org.setPublic_members_url(entity.getPublic_members_url());
        org.setAvatar_url(entity.getAvatar_url());
        org.setDescription(entity.getDescription());

        return org;
    }
}
