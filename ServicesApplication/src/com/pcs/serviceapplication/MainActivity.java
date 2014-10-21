package com.pcs.serviceapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.servicesapplication.R;

//Implement SurfaceHolder interface to Play video
//Implement this interface to receive information about changes to the surface
public class MainActivity extends Activity implements SurfaceHolder.Callback{
	
	
	 MediaPlayer mediaPlayer;
	    SurfaceView surfaceView;
	    SurfaceHolder surfaceHolder;
	    boolean pausing = false;
	    
	    /** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		 Button playVideo = (Button)findViewById(R.id.playvideo);
         Button stopVideo = (Button)findViewById(R.id.stopvideo);

         
         
	       getWindow().setFormat(PixelFormat.UNKNOWN);
	        
	        //Displays a video file.  
	        VideoView videoplayer = (VideoView)findViewById(R.id.videoview);
	        
	         
	        String uriPath = "android.resource://package com.pcs.serviceapplication/"+R.raw.nature;
	        Uri uri = Uri.parse(uriPath);
	        videoplayer.setVideoURI(uri);
	        videoplayer.requestFocus();
	        videoplayer.start();
	 
	         
	         
	        playVideo.setOnClickListener(new Button.OnClickListener(){
	 
	            @Override
	            public void onClick(View v) {
	             
	            	 //Displays a video file.  
	    	        VideoView videoplayer = (VideoView)findViewById(R.id.videoview);
	    	        
	    	         
	    	        String uriPath = "android.resource://package com.pcs.serviceapplication/"+R.raw.nature;    	     
	    	        Uri uri = Uri.parse(uriPath);
	    	        videoplayer.setVideoURI(uri);
	    	        videoplayer.requestFocus();
	    	        videoplayer.start();
	    	        Toast.makeText(getBaseContext(), "Video is Playing", Toast.LENGTH_SHORT).show();
	                 
	                 
	            }});
	        
	        stopVideo.setOnClickListener(new Button.OnClickListener(){
	   @Override
	            public void onClick(View v) {
	            mediaPlayer.stop();
	              Toast.makeText(getBaseContext(), "Video stopped", Toast.LENGTH_SHORT).show();
	              	mediaPlayer.release();  
	                 
	            }}); 
	
		}
	/**
	 * Methods For Service
	 * @param view
	 */
	
	// Method to start the service
	   public void playMusic(View view) {
	      startService(new Intent(getBaseContext(), MyService.class));
	   }

	   // Method to stop the service
	   public void stopMusic(View view) {
	      stopService(new Intent(getBaseContext(), MyService.class));
	   }
	   
	   
	   
	   /**
	    * Methods for supporting to play Video
	    */
	   
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		mediaPlayer.stop();
		mediaPlayer.release();
	}

}
