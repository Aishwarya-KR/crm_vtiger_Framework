package sampleTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
@Listeners(com.crm.vtiger.GenericUtils.ListIngClass.class)
public class SimpleTest extends BaseClass {
	@Test
	public void createOrg()
	{
		System.out.println("Execute create organizaton test");
		System.out.println(10/0);
	}

	

}
