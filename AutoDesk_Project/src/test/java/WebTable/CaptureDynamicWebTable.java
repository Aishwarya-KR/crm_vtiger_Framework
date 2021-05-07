package WebTable;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class CaptureDynamicWebTable {
	
	static
	{
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
	}
	
	@Test
	public void captureOrgName() throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//step1:get the url
		driver.get("http://localhost:8888/");
		
		//step 2:login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(3000);
		
		//step 3:navigate to oraganizations
		driver.findElement(By.linkText("Organizations")).click();
		
		
		
		//step 4:capture all organization names
		String x="//table[@class='lvt small']/tbody/tr[*]/td[3]/a";
        List<WebElement> list=driver.findElements(By.xpath(x));
		
        //scenario 1:to display organization names
        Thread.sleep(3000);
        for(WebElement wb:list)
        {
        	System.out.println(wb.getText());
        }
        Thread.sleep(3000);

        //scenario 2:to click on all checkboxes
      String z="//table[@class='lvt small']/tbody/tr[*]/td[1]/input";
      List<WebElement> list1=driver.findElements(By.xpath(z));
       for(int i=1;i<list1.size();i++)
       {
    	   list1.get(i).click();
       }
       Thread.sleep(3000);
       
       //scenario 3:to click on last checkbox
       String y="(//input[@name='selected_id'])[last()]";
       driver.findElement(By.xpath(y)).click();
       Thread.sleep(3000);
       
       //scenario 4:fetch the data from webtable and compare it with expected data
       String edata="Cisco";
       String a="//table[@class='lvt small']/tbody/tr[*]/td[3]";
       List<WebElement> l2=driver.findElements(By.xpath(a));
       for(WebElement l:l2)
       {
    	   String acctdata=l.getText();
    	   if(edata.equals(acctdata))
    	   {
    		   System.out.println("Data is matching");
    		   l.click();
    		   break;
    	   }
       }
       
         
        
        driver.close();
	}
	
	
	

}
