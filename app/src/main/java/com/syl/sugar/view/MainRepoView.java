package com.syl.sugar.view;

import com.syl.domain.model.Repository;

import java.util.List;

/**
 * Created by Shen YunLong on 2016/07/27.
 */
public interface MainRepoView extends BaseView {

    void refreshComplete();

    void render(List<Repository> repositories, boolean isLoadMore);

    void showToast(String message);
}
