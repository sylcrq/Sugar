package com.syl.sugar.presenter;

import com.syl.data.JobExecutor;
import com.syl.data.repository.GitHubDataRepository;
import com.syl.domain.interactor.GetSingleUserUseCase;
import com.syl.domain.interactor.GetSingleUserUseCaseImpl;
import com.syl.domain.model.User;
import com.syl.sugar.UIThread;
import com.syl.sugar.view.SingleUserView;

/**
 * 用户信息页面相关逻辑
 * <p>
 * Created by Shen Yunlong on 2016/05/05.
 */
public class SingleUserPresenter {

    private SingleUserView mView;

    public SingleUserPresenter(SingleUserView view) {
        this.mView = view;
    }

    /**
     * 加载用户信息
     *
     * @param userName
     */
    public void loadData(String userName) {
        GetSingleUserUseCase useCase =
                new GetSingleUserUseCaseImpl(GitHubDataRepository.getInstance(),
                        JobExecutor.getInstance(), UIThread.getInstance());

        useCase.execute(userName, new GetSingleUserUseCase.Callback() {
            @Override
            public void onSuccess(User user) {
                mView.onLoadSuccess(user);
            }

            @Override
            public void onError(Exception e) {
                mView.onLoadError();
            }
        });
    }
}
