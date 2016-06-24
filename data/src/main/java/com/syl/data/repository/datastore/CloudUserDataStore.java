package com.syl.data.repository.datastore;

import android.text.TextUtils;

import com.syl.basecore.logger.SugarLogger;
import com.syl.data.http.GitHubApi;
import com.syl.data.http.GitHubApiImpl;
import com.syl.data.model.UserEntity;


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
public class CloudUserDataStore implements UserDataStore {

    public static final String TAG = CloudUserDataStore.class.getSimpleName();

    private GitHubApi mNetApi = new GitHubApiImpl();

    @Override
    public void getUser(String username, final GetUserCallback callback) {
        if (TextUtils.isEmpty(username)) {
            SugarLogger.e(TAG, "invalid username");
            return;
        }

        mNetApi.getUser(username, new GitHubApi.GetDataCallback<UserEntity>() {
            @Override
            public void onSuccess(UserEntity entity) {
                if (callback != null) {
                    callback.onSuccess(entity);
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

    @Override
    public void getCurrentUser(final GetUserCallback callback) {
        mNetApi.getCurrentUser(new GitHubApi.GetDataCallback<UserEntity>() {
            @Override
            public void onSuccess(UserEntity entity) {
                if (callback != null) {
                    callback.onSuccess(entity);
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
