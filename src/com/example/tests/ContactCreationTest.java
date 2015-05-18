package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testValidContactCreation(ContactData contact1) throws Exception {
		appManager.getNavigationHelper().openMainPage();

		//Save old list of contacts
		List<ContactData> oldList = appManager.getContactHelper().getContacts();

		
		//Actions
		appManager.getNavigationHelper().goToNewContactPage();	
		appManager.getContactHelper().fillContactForm(contact1);
		appManager.getContactHelper().submitContactCreation();
		appManager.getNavigationHelper().returnToHomePage();

		//Save new list of contacts
		List<ContactData> newList = appManager.getContactHelper().getContacts();

		//Compare old and new lists of contacts
		oldList.add(contact1);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
	}

}