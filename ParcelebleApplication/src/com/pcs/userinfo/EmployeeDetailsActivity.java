package com.pcs.userinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.pcs.details.Employee;
import com.pcs.helper.Helper;

public class EmployeeDetailsActivity extends Activity{
	 private EditText empId;
	 private EditText empName;
	 private EditText empDesignation;
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.info);
	
	Button showEmployee = (Button)findViewById(R.id.show_btn);
	 empId =(EditText)findViewById(R.id.empid_edt);
	 empName =(EditText)findViewById(R.id.empname_edt);
	 empDesignation =(EditText)findViewById(R.id.empdesg_edt);
	
	
	showEmployee.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(EmployeeDetailsActivity.this,EmployeeDetailsDisplayActivity.class);
			Employee empObj = new Employee();
			
			Employee.setId(empId.getText().toString());
			Employee.setName(empName.getText().toString());
			Employee.setDesignation(empDesignation.getText().toString());
			
			
			
			intent.putExtra(Helper.AddExtras.EMPLOYEE_DETAILS, empObj);
			startActivity(intent);
			
		}
	});
	
	}
	

}
