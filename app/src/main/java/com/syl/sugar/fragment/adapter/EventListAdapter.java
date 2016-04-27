package com.syl.sugar.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.syl.domain.model.Events;
import com.syl.sugar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @see com.syl.sugar.fragment.EventsFragment
 * <p/>
 * Created by shenyunlong on 2/5/16.
 */
public class EventListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Events> mEventList = new ArrayList<>();

    public EventListAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<Events> userList) {
        mEventList.clear();
        mEventList.addAll(userList);
    }

    @Override
    public int getCount() {
        return (mEventList == null) ? 0 : mEventList.size();
    }

    @Override
    public Object getItem(int position) {
        return (mEventList == null) ? null : mEventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(mContext).inflate(R.layout.event_list_adapter_item, parent, false);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.user_avatar);
            viewHolder.userName = (TextView) convertView.findViewById(R.id.user_name);
            viewHolder.action = (TextView) convertView.findViewById(R.id.user_action);
            viewHolder.repoName = (TextView) convertView.findViewById(R.id.repo_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Events events = (Events) getItem(position);
        Picasso.with(mContext).load(events.getActor().getAvatar_url())
                .placeholder(R.drawable.github_mark_64px)
                .into(viewHolder.avatar);
        viewHolder.userName.setText(events.getActor().getLogin());
        viewHolder.action.setText(events.getPayload().getAction());
        viewHolder.repoName.setText(events.getRepo().getName());

        return convertView;
    }

    /**
     * ViewHolder
     */
    public static class ViewHolder {
        public ImageView avatar;
        public TextView userName;
        public TextView action;
        public TextView repoName;
    }
}
