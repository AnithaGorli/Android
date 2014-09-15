package com.pcs.listexampleapplication;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.example.listexampleapplication.R;
import com.pcs.adapter.ListAdapter;
import com.pcs.model.User;

public class ListActivity extends Activity{
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
		Button createBtn=(Button)findViewById(R.id.create_btn);
		createBtn.setOnClickListener(new OnClickListener() {



			@Override
			public void onClick(View v) {

				Intent intent=new Intent(ListActivity.this,FirstActivity.class);
				startActivityForResult(intent, REQUEST_A);

			}

		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);

		if(data!=null){
			User user=new User();
			String name=data.getStringExtra(Constants.AddingExtras.NAME);	
			String phone=data.getStringExtra(Constants.AddingExtras.PHONE);
			String address=data.getStringExtra(Constants.AddingExtras.ADDRESS);
        //Adding user
			user.setName(name);
			user.setPhone(phone);
			user.setAddress(address);
			userlist.add(user);


			adapter =new ListAdapter(ListActivity.this, userlist);
			listview.setAdapter(adapter);

		}


}

}
