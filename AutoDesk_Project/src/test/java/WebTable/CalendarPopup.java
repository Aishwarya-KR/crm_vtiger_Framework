package WebTable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CalendarPopup {

	static
	{
		System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
	}
	
	public static void main(String[] args)throws InterruptedException
	{
		
		Date dateobj=new Date();
		System.out.println(dateobj.toString());
		
		String currsystdate=dateobj.toString();
		//Sun May 02 18:42:56 IST 2021
		//0   1    2  3        4    5
		String[] arr=currsystdate.split(" ");
		
		String day=arr[0];
		String month=arr[1];
		String date=arr[2];
		String year=arr[5];
		
		System.out.println(day+" "+month+" "+date+" "+year);
		String curdate=day+" "+month+" "+date+" "+year;
		
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//to get the URL
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		//handle login popup
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		
		//click on from and to textbox
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("HYD");
		driver.findElement(By.xpath("//div[contains(text(),'HYD')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("PNQ");
		driver.findElement(By.xpath("//div[contains(text(),'PNQ')]")).click();
		Thread.sleep(2000);

		//click on departure
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		//driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']")).click();
		//driver.findElement(By.xpath("//div[@aria-label='"+curdate+"']")).click();
          
		int count=0;
		while(count<11)
		{
			try
			{
				driver.findElement(By.xpath("//div[@aria-label='Sun Aug 15 2021']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
                count++;
			}
		}
		Thread.sleep(2000);
		//close the driver
		driver.close();
		
		
	}
	
	
	

}
