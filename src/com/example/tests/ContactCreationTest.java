package com.example.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testEmtyContactCreation() throws Exception {
    openMainPage();
    goToContactPage();
    ContactData contact1 = new ContactData();
    fillContactForm(contact1);
    submitContactCreation();
    returnToHomePage();
  }
  
  @Test
  public void testNonEmptyContactCreation2() throws Exception {
    openMainPage();
    goToContactPage();
    ContactData contact1 = new ContactData();
    contact1.firstName = "Ivan";
    contact1.lastName = "Ivanov";
    contact1.address = "Ivanovkaya street 56, 12";
    contact1.homeNumber = "11111111";
    contact1.mobileNumber = "22222222";
    contact1.workNumber = "33333333";
    contact1.email1 = "ivanov@gmail.com";
    contact1.email2 = "ivanov@yandex.ru";
    contact1.bDay = "18";
    contact1.bMonth = "October";
    contact1.bYear = "1965";
    contact1.groupName = "friends";
    contact1.address2 = "additional address";
    contact1.homeNumber2 = "44444444";
    fillContactForm(contact1);
    submitContactCreation();
    returnToHomePage();
  }

private void fillContactForm(ContactData contact1) {
	setKeyInElement("firstname", contact1.firstName);
    setKeyInElement("lastname", contact1.lastName);
    setKeyInElement("address", contact1.address);
    setKeyInElement("home", contact1.homeNumber);
    setKeyInElement("mobile", contact1.mobileNumber);
    setKeyInElement("work", contact1.workNumber);
    setKeyInElement("email", contact1.email1);
    setKeyInElement("email2", contact1.email2);
    selectDropdownValue ("bday", contact1.bDay);
    selectDropdownValue ("bmonth", contact1.bMonth);
    setKeyInElement("byear", contact1.bYear);
    selectDropdownValue ("new_group", contact1.groupName);
    setKeyInElement("address2", contact1.address2);
    setKeyInElement("phone2", contact1.homeNumber2);
}

private void returnToHomePage() {
	driver.findElement(By.linkText("home page")).click();
}

private void submitContactCreation() {
	driver.findElement(By.name("submit")).click();
}

private void goToContactPage() {
	driver.findElement(By.linkText("add new")).click();
}


private void setKeyInElement(String elementName, String inputValue)
{
	WebElement webElement = driver.findElement(By.name(elementName));
	
		webElement.clear();
		webElement.sendKeys(inputValue);
	
//	
//  driver.findElement(By.name(elementName)).clear();
//  driver.findElement(By.name(elementName)).sendKeys(inputValue);
}

private void selectDropdownValue (String elementName, String inputValue)
{
	if ( inputValue.isEmpty() )
		return; 
	WebElement dropdownElement =  driver.findElement(By.name(elementName));
	new Select(dropdownElement).selectByVisibleText(inputValue);
}

}