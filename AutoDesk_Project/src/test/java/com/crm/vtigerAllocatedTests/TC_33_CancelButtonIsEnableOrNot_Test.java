package com.crm.vtigerAllocatedTests;


import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.contactpomclass.ContactPage;
import com.crm.vtiger.contactpomclass.CreateContactPage;
import com.crm.vtiger.contactpomclass.HomePage;

public class TC_33_CancelButtonIsEnableOrNot_Test extends BaseClass {

	@Test
	public void cancelButtonEnabledOrNot() throws Throwable
	{
		wutil.waitUntilPageLoad(driver);
		String contactname=futil.getDataFromJson("contact")+JavaUtility.getRandomData();

		
		//navigate to contacts
		HomePage homePage=new HomePage(driver);
		homePage.clickOnContactLink();
		
		//click on new contact button
		//create contact
		ContactPage contactPage=new ContactPage(driver);
		contactPage.clickOnCreateContactImg();
		
		CreateContactPage createContactPage=new CreateContactPage(driver);
		createContactPage.enableCancel(contactname);
	
					
	}
	

}
