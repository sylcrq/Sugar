package com.syl.data.repository.datastore;

import com.syl.data.model.IssueEntity;

import java.util.List;

/**
 * Issues
 * <p/>
 * Created by Shen YunLong on 2016/06/24.
 */
public interface IssuesDataStore {

    void getUserIssues(GetIssuesCallback callback);

    interface GetIssuesCallback {
        void onSuccess(List<IssueEntity> list);

        void onError(Exception e);
    }
}
