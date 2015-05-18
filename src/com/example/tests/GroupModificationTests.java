package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	
public void modifySomeGroup(GroupData group){
		appManager.getNavigationHelper().openMainPage();
		appManager.getNavigationHelper().goToGroupsPage();
		
//		save old list of groups
		List<GroupData> oldList = appManager.getGroupHelper().getGroups();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
//		actions
		appManager.getGroupHelper().initGruopModification(index);
		appManager.getGroupHelper().fillGroupForm(group);
		appManager.getGroupHelper().submitGruopModification();
		appManager.getGroupHelper().returnToGroupsPage();
		
//save new list of groups
		List<GroupData> newList = appManager.getGroupHelper().getGroups();
				
//compare group lists
		oldList.remove(index);
		oldList.add(group);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);

	}

}
