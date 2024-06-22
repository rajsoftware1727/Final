package TestNG_Concepts;

import org.testng.annotations.Test;

public class dependencyonXML {
	
	@Test(groups="openbrowser")
	public static void openBrowser()
	{
		System.out.println("open browser");
	}
	
	@Test(groups="login")
	public static void login()
	{
		System.out.println("login");
	}
	
	@Test(groups="viewacc")
	public static void viewacc()
	{
		System.out.println("viewacc");
	}
	
	@Test(groups="logout")
	public static void logout()
	{
		System.out.println("logout");
	}

}
