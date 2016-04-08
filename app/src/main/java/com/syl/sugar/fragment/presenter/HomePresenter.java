package com.syl.sugar.fragment.presenter;

import com.syl.data.JobExecutor;
import com.syl.data.repository.UserDataRepository;
import com.syl.interactor.GetUserListUseCase;
import com.syl.interactor.GetUserListUseCaseImpl;
import com.syl.model.User;
import com.syl.sugar.UIThread;
import com.syl.sugar.fragment.HomeView;
import java.util.List;

/**
 * 处理用户列表页面相关业务逻辑
 *
 * Created by shenyunlong on 2/5/16.
 */
public class HomePresenter {

    private HomeView mHomeView;

    public HomePresenter(HomeView homeView) {
        mHomeView = homeView;
    }

    /**
     * 加载数据
     */
    public void loadData() {
        mHomeView.showLoading();

        GetUserListUseCase useCase = new GetUserListUseCaseImpl(UserDataRepository.getInstance(),
                JobExecutor.getInstance(),
                UIThread.getInstance());

        useCase.execute(new GetUserListUseCase.Callback() {
            @Override
            public void onSuccess(List<User> users) {
                mHomeView.hideLoading();
                mHomeView.bindData(users);
            }

            @Override
            public void onError() {
                // TODO: 4/8/16
            }
        });
    }
}
