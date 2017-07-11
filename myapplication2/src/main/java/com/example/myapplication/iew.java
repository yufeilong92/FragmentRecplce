package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyWork
 * @Package com.example.myapplication
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/7/2 21:40
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class iew extends View {

    private Canvas canvas1;
    private Paint paints;

    public iew(Context context) {
        super(context);
    }

    public iew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public iew(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int min = Math.min(measuredHeight / 2, measuredWidth / 2);
        paints = new Paint();
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        paints.setColor(getResources().getColor(R.color.colorAccent));
        paint.setTextSize(40);
        String a = "你好";
        int argb = Color.argb(127, 225, 0, 0);
        int i = Color.parseColor("#7fff0000");
        paints.setColorFilter(new LightingColorFilter(Color.GREEN, Color.YELLOW));
        canvas.drawCircle(measuredWidth / 2, measuredHeight / 2, min, paints);
        canvas.drawText(a, (getWidth() - a.length()) / 2, getHeight() / 2, paint);

    }

}
