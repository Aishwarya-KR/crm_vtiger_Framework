package WebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class DeleteRecord {

	static
	{
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
	}
	@Test
	public void deleteRecord() throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//step1:get the url
		driver.get("http://localhost:8888/");
		
		//step 2:login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step 3:navigate to oraganizations
		driver.findElement(By.linkText("Organizations")).click();
		String expData="Cisco";
		int actRowCount=0;
		
		//step 4:capture all organization names
		String x="//table[@class='lvt small']/tbody/tr[*]/td[3]/a";
        List<WebElement> list=driver.findElements(By.xpath(x));
        for(WebElement wb:list)
        {
        	String actData=wb.getText();
        	if(expData.equals(actData))
        	{
        		//wb.click();
        		break;
        	}
        	actRowCount++;
        }
        System.out.println(actRowCount);
        
        String path="//table[@class='lvt small']/tbody/tr["+actRowCount+"]/td[8]/a[text()='del']";
        driver.findElement(By.xpath(path)).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        

		
		
		driver.close();
		
	}

}
