package com.automation.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.library.Base;

public class LandingPage extends Base {

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#tweet-box-home-timeline")
	private WebElement tweetTextBox;
	@FindBy(xpath = "//*[@id=\"swift_tweetbox_1534450637613\"]/div[3]/div[2]/button")
	private WebElement tweetBtn;
	@FindBy(className = "js-tweet-text-container")
	private List<WebElement> tweets;

	public void sendTweet(String tweet) throws InterruptedException {
		tweetTextBox.sendKeys(tweet + Keys.CONTROL, Keys.RETURN);
		Thread.sleep(3000);
		String actualTweet = tweets.get(0).getText();
		Assert.assertEquals(actualTweet, tweet);

	}
	

}
