package com.training.webdrivertestbcs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartHomePageSubMenus {
WebDriver driver;
String title=null;
int Step=0;

@BeforeClass
public void setUp()
{	/*System.setProperty("webdriver.chrome.driver","C:\Backup\Automation\Workspace");*/
	driver=new FirefoxDriver();
	driver.get("http://www.flipkart.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}

@Test

public void flipkartHome() throws InterruptedException
{
	Step=0;
	/*WebElement Ad=driver.findElement(By.xpath("//a[@class='js-promo-cancel promoCancel']"));
	Ad.click();*/
	String title=driver.getTitle().trim();
	String ExpHomePageTitle="Online Shopping India Mobile, Cameras, Lifestyle & more Online @ Flipkart.com";
	Assert.assertEquals(title, ExpHomePageTitle, "Flipkart Home Page Title is not displayed");
	System.out.println(Step++ +"Home Page With all Sub Pages");
	WebElement Electronics=driver.findElement(By.xpath("//a[@class='menu-text fk-inline-block']//span[contains(text(),'Electronics')]"));
	WebElement Mobiles=driver.findElement(By.xpath("//li[@class='heading']//a[@href='/mobiles?otracker=hp_nmenu_sub_electronics_0_Mobiles']"));
	Electronics.click();
	Thread.sleep(1000);
	Mobiles.click();
	Thread.sleep(1000);
	
	System.out.println(Step++ +"Verifying Mobile Page");
	
	String Mobtitle=driver.getTitle().trim();
	String ExpMobTitle="Mobiles Phones - Buy Mobile Phones Online at Best Price in India - Flipkart.com";
	Assert.assertEquals(Mobtitle, ExpMobTitle,"Mob Home Page is not displayed");
	
}

 @AfterClass
 
 public void tearDown() throws Exception
 {
	 driver.quit();}
 
 }

