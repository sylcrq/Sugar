package com.syl.data.mapper;


import com.syl.data.mapper.event.CreateEventMapper;
import com.syl.data.mapper.event.ForkEventMapper;
import com.syl.data.mapper.event.MemberEventMapper;
import com.syl.data.mapper.event.WatchEventMapper;
import com.syl.data.model.event.CreateEventEntity;
import com.syl.data.model.EventEntity;
import com.syl.data.model.event.ForkEventEntity;
import com.syl.data.model.event.MemberEventEntity;
import com.syl.data.model.event.WatchEventEntity;
import com.syl.domain.model.event.CreateEvent;
import com.syl.domain.model.Event;
import com.syl.domain.model.event.ForkEvent;
import com.syl.domain.model.event.MemberEvent;
import com.syl.domain.model.event.WatchEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @see Event
 * @see EventEntity
 * Created by Shen YunLong on 2016/04/27.
 */
public class EventMapper {

    public static Event transform(EventEntity entity) {
        Event event = null;

        if (entity instanceof WatchEventEntity) {
            event = new WatchEvent();
            new WatchEventMapper().doTransform(event, entity);
        } else if (entity instanceof CreateEventEntity) {
            event = new CreateEvent();
            new CreateEventMapper().doTransform(event, entity);
        } else if (entity instanceof ForkEventEntity) {
            event = new ForkEvent();
            new ForkEventMapper().doTransform(event, entity);
        } else if (entity instanceof MemberEventEntity) {
            event = new MemberEvent();
            new MemberEventMapper().doTransform(event, entity);
        }

        return event;
    }

    public static List<Event> transform(List<EventEntity> entityList) {
        List<Event> list = new ArrayList<>();

        for (EventEntity entity : entityList) {
            Event event = transform(entity);
            if (event != null) {
                list.add(event);
            }
        }

        return list;
    }

    public void doTransform(Event event, EventEntity entity) {
        event.setType(entity.getType());
        event.setPublicX(entity.isPublicX());
        event.setRepo(RepositoryMapper.transform(entity.getRepo()));
        event.setActor(UserMapper.transform(entity.getActor()));
        event.setOrg(OrganizationMapper.transform(entity.getOrg()));
        event.setCreated_at(entity.getCreated_at());
        event.setId(entity.getId());
    }
}
