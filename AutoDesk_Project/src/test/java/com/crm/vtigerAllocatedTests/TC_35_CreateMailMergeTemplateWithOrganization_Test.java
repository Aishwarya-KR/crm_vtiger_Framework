package com.crm.vtigerAllocatedTests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.contactpomclass.ContactPage;
import com.crm.vtiger.contactpomclass.CreateMailMergeTemplatePage;
import com.crm.vtiger.contactpomclass.HomePage;

public class TC_35_CreateMailMergeTemplateWithOrganization_Test extends BaseClass {

	@Test
	public void createMailMerge() throws Throwable
	{
		wutil.waitUntilPageLoad(driver);
		String moduleSelect=futil.getDataFromJson("module");

	
		//navigate to contacts
		HomePage homePage=new HomePage(driver);
		homePage.clickOnContactLink();
		
		//click on mail merge template
		ContactPage contactPage=new ContactPage(driver);
		contactPage.clickOnMailMergeTemLink();
		
		//click on browse button and select organization
		CreateMailMergeTemplatePage createMailMerge=new CreateMailMergeTemplatePage(driver);
        createMailMerge.uploadEmptyFile(moduleSelect,driver);
		
	}
		
	

}
