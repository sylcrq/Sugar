package com.syl.data.repository.datastore;

import com.syl.data.model.NotificationEntity;

import java.util.List;

/**
 * Notifications
 * <p/>
 * Created by Shen YunLong on 2016/06/24.
 */
public interface NotificationsDataStore {

    void getNotifications(boolean all, boolean participating, GetNotificationsCallback callback);

    interface GetNotificationsCallback {
        void onSuccess(List<NotificationEntity> list);

        void onError(Exception e);
    }
}
