package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		appManager.getNavigationHelper().openMainPage();
		
		//Save old list of contacts
		List<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		Random rnd = new Random();
		int index = rnd. nextInt(oldList.size()-1);
				
		//Actions
		appManager.getContactHelper().editContact(index);
		appManager.getContactHelper().submitContactDeletion();
		appManager.getNavigationHelper().returnToHomePage();
		
		//Save new list of contacts
		List<ContactData> newList = appManager.getContactHelper().getContacts();
				
		//Compare old and new lists of contacts
		oldList.remove(index);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
}
}