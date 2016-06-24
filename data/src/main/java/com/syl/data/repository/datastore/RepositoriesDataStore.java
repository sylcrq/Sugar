package com.syl.data.repository.datastore;

import com.syl.data.model.RepositoryEntity;

import java.util.List;

/**
 * Repositories
 * <p/>
 * Created by Shen YunLong on 2016/06/24.
 */
public interface RepositoriesDataStore {

    void getMyRepos(GetReposCallback callback);

    interface GetReposCallback {
        void onSuccess(List<RepositoryEntity> list);

        void onError(Exception e);
    }
}
