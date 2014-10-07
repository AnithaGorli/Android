package com.pcs.weatherupdateapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.weatherupdateapplication.R;

public class MainActivity extends Activity{

	private EditText emailEdt;
	private EditText passwordEdt;
	private Button loginBtn;
	private Button forgotBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_screen);


		emailEdt=(EditText)findViewById(R.id.username_edt);
		passwordEdt=(EditText)findViewById(R.id.password_edt);
		loginBtn=(Button)findViewById(R.id.login_btn);
		forgotBtn=(Button)findViewById(R.id.forgotpassword_btn);


		loginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,WeatherDisplayActivity.class);
				startActivity(intent);


			}
		});
	}

}
