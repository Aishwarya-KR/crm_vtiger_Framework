package com.crm.vtiger.contactpomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Aishwarya
 */
public class ContactPage {
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactImg;
	
	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	
	@FindBy(linkText="Create Mail Merge templates")
	private WebElement createMailMerge;
	
	public WebElement getCreateMailMerge() {
		return createMailMerge;
	}

	/*
	 * Click on create contact image
	 */
	public void clickOnCreateContactImg()
	{
		createContactImg.click();
	}
	
	/*
	 * Click on create mail merge template link
	 */
	public void clickOnMailMergeTemLink()
	{
		createMailMerge.click();
	}
	
	

}
