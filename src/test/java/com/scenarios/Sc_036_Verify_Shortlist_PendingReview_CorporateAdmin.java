package com.scenarios;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ViewResponsesPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_036_Verify_Shortlist_PendingReview_CorporateAdmin extends Action_Method
{
	public void Shortlist_PendingReview() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		logger = extent.startTest("verifying Shortlist of a candidate in pending review by corporate");
		
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button,Corporate Landing page displayed");
		
		//Creating Object for view Responses page
		ViewResponsesPage view=PageFactory.initElements(driver,ViewResponsesPage.class);
		if(view.Click_On_ViewResponses_Tab()==true)
		{
			logger.log(LogStatus.PASS, "Click on View Responses tab","View Responses tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on View Responses tab","Fail,View Responses tab not clicked");
		}
		if(view.Click_On_PendingReview_Button_ViewResponsespage(getExceldata(Variables.testdata,Variables.SetData_Excel,"Job ID"))==true)
		{
			logger.log(LogStatus.PASS, "Verify Pending Review Button","Pending review button clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Verify Pending review button","Fail,Unable to click on Pending review button");
		}
		if(view.Click_On_Shortlist_ViewResponses()==true)
		{
			logger.log(LogStatus.PASS, "Verify shortlist in pending review","Candidate shortlisted");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Verify shortlist in pending review","Fail to shortlist candidate");
		}
		

		logger.log(LogStatus.INFO,"Shortlist candidate in pending review page completed");
		extent.endTest(logger);
		
	}
}
