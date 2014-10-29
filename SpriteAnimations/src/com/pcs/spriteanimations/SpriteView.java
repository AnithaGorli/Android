package com.pcs.spriteanimations;
import com.example.spriteanimations.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
public class SpriteView extends View{
	//Constructor for the SpriteView
	public SpriteView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context = context;
		init();
	}
	private int currentFrame;
	public Context context;
	public int frameWidth;
	public int frameHeight;
	private int frameNr;        // number of frames in animation
	
	private long frameTicker;   // the time of the last frame update
	private int framePeriod; 
	Bitmap spriteSheet = BitmapFactory.decodeResource(getResources(), R.drawable.walk_elaine);
	Rect source = new Rect(0,0,frameWidth,frameHeight);
	Rect destination = new Rect();
	public int x,y;
	public boolean go;
	public AnimationThread spriteThread;

	private void init() {
		//framewidth,frameHeigh,source and destination of the image
		frameWidth = spriteSheet.getWidth()/5;
		frameHeight = spriteSheet.getHeight()/1;
		destination.left = destination.top = 0;
		destination.right = frameWidth;
		destination.bottom = frameHeight;
		//update(System.currentTimeMillis());

	}
	public void startAnimation() {
		//When user clicks on StartAnimation() Button Animation will run
		go = true;
		//Initiatlizing Thread
		spriteThread = new AnimationThread();
		//starting spriteThread
		//update(System.currentTimeMillis());
		spriteThread.start();
	

	}
	public void stopAnimation() {
		//When user clicks on StopAnimation() Button Animation will stop
		go=false;
		try{
			spriteThread.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
public void update(long gameTime) {
		framePeriod = 1000 / 5;
		frameNr = 5;
		frameTicker = 0l;
		if (gameTime > frameTicker + framePeriod) {
			frameTicker = gameTime;
			// increment the frame
			currentFrame++;
			if (currentFrame >= frameNr) {
				currentFrame = 0;
			}
		}
		// define the rectangle to cut out sprite
		this.source.left = currentFrame * frameWidth;
		this.source.right = this.source.left + frameWidth;
	}
	@Override
	protected void onDraw(Canvas canvas) {
		Rect destRect = new Rect(0, 0,  0+frameWidth, 0+frameHeight);
		canvas.drawBitmap(spriteSheet, source, destination, null);
		canvas.drawBitmap(spriteSheet, 20, 150, null);
		Paint paint = new Paint();
		paint.setARGB(50, 255, 0, 255);
		canvas.drawRect(20+ (currentFrame * destRect.width()), 150, 20
				+ (currentFrame * destRect.width())
			+ destRect.width(), 150 + destRect.height(),  paint);
		canvas.drawBitmap(spriteSheet, source, destination, null);
	}
	public class AnimationThread extends Thread{
		public int screenWidth,screenHeight;
		//speed of the animation
		int speed=20;
		@Override
		public void run() {
			screenWidth = getWidth();
			screenHeight = getHeight();
			int destleft=0,desttop=0;
			
			while(go) {
				for(int rows=0;rows<1;rows++) {
					for(int columns=0;columns<4;columns++) {
						//animation will start at the first Frame in the SpriteSheet
						update(System.currentTimeMillis());
						source.left = columns*frameWidth;
						source.top = rows*frameHeight;
						source.right = source.left+frameWidth;
						source.bottom = source.top+frameHeight;
						destination.left = destleft;
						destination.top = desttop;
						int flag=destination.left;
						destination.right = destination.left+frameWidth;
						destination.bottom = destination.top+frameHeight;
						//to show the animation side by side like movement of animation by frames
						destleft=destination.right;
						desttop=destination.top;
						//if width of emulator exceeds then image will start from left of emulator
						if(flag > 2*spriteSheet.getWidth()){
							destleft=0;
							desttop=0;
						}

						postInvalidate();
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}// end of inner for()

				}// end of outer for()

			}// end of while()
		}// end of run()
	}
}
