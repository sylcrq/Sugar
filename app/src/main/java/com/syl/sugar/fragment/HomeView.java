package com.syl.sugar.fragment;

import com.syl.model.User;

import java.util.List;

/**
 * 用户列表页面UI相关操作
 *
 * Created by shenyunlong on 2/5/16.
 */
public interface HomeView {

    void showLoading();

    void hideLoading();

    void onItemClick(int userId);

    void bindData(List<User> users);

    void showToast(String content);
}
