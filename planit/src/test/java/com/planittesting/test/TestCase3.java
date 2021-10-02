package com.planittesting.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ContactPage;
import pageObjects.HomePage;
import resources.Base;

public class TestCase3 extends Base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void Test3() throws InterruptedException {

		// From HomePage go to Contact page
		HomePage hp = new HomePage(driver);
		hp.ContactLink().click();
		Thread.sleep(5000);

		// Populate mandatory fields with invalid data
		ContactPage cp = new ContactPage(driver);
		cp.Forename().sendKeys(";;");
		cp.Email().sendKeys(";;");
		cp.Message().sendKeys(".");
		Thread.sleep(5000);
		
		//Validate errors
		String actualEmailError = cp.EmailError().getAttribute("innerHTML");
		String expectedEmailError = "Please enter a valid email";
		Assert.assertEquals(actualEmailError, expectedEmailError, "Incorrect Email Error");

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
