package com.syl.sugar.presenter;

import android.os.Handler;
import android.text.TextUtils;

import com.syl.sugar.view.LoginView;

/**
 * 处理登录页面相关业务逻辑
 *
 * Created by shenyunlong on 2/5/16.
 */
public class LoginPresenter {

    private LoginView mLoginView;

    public LoginPresenter(LoginView loginView) {
        mLoginView = loginView;
    }

    /**
     * 登录逻辑
     *
     * @param username
     * @param password
     */
    public void doLogin(String username, String password) {
        mLoginView.showLoading();

        if(TextUtils.isEmpty(username)) {
            mLoginView.hideLoading();
            mLoginView.onUserNameError();
            return;
        }

        if(TextUtils.isEmpty(password)) {
            mLoginView.hideLoading();
            mLoginView.onPasswordError();
            return;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoginView.hideLoading();
                mLoginView.jump2MainActivity();
            }
        }, 2000);

    }

}
