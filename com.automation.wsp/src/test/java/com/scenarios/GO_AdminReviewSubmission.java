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

public class GO_AdminReviewSubmission  extends Action_Method {
	
	public void goAdminReviewSubmission() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		logger = extent.startTest("GO_AdminReviewSubmission_04");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Guaranteed Onboarding-BasicFlow");
		logger.setDescription("Guaranteed Onboarding Basic Flow - Admin Shortlists the candidate under Review Submission for the campaign");
		
		
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button, Admin Landing page displayed");
		
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
			logger.log(LogStatus.FAIL, "Click on Manage job button","Fail,Manage job button not clicked");
		}
		if(manage.Click_On_ReviewSubmissionTab()==true)
		{
			logger.log(LogStatus.PASS, "Click on review submission tab","Review Submission tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on review submission tab","Fail,Review submission not clicked");
		}
		if(manage.Accept_Candidate_ReviewSubmission()==true)
		{
			logger.log(LogStatus.PASS, "Click on Accept button in Review Submission","Accept button clicked in Review submission");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Accept button","Fail to click on Accept button in Review submission");
		}
		
		logger.log(LogStatus.INFO,"Admin Shortlisted the candidate under Review submission of the campaign");
		extent.endTest(logger);
		lp.logout();
	}

}
