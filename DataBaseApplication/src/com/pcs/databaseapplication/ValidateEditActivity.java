package com.pcs.databaseapplication;

import com.example.databaseapplication.R;
import com.pcs.helper.Constant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ValidateEditActivity extends Activity{
	private EditText emailEdt;
	private Button submitBtn;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.edit_validate);
	
	
	emailEdt=(EditText)findViewById(R.id.validate_email);
	submitBtn=(Button)findViewById(R.id.submit_btn);
	
	if(TextUtils.isEmpty(emailEdt.getText().toString())){
		Toast.makeText(getBaseContext(),
				this.getResources().getString(R.string.error),
				Toast.LENGTH_LONG).show();
	}else{
	
	submitBtn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(ValidateEditActivity.this,EditContactActivity.class);
			intent.putExtra(Constant.AddExtras.EMAIL, emailEdt.getText().toString());
			startActivity(intent);
			
		}
	});
	}
	
}
}
