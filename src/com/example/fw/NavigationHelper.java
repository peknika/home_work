package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void goToContactPage() {
		click(By.linkText("add new"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void goToGroupsPage() {
		click(By.linkText("groups"));
	}

	public void openMainPage() {
	    driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}


}
