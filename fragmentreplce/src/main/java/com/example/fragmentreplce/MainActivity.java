package com.example.fragmentreplce;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.fragmentreplce.applyvo.onevo;
import com.example.fragmentreplce.fragment.fragmentThree;
import com.example.fragmentreplce.fragment.fragmentont;
import com.example.fragmentreplce.fragment.fragmentwo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Fragment mTtemFragment = null;
    private FrameLayout fragment;
    private FragmentManager fm;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        initView();
        initData();
    }

    private void initView() {
        fragment = (FrameLayout) findViewById(R.id.fragment);
        fragments = new ArrayList<>();

        fragmentont fragmentont = new fragmentont();
        fragmentwo fragmenttwo = new fragmentwo();
        fragmentThree fragmentThree = new fragmentThree();
        fragments.add(fragmentont);
        fragments.add(fragmenttwo);
        fragments.add(fragmentThree);

        fm = getSupportFragmentManager();
        for (int i = 0; i < fragments.size(); i++) {
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.add(R.id.fragment, fragments.get(i)).hide(fragments.get(i)).commit();

        }
          fm.beginTransaction().show(fragmentont).commit();

    }
    private void initData() {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(onevo event) {
        int id = event.getId();
        String name = event.getName();
        Log.d("===", "onEvent: =="+id+name);
       if (id==1){
           switchFragment(fragments.get(0),fragments.get(1));
       }else if (id==2){
           switchFragment(fragments.get(1),fragments.get(2));
       }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    /**
     * 使用hide和show方法切换Fragment
     *
     * @param fragmentfrom  隐藏fragment
     * @param fragmentto   需要切换的fragment
     */
    private void switchFragment(Fragment fragmentfrom, Fragment fragmentto) {
        if (fragmentto != mTtemFragment) {
            FragmentTransaction bt = fm.beginTransaction();
            bt.addToBackStack(null);
            if (!fragmentto.isAdded()) {
                bt.hide(fragmentfrom)
                        .add(R.id.fragment, fragmentto).commit();
            } else {
                bt.hide(fragmentfrom)
                        .show(fragmentto).commit();
            }
            mTtemFragment= fragmentto;
        }
    }
}
