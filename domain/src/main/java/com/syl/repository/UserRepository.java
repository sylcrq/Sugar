package com.syl.repository;

import com.syl.model.User;
import java.util.List;

/**
 * 获取用户相关信息接口
 *
 * Created by shenyunlong on 4/7/16.
 */
public interface UserRepository {

    void getUserList(GetUserListCallback callback);

    void getUserDetail(int userId, GetUserDetailCallback callback);

    interface GetUserListCallback {
        void onSuccess(List<User> users);
        void onError();
    }

    interface GetUserDetailCallback {
        void onSuccess(User user);
        void onError();
    }
}
