package com.example.smokefree;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

public class BarGraph {

	public enum Period{
		DAILY,
		WEEKLY,
		MONTHLY,
		YEARLY
	};
	
	private Period period;
	private int days;
	private final int maxBarsToShow = 20;
	
	public View getView(Context context, Period _period){
		period = _period;
		period = Period.DAILY;
		return ChartFactory.getBarChartView(context, getDataset(), getRenderer(), Type.DEFAULT);
	}
	
	private XYMultipleSeriesDataset getDataset() {
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        int y[] = {8, 24, 18, 22, 12, 13, 1, 5, 8, 24, 18, 22, 12, 13, 1, 5, 12, 13, 1, 5, 8, 24, 18, 22, 12, 13, 8, 24, 18, 22};
        CategorySeries series = new CategorySeries("Bar Graph Series");
        int length = y.length;
        days = 1;
    	switch(period){
    	case DAILY:
    		days = 1;
    		break;
    	case WEEKLY:
    		days = 7;
    		break;
    	case MONTHLY:
    		days = 30;
    		break;
    	case YEARLY:
    		days = 365;
    		break;
    	default:
    		days = 1;
    		break;
    	}
        for (int i=0; i<maxBarsToShow; i++){
        	int index = length - i * days - 1;
        	series.add("Bar "+(i+1), (index < 0) ? 0 : y[i]);
        }
        
        dataset.addSeries(series.toXYSeries());
        
        return dataset;
    }
    
    private XYMultipleSeriesRenderer getRenderer() {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();

        XYSeriesRenderer r1 = new XYSeriesRenderer();

        r1.setDisplayChartValues(true);
        r1.setChartValuesSpacing((float)0.1);
        r1.setColor(Color.GREEN);
        
        renderer.addSeriesRenderer(r1);
        setChartSettings(renderer);
        return renderer;
    }
    
    private void setChartSettings(XYMultipleSeriesRenderer renderer) {
        renderer.setChartTitle("Number of cigarettes over time");
        renderer.setXTitle("Time");
        renderer.setYTitle("No. of cigarettes");
        renderer.setApplyBackgroundColor(false);
        renderer.setFitLegend(false);
        renderer.setAxesColor(Color.GRAY);
        renderer.setZoomEnabled(false);
        renderer.setBarSpacing(0.5);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        long currentTime = System.currentTimeMillis() - maxBarsToShow * days * 3600 * 24 * 1000;
        for (int i=0; i<maxBarsToShow; i++){
        	String date = sdf.format(currentTime);
        	if (i % 5 == 0)
        		renderer.addXTextLabel(i+1, date);
        	else
        		renderer.addXTextLabel(i+1, "");
        	currentTime += days * 3600 * 24 * 1000;
        }
      }
    
}
