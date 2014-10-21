package com.pcs.serviceapplication;

import com.example.servicesapplication.R;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service{
	MediaPlayer player;



	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
		player = MediaPlayer.create(this,R.raw.music);
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// Let it continue running until it is stopped.
		player.start();
		Toast.makeText(this, "Music is playing", Toast.LENGTH_LONG).show();
		return START_STICKY;
	}

//when service is stopped player will stopped and released
	public void onStop(){
		player.stop();
		player.release();
	}

	public void onPause(){
		player.stop();
		player.release();
	}


	@Override
	public void onDestroy() {
		//when service is destroyed player will automatically stopped
		player.stop();
		Toast.makeText(this, "Music stopped", Toast.LENGTH_SHORT).show();
		player.release();
		Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	}

}
