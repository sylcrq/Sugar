package com.syl.sugar.view.adapter;

import android.view.View;

import com.syl.domain.model.Issue;

/**
 * Created by Shen YunLong on 2016/07/26.
 */
public class IssueListAdapter extends BaseListAdapter<Issue> {

    @Override
    public ViewHolder createViewHolder() {
        return new ViewHolder();
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initView(View view, BaseViewHolder viewHolder) {

    }

    @Override
    public void bindData(BaseViewHolder viewHolder, int position) {

    }

    public static class ViewHolder extends BaseViewHolder {

    }

}
