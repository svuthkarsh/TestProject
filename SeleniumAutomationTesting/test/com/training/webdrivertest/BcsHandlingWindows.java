package com.training.webdrivertest;

import java.awt.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BcsHandlingWindows {
WebDriver driver;



@BeforeClass
public void setUp()
{
	driver=new FirefoxDriver();
	driver.get("http://www.bcsrecruit.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}

@Test
public void HandleWindow() throws InterruptedException{
	/*//Handling Links and Counts
	java.util.List<WebElement>lst = driver.findElements(By.xpath("a"));
	int linkSize = lst.size();
	System.out.println(linkSize);
	for(WebElement element:lst) {
		String text = element.getText();
		System.out.println(text);
	}*/
	 //one Way of handling windows
	String Parentwindow=driver.getWindowHandle();
	System.out.println("Parent Window Title:"+Parentwindow);
	WebElement childWindow=driver.findElement(By.linkText("BCS, The Chartered Institute for IT"));
	childWindow.click();
	Thread.sleep(3000);
	Set<String>windows=driver.getWindowHandles();
	for (String newWindow : windows) {
		driver.switchTo().window(newWindow);
		Thread.sleep(3000);
	
		
	}
	driver.close();
	Thread.sleep(3000);
	driver.switchTo().window(Parentwindow);
	Thread.sleep(3000);
	
	/*//second way of handling windows
	for (String newWindow:driver.getWindowHandles()) {
		driver.switchTo().window(newWindow);
		
		//3rd way of handling windows
		driver.switchTo().window("BCS - The Chartered Institute for IT");
		
		driver.switchTo().window(Parentwindow);*/
		 
		
	}
		
	


	
			
	
	
	/*String window=driver.getWindowHandle();
	System.out.println(window);
	WebElement link=driver.findElement(By.xpath("//a[contains(text(),'BCS, The Chartered Institute for IT')]"));
	link.click();   
	
	Set<String> links=driver.getWindowHandles();
	System.out.println(links);*/
	
	 
}

