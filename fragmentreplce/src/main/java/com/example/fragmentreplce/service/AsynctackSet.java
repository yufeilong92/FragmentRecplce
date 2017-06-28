package com.example.fragmentreplce.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyWork
 * @Package com.example.fragmentreplce.service
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/5/19 21:48
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class AsynctackSet extends AsyncTask<Void, Integer, Boolean> {

    public static final String TAG = "异步线程";
    private final Context mContext;
    private ProgressDialog mProgressDialog;

    public AsynctackSet(Context context) {
        this.mContext = context;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        Log.d(TAG, "onPostExecute: ");
        super.onPostExecute(aBoolean);
    }

    @Override
    protected void onProgressUpdate(final Integer... values) {
        Log.d(TAG, "onProgressUpdate: ");
        for (int i = 0; i < values.length; i++) {

            final int finalI = i;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mProgressDialog.setProgress(values[finalI]);
                }
            }, 1000);
        }
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        Log.d(TAG, "doInBackground: ");

        publishProgress();
        return null;
    }

    @Override
    protected void onPreExecute() {
        Log.d(TAG, "onPreExecute: ");
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setTitle("下载中....");
        mProgressDialog.setMessage("程序更新中");
        mProgressDialog.setMax(100);
        mProgressDialog.show();


    }

    @Override
    protected void onCancelled() {
        Log.d(TAG, "onCancelled: ");
        super.onCancelled();
    }
}
