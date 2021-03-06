package com.syl.sugar.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.syl.sugar.NavigationTool;
import com.syl.sugar.R;
import com.syl.sugar.presenter.LoginPresenter;
import com.syl.sugar.view.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.edit_login_username)
    EditText mEditLoginUsername;
    @Bind(R.id.edit_login_password)
    EditText mEditLoginPassword;
    @Bind(R.id.button_login)
    Button mButtonLogin;
    @Bind(R.id.loading_bar)
    ProgressBar mLoadingBar;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.edit_login_username, R.id.edit_login_password, R.id.button_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_login_username:
                break;
            case R.id.edit_login_password:
                break;
            case R.id.button_login:
                final String username = mEditLoginUsername.getText().toString();
                final String password = mEditLoginPassword.getText().toString();

                mLoginPresenter.doLogin(username, password);
                break;
        }
    }

    @Override
    public void showLoading() {
        mLoadingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingBar.setVisibility(View.GONE);
    }

    @Override
    public void onUserNameError() {
        mEditLoginUsername.setError(getString(R.string.username_is_empty));
    }

    @Override
    public void onPasswordError() {
        mEditLoginPassword.setError(getString(R.string.password_is_empty));
    }

    @Override
    public void jump2MainActivity() {
        NavigationTool.gotoMainActivity(this);
    }
}
