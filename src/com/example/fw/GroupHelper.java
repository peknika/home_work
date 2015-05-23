package com.example.fw;

import java.util.List;

import javafx.collections.transformation.SortedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase{
	
	SortedListOf<GroupData> cachedGroups;

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	
	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null){
			rebuildCache();	
		}
			return cachedGroups;
	}	
		
	private void rebuildCache() {
		
		cachedGroups = new SortedListOf<GroupData>();
		manager.getNavigationHelper().goToGroupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select( ".length(), title.length() - ")".length());
			cachedGroups.add(new GroupData().withName(name));
		}

	}


	public GroupHelper createGroup(GroupData group) {
		manager.getNavigationHelper().goToGroupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();	
		rebuildCache();
		
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		rebuildCache();

		return this;
	}

	public GroupHelper modifyGroup(int index, GroupData group) {
		initGruopModification(index);
		fillGroupForm(group);;
		submitGruopModification();
		returnToGroupsPage();
		rebuildCache();
		
		return this;
	}
	
//	___________________________________________________________________________________________
	
	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {

		typeKeyInElement(By.name("group_name"), group.getName());
		typeKeyInElement(By.name("group_header"), group.getHeader());
		typeKeyInElement(By.name("group_footer"), group.getFooter());

		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;

		return this;
	}

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));

		return this;
	}


	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+ (index+1) +"]"));
	}

	public GroupHelper initGruopModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));

		return this;

	}

	public GroupHelper submitGruopModification() {
		click(By.name("update"));
		cachedGroups = null;

		return this;

	}


	private void submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
	}
	

}
