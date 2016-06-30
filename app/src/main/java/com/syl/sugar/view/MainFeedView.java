package com.syl.sugar.view;

import com.syl.domain.model.Event;
import com.syl.sugar.presenter.MainFeedPresenter;
import com.syl.sugar.view.fragment.MainFeedFragment;

import java.util.List;

/**
 * 首页Feed页面
 *
 * @see MainFeedFragment
 * @see MainFeedPresenter
 */
public interface MainFeedView extends BaseView {

    void refreshComplete();

    void render(List<Event> events, boolean isLoadMore);

    void showToast(String message);
}
