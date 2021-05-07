package com.cancast.crm.ContactTest;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateContactTest extends BaseClass {

	@Test(groups="smokeTest")
	public void createContact() throws Throwable
	{
        wutil.waitUntilPageLoad(driver);
        String contactname=eutil.getExcelData("contact", 1, 2);
		//navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		//click on new contact button
		//create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactname+JavaUtility.getRandomData());
		//click on save button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//verification
		wutil.waitForElementVisibility(driver, driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
		 String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 Assert.assertTrue(expData.contains(contactname));
		 System.out.println(expData);			
	}
	
	@Test(groups="regressionTest")
	public void createContactwithOrg() throws Throwable
	{
		
		        wutil.waitUntilPageLoad(driver);
				String contact=eutil.getExcelData("contact", 4, 2);
				String orgname=eutil.getExcelData("contact", 4, 3);
				//navigate to contact
				driver.findElement(By.linkText("Contacts")).click();
				//create contact
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys(contact+JavaUtility.getRandomData());
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
				//navigate to another window
				wutil.switchToWindow(driver, "Accounts");
				driver.findElement(By.id("search_txt")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.linkText(orgname)).click();
				wutil.switchToWindow(driver, "Contacts");
                //to save the contact
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				//verification
				wutil.waitForElementVisibility(driver,driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
				String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				Assert.assertTrue(expData.contains(contact));
				System.out.println(expData);

							
	}



}
