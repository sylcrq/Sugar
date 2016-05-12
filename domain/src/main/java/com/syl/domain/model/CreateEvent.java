package com.syl.domain.model;

/**
 * Created by Shen YunLong on 2016/05/13.
 */
public class CreateEvent extends Event {

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
}
