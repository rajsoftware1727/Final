package TestNG_Concepts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

 
public class Parameter {
	
	@Parameters(value="gg")
	@Test
	public static void test1(String h)
	{
		System.out.println("test1"+h);
	}

}
