package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.server.browserlaunchers.GoogleChromeLauncher;


public class ApplicationManager {
	public WebDriver driver;
	public String baseUrl;

	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;

	public ApplicationManager(Properties properties) {
		this.properties = properties;
		String browser = properties.getProperty("browser");
		if ("firefox".equals(browser)) {
			driver = new FirefoxDriver();
		} else if ("chrome".equals(browser)) {
			driver = new ChromeDriver();
		} else if ("ie".equals(browser)) {
			driver = new InternetExplorerDriver();
		} else {
			throw new Error("unsupported browsers" + browser);
		}

		driver = new FirefoxDriver();
		baseUrl = properties.getProperty("browser");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}



	public void stop() {	
		driver.quit();

	}

	public NavigationHelper getNavigationHelper(){
		if (navigationHelper ==null) {
			navigationHelper = new NavigationHelper(this);
		}
		return  navigationHelper;

	}
	public ContactHelper getContactHelper(){
		if (contactHelper ==null) {
			contactHelper = new ContactHelper(this);
		}
		return  contactHelper;
	}

	public GroupHelper getGroupHelper(){
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}


}


