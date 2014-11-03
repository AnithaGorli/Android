package com.pcs.databaseapplication;

import com.example.databaseapplication.R;
import com.pcs.helper.MySqliteHelper;
import com.pcs.model.Contact;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;

public class ShowContactsActivity extends Activity{
	private ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		listview=(ListView)findViewById(R.id.contactlist);
		listview.setCacheColorHint(Color.TRANSPARENT);
		listview.setFadingEdgeLength(0);
		listview.setDividerHeight(3);
		
		MySqliteHelper helper=new MySqliteHelper(ShowContactsActivity.this);
		SQLiteDatabase sqlitedb=helper.getReadableDatabase();
		Cursor mCursor =sqlitedb.rawQuery("select * from  "+helper.TABLE_NAME, null);
		SimpleCursorAdapter simpleAdapter = new SimpleCursorAdapter(ShowContactsActivity.this, R.layout.customlist, mCursor, 
				new String[]{ "username", "password", "phone"}, 
				new int[]{R.id.list_username,R.id.list_password,R.id.list_email,R.id.list_phone});
		listview.setAdapter(simpleAdapter);
		


				
		
	}

		
	}
	


