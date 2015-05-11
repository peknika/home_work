package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void deleteSomeGroup	(){
		appManager.getNavigationHelper().openMainPage();
		appManager.getContactHelper().editContact(1);
		ContactData contact1 = new ContactData();
		contact1.firstName = "New First Name";
		contact1.lastName = "New Last Name";
		appManager.getContactHelper().fillContactForm(contact1);
		appManager.getContactHelper().submitContactModification();
		appManager.getNavigationHelper().returnToHomePage();

}
}