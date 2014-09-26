package com.pcs.fragmentapplication;



import android.annotation.SuppressLint;
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

/**
 * This Activity Contains Two fragments
 * first fragment contains three buttons
 * when i click on particular button on first fragment ,
 * information related to that button is displayed on second fragment
 * @author Anitha-pcs-231
 *
 */
public class MainActivity extends FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
          
		setContentView(R.layout.mainone);

	}
/**
 * FragmentOne contains three buttons when i click on particular button
 * id of particular button is sent to the FragmentTwo
 * @author pcs-05
 *
 */

	public static class FragmentOne extends Fragment implements OnClickListener{


		@Override
		public View onCreateView(LayoutInflater inflater,
				ViewGroup container,
				Bundle savedInstanceState) {

			
			View mainView = inflater.inflate(R.layout.fragment_one,container,false);


			Button googleBtn=(Button)mainView.findViewById(R.id.fragmentone_webbtn);
			Button imageBtn=(Button)mainView.findViewById(R.id.fragmentone_imagebtn);
			Button textBtn=(Button)mainView.findViewById(R.id.fragmentone_textbtn);

			googleBtn.setOnClickListener(this);

			imageBtn.setOnClickListener(this);

			textBtn.setOnClickListener(this);


			return mainView;
		}
		/**
		 * when i click on any button ,id of that button will sent to FragmentTwo
		 */

		@Override
		public void onClick(View v) {
			
			FragmentTwo fragment = new FragmentTwo(v.getId());
			
			getFragmentManager().beginTransaction().add(R.id.fragment_two, fragment).commit();
		}



	}
/**
 * when i click on google button ,
 * the page should be loaded in fragmentTwo only ,
 * for that i extended my class with WebViewClient
 * @author pcs-05
 *
 */
	public  static class MyBrowser extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			return true;
		}
	}

/**
 * It will get the id's of particular buttons,
 * And does operation based on that
 * @author pcs-05
 *
 */
public static class FragmentTwo extends Fragment  {


		private int position;
		//for identifying the buttons
		public FragmentTwo(int position) {
			this.position = position;

		}

		public FragmentTwo() {
		}

		@SuppressLint("SetJavaScriptEnabled")
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View mainView = inflater.inflate(R.layout.fragment_two, container,
					false);

			ImageView imageView = (ImageView) mainView.findViewById(R.id.fragmenttwo_imageview);
			WebView webView=(WebView)mainView.findViewById(R.id.fragmenttwo_webview);
			TextView textview=(TextView)mainView.findViewById(R.id.fragmenttwo_textview);




			switch(position){
			//displays webPage of google
			case R.id.fragmentone_webbtn:
				webView.setVisibility(View.VISIBLE) ;
				imageView.setVisibility(View.GONE) ;
				textview.setVisibility(View.GONE);
				MyBrowser myBrowser=new MyBrowser();
				webView.setWebViewClient(myBrowser);
				webView.getSettings().setJavaScriptEnabled(true);
				webView.loadUrl("http://google.com");
				break;
				//displays image
			case R.id.fragmentone_imagebtn:
				imageView.setVisibility(View.VISIBLE) ;
				webView.setVisibility(View.GONE);
				textview.setVisibility(View.GONE);
				imageView.setBackgroundResource(R.drawable.flower);
				break;
				// displays document
			case R.id.fragmentone_textbtn:
				textview.setVisibility(View.VISIBLE) ;
				imageView.setVisibility(View.GONE) ;
				webView.setVisibility(View.GONE);
				textview.setText(R.string.text);
				break;

			}
			return mainView;
		}
	}

}



