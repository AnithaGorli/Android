package com.pcs.fragmentsviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentsviewpager.R;
public class MyFragmentThree extends Fragment {
private View v;
	//Third Fragment which Displays Icon of Android
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//inflating fragment three xml
		
		View v = inflater.inflate(R.layout.fragmentthree, container, false);
		
		return v;
	}

	}
