package com.amazon.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.amazon.Pages.LoginPage;
import com.amazon.baseClass.BaseClass;



public class LoginPageTest extends BaseClass{
	LoginPage loginPage;
	
	public LoginPageTest() {
		super();
	}	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(enabled = false)
	public void verifyLogoTest() {
		Assert.assertTrue(loginPage.verifyLogo());
	}
	
	
	
	@Test(priority = 1)
	public void getEmailOrPhoneNoTest() {
		
		loginPage.clickOnSignIn();
		loginPage.getEmailOrPhoneNo(prop.getProperty("emailID"));
		loginPage.clickOnContinue();
		loginPage.getPassword(prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
