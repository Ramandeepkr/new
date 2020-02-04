package com.amazon.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.Pages.HomePage;
import com.amazon.Pages.LoginPage;
import com.amazon.baseClass.BaseClass;

public class HomePageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.clickOnSignIn();
		loginPage.getEmailOrPhoneNo(prop.getProperty("emailID"));
		loginPage.clickOnContinue();
		loginPage.getPassword(prop.getProperty("password"));
		loginPage.getLoginClick();
	}
	
	@Test(enabled = false)
	public void getDropDownSelectTest() {
		homePage.getDropDownSelect();
	}
	
	@Test(priority = 1)
	public void getSearchTextTest() throws InterruptedException {
		homePage.getSearchText();
		Thread.sleep(2000);
		homePage.getClickOnSearchBtn();
		homePage.getProductClicked();
		getAddToCartTest();
		
		
	}
	@Test(priority = 2,enabled = false)
	public void getbuyAgainLinkTest() throws InterruptedException {
		Thread.sleep(1000);
		homePage.getBuyAgainLink();
	}
	
	@Test(priority = 3,enabled = false)
	public void getAllBuyAgainLinksTest() throws InterruptedException {
		homePage.getYourOrder();
		getProductCancelByCancelLinkTest();
	}
	
	@Test(enabled = false)
	public void getProductCancelByCancelLinkTest() {
		homePage.getProductCancelByCancelLink();
	}
	
	public void getAmazonpayTest() {
		homePage.getAmazonPay();
	}
	
	public void getAddToCartTest() {
		homePage.getAddToCart();
	}
	

	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
