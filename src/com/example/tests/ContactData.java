package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstName;
	private String lastName;
	private String address;
	private String homeNumber;
	private String mobileNumber;
	private String workNumber;
	private String email1;
	private String email2;
	private int bDayIndex;
	private int bMonthIndex;
	private String bYear;
	private String address2;
	private String homeNumber2;
	private int groupNameIndex;
	
//	public ContactData() {
//		this.firstName = "";
//		this.lastName = "";
//		this.address = "";
//		this.homeNumber = "";
//		this.mobileNumber = "";
//		this.workNumber = "";
//		this.email1 = "";
//		this.email2 = "";
//		this.bDay = 0;
//		this.bMonth = 0;
//		this.bYear = "";
//		this.address2 = "";
//		this.homeNumber2 = "";
//		this.groupName = 0;
//		this.name = "";
//	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + "]";
	}

	@Override
	public int compareTo(ContactData other) {
		return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getWorkNumber() {
		return workNumber;
	}


	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public int getbDay() {
		return bDayIndex;
	}

	public int getbMonth() {
		return bMonthIndex;
	}


	public String getbYear() {
		return bYear;
	}


	public String getAddress2() {
		return address2;
	}

	public String getHomeNumber2() {
		return homeNumber2;
	}

	public int getGroupName() {
		return groupNameIndex;
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
		return this;
	}

	public ContactData withMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	public ContactData withWorkNumber(String workNumber) {
		this.workNumber = workNumber;
		return this;
	}

	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}

	public ContactData withBDay(int bDay) {
		this.bDayIndex = bDay;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 =email2;
		return this;
	}

	public ContactData withBMonth(int bMonth) {
		this.bMonthIndex = bMonth;
		return this;
	}

	public ContactData withBYear(String bYear) {
		this.bYear = bYear;
		return this;
	}

	public ContactData withGroupName(int groupName) {
		this.groupNameIndex = groupName;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withHomeNumber2(String homeNumber2) {
		this.homeNumber2 = homeNumber2;
		return this;
	}
	



}