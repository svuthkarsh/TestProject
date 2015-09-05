package com.training.tests;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;
import com.training.objectrepo.HomePageWebElements;

public class HomePageTest { 

	private Selenium s;
	private String BASE_URL="https://www.bcsrecruit.com";
	private String BROWSER="firefox";
	private String title=null;
	private String homePageTitle="BCSrecruit.com";
	private String seekerTitle= "My BCSrecruit";
	private String  PAGE_LOAD="300000";
	private String textMessage="Welcome manjunath";
	private String text=null;
	boolean flag=true;
	
	
	
	
	
	
	@Before
	
	public void setUp() throws Exception{
		
		s=new DefaultSelenium("localhost", 4444, BROWSER, BASE_URL);
		s.start();
		s.windowMaximize();
		s.windowFocus();
	}
	
	
	@Test
	
			
	public void homeTest1() throws InterruptedException {
		s.open("/");
		title=s.getTitle().trim();
		Assert.assertEquals("home Page title is not displayed", homePageTitle, title);
		flag=s.isElementPresent(HomePageWebElements.textLogo);
		
		// job seeker page login
		
		s.click(HomePageWebElements.textJobseekerlogin);
		s.waitForPageToLoad(PAGE_LOAD);
		Thread.sleep(5000);
		title=s.getTitle().trim();
		Assert.assertEquals("Job Seeker Title is not Present", seekerTitle, title);
		flag=s.isElementPresent("//h1");
		
		s.type("//input[@id='email']","manjunath.r@wisdomleaf.com");
		s.type("//input[@id='password']", "manjunath123");
		s.click("//input[@value='Log in']");
		s.waitForPageToLoad(PAGE_LOAD);
		Thread.sleep(5000);
		text=s.getText("//h1");
		Assert.assertEquals("Welcome message is not displayed", textMessage, text);
		flag=s.isElementPresent(".//*[@id='nav']/ul/li[1]");
		Assert.assertEquals("Logoff is not present",flag);
		
		
	}
 
	
	
	
	
}
