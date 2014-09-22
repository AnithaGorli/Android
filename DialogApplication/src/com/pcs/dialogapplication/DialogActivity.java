package com.pcs.dialogapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dialogapplication.R;


public class DialogActivity extends Activity {
	private Button createBtn;
	private Button deleteBtn;
	private Button changeColorBtn;
	private LayoutInflater layoutInflater;
	private AlertDialog.Builder builder;
	private AlertDialog alert;
	private EditText nameEdt;
	private EditText phoneEdt;
	private EditText addressEdt;
	private LinearLayout layout;
	
	 
	 
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		createBtn = (Button) findViewById(R.id.create_btn);
		deleteBtn = (Button) findViewById(R.id.delete_btn);
		changeColorBtn = (Button) findViewById(R.id.color_btn);



		createBtn.setOnClickListener(new  android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {
				layoutInflater=LayoutInflater.from(DialogActivity.this);
				View mainView = layoutInflater.inflate(R.layout.create, null);
				builder = new AlertDialog.Builder(DialogActivity.this);

				builder.setView(mainView);
				alert = builder.create();
				alert.show();

				nameEdt=(EditText)mainView.findViewById(R.id.name_edt);
				phoneEdt=(EditText)mainView.findViewById(R.id.phone_edt);
				addressEdt=(EditText)mainView.findViewById(R.id.address_edt);
				Button addBtn=(Button)mainView.findViewById(R.id.add_btn);
				Button cancelBtn=(Button)mainView.findViewById(R.id.cancle_btn);


				addBtn.setOnClickListener(new android.view.View.OnClickListener() {

					@Override
					public void onClick(View v) {

						Intent intent=new Intent();
						intent.putExtra(Constants.AddingExtras.NAME, nameEdt.getText().toString());
						intent.putExtra(Constants.AddingExtras.PHONE, phoneEdt.getText().toString());
						intent.putExtra(Constants.AddingExtras.ADDRESS, addressEdt.getText().toString());
						intent.putExtra( Constants.AddingExtras.IMAGE, R.drawable.ic_launcher);

						if(nameEdt.getText().toString().equals("") & phoneEdt.getText().toString().equals("") & addressEdt.getText().toString().equals("") ){
							setResult(Activity.RESULT_CANCELED);
						}else{
							setResult(Activity.RESULT_OK,intent);
						}
						finish();
						alert.dismiss();
					}


				});



			}



		});







		deleteBtn.setOnClickListener(new android.view.View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent= new Intent();
				finish();

			}
		});




		changeColorBtn.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(DialogActivity.this,
						getResources().getString(R.string.app_name),
						Toast.LENGTH_LONG).show();
				builder = new AlertDialog.Builder(DialogActivity.this);
				builder.setTitle(R.string.color_title);
				final String[] colorlist=getResources().getStringArray(R.array.colors);
				builder.setSingleChoiceItems(R.array.colors, 0, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

						alert.dismiss();
						layout=(LinearLayout)findViewById(R.id.main_layout);
						switch(which){
						case 0:
							layout.setBackgroundColor(getResources().getColor(R.color.pink));
							break;
						case 1:
							layout.setBackgroundColor(getResources().getColor(R.color.blue));
							break;
						case 2:
							layout.setBackgroundColor(getResources().getColor(R.color.yellow));
							break;
						}
					}
				});



				alert=builder.create();
				alert.show();
			}

		});

	}
}
