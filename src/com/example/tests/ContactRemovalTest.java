package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTest extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		//Save old list of contacts
		SortedListOf<ContactData> oldList = appManager.getContactHelper().getContacts();
		if (oldList.size() > 0)
		{
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
				
		//Actions
		appManager.getContactHelper().deleteContact(index);

		
		//Save new list of contacts
		SortedListOf<ContactData> newList = appManager.getContactHelper().getContacts();
				
		//Compare old and new lists of contacts
		assertThat(newList, equalTo(oldList.without(index)));
		}
}
}