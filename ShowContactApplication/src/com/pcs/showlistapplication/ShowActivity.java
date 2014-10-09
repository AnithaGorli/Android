package com.pcs.showlistapplication;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ShowActivity extends Activity {
	private ListView listview;
	private Button deleteBtn;
	//private MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);

		listview=(ListView)findViewById(R.id.contactlist);
		listview.setCacheColorHint(Color.TRANSPARENT);
		listview.setFadingEdgeLength(0);
		listview.setDividerHeight(3);
		deleteBtn=(Button)findViewById(R.id.deletebtn);



		String choice=getIntent().getAction();

		if(choice.equals(Constants.AddExtras.SHOW_INFO)){

			//Accessing Content provider
			ContentResolver resolver = getContentResolver();

			Uri uri = Uri.parse("content://com.pcs.provider.Customer/customers");
			//Retrieving and displaying data in a list 
			Cursor cursor = resolver.query(uri, null, null, null, null);

			while(cursor.moveToNext())
			{
				SimpleCursorAdapter simpleAdapter = new SimpleCursorAdapter(ShowActivity.this, R.layout.customlistview, cursor, 
						new String[]{ "name", "email", "office", "phone"}, 
						new int[]{R.id.list_name,R.id.list_email,R.id.list_office,R.id.list_phone});
				listview.setAdapter(simpleAdapter);
			}


			/**
			 * if you click on delete contacts button ,all contacts will be deleted in database as well as in list
			 */
			deleteBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					ContentResolver mResolver = getContentResolver();
					Uri uri = Uri.parse("content://com.pcs.provider.Customer/customers");

					mResolver.delete(uri, null, null);
					Toast.makeText(ShowActivity.this, getResources().getString(R.string.deleted), Toast.LENGTH_LONG).show(); 


				}
			});



		}

	}
}














