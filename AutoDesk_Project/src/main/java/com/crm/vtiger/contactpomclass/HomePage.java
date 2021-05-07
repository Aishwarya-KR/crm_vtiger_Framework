package com.crm.vtiger.contactpomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(xpath="//a[contains(text(),'Sign Out')]")
	private WebElement signOutLink;

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	/*
	 * click on contact link
	 */
	public void clickOnContactLink()
	{
		contactLink.click();
	}
	
	/*
	 * sign out from the app
	 */
	public void signOut()
	{
		mouseOver(driver,administratorImg);
		signOutLink.click();
	}

}
