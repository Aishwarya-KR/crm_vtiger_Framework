package sampleTest;

import org.testng.annotations.Test;

public class simple1Test {

	@Test(retryAnalyzer=com.crm.vtiger.GenericUtils.RetryAnalyzer.class)
	public void createorg()
	{
		System.out.println(10/0);
	}

}
