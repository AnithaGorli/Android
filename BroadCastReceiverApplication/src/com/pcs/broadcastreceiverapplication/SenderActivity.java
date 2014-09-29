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
	private Button startBtn;
	private TextView sendtxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sendtxt=(TextView)findViewById(R.id.send_text);
		startBtn=(Button)findViewById(R.id.broadcast_btn);
	
		startBtn.setOnClickListener(new OnClickListener() {
			/**
			 * text field will take message and then
			 * when i click on start button data will be broadcasted to all who are registered
			 */
			@Override
			public void onClick(View v) {
				
				Intent intent=new Intent();
				intent.setAction("com.pcs.SEND");
				intent.putExtra(Constant.AddExtaras.TEXT, sendtxt.getText().toString());
				//start broadcasting message
			    sendBroadcast(intent);
				
				
			}
		
		});
		
		
		
	}

}
