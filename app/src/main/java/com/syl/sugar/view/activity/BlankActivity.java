package com.syl.sugar.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.syl.sugar.R;

@Deprecated
public class BlankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
    }
}
