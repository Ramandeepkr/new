package com.amazon.baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.amazon.utils.Utility;



public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\amazon\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",".//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("FF")) {
			System.setProperty("webdriver.chrome.driver",".//Drivers//geckodriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Utility.PageLoadTimeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.ImplicitlyWait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}


}
