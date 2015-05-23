package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}


	public void goToGroupsPage() {
		if (! onGroupsPage()){
			click(By.linkText("groups"));
		}

	}

	private boolean onGroupsPage() {
		if (driver.getCurrentUrl().contains("/group.php")
				&& driver.findElements(By.name("new")).size() > 0 ) {
			return true;
		} else {
			return false;
		}
	}

	public void openMainPage() {
		if (! onMainsPage()) {
			click(By.linkText("home"));
		}
	}

	private boolean onMainsPage() {
		return (driver.findElements(By.id("maintable")).size() > 0 );	 
	}


	public void goToHomePageWithMenueButton(){
		click(By.linkText("home"));	
	}
}
