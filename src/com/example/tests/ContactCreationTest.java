package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactCreationTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

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

private void openMainPage() {
	driver.get(baseUrl + "/addressbookv4.1.4/");
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

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
