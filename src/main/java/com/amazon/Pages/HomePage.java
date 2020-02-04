package com.amazon.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.baseClass.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath ="//*[text()='Amazon Pay']")
	WebElement amazonPay;
	
	@FindBy(xpath="//*[text()='Buy Again']")
	WebElement buyAgainLink;
	
	@FindBy(xpath="//*[text()='Your Orders' and @class='a-link-normal']")
	WebElement yourOrder;
	
	@FindBy(xpath = "//*[@id='a-autoid-1-announce']")
	WebElement allOrderLast6Months;
	
	@FindBy(xpath="(//*[@class='a-link-normal item'])[3]")
	WebElement cancelLink;
		
	@FindBy(xpath ="//*[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	By dropDown = By.xpath("//*[@id='searchDropdownBox']//option");
	
	@FindBy(xpath="//*[@type='submit' and @class='nav-input']")
	WebElement searchBtn;
	
	@FindBy(xpath ="//*[text()='(Renewed) HP 6470b Probook 14 Inch Screen Laptop (3rd Gen Intel Core i5 - 3320m /8 GB/320 GB HDD/Windows 10 Pro), Copper']")
	WebElement selectProduct;
	
	@FindBy(xpath="//*[@id='buy-now-button']")
	WebElement addToCart;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public void getDropDownSelect() {
		List<WebElement> dropDownList = driver.findElements(dropDown);
		for(int i =0; i<dropDownList.size(); i++) {
			System.out.println(dropDownList.get(i).getText());
		}
	}
	
	public void getBuyAgainLink() {
		buyAgainLink.click();
	}
	
	public void getAmazonPay() {
		amazonPay.click();
	}
	
	public void getYourOrder() throws InterruptedException {
		yourOrder.click();
		Thread.sleep(2000);
		allOrderLast6Months.click();
	}
	
	public void getProductCancelByCancelLink() {
		cancelLink.click();
	}
	public void getSearchText() {
		searchBox.sendKeys("Laptops");
		
	}
	
	public void getClickOnSearchBtn() {
		searchBtn.click();
	}
	
	public void getProductClicked() {
		selectProduct.click();
	}
	
	public void getAddToCart() {
		addToCart.click();
	}
	
	
	
	

}
