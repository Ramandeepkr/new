package com.amazon.testCases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.amazon.Pages.SignUpPage;
import com.amazon.baseClass.BaseClass;

public class SignUpPageTest extends BaseClass {
	SignUpPage signup;
	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signup = new SignUpPage();

	}
	

	@Test(priority = 1)
	public void getNewlyCreatedUserTest() throws InterruptedException {
		signup.clickOnSignIn();
		driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
		Thread.sleep(2000);
		getSignUpInfoTest();
		
		
	}

	public void getSignUpInfoTest() throws InterruptedException {
		signup.getUserInfo();
		
	}
//	public void getUSSelectTest() {
//	signup.getUSselect();
//	}
	
//	public
//	signup.getMobileNumber();
//	signup.getOTPpassword();
//	signup.getContinueClick();
	

}
