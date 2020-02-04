package com.amazon.Pages;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.baseClass.BaseClass;
import com.amazon.utils.AmazonOTP;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class SignUpPage extends BaseClass {
	
	By signIn = By.xpath("//*[text()='Hello. Sign in']");
	
	@FindBy(xpath="//*[@id='ap_customer_name']")
	WebElement CreateUser;
	
	@FindBy(xpath="//*[@id=\"auth-country-picker-container\"]/span/span")
	WebElement usSelect;
	
	@FindBy(xpath="//*[@id='ap_phone_number']")
	WebElement Mobile;
	
	@FindBy(xpath="//*[@id='ap_password']")
	WebElement password;
	
	
	@FindBy(xpath="//*[@id='continue']")
	WebElement continueBtn;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
			
	}
	public void clickOnSignIn() {
		driver.findElement(signIn).click();
		
	}
	
	public void getUserInfo() throws InterruptedException {
		CreateUser.sendKeys("Kavita");
		getUSselect();
		Thread.sleep(1000);
		getMobileNumber();
		Thread.sleep(1000);
		getOTPpassword();
		Thread.sleep(1000);
		getContinueClick();
		
	}
	public void getUSselect() {
		usSelect.click();
		driver.findElement(By.xpath("//ul[@role='application']//li/a[contains(text(),'United States +1')]")).click();
		
	}
	public void getMobileNumber() {
		Mobile.sendKeys("13167127601");
		
	}
	public void getOTPpassword() {
		password.sendKeys("test@123");
		
	}
	
	
	public void getContinueClick() {
		continueBtn.click();
//		Twilio.init(AmazonOTP.ACCOUNTSID,AmazonOTP.AUTH_TOKEN);
//		String smsBody = getMessage();
//		System.out.println(smsBody);
	}
	
	public String getMessage() {
		return getMessages().filter(m->m.getDirection().compareTo(Message.Direction.INBOUND)==0)
				.filter(m->m.getTo().equals("+13167127601")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}
	private Stream<Message> getMessages() {
		ResourceSet<Message> messages = Message.reader(AmazonOTP.ACCOUNTSID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}

}
