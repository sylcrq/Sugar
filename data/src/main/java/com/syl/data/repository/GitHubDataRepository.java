package com.syl.data.repository;

import com.syl.data.mapper.EventMapper;
import com.syl.data.mapper.UserMapper;
import com.syl.data.model.EventEntity;
import com.syl.data.model.UserEntity;
import com.syl.data.repository.datastore.CloudEventsDataStore;
import com.syl.data.repository.datastore.CloudUserDataStore;
import com.syl.data.repository.datastore.GitHubDataFactory;
import com.syl.domain.repository.GitHubRepository;

import java.util.List;

/**
 * 实现Domain层接口
 *
 * @see GitHubRepository
 * <p/>
 * Created by shenyunlong on 16/4/27.
 */
public class GitHubDataRepository implements GitHubRepository {

    private static GitHubDataRepository mInstance;

    private GitHubDataRepository() {
    }

    public static GitHubDataRepository getInstance() {
        if (mInstance == null) {
            mInstance = new GitHubDataRepository();
        }

        return mInstance;
    }

    @Override
    public void getUserEvents(String userName, final Callback callback) {
        CloudEventsDataStore dataStore = GitHubDataFactory.createEventsDataStore();
        dataStore.getUserEvents(userName, new CloudEventsDataStore.Callback() {

            @Override
            public void onSuccess(List<EventEntity> list) {
                if (callback != null) {
                    // 转换成Data层对象
                    callback.onSuccess(EventMapper.transform(list));
                }
            }

            @Override
            public void onError(Exception e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }
        });
    }

    @Override
    public void getUserEvents(String userName, int page, final Callback callback) {
        CloudEventsDataStore dataStore = GitHubDataFactory.createEventsDataStore();
        dataStore.getUserEvents(userName, page, new CloudEventsDataStore.Callback() {
            @Override
            public void onSuccess(List<EventEntity> list) {
                if (callback != null) {
                    callback.onSuccess(EventMapper.transform(list));
                }
            }

            @Override
            public void onError(Exception e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }
        });
    }

    @Override
    public void getSingleUser(String userName, final GetCallback callback) {
        CloudUserDataStore dataStore = GitHubDataFactory.createUserDataStore();
        dataStore.getSingleUser(userName, new CloudUserDataStore.Callback() {
            @Override
            public void onSuccess(UserEntity entity) {
                if (callback != null) {
                    callback.onSuccess(UserMapper.transform(entity));
                }
            }

            @Override
            public void onError(Exception e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }
        });

    }
}
