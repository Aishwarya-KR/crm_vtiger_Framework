package com.crm.vtiger.contactpomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Aishwarya
 */

public class ContactInformationPage {
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactInfo;

	public WebElement getContactInfo() {
		return contactInfo;
	}
	
	/*
	 * It will display the contact information
	 */
	public String getContactText()
	{
		return contactInfo.getText();
	}
	

}
