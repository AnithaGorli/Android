package com.pcs.stylesandthemes;

import com.example.stylesandthemes.R;

import android.app.Activity;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstActivity extends Activity implements OnClickListener{
	private Button androidBtn,iosBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
		androidBtn=(Button)findViewById(R.id.androidbtn);		
		iosBtn=(Button)findViewById(R.id.iosbtn);
		androidBtn.setOnClickListener(this);
		iosBtn.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		//it will directed to Second Activity which is android page
		case R.id.androidbtn:
			Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
			startActivity(intent);

			break;
			//it will directed to Second Activity which is ios page
		case R.id.iosbtn:
			Intent intentOne=new Intent(FirstActivity.this,ThirdActivity.class);
			startActivity(intentOne);
			break;
		default:
			break;
		}

	}

}
