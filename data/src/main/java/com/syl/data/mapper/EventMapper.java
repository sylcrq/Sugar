package com.syl.data.mapper;


import com.syl.data.model.CreateEventEntity;
import com.syl.data.model.EventEntity;
import com.syl.data.model.ForkEventEntity;
import com.syl.data.model.MemberEventEntity;
import com.syl.data.model.WatchEventEntity;
import com.syl.domain.model.CreateEvent;
import com.syl.domain.model.Event;
import com.syl.domain.model.ForkEvent;
import com.syl.domain.model.MemberEvent;
import com.syl.domain.model.WatchEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * 将 {@link EventEntity} 对象转换成 {@link Event}
 * <p/>
 * Created by Shen YunLong on 2016/04/27.
 */
public class EventMapper {

    public static Event transform(EventEntity entity) {
        Event event = null;

        if (entity instanceof WatchEventEntity) {
            event = new WatchEvent();
        } else if (entity instanceof CreateEventEntity) {
            event = new CreateEvent();
        } else if (entity instanceof ForkEventEntity) {
            event = new ForkEvent();
        } else if (entity instanceof MemberEventEntity) {
            event = new MemberEvent();
        }

        entity.transform(entity, event);

        return event;
    }

    public static List<Event> transform(List<EventEntity> entityList) {
        List<Event> eventList = new ArrayList<>();

        for (EventEntity entity : entityList) {
            Event event = transform(entity);
            if (event != null) {
                eventList.add(event);
            }
        }

        return eventList;
    }
}
