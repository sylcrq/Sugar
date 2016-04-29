package com.syl.sugar.view.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.syl.sugar.NavigationTool;
import com.syl.sugar.R;
import com.syl.sugar.view.fragment.SingleUserFragment;

/**
 * 用户信息页面
 */
public class SingleUserActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user);

        fragmentManager = getSupportFragmentManager();

        Intent intent = getIntent();
        if (intent != null) {
            userName = intent.getStringExtra(NavigationTool.START_SINGLE_USER_KEY_NAME);
        }

        initFragment();
    }

    public void initFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, SingleUserFragment.newInstance(userName));
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
