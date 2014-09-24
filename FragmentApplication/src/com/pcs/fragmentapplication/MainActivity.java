package com.pcs.fragmentapplication;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.mainone);
	
	}


	public static class FragmentOne extends Fragment implements OnClickListener{


		@Override
		public View onCreateView(LayoutInflater inflater,
				ViewGroup container,
				Bundle savedInstanceState) {

                
			View mainView = inflater.inflate(R.layout.fragment1,container,false);


			Button googleBtn=(Button)mainView.findViewById(R.id.fragment1_webbtn);
			Button imageBtn=(Button)mainView.findViewById(R.id.fragment1_imagebtn);
			Button textBtn=(Button)mainView.findViewById(R.id.fragment1_textbtn);

			googleBtn.setOnClickListener(this);

			imageBtn.setOnClickListener(this);

			textBtn.setOnClickListener(this);


			return mainView;
		}


		@Override
		public void onClick(View v) {
			int position=0;
			switch (v.getId()) {
			case R.id.fragment1_webbtn:
				position=1;


				break;

			case R.id.fragment1_imagebtn:
				position=2;

				break;
			case R.id.fragment1_textbtn:
				position=3;
				break;

			default:
				break;
			}
			FragmentTwo fragment_2 = new FragmentTwo(position);

			getFragmentManager().beginTransaction().add(R.id.fragment_2, fragment_2).commit();
		}
	
	
	
	}

	public  static class MyBrowser extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			
			
			view.loadUrl(url);
			return true;
		}
	}




		public static class FragmentTwo extends Fragment  {


			private int position;

			public FragmentTwo(int position) {
				this.position = position;

			}

			public FragmentTwo() {
			}

			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container,
					Bundle savedInstanceState) {
				 View mainView = inflater.inflate(R.layout.fragment2, container,
						false);

				ImageView imageView = (ImageView) mainView.findViewById(R.id.fragment2_imageview);
				WebView webView=(WebView)mainView.findViewById(R.id.fragment2_webview);
				TextView textview=(TextView)mainView.findViewById(R.id.fragment2_textview);
             
				
				
              
				switch(position){
				case 1:
					webView.setVisibility(View.VISIBLE) ;
					
					
					MyBrowser myBrowser=new MyBrowser();
					
					
					
					webView.setWebViewClient(myBrowser);
					webView.getSettings().setJavaScriptEnabled(true);
					
					webView.loadUrl("http://google.com");
					
					
					break;
				case 2:
					imageView.setVisibility(View.VISIBLE) ;
					imageView.setBackgroundResource(R.drawable.ic_launcher);
					break;
				case 3:
					textview.setVisibility(View.VISIBLE) ;
					textview.setText(R.string.text);
					break;

				}
				return mainView;
			}
		}
	
}



