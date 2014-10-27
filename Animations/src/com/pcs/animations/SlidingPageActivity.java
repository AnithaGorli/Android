package com.pcs.animations;



import com.example.animations.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

public class SlidingPageActivity extends Activity implements AnimationListener{
	private TextView textMessage;
	Animation animSlidUp,animSlidDown;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.slide);
	      
	        textMessage = (TextView) findViewById(R.id.text);
	        
	        animSlidUp = AnimationUtils.loadAnimation(getApplicationContext(),
	                R.anim.slid_up); 
	        animSlidUp.setAnimationListener(this);
	       
	        
	        animSlidDown = AnimationUtils.loadAnimation(getApplicationContext(),
	                R.anim.slid_down);    
	        animSlidDown.setAnimationListener(this);
	        
	    
	   
	    
	    }
	    
	        public void slidUp(View view){
	        	textMessage.setVisibility(View.VISIBLE);
	        textMessage.startAnimation(animSlidUp);
	        }
	        
	        public void slidDown(View view){
	        	textMessage.setVisibility(View.VISIBLE);
	            textMessage.startAnimation(animSlidDown);   
	      
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


