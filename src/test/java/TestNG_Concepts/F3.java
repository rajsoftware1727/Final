package TestNG_Concepts;

import org.testng.annotations.Factory;

public class F3 {
	
	@Factory
	public static Object[] test5()
	{
		Object test[]=new Object[2];
		test[0]=new F1();
		test[1]=new F2();
		return test;
		
	}

}
