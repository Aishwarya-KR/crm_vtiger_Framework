package com.crm.vtigerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateOrganizationWithIndustry extends BaseClass {
	@Test
	public void createOrganization() throws Throwable
	{
		
		wutil.waitUntilPageLoad(driver);
		String orgname=futil.getDataFromJson("organization");
		//navigate to oraganization
		driver.findElement(By.linkText("Organizations")).click();
		
		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname+JavaUtility.getRandomData());
		WebElement industry=driver.findElement(By.name("industry"));
		wutil.SelectOption(industry,"Engineering");
        //click on save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//verification
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(expData.contains(orgname));
		System.out.println(expData);
		
	}


}
