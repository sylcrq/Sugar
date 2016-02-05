package com.syl.sugar;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.user_data_list)
    ListView mUserDataList;
    @Bind(R.id.loading_bar)
    ProgressBar mLoadingBar;

    private UserListAdapter mAdapter;
    private Handler mHandler = new Handler();

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

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("Hello " + i);
        }

        mAdapter = new UserListAdapter(this);
        mAdapter.setData(data);
        mUserDataList.setAdapter(mAdapter);

        showLoading();
        hideData();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoading();
                showData();
            }
        }, 2000);
    }

    private void showLoading() {
        mLoadingBar.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        mLoadingBar.setVisibility(View.GONE);
    }

    private void showData() {
        mUserDataList.setVisibility(View.VISIBLE);
    }

    private void hideData() {
        mUserDataList.setVisibility(View.GONE);
    }
}
