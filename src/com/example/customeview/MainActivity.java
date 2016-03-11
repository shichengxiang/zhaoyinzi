package com.example.customeview;

import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends BaseActivity {
	
//	PullToRefreshScrollView mPullToRefreshScrollView;
	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		mPullToRefreshScrollView=(PullToRefreshScrollView) findViewById(R.id.mScrollView);
//		mPullToRefreshScrollView.setMode(Mode.PULL_FROM_START);
//		mPullToRefreshScrollView.onRefreshComplete();
//		mPullToRefreshScrollView.getLoadingLayoutProxy().setLastUpdatedLabel("刷新时间: 2016-10-01 10:00");
//		mPullToRefreshScrollView.getLoadingLayoutProxy().setRefreshingLabel("refreshing");
//		mPullToRefreshScrollView.getLoadingLayoutProxy().setReleaseLabel("加载中...");
//		mPullToRefreshScrollView.setOnRefreshListener(new OnRefreshListener<ScrollView>() {
//			@Override
//			public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
//				
//			}
//		});
		img=(ImageView) findViewById(R.id.img);
		img.setImageBitmap(BitmapUtils.getInstance().createButton(200, 100,Color.GRAY));
	}
	

}
