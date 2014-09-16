package com.pcs.listexampleapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listexampleapplication.R;

public class InteractionActivity extends Activity implements OnClickListener{
	private ImageView imageView;
	private TextView nameTxt;
	private TextView phoneTxt;
	private TextView addressTxt;
	private Button calBtn;
	private Button backBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interaction);

		imageView=(ImageView)findViewById(R.id.interact_image);
		nameTxt=(TextView)findViewById(R.id.interact_name_txt);
		phoneTxt=(TextView)findViewById(R.id.interact_phone_txt);
		addressTxt=(TextView)findViewById(R.id.interact_address_txt);
		calBtn=(Button)findViewById(R.id.call_btn);
		backBtn=(Button)findViewById(R.id.back_btn);
		calBtn.setOnClickListener(this);
		backBtn.setOnClickListener(this);


/**
 * getting data from intent
 */
		String name=getIntent().getStringExtra(Constants.AddingExtras.NAME);
		String phone=getIntent().getStringExtra(Constants.AddingExtras.PHONE);
		String address=getIntent().getStringExtra(Constants.AddingExtras.ADDRESS);
//setting data

		nameTxt.setText(name);
		phoneTxt.setText(phone);
		addressTxt.setText(address);
		imageView.setImageResource(R.drawable.back);
	}

	@Override
	public void onClick(View v) {

		switch(v.getId()){

		case R.id.call_btn:
			String call="tel:"+phoneTxt.getText().toString();
			Intent intent2=new Intent(Intent.ACTION_CALL);
			intent2.setData(Uri.parse(call));
			startActivity(intent2);
			break;



		case R.id.back_btn:

			finish();
			break;


		default:
			break;


		}

	}
}
