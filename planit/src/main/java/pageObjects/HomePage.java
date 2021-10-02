package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	private By Contact = By.cssSelector("a[href='#/contact']");
	private By Shop = By.linkText("Shop");
	
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement ContactLink() 
	{
		return driver.findElement(Contact);
	}
	public WebElement ShopLink() 
	{
		return driver.findElement(Shop);
	}
	
	}