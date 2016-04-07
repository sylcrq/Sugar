package com.syl.data.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.syl.data.model.UserEntity;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 从云端获取用户数据
 *
 * Created by shenyunlong on 4/7/16.
 */
public class CloudUserDataStore implements UserDataStore {

    private OkHttpClient mOkHttpClient = new OkHttpClient();
    private Gson mGson = new Gson();

    /**
     * 获取某个用户详细信息
     *
     * @param userId
     * @param callback
     */
    @Override
    public void getUserDetail(int userId, final GetUserDetailCallback callback) {
        final String url = "http://www.android10.org/myapi/user_" + userId + ".json";
        Request request = new Request.Builder().url(url).build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(!response.isSuccessful()) {
                    callback.onError();
                    return;
                }

                UserEntity user = mGson.fromJson(response.body().charStream(), UserEntity.class);
                callback.onSuccess(user);
            }
        });
    }

    /**
     * 获取用户列表
     *
     * @param callback
     */
    @Override
    public void getUserList(final GetUserListCallback callback) {
        Request request = new Request.Builder().url("http://www.android10.org/myapi/users.json").build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(!response.isSuccessful()) {
                    callback.onError();
                    return;
                }

                Type listType = new TypeToken<List<UserEntity>>(){}.getType();
                List<UserEntity> users = mGson.fromJson(response.body().charStream(), listType);
                callback.onSuccess(users);
            }
        });
    }
}
