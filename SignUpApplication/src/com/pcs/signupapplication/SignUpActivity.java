package com.pcs.signupapplication;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.signupapplication.R;

public class SignUpActivity extends Activity{

	private EditText nameEdt;
	private EditText emailEdt;
	private EditText phoneEdt;
	private EditText dobEdt;
	private EditText tobEdt;
	private TextView done;
	private Button registerBtn;
	private LinearLayout layout1;
	private LinearLayout layout2;
	private ProgressBar progress;
	private String name;
	private String email;
	private String phone;
	private String dob;
	private String tob;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		layout1=(LinearLayout)findViewById(R.id.layout_1);
		layout2=(LinearLayout)findViewById(R.id.layout_2);
		done=(TextView)findViewById(R.id.done_txt);
		nameEdt=(EditText)findViewById(R.id.name_edt);
		emailEdt=(EditText)findViewById(R.id.mail_edt);
		phoneEdt=(EditText)findViewById(R.id.phone_edt);
		dobEdt =(EditText)findViewById(R.id.dob_edt);
		tobEdt=(EditText)findViewById(R.id.tob_edt);
		registerBtn=(Button)findViewById(R.id.register_btn);
		layout2.setVisibility(View.VISIBLE);
		name=nameEdt.getText().toString();
		email=emailEdt.getText().toString();
		phone=phoneEdt.getText().toString();
		dob=dobEdt.getText().toString();
		tob=tobEdt.getText().toString();		
		
		progress=new ProgressBar(SignUpActivity.this);
		progress=(ProgressBar)findViewById(R.id.progress_bar);
		progress.setProgress(0);
		progress.setHorizontalScrollBarEnabled(true);

		
		/*if i entered any text for name, refresh() will be called to updating the progress 
		 * refresh() will return a boolean value as a result
		 * if i din't enter any text for name it will return 0
		 * else 1
		 */
		nameEdt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				refresh();
			}

		});
		/*if i entered any text for email, refresh() will be called to updating the progress 
		 * refresh() will return a boolean value as a result
		 * if i din't enter any text for email it will return 0
		 * else 1
		 */
		emailEdt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				refresh();
			}
		});
		
		/*if i entered any number for phone, refresh() will be called to updating the progress 
		 * refresh() will return a boolean value as a result
		 * if i din't enter any number for phone it will return 0
		 * else 1
		 */
		phoneEdt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				refresh();
			}
		});
		/*if i set any date for Date of Birth, refresh() will be called to updating the progress 
		 * refresh() will return a boolean value as a result
		 * if i din't set any Date of Birth for dob it will return 0
		 * else 1
		 * And Date will be selected by default calendar 
		 * i used default DatePicker
		 */
		dobEdt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH);
				int day = calendar.get(Calendar.DAY_OF_MONTH);
				Dialog date_dialog = new DatePickerDialog(SignUpActivity.this, new OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						dobEdt.setText(year+"/"+monthOfYear+"/"+dayOfMonth);
					}
				} , year, month, day);
				date_dialog.show();
				refresh();
			}
		});
		/*if i set any time for Time of Birth, refresh() will be called to updating the progress 
		 * refresh() will return a boolean value as a result
		 * if i din't set any Time of Birth for tob it will return 0
		 * else 1
		 * And Time  will be selected by default calendar 
		 * i used default TimePicker
		 */

		tobEdt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Calendar calendar = Calendar.getInstance();
				int hour=calendar.get(Calendar.HOUR);
				int minute=calendar.get(Calendar.MINUTE);

				Dialog time_dialog=new TimePickerDialog(SignUpActivity.this, new OnTimeSetListener() {

					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						// TODO Auto-generated method stub
						tobEdt.setText(hourOfDay+":"+minute);

					}
				}, hour, minute, false);
				time_dialog.show();
				refresh();
			}
		});
/**
 * if i click this button data which is entered by me is displayed on the same screen
 */
		registerBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				layout2.setVisibility(View.INVISIBLE);
				layout1.setVisibility(View.VISIBLE);

                 
				done.setText(name+"\n"+email+"\n"+phone+"\n"+dob+"\n"+tob);

			}
		});
	}
	
	/**
	 * it will set the progress depending on the data
	 */

	public void refresh(){

		/**
		 * checking whether data is empty or not 
		 */
		
		Boolean nameBool = TextUtils.isEmpty(name);
		Boolean mailBool = TextUtils.isEmpty(email);
		Boolean phoneBool = TextUtils.isEmpty(phone);
		Boolean dateBool = TextUtils.isEmpty(dob);
		Boolean timeBool = TextUtils.isEmpty(tob);
		int namevalue=1,mailvalue=1,phonevalue=1,dobvalue=1,tobvalue=1;
		if(nameBool)
			namevalue=0;
		if(mailBool)
			mailvalue=0;
		if(phoneBool)
			phonevalue=0;
		if(dateBool)
			dobvalue=0;
		if(timeBool)
			tobvalue=0;
		int result = namevalue+mailvalue+phonevalue+dobvalue+tobvalue;
		progress.setProgress(result*20);

	}

}

