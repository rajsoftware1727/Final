package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UTILITIES.ReadDataFromPropertyFile;
import UTILITIES.WebElementOPtions;

public class LoginPage {
	
	//define all the webelements
	WebDriver driver;
	
	@FindBy(name="uid")
	private WebElement uname;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="btnLogin")
	private WebElement signinButton;
	
	@FindBy(xpath="//marquee[@class='heading3']")
	private WebElement pageWelcomemessage;
	
	//constructor initalize the webelements in pom design
	public LoginPage(WebDriver driver1)
	{
		driver=driver1;
		PageFactory.initElements(driver1,this);
	}
	
	public void enterUserName(String username)
	{
		WebElementOPtions.highlightElements(uname);
		uname.sendKeys(username);;
	}
	
	public void enterPassword(String pwd)
	{
		WebElementOPtions.highlightElements(password);

		password.sendKeys(pwd);;
	}
	
	public void clicksignIn()
	{
		WebElementOPtions.highlightElements(signinButton);

		  signinButton.click();;
	}
	
	public WebElement getWelcomePageMsg()
	{
		return pageWelcomemessage;
	}
	
	
	public String pageTitle() throws IOException
	{
		return (String)ReadDataFromPropertyFile.readDataFromProperty("pageTitle");
	}
	
	public String pageMessage() throws IOException
	{
		return (String)ReadDataFromPropertyFile.readDataFromProperty("pageMessage");
	}
	
	public  String validUname() throws IOException
	{
		return (String)ReadDataFromPropertyFile.readDataFromProperty("userName");
	}
	public   String validPwd() throws IOException
	{
		return (String)ReadDataFromPropertyFile.readDataFromProperty("password");

	}
	 
	 	

}
