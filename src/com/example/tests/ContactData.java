package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String firstName;
	public String lastName;
	public String name;
	public String address;
	public String homeNumber;
	public String mobileNumber;
	public String workNumber;
	public String email1;
	public String email2;
	public int bDay;
	public int bMonth;
	public String bYear;
	public String address2;
	public String homeNumber2;
	public int groupName;
	
	public ContactData() {
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.homeNumber = "";
		this.mobileNumber = "";
		this.workNumber = "";
		this.email1 = "";
		this.email2 = "";
		this.bDay = 0;
		this.bMonth = 0;
		this.bYear = "";
		this.address2 = "";
		this.homeNumber2 = "";
		this.groupName = 0;
		this.name = "";
	}

//	public ContactData(String firstName, String lastName, String address,
//			String homeNumber, String mobileNumber, String workNumber,
//			String email1, String email2, String bDay, String bMonth,
//			String bYear, String address2, String homeNumber2) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.name = lastName + firstName;
//		this.address = address;
//		this.homeNumber = homeNumber;
//		this.mobileNumber = mobileNumber;
//		this.workNumber = workNumber;
//		this.email1 = email1;
//		this.email2 = email2;
//		this.bDay = bDay;
//		this.bMonth = bMonth;
//		this.bYear = bYear;
//		this.address2 = address2;
//		this.homeNumber2 = homeNumber2;
//	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ContactData [name=" + name + "]";
	}

	@Override
	public int compareTo(ContactData other) {
		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
	}
	



}