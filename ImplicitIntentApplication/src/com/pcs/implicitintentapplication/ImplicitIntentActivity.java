package com.pcs.implicitintentapplication;





import com.pcs.implicitintentapplicatiom.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ImplicitIntentActivity extends Activity implements OnClickListener{
	private Button callBtn;
	private Button contactsBtn;
	private Button browseBtn;
	private Button emailBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.implicitintent);
		callBtn=(Button)findViewById(R.id.call_btn);
		contactsBtn=(Button)findViewById(R.id.contacts_btn);
		browseBtn=(Button)findViewById(R.id.browse_btn);
		emailBtn=(Button)findViewById(R.id.email_btn);
		contactsBtn.setOnClickListener(this);
		callBtn.setOnClickListener(this);
		browseBtn.setOnClickListener(this);
		emailBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent= new Intent();
		switch(v.getId()){
		case R.id.call_btn:
			intent=new Intent(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:9848022338"));
			 startActivity(intent);
			
			break;
		case R.id.contacts_btn:
			 intent=new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("content://contacts/people/"));
			 startActivity(Intent.createChooser(intent,getResources().getString(R.string.choose)));
			break;
		case R.id.browse_btn:
			intent=new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://google.com"));
			 startActivity(intent);
			break;
			
			
		case R.id.email_btn:
			intent=new Intent(Intent.ACTION_SEND);
			intent.putExtra(intent.EXTRA_TEXT,"Hello friends");
			intent.putExtra(intent.EXTRA_SUBJECT,"Wishes");
			intent.putExtra(intent.EXTRA_EMAIL,"anitha.honey784@gmail.com");
			
			 startActivity(Intent.createChooser(intent, getResources().getString(R.string.email)));
			break;
			
			default:
				intent=new Intent();
				break;
		}
  
	}
}