package practice.ddt;

import org.testng.annotations.Test;

public class ReadDataCmdTest {

	@Test
	public void readCommand()
	{
		System.out.println("Command Line execution");
		String PASSWORD=System.getProperty("password");
		System.out.println(PASSWORD);
	}

}
