package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
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
 * @date: 2017/6/29 20:53
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class CompassView extends View {

    private float bearing;
    private Paint paint;
    private Paint paint1;
    private Paint paint2;
    private int yy;

    public float getBearing() {
        return bearing;
    }

    public void setBearing(float bearing) {
        this.bearing = bearing;
    }

    public CompassView(Context context) {
        super(context);
        initCompassView();
    }


    public CompassView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initCompassView();
    }

    public CompassView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCompassView();
    }

    private void initCompassView() {
        setFocusable(true);

        Resources r= this.getResources();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(r.getColor(R.color.bg));
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        String n = r.getString(R.string.n);
        String w = r.getString(R.string.w);
        String s = r.getString(R.string.s);
        String e = r.getString(R.string.e);
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(r.getColor(R.color.txt));
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        yy = (int) paint1.measureText("Yy");
        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(r.getColor(R.color.mark));

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measure = measure(widthMeasureSpec);
        int measure1 = measure(heightMeasureSpec);

        int min = Math.min(measure, measure1);
        setMeasuredDimension(min, min);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        int measuredHeight = getMeasuredHeight();

        int measuredWidth = getMeasuredWidth();
        int i = measuredHeight / 2;
        int i1 = measuredWidth / 2;

        int min = Math.min(i, i1);
        canvas.drawCircle(i, i1, min,paint);
        canvas.save();
        canvas.rotate(-bearing,i,i1);
        super.onDraw(canvas);
        int w = (int) paint1.measureText("w");
        int i2 = i-w / 2;
        int i3 = i2 - w +yy;

    }

    private int measure(int meaureSpace) {
        int result = 0;
        int mode = MeasureSpec.getMode(meaureSpace);
        int size = MeasureSpec.getSize(meaureSpace);
        if (mode == MeasureSpec.UNSPECIFIED) {
            result = 200;
        } else {
            result = size;
        }
        return result;
    }
}
