package com.syl.data.repository.datastore;

import android.text.TextUtils;

import com.syl.basecore.logger.SugarLogger;
import com.syl.data.http.GitHubApi;
import com.syl.data.http.GitHubApiImpl;
import com.syl.data.model.EventEntity;

import java.util.List;


/**
 * Events
 * https://developer.github.com/v3/activity/events/
 * <p/>
 * Created by Shen YunLong on 2016/04/27.
 */
public class CloudEventsDataStore implements EventsDataStore {

    public static final String TAG = CloudEventsDataStore.class.getSimpleName();

    private GitHubApi mNetApi = new GitHubApiImpl();

    @Override
    public void getUserReceivedEvents(String username, final GetEventsCallback callback) {
        if (TextUtils.isEmpty(username)) {
            SugarLogger.e(TAG, "invalid username");
            return;
        }

        mNetApi.getUserReceivedEvents(username, new GitHubApi.GetDataListCallback<EventEntity>() {
            @Override
            public void onSuccess(List<EventEntity> list) {
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
