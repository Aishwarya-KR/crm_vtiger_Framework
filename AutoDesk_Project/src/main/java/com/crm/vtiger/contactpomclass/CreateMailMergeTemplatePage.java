package com.crm.vtiger.contactpomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateMailMergeTemplatePage extends WebDriverUtility {
	
	WebDriver driver;
	public CreateMailMergeTemplatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@class='small']")
	private WebElement browseBtn;
	
	@FindBy(name="target_module")
	private WebElement moduledropdown;
	
	@FindBy(xpath="//input[@title='Save']")
	private WebElement saveBtn;

	public WebElement getBrowseBtn() {
		return browseBtn;
	}

	public WebElement getModuledropdown() {
		return moduledropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void uploadFile(String uploadfile,String moduleSelect)
	{
		browseBtn.sendKeys(uploadfile);
		SelectOption(moduledropdown,moduleSelect);
		saveBtn.click();
		
	}
	
	public void uploadEmptyFile(String moduleSelect,WebDriver driver)
	{
		SelectOption(moduledropdown,moduleSelect);
		saveBtn.click();
		acceptAlert(driver);
	}

}
