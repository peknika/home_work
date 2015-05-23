package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testValidGroupCreationd(GroupData group) throws Exception {
		
//		save old list of groups
		SortedListOf<GroupData> oldList = appManager.getGroupHelper().getGroups();

//		actions
		appManager.getGroupHelper().createGroup(group);
		
//save new list of groups
		SortedListOf<GroupData> newList = appManager.getGroupHelper().getGroups();
		
		assertThat(newList, equalTo(oldList.withAdded(group)));


	}
}
