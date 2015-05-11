package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

@Test
public void deleteSomeGroup	(){
	appManager.getNavigationHelper().openMainPage();
	appManager.getNavigationHelper().goToGroupsPage();
	appManager.getGroupHelper().deleteGroup(1);
	appManager.getGroupHelper().returnToGroupsPage();

}
}
