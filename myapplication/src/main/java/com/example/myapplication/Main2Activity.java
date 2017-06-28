package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class Main2Activity extends AppCompatActivity {

    private Toolbar mToolbar;
    private AppBarLayout mAppbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        ActionBar actionBar = getSupportActionBar();
        setSupportActionBar(mToolbar);
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher_round);
        }

    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mAppbar = (AppBarLayout) findViewById(R.id.appbar);
    }
}
