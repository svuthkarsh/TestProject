package com.training.webdrivertest;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FailedTestScreenShot {
	public class searchByJobType {
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
		public void searchBySalary() throws Exception
		{
			try {
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
			
			
			WebElement jobtype=driver.findElement(By.id("jobtypeP"));
			jobtype.click();
			WebElement currency=driver.findElement(By.id("currencyType"));
			new Select(currency).selectByValue("USD");
			WebElement rate=driver.findElement(By.id("hourlyFormat"));
			rate.click();
			Thread.sleep(3000);
			
			Select sal= new Select(driver.findElement(By.id("fromSalary")));
			
			sal.selectByIndex(2);
			WebElement tosalary=driver.findElement(By.id("toSalary"));
			new Select(tosalary).selectByIndex(4);
			
			WebElement Moreoptions=driver.findElement(By.xpath("//select[@id='daysbac ']/option[1]"));
			
			String actualvalue=Moreoptions.getText();
			System.out.println("The Value is present"+ actualvalue);
			String expectedvalue="in last 7 days";
			Assert.assertEquals(actualvalue, expectedvalue, "actual last 7days is not displayed");
			
			} catch (Exception e) {
				getScreenShot();
				throw new Exception("TEST CASE FAILED WHILE VERIFYING\n::searchBySalary"+e.getLocalizedMessage());
  				
			}
			
		}
		
		
		
		
	
	//To Capture the screen shot
	public void getScreenShot() throws IOException
	{
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File destination=new File("E:\\Automation\\Workspace\\SeleniumAutomationTesting\\Resources\\ScreenShots\\screenshot1.png");
		 FileUtils.copyFile(src, destination);
	}
	}
}
