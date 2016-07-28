package com.syl.sugar.view.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.syl.domain.model.Notification;
import com.syl.sugar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Notification列表Adapter
 * <p/>
 * Created by Shen YunLong on 2016/07/26.
 */
public class NotificationListAdapter extends BaseAdapter {

    public static final int TOTAL_TYPE_COUNT = 2;

    public static final int TYPE_REPO_TITLE = 0;
    public static final int TYPE_NOTIFICATION_INFO = TYPE_REPO_TITLE + 1;

    private Context mContext;
    private List<Notification> mData = new ArrayList<>();
    private SparseArray<List<Notification>> mMap = new SparseArray<>();

    public NotificationListAdapter(Context context) {
        mContext = context;
    }

    public void addData(List<Notification> notifications) {
        if (notifications == null) {
            return;
        }

        updateData(notifications);
    }

    public void setData(List<Notification> notifications) {
        mData.clear();
        mMap.clear();

        if (notifications == null) {
            return;
        }

        updateData(notifications);
    }

    /**
     * 更新数据
     *
     * @param notifications
     */
    private void updateData(List<Notification> notifications) {
        for (Notification notification : notifications) {
            // 根据Repo Id进行分类
            int id = notification.getRepository().getId();

            if (mMap.get(id, null) == null) {
                List<Notification> list = new ArrayList<>();
                list.add(notification);
                mMap.put(id, list);
            } else {
                mMap.get(id).add(notification);
            }
        }

        mData.clear();

        for (int i = 0; i < mMap.size(); i++) {
            int key = mMap.keyAt(i);
            List<Notification> list = mMap.get(key);

            if (list != null && list.size() > 0) {
                // FIXME: 16/7/28 生成一个假的通知对象
                Notification notification = new Notification();
                notification.setId("-1");
                Notification.SubjectBean subject = new Notification.SubjectBean();
                subject.setTitle(list.get(0).getRepository().getFull_name());
                notification.setSubject(subject);

                mData.add(notification);
                mData.addAll(list);
            }
        }
    }

    @Override
    public int getCount() {
        return (mData != null) ? mData.size() : 0;
    }

    @Override
    public Notification getItem(int position) {
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
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = getItemView(position, parent);
            if (convertView == null) {
                return null;
            }

            viewHolder = new ViewHolder();
            initView(position, convertView, viewHolder);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        bindData(position, viewHolder);

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        Notification notification = getItem(position);

        if (notification.getId().equals("-1")) {
            return TYPE_REPO_TITLE;
        } else {
            return TYPE_NOTIFICATION_INFO;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TOTAL_TYPE_COUNT;
    }

    private View getItemView(int position, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case TYPE_REPO_TITLE:
                return LayoutInflater.from(mContext).inflate(R.layout.notification_list_adapter_item_2, parent, false);
            case TYPE_NOTIFICATION_INFO:
                return LayoutInflater.from(mContext).inflate(R.layout.notification_list_adapter_item, parent, false);
            default:
                return null;
        }
    }

    private void initView(int position, View view, ViewHolder viewHolder) {
        switch (getItemViewType(position)) {
            case TYPE_REPO_TITLE:
                viewHolder.mRepoTitle = (TextView) view.findViewById(R.id.notification_repo_title);
                break;
            case TYPE_NOTIFICATION_INFO:
                viewHolder.mIcon = (ImageView) view.findViewById(R.id.notification_icon);
                viewHolder.mTitle = (TextView) view.findViewById(R.id.notification_title);
                break;
            default:
                break;
        }
    }

    private void bindData(int position, ViewHolder viewHolder) {
        Notification notification = getItem(position);

        switch (getItemViewType(position)) {
            case TYPE_REPO_TITLE:
                viewHolder.mRepoTitle.setText(notification.getSubject().getTitle());
                break;
            case TYPE_NOTIFICATION_INFO:
                viewHolder.mTitle.setText(notification.getSubject().getTitle());
                break;
            default:
                break;
        }
    }

    public static class ViewHolder {
        public TextView mRepoTitle;
        public ImageView mIcon;
        public TextView mTitle;
    }
}
