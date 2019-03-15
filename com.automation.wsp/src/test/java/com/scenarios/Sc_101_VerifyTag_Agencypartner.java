package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.MyAssignmentsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_101_VerifyTag_Agencypartner extends Action_Method
{
	public void Tag_Candidate_AgencyPartner() throws EncryptedDocumentException, InvalidFormatException, IOException
	{

		logger = extent.startTest("GS05_SC_101_Verifying tag candidate by agency partner");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Guaranteed Submission - BasicFlow");
		logger.setDescription("Login as Agency partner and verify the campaign is accepted and tag the candidates to the GS Campaign");
	
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Agency Email","Agency Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button, Agency Partner Landing page displayed");
		
		//Creating object for Myassignment page
		MyAssignmentsPage My=PageFactory.initElements(driver,MyAssignmentsPage.class);
		if(My.click_On_ActiveAssignmentTab()==true)
		{
			logger.log(LogStatus.PASS, "Navigated to Active Assignments");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Myassignment tab","Fail,Myassignment tab not clicked");
		}
		if(My.Click_Assign_Candidate(getExceldata(Variables.testdata, Variables.SetData_Excel,"Job ID"))==true)
		{
			logger.log(LogStatus.PASS, "Click on Assign Candidate button under job","Assign candidate button clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Assign Candidate button under job","Fail,Not ablle to click on Assign candidate button");
		}
		if(My.Click_on_TagExistingTab()==true)
		{
			logger.log(LogStatus.PASS, "Click on Tag Existing tab","Tagexisting tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Tag Existing tab","Fail,Not able to click on tag existing tab");
		}
		if(My.Search_Candidate_TagExisting()==true)
		{
			logger.log(LogStatus.PASS, "Click on Search button in Tag Existing page","Search button clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Search button in Tag Existing page","Fail,Not able to click on search button");
		}
		if(My.Tag_Candidate()==true)
		{
			logger.log(LogStatus.PASS, "Click on Tag button to tag candidate","Candidate tagged successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Tag button to tag candidate","Fail,Not able click on tag button for Candidate tagging");
		}
		
		
		logger.log(LogStatus.INFO,"Candidate tag verification completed");
		extent.endTest(logger);
	
		
	}
}