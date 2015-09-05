package com.training.webdrivertestbcs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SnapDealTest {

	WebDriver driver;
	String baseurl = "http://www.snapdeal.com/";
	String title = null;
	int step = 0;
@BeforeTest

public void setUp() throws Exception {
	
	driver = new FirefoxDriver();
	driver.get(baseurl);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}
@Test
public void test1() throws Exception {
	step = 0;
	title = driver.getTitle().trim();
	String ExpHomePageTitle = "Snapdeal: India's Largest Online Shopping Site";
	System.out.println(step++ + "Verifying Home page");
	Assert.assertEquals(title, ExpHomePageTitle,"Home page is not displayed as expected");
	WebElement myAccount = driver.findElement(By.xpath("//a[label[contains(.,'My Account')]]"));
	System.out.println(step++ + "Verifying My account link");
	if (myAccount.getText().contains("My Account")) {
		Assert.assertEquals(myAccount.getText(), "My Account","My account is not displayed");
	}
	System.out.println(step++ + "Verifying my account menu link");
	WebElement myAccountMenu = driver.findElement(By.xpath("//i[contains(@class,'right-downArrow breadcrumbArrow-down')]"));
	if (myAccount.isDisplayed()) {
		boolean isMyAccountMenuDisplayed = myAccountMenu.isDisplayed();
		Assert.assertTrue(isMyAccountMenuDisplayed, "My account menu is not displayed on the home page");
	}
	
	System.out.println(step++ + "Verifying Sign in link");
	WebElement signIn = driver.findElement(By.xpath("//a[@class='signIn']/i[2]"));
	if (myAccountMenu.isDisplayed()) {
		boolean isSignInLinkDisplayed = myAccountMenu.isDisplayed();
		Assert.assertTrue(isSignInLinkDisplayed, "Sign in link is not displayed on the home page");
		System.out.println(step++ + "Clicking on signin link");
		signIn.click();
		Thread.sleep(3000);
	}
	
	driver.switchTo().frame("loginIframe");
	WebElement signUpPop = driver.findElement(By.xpath("//div[@id='signin_box']//div[@class='signupopupbox sdModal']"));
	System.out.println(step++ + "Verifying Sign up pop box");
	boolean isSignUpPOPDisplayed = signUpPop.isDisplayed();
	Assert.assertTrue(isSignUpPOPDisplayed, "Pop up box is not displayed");
	
	WebElement register = driver.findElement(By.id("log"));
	WebElement login = driver.findElement(By.id("sig"));
	
	boolean isRegisterDisplayed = register.isDisplayed();
	Assert.assertTrue(isRegisterDisplayed, "Register button is not displayed");
	boolean isLoginDisplayed = login.isDisplayed();
	Assert.assertTrue(isLoginDisplayed, "Login button is not displayed");
}

@AfterTest
public void quitBrowser() throws Exception {
	
	driver.quit();
}

}
