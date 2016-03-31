package com.syl.sugar.fragment.presenter;

import android.os.Handler;
import com.syl.aop.annotation.DebugTrace;
import com.syl.sugar.fragment.HomeView;
import java.util.ArrayList;
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

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mHomeView.hideLoading();
                mHomeView.bindData(getUserList());
            }
        }, 2000);
    }

    /**
     * 生成测试数据
     *
     * @return
     */
    @DebugTrace
    private List<String> getUserList() {
        List<String> data = new ArrayList<>();
        for(int i=0; i<50; i++) {
            data.add("hello " + i);
        }

        return data;
    }
}
