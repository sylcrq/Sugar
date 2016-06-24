package com.syl.data.model.event;

import com.syl.data.model.EventEntity;
import com.syl.data.model.RepositoryEntity;
import com.syl.data.model.UserEntity;

/**
 * Model MemberEvent
 * <p>
 * Created by Shen YunLong on 2016/05/12.
 */
public class MemberEventEntity extends EventEntity {

    public static final String TYPE = "MemberEvent";

    private PayloadBean payload;

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public static class PayloadBean {

        private String action;
        private UserEntity member;
        private RepositoryEntity repository;
        private UserEntity sender;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public UserEntity getMember() {
            return member;
        }

        public void setMember(UserEntity member) {
            this.member = member;
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
