package com.pcs.listexampleapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.listexampleapplication.R;

public class FirstActivity extends Activity{
	private EditText nameEdt;
	private EditText phoneEdt;
	private EditText addressEdt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.addinguser);


		nameEdt=(EditText)findViewById(R.id.name_edt);
		phoneEdt=(EditText)findViewById(R.id.phone_edt);
		addressEdt=(EditText)findViewById(R.id.address_edt);
		Button addBtn=(Button)findViewById(R.id.add_btn);



		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//sending result back to previous Activity
				Intent intent=new Intent();
				
				intent.putExtra(Constants.AddingExtras.NAME, nameEdt.getText().toString());
				intent.putExtra(Constants.AddingExtras.PHONE, phoneEdt.getText().toString());
				intent.putExtra(Constants.AddingExtras.ADDRESS, addressEdt.getText().toString());
		
				intent.putExtra( Constants.AddingExtras.IMAGE, R.drawable.android1);
				//checking whether text is empty or not
				if(nameEdt.getText().toString().equals("") & phoneEdt.getText().toString().equals("") & addressEdt.getText().toString().equals("") ){
					setResult(Activity.RESULT_CANCELED);
				}else{
				setResult(Activity.RESULT_OK,intent);
				}
				finish();
			}
		});

	}
}
