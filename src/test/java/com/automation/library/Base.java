package com.automation.library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.automation.pages.HomePage;
import com.automation.pages.LandingPage;

public class Base {

	public static WebDriver driver;
	public static SeleniumLibrary myLib;
	public static Properties prop;
	private static String browser;
	public static HomePage hp;
	public static LandingPage lp;

	@BeforeMethod
	public void beforeEachTestStart() throws Exception {

		driver = myLib.initializeDriver(browser);
		hp = new HomePage(driver);
	    lp = new LandingPage(driver);
		driver.get(prop.getProperty("homePageurl"));

	}

	@AfterMethod(alwaysRun = true)
	public void afterEachTestComplete() {
		driver.close();
	}

	@BeforeClass(alwaysRun = true)
	public void beforeAllTestStart() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\dynamicConfig.properties");
		prop.load(fis);
		browser = prop.getProperty("browser");
		myLib = new SeleniumLibrary(driver);

	}

	@AfterClass(alwaysRun = true)
	public void afterAllTestsComplete() {
		if (driver != null) {
			driver.quit();
		}
	}

}
