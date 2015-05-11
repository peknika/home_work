package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase {


	protected ApplicationManager manager;
	protected WebDriver driver;

	public HelperBase(ApplicationManager manager){
		this.manager = manager;
		this.driver = manager.driver;

	}

	
	 void typeKeyInElement(By locator, String inputValue) {
		 if (!inputValue.isEmpty()){
		WebElement webElement = driver.findElement(locator);
		
		webElement.clear();
		webElement.sendKeys(inputValue);
		}
		 
	} 
		 

	public void selectDropdownValue(By locator, String inputValue) {
		if ( !inputValue.isEmpty()){

		WebElement dropdownElement = driver.findElement(locator);
		new Select(dropdownElement).selectByVisibleText(inputValue);
	}
	}
	protected void click(By locatior) {
		driver.findElement(locatior).click();
	}
}
