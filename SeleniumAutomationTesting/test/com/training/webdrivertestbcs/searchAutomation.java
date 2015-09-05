package com.training.webdrivertestbcs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetTitle;

public class searchAutomation {

	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void searchbylocation()
	{
		driver.get("http://www.bcsrecruit.com/");
		WebElement location=driver.findElement(By.id("location_include"));
		boolean flag=location.isDisplayed();
		Assert.assertTrue(flag, "Location is not displayed");
		System.out.println(flag+ "Location Text Box Should get displayed");
		WebElement searchbtn=driver.findElement(By.className("submit"));
		boolean searchflag=searchbtn.isDisplayed();
		Assert.assertTrue(searchflag, "searchbtn is not displayed");
		System.out.println(searchflag+ "Search button should get displayed");
		location.clear();
		location.sendKeys("London");
		searchbtn.click();
		String title=driver.getTitle();
		String expectedresult="BCSrecruit Search Results";
		Assert.assertEquals(title, expectedresult, "Search Result is not displayed");
		if(title.equals("BCSrecruit Search Results"))
		{
			System.out.println("Search Results page is displayed");
		}
		else {
			System.out.println("Search Results are not displayed");
		}
		
		WebElement Locationmatch=driver.findElement(By.xpath("//p[contains(., 'Locations: within')]/em"));
		String Actual=Locationmatch.getText();
		System.out.println("The value is present"+ Actual);
		String expected="London";
		Assert.assertEquals(Actual, expected, "Entered Location is not present");
		WebElement count=driver.findElement(By.tagName("h1"));
		String Counting=count.getText();
		if(Counting.contains(expected))
		{
			System.out.println("Count is match");
		}
		else {
			System.out.println("Count is not match");
		}
		WebElement sortBy=driver.findElement(By.id("resultsSort"));
		new Select(sortBy).selectByValue("/cgi-bin/advsearch?reord=D&lr=&repeat_search=Y&agency_group_id=&vac_group_id=&agency_id=&vr=&agency_group_id=&agency_id=&vr=&engine=db");
		sortBy.click();
		
		//Shows Summary Radio button fuctionality
		WebElement Showsumarry=driver.findElement(By.id("show_descY"));
		boolean Showssummarryradiobtn=Showsumarry.isDisplayed();
		Assert.assertTrue(Showssummarryradiobtn, "Radio button is not displayed");
		
		Showsumarry.click();
	
		WebElement summary=driver.findElement(By.xpath("//div[@class='clearfix']//p[contains(.,'SE1 Southwark')]"));
		if(Showsumarry.equals(summary))
		{
			System.out.println("Summary is displayed");
		}
		else {
			System.out.println("summary is not displayed");
		}
	}
		// to check the hide summary button
		
		/*WebElement hidesum=driver.findElement(By.xpath("//input[@id='show_descN']"));
		boolean hidesummary=hidesum.isDisplayed();
		System.out.println("Hide summary radio button is displayed");
		hidesum.click();
		if(hidesum.isSelected())
		{
			System.out.println("Summarry shouldn't displayed");
		}
		else {
			System.out.println("summary should display");
		}
	}*/
		
		@Test
		public void searchByKeyword()
		{
			
			driver.get("http://www.bcsrecruit.com");
			System.out.println("**************Search BY Keyword************");
			
		String title=driver.getTitle();
			if(title.contains("BCSrecruit.com"))
			{
				System.out.println("Home PAge Title is displayed");
			}
			else {
				System.out.println("Home Page Title is not displayed");
			}
			WebElement keyword=driver.findElement(By.xpath("//input[@id='fp_skill_include']"));
			if(keyword.isDisplayed())
			{
				System.out.println("Keyword Text box is displayed");
			}
			
			else {
				System.out.println("Key Word text bos is not displayed");
			}
			WebElement search=driver.findElement(By.xpath("//input[@value='Search']"));
			Assert.assertTrue(search.isDisplayed());
			System.out.println("Search button is displayed");
			keyword.clear();
			keyword.sendKeys("Tester");
			search.click();
			
			String SearchResult="BCSrecruit Search Results";
			String SearchResults =driver.getTitle();
			Assert.assertEquals(SearchResults, SearchResult, "Search Page is not displayed");
			
			WebElement Searchkeyword=driver.findElement(By.xpath("//div[@id='results']/p/em"));
			
			String text=Searchkeyword.getText().trim();
			
		if(Searchkeyword.equals(text))
		{
			System.out.println("Entered Key word is match");
		}
		else {
			System.out.println("Entered Key word is not match");
		}
			WebElement KeyCount=driver.findElement(By.tagName("h1"));
			String KeyCounting=KeyCount.getText().trim();
			if(KeyCount.equals(KeyCounting))
			{
				System.out.println("Count is match");
			}  
			else
			{
				System.out.println("Count is not Match");
			}
			
			WebElement SortBy=driver.findElement(By.id("resultsSort"));
			boolean flag=SortBy.isDisplayed();
			Assert.assertTrue(flag, "SortBy is not present");
			
			WebElement SortBy1=driver.findElement(By.xpath("//select[@id='resultsSort']/option[2]"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean flag1=SortBy1.isDisplayed();
			System.out.println(flag1);
			
			WebElement SortBy2=driver.findElement(By.xpath("//select[@id='resultsSort']/option[3]"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			boolean flag2=SortBy2.isDisplayed();
			System.out.println(flag2);
			
			WebElement Sum=driver.findElement(By.xpath("//form[@id='displayPref']//label[@for='show_descN']"));
			boolean flag3=Sum.isDisplayed();
			Assert.assertTrue(flag3, "Hide Summary is not displayed");
			
			WebElement Radbtn=driver.findElement(By.id("show_descN"));
			Radbtn.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			WebElement logo=driver.findElement(By.xpath("//div [@class='logo']"));
			logo.click();
			System.out.println("BCS Home Page is displayed");
		}
		
	}

	
	
	
	

