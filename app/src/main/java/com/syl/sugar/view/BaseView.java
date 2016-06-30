package com.syl.sugar.view;

/**
 * Created by Shen YunLong on 2016/06/30.
 */
public interface BaseView {

    void showLoadingView(boolean show);

    void showErrorView(boolean show);

    void showEmptyView(boolean show);

    void showContent(boolean show);
}
