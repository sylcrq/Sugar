package com.syl.data.repository;

import com.syl.data.model.UserEntity;
import com.syl.data.model.UserEntityMapper;
import com.syl.repository.UserRepository;
import java.util.List;

/**
 * Created by shenyunlong on 4/7/16.
 */
public class UserDataRepository implements UserRepository {

    private UserDataStore mDataStore = new CloudUserDataStore();

    @Override
    public void getUserDetail(int userId, final GetUserDetailCallback callback) {
        mDataStore.getUserDetail(userId, new UserDataStore.GetUserDetailCallback() {
            @Override
            public void onSuccess(UserEntity user) {
                callback.onSuccess(UserEntityMapper.transform(user));
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    @Override
    public void getUserList(final GetUserListCallback callback) {
        mDataStore.getUserList(new UserDataStore.GetUserListCallback() {
            @Override
            public void onSuccess(List<UserEntity> users) {
                callback.onSuccess(UserEntityMapper.transform(users));
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }
}
