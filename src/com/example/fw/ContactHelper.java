package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactData> cachedContacts;

	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCache();	
		}
		return cachedContacts;
	}	


	private void rebuildCache() 	{

		cachedContacts = new SortedListOf<ContactData>();
		manager.getNavigationHelper().openMainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			ContactData contact = new ContactData()
			.withFirstName(row.findElement(By.xpath(".//td[3]")).getText())
			.withLastName(row.findElement(By.xpath(".//td[2]")).getText());
			cachedContacts.add(contact);
		}
	}


	public ContactHelper createContact(ContactData contact1) {
		initNewContactCreation();	
		fillContactForm(contact1);
		submitContactCreation();
		returnToHomePage();
		rebuildCache();

		return this;
	}

	public ContactHelper modifyContact(int index, ContactData contact1) {
		editContact(index);
		fillContactForm(contact1);
		submitContactModification();
		returnToHomePage();
		rebuildCache();

		return this;

	}

	public ContactHelper deleteContact(int index) {
		editContact(index);
		submitContactDeletion();
		returnToHomePage();
		rebuildCache();

		return this;
	}

	//	____________________________________________________________________

	private List<WebElement> getContactRows() {
		
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='maintable']/tbody/tr"));
		
		list.remove(0);
		list.remove(list.size()-1);
		
		return  list;
	}

	public ContactHelper editContact(int index) {
		click(By.xpath("(//a/img [@title='Edit'])["+ (index + 1) +"]"));
		return this;
	}

	public ContactHelper submitContactDeletion() {
		click(By.xpath("(//input[@name ='update'] [@value = 'Delete'])"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}


	public ContactHelper fillContactForm(ContactData contact1) {
		typeKeyInElement(By.name("firstname"), contact1.getFirstName());
		typeKeyInElement(By.name("lastname"), contact1.getLastName());
		typeKeyInElement(By.name("address"), contact1.getAddress());
		typeKeyInElement(By.name("home"), contact1.getHomeNumber());
		typeKeyInElement(By.name("mobile"), contact1.getMobileNumber());
		typeKeyInElement(By.name("work"), contact1.getWorkNumber());
		typeKeyInElement(By.name("email"), contact1.getEmail1());
		typeKeyInElement(By.name("email2"), contact1.getEmail2());
		selectDropdownValue(By.name("bday"), contact1.getbDay());
		selectDropdownValue(By.name("bmonth"), contact1.getbMonth());
		typeKeyInElement(By.name("byear"), contact1.getbYear());
		selectGroupDropdownValue(By.name("new_group"), contact1.getGroupName());
		typeKeyInElement(By.name("address2"), contact1.getAddress2());
		typeKeyInElement(By.name("phone2"), contact1.getHomeNumber2());

		return this;
	}

	public ContactHelper initNewContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.name("update"));
		cachedContacts = null;
		return this;

	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}


	public int getGroupsNumber() {
		manager.getNavigationHelper().goToGroupsPage();
		return manager.driver.findElements(By.name("selected[]")).size();

	}



}
