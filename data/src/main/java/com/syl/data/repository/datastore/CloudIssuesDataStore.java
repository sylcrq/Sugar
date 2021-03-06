package com.syl.data.repository.datastore;

import com.syl.data.http.GitHubApi;
import com.syl.data.http.GitHubApiImpl;
import com.syl.data.model.IssueEntity;

import java.util.List;


/**
 * @see <a href="https://developer.github.com/v3/issues/">Issues</a>
 * <p/>
 * Created by Shen YunLong on 2016/06/23.
 */
public class CloudIssuesDataStore implements IssuesDataStore {

    public static final String TAG = CloudIssuesDataStore.class.getSimpleName();

    private GitHubApi mNetApi = new GitHubApiImpl();

    @Override
    public void getUserIssues(final GetIssuesCallback callback) {
        mNetApi.getUserIssues(new GitHubApi.GetDataListCallback<IssueEntity>() {
            @Override
            public void onSuccess(List<IssueEntity> list) {
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
