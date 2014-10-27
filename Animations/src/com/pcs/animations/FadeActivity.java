package com.pcs.animations;

import com.example.animations.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class FadeActivity extends Activity implements AnimationListener{
	private TextView textMessage;
	Animation animFadein,animFadeout;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.fade);
	      
	        textMessage = (TextView) findViewById(R.id.text);
	        
	        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
	                R.anim.fade_in); 
	        animFadein.setAnimationListener(this);
	       
	        
	        animFadeout = AnimationUtils.loadAnimation(getApplicationContext(),
	                R.anim.fade_out);    
	        animFadeout.setAnimationListener(this);
	        
	    
	   
	    
	    }
	    
	        public void fadeIn(View view){
	        	textMessage.setVisibility(View.VISIBLE);
	        textMessage.startAnimation(animFadein);
	        }
	        
	        public void fadeOut(View view){
	        	textMessage.setVisibility(View.VISIBLE);
	            textMessage.startAnimation(animFadeout);   
	      
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

