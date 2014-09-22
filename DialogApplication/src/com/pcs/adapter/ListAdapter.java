package com.pcs.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.dialogapplication.R;
import com.pcs.model.User;

public class ListAdapter extends BaseAdapter {

	private Context lcontext;
	private ArrayList<User> userlist;
	private LayoutInflater layoutInflater;



	public ListAdapter(Context context ,ArrayList<User> users) {
		lcontext=context;
		userlist=users;
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
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewContainer container = null;
		User user= (User)getItem(position);
		if(convertView==null){
			convertView = layoutInflater.inflate(R.layout.addingcontacts, null);
			container = new ViewContainer();
			container.imageView=(ImageView) convertView.findViewById(R.id.image);
			container.nameTxt=(TextView) convertView.findViewById(R.id.name_txt);
			container.phoneTxt=(TextView) convertView.findViewById(R.id.phone_txt);
			container.addressTxt=(TextView) convertView.findViewById(R.id.address_txt);
			convertView.setTag(container);
		}
		else
		{
			container=(ViewContainer)convertView.getTag();
		}
		container.imageView.setBackgroundResource(user.getImage());
		container.nameTxt.setText(user.getName());
		container.phoneTxt.setText(user.getPhone());
		container.addressTxt.setText(user.getAddress());
		return convertView;
	}
	public class ViewContainer{
		public	ImageView imageView;	
		public	TextView nameTxt;
		public TextView phoneTxt;
		public TextView addressTxt;
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



