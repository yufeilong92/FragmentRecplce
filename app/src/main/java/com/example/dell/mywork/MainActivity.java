package com.example.dell.mywork;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private NoScrrolView viewpager;
    private String[] title = {"法制宣传", "法制创建", "法宣视频", "以案释法"};
    private List<Fragment> list = new ArrayList();
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        for (int i = 0; i < title.length; i++) {
            BlankFragment fragment = new BlankFragment();
            Bundle bundle = new Bundle();
            bundle.putString("titel", title[i]);
            fragment.setArguments(bundle);
            list.add(fragment);
            data.add(title[i]);
        }


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), list, data, this);
        viewpager.setAdapter(viewPagerAdapter);
        tablayout.setupWithViewPager(viewpager);

    }

    private void initView() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (NoScrrolView) findViewById(R.id.viewpager);
        viewpager.setPagingEnabled(false);
    }
}
