package com.pcs.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menuapplication.R;
import com.pcs.menuapplication.ListActivity;
import com.pcs.model.User;

public class GlobalAdapter extends BaseAdapter {

	private Context lcontext;
	private ArrayList<User> userlist;
	private LayoutInflater layoutInflater;


	
	public GlobalAdapter(ListActivity listActivity, ArrayList<User> userlist2) {
	lcontext=listActivity;
	userlist=userlist2;
	layoutInflater=LayoutInflater.from(lcontext);
		
	}

	@Override
	public int getCount() {

		return userlist.size();
	}

	@Override
	public User getItem(int position) {

		return userlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewContainer container = null;
		User user= (User)getItem(position);
		if(convertView==null){
			convertView = layoutInflater.inflate(R.layout.addcontact, null);
			container = new ViewContainer();
			container.imageView=(ImageView) convertView.findViewById(R.id.image_view);
			container.nameTxt=(TextView) convertView.findViewById(R.id.name_view);
			container.phoneTxt=(TextView) convertView.findViewById(R.id.phone_view);
			container.emailTxt=(TextView) convertView.findViewById(R.id.email_view);
			convertView.setTag(container);
		}
		else
		{
			container=(ViewContainer)convertView.getTag();
		}
		container.imageView.setBackgroundResource(R.drawable.image_contact);
		container.nameTxt.setText(user.getName());
		container.phoneTxt.setText(user.getPhone());
		container.emailTxt.setText(user.getEmail());
		return convertView;
	}
	public class ViewContainer{
		
		public	TextView nameTxt;
		public TextView phoneTxt;
		public TextView emailTxt;
		public ImageView imageView;
	}
	public void adduser(User user) throws IllegalArgumentException{
		if(userlist!=null){
			if(user==null){
				throw new IllegalArgumentException("User should not be null");
			}
			userlist.add(user);
			notifyDataSetChanged();
		}
	}

}
