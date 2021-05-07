package com.concast.crm.OrganizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups="smokeTest")
	public void creteOrg() throws Throwable
	{
		wutil.waitUntilPageLoad(driver);
		String orgname=eutil.getExcelData("org", 1, 2);
		//click on organization
		driver.findElement(By.linkText("Organizations")).click();
		//create org
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys(orgname+JavaUtility.getRandomData());
		//click on save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verification
		wutil.waitForElementVisibility(driver,driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 Assert.assertTrue(expData.contains(orgname));
		 System.out.println(expData);
		
	}
	
	@Test(groups="regressionTest")
	public void createOrgWithIndustry() throws Throwable
	{
		
		wutil.waitUntilPageLoad(driver);
		String orgname=eutil.getExcelData("org",4 , 2);
		String industryname=eutil.getExcelData("org", 4, 3);
		//navigate to oraganization
		driver.findElement(By.linkText("Organizations")).click();
		
		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname+JavaUtility.getRandomData());
		WebElement industry=driver.findElement(By.name("industry"));
		wutil.SelectOption(industry,industryname);
        //click on save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//verification
		wutil.waitForElementVisibility(driver,driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(expData.contains(orgname));
		System.out.println(expData);
		
	}

}
