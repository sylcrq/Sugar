package com.syl.data.repository.datastore;

import android.text.TextUtils;

import com.syl.basecore.json.SugarJson;
import com.syl.data.GitHubApi;
import com.syl.data.http.HttpClient;
import com.syl.data.model.UserEntity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Many of the resources on the users API provide a shortcut for getting information
 * about the currently authenticated user. If a request URL does not include a
 * :username parameter then the response will be for the logged in user (and you must
 * pass authentication information with your request).
 *
 * @see <a href="https://developer.github.com/v3/users/">Users</a>
 * <p/>
 * Created by Shen YunLong on 4/7/16.
 */
public class CloudUserDataStore {

    // Get a single user
    public static final String GET_SINGLE_USER = GitHubApi.GITHUB_HOST + "/users/%s";
    // Get the authenticated user
    public static final String GET_LOGGED_IN_USER = GitHubApi.GITHUB_HOST + "/user";

    /**
     * Get a single user
     *
     * @param userName
     * @param callback
     */
    public void getSingleUser(String userName, final Callback callback) {
        if (TextUtils.isEmpty(userName)) {
            if (callback != null) {
                callback.onError(new RuntimeException("Invalid UserName"));
            }
            return;
        }

        final String url = String.format(GET_SINGLE_USER, userName) +
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
                        callback.onError(new IOException("Unexpected code " + response));
                    }
                    return;
                }

                if (callback != null) {
                    final UserEntity entity = SugarJson.fromJson(response.body().charStream(), UserEntity.class);
                    callback.onSuccess(entity);
                }
            }
        });
    }

    /**
     * Get the authenticated user
     *
     * @param callback
     */
    public void getCurrentUser(final Callback callback) {
        final String url = GET_LOGGED_IN_USER +
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
                        callback.onError(new IOException("Unexpected code " + response));
                    }
                    return;
                }

                if (callback != null) {
                    final UserEntity entity = SugarJson.fromJson(response.body().charStream(), UserEntity.class);
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
