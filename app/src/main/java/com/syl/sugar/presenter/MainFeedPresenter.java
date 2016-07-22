package com.syl.sugar.presenter;

import com.syl.data.JobExecutor;
import com.syl.data.repository.GitHubDataRepository;
import com.syl.domain.interactor.GetEventsUseCase;
import com.syl.domain.interactor.GetEventsUseCaseImpl;
import com.syl.domain.model.Event;
import com.syl.sugar.UIThread;
import com.syl.sugar.view.MainFeedView;
import com.syl.sugar.view.fragment.MainFeedFragment;

import java.util.List;

/**
 * 首页Feed页面
 *
 * @see MainFeedFragment
 * @see MainFeedView
 */
public class MainFeedPresenter extends BaseListPresenter {

    private MainFeedView mMainFeedView;

    public MainFeedPresenter(MainFeedView mainFeedView) {
        mMainFeedView = mainFeedView;
    }

    public void startLoadData(boolean showLoading) {
        mMainFeedView.showEmptyView(false);
        mMainFeedView.showErrorView(false);
        mMainFeedView.showLoadingView(showLoading);
        mMainFeedView.showContent(!showLoading);
    }

    public void onLoadOk(boolean showEmpty) {
        mMainFeedView.showLoadingView(false);
        mMainFeedView.showErrorView(false);
        mMainFeedView.showEmptyView(showEmpty);
        mMainFeedView.showContent(!showEmpty);
    }

    public void onLoadError(boolean showError) {
        mMainFeedView.showLoadingView(false);
        mMainFeedView.showEmptyView(false);
        mMainFeedView.showErrorView(showError);
        mMainFeedView.showContent(!showError);
    }

    @Override
    public void loadData(int page) {
        if (mMainFeedView instanceof MainFeedFragment) {
            final MainFeedFragment fragment = (MainFeedFragment) mMainFeedView;
            final boolean hasData = fragment.hasData();
            String username = fragment.getUserName();

            final boolean isLoadMore = page > 1;
            startLoadData(!hasData);

            GetEventsUseCase useCase =
                    new GetEventsUseCaseImpl(GitHubDataRepository.getInstance(),
                            JobExecutor.getInstance(),
                            UIThread.getInstance());

            useCase.execute(username, page, new GetEventsUseCase.Callback() {
                @Override
                public void onSuccess(List<Event> list) {
                    mMainFeedView.refreshComplete();
                    onLoadOk(!hasData && list.isEmpty());
                    mMainFeedView.render(list, isLoadMore);
                }

                @Override
                public void onError(Exception e) {
                    mMainFeedView.refreshComplete();
                    onLoadError(!hasData);
                    mMainFeedView.showToast("xxx");
                }
            });
        }
    }
}
