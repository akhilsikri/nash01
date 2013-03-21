package com.example.smokefree;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class HealthTips extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.health_tips);
		
		ViewPager myPager = (ViewPager) findViewById(R.id.myfivepanelpager);
		MyPagerAdapter adapter = new MyPagerAdapter(myPager);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.health_tips, menu);
		return true;
	}
	
	
}
