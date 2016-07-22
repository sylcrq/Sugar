package com.syl.data.http;

import com.google.gson.reflect.TypeToken;
import com.syl.basecore.http.SugarHttpClient;
import com.syl.basecore.json.SugarJson;
import com.syl.data.model.EventEntity;
import com.syl.data.model.IssueEntity;
import com.syl.data.model.NotificationEntity;
import com.syl.data.model.RepositoryEntity;
import com.syl.data.model.UserEntity;
import com.syl.data.utils.GitHubJson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


/**
 * GitHub API v3
 * <p/>
 * Created by Shen YunLong on 2016/06/24.
 */
public class GitHubApiImpl implements GitHubApi {

    public static final String PARAM_ACCESS_TOKEN = "access_token=" + ACCESS_TOKEN;

    @Override
    public void getPublicEvents(GetDataListCallback<EventEntity> callback) {
        // GET /events
        final String url = HOST + "/events" +
                "?" + PARAM_ACCESS_TOKEN;
        httpGet4Event(url, callback);
    }

    @Override
    public void getRepoEvents(String owner, String repo, GetDataListCallback<EventEntity> callback) {
        // GET /repos/:owner/:repo/events
        final String url = HOST + String.format("/repos/%s/%s/events", owner, repo) +
                "?" + PARAM_ACCESS_TOKEN;
        httpGet4Event(url, callback);
    }

    @Override
    public void getPublicOrgEvents(String org, GetDataListCallback<EventEntity> callback) {
        // GET /orgs/:org/events
        final String url = HOST + String.format("/orgs/%s/events", org) +
                "?" + PARAM_ACCESS_TOKEN;
        httpGet4Event(url, callback);
    }

    @Override
    public void getUserReceivedEvents(String username, GetDataListCallback<EventEntity> callback) {
        // GET /users/:username/received_events
        final String url = HOST + String.format("/users/%s/received_events", username) +
                "?" + PARAM_ACCESS_TOKEN;
        httpGet4Event(url, callback);
    }

    @Override
    public void getUserPerformedEvents(String username, GetDataListCallback<EventEntity> callback) {
        // GET /users/:username/events
        final String url = HOST + String.format("/users/%s/events", username) +
                "?" + PARAM_ACCESS_TOKEN;
        httpGet4Event(url, callback);
    }

    @Override
    public void getNotifications(GetDataListCallback<NotificationEntity> callback) {
        // GET /notifications
        final String url = HOST + "/notifications";
        httpGet(url, callback);
    }

    @Override
    public void getRepoNotifications(String owner, String repo, GetDataListCallback<NotificationEntity> callback) {
        // GET /repos/:owner/:repo/notifications
        final String url = HOST + String.format("/repos/%s/%s/notifications", owner, repo);
        httpGet(url, callback);
    }

    @Override
    public void getIssues(GetDataListCallback<IssueEntity> callback) {
        // GET /issues
        final String url = HOST + "/issues";
        httpGet(url, callback);
    }

    @Override
    public void getUserIssues(GetDataListCallback<IssueEntity> callback) {
        // GET /user/issues
        final String url = HOST + "/user/issues";
        httpGet(url, callback);
    }

    @Override
    public void getOrgIssues(String org, GetDataListCallback<IssueEntity> callback) {
        // GET /orgs/:org/issues
        final String url = HOST + String.format("/orgs/%s/issues", org);
        httpGet(url, callback);
    }

    @Override
    public void getRepoIssues(String owner, String repo, GetDataListCallback<IssueEntity> callback) {
        // GET /repos/:owner/:repo/issues
        final String url = HOST + String.format("/repos/%s/%s/issues", owner, repo);
        httpGet(url, callback);
    }

    @Override
    public void getMyRepos(GetDataListCallback<RepositoryEntity> callback) {
        // GET /user/repos
        final String url = HOST + "/user/repos";
        httpGet(url, callback);
    }

    @Override
    public void getUserRepos(String username, GetDataListCallback<RepositoryEntity> callback) {
        // GET /users/:username/repos
        final String url = HOST + String.format("/users/%s/repos", username);
        httpGet(url, callback);
    }

    @Override
    public void getUser(String username, GetDataCallback<UserEntity> callback) {
        // GET /users/:username
        final String url = HOST + String.format("/users/%s", username) +
                "?" + PARAM_ACCESS_TOKEN;
        httpGet(url, callback, UserEntity.class);
    }

    @Override
    public void getCurrentUser(GetDataCallback<UserEntity> callback) {
        // GET /user
        final String url = HOST + "/user" +
                "?" + PARAM_ACCESS_TOKEN;
        httpGet(url, callback, UserEntity.class);
    }

    private <T> void httpGet(String url, final GetDataCallback<T> callback, final Class<T> clazz) {
        SugarHttpClient.getInstance().doHttpGet(url, new SugarHttpClient.HttpCallback() {
            @Override
            public void onError(IOException e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }

            @Override
            public void onSuccess(String response) {
                if (callback != null) {
                    T t = SugarJson.fromJson(response, clazz);
                    callback.onSuccess(t);
                }

            }
        });
    }

    private <T> void httpGet(String url, final GetDataListCallback<T> callback) {
        SugarHttpClient.getInstance().doHttpGet(url, new SugarHttpClient.HttpCallback() {
            @Override
            public void onError(IOException e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }

            @Override
            public void onSuccess(String response) {
                if (callback != null) {
                    Type type = new TypeToken<List<T>>() {
                    }.getType();
                    List<T> list = SugarJson.fromJson(response, type);
                    callback.onSuccess(list);
                }
            }
        });
    }

    private void httpGet4Event(String url, final GetDataListCallback<EventEntity> callback) {
        SugarHttpClient.getInstance().doHttpGet(url, new SugarHttpClient.HttpCallback() {
            @Override
            public void onError(IOException e) {
                if (callback != null) {
                    callback.onError(e);
                }
            }

            @Override
            public void onSuccess(String response) {
                if (callback != null) {
                    List<EventEntity> list = GitHubJson.parseEventList(response);
                    callback.onSuccess(list);
                }
            }
        });
    }
}
