package practice.ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadFromPropertiesTest {

	@Test
	public void readData() throws IOException
	{
		FileInputStream fis=new FileInputStream("./Data/CommonData1.properties");
		
		Properties pro=new Properties();
		pro.load(fis);
		
		String Password=pro.getProperty("password");
		System.out.println(Password);
		
	}
}
