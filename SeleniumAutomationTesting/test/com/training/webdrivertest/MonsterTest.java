package com.training.webdrivertest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MonsterTest {
	WebDriver uidriver;
		String URL="http://www.monsterindia.com/";
		String Title="Jobs in India, Career Jobs, Fresher Jobs & Vacancies – Monster India";
		
		
		@BeforeClass
		public void setUp(){
			uidriver=new FirefoxDriver();
			uidriver.get(URL);
			uidriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			uidriver.manage().window().maximize();
		}
		@Test
		public void HomePageTest(){
			String Actual=uidriver.getTitle().trim();
			Assert.assertEquals(Actual, Title, "Home Page Title is not displayed");
			System.out.println(Actual);
}
		@Test
		public void FooterLinks(){
			List<WebElement> Footers=uidriver.findElements(By.xpath("//div[12]/div[3]/div/div/div[2]"));
			List<String> Links=new ArrayList<String>();
			for (WebElement Linksname : Footers) {
				String text= Linksname.getText();
				System.out.println(text);
			}
			
		}
}



