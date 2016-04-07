package com.syl.sugar.fragment.presenter;

import android.os.Handler;
import android.os.Looper;
import com.syl.aop.annotation.DebugTrace;
import com.syl.data.repository.UserDataRepository;
import com.syl.interactor.GetUserListUseCase;
import com.syl.model.User;
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

        GetUserListUseCase useCase = new GetUserListUseCase(new UserDataRepository());
        useCase.getUserList(new GetUserListUseCase.GetUserListCallback() {
            @DebugTrace
            @Override
            public void onSuccess(final List<User> users) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mHomeView.hideLoading();
                        mHomeView.bindData(users);
                    }
                });
            }

            @DebugTrace
            @Override
            public void onError() {
                // TODO: 4/7/16
            }
        });
    }
}
