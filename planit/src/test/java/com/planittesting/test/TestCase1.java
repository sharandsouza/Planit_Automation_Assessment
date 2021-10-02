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

public class TestCase1 extends Base {


	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test (dataProvider="ValidData")
	public void Test1(String Forename, String Email, String Message) throws InterruptedException {
		
		// From HomePage go to Contact page
		HomePage hp = new HomePage(driver);
		hp.ContactLink().click();
		Thread.sleep(5000);

		// Click Submit Button
		ContactPage cp = new ContactPage(driver);
		cp.SubmitButton().click();
		Thread.sleep(5000);

		// Validate the Error messages
		String actualPageError = cp.IncompleteFormError().getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualPageError
				.contains("We welcome your feedback - but we won't get it unless you complete the form correctly."));

		// Get Value of Font weight and assert if it is bold
		String fontWeight = cp.IncompleteFormErrorBold().getCssValue("font-weight");
		softAssert.assertTrue(Integer.parseInt(fontWeight) >= 700);

		String actualForenameError = cp.ForenameError().getAttribute("innerHTML");
		String expectedForenameError = "Forename is required";
		softAssert.assertEquals(actualForenameError, expectedForenameError, "Incorrect Forename Error");

		String actualEmailError = cp.EmailError().getAttribute("innerHTML");
		String expectedEmailError = "Email is required";
		softAssert.assertEquals(actualEmailError, expectedEmailError, "Incorrect Email Error message");

		String actualMessageError = cp.MessageError().getAttribute("innerHTML");
		String expectedMessageError = "Message is required";
		softAssert.assertEquals(actualMessageError, expectedMessageError, "Incorrect Message Error message");

		softAssert.assertAll();

		// Populate mandatory fields
		cp.Forename().sendKeys(Forename);
		cp.Email().sendKeys(Email);
		cp.Message().sendKeys(Message);

		// Validate errors are gone. We can use softAssert as well.
		List<WebElement> forenameError = cp.NoForenameError();
		Assert.assertEquals(forenameError.size(), 0);

		List<WebElement> EmailError = cp.NoEmailError();
		Assert.assertEquals(EmailError.size(), 0);

		List<WebElement> MessageError = cp.NoMessageError();
		Assert.assertEquals(MessageError.size(), 0);

	}

	@DataProvider(name="ValidData")
	public String[][] getData()throws IOException
	{
	
	String path =".\\datafiles\\TestData.xlsx";
	ExcelUtils excelUtil= new ExcelUtils(path);
	
	int totalRows=excelUtil.getRowCount("TestCase1");
	int totalColumns=excelUtil.getCellCount("TestCase1", 1);
			
	String ValidData[][]= new String[totalRows][totalColumns];
	
	for(int i=1;i<=totalRows;i++)
	{
		for(int j=0;j<totalColumns;j++)
		{
			ValidData[i-1][j]=excelUtil.getCellData("TestCase1", i, j);
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
