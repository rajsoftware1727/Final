package UTILITIES;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	/*
	 * browser intilization and browser closing done by this class
	 */
	static WebDriver driver;
	  static Logger logger;
	 static  String browserName;
	
    
	@BeforeTest
 	public static void openBrowser() throws IOException
	{
 		    browserName=(String)ReadDataFromPropertyFile.readDataFromProperty("browserName");
     	
       if(browserName.equalsIgnoreCase("chrome"))
       {
    	   WebDriverManager.chromedriver().setup();
    	   driver=new ChromeDriver();
       }
       else if(browserName.equalsIgnoreCase("edge"))
       {
    	   WebDriverManager.edgedriver().setup();
    	   driver=new EdgeDriver();
       }
       if(browserName.equalsIgnoreCase("firefox"))
       {
    	   WebDriverManager.firefoxdriver().setup();
    	   driver=new FirefoxDriver();
       }
       
         //logger=Logger.getLogger("TESTNG PROJECT");
       //PropertyConfigurator.configure(System.getProperty("src/test/resources/PropertyFile/Log4j.properties"));       
       
       driver.manage().window().maximize();
       driver.get((String)ReadDataFromPropertyFile.readDataFromProperty("siteURL"));
       //logger.info("browser opened");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
	}
	
	@AfterClass
	public static void tearDown()
	{
		driver.close();
		//logger.info("browser closed");
	}
	
	public static  WebDriver getDriver()
	{
		return driver;
	}
	
	 

	 
}
