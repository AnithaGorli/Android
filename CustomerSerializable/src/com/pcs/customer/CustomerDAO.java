package com.pcs.customer;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class CustomerDAO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String address;




	

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	


	public String toString() {
		return "\n\n\tUsername:"+getUsername()+"\n\tPassword:"+getPassword()+"\n\tEmail:"+getEmail()+"\n\tPhone:"+getPhone()+"\n\tAddress:"+getAddress();
	};
}




