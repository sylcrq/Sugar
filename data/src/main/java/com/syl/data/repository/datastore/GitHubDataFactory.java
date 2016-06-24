package com.syl.data.repository.datastore;

/**
 * 工厂模式
 * <p/>
 * Created by Shen YunLong on 2016/04/27.
 */
public class GitHubDataFactory {

    public static EventsDataStore createEventsDataStore() {
        return new CloudEventsDataStore();
    }

    public static IssuesDataStore createIssuesDataStore() {
        return new CloudIssuesDataStore();
    }

    public static UserDataStore createUserDataStore() {
        return new CloudUserDataStore();
    }

    public static NotificationsDataStore createNotificationsDataStore() {
        return new CloudNotificationsDataStore();
    }

    public static RepositoriesDataStore createRepositoriesDataStore() {
        return new CloudRepositoriesDataStore();
    }
}
