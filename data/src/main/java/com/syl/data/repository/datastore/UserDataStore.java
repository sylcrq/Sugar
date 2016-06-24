package com.syl.data.repository.datastore;

import com.syl.data.model.UserEntity;

/**
 * Users
 * <p/>
 * Created by Shen YunLong on 2016/06/24.
 */
public interface UserDataStore {

    void getUser(String username, GetUserCallback callback);

    void getCurrentUser(GetUserCallback callback);

    interface GetUserCallback {
        void onSuccess(UserEntity user);

        void onError(Exception e);
    }
}
