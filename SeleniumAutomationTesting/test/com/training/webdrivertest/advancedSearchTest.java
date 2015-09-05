package com.training.webdrivertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class advancedSearchTest {
 
	WebDriver driver;
	
	@BeforeClass
	
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bcsrecruit.com");
	}
	
	@Test
	
	public void adTest()
	{
		WebElement advanced=driver.findElement(By.xpath("//a[@class='advSearch']"));
		advanced.click();
	String title=driver.getTitle();
	if(title.equals("Advanced Search"))
	{
		System.out.println("Advanced Search Page Title is displayed");
	}
	else {
		System.out.println("Advanced Search page title is not displayed");
	}
	
	WebElement keyword=driver.findElement(By.xpath("//input[@id='skill_keywords']"));
	keyword.clear();
	keyword.sendKeys("Manual Testing");
	WebElement location=driver.findElement(By.id("location_include"));
	location.clear();location.sendKeys("London");
	WebElement within=driver.findElement(By.id("location_within"));
	new Select(within).selectByValue("15");
	WebElement Jobtitle=driver.findElement(By.id("job_title_keywords_id"));
	Jobtitle.clear();
	Jobtitle.sendKeys("Software Engineer");
	WebElement Ignore=driver.findElement(By.id("exclude_keywords"));
	Ignore.clear();
	Ignore.sendKeys("Description");
	WebElement job=driver.findElement(By.id("exclude_type"));
	new Select(job).selectByValue("S");
	WebElement search=driver.findElement(By.xpath("//input[@value='Search']"));
	search.click();
String resulttitle=driver.getTitle();
if(resulttitle.equals("BCSrecruit Search Results"))
{
	System.out.println("Search Results are displayed");
}
else {
	System.out.println("Search results are not displayed");
}
	
	WebElement count=driver.findElement(By.tagName("h1"));
		String resultscount=count.getText();
		if(resultscount.contains("Jobs"))
		{
			System.out.println("Count is matching");
		}
	
		else {
			System.out.println("Count is not matching");
		}
		
		
		
		
		
		
	
	}
	
	
	
	
	
	
}
