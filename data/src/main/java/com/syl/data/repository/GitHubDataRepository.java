package com.syl.data.repository;

import com.syl.data.mapper.EventMapper;
import com.syl.data.mapper.IssueMapper;
import com.syl.data.mapper.NotificationMapper;
import com.syl.data.mapper.RepositoryMapper;
import com.syl.data.mapper.UserMapper;
import com.syl.data.model.EventEntity;
import com.syl.data.model.IssueEntity;
import com.syl.data.model.NotificationEntity;
import com.syl.data.model.RepositoryEntity;
import com.syl.data.model.UserEntity;
import com.syl.data.repository.datastore.EventsDataStore;
import com.syl.data.repository.datastore.GitHubDataFactory;
import com.syl.data.repository.datastore.IssuesDataStore;
import com.syl.data.repository.datastore.NotificationsDataStore;
import com.syl.data.repository.datastore.RepositoriesDataStore;
import com.syl.data.repository.datastore.UserDataStore;
import com.syl.domain.model.Event;
import com.syl.domain.model.Issue;
import com.syl.domain.model.Notification;
import com.syl.domain.model.Repository;
import com.syl.domain.model.User;
import com.syl.domain.repository.GitHubRepository;

import java.util.List;

/**
 * 实现Domain层接口
 *
 * @see GitHubRepository
 * <p/>
 * Created by Shen YunLong on 2016/4/27.
 */
public class GitHubDataRepository implements GitHubRepository {

    private static GitHubDataRepository mInstance;

    private GitHubDataRepository() {
    }

    // 单例
    public static GitHubDataRepository getInstance() {
        if (mInstance == null) {
            mInstance = new GitHubDataRepository();
        }

        return mInstance;
    }

    @Override
    public void getUserReceivedEvents(String username, final GetDataListCallback<Event> callback) {
        EventsDataStore dataStore = GitHubDataFactory.createEventsDataStore();
        dataStore.getUserReceivedEvents(username, new EventsDataStore.GetEventsCallback() {
            @Override
            public void onSuccess(List<EventEntity> list) {
                if (callback != null) {
                    callback.onSuccess(EventMapper.transform(list));
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
    public void getUser(String username, final GetDataCallback<User> callback) {
        UserDataStore dataStore = GitHubDataFactory.createUserDataStore();
        dataStore.getUser(username, new UserDataStore.GetUserCallback() {
            @Override
            public void onSuccess(UserEntity user) {
                if (callback != null) {
                    callback.onSuccess(UserMapper.transform(user));
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
    public void getCurrentUser(final GetDataCallback<User> callback) {
        UserDataStore dataStore = GitHubDataFactory.createUserDataStore();
        dataStore.getCurrentUser(new UserDataStore.GetUserCallback() {
            @Override
            public void onSuccess(UserEntity user) {
                if (callback != null) {
                    callback.onSuccess(UserMapper.transform(user));
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
    public void getUserIssues(final GetDataListCallback<Issue> callback) {
        IssuesDataStore dataStore = GitHubDataFactory.createIssuesDataStore();
        dataStore.getUserIssues(new IssuesDataStore.GetIssuesCallback() {
            @Override
            public void onSuccess(List<IssueEntity> list) {
                if (callback != null) {
                    callback.onSuccess(IssueMapper.transform(list));
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
    public void getNotifications(boolean all, boolean participating, final GetDataListCallback<Notification> callback) {
        NotificationsDataStore dataStore = GitHubDataFactory.createNotificationsDataStore();
        dataStore.getNotifications(all, participating, new NotificationsDataStore.GetNotificationsCallback() {
            @Override
            public void onSuccess(List<NotificationEntity> list) {
                if (callback != null) {
                    callback.onSuccess(NotificationMapper.transform(list));
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
    public void getMyRepos(final GetDataListCallback<Repository> callback) {
        RepositoriesDataStore dataStore = GitHubDataFactory.createRepositoriesDataStore();
        dataStore.getMyRepos(new RepositoriesDataStore.GetReposCallback() {
            @Override
            public void onSuccess(List<RepositoryEntity> list) {
                if (callback != null) {
                    callback.onSuccess(RepositoryMapper.transform(list));
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
    public void getStarredRepos(final GetDataListCallback<Repository> callback) {
        RepositoriesDataStore dataStore = GitHubDataFactory.createRepositoriesDataStore();
        dataStore.getStarredRepos(new RepositoriesDataStore.GetReposCallback() {
            @Override
            public void onSuccess(List<RepositoryEntity> list) {
                if (callback != null) {
                    callback.onSuccess(RepositoryMapper.transform(list));
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
