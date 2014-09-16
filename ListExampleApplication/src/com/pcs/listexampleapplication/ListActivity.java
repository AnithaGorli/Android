package com.pcs.listexampleapplication;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listexampleapplication.R;
import com.pcs.adapter.ListAdapter;
import com.pcs.model.User;

public class ListActivity extends Activity {
	public static final int REQUEST_A=101;
	public ArrayList<User> userlist;
	public ListAdapter adapter;
	public ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlist);


		listview=(ListView)findViewById(R.id.main_list);
		userlist= new ArrayList<User>();
		adapter =new ListAdapter(ListActivity.this, userlist);
		listview.setCacheColorHint(Color.TRANSPARENT);
		listview.setFadingEdgeLength(0);
		Button createBtn=(Button)findViewById(R.id.create_btn);



		createBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//sending intent from one Activity to another
				Intent intent=new Intent(ListActivity.this,FirstActivity.class);
				startActivityForResult(intent, REQUEST_A);

			}

		});

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent1=new Intent(ListActivity.this,InteractionActivity.class);

				intent1.putExtra(Constants.AddingExtras.NAME,userlist.get(position).getName());
				intent1.putExtra(Constants.AddingExtras.PHONE, userlist.get(position).getPhone());
				intent1.putExtra(Constants.AddingExtras.ADDRESS, userlist.get(position).getAddress());

				startActivity(intent1);

			}
		});

	}





	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			if(data!=null){
				User user=new User();
				String name=data.getStringExtra(Constants.AddingExtras.NAME);	
				String phone=data.getStringExtra(Constants.AddingExtras.PHONE);
				String address=data.getStringExtra(Constants.AddingExtras.ADDRESS);
				int image=data.getIntExtra(Constants.AddingExtras.IMAGE, 0);
				//Adding user
				user.setName(name);
				user.setPhone(phone);
				user.setAddress(address);
				user.setImage(image);
				userlist.add(user);
				adapter =new ListAdapter(ListActivity.this, userlist);
				listview.setAdapter(adapter);

			}
		
	
		}
		else if(resultCode==RESULT_CANCELED){


			Toast.makeText(ListActivity.this,getResources().getString(R.string.app), Toast.LENGTH_LONG).show();

		}
	}
}


	