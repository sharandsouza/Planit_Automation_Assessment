package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	public WebDriver driver;

	private By CartItems = By.cssSelector(".cart-item.ng-scope");
	private By CartFunnyCow = By.xpath("//tr[@class='cart-item ng-scope']/parent::tbody/tr[1]/td[1]");
	private By CartFluffyBunny = By.xpath("//tr[@class='cart-item ng-scope']/parent::tbody/tr[2]/td[1]");


	
	public CartPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	public List<WebElement> CartItems() 
	{
		return driver.findElements(CartItems);

	}
	public WebElement CartFunnyCow() 
	{
		return driver.findElement(CartFunnyCow);

	}
	public WebElement CartFluffyBunny() 
	{
		return driver.findElement(CartFluffyBunny);

	}
	
	
	}