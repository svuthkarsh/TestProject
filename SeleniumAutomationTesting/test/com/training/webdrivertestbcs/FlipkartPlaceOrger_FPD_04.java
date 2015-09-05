package com.training.webdrivertestbcs;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartPlaceOrger_FPD_04 {

	WebDriver driver;
	
	@BeforeClass
	
		public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	
	public void placeOrder() throws InterruptedException
	{
		String expected="Online Shopping India Mobile, Cameras, Lifestyle & more Online @ Flipkart.com";
		String actual=driver.getTitle().trim();
		org.testng.Assert.assertEquals(actual, expected, "Flipkart Home Page is not displayed");
		
		 WebElement Men=driver.findElement(By.xpath("//a[@class='menu-text fk-inline-block']/span[contains(text(),'Men')]"));
		 Men.click();
		 Thread.sleep(3000);
		 
		 WebElement Clothing=driver.findElement(By.xpath("//div[@id='menu-men-tab-0-content']//a[contains(text(),'All Clothing')]"));
		 Actions action=new Actions(driver);
		 action.moveToElement(Clothing).build().perform();
		
		 WebElement Tshirt=driver.findElement(By.xpath("//div[@id='menu-men-tab-0-content']//a[contains(text(),'T-Shirts')]"));
		 Tshirt.click();
		 
		 
		 WebElement expectedText=driver.findElement(By.tagName("h1"));
		 
		 String actualText=expectedText.getText();
		 
		 if(expectedText.equals(actualText))
		 {
			 System.out.println( "T-Shirt page s present");
		 }
		 
		 WebElement Vneck=driver.findElement(By.xpath("//a[@class='link fk-display-block']/li[contains(text(),'V Neck')]"));
		 
		Vneck.click();
		Thread.sleep(4000);
		
		WebElement VneckTshirt=driver.findElement(By.xpath(".//*[@id='pageTitle']/h1[starts-with(.,'V-neck')]/following::div[@id='sort-dropdown']/span[contains(text(),'Popular')]/following::div[@id='products']/div/div[1]/div[3]/div/div[1]/a[1]/img"));
		VneckTshirt.click();
		Thread.sleep(2000);
		WebElement Size=driver.findElement(By.xpath("//div[@class='multiSelectionWidget unit size1of2']/following::div[@class='selector-boxes']/span[contains(text(),'S')]"));
		Size.click();
		Thread.sleep(2000);
		WebElement buy=driver.findElement(By.xpath("//div[@class='tmargin10 omniture-field']//input[@value='Buy Now']"));
		buy.click();
		Thread.sleep(3000);
		 
		WebElement orderpage=driver.findElement(By.xpath("//h2//span[contains(text(),'1. Before you place your order! ')]"));
		String Expected="1. BEFORE YOU PLACE YOUR ORDER!";
		String actualorderpage=orderpage.getText().trim();
		
		org.testng.Assert.assertEquals(actualorderpage, Expected, "Order Page is not displayed");
		
		 	}	
	
	
	
	@AfterClass
	
	public void tearDown()
	{
		driver.quit();
	}

	
	
	
	
	
	
	
	
	
}
