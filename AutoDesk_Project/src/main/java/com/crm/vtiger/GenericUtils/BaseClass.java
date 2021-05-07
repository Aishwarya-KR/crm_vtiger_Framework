package com.crm.vtiger.GenericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.vtiger.contactpomclass.HomePage;
import com.crm.vtiger.contactpomclass.LoginPage;

public class BaseClass {

	static
	{
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
	}
	public WebDriver driver;
	public ExcelUtility eutil=new ExcelUtility();
	public FileUtility futil=new FileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public static WebDriver sdriver;
	
	
	@BeforeSuite(groups={"smokeTest" , "regressionTest"})
	public void configBS()
	{
		//connect to DB
	}
	
	@BeforeTest(groups={"smokeTest" , "regressionTest"})
	public void configBT()
	{
		//launch browser in parallel mode
	}
	
	//@Parameters("browser")
	@BeforeClass(groups={"smokeTest" , "regressionTest"})
	public void configBC() throws Throwable
	{
		String browserName=futil.getDataFromJson("browser");
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
		
			driver=new ChromeDriver();
		}
	    else if(browserName.equalsIgnoreCase("IE"))
	    {
		
		driver=new InternetExplorerDriver();
		}
		sdriver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod(groups={"smokeTest" , "regressionTest"})
	public void setUp() throws Throwable
	{
		String url=futil.getDataFromJson("url");
		String username=futil.getDataFromJson("username");
		String password=futil.getDataFromJson("password");
		driver.get(url);
		//login to the application
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();*/
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(username, password);
	}
	
	@AfterMethod(groups={"smokeTest" , "regressionTest"})
	public void tearDown()
	{
		/*WebElement administrator=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebElement signout=driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
		Actions action=new Actions(driver);
		action.moveToElement(administrator).click(signout).build().perform();*/
		HomePage homePage=new HomePage(driver);
		homePage.signOut();
		
	}
	
	@AfterClass(groups={"smokeTest" , "regressionTest"})
	public void configAC()
	{
		driver.close();
	}
	
	@AfterTest(groups={"smokeTest" , "regressionTest"})
	public void configAT()
	{
		//close the ref in parallel mode
	}
	
	@AfterSuite(groups={"smokeTest" , "regressionTest"})
	public void configAs()
	{
		//close
	}	

}
