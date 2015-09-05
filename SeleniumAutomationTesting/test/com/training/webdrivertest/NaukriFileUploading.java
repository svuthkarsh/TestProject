package com.training.webdrivertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NaukriFileUploading {
WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
	
	@Test
	
	public void naukri() throws InterruptedException
	{
		String path="C:\\Users\\Shailesh kumar\\Desktop\\New Microsoft Office Word Document.docx";
		WebElement login=driver.findElement(By.xpath("//a[@id='login_Layer']"));
		String tooltip=login.getAttribute("title");
		String Expectedtooltip="Jobseeker Login";
		System.out.println(tooltip); 
		Assert.assertEquals(tooltip, Expectedtooltip, "Tool tip is not present");
		login.click();
		Thread.sleep(3000);
		WebElement register=driver.findElement(By.xpath("//div[@class='row txtC']/a"));
		register.click();
		Thread.sleep(3000);
		WebElement browse=driver.findElement(By.id("inpFile"));
		browse.sendKeys(path);
		Thread.sleep(3000);
		String doc="New Microsoft Office Word Document.docx";
		String orginal=browse.getAttribute("value");
		System.out.println(orginal);
		Assert.assertEquals(orginal, doc, "File is not present");
		}
	
	}
	
	
	
