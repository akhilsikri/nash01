package com.diabetes.util;



import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.Button;

import com.diabetes.R;
/**
 * Class is used to draw custom button.
 *
 */
public class UIButton extends Button{

	private Drawable m_drawable;
	
	public UIButton(Context context) {
		super(context);
		
		m_drawable = getBackground();
		
	}
 	public UIButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		m_drawable = getBackground();
		setCustomeTypeface(context, attrs);
	}

	@Override
	protected void drawableStateChanged() {
		super.drawableStateChanged();

		int[] states = getDrawableState();

		if (StateSet.stateSetMatches(new int[] { android.R.attr.state_pressed }, states) || StateSet.stateSetMatches(new int[] { android.R.attr.state_focused }, states)) {
			m_drawable.setAlpha(150);
			setBackgroundDrawable(m_drawable);
		} else if(!StateSet.stateSetMatches(new int[] { android.R.attr.state_enabled }, states)){
			//setBackgroundDrawable(m_disabledDrawable);
		}
		else{
			m_drawable.setAlpha(255);
			setBackgroundDrawable(m_drawable);
		}
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
	}
}
