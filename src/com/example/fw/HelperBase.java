package com.example.fw;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.NoSuchElementException;

public abstract class HelperBase {


	protected ApplicationManager manager;
	protected WebDriver driver;

	public HelperBase(ApplicationManager manager){
		this.manager = manager;
		this.driver = manager.driver;

	}


	void typeKeyInElement(By locator, String inputValue) {
		if (inputValue != null){
			WebElement webElement = driver.findElement(locator);

			webElement.clear();
			webElement.sendKeys(inputValue);
		}

	} 


	public void selectDropdownValue(By locator, int index) {
		WebElement dropdownElement = driver.findElement(locator);
		new Select(dropdownElement).selectByIndex(index);
	}

	public void selectGroupDropdownValue(By locator, int index) {
		try { 
			WebElement dropdownElement = driver.findElement(locator);
			Select se = new Select(dropdownElement);
			List<WebElement> l = se.getOptions();
			l.size();

			Random rnd = new Random();
			se.selectByIndex(rnd.nextInt(l.size()-1)+1);
		} catch (NoSuchElementException ex) { 
			//	        do nothing, webElement is not present
		}
	}

	protected void click(By locatior) {
		driver.findElement(locatior).click();
	}
}
