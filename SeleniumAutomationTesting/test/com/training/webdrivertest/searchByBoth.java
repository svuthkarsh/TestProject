package com.training.webdrivertest;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.thoughtworks.selenium.webdriven.commands.GetTitle;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class searchByBoth {

	WebDriver driver;
	
	@BeforeClass
	
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.bcsrecriut.com");
		}
	
	@Test
	
	public void bothTest()
	{
		
		Alert alert=driver.switchTo().alert();
		
		String alert1=alert.getText();
		String ExpectedValue="Please enter a value for the Email Address field.";
		Assert.assertEquals(alert1, ExpectedValue, "Alert is not displayed");
		alert.accept();
		
	/*String title=driver.getTitle();
	if(title.equals("BCSrecruit.com"))
	{
		System.out.println("Home Page Title is displayed");
	}
	else {
		System.out.println("Home Page title is not displayed");
	}
	
	WebElement Keyword=driver.findElement(By.id("fp_skill_include"));
	Keyword.sendKeys("Automatoion Tester");
	
	WebElement Location=driver.findElement(By.id("location_include"));
	Location.sendKeys("London");
	
	WebElement Search=driver.findElement(By.xpath("//input[@value='Search']"));
	Search.click();*/
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
