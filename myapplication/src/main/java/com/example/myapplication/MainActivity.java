package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToobal;
    private FloatingActionButton mFabtn;
    private NavigationView mNavView;
    private DrawerLayout mDrl;
    private RecyclerView mRlv;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initData() {
        addData();
        if (list==null)
            return;
        GridLayoutManager manager = new GridLayoutManager(this,1);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list, this);
        mRlv.setLayoutManager(manager);
        mRlv.setAdapter(recyclerAdapter);
    }

    private void addData() {
        list = new ArrayList<>();
        int a=20;
        for (int i = 0; i < a; i++) {
            list.add("第"+i+"行");
        }
    }

    private void initView() {
        mToobal = (Toolbar) findViewById(R.id.toobal);
        mFabtn = (FloatingActionButton) findViewById(R.id.fabtn);
        mNavView = (NavigationView) findViewById(R.id.nav_view);
        mDrl = (DrawerLayout) findViewById(R.id.drl);
        setSupportActionBar(mToobal);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher_round);
        }
        mFabtn.setOnClickListener(this);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setOnClickListener(this);
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch(item.getItemId())
               { case R.id.nav_call :
                   Toast.makeText(MainActivity.this,"call",Toast.LENGTH_SHORT).show();
                   mDrl.closeDrawers();

                     break;
               case  R.id.nav_friends:
                   Toast.makeText(MainActivity.this,"frends",Toast.LENGTH_SHORT).show();
                   mDrl.closeDrawers();

                   break;
               case  R.id.nav_location:
                   Toast.makeText(MainActivity.this,"loaction",Toast.LENGTH_SHORT).show();
                   mDrl.closeDrawers();

                   break;
               case  R.id.nav_mail:
                   Toast.makeText(MainActivity.this,"mail",Toast.LENGTH_SHORT).show();
                   mDrl.closeDrawers();

                   break;
                 default:
                     break;
               }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabtn:
                Snackbar.make(v, "Data,deleted", Snackbar.LENGTH_SHORT)
                        .setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "2222", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrl.openDrawer(Gravity.START);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
