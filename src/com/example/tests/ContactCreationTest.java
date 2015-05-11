package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

	@Test
	public void testEmtyContactCreation() throws Exception {
		appManager.getNavigationHelper().openMainPage();
		appManager.getNavigationHelper().goToContactPage();
		ContactData contact1 = new ContactData();
		appManager.getContactHelper().fillContactForm(contact1);
		appManager.getContactHelper().submitContactCreation();
		appManager.getNavigationHelper().returnToHomePage();
	}

	@Test
	public void testNonEmptyContactCreation2() throws Exception {
		appManager.getNavigationHelper().openMainPage();
		appManager.getNavigationHelper().goToContactPage();
		ContactData contact1 = new ContactData();
		contact1.firstName = "Ivan";
		contact1.lastName = "Ivanov";
		contact1.address = "Ivanovkaya street 56, 12";
		contact1.homeNumber = "11111111";
		contact1.mobileNumber = "22222222";
		contact1.workNumber = "33333333";
		contact1.email1 = "ivanov@gmail.com";
		contact1.email2 = "ivanov@yandex.ru";
		contact1.bDay = "18";
		contact1.bMonth = "October";
		contact1.bYear = "1965";
		contact1.groupName = "friends";
		contact1.address2 = "additional address";
		contact1.homeNumber2 = "44444444";
		appManager.getContactHelper().fillContactForm(contact1);
		appManager.getContactHelper().submitContactCreation();
		appManager.getNavigationHelper().returnToHomePage();
	}

}