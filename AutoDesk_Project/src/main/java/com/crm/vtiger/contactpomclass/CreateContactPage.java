package com.crm.vtiger.contactpomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	WebDriver driver;
	public CreateContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="lastname")
	private WebElement lastNameTF;
	
	@FindBy(xpath="//input[@name='portal']")
	private WebElement portalCB;
	
	@FindBy(id="email")
	private WebElement emailTF;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancelBtn;

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getPortalCB() {
		return portalCB;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	
	/*
	 * create contact with mandatory fields
	 */
	
	public void createContact(String contactname)
	{
		lastNameTF.sendKeys(contactname);
		saveBtn.click();
	}
	
	/*
	 * create contact with mandatory fields and check cancel button is enabled or not
	 */
	public void enableCancel(String contactname)
	{
		lastNameTF.sendKeys(contactname);
		cancelBtn.click();
	}
	
	public void createContactWithPortal(String contactname,String email)
	{
		lastNameTF.sendKeys(contactname);
		portalCB.click();
		saveBtn.click();
		acceptAlert(driver);
		emailTF.sendKeys(email);
		saveBtn.click();
		
	}
	
	
}
