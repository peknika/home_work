package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.txt"))).iterator();

	}


	@Test(dataProvider = "contactsFromFile")
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