package com.training.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonWindowHandling {
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
List<WebElement> element=driver.findElements(By.tagName("a"));

int elementsize=element.size();
System.out.println(elementsize);
for (WebElement webElement : element) {
	String text=webElement.getText();
	System.out.println(text);
	
}

}
}