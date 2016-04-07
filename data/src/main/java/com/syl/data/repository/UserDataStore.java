package com.syl.data.repository;

import com.syl.data.model.UserEntity;

import java.util.List;

/**
 * 获取用户数据接口
 *
 * Created by shenyunlong on 4/7/16.
 */
public interface UserDataStore {

    void getUserList(GetUserListCallback callback);

    void getUserDetail(int userId, GetUserDetailCallback callback);

    interface GetUserListCallback {
        void onSuccess(List<UserEntity> users);
        void onError();
    }

    interface GetUserDetailCallback {
        void onSuccess(UserEntity user);
        void onError();
    }
}
