package com.example.serverrequestapplication.test;

import com.pcs.serverrequestapplication.RequestActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RequestActivityTest extends ActivityInstrumentationTestCase2<RequestActivity> {
	private TextView name, gender,city;
	private Button downloadBtn;
	public RequestActivity activity;
	public RequestActivityTest() {
		super(RequestActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		activity = getActivity();
		assertNotNull(activity); 
		name = (TextView) activity
				.findViewById(com.example.serverrequestapplication.R.id.name);
		gender = (TextView) activity
				.findViewById(com.example.serverrequestapplication.R.id.gender);
		city = (TextView) activity
				.findViewById(com.example.serverrequestapplication.R.id.city);
		downloadBtn = (Button) activity
				.findViewById(com.example.serverrequestapplication.R.id.download_btn);
		
		
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	

	
	protected void test_validate(){
		
	 TouchUtils.clickView(this, downloadBtn);
		

	}
}
