package com.pcs.fragmentsviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentsviewpager.R;
public class MyFragmentOne extends Fragment {

//First Fragment which Displays Introduction of Android
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

//inflating fragmentone xml
		View v = inflater.inflate(R.layout.fragmentone, container, false);

		return v;
	}
}