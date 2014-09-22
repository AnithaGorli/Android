package com.pcs.menuapplication;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.menuapplication.R;

/**
 * Second Activity
 * In this we can give information of user
 * we can change themes of screen and background color of screen
 * we can reset the data
 * we can can call,and send mail,add contact of particular person
 * @author pcs-05
 *
 */
public class MenuActivity extends Activity{

	private EditText nameEdt;
	private EditText mailEdt;
	private EditText phoneEdt;
	private Button okEdt;
	private LinearLayout layout;


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);


		nameEdt=(EditText)findViewById(R.id.name_edt);
		mailEdt=(EditText)findViewById(R.id.mail_edt);
		phoneEdt=(EditText)findViewById(R.id.phone_edt);
		okEdt=(Button)findViewById(R.id.ok_btn);
		layout=(LinearLayout)findViewById(R.id.layout_main);
		//we have to register view for context menu
		registerForContextMenu(okEdt);



	}
	/**
	 * creating Option menu
	 * no need to register any view
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {


		MenuInflater inflaterOption=getMenuInflater();
		inflaterOption.inflate(R.menu.menu1,menu );
		return super.onCreateOptionsMenu(menu);

	}
	//on selecting option menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {




		switch (item.getItemId()) {
		/**
		 * changing background color of screen
		 */
		case R.id.pink:

			layout.setBackgroundColor(getResources().getColor(R.color.pink));

			break;

		case R.id.blue:

			layout.setBackgroundColor(getResources().getColor(R.color.blue));

			break;
		case R.id.yellow:

			layout.setBackgroundColor(getResources().getColor(R.color.yellow));

			break;
			/**
			 * Resetting the data which  is entered
			 */
		case R.id.reset:

			nameEdt.setText(null);
			phoneEdt.setText(null);
			mailEdt.setText(null);
			break;
			/**
			 * for changing background themes of screen
			 */
		case R.id.theme1:

			layout.setBackgroundResource(R.drawable.back_theme1);
			break;
		case R.id.theme2:

			layout.setBackgroundResource(R.drawable.back_theme2);
			break;
		case R.id.theme3:

			layout.setBackgroundResource(R.drawable.bak_theme3);
			break;

		}

		return super.onOptionsItemSelected(item);
	}


	/**
	 * Creating context menu
	 * Context menu which has call,mail,add to contacts as items
	 * when we click on ok Button menu will appear
	 */


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);

		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.menu,menu );
	}
	//on selecting  Context menu
	@Override
	public boolean onContextItemSelected(MenuItem item) {



		switch (item.getItemId()) {
		//when we click on call item
		case R.id.item1:

			Intent intent=new Intent(Intent.ACTION_CALL);
			String calling=phoneEdt.getText().toString();
			intent.setData(Uri.parse("tel:"+calling));
			startActivity(intent);
			break;
			/**
			 * when we click on add Contact item
			 * data which is entered by us is send to the list activity
			 * if data is null result is Result_canceled
			 * else
			 * Result_ok
			 *  
			 */
		case R.id.item2:

			Intent intent1=new Intent();
			intent1.putExtra(Constants.AddingExtras.NAME, nameEdt.getText().toString());
			intent1.putExtra(Constants.AddingExtras.PHONE, phoneEdt.getText().toString());
			intent1.putExtra(Constants.AddingExtras.MAIL, mailEdt.getText().toString());
			Boolean nameBool = TextUtils.isEmpty(nameEdt.getText().toString());
			Boolean mailBool = TextUtils.isEmpty(mailEdt.getText().toString());
			Boolean phoneBool = TextUtils.isEmpty(phoneEdt.getText().toString());
			
			
			if( nameBool==true  & mailBool==true& phoneBool==true ){
				setResult(Activity.RESULT_CANCELED);
			}else{
				setResult(Activity.RESULT_OK,intent1);
			}
			finish();			

			break;
			//sending an email
		case R.id.item3:
			Intent intent2=new Intent(Intent.ACTION_SEND);
			intent2.putExtra(Intent.EXTRA_TEXT,"Hello friends");
			intent2.putExtra(Intent.EXTRA_SUBJECT,"Wishes");
			intent2.putExtra(Intent.EXTRA_EMAIL,mailEdt.getText().toString());
			startActivity(Intent.createChooser(intent2, getResources().getString(R.string.mail)));
			break;

		default:
			break;
		}

		return super.onContextItemSelected(item);
	}

}
