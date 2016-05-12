package com.syl.data.model;

import com.syl.domain.model.Event;
import com.syl.domain.model.WatchEvent;

/**
 * The WatchEvent is related to starring a repository, not watching.
 * <p/>
 * Created by Shen YunLong on 2016/05/12.
 */
public class WatchEventEntity extends EventEntity {

    public static final String TYPE = "WatchEvent";

    private PayloadBean payload;

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public static class PayloadBean {
        private String action;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }

    @Override
    public void transform(EventEntity entity, Event event) {
        super.transform(entity, event);

        if (entity instanceof WatchEventEntity && event instanceof WatchEvent) {
            if (((WatchEventEntity) entity).getPayload() != null) {
                WatchEvent.PayloadBean payloadBean = new WatchEvent.PayloadBean();
                payloadBean.setAction(((WatchEventEntity) entity).getPayload().getAction());
                ((WatchEvent) event).setPayload(payloadBean);
            }
        }
    }
}
