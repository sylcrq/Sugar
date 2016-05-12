package com.syl.data.model;

import com.syl.domain.model.CreateEvent;
import com.syl.domain.model.Event;

/**
 * Represents a created repository, branch, or tag.
 * <p/>
 * Created by Shen YunLong on 2016/05/12.
 */
public class CreateEventEntity extends EventEntity {

    public static final String TYPE = "CreateEvent";

    private PayloadBean payload;

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public static class PayloadBean {
        private Object ref;
        private String ref_type;
        private String master_branch;
        private String description;
        private String pusher_type;

        public Object getRef() {
            return ref;
        }

        public void setRef(Object ref) {
            this.ref = ref;
        }

        public String getRef_type() {
            return ref_type;
        }

        public void setRef_type(String ref_type) {
            this.ref_type = ref_type;
        }

        public String getMaster_branch() {
            return master_branch;
        }

        public void setMaster_branch(String master_branch) {
            this.master_branch = master_branch;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPusher_type() {
            return pusher_type;
        }

        public void setPusher_type(String pusher_type) {
            this.pusher_type = pusher_type;
        }
    }

    @Override
    public void transform(EventEntity entity, Event event) {
        super.transform(entity, event);

        if (entity instanceof CreateEventEntity && event instanceof CreateEvent) {
            if (((CreateEventEntity) entity).getPayload() != null) {
                CreateEvent.PayloadBean payloadBean = new CreateEvent.PayloadBean();
                payloadBean.setRef(((CreateEventEntity) entity).getPayload().getRef());
                payloadBean.setRef_type(((CreateEventEntity) entity).getPayload().getRef_type());
                payloadBean.setMaster_branch(((CreateEventEntity) entity).getPayload().getMaster_branch());
                payloadBean.setDescription(((CreateEventEntity) entity).getPayload().getDescription());
                payloadBean.setPusher_type(((CreateEventEntity) entity).getPayload().getPusher_type());
                ((CreateEvent) event).setPayload(payloadBean);
            }
        }
    }
}
