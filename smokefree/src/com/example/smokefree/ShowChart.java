package com.example.smokefree;

import com.example.smokefree.BarGraph.Period;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RelativeLayout;

public class ShowChart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showchart);
		
		RelativeLayout rL = (RelativeLayout) findViewById(R.string.graph);
		BarGraph graph = new BarGraph();
		rL.addView(graph.getView(this, Period.DAILY));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_chart, menu);
		return true;
	}

}
