package com.training.webdrivertestbcs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.security.Credentials;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class snapDeal {

	WebDriver driver;
	
	@BeforeClass
	
	public void setUP()
	{
		/*driver=new FirefoxDriver();*/
		/*System.setProperty("webdriver.chrome.driver", "E://Automation//Workspace//SeleniumAutomationTesting//chromedriver.exe");*/
		System.setProperty("webdriver.ie.driver","E://Automation//Workspace//SeleniumAutomationTesting/IEDriverServer.exe");
		/*driver=new ChromeDriver();*/
		driver=new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	
	public void Homepage() throws InterruptedException
	{
		
		driver.get("http://www.snapdeal.com");
		System.out.println("Snap deal home page is displayed");
		System.out.println("Verifying My Account is displayed or not");
		WebElement Myacount=driver.findElement(By.xpath("//a[@class='signIn']/i[2]"));
		
		boolean Myaccounttab=Myacount.isDisplayed();
		Assert.assertTrue(Myaccounttab, "Myaccount label is not displayed");
		System.out.println("Verifying My Account menu");
		
		WebElement menu=driver.findElement(By.xpath("//a[@class='signIn']/i[2]"));
		boolean accountmenu=menu.isDisplayed();
		Assert.assertTrue(accountmenu, "Menu is not displayed");
		
		Myacount.click();
		Thread.sleep(3000);
		System.out.println("Myaccount Pop up is displayed");
		
		//Verifying Pop-Up conditions
		
		System.out.println("Verifying pop-up display");
		String loginframe="loginIframe";
		driver.switchTo().frame(loginframe);
		WebElement popup=driver.findElement(By.xpath("//div[@class='signupopupbox sdModal']"));
		driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
		boolean popupframe=popup.isDisplayed();
		Assert.assertTrue(popupframe, "popup frame is not displayed");
		
		//Verifying the Rgister and login 
		
		WebElement login=driver.findElement(By.xpath("//li//a[@id='sig']"));
		boolean isLoginDisaplyed = login.isDisplayed();
		Assert.assertTrue(isLoginDisaplyed, "Login button is not displayed");
		if (isLoginDisaplyed) {
			login.click();
			WebElement useemailAddress = driver.findElement(By.xpath("//button[@id='logInByEmailBtn']"));
			
			
			boolean isuseemailAddress=useemailAddress.isDisplayed();
			Assert.assertTrue(isuseemailAddress, "User Email Address is not displayed");
			
			if (isuseemailAddress) {
				
				useemailAddress.click();
				WebElement email=driver.findElement(By.xpath("//input[@id='j_username']"));
				boolean isemailDisplayed=email.isDisplayed();
				Assert.assertTrue(isemailDisplayed, "email address is not displayed");
				
				//getting the email text
				String text=email.getAttribute("placeholder");
				String Expected="eg. xyz@gmail.com";
				Assert.assertEquals(text, Expected, "Email id is not displayed");
				
				System.out.println(text);
				
				WebElement password=driver.findElement(By.xpath("//form[@id='ajaxSignin']//input[@id='j_password']"));
				boolean ispasswordDisplayed=password.isDisplayed();
				Assert.assertTrue(ispasswordDisplayed, "Password is not displayed");
				
				WebElement forgot=driver.findElement(By.xpath("//a[@class='forgottxt fnt13']"));
				boolean isforgotDisplayed=forgot.isDisplayed();
				Assert.assertTrue(isforgotDisplayed, "Forgot Password is not displayed");	 
			}
		} 
		
			
		//verifying Register page elements
		
		
		WebElement reg=driver.findElement(By.xpath("//li[@style='margin-left: -40px']/a"));
		boolean isregDisplayed=reg.isDisplayed();
		if(isregDisplayed)
		{
			reg.click();
			Assert.assertTrue(isregDisplayed, "Register is not present");
			
			WebElement mobile=driver.findElement(By.xpath("//input[@placeholder='Enter Mobile No.']"));
			boolean ismobileDisplayed=mobile.isDisplayed();
			Assert.assertTrue(ismobileDisplayed, "Mobile number field is not present");
			
			String mobiletext=mobile.getAttribute("placeholder");
			String expect="Enter Mobile No.";
			Assert.assertEquals(mobiletext, expect, "Mobile number text s not present");
			System.out.println(expect);
			
			WebElement continuebtn=driver.findElement(By.xpath("//button[@class='signinContinue buyBlueButton']"));
			boolean continueisdisplayed=continuebtn.isDisplayed();
			Assert.assertTrue(continueisdisplayed, "Continue Button is not displayed");
			
			mobile.sendKeys("8553552149");
			continuebtn.click();
			Thread.sleep(3000);
			
Alert alert=driver.switchTo().alert();
			
			String alert1=alert.getText();
			String ExpectedValue="Please enter a value for the Email Address field.";
			Assert.assertEquals(alert1, ExpectedValue, "Alert is not displayed");
			alert.accept();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	}
	
	
	
	
	
	
	
	
	
}

