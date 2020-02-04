package com.amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.utils.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPage {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Utility.PageLoadTimeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.ImplicitlyWait,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Laptops");
		driver.findElement(By.xpath("//*[@type='submit' and @class='nav-input']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Lenovo Ideapad S145 AMD A6-9225 15.6 inch HD Thin and Light Laptop (4GB/1TB/Windows 10/Grey/1.85Kg), 81N30063IN']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#buy-now-button")).click();
		//driver.findElement(By.xpath("//*[@id='siNoCoverage-announce']")).click();
	}
	
	
	

}
