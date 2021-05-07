package practice.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertiesFileTest {

	@Test
	public void readDataTest()throws IOException
	{
		//read the data from properties file
		//step1:get the java representaion object of the physical file
		FileInputStream fis=new FileInputStream("./Data/commonData.properties");
		
		//step2:create an object of the properties class and load all key values pair
		Properties poj=new Properties();
		poj.load(fis);
		
		//step3: Read the value using getProperty("Key")
		String URL=poj.getProperty("url");
		String BROWSER=poj.getProperty("browser");
		String USERNAME=poj.getProperty("username");
		String TIMEOUTS=poj.getProperty("timeout");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(TIMEOUTS);
		
	}


}
