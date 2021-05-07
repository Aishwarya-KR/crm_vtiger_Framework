package com.crm.vtigerTests;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;

public class CreateContactWithOrganizationTest  extends BaseClass{
	
	@Test
	public void createContact() throws Throwable
	{
		
		        wutil.waitUntilPageLoad(driver);
				
				String contact=eutil.getExcelData("Sheet1", 3, 3);
				//String orgname=eutil.getExcelData("Sheet1", 3, 4);
				
				//navigate to contact
				driver.findElement(By.linkText("Contacts")).click();
				
				
				//create contact
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys(contact);
				driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
				
				//navigate to another window
				Set<String> allwin=driver.getWindowHandles();
				ArrayList<String> al=new ArrayList<String>(allwin);
				driver.switchTo().window(al.get(1));
				driver.findElement(By.xpath("//a[contains(text(),'HP')]")).click();
				driver.switchTo().window(al.get(0));
			
                //to save the contact
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

							
	}

}
