package com.syl.data.repository.datastore;

import com.syl.data.model.EventEntity;

import java.util.List;

/**
 * Events
 * <p/>
 * Created by Shen YunLong on 2016/06/24.
 */
public interface EventsDataStore {

    void getUserReceivedEvents(String username, GetEventsCallback callback);

    interface GetEventsCallback {
        void onSuccess(List<EventEntity> list);

        void onError(Exception e);
    }
}
