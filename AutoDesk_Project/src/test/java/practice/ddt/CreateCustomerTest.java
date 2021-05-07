package practice.ddt;

import org.testng.annotations.Test;


public class CreateCustomerTest {

	@Test
	public void TestA()
	{
		System.out.println("Test2 EXECUTION");
		String Browser=System.getProperty("browser");
		System.out.println(Browser);
	}
}
