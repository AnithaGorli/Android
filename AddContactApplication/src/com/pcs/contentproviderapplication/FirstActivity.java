package com.pcs.contentproviderapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstActivity extends Activity implements OnClickListener{


	private Button addContact;
	private Button showcontact;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);

		addContact=(Button)findViewById(R.id.add_contact);
		showcontact=(Button)findViewById(R.id.show_contact);


		addContact.setOnClickListener(this);
		showcontact.setOnClickListener(this);



	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		/**
		 * if you click on add_contact button , it will go to the MainActivity
		 */
		case R.id.add_contact:

			Intent intent=new Intent(FirstActivity.this,MainActivity.class);
			startActivity(intent);

			break;
			/**
			 * if you click on show_contact button ,it will directed to ShowListApplication
			 */
		case R.id.show_contact:
			Intent mintent=new Intent("com.pcs.showlistapplication.ShowActivity.SHOW");
			mintent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(mintent);

			break;

		default:
			break;
		}

	}



}
