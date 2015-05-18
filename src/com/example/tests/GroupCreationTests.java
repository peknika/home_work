package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testValidGroupCreationd(GroupData group) throws Exception {
		appManager.getNavigationHelper().openMainPage();
		appManager.getNavigationHelper().goToGroupsPage();
		
//		save old list of groups
		List<GroupData> oldList = appManager.getGroupHelper().getGroups();

//		actions
		appManager.getGroupHelper().initGroupCreation();
		appManager.getGroupHelper().fillGroupForm(group);
		appManager.getGroupHelper().submitGroupCreation();
		appManager.getGroupHelper().returnToGroupsPage();	
		
//save new list of groups
		List<GroupData> newList = appManager.getGroupHelper().getGroups();
		
//		compare group lists
//		assertEquals(newList.size(), oldList.size()+1);	
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
