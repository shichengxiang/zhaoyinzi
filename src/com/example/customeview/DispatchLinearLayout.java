package com.example.customeview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by hubin on 16/2/1.
 */
public class DispatchLinearLayout extends LinearLayout{
    public DispatchLinearLayout(Context context) {
        this(context,null);
    }

    public DispatchLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DispatchLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //拦截Touch事件,交给DispatchLinearLayout
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
