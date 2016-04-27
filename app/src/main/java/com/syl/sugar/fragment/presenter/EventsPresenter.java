package com.syl.sugar.fragment.presenter;

import com.syl.data.JobExecutor;
import com.syl.data.repository.GitHubDataRepository;
import com.syl.data.repository.UserDataRepository;
import com.syl.domain.interactor.GetEventsUseCase;
import com.syl.domain.interactor.GetEventsUseCaseImpl;
import com.syl.domain.interactor.GetUserListUseCase;
import com.syl.domain.interactor.GetUserListUseCaseImpl;
import com.syl.domain.model.Events;
import com.syl.domain.model.User;
import com.syl.sugar.UIThread;
import com.syl.sugar.fragment.EventsView;

import java.util.List;

/**
 * 处理用户列表页面相关业务逻辑
 * <p/>
 * Created by shenyunlong on 2/5/16.
 */
public class EventsPresenter {

    private EventsView mEventsView;

    public EventsPresenter(EventsView eventsView) {
        mEventsView = eventsView;
    }

    /**
     * 加载数据
     */
    public void loadData(String userName) {
        mEventsView.showLoading();

        GetEventsUseCase useCase =
                new GetEventsUseCaseImpl(GitHubDataRepository.getInstance(),
                        JobExecutor.getInstance(),
                        UIThread.getInstance());

        useCase.execute(userName, new GetEventsUseCase.Callback() {
            @Override
            public void onSuccess(List<Events> list) {
                mEventsView.hideLoading();
                mEventsView.bindData(list);
            }

            @Override
            public void onError(Exception e) {
                mEventsView.hideLoading();
            }
        });
    }
}
