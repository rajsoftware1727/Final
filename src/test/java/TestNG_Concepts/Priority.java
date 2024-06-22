package TestNG_Concepts;

import org.testng.annotations.Test;

public class Priority {
	
	@Test(priority=-2)
	public static void test1()
	{
		System.out.println("test1");
	}
	

	@Test(priority=-4,invocationCount=2)
	public static void test2()
	{
		System.out.println("test2");
	}
	

	@Test(priority=0)
	public static void test3()
	{
		System.out.println("test3");
	}

}
