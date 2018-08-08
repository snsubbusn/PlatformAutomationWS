package com.scenarios;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.GuaranteedSubmissionsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_087_VerifyAccept_GS extends Action_Method
{
	public void Accept_GS() throws EncryptedDocumentException, InvalidFormatException, IOException
	{

		logger = extent.startTest("verifying Guaranteed Submission of  JOb");
		
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Agency Email","Agency Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button,Agency Partner Landing page displayed");
		
		//Creating object for Guaranteed submission page
		GuaranteedSubmissionsPage gs=PageFactory.initElements(driver,GuaranteedSubmissionsPage.class);
		if(gs.Click_on_GuaranteedSubmission_Tab()==true)
		{
			logger.log(LogStatus.PASS, "Click on Guaranteed Submissions tab","Guaranteed submissions tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Guaranteed Submissions tab","Fail,Guaranteed submissions tab not clicked");
		}
		if(gs.Accept_Job_GuaranteedSubmission(getExceldata(Variables.testdata,Variables.SetData_Excel,"Job ID"))==true)
		{
			logger.log(LogStatus.PASS, "Click on Accept button for job in Guaranteed Submissions page","Accept button clicked in job card");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Accept button for job in Guaranteed Submissions page","Fail,Accept button not clicked in job card");
		}
		logger.log(LogStatus.INFO,"Accept Guaranteed submission verification completed");
		extent.endTest(logger);
	}

}
