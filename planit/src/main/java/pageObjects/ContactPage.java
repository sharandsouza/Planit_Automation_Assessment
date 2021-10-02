package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
	
	public WebDriver driver;
	
	private By Submit=By.cssSelector(".btn-contact.btn.btn-primary");
	private By PageAlertBold=By.xpath("//strong[contains(text(),'We welcome your feedback')]");
	private By PageAlert=By.xpath("//div[@class='alert alert-error ng-scope']");
	private By ForenameError=By.id("forename-err");
	private By Forename=By.xpath("//input[@id='forename']");
	private By Surname=By.xpath("//input[@id='surname']");
	private By EmailError=By.xpath("//span[@id='email-err']");
	private By Email=By.xpath("//input[@id='email']");
	private By Telephone=By.xpath("//input[@id='telephone']");
	private By MessageError=By.xpath("//span[@id='message-err']");
	private By Message=By.xpath("//textarea[@id='message']");
	private By SubmissionMessage=By.xpath("//div[@class='alert alert-success']");
	
	public ContactPage(WebDriver driver) 
	{
		this.driver=driver; //Constructor
	}
	
	public WebElement SubmitButton()
	{
		return driver.findElement(Submit);
	}
	public WebElement ForenameError()
	{
		return driver.findElement(ForenameError);
	}
	public WebElement Forename()
	{
		return driver.findElement(Forename);
	}
	public WebElement Surname()
	{
		return driver.findElement(Surname);
	}
	public WebElement EmailError()
	{
		return driver.findElement(EmailError);
	}
	public WebElement Email()
	{
		return driver.findElement(Email);
	}
	public WebElement Telephone()
	{
		return driver.findElement(Telephone);
	}
	public WebElement IncompleteFormErrorBold()
	{
		return driver.findElement(PageAlertBold);
	}
	public WebElement IncompleteFormError()
	{
		return driver.findElement(PageAlert);
	}
	public WebElement MessageError()
	{
		return driver.findElement(MessageError);
	}
	public WebElement Message()
	{
		return driver.findElement(Message);
	}
	public List<WebElement> NoForenameError()
	{
		return driver.findElements(ForenameError);
	}
	public List<WebElement> NoEmailError()
	{
		return driver.findElements(EmailError);
	}
	public List<WebElement> NoMessageError()
	{
		return driver.findElements(MessageError);
	}
	public WebElement SubmissionMessage()
	{
		return driver.findElement(SubmissionMessage);
	}
	
	
	

}