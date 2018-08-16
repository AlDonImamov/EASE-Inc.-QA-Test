
package com.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.automation.library.Base;

public class HomePage extends Base{
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"doc\"]/div/div[1]/div[1]/div[2]/div[2]/div/a[2]")
	private WebElement loginButton;
	@FindBy(xpath = "//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[1]/input")
	private WebElement loginTextBox;
	@FindBy(xpath = "//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[2]/input")
	private WebElement passwordTextBox;
	
	
	 

	public void logIntoTwitterAccount(String username, String password) throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginButton);
		loginTextBox.sendKeys(username + Keys.TAB);
		passwordTextBox.sendKeys(password + Keys.ENTER);
		

	}
}
