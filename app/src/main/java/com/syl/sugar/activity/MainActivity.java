package com.syl.sugar.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.syl.aop.annotation.DebugTrace;
import com.syl.sugar.DbTask;
import com.syl.sugar.NavigationTool;
import com.syl.sugar.R;
import com.syl.sugar.activity.adapter.UserListAdapter;
import com.syl.sugar.activity.presenter.MainPresenter;
import com.syl.sugar.task.TaskManager;
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

        mAdapter = new UserListAdapter(this);
        mUserDataList.addHeaderView(initHeaderView());
        mUserDataList.setAdapter(mAdapter);
        mUserDataList.setOnItemClickListener(this);

        mMainPresenter = new MainPresenter(this);
        mMainPresenter.loadData();

        TaskManager.getInstance().start(new DbTask());
        TaskManager.getInstance().start(new DbTask());
        TaskManager.getInstance().start(new DbTask());
        TaskManager.getInstance().start(new DbTask());
        TaskManager.getInstance().start(new DbTask());
        TaskManager.getInstance().start(new DbTask());
    }

    private View initHeaderView() {
        View view = LayoutInflater.from(this).inflate(R.layout.main_listview_header, null);
        return view;
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
        NavigationTool.gotoGankActivity(this);
    }

    @Override
    public void bindData(List<String> users) {
        mAdapter.setData(users);
        mAdapter.notifyDataSetChanged();
    }
}
