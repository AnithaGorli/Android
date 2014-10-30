package com.pcs.fragmentsviewpager;
import java.util.ArrayList;
/**
 * This Activity uses view pager
 * The ViewPager is the widget that allows the user to swipe left 
 * or right to see an entirely new screen.
 */
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.fragmentsviewpager.R;
public class PageViewActivity extends FragmentActivity {
	MyPageAdapter pageAdapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		List<Fragment> fragments = getFragments();
		pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
		ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
		pager.setAdapter(pageAdapter);
	}
	private List<Fragment> getFragments(){
		//creating a list for array of fragments
		
		List<Fragment> fList = new ArrayList<Fragment>();
		//adding first fragment
		try{
		MyFragmentOne one=new MyFragmentOne();
		fList.add(one);
		//adding Second fragment
		MyFragmentTwo two=new MyFragmentTwo();
		fList.add(two);
		//adding third fragment
		MyFragmentThree three=new MyFragmentThree();
		fList.add(three); }
		catch(IllegalArgumentException e){
		e.printStackTrace();	
		}
		return fList;
	}

	/**
	 * The Page Adapter’s job is to supply Fragments (instead of views) to the UI for drawing.
	 *  This is a class that inherits from the FragmentPageAdapater class. 
	 *
	 */
	private class MyPageAdapter extends FragmentPagerAdapter {
		private List<Fragment> fragments;
		public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}
		@Override
		public Fragment getItem(int position) {
			return this.fragments.get(position);
		}
		@Override
		public int getCount() {
			return this.fragments.size();
		}
	}
}