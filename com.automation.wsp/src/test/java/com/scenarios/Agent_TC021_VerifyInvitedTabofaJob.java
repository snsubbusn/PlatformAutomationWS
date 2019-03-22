package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyInviteNewPage;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.MyAssignmentsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC021_VerifyInvitedTabofaJob extends Action_Method{

	public void verifyInviteNewCandidateForJob() throws InterruptedException {
		logger = extent.startTest("Agent_TC021_VerifyInvitedTabofaJob");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner General");
		logger.setDescription("Agency Logs in and click on \"Active Assignments\" tab. Verify Jobs present under Active Assignments and click on 'Assign Candidates'. Click on \"Invited\" Tab and verify the Invited Tab section");

		//Launching URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and the Login Page is displayed");


		//LoginPage Object creation
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as Agency Partner
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage, "Agency Email", "Agency Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button, Agency Partner Landing page is displayed");

		AgencyPartnerGenPage ag = PageFactory.initElements(driver, AgencyPartnerGenPage.class);

		if(ag.verifyAgentLogin()) {
			logger.log(LogStatus.PASS, "Verified the Agent has logged in successfully");
		}else {
			logger.log(LogStatus.FAIL, "Agency partner login failed. NewAssignments tab is not displayed.");
		}

		MyAssignmentsPage my = PageFactory.initElements(driver, MyAssignmentsPage.class);
		if(my.click_On_ActiveAssignmentTab()) {
			logger.log(LogStatus.PASS, "Navigated to \"Active Assignments\" Page");
			
			String New = my.getFirstJobCardDetails();
			logger.log(LogStatus.PASS, "The First Job Card details under Active Assignments of the Agent are :- "+New);
			int start = New.indexOf("#");
			String jobId = New.substring(start+1);
			if(my.Click_Assign_Candidate(jobId)) {
				logger.log(LogStatus.PASS, "Clicked on the first job card Assign Candidate.");
			}else {
				logger.log(LogStatus.FAIL, "Failed to click on Assign Candidate of first job card");
			}
			
			String myass = my.verifyNavigatedtoMyAssignmentsPage();
			if(myass.contains("My Assignments")) {
				logger.log(LogStatus.PASS, "Navigated to \"My Assignments\" Page of the selected Job Id.");
			}else {
				logger.log(LogStatus.FAIL, "Failed to navigate to \"My Assignments\" Page of the selected Job Id");
			}
			
			if(my.clickOnInvitedTab()) {
				logger.log(LogStatus.PASS, "Clicked on \"Invited\" Tab of the job");
			}else {
				logger.log(LogStatus.FAIL, "Failed to click on \"Invited\" Tab");
			}
			
			logger.log(LogStatus.INFO, "Verify the Invited Tab for any candidate has been invited for the job or not");
			
			//Agency Invite New Page
			AgencyInviteNewPage an = PageFactory.initElements(driver, AgencyInviteNewPage.class);
			
			if(an.verifyCandidateInvitedUnderInvitedTab()) {
				logger.log(LogStatus.PASS, "There are no candidates invited for the job");
			}else {
				logger.log(LogStatus.PASS, "Candidates are invited for the job");
			}
				
						
		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to \"Active Assignments\" Page");
		}

		logger.log(LogStatus.INFO, "Completed Inviting new Candidate under Assign Candidate for a Job");

		//lp.logout();
		extent.endTest(logger);

	}
}
