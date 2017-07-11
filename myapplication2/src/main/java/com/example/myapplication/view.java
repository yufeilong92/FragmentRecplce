package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class view extends View{


    public view(Context context) {
        super(context);
    }

    public view(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public view(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
        canvas.drawCircle(40, 30, 20, paint);
        // 画一个正放形
        canvas.drawRect(20, 70, 70, 120, paint);
        Paint paint1 = new Paint();
        paint1.setColor(Color.BLACK);
        paint1.setTextSize(20);
        canvas.drawText("你好",28,100,paint1);
        // 画一个长方形
        canvas.drawRect(20, 170, 90, 130, paint);
        // 画一个椭圆
        RectF re = new RectF(20, 230, 100, 190);
        canvas.drawOval(re,paint);
        super.onDraw(canvas);
    }
}
