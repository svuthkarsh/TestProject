package com.training.webdrivertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class myFirstWebdriverTest {

	public static void main(String args[])
	
	{
		//Creating and Instantiates Browser Objects
		
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.bcsrecruit.com");
		String title=driver.getTitle();
		if(title.contains("BCSrecruit.com"))
		{
			System.out.println("Home Page is displayed as expected");
		}
		else {
			System.out.println("Home Page is not displayed as expected");
		}
		
		WebElement keyword=driver.findElement(By.id("fp_skill_include"));
		keyword.clear();
		keyword.sendKeys("Selenium");
		WebElement search=driver.findElement(By.xpath("//input[@value='Search']"));
		search.click();
		String searchresulttitle=driver.getTitle();
		if(searchresulttitle.contains("BCSrecruit Search Results"))
		{
			System.out.println("Search Result Page is displayed");
		}
			else {
				System.out.println("Search Results page is not displayed");
			}
		
		WebElement jobscount=driver.findElement(By.tagName("h1"));
		String count=jobscount.getText().trim();
		if(count.contains("202"))
		{
			System.out.println("Job Count is matching");
		}
		
		else { 
			System.out.println("Job Count is not matching");
		}
		
		//*Drop down handing
	/*	WebElement Currency=driver.findElement(By.id("currencyType"));
		new Select(Currency).selectByVisibleText("GBP - Pound Sterling</option>");*/
		
		driver.quit();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
