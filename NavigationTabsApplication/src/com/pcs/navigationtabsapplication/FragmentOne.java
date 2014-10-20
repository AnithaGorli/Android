package com.pcs.navigationtabsapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationtabsapplication.R;

public class FragmentOne extends Fragment{

	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	View view=	inflater.inflate(R.layout.fragmnetone,container,false);
		return view;
	}
}
