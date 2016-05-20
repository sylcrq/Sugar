package com.syl.sugar.view;

import com.syl.domain.model.Event;

import java.util.List;

/**
 * 首页Timeline MVP
 * <p/>
 * Created by Shen YunLong on 2016/02/05.
 */
public interface EventsView {

    void showLoadingView(boolean show);

    void showErrorView(boolean show);

    void showEmptyView(boolean show);

    void showDataView(boolean show);

//    void autoRefresh();

    void refreshComplete();

    void bindData(List<Event> events, boolean isLoadMore);

    void showToast(String message);
}
