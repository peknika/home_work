package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		appManager.getNavigationHelper().openMainPage();
		appManager.getContactHelper().editContact(1);
		appManager.getContactHelper().deleteContact(2);
		appManager.getNavigationHelper().returnToHomePage();

}
}