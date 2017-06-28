package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements BlankFragments.OnNewItenListener {

    private EditText mEtShow;
    private ListView mListview;
    private FragmentManager fm;
    private ArrayList<String> strings;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        fm = getSupportFragmentManager();
        TOdoFragment fragmentById = (TOdoFragment) fm.findFragmentById(R.id.fla_to);
        strings = new ArrayList<>();
        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings);
        fragmentById.setListAdapter(adapter1);
 /*       mListview = (ListView) findViewById(R.id.listview);
        final ArrayList<String> strings = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings);
        mListview.setAdapter(adapter);*/
/*        mEtShow = (EditText) findViewById(R.id.et_show);
        mEtShow.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN || keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
                    String trim = mEtShow.getText().toString().trim();
                    strings.add(trim);
                    adapter.notifyDataSetChanged();
                    mEtShow.setText("");
                    return true;
                }
                return false;
            }
        });*/

    }

    private void submit() {

    }

    @Override
    public void onNewItemListener(View view, String item) {
        strings.add(item);
        adapter1.notifyDataSetChanged();
    }
}
