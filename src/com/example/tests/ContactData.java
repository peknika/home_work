package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String homeNumber;
	public String mobileNumber;
	public String workNumber;
	public String email1;
	public String email2;
	public String bDay;
	public String bMonth;
	public String bYear;
	public String address2;
	public String homeNumber2;
	public String groupName;
	
	public ContactData() {
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.homeNumber = "";
		this.mobileNumber = "";
		this.workNumber = "";
		this.email1 = "";
		this.email2 = "";
		this.bDay = "";
		this.bMonth = "";
		this.bYear = "";
		this.address2 = "";
		this.homeNumber2 = "";
		this.groupName = "";
	}

	public ContactData(String firstName, String lastName, String address,
			String homeNumber, String mobileNumber, String workNumber,
			String email1, String email2, String bDay, String bMonth,
			String bYear, String address2, String homeNumber2) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homeNumber = homeNumber;
		this.mobileNumber = mobileNumber;
		this.workNumber = workNumber;
		this.email1 = email1;
		this.email2 = email2;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.address2 = address2;
		this.homeNumber2 = homeNumber2;
	}

}