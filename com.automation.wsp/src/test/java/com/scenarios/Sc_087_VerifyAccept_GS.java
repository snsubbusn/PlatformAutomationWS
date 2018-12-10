package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Agency_CampaignsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_087_VerifyAccept_GS extends Action_Method
{
	public void Accept_GS() throws EncryptedDocumentException, InvalidFormatException, IOException
	{

		logger = extent.startTest("GS04_SC_087_Verifying Guaranteed Submission of JOb");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Agency Email","Agency Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button,Agency Partner Landing page displayed");
		
		//Creating object for Campaigns page
		Agency_CampaignsPage gs=PageFactory.initElements(driver,Agency_CampaignsPage.class);
		if(gs.Click_on_Campaigns_Tab()==true)
		{
			logger.log(LogStatus.PASS, "Verified the New Assignments page is displayed.");
		}
		else
		{
			logger.log(LogStatus.FAIL, "New Assignments page is not displayed.");
		}
		if(gs.Accept_Job(getExceldata(Variables.testdata,Variables.SetData_Excel,"Job ID"))==true)
		{
			logger.log(LogStatus.PASS, "Click on Accept button for job in Agency Campaigns page","Accept button clicked in job card");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Accept button for job in Agency Campaigns page","Fail,Accept button not clicked in job card");
		}
		logger.log(LogStatus.INFO,"Accept Agency Campaigns verification completed");
		extent.endTest(logger);
	}

}
