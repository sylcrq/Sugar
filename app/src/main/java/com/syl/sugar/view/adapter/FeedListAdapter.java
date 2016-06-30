package com.syl.sugar.view.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.syl.basecore.SugarTime;
import com.syl.basecore.imageLoader.SugarLoader;
import com.syl.domain.model.event.CreateEvent;
import com.syl.domain.model.Event;
import com.syl.domain.model.event.ForkEvent;
import com.syl.domain.model.event.MemberEvent;
import com.syl.domain.model.event.WatchEvent;
import com.syl.sugar.R;
import com.syl.sugar.view.fragment.MainFeedFragment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @see MainFeedFragment
 * <p/>
 * Created by Shen YunLong on 2016/05/02.
 */
public class FeedListAdapter extends BaseAdapter {

    public static final String SPACE_CHARACTER = "\u00A0";

    private Context mContext;
    private List<Event> mEventList = new ArrayList<>();

    public FeedListAdapter(Context context) {
        mContext = context;
    }

    /**
     * 追加数据
     *
     * @param list
     */
    public void addData(List<Event> list) {
        mEventList.addAll(list);
    }

    /**
     * 重置数据
     *
     * @param list
     */
    public void setData(List<Event> list) {
        mEventList.clear();
        mEventList.addAll(list);
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.feed_list_adapter_item, parent, false);
            viewHolder.mAvatar = (CircleImageView) convertView.findViewById(R.id.event_user_avatar);
            viewHolder.mContent = (TextView) convertView.findViewById(R.id.event_content);
            viewHolder.mTime = (TextView) convertView.findViewById(R.id.event_time);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        bindData(viewHolder, position);

        return convertView;
    }

    public void bindData(ViewHolder viewHolder, int position) {
        Event event = (Event) getItem(position);

        SugarLoader.loadImage(mContext, event.getActor().getAvatar_url(), viewHolder.mAvatar, R.drawable.github_mark_120px);
        viewHolder.mTime.setText(SugarTime.convertTimeAgo(event.getCreated_at()));
        viewHolder.mContent.setText(setUpContent(event));
    }

    public SpannableStringBuilder setUpContent(Event event) {
        final String actor;
        final String action;
        final String var_1;
        final String to;
        final String var_2;

        if (event instanceof WatchEvent) {
            actor = event.getActor().getLogin();
            action = "starred";
            var_1 = event.getRepo().getName();
            to = null;
            var_2 = null;
        } else if (event instanceof CreateEvent) {
            actor = event.getActor().getLogin();
            action = "created " + SPACE_CHARACTER + ((CreateEvent) event).getPayload().getRef_type();
            var_1 = event.getRepo().getName();
            to = null;
            var_2 = null;
        } else if (event instanceof ForkEvent) {
            actor = event.getActor().getLogin();
            action = "forked";
            var_1 = event.getRepo().getName();
            to = "to";
            var_2 = ((ForkEvent) event).getPayload().getForkee().getFull_name();
        } else if (event instanceof MemberEvent) {
            actor = event.getActor().getLogin();
            action = ((MemberEvent) event).getPayload().getAction();
            var_1 = ((MemberEvent) event).getPayload().getMember().getLogin();
            to = "to";
            var_2 = event.getRepo().getName();
        } else {
            // TODO: 16/5/16
            actor = null;
            action = null;
            var_1 = null;
            to = null;
            var_2 = null;
        }

        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append(actor != null ? actor : "");
        builder.append(SPACE_CHARACTER);
        builder.append(action != null ? action : "");
        builder.append(SPACE_CHARACTER);
        builder.append(var_1 != null ? var_1 : "");
        builder.append(SPACE_CHARACTER);
        builder.append(to != null ? to : "");
        builder.append(SPACE_CHARACTER);
        builder.append(var_2 != null ? var_2 : "");

        if (actor != null) {
            builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.text_color_blue)),
                    0,
                    actor.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            if (action != null) {
                builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.text_color)),
                        actor.length() + 1,
                        actor.length() + action.length() + 1,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                if (var_1 != null) {
                    builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.text_color_blue)),
                            actor.length() + action.length() + 2,
                            actor.length() + action.length() + var_1.length() + 2,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                    if (to != null) {
                        builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.text_color)),
                                actor.length() + action.length() + var_1.length() + 3,
                                actor.length() + action.length() + var_1.length() + to.length() + 3,
                                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        if (var_2 != null) {
                            builder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.text_color_blue)),
                                    actor.length() + action.length() + var_1.length() + to.length() + 4,
                                    builder.length(),
                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                    }
                }
            }
        }

        return builder;
    }

    /**
     * ViewHolder
     */
    public static class ViewHolder {
        public CircleImageView mAvatar;
        public TextView mContent;
        public TextView mTime;
    }
}
