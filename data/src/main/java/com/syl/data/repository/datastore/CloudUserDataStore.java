package com.syl.data.repository.datastore;

import android.text.TextUtils;

import com.syl.data.GitHubApi;
import com.syl.data.http.HttpClient;
import com.syl.data.model.UserEntity;
import com.syl.data.utils.JsonUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * https://developer.github.com/v3/users/
 * <p>
 * Created by shenyunlong on 4/7/16.
 */
public class CloudUserDataStore {

    public static final String SINGLE_USER_URL = "/users/%s";

    public void getSingleUser(String userName, final Callback callback) {
        if (TextUtils.isEmpty(userName)) {
            if (callback != null) {
                callback.onError(new RuntimeException("Invalid UserName"));
            }
            return;
        }

        final String url = GitHubApi.GITHUB_HOST + String.format(SINGLE_USER_URL, userName);
        Request request = new Request.Builder().url(url).build();

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
                    UserEntity entity = JsonUtils.fromJson(response.body().charStream(), UserEntity.class);

                    callback.onSuccess(entity);
                }
            }
        });
    }

    public interface Callback {
        void onSuccess(UserEntity entity);

        void onError(Exception e);
    }

}
