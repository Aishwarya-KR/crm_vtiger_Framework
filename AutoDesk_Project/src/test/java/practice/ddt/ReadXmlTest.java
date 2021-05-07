package practice.ddt;

import org.testng.xml.XmlTest;

public class ReadXmlTest {

	@org.testng.annotations.Test
	public void Test(XmlTest xml)
	{
		System.out.println("Test1 execution");
		String BROWSER=xml.getParameter("browser");
		System.out.println(BROWSER);
	}

}
