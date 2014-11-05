package com.example.slidingdrawerapplication;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Song;

public class GridAdapter extends BaseAdapter{
	private Context lcontext;
	private ArrayList<Song> songlist;
	private LayoutInflater layoutInflater;
	

	public GridAdapter(Context mainFragment, ArrayList<Song> songs) {
		// TODO Auto-generated constructor stub
	       lcontext=mainFragment;
		songlist=songs;
		layoutInflater=LayoutInflater.from(lcontext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return songlist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return songlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewContainer container = null;
		Song song= (Song)getItem(position);
		if(convertView==null){
			convertView = layoutInflater.inflate(R.layout.custom_grid, null);
			container = new ViewContainer();
			container.imageView=(ImageView) convertView.findViewById(R.id.grid_image);
			container.titleTxt=(TextView) convertView.findViewById(R.id.grid_title);
			container.singersTxt=(TextView) convertView.findViewById(R.id.grid_singers);
			container.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			convertView.setTag(container);
		}
		else
		{
			container=(ViewContainer)convertView.getTag();
		}
		container.imageView.setBackgroundResource(song.getImage());
		container.titleTxt.setText(song.getTitle());
		container.singersTxt.setText(song.getSingers());
		
		return convertView;
	}
	public class ViewContainer{
		public	ImageView imageView;	
		public	TextView titleTxt;
		public TextView singersTxt;
		
	}
	public void adduser(Song song) throws IllegalArgumentException{
		if(songlist!=null){
			if(song==null){
				throw new IllegalArgumentException("User should not be null");
			}
			songlist.add(song);
			notifyDataSetChanged();
		}
	}

}
