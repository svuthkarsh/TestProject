package com.training.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;

public class AmazonTest {
WebDriver driver;

@BeforeClass

public void setUp(){
	driver=new FirefoxDriver();
	driver.get("http://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}
@Test
public void Amazon() throws InterruptedException
{
	

	
	
	
	String Expected="Online Shopping: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	String actual=driver.getTitle();
	Assert.assertEquals(actual, Expected, "Home page title is not displayed");
	WebElement sort=driver.findElement(By.xpath("//a[@id='nav-link-shopall']"));
	WebElement books=driver.findElement(By.xpath("//div[@class='nav-template nav-flyout-content nav-tpl-itemList']//span[3]/span"));
	WebElement bestsellers=driver.findElement(By.xpath("//div[@class='nav-template nav-subcat nav-tpl-itemList nav-colcount-2']/following::div[@class='nav-panel']/a[2]/span[contains(text(),'Bestsellers')]"));
	WebElement textbox=driver.findElement(By.id("twotabsearchtextbox"));
	
	
	Actions action=new Actions(driver);
	action.moveToElement(sort).build().perform();
	Thread.sleep(3000);
	action.moveToElement(books).build().perform();
	Thread.sleep(3000);
	action.moveToElement(bestsellers).build().perform();
	bestsellers.click();
	Thread.sleep(3000);
	
	action.moveToElement(textbox).keyDown(textbox,Keys.SHIFT).sendKeys(textbox, "science fiction").keyUp(textbox,Keys.SHIFT).build().perform();
	Thread.sleep(3000);
	action.moveToElement(textbox).keyDown(textbox, Keys.BACK_SPACE).keyUp(textbox, Keys.BACK_SPACE).build().perform();
	action.moveToElement(textbox).keyDown(textbox, Keys.ARROW_DOWN).sendKeys(textbox,Keys.ENTER).keyUp(textbox,Keys.ARROW_DOWN).build().perform();
	
	  


}
}
