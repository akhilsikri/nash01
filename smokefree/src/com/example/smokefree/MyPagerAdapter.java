/**
 * 
 */
package com.example.smokefree;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * @author himanshugupta
 *
 */
public class MyPagerAdapter extends PagerAdapter {

	
	private String[] time = null;
	private String[] healthTip = null;
	private int[] noOfLines = null;
	private int maxLinesOnAPage = 19;
	private float averageWordsPerLine = 4.5f;
	
	public MyPagerAdapter(View view){
		time = view.getResources().getStringArray(R.array.time);
		healthTip = view.getResources().getStringArray(R.array.tip);
		noOfLines = new int[time.length];
		for (int i=0; i<time.length; i++){
			noOfLines[i] = (int)((float)countOccurrences(healthTip[i], ' ') / averageWordsPerLine) + 1;
		}
	}
	
	/* (non-Javadoc)
	 * @see android.support.v4.view.PagerAdapter#getCount()
	 */
	@Override
	public int getCount() {
		int startingTipNo = 0, pageNo = 0, num = 0;
		while (true){
			num = 0;
			while (num <= maxLinesOnAPage && startingTipNo < time.length){
				num += noOfLines[startingTipNo++];
			}
			if (startingTipNo == time.length){
				if (num > 0)
					return pageNo + 1;
				else
					return pageNo;
			}
			startingTipNo--;
			pageNo++;
		}
	}

	/* (non-Javadoc)
	 * @see android.support.v4.view.PagerAdapter#isViewFromObject(android.view.View, java.lang.Object)
	 */
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	public Object instantiateItem(View collection, int position) {

		LayoutInflater inflater = (LayoutInflater) collection.getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		int resId = R.layout.activity_health_tips_by_time;
		
		View view = inflater.inflate(resId, null);
		
		int startingTipNo = 0, pageNo = 0, num = 0;
		while (pageNo < position){
			num = 0;
			while (num <= maxLinesOnAPage){
				num += noOfLines[startingTipNo++];
			}
			startingTipNo--;
			pageNo++;
		}
		num = noOfLines[startingTipNo]; 
		while (num <= maxLinesOnAPage){
			LinearLayout healthTipColumn = getHealthTipColumn(view, putSpecialCharacters(time[startingTipNo]), putSpecialCharacters(healthTip[startingTipNo]));
			((LinearLayout)view).addView(healthTipColumn);
			if (startingTipNo == time.length - 1)
				break;
			num += noOfLines[++startingTipNo];
		}
		
		((ViewPager) collection).addView(view, 0);
		return view;
	}
	
	public int countOccurrences(String haystack, char needle)
	{
	    int count = 0;
	    for (int i=0; i < haystack.length(); i++)
	    {
	        if (haystack.charAt(i) == needle)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	
	public String putSpecialCharacters(String str){
		str = str.replaceAll("PERCENT", "%");
		str = str.replaceAll("SINGLEQUOTE", "'");
		return str;
	}
	
	public LinearLayout getHealthTipColumn(View view, String timeBy, String tip){
		LinearLayout horizontalLayout = new LinearLayout(view.getContext());
		horizontalLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
		
		Resources res = view.getResources();
		
		TextView byTime = new TextView(view.getContext());
		float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, res.getDisplayMetrics());
		byTime.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));
		byTime.setWidth((int)pixels);
		byTime.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
		byTime.setBackgroundResource(R.color.gray);
		byTime.setText(timeBy);
		
		TextView healthEffect = new TextView(view.getContext());
		healthEffect.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		healthEffect.setBackgroundResource(R.color.gray);
		healthEffect.setText(tip);
		
		horizontalLayout.addView(byTime);
		horizontalLayout.addView(healthEffect);
		
		return horizontalLayout;
	}
	
	@Override
	public void destroyItem(View collection, int position, Object view) {
	     ((ViewPager) collection).removeView((View) view);
	}
	
}
