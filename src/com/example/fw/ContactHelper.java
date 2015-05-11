package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact1) {
		typeKeyInElement(By.name("firstname"), contact1.firstName);
		typeKeyInElement(By.name("lastname"), contact1.lastName);
		typeKeyInElement(By.name("address"), contact1.address);
		typeKeyInElement(By.name("home"), contact1.homeNumber);
		typeKeyInElement(By.name("mobile"), contact1.mobileNumber);
		typeKeyInElement(By.name("work"), contact1.workNumber);
		typeKeyInElement(By.name("email"), contact1.email1);
		typeKeyInElement(By.name("email2"), contact1.email2);
		selectDropdownValue(By.name("bday"), contact1.bDay);
		selectDropdownValue(By.name("bmonth"), contact1.bMonth);
		typeKeyInElement(By.name("byear"), contact1.bYear);
		selectDropdownValue(By.name("new_group"), contact1.groupName);
		typeKeyInElement(By.name("address2"), contact1.address2);
		typeKeyInElement(By.name("phone2"), contact1.homeNumber2);
	}

	public void deleteContact(int index) {
		
		click(By.xpath("(//input[@name ='update'])["+ index +"]"));
		
	}


	public void submitContactModification() {
		click(By.name("update"));
		
	}

	public void editContact(int index) {
		click(By.xpath("(//a/img [@title='Edit'])["+ index +"]"));
		
	}

}
