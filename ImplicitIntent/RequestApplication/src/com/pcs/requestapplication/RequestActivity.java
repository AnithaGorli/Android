package com.pcs.requestapplication;

import com.example.requestapplication.R;

import android.app.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RequestActivity extends Activity implements OnClickListener{
	private  Button browserBtn;
	private  Button musicBtn;
	private  Button imageBtn;
	private  Button textBtn;
	private  Button educationBtn;
	private  Button facebookBtn;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.request);

		browserBtn=(Button)findViewById(R.id.browser_btn);
		musicBtn=(Button)findViewById(R.id.music_btn);
		imageBtn=(Button)findViewById(R.id.images_btn);
		textBtn=(Button)findViewById(R.id.text_btn);
		educationBtn=(Button)findViewById(R.id.education_btn);
		facebookBtn=(Button)findViewById(R.id.facebook_btn);

		browserBtn.setOnClickListener(this);
		musicBtn.setOnClickListener(this);
		imageBtn.setOnClickListener(this);
		textBtn.setOnClickListener(this);
		educationBtn.setOnClickListener(this);
		facebookBtn.setOnClickListener(this);

	}


	@Override
	public void onClick(View v) {

		Intent intent = new Intent();
		switch(v.getId())
		{
		case R.id.browser_btn:
			intent = new Intent("com.pcs.resultapplication.ResultActivity.SHOW_BROWSER");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(intent);
			break;
		case R.id.music_btn :
			intent = new Intent("com.pcs.resultapplication.ResultActivity.PLAY_MUSIC");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(intent);
			break;

		case R.id.images_btn:
			intent = new Intent("com.pcs.resultapplication.ResultActivity.SHOW_IMAGES");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(intent);
			break;

		case R.id.text_btn :
			intent = new Intent("com.pcs.resultapplication.ResultActivity.SHOW_TEXT");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);

			startActivity(intent);
			break;

		case R.id.facebook_btn :
			intent = new Intent("com.pcs.resultapplication.ResultActivity.SHOW_FACEBOOK");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(intent);
			break;
		case R.id.education_btn:
			intent = new Intent("com.pcs.resultapplication.ResultActivity.SHOW_EDUCATION");
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			startActivity(intent);
			break;
		default :
			break;

		}

	}






}
