package com.pcs.broadcastreceiverapplication;

import com.example.broadcastreceiverapplication.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class SenderActivity extends Activity{
	private Button broadcastBtn;
	private TextView messageTxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		messageTxt=(TextView)findViewById(R.id.send_text);
		broadcastBtn=(Button)findViewById(R.id.broadcast_btn);
	
		broadcastBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent=new Intent();
				intent.setAction("com.pcs.SEND_MESSAGE");
				intent.putExtra(Constant.AddExtaras.TEXT, messageTxt.getText().toString());
		
			    sendBroadcast(intent);
				
				
			}
		
		});
		
		
		
	}

}
