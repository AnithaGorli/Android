package com.pcs.menuapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menuapplication.R;
import com.pcs.adapter.GlobalAdapter;
import com.pcs.model.User;
/**
 * This is the first Activity 
 * It will display contacts
 * @author pcs-05
 *
 */
public class ListActivity extends Activity{
	public ArrayList<User> userlist;
	public GlobalAdapter adapter;
	public ListView listview;
	private TextView contacts;
	public static final int REQUEST_A=101;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_list);
		listview=(ListView)findViewById(R.id.family_list_view);
		userlist= new ArrayList<User>();

		listview.setCacheColorHint(Color.TRANSPARENT);
		listview.setFadingEdgeLength(0);
		contacts=(TextView)findViewById(R.id.contacts_list);

		/**
		 * when you click on contacts view it will directed to menu Activity
		 * And result will come back to this Activity

		 */

		contacts.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View v) {

				Intent intent=new Intent(ListActivity.this,MenuActivity.class);
				startActivityForResult(intent, REQUEST_A);	
			}

		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) throws IllegalArgumentException{

		super.onActivityResult(requestCode, resultCode, data);
		/**
		 * if List Activity send any result back to this Activity
		 * If the Result is ok then it will create a user and append this user to listview
		 * information is in data which is an intent 
		 * then information is get from the data and set into the user
		 * 
		 * 
		 */
		if(resultCode==RESULT_OK){
			if(data!=null){

				String name=data.getStringExtra(Constants.AddingExtras.NAME);
				String phone=data.getStringExtra(Constants.AddingExtras.PHONE);
				String mail=data.getStringExtra(Constants.AddingExtras.MAIL);
				/**
				 * Creating User Object
				 * set data into user object
				 */

				User user=new User();
				user.setName(name);
				user.setPhone(phone);
				user.setEmail(mail);
				user.setImage(R.drawable.image_contact);
				//adding user to the userlist
				userlist.add(user);
				//setting userlist to the adapter
				adapter =new GlobalAdapter(ListActivity.this, userlist);
				//setting adapter to listview 
				listview.setAdapter(adapter);
			}
			else{
				throw new IllegalArgumentException(getResources().getString(R.string.message));
			}
		}
		
		
		/**
		 * if result is canceled no user will created
		 */
		else if(resultCode==RESULT_CANCELED){
			Toast.makeText(ListActivity.this,getResources().getString(R.string.message), Toast.LENGTH_LONG).show();
		}	

	}
}

