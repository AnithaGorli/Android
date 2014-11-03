package com.pcs.databaseapplication;

import com.example.databaseapplication.R;
import com.pcs.helper.MySqliteHelper;
import com.pcs.model.Contact;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends Activity implements OnClickListener {
	private EditText usernameEdt;
	private EditText passwordEdt;
	private EditText emailEdt;
	private EditText phoneEdt;
	private Button saveContact, showContacts, editContact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		usernameEdt = (EditText) findViewById(R.id.username_edt);
		passwordEdt = (EditText) findViewById(R.id.password_edt);
		emailEdt = (EditText) findViewById(R.id.email_edt);
		phoneEdt = (EditText) findViewById(R.id.phone_edt);

		saveContact = (Button) findViewById(R.id.save_btn);
		showContacts = (Button) findViewById(R.id.show_btn);
		editContact = (Button) findViewById(R.id.edit_btn);

		saveContact.setOnClickListener(this);
		showContacts.setOnClickListener(this);
		editContact.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		//adding contact
		case R.id.save_btn:
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
				MySqliteHelper helper = new MySqliteHelper(
						AddContactActivity.this);
				Contact contact = new Contact(AddContactActivity.this);
				contact.setUsername(usernameValue);
				contact.setPassword(passwordValue);
				contact.setEmail(emailValue);
				contact.setPhone(phoneValue);

				long result = helper.saveContact(contact);

				if (result != -1) {
					Toast.makeText(AddContactActivity.this,
							getResources().getString(R.string.insert_success),
							Toast.LENGTH_LONG).show();
				}
				usernameEdt.setText(" ");
				passwordEdt.setText(" ");
				emailEdt.setText(" ");
				phoneEdt.setText(" ");
			}

			break;
          //show contacts
		case R.id.show_btn:
			Intent intent = new Intent(AddContactActivity.this,
					ShowContactsActivity.class);
			startActivity(intent);

			break;
			//for editing contact
		case R.id.edit_btn:

			Intent intent_one = new Intent(AddContactActivity.this,
					ValidateEditActivity.class);
			startActivity(intent_one);
			break;

		default:
			break;
		}
	}

}
