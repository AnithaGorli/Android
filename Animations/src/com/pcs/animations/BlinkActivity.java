package com.pcs.animations;

import com.example.animations.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class BlinkActivity extends Activity implements AnimationListener{
	private TextView textMessage;
	Animation animBlink;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.blink);
	      
	        textMessage = (TextView) findViewById(R.id.text);
	        
	        
	       
	        
	        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
	                R.anim.blink);    
	        animBlink.setAnimationListener(this);
	        
	    
	   
	    
	    }
	    
	      
	        
	        public void blinkText(View view){
	        	textMessage.setVisibility(View.VISIBLE);
	            textMessage.startAnimation(animBlink);   
	      
	}
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			
	    }
	}


