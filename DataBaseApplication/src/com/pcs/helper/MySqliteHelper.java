package com.pcs.helper;

import com.pcs.model.Contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteHelper extends SQLiteOpenHelper {

	private SQLiteDatabase sqlitedb;

	public static final String DATABASE_NAME = "mydatabase.db";
	public static final String TABLE_NAME = "contacts";
	public static final int VERSION =1;
	public static final String CONTACT_USERNAME = "username";
	public static final String CONTACT_PASSWORD = "password";
	public static final String CONTACT_ID = "_id";
	public static final String CONTACT_EMAIL = "email";
	public static final String CONTACT_PHONE = "phone";
	//droping table
	public static final String DROP_TABLE = "drop table if exists " + TABLE_NAME;

	//creating table
	public static final String CREATE_TABLE = "create table " + TABLE_NAME
			+ "(" + CONTACT_ID + " integer," + CONTACT_USERNAME
			+ "  text not null," + CONTACT_PASSWORD + "  text not null,"
			+ CONTACT_EMAIL + "  text not null," + CONTACT_PHONE
			+ " text not null)";

	public MySqliteHelper(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(DROP_TABLE);
		onCreate(db);

	}
	//inserting row
	public long saveContact(Contact contact) {
		sqlitedb = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(MySqliteHelper.CONTACT_USERNAME, contact.getUsername());
		values.put(MySqliteHelper.CONTACT_PASSWORD, contact.getPassword());
		values.put(MySqliteHelper.CONTACT_EMAIL, contact.getEmail());
		values.put(MySqliteHelper.CONTACT_PHONE, contact.getPhone());
		long result = sqlitedb.insert(MySqliteHelper.TABLE_NAME, null, values);
		sqlitedb.close();
		return result;

	}

	public Cursor getData(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor res = db.rawQuery("select * from contacts where id=" + id + "",
				null);
		return res;
	}
	//updating table
	public boolean updateContact(String username, String password,
			String email, String phone) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(MySqliteHelper.CONTACT_USERNAME, username);
		contentValues.put(MySqliteHelper.CONTACT_PASSWORD, password);
		contentValues.put(MySqliteHelper.CONTACT_EMAIL, email);
		contentValues.put(MySqliteHelper.CONTACT_PHONE, phone);
		db.update("contacts", contentValues, "email = ? ",
				new String[] { email });
		return true;
	}





}
