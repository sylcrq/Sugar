package com.syl.sugar.activity;

import java.util.List;

/**
 * 用户列表页面UI相关操作
 *
 * Created by shenyunlong on 2/5/16.
 */
public interface MainView {

    void showLoading();

    void hideLoading();

    void onItemClick(String user);

    void bindData(List<String> users);
}
