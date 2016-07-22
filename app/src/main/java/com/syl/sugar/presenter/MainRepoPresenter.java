package com.syl.sugar.presenter;

import com.syl.sugar.view.MainRepoView;

/**
 * Created by Shen YunLong on 2016/07/26.
 */
public class MainRepoPresenter extends BaseListPresenter {

    private MainRepoView mMainRepoView;

    public MainRepoPresenter(MainRepoView mainRepoView) {
        mMainRepoView = mainRepoView;
    }

    @Override
    public void loadData(int page) {

    }
}
