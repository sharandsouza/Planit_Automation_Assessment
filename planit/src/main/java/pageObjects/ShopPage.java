package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {

	public WebDriver driver;

	private By ItemFunnyCow = By.xpath("//h4[contains(text(),'Funny Cow')]/parent::div[1]/p[1]/a[1]");
	private By ItemFluffyBunny = By.xpath("//h4[contains(text(),'Fluffy Bunny')]/parent::div[1]/p[1]/a[1]");
	private By Cart = By.xpath("//a[@href='#/cart']");


	
	public ShopPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement BuyFunnyCow() 
	{
		return driver.findElement(ItemFunnyCow);

	}
	public WebElement BuyFluffyBunny() 
	{
		return driver.findElement(ItemFluffyBunny);

	}
	public WebElement CartMenu() 
	{
		return driver.findElement(Cart);

	}
	
	}