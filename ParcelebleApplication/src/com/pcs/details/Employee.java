package com.pcs.details;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {
	
	private static String id;
	private static String name;
	private static String designation;
	
	public Employee(Parcel source) {
		
		setId(source.readString());
		setName(source.readString());
		setDesignation(source.readString());
		
	}
	public Employee() {
		
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		Employee.id = id;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Employee.name = name;
	}
	public static String getDesignation() {
		return designation;
	}
	public static void setDesignation(String designation) {
		Employee.designation = designation;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(getId());
		dest.writeString(getName());
		dest.writeString(getDesignation());
			
	}
	
public static final Creator<Employee> CREATOR = new Creator<Employee>(){

	@Override
	public Employee createFromParcel(Parcel source) {
		return new Employee(source);
	}

	@Override
	public Employee[] newArray(int size) {
		return new Employee[size];
	}
		
};

public String toString() {
	
	return "Employee Id :\t"+ getId()+"\nEmployee Name :\t"+ getName()+"\nEmployee Designation :\t"+getDesignation();
	
};

}
