package com.diabetes.latescare;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diabetes.R;
import com.diabetes.R.id;
import com.diabetes.R.layout;
import com.diabetes.util.UITextView;

public class Description extends Fragment 
{
	String description;
	String title;
	public Description(String description, String titleString)
	{
		this.description=description;
		this.title=titleString;
		
    	
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		View v = inflater.inflate(R.layout.description, container, false);		
		UITextView desc = (UITextView)v.findViewById(R.id.descriptionTextView);
		
		UITextView title =(UITextView)v.findViewById(R.id.descriptionTitleTextView);
		title.setText(this.title);
		
		CharSequence styledText = Html.fromHtml(description);
		desc.setText(styledText);
		
		//desc.setText(Html.fromHtml(description));
		
		return v;
	}
}
