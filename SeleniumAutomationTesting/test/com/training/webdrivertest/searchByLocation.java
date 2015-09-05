package com.training.webdrivertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetText;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class searchByLocation {

	WebDriver driver;
	
	
	@BeforeClass
	
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.bcsrecruit.com");
	}
	
	
	@Test
	
	public void test1()
	{
		
	String title=driver.getTitle();
	if(title.equals("BCSrecruit.com"))
			{
		System.out.println("Home Page title is displayed");
	}
	else {
		System.out.println("Home Page Title is not displayed");
	}
	
	WebElement location=driver.findElement(By.id("location_include"));
	location.clear();
	location.sendKeys("London");
	WebElement search=driver.findElement(By.xpath("//input[@value='Search']"));
	search.click();
	String searchresultstitle=driver.getTitle();
	if(searchresultstitle.equals("BCSrecruit Search Results"))
	{
		System.out.println("Search Result Title is displayed");
	}

 	else {
		System.out.println("Search Result title is not displayed");
	}
	WebElement count=driver.findElement(By.tagName("h1"));
String countingtext=count.getText();
if(countingtext.equals("count"))
		{
			System.out.println("Count is equal");
		}
	
else {
	System.out.println("Count is not equal");
}
	
	WebElement logo=driver.findElement(By.xpath("//img[@src='/images/home/logo.gif']"));
	
	String logoimage=logo.getText();	
	
if(logoimage.equals("logo"))
{
	System.out.println("log is present");
}
	
	
else {
	System.out.println("logo is not present");
}
	WebElement IsElementPresent=driver.findElement(By.tagName("p"));
	String text1=IsElementPresent.getText();
	if(IsElementPresent.equals("text1"))
	{
		System.out.println("Element is present");
	}
	else {
		System.out.println("Element is not Present");
	}
	
	WebElement keyword1=driver.findElement(By.id("fp_skill_include"));
	keyword1.sendKeys("tester");
	WebElement search1=driver.findElement(By.xpath("//input[@value='Search']"));
	search1.click();
		

	
	}
	
	
	
	@AfterClass
	
	public void tearout()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
}
