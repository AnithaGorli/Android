package com.pcs.fragmentsviewpager;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
//Second Fragment which Displays Versions of Android,it uses list
public class MyFragmentTwo extends ListFragment{
	String android_versions[] = new String[]{
			"Android Vertions:",
			"",
			"Jelly Bean",
			"IceCream Sandwich",
			"HoneyComb",
			"Ginger Bread",
			"Froyo",
			"Eclair","Donut","cupcake"
	};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, android_versions);

		/** Setting the array adapter to the listview */

		setListAdapter(adapter);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
