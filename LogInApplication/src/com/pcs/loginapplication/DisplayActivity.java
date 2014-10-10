package com.pcs.loginapplication;

import com.example.loginapplication.R;
import com.pcs.constants.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * get the result From Login Activity
 * and displays in TextView
 * @author pcs-05
 *
 */
public class DisplayActivity  extends Activity{
	
	private TextView displayTxt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		
		displayTxt=(TextView)findViewById(R.id.dasplaytxt);
		
		
		displayTxt.setText(getResources().getString(R.string.welcome) + " "
				+ getIntent().getStringExtra(Constants.AddExtras.EMAIL));
		
			
		
	}

}
