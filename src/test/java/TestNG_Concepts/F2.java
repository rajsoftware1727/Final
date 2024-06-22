package TestNG_Concepts;

import org.testng.annotations.Test;

public class F2 {
	
	@Test
	public static void test3()
	{
		System.out.println("thread name is "+Thread.currentThread().getId());

		System.out.println("test3");
	}
	
	@Test
	public static void test4()
	{
		System.out.println("thread name is "+Thread.currentThread().getId());

		System.out.println("test4");

	}

}
