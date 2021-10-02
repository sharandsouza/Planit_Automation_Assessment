package com.planittesting.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ContactPage;
import pageObjects.HomePage;
import resources.Base;
import resources.ExcelUtils;

public class TestCase2 extends Base {


	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test (dataProvider="ValidData")
	public void Test2(String Forename, String Email, String Message) throws InterruptedException {
		
		// From HomePage go to Contact page
		HomePage hp = new HomePage(driver);
		hp.ContactLink().click();
		Thread.sleep(5000);

		// Populate mandatory fields
		ContactPage cp = new ContactPage(driver);
		cp.Forename().sendKeys(Forename);
		cp.Email().sendKeys(Email);
		cp.Message().sendKeys(Message);

		// Click Submit Button
		Thread.sleep(5000);
		cp.SubmitButton().click();
		Thread.sleep(5000);
		
		//Validate successful submission message
		String actualSubmitMessage=cp.SubmissionMessage().getAttribute("innerHTML");
		Assert.assertTrue(actualSubmitMessage.contains("we appreciate your feedback."), "Incorrect Submission Message");

	}
	
	@DataProvider(name="ValidData")
	public String[][] getData()throws IOException
	{
	
	String path =".\\datafiles\\TestData.xlsx";
	ExcelUtils excelUtil= new ExcelUtils(path);
	
	int totalRows=excelUtil.getRowCount("TestCase2");
	int totalColumns=excelUtil.getCellCount("TestCase2", 1);
			
	String ValidData[][]= new String[totalRows][totalColumns];
	
	for(int i=1;i<=totalRows;i++)
	{
		for(int j=0;j<totalColumns;j++)
		{
			ValidData[i-1][j]=excelUtil.getCellData("TestCase2", i, j);
		}
	}
	
	return ValidData;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
