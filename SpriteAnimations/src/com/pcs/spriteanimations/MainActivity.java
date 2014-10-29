package com.pcs.spriteanimations;

import com.example.spriteanimations.R;


import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
public class MainActivity extends Activity{

	public SpriteView spriteView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	spriteView = (SpriteView) findViewById(R.id.spriteView);
	spriteView.startAnimation();
	}
	
	

	}

