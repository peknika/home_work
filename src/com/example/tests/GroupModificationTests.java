package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	
	@Test
	public void deleteSomeGroup	(){
		appManager.getNavigationHelper().openMainPage();
		appManager.getNavigationHelper().goToGroupsPage();
		appManager.getGroupHelper().initGruopModification(1);
		GroupData group = new GroupData();
		group.name = "new name";
		appManager.getGroupHelper().fillGroupForm(group);
		appManager.getGroupHelper().submitGruopModification();
		appManager.getGroupHelper().returnToGroupsPage();

	}

}
