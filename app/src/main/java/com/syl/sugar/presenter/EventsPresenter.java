package com.syl.sugar.presenter;

import com.syl.data.JobExecutor;
import com.syl.data.repository.GitHubDataRepository;
import com.syl.domain.interactor.GetEventsUseCase;
import com.syl.domain.interactor.GetEventsUseCaseImpl;
import com.syl.domain.model.Event;
import com.syl.sugar.UIThread;
import com.syl.sugar.view.EventsView;

import java.util.List;

/**
 * 首页Timeline MVP
 * <p/>
 * Created by Shen YunLong on 2016/02/05.
 */
public class EventsPresenter {

    private EventsView mEventsView;

    public EventsPresenter(EventsView eventsView) {
        mEventsView = eventsView;
    }

    public void startLoadData(boolean showLoading) {
        mEventsView.showEmptyView(false);
        mEventsView.showErrorView(false);
        mEventsView.showLoadingView(showLoading);
        mEventsView.showDataView(!showLoading);
    }

    public void onLoadOk(boolean showEmpty) {
        mEventsView.showLoadingView(false);
        mEventsView.showErrorView(false);
        mEventsView.showEmptyView(showEmpty);
        mEventsView.showDataView(!showEmpty);
    }

    public void onLoadError(boolean showError) {
        mEventsView.showLoadingView(false);
        mEventsView.showEmptyView(false);
        mEventsView.showErrorView(showError);
        mEventsView.showDataView(!showError);
    }

    /**
     * 加载数据
     *
     * @param userName
     * @param page
     * @param hasData
     */
    public void loadData(String userName, int page, final boolean hasData) {
        final boolean isLoadMore = page > 1;
        startLoadData(!hasData);

        GetEventsUseCase useCase =
                new GetEventsUseCaseImpl(GitHubDataRepository.getInstance(),
                        JobExecutor.getInstance(),
                        UIThread.getInstance());

        useCase.execute(userName, page, new GetEventsUseCase.Callback() {
            @Override
            public void onSuccess(List<Event> list) {
                mEventsView.refreshComplete();
                onLoadOk(!hasData && list.isEmpty());
                mEventsView.bindData(list, isLoadMore);
            }

            @Override
            public void onError(Exception e) {
                mEventsView.refreshComplete();
                onLoadError(!hasData);
                mEventsView.showToast("xxx");
            }
        });
    }
}
