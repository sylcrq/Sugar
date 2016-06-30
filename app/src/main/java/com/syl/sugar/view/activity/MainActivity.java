package com.syl.sugar.view.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.syl.aop.annotation.DebugTrace;
import com.syl.sugar.R;
import com.syl.sugar.view.fragment.MainMoreFragment;
import com.syl.sugar.view.fragment.MainNotificationFragment;
import com.syl.sugar.view.fragment.MainRepoFragment;
import com.syl.sugar.view.fragment.MainFeedFragment;
import com.syl.sugar.view.fragment.MainIssueFragment;

import butterknife.ButterKnife;

/**
 * 首页: 包含Feed, Repo, Notification, Issue, More五个子页面
 */
public class MainActivity extends AppCompatActivity {

    public static final int MAIN_TAB_NEWS = 0;
    public static final int MAIN_TAB_REPO = 1;
    public static final int MAIN_TAB_NOTIFICATION = 2;
    public static final int MAIN_TAB_ISSUE = 3;
    public static final int MAIN_TAB_MORE = 4;

    private BottomBar mBottomBar;
    private FragmentManager mFragmentManager;

    @DebugTrace
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFragmentManager = getSupportFragmentManager();
        initView(savedInstanceState);
    }

    private void initView(Bundle savedInstanceState) {

        mBottomBar = BottomBar.attach(this, savedInstanceState);
//        mBottomBar.useFixedMode();
        mBottomBar.noNavBarGoodness();

        mBottomBar.setItems(R.menu.bottombar_menu);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.bottom_bar_item_1:
                        switchToFragment(MAIN_TAB_NEWS);
                        break;
                    case R.id.bottom_bar_item_2:
                        switchToFragment(MAIN_TAB_REPO);
                        break;
                    case R.id.bottom_bar_item_3:
                        switchToFragment(MAIN_TAB_NOTIFICATION);
                        break;
                    case R.id.bottom_bar_item_4:
                        switchToFragment(MAIN_TAB_ISSUE);
                        break;
                    case R.id.bottom_bar_item_5:
                        switchToFragment(MAIN_TAB_MORE);
                        break;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
            }
        });

        mBottomBar.mapColorForTab(MAIN_TAB_NEWS, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(MAIN_TAB_REPO, 0xFF5D4037);
        mBottomBar.mapColorForTab(MAIN_TAB_NOTIFICATION, "#7B1FA2");
        mBottomBar.mapColorForTab(MAIN_TAB_ISSUE, "#FF5252");
        mBottomBar.mapColorForTab(MAIN_TAB_MORE, "#FF9800");
    }

    private void switchToFragment(int id) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        switch (id) {
            case MAIN_TAB_NEWS:
                transaction.replace(R.id.container, MainFeedFragment.newInstance("sylcrq"));
                break;
            case MAIN_TAB_REPO:
                transaction.replace(R.id.container, MainRepoFragment.newInstance(""));
                break;
            case MAIN_TAB_NOTIFICATION:
                transaction.replace(R.id.container, MainNotificationFragment.newInstance(""));
                break;
            case MAIN_TAB_ISSUE:
                transaction.replace(R.id.container, MainIssueFragment.newInstance(""));
                break;
            case MAIN_TAB_MORE:
                transaction.replace(R.id.container, MainMoreFragment.newInstance(""));
                break;
        }

        transaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mBottomBar.onSaveInstanceState(outState);
    }
}
