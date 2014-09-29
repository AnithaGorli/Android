package com.pcs.broadcastreceiverapplication;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.broadcastreceiverapplication.R;

public class ReceiverActivity extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
   //get the message from sender
		String message = intent.getStringExtra(Constant.AddExtaras.TEXT);
/**
 * If message is empty notification should not be sent
 * otherwise shows Notification
 */
     Boolean data=TextUtils.isEmpty(message);
		if(data==false){
			/**
			 * creating notification object
			 * setting icon , title and text foe notification
			 */
			NotificationCompat.Builder builder= new NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_launcher).
					setContentTitle(context.getResources().getText(R.string.notification))
					.setContentText(message);

			Intent resultIntent = new Intent();
			//setting flags for showing notification order and appearance
			resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK   | Intent.FLAG_ACTIVITY_CLEAR_TOP);

			PendingIntent resultPendingIntent =PendingIntent.getBroadcast(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);


			builder.setContentIntent(resultPendingIntent);
			builder.setAutoCancel(true);
			NotificationManager NotificationManager =
					(NotificationManager)context. getSystemService(Context.NOTIFICATION_SERVICE);

			NotificationManager.notify(0, builder.build());
		}
		//if message is empty just print the toast ,won't broadcast
		else{
			Toast.makeText(context,context.getResources().getText(R.string.error), Toast.LENGTH_LONG).show();
		     }


	}

}
