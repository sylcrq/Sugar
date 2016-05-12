package com.syl.data.repository.datastore;

import android.text.TextUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.syl.basecore.json.SugarJson;
import com.syl.basecore.logger.SugarLogger;
import com.syl.data.model.CreateEventEntity;
import com.syl.data.model.EventEntity;
import com.syl.data.GitHubApi;
import com.syl.data.http.HttpClient;
import com.syl.data.model.ForkEventEntity;
import com.syl.data.model.MemberEventEntity;
import com.syl.data.model.WatchEventEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * List events that a user has received
 * <p/>
 * https://developer.github.com/v3/activity/events/
 * <p/>
 * Created by Shen YunLong on 2016/04/27.
 */
public class CloudEventsDataStore {

    public static final String TAG = CloudEventsDataStore.class.getSimpleName();

    public static final String EVENTS_URL = "/users/%s/received_events?page=%s";

    /**
     * 获取用户Events,默认第一页
     *
     * @param userName
     * @param callback
     */
    public void getUserEvents(String userName, Callback callback) {
        getUserEvents(userName, 1, callback);
    }

    /**
     * 获取用户Events
     *
     * @param userName
     * @param page
     * @param callback
     */
    public void getUserEvents(String userName, int page, final Callback callback) {
        // 检查传入参数
        if (TextUtils.isEmpty(userName) || page <= 0) {
            if (callback != null) {
                callback.onError(new RuntimeException("Invalid UserName"));
            }
            return;
        }

        final String url = GitHubApi.GITHUB_HOST + String.format(EVENTS_URL, userName, page);
        Request request = new Request.Builder().url(url).build();
        SugarLogger.d(TAG, url);

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
                    List<EventEntity> eventList = new ArrayList<EventEntity>();

                    String json = response.body().string();
                    SugarLogger.d(TAG, json);

                    // TODO: 16/5/13 不要直接调用Gson方法
                    JsonParser parser = new JsonParser();
                    JsonArray array = parser.parse(json).getAsJsonArray();

                    for (JsonElement element : array) {
                        String type = element.getAsJsonObject().get("type").getAsString();

                        if (type.equals(WatchEventEntity.TYPE)) {
                            eventList.add(SugarJson.fromJson(element, WatchEventEntity.class));
                        } else if (type.equals(CreateEventEntity.TYPE)) {
                            eventList.add(SugarJson.fromJson(element, CreateEventEntity.class));
                        } else if (type.equals(ForkEventEntity.TYPE)) {
                            eventList.add(SugarJson.fromJson(element, ForkEventEntity.class));
                        } else if (type.equals(MemberEventEntity.TYPE)) {
                            eventList.add(SugarJson.fromJson(element, MemberEventEntity.class));
                        }
                    }

                    callback.onSuccess(eventList);
                }
            }
        });
    }

    public interface Callback {
        void onSuccess(List<EventEntity> t);

        void onError(Exception e);
    }
}
