package com.amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.baseClass.BaseClass;

public class LoginPage extends BaseClass{
	
	
	@FindBy(xpath="//*[@id=\"nav-logo\"]/a[@class='nav-logo-link']")
	WebElement logo;
	
	By signIn = By.xpath("//*[text()='Hello. Sign in']");
	
	@FindBy(xpath ="//*[@id='ap_email']")
	WebElement emailORPhoneNo;

	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(id = "ap_password")
	WebElement pwd;
	
	
	@FindBy(xpath="//*[@id='signInSubmit']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//*[@id='continue']")
	WebElement authBtn;
	
	@FindBy(xpath="//*[@class='a-input-text a-span12 cvf-widget-input cvf-widget-input-code']")
	WebElement OTPNumber;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
			
	}
	
	public boolean verifyLogo() {
		return logo.isDisplayed();
		
	}
	public void clickOnSignIn() {
		driver.findElement(signIn).click();
		
	}
	public void getEmailOrPhoneNo(String emailOrPhone) {
		emailORPhoneNo.sendKeys(emailOrPhone);
	}
	
	public void clickOnContinue() {
		continueBtn.click();
	}
	
	public void getPassword(String password) {
		pwd.sendKeys(password);
		
		
	}
	public void getLoginClick() {
		LoginBtn.click();
	}
	
	public void getAuthClick() {
		authBtn.click();
	}
	public void getOTPNumber() {
		OTPNumber.sendKeys("");
	}


}
