package com.pcs.model;

import android.content.Context;

public class Contact {
	private String username;
	private String Password;
	private String email;
	private String phone;
	private Context context;
	public Contact(Context baseContext) {
		// TODO Auto-generated constructor stub
		context=baseContext;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
