package com.syl.sugar.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shen YunLong on 2016/07/27.
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mData = new ArrayList<>();

    public void addData(List<T> list) {
        mData.addAll(list);
    }

    public void setData(List<T> list) {
        mData.clear();
        mData.addAll(list);
    }

    @Override
    public int getCount() {
        return (mData == null) ? 0 : mData.size();
    }

    @Override
    public T getItem(int position) {
        if (position >= 0 && position < getCount()) {
            return mData.get(position);
        }

        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = createViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(getLayoutId(), parent, false);
            initView(convertView, viewHolder);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (BaseViewHolder) convertView.getTag();
        }

        bindData(viewHolder, position);

        return convertView;
    }

    public abstract BaseViewHolder createViewHolder();

    public abstract int getLayoutId();

    public abstract void initView(View view, BaseViewHolder viewHolder);

    public abstract void bindData(BaseViewHolder viewHolder, int position);

    public static abstract class BaseViewHolder {
        // empty
    }
}
