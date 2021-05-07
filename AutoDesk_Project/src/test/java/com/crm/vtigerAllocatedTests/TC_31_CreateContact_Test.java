package com.crm.vtigerAllocatedTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.contactpomclass.ContactInformationPage;
import com.crm.vtiger.contactpomclass.ContactPage;
import com.crm.vtiger.contactpomclass.CreateContactPage;
import com.crm.vtiger.contactpomclass.HomePage;

public class TC_31_CreateContact_Test extends BaseClass {

	
	@Test
	public void createContact() throws Throwable
	{
		wutil.waitUntilPageLoad(driver);
		String contactname=futil.getDataFromJson("contact")+"_"+JavaUtility.getRandomData();
		String email=futil.getDataFromJson("email");
	
		//navigate to contacts
		HomePage homePage=new HomePage(driver);
		homePage.clickOnContactLink();
		
		//click on new contact button
		//create contact
		ContactPage contactPage=new ContactPage(driver);
		contactPage.clickOnCreateContactImg();
		
		CreateContactPage createContactPage=new CreateContactPage(driver);
        createContactPage.createContactWithPortal(contactname, email);
				
		//verification
        ContactInformationPage contactInfoPage=new ContactInformationPage(driver);
        String actualContactText=contactInfoPage.getContactText();
        Assert.assertTrue(actualContactText.contains(contactname));
  			
	}

}
