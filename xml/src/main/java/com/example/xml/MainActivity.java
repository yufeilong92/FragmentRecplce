package com.example.xml;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    String obj = (String) msg.obj;
                    mTv.setText(obj);
                    break;
                default:
                    break;
            }
        }
    };

    private void request() {
          new Thread(new Runnable() {

              private HttpURLConnection connection;
              @Override
              public void run() {

                  String srl = "http://www.baidu.com";
                  try {
                      URL url = new URL(srl);
                      connection = (HttpURLConnection) url.openConnection();
                      connection.setRequestMethod("GET");
                      connection.setConnectTimeout(6000);
                      connection.setReadTimeout(6000);
                      InputStream inputStream = connection.getInputStream();

                      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                      StringBuilder stringBuilder = new StringBuilder();
                      String line;
                      while ((line = reader.readLine()) != null) {
                          stringBuilder.append(line);
                      }
                      Message message = new Message();
                      message.what = 1;
                      message.obj = stringBuilder.toString();
                      handler.sendMessage(message);
                      
                  } catch (Exception e) {
                      e.printStackTrace();
                  }finally {
                      if (connection!=null){
                          connection.disconnect();
                      }
                  }
              }
          }).start();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                request();
                requests();
                break;
        }
    }

    private void requests() {


    }
}
