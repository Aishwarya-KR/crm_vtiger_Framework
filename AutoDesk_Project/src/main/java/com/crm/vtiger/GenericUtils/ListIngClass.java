package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListIngClass implements ITestListener {
	
	public void onTestFailure(ITestResult result)
	{
		String failedTestName=result.getMethod().getMethodName();
		EventFiringWebDriver ed=new EventFiringWebDriver(BaseClass.sdriver);
		File srcImg=ed.getScreenshotAs(OutputType.FILE);
		String currentDate=new Date().toString().replace(":","_").replace(" ","_");
		File destImg=new File("./screenshot/"+failedTestName+"_"+currentDate+".png");
		try
		{
			FileUtils.copyFile(srcImg,destImg);
		}
		catch(IOException e)
		{
			
		}
	}

	

}
