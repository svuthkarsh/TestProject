package com.training.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class facebook {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://www.facebook.com/");
		selenium.start();
	}

	@Test
	public void testFacebook() throws Exception {
		selenium.open("/?_rdr");
		selenium.type("id=email", "svuthkarsh@gmail.com");
		selenium.type("id=pass", "udisandiudisandi");
		selenium.click("id=u_0_n");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=span._2dpb");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
