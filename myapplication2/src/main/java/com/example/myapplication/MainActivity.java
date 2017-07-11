package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    private Button mBtn;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private iew tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mButton = (Button) findViewById(R.id.button);
        mBtn = (Button) findViewById(R.id.btn);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);

        mButton.setOnClickListener(this);
        mBtn.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        tv = (iew) findViewById(R.id.tv);
        tv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    }
                }, 24, 60, true);
                timePickerDialog.show();

                break;
            case R.id.btn:
                DatePickerDialog pickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    }
                }, 1990, 0, 01);
                pickerDialog.show();
                break;
            case R.id.button2:
//                String action= Context.NOTIFICATION_SERVICE;
//                NotificationManager  manager= (NotificationManager) getSystemService(action);
                Notification.Builder builder = new Notification.Builder(this);
                builder.setSmallIcon(R.mipmap.ic_launcher_round);
                builder.setTicker("测试Ticke");
                builder.setContentTitle(";;;;;");
                builder.setContentText(":::::");
                builder.setWhen(System.currentTimeMillis());
                builder.setDefaults(Notification.DEFAULT_ALL);
                break;
            case R.id.button3:
                int a = 0;
                NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                //实例化NotificationCompat.Builde并设置相关属性
                Notification builder1 = new NotificationCompat.Builder(this)
                        //设置小图标
                        .setSmallIcon(R.mipmap.ic_launcher)
                        //设置通知标题
                        .setContentTitle("最简单的Notification")
                        //设置通知内容
                        .setContentText("只有小图标、标题、内容")
                        //设置通知时间，默认为系统发出通知的时间，通常不用设置
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setTicker("ticker")
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round))
                        .setWhen(System.currentTimeMillis()).build();
                //通过builder.build()方法生成Notification对象,并发送通知,id=1\
                notifyManager.notify(1, builder1);
                break;
            case R.id.button4:

                break;
        }
    }
}
