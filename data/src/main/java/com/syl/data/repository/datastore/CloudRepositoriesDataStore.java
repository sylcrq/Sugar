package com.syl.data.repository.datastore;

import com.syl.data.http.GitHubApi;
import com.syl.data.http.GitHubApiImpl;
import com.syl.data.model.RepositoryEntity;

import java.util.List;

/**
 * Repositories
 * <p/>
 * Created by Shen YunLong on 2016/06/24.
 */
public class CloudRepositoriesDataStore implements RepositoriesDataStore {

//    public static final String TAG = CloudRepositoriesDataStore.class.getSimpleName();

    private GitHubApi mNetApi = new GitHubApiImpl();

    @Override
    public void getMyRepos(final GetReposCallback callback) {
        mNetApi.getMyRepos(new GitHubApi.GetDataListCallback<RepositoryEntity>() {
            @Override
            public void onSuccess(List<RepositoryEntity> list) {
                if (callback != null) {
                    callback.onSuccess(list);
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
    public void getStarredRepos(final GetReposCallback callback) {
        mNetApi.getStarredRepos(new GitHubApi.GetDataListCallback<RepositoryEntity>() {
            @Override
            public void onSuccess(List<RepositoryEntity> list) {
                if (callback != null) {
                    callback.onSuccess(list);
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
