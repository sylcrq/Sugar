package com.syl.sugar.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.syl.sugar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenyunlong on 2/5/16.
 */
public class UserListAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mUserList = new ArrayList<>();

    public UserListAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<String> userList) {
        // copy data
        mUserList.clear();
        mUserList.addAll(userList);
    }

    @Override
    public int getCount() {
        return (mUserList == null) ? 0 : mUserList.size();
    }

    @Override
    public Object getItem(int position) {
        return (mUserList == null) ? null : mUserList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.user_list_adapter_item, parent, false);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mUserName = (TextView) convertView.findViewById(R.id.username);

        viewHolder.mUserName.setText((String) getItem(position));

        return convertView;
    }

    /**
     * ViewHolder
     */
    public static class ViewHolder {
        public TextView mUserName;
    }
}
