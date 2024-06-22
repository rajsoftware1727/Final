package UTILITIES;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementOPtions {
	
 	
	public static void highlightElements(WebElement element)
	{
		String color=WebElementOPtions.color("Aqua");
	  JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
	  js.executeScript("arguments[0].style.border='3px solid "+color+"'",element);
		
	}
	public static String color(String co)
	{
		return co;
	}

	 

	 


	

}
