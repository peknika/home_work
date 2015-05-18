package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

@Test
public void deleteSomeGroup	(){
	appManager.getNavigationHelper().openMainPage();
	appManager.getNavigationHelper().goToGroupsPage();
	
//	save old list of groups
	List<GroupData> oldList = appManager.getGroupHelper().getGroups();
	
Random rnd = new Random();
int index = rnd.nextInt(oldList.size()-1);
	
//	actions
	appManager.getGroupHelper().deleteGroup(index);
	appManager.getGroupHelper().returnToGroupsPage();
	
//save new list of groups
		List<GroupData> newList = appManager.getGroupHelper().getGroups();
			
//compare group lists
			oldList.remove(index);
			Collections.sort(oldList);
			Collections.sort(newList);
			assertEquals(newList, oldList);
}
}
