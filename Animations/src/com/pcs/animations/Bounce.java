package com.pcs.animations;

import com.example.animations.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

public class Bounce extends Activity implements AnimationListener{
	private TextView textMessage;
	Animation animBounce;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.bounce);
	      
	        textMessage = (TextView) findViewById(R.id.text);
	        
	        
	       
	        
	        animBounce = AnimationUtils.loadAnimation(getApplicationContext(),
	                R.anim.bounce);    
	        animBounce.setAnimationListener(this);
	        
	    
	   
	    
	    }
	    
	      
	        
	        public void bounceText(View view){
	        	textMessage.setVisibility(View.VISIBLE);
	            textMessage.startAnimation(animBounce);   
	      
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


