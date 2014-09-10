package com.pcs.customerapplication;

import com.pcs.customer.CustomerDAO;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		TextView textview_display=(TextView)findViewById(R.id.display_txt);
		CustomerDAO customer=getIntent().getParcelableExtra(Constants.LoginExtras.CUSTOMER);
		if(customer!=null){
			textview_display.setText(customer.toString());
		}
	}

}
