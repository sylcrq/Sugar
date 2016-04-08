package com.syl.domain.repository;

import com.syl.domain.model.User;
import java.util.List;

/**
 * data层实现该接口
 *
 * Created by shenyunlong on 4/7/16.
 */
public interface UserRepository {

    /**
     * 获取用户列表
     *
     * @param callback
     */
    void getUserList(GetUserListCallback callback);

    /**
     * 获取用户详细信息
     *
     * @param userId
     * @param callback
     */
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
