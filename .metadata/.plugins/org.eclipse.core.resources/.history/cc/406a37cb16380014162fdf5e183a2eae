package com.pcs.customer;

import android.os.Parcel;
import android.os.Parcelable;

public class CustomerDAO implements Parcelable{
	private String username;
	private String password;
	private String email;
	private String phone;
	private String address;




	public CustomerDAO(Parcel source) {

		setUsername(source.readString());
		setPassword(source.readString());
		setEmail(source.readString());
		setPhone(source.readString());
		setAddress(source.readString());

	}

	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(getUsername());
		dest.writeString(getPassword());
		dest.writeString(getEmail());
		dest.writeString(getPhone());
		dest.writeString(getAddress());
	}
	public static final Creator<CustomerDAO> CREATOR = new Creator<CustomerDAO>() {

		@Override
		public CustomerDAO createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new CustomerDAO(source);
		}

		@Override
		public CustomerDAO[] newArray(int size) {
			// TODO Auto-generated method stub
			return new CustomerDAO[size];
		}


	};


	public String toString() {
		return "\n\n\tUsername:"+getUsername()+"\n\tPassword:"+getPassword()+"\n\tEmail:"+getEmail()+"\n\tPhone:"+getPhone()+"\ntAddress:"+getAddress();
	};
}




