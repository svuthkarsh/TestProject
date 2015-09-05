package com.training.webdrivertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class searchTests {
/**
 * Starts the Browser Session with the given URL
 * @author Uthkarsh 
 * @return-void
 * @paramu-User Name, Password
 */
	WebDriver driver;
	private String title=null;
	
	@BeforeClass
	
	public void Setup()
	
	{
		driver= new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.bcsrecruit.com");
	}
	
	
	@Test
	
	public void searchByKeyword() throws Exception
	{
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
	}
	
	@AfterClass
	
	public void tearDown()
	{
		driver.quit();
	}
	
	
	}
		
	
	//* Select the Drop down



