package com.example.fw;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

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
		if (inputValue != null){
			WebElement webElement = driver.findElement(locator);

			webElement.clear();
			webElement.sendKeys(inputValue);
		}

	} 


	public void selectDropdownValue(By locator, int index) {
		WebElement dropdownElement = driver.findElement(locator);
		Select select = new Select(dropdownElement);
		List<WebElement> options = select.getOptions();
		assertTrue((index >= 0) && (index < options.size()), "invalid index");
		select.selectByIndex(index);
	}


	public void selectGroupDropdownValue(By locator, int index) {
		WebElement dropdownElement = driver.findElement(locator);
		if (dropdownElement != null)
		{
			Select se = new Select(dropdownElement);
			List<WebElement> l = se.getOptions();

			Random rnd = new Random();
			se.selectByIndex(rnd.nextInt(l.size()-1)+1);
		}
		else{
			
		}
		
	}

	protected void click(By locatior) {
		driver.findElement(locatior).click();
	}
}
