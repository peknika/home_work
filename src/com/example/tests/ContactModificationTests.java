package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact1){	
		//Save old list of contacts
		SortedListOf<ContactData> oldList = appManager.getContactHelper().getContacts();
				
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
		//Actions
		appManager.getContactHelper().modifyContact(index, contact1);

		//Save new list of contacts
		SortedListOf<ContactData> newList = appManager.getContactHelper().getContacts();
				
		//Compare old and new lists of contacts
			assertThat(newList, equalTo(oldList.without(index).withAdded(contact1)));
}
}