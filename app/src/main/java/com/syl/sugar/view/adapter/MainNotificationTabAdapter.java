package com.syl.sugar.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.syl.sugar.R;
import com.syl.sugar.view.fragment.NotificationListFragment;

/**
 * Created by Shen YunLong on 2016/06/30.
 */
public class MainNotificationTabAdapter extends SmartFragmentStatePagerAdapter {

    public static final int[] MAIN_NOTIFICATION_TABS = new int[]{
            R.string.main_notification_tab_unread,
            R.string.main_notification_tab_all
    };

    private Context mContext;
    private FragmentManager mFragmentManager;

    public MainNotificationTabAdapter(Context context, FragmentManager fm) {
        super(fm);

        this.mContext = context;
        this.mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        if (position >= 0 && position < getCount()) {
            return NotificationListFragment.newInstance("", "");
        }

        return null;
    }

    @Override
    public int getCount() {
        return MAIN_NOTIFICATION_TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position >= 0 && position < getCount()) {
            return mContext.getString(MAIN_NOTIFICATION_TABS[position]);
        }

        return null;
    }
}
