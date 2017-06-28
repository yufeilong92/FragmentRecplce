package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class BlankFragments extends Fragment {

    public interface OnNewItenListener {
        void onNewItemListener(View view, String item);
    }
    public   OnNewItenListener onNewItenListener;

    private EditText et_fragmnet;

    private void initView(View view) {
        et_fragmnet = (EditText) view.findViewById(R.id.et_fragmnet);
        et_fragmnet.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN||keyCode==KeyEvent.KEYCODE_DPAD_CENTER){
                    String trim = et_fragmnet.getText().toString().trim();
                    onNewItenListener.onNewItemListener(v,trim);
                    et_fragmnet.setText("");
                    return true;
                }


                return false;
            }
        });
    }

    private void submit() {
        // validate
        String fragmnet = et_fragmnet.getText().toString().trim();
        if (TextUtils.isEmpty(fragmnet)) {
            Toast.makeText(getContext(), "fragmnet不能为空", Toast.LENGTH_SHORT).show();
            return;
        }



    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onNewItenListener = (OnNewItenListener) activity;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(view);
        return view;
    }


}
