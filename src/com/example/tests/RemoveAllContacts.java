package com.example.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class RemoveAllContacts extends TestBase {

	@Test
	public void removeContacts() {
		appManager.getNavigationHelper().openMainPage();;
		removeEveryContact();

	}

	private void removeEveryContact() {

		List<WebElement> list = appManager.driver.findElements(By.xpath("(//a/img [@title='Edit'])"));
		while (list.size() > 0)
		{
			list.get(0).click();
			appManager.getContactHelper().submitContactDeletion();
			appManager.getContactHelper().returnToHomePage();
			
			list = appManager.driver.findElements(By.xpath("(//a/img [@title='Edit'])"));

			
		}

//
//		appManager.driver.findElement(By.xpath("(//a/img [@title='Edit'])").click());
//		
//		
//		
//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a/img [@title='Edit'])")));
//		List<WebElement> contactLinks = appManager.driver.findElements(By.xpath("(//a/img [@title='Edit'])"));


//		while(contactLinks.size() > 0)
//		{
//			contactLinks.get(contactLinks.size()-1).click();
//			appManager.getContactHelper().submitContactDeletion();
//			contactLinks.remove(contactLinks.size()-1);
//
//			appManager.getContactHelper().returnToHomePage();
//		}
	}

	protected void click(By locatior) {
		appManager.driver.findElement(locatior).click();
	}
	public void deleteContact(int index) {

		click(By.xpath("(//input[@name ='update'])["+ index +"]"));
	}
}