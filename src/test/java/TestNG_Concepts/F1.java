package TestNG_Concepts;

import org.testng.annotations.Test;

public class F1 {
	
	@Test
	public static void test1()
	{
		System.out.println("thread name is "+Thread.currentThread().getId());
		System.out.println("test1");
		
	}
	
	@Test
	public static void test2()
	{
		System.out.println("thread name is "+Thread.currentThread().getId());

		System.out.println("test2");

	}

}
