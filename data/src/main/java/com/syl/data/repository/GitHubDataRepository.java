package com.syl.data.repository;

import com.syl.data.mapper.EventsMapper;
import com.syl.data.model.EventsEntity;
import com.syl.data.repository.datastore.CloudEventsDataStore;
import com.syl.data.repository.datastore.GitHubDataFactory;
import com.syl.domain.repository.GitHubRepository;

import java.util.List;

/**
 * 实现Domain层接口
 *
 * @see GitHubRepository
 * <p>
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
            public void onSuccess(List<EventsEntity> list) {
                if (callback != null) {
                    // 转换成Data层对象
                    callback.onSuccess(EventsMapper.transform(list));
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
