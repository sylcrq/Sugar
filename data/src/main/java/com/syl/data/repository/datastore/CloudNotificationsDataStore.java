package com.syl.data.repository.datastore;

import com.syl.data.http.GitHubApi;
import com.syl.data.http.GitHubApiImpl;
import com.syl.data.model.NotificationEntity;

import java.util.List;


/**
 * @see <a href="https://developer.github.com/v3/activity/notifications/">Notifications</a>
 * <p/>
 * Created by Shen YunLong on 2016/06/23.
 */
public class CloudNotificationsDataStore implements NotificationsDataStore {

    public static final String TAG = CloudNotificationsDataStore.class.getSimpleName();

    private GitHubApi mNetApi = new GitHubApiImpl();

    @Override
    public void getNotifications(boolean all, boolean participating, final GetNotificationsCallback callback) {
        mNetApi.getNotifications(all, participating, new GitHubApi.GetDataListCallback<NotificationEntity>() {
            @Override
            public void onSuccess(List<NotificationEntity> list) {
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
