package com.example.model;

import java.util.ArrayList;

import android.R.color;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.slidingdrawerapplication.GridAdapter;
import com.example.slidingdrawerapplication.R;

public class MainFragment extends Fragment {
	private Song songObj;
	public static final String ITEM_POSITION = "item_name";

	public MainFragment() {
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View rootView = inflater.inflate(R.layout.fragment_grid, container,
				false);

		GridView gridView = (GridView) rootView.findViewById(R.id.gridview);

		gridView.setCacheColorHint(color.transparent);
		gridView.setFadingEdgeLength(0);

		ArrayList<Song> songs = new ArrayList<Song>();
		GridAdapter adapter = new GridAdapter(getActivity(), songs);
		// creating album
		songObj = new Song();
		songObj.setImage(R.drawable.image_001);
		songObj.setTitle(getResources().getString(R.string.album_one));
		songObj.setSingers(getResources().getString(R.string.album_one_singers));
		songs.add(songObj);

		songObj = new Song();
		songObj.setImage(R.drawable.image_002);
		songObj.setTitle(getResources().getString(R.string.album_two));
		songObj.setSingers(getResources().getString(R.string.album_two_singers));
		songs.add(songObj);

		songObj = new Song();
		songObj.setImage(R.drawable.music);
		songObj.setTitle(getResources().getString(R.string.album_three));
		songObj.setSingers(getResources().getString(
				R.string.album_three_singers));
		songs.add(songObj);

		songObj = new Song();
		songObj.setImage(R.drawable.image_004);
		songObj.setTitle(getResources().getString(R.string.album_four));
		songObj.setSingers(getResources()
				.getString(R.string.album_four_singers));
		songs.add(songObj);

		songObj = new Song();
		songObj.setImage(R.drawable.image_005);
		songObj.setTitle(getResources().getString(R.string.album_five));
		songObj.setSingers(getResources()
				.getString(R.string.album_five_singers));
		songs.add(songObj);

		songObj = new Song();
		songObj.setImage(R.drawable.image_006);
		songObj.setTitle(getResources().getString(R.string.album_six));
		songObj.setSingers(getResources().getString(R.string.album_six_singers));
		songs.add(songObj);

		gridView.setAdapter(adapter);

		return rootView;

	}
}