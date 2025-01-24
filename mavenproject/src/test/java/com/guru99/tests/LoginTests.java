package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTests extends BaseTests {

	@Test
	@Parameters({"username","userPassword"})
	public void verifyUserLoginWithValidCredentials(String username, String password) {
		reportUtils.createATestCase("verify User Login With Valid Credentials");
		reportUtils.addTestLog(Status.INFO, "Performing Login");
		loginpage.loginToApplication(username, password);
		String expectedTitle= "GTPL Baank Manager HomePage";
		String ActualTitle = cmnDriver.getTitleOfPage();
		reportUtils.addTestLog(Status.INFO, "Comparing expected and actual");
		Assert.assertEquals(expectedTitle, ActualTitle);
	}
}
