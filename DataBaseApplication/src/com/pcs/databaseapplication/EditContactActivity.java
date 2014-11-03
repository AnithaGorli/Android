package com.pcs.databaseapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databaseapplication.R;
import com.pcs.helper.Constant;
import com.pcs.helper.MySqliteHelper;

public class EditContactActivity extends Activity implements OnClickListener {
	private EditText usernameEdt;
	private EditText passwordEdt;
	private EditText emailEdt;
	private EditText phoneEdt;
	private Button saveContact;
	private SQLiteDatabase sqlitedb;
	private MySqliteHelper helper;
	int id_To_Update = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit);

		String email = getIntent().getStringExtra(Constant.AddExtras.EMAIL);

		usernameEdt = (EditText) findViewById(R.id.username_edt);
		passwordEdt = (EditText) findViewById(R.id.password_edt);
		emailEdt = (EditText) findViewById(R.id.email_edt);

		phoneEdt = (EditText) findViewById(R.id.phone_edt);

		saveContact = (Button) findViewById(R.id.save_btn);

		saveContact.setOnClickListener(this);

		MySqliteHelper helper = new MySqliteHelper(EditContactActivity.this);
		SQLiteDatabase sqlitedb = helper.getReadableDatabase();
		Cursor cursor = sqlitedb.rawQuery("select * from  "
				+ MySqliteHelper.TABLE_NAME+" where "+Constant.AddExtras.EMAIL+" = '"+email+" "+"';",
				null);
		//try{
			  Bundle extras = getIntent().getExtras(); 
		      if(extras !=null)
		      {
		         int Value = extras.getInt("id");
		         if(Value>0){
			 Cursor mCursor = helper.getData(Value);
	            id_To_Update = Value;
	            mCursor.moveToFirst();
	            usernameEdt.setText(mCursor.getString((mCursor
	    				.getColumnIndex(MySqliteHelper.CONTACT_USERNAME))));
	    		passwordEdt.setText(mCursor.getString((mCursor
	    				.getColumnIndex(MySqliteHelper.CONTACT_PASSWORD))));
	    		emailEdt.setText(mCursor.getString((mCursor
	    				.getColumnIndex(MySqliteHelper.CONTACT_EMAIL))));
	    		phoneEdt.setText(mCursor.getString((mCursor
	    				.getColumnIndex(MySqliteHelper.CONTACT_PHONE))));
	            if (!mCursor.isClosed()) 
	            {
	               mCursor.close();
	            }
		         
		         }
		      }


		//mCursor.moveToFirst();
	/*		
		usernameEdt.setText(mCursor.getString((mCursor
				.getColumnIndex(MySqliteHelper.CONTACT_USERNAME))));
		passwordEdt.setText(mCursor.getString((mCursor
				.getColumnIndex(MySqliteHelper.CONTACT_PASSWORD))));
		emailEdt.setText(mCursor.getString((mCursor
				.getColumnIndex(MySqliteHelper.CONTACT_EMAIL))));
		phoneEdt.setText(mCursor.getString((mCursor
				.getColumnIndex(MySqliteHelper.CONTACT_PHONE))));
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		         
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		String usernameValue = usernameEdt.getText().toString();
		String passwordValue = passwordEdt.getText().toString();
		String emailValue = emailEdt.getText().toString();

		String phoneValue = phoneEdt.getText().toString();

		if (TextUtils.isEmpty(usernameValue)
				|| TextUtils.isEmpty(passwordValue)
				|| TextUtils.isEmpty(emailValue)
				|| TextUtils.isEmpty(phoneValue)) {
			Toast.makeText(getBaseContext(),
					this.getResources().getString(R.string.error),
					Toast.LENGTH_LONG).show();
		} else {

			helper.updateContact(usernameValue, passwordValue, emailValue,
					passwordValue);
		}

	}

}
