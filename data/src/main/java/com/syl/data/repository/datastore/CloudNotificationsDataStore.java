package com.syl.data.repository.datastore;

import com.google.gson.reflect.TypeToken;
import com.syl.basecore.json.SugarJson;
import com.syl.data.GitHubApi;
import com.syl.data.http.HttpClient;
import com.syl.data.model.NotificationEntity;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @see <a href="https://developer.github.com/v3/activity/notifications/">Notifications</a>
 * <p/>
 * Created by Shen YunLong on 2016/06/23.
 */
public class CloudNotificationsDataStore {

    // List your notifications
    public static final String GET_ALL_NOTIFICATIONS = GitHubApi.GITHUB_HOST + "/notifications";

    public void getNotificationList(final Callback callback) {
        final String url = GET_ALL_NOTIFICATIONS +
                "?access_token=" + GitHubApi.GITHUB_ACCESS_TOKEN;
        final Request request = new Request.Builder().url(url).build();

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
                        callback.onError(new IOException("" + response));
                    }
                    return;
                }

                if (callback != null) {
                    Type type = new TypeToken<List<NotificationEntity>>() {
                    }.getType();
                    List<NotificationEntity> notificationList = SugarJson.fromJson(response.body().charStream(), type);
                    callback.onSuccess(notificationList);
                }
            }
        });

    }

    public interface Callback {
        void onSuccess(List<NotificationEntity> notificationList);

        void onError(Exception e);
    }
}
