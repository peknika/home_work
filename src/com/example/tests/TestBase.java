package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected static ApplicationManager appManager;

	@BeforeTest
	public void setUp() throws Exception {
		appManager = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		appManager.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++){
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[]{group});
		}
		return list.iterator();

	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
			return "";
		} else{
			return "test" + rnd.nextInt();
		}
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i <3; i++) {
			ContactData contact = new ContactData();
			contact.firstName = generateRandomStringForContact();
			contact.lastName = generateRandomStringForContact();
			contact.name = contact.firstName  + " " + contact.lastName;
			contact.address = generateRandomStringForContact();
			contact.homeNumber = generateRandomStringForContact();
			contact.mobileNumber = generateRandomStringForContact();
			contact.workNumber = generateRandomStringForContact();
			contact.email1 = generateRandomStringForContact();
			contact.email2 = generateRandomStringForContact();
			contact.bDay = generateRandomDayIndexForContact();
			contact.bMonth = generateRandomMonthIndexForContact();
			contact.bYear = generateRandomYearStringForContact();
			contact.groupName = generateRandomGoupIndexForContact();
			contact.address2 = generateRandomStringForContact();
			contact.homeNumber2 = generateRandomStringForContact();
			list.add(new Object[] {contact});
		}
		return list.iterator();
	}
	
	public int generateRandomGoupIndexForContact() {
		return 0;
	}

	private String generateRandomYearStringForContact() {
		Random rnd = new Random();
		return String.valueOf(rnd.nextInt(200) +1900);
	}


	private int generateRandomMonthIndexForContact() {
		Random rnd = new Random();

		return rnd.nextInt(11+1);
	}

	private int generateRandomDayIndexForContact() {
		Random rnd = new Random();

		return rnd.nextInt(30);
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
