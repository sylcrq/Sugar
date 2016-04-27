package com.syl.sugar.fragment;

import com.syl.domain.model.Events;
import com.syl.domain.model.User;

import java.util.List;

/**
 * 用户列表页面UI相关操作
 * <p/>
 * Created by shenyunlong on 2/5/16.
 */
public interface EventsView {

    void showLoading();

    void hideLoading();

    void onItemClick(int userId);

    void bindData(List<Events> eventList);

    void showToast(String content);
}
