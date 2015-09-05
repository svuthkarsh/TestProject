package com.training.webdrivertestbcs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class FlipkartToVerifyHomePageSubMenus_FPD_02 {
	 
WebDriver driver;
String title=null;
@BeforeClass

public void setUp()
{
	driver=new FirefoxDriver();
	driver.get("http://www.flipkart.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
}

	 @Test
	 
	 public void flipSubMenuTest() throws InterruptedException
	 {
		
		/*WebElement Ad=driver.findElement(By.xpath("//a[@class='js-promo-cancel promoCancel']"));
		Ad.click();*/
		String title=driver.getTitle().trim();
		String exptitle="Online Shopping India Mobile, Cameras, Lifestyle & more Online @ Flipkart.com";
		Assert.assertEquals(title, exptitle, "home pge is not displayed");
		 
	/*	WebElement search=driver.findElement(By.xpath("//input[@id='fk-top-search-box']"));
		search.sendKeys("Yonex Bat");
		Thread.sleep(4000);
		search.sendKeys(Keys.ENTER);*/
		
		WebElement Electronics=driver.findElement(By.xpath("//a[@class='menu-text fk-inline-block']/span[contains(.,'Electronics')]"));
		
		WebElement tablet=driver.findElement(By.xpath("//div[@id='menu-electronics-tab-0-content']//li[@class='heading']//a[contains(text(),'Tablets')]"));
		
		
		Actions actions=new Actions(driver);
		actions.moveToElement(Electronics).build().perform();
		Thread.sleep(3000);
		
		actions.moveToElement(tablet);
		actions.click().build().perform();
		
		WebElement Tablettext=driver.findElement(By.xpath("//div[@class='gd-row bmargin10']/h1"));
		String Tabactual=Tablettext.getText().trim();
		String TabExpec="TABLETS";
		Assert.assertEquals(Tabactual, TabExpec, "Tablets are not present");	
		
			 }
	 
@AfterClass

	public void tearDown()
	{
		driver.quit();
	}
}

