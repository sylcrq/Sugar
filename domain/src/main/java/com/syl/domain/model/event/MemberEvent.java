package com.syl.domain.model.event;

import com.syl.domain.model.Event;
import com.syl.domain.model.Repository;
import com.syl.domain.model.User;

/**
 * Created by Shen YunLong on 2016/05/13.
 */
public class MemberEvent extends Event {

    private PayloadBean payload;

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public static class PayloadBean {

        private String action;
        private User member;
        private Repository repository;
        private User sender;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public User getMember() {
            return member;
        }

        public void setMember(User member) {
            this.member = member;
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
