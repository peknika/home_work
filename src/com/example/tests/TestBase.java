package com.example.tests;

import static com.example.tests.GroupDataGeneratior.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected static ApplicationManager appManager;

	@BeforeTest
	public void setUp() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		appManager = new ApplicationManager(properties);
	}

	@AfterTest
	public void tearDown() throws Exception {
		appManager.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();

	}


	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		return wrapContactsForDataProvider(generateRandomContacts(5)).iterator();
	}
	
	public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}

	public int generateRandomGoupIndexForContact() {
		return 0;
	}

	public String generateRandomStringForContact(){
		Random rnd = new Random();
		if (rnd.nextInt(10) == 0) {
			return "";
		}
		else {
			return "yupi!" + rnd.nextInt();
		}	
	}
	
}
