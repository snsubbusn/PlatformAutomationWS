package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Agency_CampaignsPage;
import com.objects_pages.MyAssignmentsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class GO_AgentAcceptandTagCandidates extends Action_Method {

	public void agentAcceptandTagCandidates() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		logger = extent.startTest("GO_AgentAcceptandTagCandidates_03");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Guaranteed Onboarding-BasicFlow");
		logger.setDescription("Guaranteed Onboarding Basic Flow - Agent Accepts and Tag Candidates for the campaign");
		
		
		//Launching the url

		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");

		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Agency Email","Agency Password");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Agency Partner Landing page displayed");

		//Creating object for Campaigns page
		Agency_CampaignsPage gs=PageFactory.initElements(driver,Agency_CampaignsPage.class);
		if(gs.Click_on_Campaigns_Tab()==true)
		{
			logger.log(LogStatus.PASS, "Click on Campaigns tab","Agency Campaigns tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Campaigns tab","Fail,Agency Campaigns tab not clicked");
		}
		if(gs.Accept_Job(getExceldata(Variables.testdata,Variables.SetData_Excel,"Job ID"))==true)
		{
			logger.log(LogStatus.PASS, "Click on Accept button for job in Agency Campaigns page","Accept button clicked in job card");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Accept button for job in Agency Campaigns page","Fail,Accept button not clicked in job card");
		}
		logger.log(LogStatus.INFO,"Agent Accepted the campaign to work on");

		//Creating object for Myassignment page
		MyAssignmentsPage My=PageFactory.initElements(driver,MyAssignmentsPage.class);
		if(My.Click_On_MyAssignmentTab()==true)
		{
			logger.log(LogStatus.PASS, "Click on Myassignment tab","Myassigment tab clicked");
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
		if(My.GO_Search_Candidate_TagExisting()==true)
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


		logger.log(LogStatus.INFO,"Candidate has been tagged for the campaign");


		extent.endTest(logger);
		lp.logout();
	}
}
