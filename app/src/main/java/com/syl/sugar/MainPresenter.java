package com.syl.sugar;

import android.os.Handler;

import com.syl.aop.annotation.DebugTrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理用户列表页面相关业务逻辑
 *
 * Created by shenyunlong on 2/5/16.
 */
public class MainPresenter {

    private MainView mMainView;

    public MainPresenter(MainView mainView) {
        mMainView = mainView;
    }

    /**
     * 加载数据
     */
    public void loadData() {
        mMainView.showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mMainView.hideLoading();
                mMainView.bindData(getUserList());
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
