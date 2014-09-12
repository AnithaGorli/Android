package com.pcs.resultapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resultapplication.R;

public class ResultActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		TextView textview=(TextView)findViewById(R.id.result_text);

		ImageView imageview=(ImageView)findViewById(R.id.result_image);

		WebView webview=(WebView)findViewById(R.id.result_browse);




		String choice=getIntent().getAction();

		if(choice.equals(Constants.LoginExtras.BROWSER)){
			webview.setVisibility(View.VISIBLE);
			webview.loadUrl("https://www.google.com");

		}
		if(choice.equals(Constants.LoginExtras.MUSIC)){
			imageview.setVisibility(View.VISIBLE);
			imageview.setBackgroundResource(R.drawable.music);

		}
		if(choice.equals(Constants.LoginExtras.FACEBOOK)){
			webview.setVisibility(View.VISIBLE);
			webview.loadUrl("http://facebook.com");

		}
		if(choice.equals(Constants.LoginExtras.TEXT)){
			textview.setVisibility(View.VISIBLE);
			textview.setText(getResources().getString(R.string.welcome));
		}
		if(choice.equals(Constants.LoginExtras.IMAGE)){
			imageview.setVisibility(View.VISIBLE);
			imageview.setBackgroundResource(R.drawable.dogs);

		}
		if(choice.equals(Constants.LoginExtras.EDUCATION)){
			imageview.setVisibility(View.VISIBLE);
			imageview.setImageResource(R.drawable.education_image);

		}


	}

}


