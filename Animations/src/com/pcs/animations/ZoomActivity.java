package com.pcs.animations;



import com.example.animations.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ZoomActivity extends Activity implements AnimationListener{
private TextView textMessage;
Animation animZoonin,animZoomout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoom);
      
        textMessage = (TextView) findViewById(R.id.text);
        
        animZoonin = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_in); 
        animZoonin.setAnimationListener(this);
       
        
        animZoomout = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_out);    
        animZoomout.setAnimationListener(this);
        
    
   
    
    }
    
        public void zoomIn(View view){
        	textMessage.setVisibility(View.VISIBLE);
        textMessage.startAnimation(animZoonin);
        }
        
        public void zoomOut(View view){
        	textMessage.setVisibility(View.VISIBLE);
            textMessage.startAnimation(animZoomout);   
      
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
