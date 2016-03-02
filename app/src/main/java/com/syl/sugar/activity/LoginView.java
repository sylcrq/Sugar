package com.syl.sugar.activity;

/**
 * 登录页面UI相关操作
 *
 * Created by shenyunlong on 2/5/16.
 */
public interface LoginView {

    void showLoading();

    void hideLoading();

    void onUserNameError();

    void onPasswordError();

    void jump2MainActivity();
}
