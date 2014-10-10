package com.pcs.loginapplication;


import com.example.loginapplication.R;
import com.pcs.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends Activity implements OnClickListener{
	private EditText emailEdt;
	private EditText passwordEdt;
	private Button signinBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);


		emailEdt=(EditText)findViewById(R.id.email_edt);
		passwordEdt=(EditText)findViewById(R.id.password_edt);
		signinBtn=(Button)findViewById(R.id.signinbtn);


		signinBtn.setOnClickListener(this);




	}
	/**
	 * when i click on sign in button it will open Display Activity 
	 * And shows Welcome  UserName
	 */
	@Override
	public void onClick(View v) {
/**
 * Validating UserName And Password
 * if you did not enter any value it will display error message
 * else it will accept you
 * 
 */
		if(TextUtils.isEmpty(emailEdt.getText().toString()) ||
				TextUtils.isEmpty(passwordEdt.getText().toString())){

			Toast.makeText(getBaseContext(), 
					getResources().getString(R.string.invalid).toString(), Toast.LENGTH_LONG).show();

		}else {
			if((emailEdt.getText().toString().contains("@")&& emailEdt.getText().toString().contains("."))){


				Intent mintent=new Intent(LogInActivity.this,DisplayActivity.class);
				mintent.putExtra(Constants.AddExtras.EMAIL, emailEdt.getText().toString());
				startActivity(mintent);
			}else{
				Toast.makeText(getBaseContext(), 
						getResources().getString(R.string.invalidemail).toString(), Toast.LENGTH_LONG).show();
			}

		}

	}

}
