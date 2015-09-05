package com.training.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import com.training.objectrepo.CreateAccount;
import com.training.objectrepo.HomePageWebElements;

public class SearchTests {

	Selenium S;
	
	@Before
	public void setUp() {
		S=new DefaultSelenium("localhost", 4444, "*firefox", "http://www.bcsrecruit.com");
		S.start();
		S.open("/");
		S.waitForPageToLoad("4000");
									
	
		
	}	
	
@Test

public void serachByKeyword() throws InterruptedException{
	    S.waitForPageToLoad("4000");
	    S.windowFocus();
		S.windowMaximize();
		S.type(HomePageWebElements.txtKeyword, "selenium");
		S.click(HomePageWebElements.btnSearch);
	//	S.waitForPageToLoad("4000");
		Thread.sleep(2000);


}
@Test

public void searchByLocation() throws InterruptedException {
	S.waitForPageToLoad("4000");
	S.type(HomePageWebElements.txtLocation, "london");
	S.click(HomePageWebElements.btnSearch);
	// S.waitForPageToLoad("4000");
Thread.sleep(2000);



}		

@Test
/*
public void headerLinks() {
	S.click(HomePageWebElements.textJobseekerlogin);
	S.waitForPageToLoad("4000");
	S.click(HomePageWebElements.textCareerAdvice);
	S.waitForPageToLoad("4000");*/

	

	






public void register() {

	S.type(HomePageWebElements.textField, "svuthkarsh@gmail.com");
	S.click(HomePageWebElements.btnReg);
	S.type(CreateAccount.txtFirstName,"Uthkarsh");
	S.type(CreateAccount.txtSurtName,"SV");
}

  
 


}