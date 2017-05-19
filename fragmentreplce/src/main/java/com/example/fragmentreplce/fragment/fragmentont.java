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

public class fragmentont extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Button mBtnOneBack;
    private Button mBtnOneNext;


    public fragmentont() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static fragmentont newInstance(String param1, String param2) {
        fragmentont fragment = new fragmentont();
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
        View view = inflater.inflate(R.layout.fragment_fragmentont, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mBtnOneBack = (Button) view.findViewById(R.id.btn_one_back);
        mBtnOneNext = (Button) view.findViewById(R.id.btn_one_next);

        mBtnOneBack.setOnClickListener(this);
        mBtnOneNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one_back:
                break;
            case R.id.btn_one_next:
                EventBus.getDefault().post(new onevo("小米",1));

                break;
        }
    }
}