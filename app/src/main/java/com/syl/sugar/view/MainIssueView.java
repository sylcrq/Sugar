package com.syl.sugar.view;

import com.syl.domain.model.Issue;

import java.util.List;

/**
 * Created by Shen YunLong on 2016/07/27.
 */
public interface MainIssueView extends BaseView {

    void refreshComplete();

    void render(List<Issue> issues, boolean isLoadMore);

    void showToast(String message);
}
