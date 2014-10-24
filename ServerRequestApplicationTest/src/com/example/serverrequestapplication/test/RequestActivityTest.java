package com.example.serverrequestapplication.test;

import org.json.JSONObject;

import com.pcs.serverrequestapplication.RequestActivity;

import android.R.bool;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RequestActivityTest extends
ActivityInstrumentationTestCase2<RequestActivity> {
	private TextView name, gender, city;
	private Button downloadBtn;
	public static final String STR ="{\"id\":\"591658927624314\",\"first_name\":\"Anitha\",\"username\":\"anitha.honey784\",\"name\":\"Anitha Honey\",\"locale\":\"en_US\",\"link\":\"https:\\/\\/www.facebook.com\\/anitha.honey784\",\"last_name\":\"Honey\",\"gender\":\"female\"}";
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
	/**
	 * Check whether getting the context or not
	 * checking whether views are available or not
	 */
	public void testPreconditions() {
		assertNotNull("Failed getting activity context", getActivity());
		assertNotNull("Can't find a view... Has layout changed?", name);
		assertNotNull("Can't find a view... Has layout changed?", gender);
		assertNotNull("Can't find a view... Has layout changed?", city);
		assertNotNull("Can't find a view... Has layout changed?", downloadBtn);
	}
	/**
	 * Validating the Server response
	 * By clicking Download button
	 * getting the JSON,checking whether response is null or not
	 * if not test will pass
	 */
	public void testValidateJson(){
		TouchUtils.clickView(this, downloadBtn);
		JSONObject data=activity.jsonObject;
		//assertNull("JSON Object is Null ", data);
		assertNotNull("getting Response",data);
	}
	/**
	 * By Clicking DownLoad Button,server will give response
	 * checking whether the server response and our Expected value are equal or not
	 * if equal test case will pass
	 */
	public void testValidateResponse(){
		TouchUtils.clickView(this, downloadBtn);
		String actual=activity.jsonObject.toString();
		String expected="{\"id\":\"591658927624314\",\"first_name\":\"Anitha\",\"username\":\"anitha.honey784\",\"name\":\"Anitha Honey\",\"locale\":\"en_US\",\"link\":\"https:\\/\\/www.facebook.com\\/anitha.honey784\",\"last_name\":\"Honey\",\"gender\":\"female\"}";
		assertEquals(expected, actual);
	}
	/**
	 * if required field is not there in response,
	 * and we are expecting that field ,test will pass and displays required field is not there in response as message
	 */
	public void testRequiredFieldCity(){
		TouchUtils.clickView(this, downloadBtn);
		String actual=city.getText().toString();
		//assertNull(actual);
		String expected="";
		assertEquals("Required field is not there",expected, actual);
		assertNotNull(actual);
	}
	/**
	 * if field is there in response it will show
	 * if response and expected are same it will pass
	 */
	public void testRequiredFielsName(){
		TouchUtils.clickView(this, downloadBtn);
		String actual=name.getText().toString();
		assertNotNull(actual);
		String expected="Name\t\tAnitha Honey";
		assertEquals(expected, actual);
	}
	/**
	 * if field is there in response it will show
	 *if  response and expected are same it will pass
	 */
	public void testRequiredFieldsGender(){
		TouchUtils.clickView(this, downloadBtn);
		String actual=gender.getText().toString();
		assertNotNull(actual);
		String expected="Gender\t\tfemale";
		assertEquals(expected, actual);
	}
}
