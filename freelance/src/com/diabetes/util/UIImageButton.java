package com.diabetes.util;



import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.ImageButton;
/**
 * Class is used to draw custom button.
 *
 */
public class UIImageButton extends ImageButton{

	private Drawable m_drawable;
	
	public UIImageButton(Context context) {
		super(context);
		
		m_drawable = getBackground();
		
	}
 	public UIImageButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		m_drawable = getBackground();
		
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
	
}
