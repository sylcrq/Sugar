package com.syl.data.mapper.event;

import com.syl.data.mapper.EventMapper;
import com.syl.data.mapper.RepositoryMapper;
import com.syl.data.mapper.UserMapper;
import com.syl.data.model.EventEntity;
import com.syl.data.model.event.CreateEventEntity;
import com.syl.domain.model.Event;
import com.syl.domain.model.event.CreateEvent;

/**
 * @see CreateEvent
 * @see CreateEventEntity
 * Created by Shen YunLong on 2016/06/27.
 */
public class CreateEventMapper extends EventMapper {

    @Override
    public void doTransform(Event event, EventEntity entity) {
        super.doTransform(event, entity);

        if (event instanceof CreateEvent && entity instanceof CreateEventEntity) {
            CreateEvent createEvent = (CreateEvent) event;
            CreateEventEntity createEventEntity = (CreateEventEntity) entity;

            CreateEvent.PayloadBean payload = new CreateEvent.PayloadBean();
            payload.setRef(createEventEntity.getPayload().getRef());
            payload.setRef_type(createEventEntity.getPayload().getRef_type());
            payload.setMaster_branch(createEventEntity.getPayload().getMaster_branch());
            payload.setDescription(createEventEntity.getPayload().getDescription());
            payload.setPusher_type(createEventEntity.getPayload().getPusher_type());
            payload.setRepository(RepositoryMapper.transform(createEventEntity.getPayload().getRepository()));
            payload.setSender(UserMapper.transform(createEventEntity.getPayload().getSender()));
            createEvent.setPayload(payload);
        }
    }

}
