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

		String message = intent.getStringExtra(Constant.AddExtaras.TEXT);

		Boolean info=TextUtils.isEmpty(message);
		if(!info){

			NotificationManager NotificationManager =
					(NotificationManager)context. getSystemService(Context.NOTIFICATION_SERVICE);

			NotificationCompat.Builder builder= new NotificationCompat.Builder(context).setSmallIcon(R.drawable.login).
					setContentTitle(context.getResources().getText(R.string.notification))
					.setContentText(message);

			Intent resultIntent = new Intent();


			resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK   | Intent.FLAG_ACTIVITY_CLEAR_TOP);

			PendingIntent resultPendingIntent =PendingIntent.getBroadcast(context, 0, resultIntent, 				PendingIntent.FLAG_UPDATE_CURRENT);


			builder.setContentIntent(resultPendingIntent);
			builder.setAutoCancel(true);



			NotificationManager.notify(0, builder.build());
		}

		else{
			Toast.makeText(context,context.getResources().getText(R.string.error), Toast.LENGTH_LONG).show();
		}


	}

}
