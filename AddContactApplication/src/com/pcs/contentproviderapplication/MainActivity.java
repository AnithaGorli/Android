package com.pcs.contentproviderapplication;



import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{
	private EditText nameEdt;

	private EditText emailEdt;
	private EditText officeEdt;
	private EditText phoneEdt;
	private Button addContact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addcontact);

		nameEdt=(EditText)findViewById(R.id.name_edt);
		emailEdt=(EditText)findViewById(R.id.email_edt);
		officeEdt=(EditText)findViewById(R.id.office_edt);
		phoneEdt=(EditText)findViewById(R.id.phone_edt);
		addContact=(Button)findViewById(R.id.add_contact_btn);




		addContact.setOnClickListener(new OnClickListener() {
			/**
			 * inserting data into database
			 */
			@Override
			public void onClick(View v) {


				if(TextUtils.isEmpty(nameEdt.getText().toString()) &
						TextUtils.isEmpty(emailEdt.getText().toString()) &
						TextUtils.isEmpty(officeEdt.getText().toString()) &
						TextUtils.isEmpty(phoneEdt.getText().toString()) ){

					Toast.makeText(getBaseContext(), 
							getResources().getString(R.string.error).toString(), Toast.LENGTH_LONG).show();

				}

				else{

					ContentValues values = new ContentValues();

					values.put(CustomerProvider.NAME, nameEdt.getText().toString());
					values.put(CustomerProvider.EMAIL, emailEdt.getText().toString());
					values.put(CustomerProvider.OFFICE, officeEdt.getText().toString());
					values.put(CustomerProvider.PHONE, phoneEdt.getText().toString());

					Uri uri = getContentResolver().insert(
							CustomerProvider.CONTENT_URI, values);

					Toast.makeText(getBaseContext(), 
							uri.toString(), Toast.LENGTH_LONG).show();
				}      



			}
		});
	}

}
