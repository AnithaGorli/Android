package com.pcs.stylesandthemes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.stylesandthemes.R;

public class SecondActivity extends Activity implements OnClickListener{
	private Button lodaBtn,backBtn;
	private WebView webView;
	private View layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		lodaBtn=(Button)findViewById(R.id.loadbtn);		
		backBtn=(Button)findViewById(R.id.backbtn);
		webView=(WebView)findViewById(R.id.webview);
		layout=(View)findViewById(R.id.layout_second);
		lodaBtn.setOnClickListener(this);
		backBtn.setOnClickListener(this);

	}
	public  static class MyBrowser extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			view.loadUrl(url);
			return true;
		}
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.loadbtn:
			layout.setVisibility(View.GONE);
			webView.setVisibility(View.VISIBLE);
			//it will load the web page in same screen
			MyBrowser myBrowser=new MyBrowser();
			webView.setWebViewClient(myBrowser);
			webView.getSettings().setJavaScriptEnabled(true);
			webView.loadUrl("http://www.tutorialspoint.com/android/index.htm");
			break;
			//when u click on back button it will go to the activity which is called this activity
		case R.id.backbtn:
			finish();
			break;
		default:
			break;
		}

	}

}