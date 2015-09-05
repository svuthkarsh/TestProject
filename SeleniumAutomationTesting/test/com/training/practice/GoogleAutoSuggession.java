package com.training.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetText;

public class GoogleAutoSuggession {

	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void Google() throws InterruptedException
	{
		WebElement Textbox=driver.findElement(By.xpath("//input[@id='lst-ib']"));
		Textbox.sendKeys("selenium org");
		WebElement selenium=driver.findElement(By.xpath(".//*[@id='sbse0']/div[contains(.,'selenium org')]"));
		selenium.click();
		Thread.sleep(3000);
		
		WebElement OrgUrlText=driver.findElement(By.xpath("//cite[contains(@class,'Rm') and contains(.,'www') and contains(.,'selenium') and contains(.,'hq.')and contains(.,'org')]"));
		WebElement Url=driver.findElement(By.xpath(".//*[@id='rso']//a[contains(text(),'Selenium - Web Browser Automation')]"));
		String Urltext="www.seleniumhq.org";
		 
		Url.click();
				
		
		
				}
		
		
		/*Actions action=new Actions(driver);
		action.moveToElement(Textbox).sendKeys(Textbox, "selenium org").sendKeys(Textbox, Keys.ARROW_DOWN).sendKeys(Textbox,Keys.ENTER).build().perform();
		Thread.sleep(3000);*/
		
	}
	
	
	


