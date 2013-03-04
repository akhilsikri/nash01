package com.diabetes.latescare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import com.diabetes.R;
import com.diabetes.R.array;
import com.diabetes.R.id;
import com.diabetes.R.layout;
import com.diabetes.util.CustomViewPager;
import com.diabetes.util.UIButton;
import com.diabetes.util.UITextView;

public class LatesCare extends FragmentActivity implements OnClickListener 
{
	CustomViewPager pager;
	ScreenSlidePagerAdapter adapter; 
	String[] letsCare;
	String[] letsCare_titles;
	UITextView title;
	int pos;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lates_care);
        
        UIButton btn=(UIButton)findViewById(R.id.latesCareBackBtn);
        btn.setOnClickListener(this);
        
        btn=(UIButton)findViewById(R.id.nextButton);
        btn.setOnClickListener(this);
        btn=(UIButton)findViewById(R.id.previousButton);
        btn.setOnClickListener(this);
        
        title = (UITextView)findViewById(R.id.textView1);
        
        pos=0;
        
        //letsCare = new String[27];
        
        letsCare =  getResources().getStringArray(R.array.letscare);
        letsCare_titles = getResources().getStringArray(R.array.letscare_titles);
        
		pager = (CustomViewPager)findViewById(R.id.pager);
		pager.setOffscreenPageLimit(1);
		adapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
		//pager.disableSwipe();
		
	
	
	}

	@Override
	public void onClick(View v) 
	{
		int position = pager.getCurrentItem();
		System.out.println("on click = "+position);
		int id = v.getId();
		switch (id) {
		case R.id.latesCareBackBtn:
			finish();
			break;
		case R.id.nextButton:
			if(position<26)
				pager.setCurrentItem(position+1, true);
			break;
		case R.id.previousButton:
			if(position>0)
				pager.setCurrentItem(position-1, true);		
			break;

		}
		
	}
	
	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) 
        {
        	Fragment desc= null;
        	desc= new Description(letsCare[position],letsCare_titles[position]);        	
            return desc;
        }
        
        @Override
        public void destroyItem(View collection, int position, Object view) {
             
        }


        @Override
        public int getCount() {
        	return letsCare.length;
        }
    }
}
