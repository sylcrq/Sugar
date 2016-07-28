package com.syl.domain.repository;

import com.syl.domain.model.Event;
import com.syl.domain.model.Issue;
import com.syl.domain.model.Notification;
import com.syl.domain.model.Repository;
import com.syl.domain.model.User;

import java.util.List;

/**
 * 使用Repository模式
 * 在data层实现本接口
 * 为上层提供获取数据的统一接口
 * <p/>
 * Created by Shen YunLong on 2016/04/27.
 */
public interface GitHubRepository {

    /**
     * 获取用户接收到的Events
     *
     * @param username
     * @param callback
     */
    void getUserReceivedEvents(String username, GetDataListCallback<Event> callback);

    /**
     * 获取单个用户的User信息
     *
     * @param username
     * @param callback
     */
    void getUser(String username, GetDataCallback<User> callback);

    /**
     * 获取当前授权用户的User信息
     *
     * @param callback
     */
    void getCurrentUser(GetDataCallback<User> callback);

    /**
     * 获取当前授权用户的Issues
     *
     * @param callback
     */
    void getUserIssues(GetDataListCallback<Issue> callback);

    /**
     * 获取当前授权用户的Notifications
     *
     * @param callback
     */
    void getNotifications(boolean all, boolean participating, GetDataListCallback<Notification> callback);

    /**
     * 获取当前授权用户的Repo
     *
     * @param callback
     */
    void getMyRepos(GetDataListCallback<Repository> callback);

    void getStarredRepos(GetDataListCallback<Repository> callback);

    interface GetDataListCallback<T> {
        void onSuccess(List<T> list);

        void onError(Exception e);
    }

    interface GetDataCallback<T> {
        void onSuccess(T t);

        void onError(Exception e);
    }
}
