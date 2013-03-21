package com.example.smokefree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class HomePage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}
	
	public void getStatistics(View view) {
		Intent showChartIntent = new Intent(this, ShowChart.class);
    	startActivity(showChartIntent);
	}

	public void showSettings(View view){
		Intent showHealthTips = new Intent(this, HealthTips.class);
		startActivity(showHealthTips);
	}
}
