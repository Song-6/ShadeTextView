package com.abblcg.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by abb on 16/7/8.
 */
public class ShadeTextView extends TextView {

    private int abbShadeColor = Color.parseColor("#50000000");

    private Paint mPaint;
    private Rect mRect;

    private float positionPct;

    public ShadeTextView(Context context) {
        this(context, null);
    }

    public ShadeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShadeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);

            if (attr == R.styleable.CustomTitleView_abbShadeColor) {
                abbShadeColor = a.getColor(attr, 0x50000000);
            }
        }
        a.recycle();

        mPaint = new Paint();
        mRect = new Rect();
        mPaint.setColor(abbShadeColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("测试", "getWidth:" + getWidth());
        Log.i("测试", "getLeft:" + getLeft());
        Log.i("测试", "getHeight:" + getHeight());
        Log.i("测试", "getTop:" + getTop());
        Log.i("测试", "getPaddingLeft:" + getPaddingLeft());
        Log.i("测试", "getPaddingRight:" + getPaddingRight());

        Log.i("测试", "--------------------------");
        mPaint.setStyle(Paint.Style.FILL);
        mRect.set((int) (positionPct * getWidth() + getLeft()), getTop(), (int) (getLeft() + positionPct * getWidth() + getWidth()), getBottom());
        canvas.drawRect(mRect, mPaint);
    }

    public void setShadePosition(float positionPct) {
        if (positionPct < -1f || positionPct > 1f) {
            throw new RuntimeException("positionPct取值在-0.1f和0.1f之间");
        }

        this.positionPct = positionPct;
        postInvalidate();
    }
}
