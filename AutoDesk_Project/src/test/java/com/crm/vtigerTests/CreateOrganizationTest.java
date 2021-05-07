package com.crm.vtigerTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateOrganizationTest extends BaseClass{

	@Test
	public void creteOrg() throws Throwable
	{
		wutil.waitUntilPageLoad(driver);
		String orgname=futil.getDataFromJson("organization");
		
		//click on organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//create org
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
	    driver.findElement(By.name("accountname")).sendKeys(orgname+JavaUtility.getRandomData());
		
		//click on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verification
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 Assert.assertTrue(expData.contains(orgname));
		 System.out.println(expData);
		
	}
}
