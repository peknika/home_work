package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
  @Test
  public void testNonEmptyGroupCreationd() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "friends";
    group.header = "friends header";
    group.footer = "friends footer";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreationd() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }
}


