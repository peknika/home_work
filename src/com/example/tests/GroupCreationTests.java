package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	@Test
	public void testNonEmptyGroupCreationd() throws Exception {
		appManager.getNavigationHelper().openMainPage();
		appManager.getNavigationHelper().goToGroupsPage();
		appManager.getGroupHelper().initGroupCreation();
		GroupData group = new GroupData();
		group.name = "friends";
		group.header = "friends header";
		group.footer = "friends footer";
		appManager.getGroupHelper().fillGroupForm(group);
		appManager.getGroupHelper().submitGroupCreation();
		appManager.getGroupHelper().returnToGroupsPage();	
	}

	@Test
	public void testEmptyGroupCreationd() throws Exception {
		appManager.getNavigationHelper().openMainPage();
		appManager.getNavigationHelper().goToGroupsPage();
		appManager.getGroupHelper().initGroupCreation();
		appManager.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
		appManager.getGroupHelper().submitGroupCreation();
		appManager.getNavigationHelper().returnToHomePage();
	}
}
