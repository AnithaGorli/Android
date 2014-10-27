package com.pcs.animations;

import com.example.animations.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

public class RotateActivity extends Activity  implements AnimationListener{
	private TextView textMessage;
	Animation animRotate;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.rotate);
	      
	        textMessage = (TextView) findViewById(R.id.text);
	        
	        
	       
	        
	        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
	                R.anim.rotate);    
	        animRotate.setAnimationListener(this);
	        
	    
	   
	    
	    }
	    
	      
	        
	        public void rotateText(View view){
	        	textMessage.setVisibility(View.VISIBLE);
	            textMessage.startAnimation(animRotate);   
	      
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


