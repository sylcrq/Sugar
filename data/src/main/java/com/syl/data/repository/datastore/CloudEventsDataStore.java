package com.syl.data.repository.datastore;

import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;
import com.syl.basecore.json.SugarJson;
import com.syl.data.model.EventsEntity;
import com.syl.data.GitHubApi;
import com.syl.data.http.HttpClient;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * GitHub Developer API -> Activity -> Events
 * <p/>
 * https://developer.github.com/v3/activity/events/
 * <p/>
 * Created by shenyunlong on 16/4/27.
 */
public class CloudEventsDataStore {

    public static final String TAG = CloudEventsDataStore.class.getSimpleName();

    public static final String EVENTS_URL = "/users/%s/received_events";

    public void getUserEvents(String userName, final Callback callback) {
        if (TextUtils.isEmpty(userName)) {
            if (callback != null) {
                callback.onError(new RuntimeException("Invalid UserName"));
            }
            return;
        }

        final String url = GitHubApi.GITHUB_HOST + String.format(EVENTS_URL, userName);
        Request request = new Request.Builder().url(url).build();

//        DebugLog.d(TAG, "HTTP Request URL = " + url);

        HttpClient.getInstance().newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    if (callback != null) {
                        callback.onError(new IOException("Unexpected code " + response));
                    }
                    return;
                }

                if (callback != null) {
                    List<EventsEntity> events = SugarJson.fromJson(response.body().charStream(),
                            new TypeToken<List<EventsEntity>>() {
                            }.getType());

                    callback.onSuccess(events);
                }
            }
        });
    }

    public interface Callback {
        void onSuccess(List<EventsEntity> t);

        void onError(Exception e);
    }
}
