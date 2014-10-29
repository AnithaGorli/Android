package com.pcs.frameanimation;




import com.example.frameanimation.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
public class MainActivity extends Activity{
	private AnimationDrawable frameAnimation;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ImageView gyroView = (ImageView) findViewById(R.id.imageview);
		//setting  background of the image view i.e animation list
		gyroView.setBackgroundResource(R.anim.gygro_animations);
		
		frameAnimation=(AnimationDrawable)gyroView.getBackground();
		
	
	}
	//when i click on image animation will start
	
	public void startAnimation(View view) {
		// TODO Auto-generated method stub
		frameAnimation.start();
		
	}
}
