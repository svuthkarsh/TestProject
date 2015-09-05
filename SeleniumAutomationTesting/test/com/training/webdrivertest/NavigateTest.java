package com.training.webdrivertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigateTest {
WebDriver driver;

@BeforeClass
public void setUp()
{
	driver=new FirefoxDriver();
	driver.navigate().to("http://www.bcsrecruit.com/");
	driver.manage().window().maximize();
}
@Test
public void navigation() throws InterruptedException
{
	WebElement job=driver.findElement(By.xpath("//a[@title='Job Seeker Login']"));
	job.click();
	Thread.sleep(3000);
	driver.navigate().back();
	Thread.sleep(3000);
	String title="BCSrecruit.com".trim();
	String actual=driver.getTitle().trim();
	Assert.assertEquals(title, actual, "Home Page title is not displayed");
	driver.navigate().refresh();
	
}
}
