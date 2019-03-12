package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ManageJobPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_080_Verify_Accept_ReviewSubmission extends Action_Method
{
	public void Accept_ReviewSubmission() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		logger = extent.startTest("GS06_SC_080_Verifying Acceptance of Review Submission by Admin");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Guaranteed Submission - BasicFlow");
		logger.setDescription("Login as WS Admin and accept tagged candidate under Review Submission");
	
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button, Admin Landing page displayed");
		
		//Creating object for manage job page
		ManageJobPage manage=PageFactory.initElements(driver,ManageJobPage.class);
		
		if(manage.clickOnActiveJobs()==true)
		{
			logger.log(LogStatus.PASS, "Click on Manage tab","Manage tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Manage tab","Fail,Manage tab not clicked");
		}
		if(manage.Click_Mangae_Job(getExceldata(Variables.testdata,Variables.SetData_Excel,"Job ID")))
		{
			logger.log(LogStatus.PASS, "Click on Manage job button ","Manage job button clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Manage tab","Fail,Manage job button not clicked");
		}
		if(manage.Click_On_ReviewSubmissionTab()==true)
		{
			logger.log(LogStatus.PASS, "Click on review submission tab","Review Submission tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on review submission tab","Fail,Review submission button not clicked");
		}
		if(manage.Accept_Candidate_ReviewSubmission()==true)
		{
			logger.log(LogStatus.PASS, "Click on Accept button in Review Submission","Accept button clicked in Review submission");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Accept button","Fail to click on Accept button in Review submission");
		}
		
		logger.log(LogStatus.INFO,"Accept candidate in Review submission completed");
		extent.endTest(logger);
		
	}
}
