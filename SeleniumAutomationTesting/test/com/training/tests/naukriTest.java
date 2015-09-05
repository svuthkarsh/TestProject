package com.training.tests;

import net.sourceforge.htmlunit.corejs.javascript.ast.ThrowStatement;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.commands.GetTitle;
import com.training.objectrepo.naukriWebPageElements;

import junit.framework.Assert ;

public class naukriTest {

	private Selenium s;
	private String BASE_URL="https://www.naukri.com";
	private String BROWSER="firefox";
	private String title="null";
	private String HomePageTitle="Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com";
	boolean flag=true;
	public String skill="test engineer";
	private String loc="Bangalore";
	
	@Before
	
		public void setUp()throws Exception{
		s=new DefaultSelenium("localhost",4444, BROWSER, BASE_URL);
		s.start();
		s.waitForPageToLoad("30000");
		s.windowMaximize();
		s.windowFocus();
	}
	
	@Test
		public void naukriElementTest() throws InterruptedException{
		Thread.sleep(3000);
		s.open("/");
		s.waitForPageToLoad("30000");
		title=s.getTitle().trim();
		Assert.assertEquals("Home Page Title is not displayed", HomePageTitle, title);
		// Home Page
		//s.click(naukriWebPageElements.txtSkills);
		s.type(naukriWebPageElements.txtSkills,skill);
		//s.click(naukriWebPageElements.txtLocation);
		s.type(naukriWebPageElements.txtLocation,loc);
		s.click(naukriWebPageElements.txtExperience);
		s.click(naukriWebPageElements.dropExperience);
		s.click(naukriWebPageElements.txtSalary);
		s.click(naukriWebPageElements.dropsalary);
		s.click(naukriWebPageElements.btnSearch);
		s.waitForPageToLoad("30000");
		Thread.sleep(3000);
	
		
		
				
			
		
		
		
	}
	
	
}
