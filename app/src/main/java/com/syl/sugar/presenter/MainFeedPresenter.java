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

    public MainFeedPresenter(MainFeedView view) {
        super(view);
    }

    @Override
    public void loadData(int page) {
        if (mView != null && mView instanceof MainFeedFragment) {
            final MainFeedFragment fragment = (MainFeedFragment) mView;
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
                    ((MainFeedFragment) mView).refreshComplete();
                    onLoadOk(!hasData && list.isEmpty());
                    ((MainFeedFragment) mView).render(list, isLoadMore);
                }

                @Override
                public void onError(Exception e) {
                    ((MainFeedFragment) mView).refreshComplete();
                    onLoadError(!hasData);
                    ((MainFeedFragment) mView).showToast("" + e);
                }
            });
        }
    }
}
