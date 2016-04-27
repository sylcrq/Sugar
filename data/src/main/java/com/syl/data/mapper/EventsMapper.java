package com.syl.data.mapper;


import com.syl.data.model.EventsEntity;
import com.syl.domain.model.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenyunlong on 16/4/27.
 */
public class EventsMapper {


    public static Events transform(EventsEntity entity) {
        Events events = new Events();
        events.setId(entity.getId());
        events.setType(entity.getType());
        events.setPublicX(entity.isPublicX());
        events.setCreated_at(entity.getCreated_at());

        Events.ActorBean actorBean = new Events.ActorBean();
        if (entity.getActor() != null) {
            actorBean.setId(entity.getActor().getId());
            actorBean.setLogin(entity.getActor().getLogin());
            actorBean.setGravatar_id(entity.getActor().getGravatar_id());
            actorBean.setUrl(entity.getActor().getUrl());
            actorBean.setAvatar_url(entity.getActor().getAvatar_url());
        }
        events.setActor(actorBean);


        Events.RepoBean repoBean = new Events.RepoBean();
        if (entity.getRepo() != null) {
            repoBean.setId(entity.getRepo().getId());
            repoBean.setName(entity.getRepo().getName());
            repoBean.setUrl(entity.getRepo().getUrl());
        }
        events.setRepo(repoBean);

        Events.PayloadBean payloadBean = new Events.PayloadBean();
        if (entity.getPayload() != null) {
            payloadBean.setAction(entity.getPayload().getAction());
        }
        events.setPayload(payloadBean);

        Events.OrgBean orgBean = new Events.OrgBean();
        if (entity.getOrg() != null) {
            orgBean.setId(entity.getOrg().getId());
            orgBean.setLogin(entity.getOrg().getLogin());
            orgBean.setGravatar_id(entity.getOrg().getGravatar_id());
            orgBean.setAvatar_url(entity.getOrg().getAvatar_url());
            orgBean.setUrl(entity.getOrg().getUrl());
        }
        events.setOrg(orgBean);

        return events;
    }

    public static List<Events> transform(List<EventsEntity> entityList) {
        List<Events> eventsList = new ArrayList<>();

        for (EventsEntity entity : entityList) {
            eventsList.add(transform(entity));
        }

        return eventsList;
    }
}
