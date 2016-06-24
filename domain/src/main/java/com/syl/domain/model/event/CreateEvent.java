package com.syl.domain.model.event;

import com.syl.domain.model.Event;
import com.syl.domain.model.Repository;
import com.syl.domain.model.User;

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

        private String ref;
        private String ref_type;
        private String master_branch;
        private String description;
        private String pusher_type;
        private Repository repository;
        private User sender;

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

        public Repository getRepository() {
            return repository;
        }

        public void setRepository(Repository repository) {
            this.repository = repository;
        }

        public User getSender() {
            return sender;
        }

        public void setSender(User sender) {
            this.sender = sender;
        }
    }
}
