package com.example.fragmentreplce.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmentreplce.R;
import com.example.fragmentreplce.applyvo.onevo;

import org.greenrobot.eventbus.EventBus;

public class fragmentwo extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Button mBtnTwoBack;
    private Button mBtnTwonExt;


    public fragmentwo() {
        // Required empty public constructor
    }

    public static fragmentwo newInstance(String param1, String param2) {
        fragmentwo fragment = new fragmentwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentwo, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mBtnTwoBack = (Button) view.findViewById(R.id.btn_two_back);
        mBtnTwonExt = (Button) view.findViewById(R.id.btn_twon_ext);
        mBtnTwoBack.setOnClickListener(this);
        mBtnTwonExt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_two_back:
                break;
            case R.id.btn_twon_ext:
                EventBus.getDefault().post(new onevo("小米",2));
                break;
        }
    }
}
