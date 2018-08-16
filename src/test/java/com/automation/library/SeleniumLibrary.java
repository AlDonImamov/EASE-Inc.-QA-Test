package com.automation.library;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumLibrary {

	private WebDriver driver;
	private Properties prop;
	public boolean isDemoMode = false;

	public SeleniumLibrary(WebDriver _driver) {
		driver = _driver;
	}

	public WebDriver initializeDriver(String browser) throws Exception {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\test\\resources\\dynamicConfig.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {// webdriver.ie.driver
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public WebElement waitTillElementclickable(WebElement element) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(element));
		return myDynamicElement;
	}

	public void customWait(double inSeconds) throws Exception {
		Thread.sleep((long) (inSeconds * 1000));
	}

}