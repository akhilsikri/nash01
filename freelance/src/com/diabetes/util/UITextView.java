package com.diabetes.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.diabetes.R;

public class UITextView extends TextView {

	public UITextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public UITextView(Context context, AttributeSet attrs) {
		super(context, attrs);

		if (isInEditMode()) {
			return;
		}

		setCustomeTypeface(context, attrs);

	}

	public UITextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (isInEditMode()) {
			return;
		}

		setCustomeTypeface(context, attrs);
	}

	private void setCustomeTypeface(Context context, AttributeSet attrs) {
		TypedArray styledAttrs = context.obtainStyledAttributes(attrs,
				R.styleable.TypefacedTextView);
		String fontName = styledAttrs
				.getString(R.styleable.TypefacedTextView_typeface);
		styledAttrs.recycle();

		if (fontName != null) {
			Typeface typeface = Typeface.createFromAsset(context.getAssets(),
					fontName);
			setTypeface(typeface);
		}
		else
		{
			Typeface typeface = Typeface.createFromAsset(context.getAssets(),	"fonts/roboto_regular.ttf");
			setTypeface(typeface);
		}
	}
}
