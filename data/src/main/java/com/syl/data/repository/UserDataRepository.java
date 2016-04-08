package com.syl.data.repository;

import com.syl.data.model.UserEntity;
import com.syl.data.model.UserEntityMapper;
import com.syl.domain.repository.UserRepository;
import java.util.List;

/**
 * Created by shenyunlong on 4/7/16.
 */
public class UserDataRepository implements UserRepository {

    /* 单例 */
    private static UserDataRepository mInstance;

    private UserDataRepository() {
    }

    public synchronized static UserDataRepository getInstance() {
        if(mInstance == null) {
            mInstance = new UserDataRepository();
        }

        return mInstance;
    }

    @Override
    public void getUserDetail(int userId, final GetUserDetailCallback callback) {
        UserDataStore dataStore = new CloudUserDataStore();
        dataStore.getUserDetail(userId, new UserDataStore.GetUserDetailCallback() {
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
        UserDataStore dataStore = new CloudUserDataStore();
        dataStore.getUserList(new UserDataStore.GetUserListCallback() {
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
