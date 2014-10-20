package com.pcs.navigationtabsapplication;

import com.example.navigationtabsapplication.R;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;

public class MyActivity extends Activity {
	public TabListener listener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		ActionBar actionbar = getActionBar() ;
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionbar.setDisplayShowTitleEnabled(false);
		ActionBar.Tab tab_one,tab_two;

		//creating friends tab
		tab_one= actionbar.newTab();
		tab_one.setText(R.string.tab_one);
		//tab_one.setIcon(R.drawable.friends);
		tab_one.setTabListener(new TabListener(new FragmentOne()));
		actionbar.addTab(tab_one);	
		
		//creating Gallery tab
		tab_two= actionbar.newTab();
		tab_two.setText(R.string.tab_two);
		//tab_two.setIcon(R.drawable.gallery);
		tab_two.setTabListener(new TabListener(new FragmentTwo()));	
		actionbar.addTab(tab_two);	



	}
}
