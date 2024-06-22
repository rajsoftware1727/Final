package TestNG_Concepts;

import org.testng.annotations.Test;

public class Groups {
	
	
	@Test(groups="jj")
	public static void a()
	{
		System.out.println("a");
	}
	@Test(dependsOnGroups="rr")
	public static void b()
	{
		System.out.println("b");

	}
	
	@Test(groups="jj")
	public static void c()
	{
		System.out.println("c");

	}
	
	@Test(groups="rr")
	public static void d()
	{
		System.out.println("d");

	}


}
