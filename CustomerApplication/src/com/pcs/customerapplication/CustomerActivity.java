package com.pcs.customerapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CustomerActivity extends Activity{
	private Button Login_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customer);
		Login_btn=(Button)findViewById(R.id.login_btn);


		Login_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent=new Intent(CustomerActivity.this,LoginActivity.class);
				startActivity(intent);


			}
		});

	}
}
