package com.pcs.userinfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.pcs.details.Employee;
import com.pcs.helper.Helper;

public class EmployeeDetailsDisplayActivity extends Activity{
	
	private TextView displayEdt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		displayEdt = (TextView)findViewById(R.id.display_employee);
		 
		Employee emplyoyee = getIntent().getParcelableExtra(Helper.AddExtras.EMPLOYEE_DETAILS);
		if(emplyoyee!=null)
			
		{
			displayEdt.setText(emplyoyee.toString());
		}
		
	}

}
