package com.diabetes;

import com.diabetes.latescare.LatesCare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener 
{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home);
        
        /*ImageButton btn=(ImageButton)findViewById(R.id.generalBtn);
        btn.setOnClickListener(this);
        btn=(ImageButton)findViewById(R.id.eyeBtn);
        btn.setOnClickListener(this);
        btn=(ImageButton)findViewById(R.id.footBtn);
        btn.setOnClickListener(this);
        */
        ImageButton btn =(ImageButton)findViewById(R.id.letsCareBtn);
        btn.setOnClickListener(this);
        btn=(ImageButton)findViewById(R.id.monitorBtn);
        btn.setOnClickListener(this);
        btn=(ImageButton)findViewById(R.id.reminderBtn);
        btn.setOnClickListener(this);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) 
	{
		Intent i;
		
		int id=v.getId();
		switch (id) {
		case R.id.letsCareBtn:
			i=new Intent(MainActivity.this, LatesCare.class);
			startActivity(i);
			break;
		case R.id.monitorBtn:
			break;
		case R.id.reminderBtn:
			break;
		}
		
	}

    
}
