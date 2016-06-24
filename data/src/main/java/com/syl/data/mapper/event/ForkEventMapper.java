package com.syl.data.mapper.event;

import com.syl.data.mapper.EventMapper;
import com.syl.data.model.EventEntity;
import com.syl.domain.model.Event;

/**
 * Created by Shen YunLong on 2016/06/27.
 */
public class ForkEventMapper extends EventMapper {

    @Override
    public void doTransform(Event event, EventEntity entity) {
        super.doTransform(event, entity);
    }
}
