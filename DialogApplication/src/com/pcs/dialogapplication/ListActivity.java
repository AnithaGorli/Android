package com.pcs.dialogapplication;


import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.dialogapplication.R;
import com.pcs.adapter.ListAdapter;



import com.pcs.model.User;

public class ListActivity extends Activity {
	public static final int REQUEST_A=101;
	public ArrayList<User> userlist;
	public ListAdapter adapter;
	public ListView listview;
	private AlertDialog.Builder builder;
	private AlertDialog alert;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);


		listview=(ListView)findViewById(R.id.list_view);
		userlist= new ArrayList<User>();
		adapter =new ListAdapter(ListActivity.this, userlist);
		listview.setCacheColorHint(Color.TRANSPARENT);
		listview.setFadingEdgeLength(0);


		Button createBtn=(Button)findViewById(R.id.create_btn);



		createBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//sending intent from one Activity to another
				Intent intent=new Intent(ListActivity.this,DialogActivity.class);
				startActivityForResult(intent, REQUEST_A);

			}

		});



		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				builder = new AlertDialog.Builder(ListActivity.this);
				builder.setTitle(R.string.delete_title);
				builder.setMessage(R.string.delete_message);

				alert=builder.create();
				alert.show();

				builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {


					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}



				});

				builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {


					@Override
					public void onClick(DialogInterface dialog, int which) {



						alert.dismiss();

					}

				});
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			if(data!=null){
		
		String name=data.getStringExtra(Constants.AddingExtras.NAME);	
		String phone=data.getStringExtra(Constants.AddingExtras.PHONE);
		String address=data.getStringExtra(Constants.AddingExtras.ADDRESS);
		int image=data.getIntExtra(Constants.AddingExtras.IMAGE, 0);
		//int color=getIntent().getIntExtra(Constants.AddingExtras.COLOR, 0);
		//Adding user
		User user=new User();
		user.setName(name);
		user.setPhone(phone);
		user.setAddress(address);
		user.setImage(image);

		userlist.add(user);
		adapter =new ListAdapter(ListActivity.this, userlist);
		listview.setAdapter(adapter);
		//listview.setBackgroundColor(color);
	}

		}
		else if(resultCode==RESULT_CANCELED){


			Toast.makeText(ListActivity.this,getResources().getString(R.string.app_name), Toast.LENGTH_LONG).show();

	}
	}
}























