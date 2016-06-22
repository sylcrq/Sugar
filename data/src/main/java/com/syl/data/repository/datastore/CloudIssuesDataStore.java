package com.syl.data.repository.datastore;

import com.google.gson.reflect.TypeToken;
import com.syl.basecore.json.SugarJson;
import com.syl.data.GitHubApi;
import com.syl.data.http.HttpClient;
import com.syl.data.model.IssueEntity;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @see <a href="https://developer.github.com/v3/issues/">Issues</a>
 * <p/>
 * Created by Shen YunLong on 2016/06/23.
 */
public class CloudIssuesDataStore {

    // List all issues assigned to the authenticated user across all visible
    // repositories including owned repositories, member repositories, and organization repositories
    public static final String GET_ALL_ISSUES = GitHubApi.GITHUB_HOST + "/issues";
    // List all issues across owned and member repositories assigned to the authenticated user
    public static final String GET_ALL_REPO_ISSUES = GitHubApi.GITHUB_HOST + "/user/issues";
    // List all issues for a given organization assigned to the authenticated user
    public static final String GET_ORG_ISSUES = GitHubApi.GITHUB_HOST + "/orgs/%s/issues";

    // assigned: Issues assigned to you
    // created: Issues created by you
    // mentioned: Issues mentioning you
    // subscribed: Issues you're subscribed to updates for
    // all: All issues the authenticated user can see, regardless of participation or creation
    public static final String[] ISSUE_FILTER =
            new String[]{"assigned", "created", "mentioned", "subscribed", "all"};

    // Indicates the state of the issues to return. Can be either open, closed, or all. Default: open
    public static final String[] ISSUE_STATE =
            new String[]{"open", "closed", "all"};

    /**
     * List issues
     *
     * @param filter
     * @param state
     * @param callback
     */
    public void getIssueList(int filter, int state, final Callback callback) {
        if (filter < 0 || filter >= ISSUE_FILTER.length) {
            filter = 0;
        }
        if (state < 0 || state >= ISSUE_STATE.length) {
            state = 0;
        }

        final String url = GET_ALL_ISSUES +
                "?access_token=" + GitHubApi.GITHUB_ACCESS_TOKEN +
                "&filter=" + ISSUE_FILTER[filter] +
                "&state=" + ISSUE_STATE[state];
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
                    Type type = new TypeToken<List<IssueEntity>>() {
                    }.getType();
                    List<IssueEntity> issueList = SugarJson.fromJson(response.body().charStream(), type);
                    callback.onSuccess(issueList);
                }
            }
        });
    }


    public interface Callback {
        void onSuccess(List<IssueEntity> issueList);

        void onError(Exception e);
    }
}
