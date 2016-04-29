package com.syl.sugar.view;

import com.syl.domain.model.User;

/**
 * Created by shenyunlong on 16/5/5.
 */
public interface SingleUserView {

    void onLoadSuccess(User user);

    void onLoadError();
}
