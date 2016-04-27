package com.syl.domain.repository;

import java.util.List;

/**
 * Repository模式, Data层实现该接口
 * <p>
 * Created by shenyunlong on 16/4/27.
 */
public interface GitHubRepository {

    void getUserEvents(String userName, Callback callback);

    interface Callback<T> {
        void onSuccess(List<T> listOfT);

        void onError(Exception e);
    }
}
