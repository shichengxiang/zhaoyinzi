package com.example.customeview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class CustomeNumberPicker extends NumberPicker {
	private Context mContext;

	public CustomeNumberPicker(Context context) {
		super(context);
		mContext=context;
	}

	public CustomeNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public CustomeNumberPicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext=context;
	}

	@Override
	public void addView(View child, int width, int height) {
		super.addView(child, width, height);
	}

	public void addView(View child) {
	};

	@Override
	public void addView(View child, int index) {
		super.addView(child, index);
	}

	@Override
	public void addView(View child, android.view.ViewGroup.LayoutParams params) {
		super.addView(child, params);
	}

	@Override
	public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
		if(child instanceof EditText){
			TextView tView=new TextView(mContext);
			tView.setText("成功了");;
			super.addView(tView, index, params);
		}
		
	}


}
