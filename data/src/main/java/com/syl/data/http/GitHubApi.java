package com.syl.data.http;

import com.syl.data.model.EventEntity;
import com.syl.data.model.IssueEntity;
import com.syl.data.model.NotificationEntity;
import com.syl.data.model.RepositoryEntity;
import com.syl.data.model.UserEntity;

import java.util.List;

/**
 * GitHub API v3
 * <p>
 * Created by Shen YunLong on 2016/06/24.
 */
public interface GitHubApi {

    public static final String HOST = "https://api.github.com";

    interface GetDataCallback<T> {
        void onSuccess(T t);

        void onError(Exception e);
    }

    interface GetDataListCallback<T> {
        void onSuccess(List<T> list);

        void onError(Exception e);
    }

    /**
     * Events
     * <p>
     * This is a read-only API to the GitHub events. These events power
     * the various activity streams on the site.
     * <p>
     * Events are optimized for polling with the "ETag" header. If no new
     * events have been triggered, you will see a "304 Not Modified" response,
     * and your current rate limit will be untouched.
     * <p>
     * Events support pagination, however the per_page option is unsupported.
     * The fixed page size is 30 items. Fetching up to ten pages is supported,
     * for a total of 300 events.
     */

    /**
     * List public events
     */
    void getPublicEvents(GetDataListCallback<EventEntity> callback);

    /**
     * List repository events
     *
     * @param owner
     * @param repo
     */
    void getRepoEvents(String owner, String repo, GetDataListCallback<EventEntity> callback);

    /**
     * List public events for an organization
     *
     * @param org
     */
    void getPublicOrgEvents(String org, GetDataListCallback<EventEntity> callback);

    /**
     * List events that a user has received
     * <p>
     * These are events that you've received by watching repos and following users.
     * If you are authenticated as the given user, you will see private events.
     * Otherwise, you'll only see public events.
     *
     * @param username
     */
    void getUserReceivedEvents(String username, GetDataListCallback<EventEntity> callback);

    /**
     * List events performed by a user
     * <p>
     * If you are authenticated as the given user, you will see your private events.
     * Otherwise, you'll only see public events.
     *
     * @param username
     */
    void getUserPerformedEvents(String username, GetDataListCallback<EventEntity> callback);


    /**
     * Notifications
     * <p>
     * Notifications are optimized for polling with the "Last-Modified" header.
     * If there are no new notifications, you will see a "304 Not Modified" response,
     * leaving your current rate limit untouched.
     */

    /**
     * List your notifications
     * <p>
     * List all notifications for the current user, grouped by repository.
     */
    void getNotifications(GetDataListCallback<NotificationEntity> callback);

    /**
     * List your notifications in a repository
     * <p>
     * List all notifications for the current user.
     *
     * @param owner
     * @param repo
     */
    void getRepoNotifications(String owner, String repo, GetDataListCallback<NotificationEntity> callback);


    /**
     * Issues
     * <p>
     * In the past, pull requests and issues were more closely aligned than they are now.
     * As far as the API is concerned, every pull request is an issue, but not every issue is a pull request.
     */

    /**
     * List issues
     * <p>
     * List all issues assigned to the authenticated user across all visible
     * repositories including owned repositories, member repositories, and organization repositories:
     *
     * @param callback
     */
    void getIssues(GetDataListCallback<IssueEntity> callback);


    /**
     * List issues
     * <p>
     * List all issues across owned and member repositories assigned to the authenticated user:
     *
     * @param callback
     */
    void getUserIssues(GetDataListCallback<IssueEntity> callback);


    /**
     * List issues
     * <p>
     * List all issues for a given organization assigned to the authenticated user:
     *
     * @param org
     * @param callback
     */
    void getOrgIssues(String org, GetDataListCallback<IssueEntity> callback);


    /**
     * List issues for a repository
     *
     * @param owner
     * @param repo
     * @param callback
     */
    void getRepoIssues(String owner, String repo, GetDataListCallback<IssueEntity> callback);

    /**
     * Repositories
     */

    /**
     * List your repositories
     * <p>
     * List repositories that are accessible to the authenticated user.
     * This includes repositories owned by the authenticated user,
     * repositories where the authenticated user is a collaborator,
     * and repositories that the authenticated user has access to through an organization membership.
     *
     * @param callback
     */
    void getMyRepos(GetDataListCallback<RepositoryEntity> callback);


    /**
     * List user repositories
     * <p>
     * List public repositories for the specified user.
     *
     * @param username
     * @param callback
     */
    void getUserRepos(String username, GetDataListCallback<RepositoryEntity> callback);

    /**
     * Users
     *
     * Many of the resources on the users API provide a shortcut for getting information
     * about the currently authenticated user. If a request URL does not include a :username
     * parameter then the response will be for the logged in user (and you must pass
     * authentication information with your request).
     */

    /**
     * Get a single user
     *
     * @param username
     * @param callback
     */
    void getUser(String username, GetDataCallback<UserEntity> callback);

    /**
     * Get the authenticated user
     *
     * @param callback
     */
    void getCurrentUser(GetDataCallback<UserEntity> callback);
}
