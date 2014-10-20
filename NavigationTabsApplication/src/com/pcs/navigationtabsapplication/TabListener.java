package com.pcs.navigationtabsapplication;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;

import com.example.navigationtabsapplication.R;

public  class TabListener implements ActionBar.TabListener{
	private Fragment fragment;
	//Constructor
	public TabListener(Fragment fragment) {
		this.fragment= fragment;
	}
   //By selecting the tab replacing the view by Fragment
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		ft.replace(R.id.container, fragment);

	}
//removing fragment by Unselecting the tab
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

		ft.remove(fragment);
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}
}