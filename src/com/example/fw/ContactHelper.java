package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	

	public void editContact(int index) {
		click(By.xpath("(//a/img [@title='Edit'])["+ (index + 1) +"]"));
		
	}
	
	public void submitContactDeletion() {
		
		click(By.xpath("(//input[@name ='update'] [@value = 'Delete'])"));
		
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}


	public void fillContactForm(ContactData contact1) {
		typeKeyInElement(By.name("firstname"), contact1.firstName);
		typeKeyInElement(By.name("lastname"), contact1.lastName);
		typeKeyInElement(By.name("address"), contact1.address);
		typeKeyInElement(By.name("home"), contact1.homeNumber);
		typeKeyInElement(By.name("mobile"), contact1.mobileNumber);
		typeKeyInElement(By.name("work"), contact1.workNumber);
		typeKeyInElement(By.name("email"), contact1.email1);
		typeKeyInElement(By.name("email2"), contact1.email2);
		selectDropdownValue(By.name("bday"), contact1.bDay);
		selectDropdownValue(By.name("bmonth"), contact1.bMonth);
		typeKeyInElement(By.name("byear"), contact1.bYear);
		selectGroupDropdownValue(By.name("new_group"), contact1.groupName);
		typeKeyInElement(By.name("address2"), contact1.address2);
		typeKeyInElement(By.name("phone2"), contact1.homeNumber2);
	}


	public void submitContactModification() {
		click(By.name("update"));
		
	}



	
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
		ContactData contact = new ContactData();
		String title = checkbox.getAttribute("title");
		contact.name = title.substring("Select( ".length(), title.length() - ")".length());
		contacts.add(contact);
		}
		return contacts;
	}

	public int getGroupsNumber() {
		manager.getNavigationHelper().goToGroupsPage();
		return manager.driver.findElements(By.name("selected[]")).size();

	}

}
