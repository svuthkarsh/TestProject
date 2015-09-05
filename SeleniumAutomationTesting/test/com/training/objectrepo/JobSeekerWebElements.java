package com.training.objectrepo;

public class JobSeekerWebElements {
	
	//Verify HomePage Display
	public static final String pageHomePage = "//body[@id='homepage']";
	
	//Verify The URL
	public static final String urlHomePage = "//meta[@content='http://www.bcsrecruit.com/']";
	public static final String urlBcsHomePage = "http://www.bcsrecruit.com";
	
	//Verify Site Logo
	public static final String imgSiteLogo = "//img[@src='images/home/logo.gif']";
	
	//Verify Jobseeker Link
	public static final String lnkJobSeekerLogin = "//a[@href='https://www.bcsrecruit.com/cgi-bin/login_applicant.cgi']";
	
	//Verify JobSeekerLogin Page
	public static final String pageJobSeekerLoginPage ="//h1[contains(text(),'Jobseeker Login')]";
	
	//Verify EmailField
	public static final String txtEmailAddress ="email";
	
	//Verify PaswordField
	public static final String txtPassword ="password";
	
	//Verify ForgottenPasswordLink
	public static final String lnkForgottenPassword ="//a[contains(text(),'Forgotten your password?')]";
	
	//Verify LoginButton
	public static final String btnJobSeekerLogin ="//input[@value='Log in']";
}
