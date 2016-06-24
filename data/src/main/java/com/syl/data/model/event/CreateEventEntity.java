package com.syl.data.model.event;

import com.syl.data.model.EventEntity;
import com.syl.data.model.RepositoryEntity;
import com.syl.data.model.UserEntity;

/**
 * Model CreateEvent
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

        private String ref;
        private String ref_type;
        private String master_branch;
        private String description;
        private String pusher_type;
        private RepositoryEntity repository;
        private UserEntity sender;

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
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

        public RepositoryEntity getRepository() {
            return repository;
        }

        public void setRepository(RepositoryEntity repository) {
            this.repository = repository;
        }

        public UserEntity getSender() {
            return sender;
        }

        public void setSender(UserEntity sender) {
            this.sender = sender;
        }
    }
}
