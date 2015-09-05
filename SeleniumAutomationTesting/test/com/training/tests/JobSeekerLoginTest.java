package com.training.tests;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import com.training.objectrepo.HomePageWebElements;
import com.training.objectrepo.JobSeekerWebElements;

public class JobSeekerLoginTest {
	
	private Selenium selenium;
	private String BASE_URL ="https://www.bcsrecruit.com"; 
	private String BROWSER ="*firefox";
	private String title = null;
	private String URL = null;
	private String expHomePageTitle = "BCSrecruit.com";
	private String expLoginPageTitle = "My BCSrecruit";
	private String expWelcomeMessage = "Welcome Dean";
	private String PAGE_LOAD_TIME = "300000";
	String expURL="http://www.bcsrecruit.com/";
	String imgSiteLogo="";
	String expJobSeekerURL="https://www.bcsrecruit.com/cgi-bin/login_applicant.cgi";
	
	 
	boolean flag = false;
	private String text = null;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, BROWSER, BASE_URL);
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
	}

	@Test
	public void testFirst() throws Exception {
		selenium.open("/");

		
		
		Thread.sleep(3000);
		
		title = selenium.getTitle().trim();
		System.out.println(title);
		if (expHomePageTitle.contains(title)) {
			Assert.assertEquals("Home page is not displayed as expected", expHomePageTitle, title);
			System.out.println("Home page is displayed as expected step:"+1);
		}else {
			System.out.println("Home page is not displayed as expected step:"+1);
		}
		
		
		Thread.sleep(3000);
		
		
		URL = selenium.getLocation();
		System.out.println(URL);
		Assert.assertEquals("URL is not correct as expected", expURL, URL);
		System.out.println("URL is correct as expected");
				
		
		
		Thread.sleep(3000);
		
		flag = selenium.isElementPresent(JobSeekerWebElements.imgSiteLogo);	
		Assert.assertTrue("Logo is not present", flag);
		System.out.println("Logo present");
		
		Thread.sleep(3000);
		
		flag = selenium.isElementPresent(JobSeekerWebElements.lnkJobSeekerLogin);	
		Assert.assertTrue("JobSeekerLogin link not present", flag);
		System.out.println("JobSeekerLogin link present");
		
		selenium.click(JobSeekerWebElements.lnkJobSeekerLogin);
		
		Thread.sleep(3000);
		
		String JobSeekerURL = selenium.getLocation();
		System.out.println(JobSeekerURL);
		Assert.assertEquals("JobSeekerURL is not correct as expected", expJobSeekerURL, JobSeekerURL);
		System.out.println("JobSeeker Page URL is correct");
		Thread.sleep(3000);
		
		flag = selenium.isElementPresent(JobSeekerWebElements.pageJobSeekerLoginPage);	
		Assert.assertTrue("JobSeekerLogin is  present", flag);
		System.out.println("JobSeekerLogin Page is present");
		
		flag = selenium.isElementPresent(JobSeekerWebElements.txtEmailAddress);	
		Assert.assertTrue("Email Address is not  present", flag);
		System.out.println("Email Address TextBox is present");
		
		flag = selenium.isElementPresent(JobSeekerWebElements.txtPassword);	
		Assert.assertTrue("Pasword is not present", flag);
		System.out.println("Password TextBox is present");
		
		flag = selenium.isElementPresent(JobSeekerWebElements.lnkForgottenPassword);	
		Assert.assertTrue("Forgotten Password is not present", flag);
		System.out.println("Forgotten Password Link is present");
		
		flag = selenium.isElementPresent(JobSeekerWebElements.btnJobSeekerLogin);	
		Assert.assertTrue("JobSeekerLogin is not  present", flag);
		System.out.println("JobSeekerLogin Button is present");
		

		
			}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}

}
