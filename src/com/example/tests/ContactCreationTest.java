package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testValidContactCreation(ContactData contact1) throws Exception {
		//Save old list of contacts
		SortedListOf<ContactData> oldList = appManager.getContactHelper().getContacts();

		
		//Actions
		appManager.getContactHelper().createContact(contact1);


		//Save new list of contacts
		SortedListOf<ContactData> newList = appManager.getContactHelper().getContacts();

		//Compare old and new lists of contacts
		oldList.add(contact1);
		assertThat(newList, equalTo(oldList));
	}

}