package com.training.webdrivertestbcs;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BcsAlertTest {

	WebDriver driver;
	String URL="http://www.bcsrecruit.com";
	@org.testng.annotations.BeforeClass
	public void setUP()
	
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
@Test

public void AlertTest()
{
	driver.get(URL);
	WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
	WebElement reg=driver.findElement(By.xpath("//input[@class='reg']"));
	reg.click();
	
		Alert alert=driver.switchTo().alert();
		String actual=alert.getText();
		String Expected="Please enter a value for the Email Address field.";
		Assert.assertEquals(actual, Expected, "Alert is not displayed");
		System.out.println(actual);
		alert.accept();
		
		
		email.clear();
		
		email.sendKeys("  @gmail.com");
		reg.click();
		Alert alert1=driver.switchTo().alert();
		String actual1=alert1.getText().trim();
		String email1="Please enter only letter, digit and";
		String email2="\"_-'.@\"";
		String email3="/characters in this email field.";
		String expected=email1.concat(email2);
		String expected1=expected.concat(email3).trim();
		
		Assert.assertEquals(actual1, expected1, "Alert is not displayed");
		System.out.println(actual1);
		System.out.println(expected1);
		alert.accept();
		
		
		
				
		
		
	
			
}
	
	
}
