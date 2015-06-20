package com.example.tests;

import static com.example.tests.GroupDataGeneratior.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGeneratior.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException{
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.txt"))).iterator();

	}


	@Test(dataProvider = "groupsFromFile")
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
