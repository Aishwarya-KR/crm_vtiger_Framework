package com.crm.vtigerAllocatedTests;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.contactpomclass.ContactPage;
import com.crm.vtiger.contactpomclass.CreateMailMergeTemplatePage;
import com.crm.vtiger.contactpomclass.HomePage;

public class TC_34_CreateMailMergeTemplateWithOrganization_Test extends BaseClass {
	
	@Test
	public void createMailMerge() throws Throwable
	{
		String uploadfile=futil.getDataFromJson("uploadfile");
		String moduleSelect=futil.getDataFromJson("module");
		//navigate to contacts
		HomePage homePage=new HomePage(driver);
		homePage.clickOnContactLink();
		
		//click on mail merge template
		ContactPage contactPage=new ContactPage(driver);
		contactPage.clickOnMailMergeTemLink();		
		
		//click on browse button and select organization
		CreateMailMergeTemplatePage createMailMerge=new CreateMailMergeTemplatePage(driver);
		createMailMerge.uploadFile(uploadfile, moduleSelect);
		
		/*driver.findElement(By.xpath("//input[@class='small']")).sendKeys(uploadfile);
		WebElement module=driver.findElement(By.name("target_module"));
		wutil.SelectOption(module,moduleSelect);*/
		//click on save
		//driver.findElement(By.xpath("//input[@title='Save']")).click();
		
	}
	

}
