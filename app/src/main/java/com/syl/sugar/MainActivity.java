package com.syl.sugar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

    @Bind(R.id.user_data_list)
    ListView mUserDataList;
    @Bind(R.id.loading_bar)
    ProgressBar mLoadingBar;

    private UserListAdapter mAdapter;
    private MainPresenter mMainPresenter;

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

        mAdapter = new UserListAdapter(this);
        mUserDataList.setAdapter(mAdapter);
        mUserDataList.setOnItemClickListener(this);

        mMainPresenter = new MainPresenter(this);
        mMainPresenter.loadData();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        onItemClick((String) mAdapter.getItem(position));
    }

    @Override
    public void showLoading() {
        mLoadingBar.setVisibility(View.VISIBLE);
        mUserDataList.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mLoadingBar.setVisibility(View.GONE);
        mUserDataList.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(String user) {
        Toast.makeText(this, user + " clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void bindData(List<String> users) {
        mAdapter.setData(users);
        mAdapter.notifyDataSetChanged();
    }
}
