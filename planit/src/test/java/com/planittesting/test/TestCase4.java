package com.planittesting.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CartPage;
import pageObjects.ContactPage;
import pageObjects.HomePage;
import pageObjects.ShopPage;
import resources.Base;

public class TestCase4 extends Base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void Test4() throws InterruptedException {

		// From HomePage go to Contact page
		HomePage hp = new HomePage(driver);
		hp.ShopLink().click();
		Thread.sleep(5000);

		// Click buy button 2 times on “Funny Cow”
		ShopPage sp = new ShopPage(driver);
		sp.BuyFunnyCow().click();
		sp.BuyFunnyCow().click();

		// Click buy button 1 time on “Fluffy Bunny”
		sp.BuyFluffyBunny().click();

		// Click the cart menu
		sp.CartMenu().click();

		// Verify the items are in the cart
		CartPage cp = new CartPage(driver);
		List<WebElement> cartItems = cp.CartItems();
		Assert.assertEquals(cartItems.size(), 2);

		String ActualCartItem1 = cp.CartFunnyCow().getText();
		Assert.assertEquals(ActualCartItem1, "Funny Cow");

		String ActualCartItem2 = cp.CartFluffyBunny().getText();
		Assert.assertEquals(ActualCartItem2, "Fluffy Bunny");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
