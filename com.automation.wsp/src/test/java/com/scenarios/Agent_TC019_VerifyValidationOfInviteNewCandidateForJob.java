package com.scenarios;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyInviteNewPage;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.MyAssignmentsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC019_VerifyValidationOfInviteNewCandidateForJob extends Action_Method{

	public void verifyValidationOfInviteNewCandidateForJob() throws InterruptedException {
		logger = extent.startTest("Agent_TC019_VerifyValidationOfInviteNewCandidateForJob");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner General");
		logger.setDescription("Agency Logs in and click on \"Active Assignments\" tab. Verify Jobs present under Active Assignments and click on 'Assign Candidates'. Click on \"Invite New\" Tab and validates the fields");

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
			
			if(my.clickOnInviteNewTab()) {
				logger.log(LogStatus.PASS, "Clicked on \"Invite New\" Tab of the job");
			}else {
				logger.log(LogStatus.FAIL, "Failed to click on \"Invite New\" Tab");
			}
			
			logger.log(LogStatus.INFO, "Validate the mandatory fields by clicking on \"Invite\" button without entering any mandatory field values");
			
			
			//Agency Invite New Page
			AgencyInviteNewPage an = PageFactory.initElements(driver, AgencyInviteNewPage.class);
			
			if(an.clickOnInviteButton()) {
				logger.log(LogStatus.PASS, "Clicked on \"Invite\" button without providing any details in the Invite New Page");
			}else {
				logger.log(LogStatus.FAIL, "Failed to click on \"Invite\" button ");
			}
			
			ArrayList<String> a = an.getAllErrorForBlankInvite();
			
			for(String error : a) {
				logger.log(LogStatus.PASS, "The Error for blank invite is - \""+(error)+"\"");
			}			
						
		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to \"Active Assignments\" Page");
		}

		logger.log(LogStatus.INFO, "Completed verification of Invite New Page Validation Active Assignments.");

		lp.logout();
		extent.endTest(logger);

	}
}
