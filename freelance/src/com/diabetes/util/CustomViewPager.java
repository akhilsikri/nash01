package com.diabetes.util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomViewPager extends ViewPager 
{
	private boolean swipe = true;

	public CustomViewPager(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		this.swipe = true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) 
	{
		if (this.swipe) 
		{
			return super.onTouchEvent(event);
		}
		return false;
	}
	
	public void disableSwipe()
	{
		swipe = false;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) 
	{
		// Never allow swiping to switch between pages
		if(swipe)
		{
			return super.onInterceptTouchEvent(arg0);
		}
		return swipe;
	}


	public void setPagingEnabled(boolean enabled) {
		this.swipe = enabled;
	}
}