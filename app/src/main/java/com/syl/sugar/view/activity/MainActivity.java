package com.syl.sugar.view.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.syl.aop.annotation.DebugTrace;
import com.syl.sugar.R;
import com.syl.sugar.view.fragment.FavoriteFragment;
import com.syl.sugar.view.fragment.EventsFragment;
import com.syl.sugar.view.fragment.NearbyFragment;

import butterknife.ButterKnife;

/**
 * MainActivity
 */
public class MainActivity extends AppCompatActivity implements EventsFragment.OnFragmentInteractionListener {

    private BottomBar mBottomBar;

    @DebugTrace
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.bottombar_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.bottom_bar_item_1:
                        switchToFragment(0);
                        break;
                    case R.id.bottom_bar_item_2:
                        switchToFragment(1);
                        break;
                    case R.id.bottom_bar_item_3:
                        switchToFragment(2);
                        break;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.bottom_bar_item_1:
//                        showToast("ReSelect Recents");
                        break;
                    case R.id.bottom_bar_item_2:
//                        showToast("ReSelect Favorite");
                        break;
                    case R.id.bottom_bar_item_3:
//                        showToast("ReSelect Nearby");
                        break;
                }
            }
        });
//        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
//        mBottomBar.mapColorForTab(1, 0xFF5D4037);
//        mBottomBar.mapColorForTab(2, "#7B1FA2");

        switchToFragment(0);

//        TaskManager.getInstance().start(new DbTask());
//        TaskManager.getInstance().start(new DbTask());
//        TaskManager.getInstance().start(new DbTask());
//        TaskManager.getInstance().start(new DbTask());
//        TaskManager.getInstance().start(new DbTask());
//        TaskManager.getInstance().start(new DbTask());
    }

    private void switchToFragment(int id) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (id) {
            case 0:
                transaction.replace(R.id.container, EventsFragment.newInstance("sylcrq"), "Home");
                break;
            case 1:
                transaction.replace(R.id.container, new FavoriteFragment(), "Favorite");
                break;
            case 2:
                transaction.replace(R.id.container, new NearbyFragment(), "Nearby");
                break;
        }

        transaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        mBottomBar.onSaveInstanceState(outState);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // TODO: 3/31/16
    }
}
