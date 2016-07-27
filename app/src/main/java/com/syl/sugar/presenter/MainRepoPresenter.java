package com.syl.sugar.presenter;

import com.syl.data.JobExecutor;
import com.syl.data.repository.GitHubDataRepository;
import com.syl.domain.interactor.GetMyRepoUseCase;
import com.syl.domain.interactor.GetMyRepoUseCaseImpl;
import com.syl.domain.interactor.GetStarredRepoUseCase;
import com.syl.domain.interactor.GetStarredRepoUseCaseImpl;
import com.syl.domain.model.Repository;
import com.syl.sugar.UIThread;
import com.syl.sugar.view.MainRepoView;
import com.syl.sugar.view.fragment.RepoListFragment;

import java.util.List;

/**
 * Created by Shen YunLong on 2016/07/26.
 */
public class MainRepoPresenter extends BaseListPresenter {

    public MainRepoPresenter(MainRepoView view) {
        super(view);
    }

    @Override
    public void loadData(int page) {
        if (mView != null && mView instanceof RepoListFragment) {
            int type = ((RepoListFragment) mView).getType();
            final boolean isLoadMore = page > 1;
            final boolean hasData = ((RepoListFragment) mView).hasData();

            startLoadData(!hasData);

            if (type == 0) {
                // Owned Repo
                GetMyRepoUseCase useCase =
                        new GetMyRepoUseCaseImpl(GitHubDataRepository.getInstance(),
                                JobExecutor.getInstance(), UIThread.getInstance());

                useCase.execute(new GetMyRepoUseCase.Callback() {
                    @Override
                    public void onSuccess(List<Repository> repositories) {
                        ((RepoListFragment) mView).refreshComplete();
                        onLoadOk(!hasData && repositories.isEmpty());
                        ((RepoListFragment) mView).render(repositories, isLoadMore);
                    }

                    @Override
                    public void onError(Exception e) {
                        ((RepoListFragment) mView).refreshComplete();
                        onLoadError(!hasData);
                        ((RepoListFragment) mView).showToast("" + e);
                    }
                });
            } else if (type == 1) {
                // Starred Repo
                GetStarredRepoUseCase useCase =
                        new GetStarredRepoUseCaseImpl(GitHubDataRepository.getInstance(),
                                JobExecutor.getInstance(), UIThread.getInstance());

                useCase.execute(new GetStarredRepoUseCase.Callback() {
                    @Override
                    public void onSuccess(List<Repository> repositories) {
                        ((RepoListFragment) mView).refreshComplete();
                        onLoadOk(!hasData && repositories.isEmpty());
                        ((RepoListFragment) mView).render(repositories, isLoadMore);
                    }

                    @Override
                    public void onError(Exception e) {
                        ((RepoListFragment) mView).refreshComplete();
                        onLoadError(!hasData);
                        ((RepoListFragment) mView).showToast("" + e);
                    }
                });
            } else {
                // Other
                ((RepoListFragment) mView).refreshComplete();
                onLoadOk(true);
            }
        }
    }

}
