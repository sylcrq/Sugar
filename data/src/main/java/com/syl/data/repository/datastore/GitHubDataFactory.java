package com.syl.data.repository.datastore;

/**
 * Created by shenyunlong on 16/4/27.
 */
public class GitHubDataFactory {

    public static CloudEventsDataStore createEventsDataStore() {
        CloudEventsDataStore dataStore = new CloudEventsDataStore();
        return dataStore;
    }

    public static CloudUserDataStore createUserDataStore() {
        CloudUserDataStore dataStore = new CloudUserDataStore();
        return dataStore;
    }
}
