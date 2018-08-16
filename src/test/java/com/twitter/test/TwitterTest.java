package com.twitter.test;

import org.testng.annotations.Test;

import com.automation.library.Base;

public class TwitterTest extends Base{
	@Test
	public void tweet() throws Exception {
		hp.logIntoTwitterAccount("aldonimamov49@gmail.com", "Ildan963.963.");
		lp.sendTweet("you can tweet anything you want");
		Thread.sleep(5000);

		
	}
	

}
