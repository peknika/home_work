package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected ApplicationManager appManager;

	@BeforeTest
	public void setUp() throws Exception {
		appManager = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		appManager.stop();
	}

}
