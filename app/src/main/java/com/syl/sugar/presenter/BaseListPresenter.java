package com.syl.sugar.presenter;

import com.syl.sugar.view.BaseView;

/**
 * Created by Shen YunLong on 2016/07/22.
 */
public abstract class BaseListPresenter {

    protected BaseView mView;

    public BaseListPresenter(BaseView view) {
        mView = view;
    }

    public abstract void loadData(int page);

    public void startLoadData(boolean showLoading) {
        mView.showEmptyView(false);
        mView.showErrorView(false);
        mView.showLoadingView(showLoading);
        mView.showContent(!showLoading);
    }

    public void onLoadOk(boolean showEmpty) {
        mView.showLoadingView(false);
        mView.showErrorView(false);
        mView.showEmptyView(showEmpty);
        mView.showContent(!showEmpty);
    }

    public void onLoadError(boolean showError) {
        mView.showLoadingView(false);
        mView.showEmptyView(false);
        mView.showErrorView(showError);
        mView.showContent(!showError);
    }

}
