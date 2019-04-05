package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyInviteNewPage;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.MyAssignmentsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC022_VerifyTagExistingTabofaJob extends Action_Method{

	public void verifyTagExistingTabOfJob() throws InterruptedException {
		logger = extent.startTest("Agent_TC022_VerifyTagExistingTabofaJob");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner General");
		logger.setDescription("Agency Logs in and click on \"Active Assignments\" tab. Verify Jobs present under Active Assignments and click on 'Assign Candidates'. Click on \"Tag Existing\" Tab and verify the TagExisting Tab section");

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
			
			String select = my.getSelectedTabDetails();
			if(select.contains("Tag Existing")) {
				logger.log(LogStatus.PASS, "The default tab displayed for the My Assignments of the Job is - "+select);
			}else {
				logger.log(LogStatus.FAIL, "The default tab displayed is not Tag Existing. It is - "+select);
			}
			
			if(my.verifySearchTalentImageIsDisplayed()) {
				logger.log(LogStatus.PASS, "Verified the Search Talent image is displayed. Hence no search has been performed by default");
			}else {
				logger.log(LogStatus.FAIL, "Could not find the Search Talent Image. There might be search result displayed by default");
			}
			
			logger.log(LogStatus.INFO, "Verify the search criteria displayed under Tag Existing");
			String sear = my.verifyAllSearchCriteriaIsDisplayed();
			if(!sear.contains("Either")) {
				logger.log(LogStatus.PASS, "Verified the search criteria as - "+sear);
			}else {
				logger.log(LogStatus.FAIL, sear);
			}
			
			logger.log(LogStatus.INFO, "Validate the Email field");
			String email = my.validateEmailSearchField();
			
			if(email.contains("Please")) {
				logger.log(LogStatus.PASS, "Validated the Email Field. When provided invalid email the error displayed is:- "+email);
			}else {
				logger.log(LogStatus.FAIL, "Unable to validate the Email Field. The msg is :-"+email);
			}
			
			logger.log(LogStatus.INFO, "Validate the Phone Number field");
			String phone = my.validatePhoneNoSearchField();
			
			if(phone.contains("Please")) {
				logger.log(LogStatus.PASS, "Validated the Phone No Field. When provided invalid Number the error displayed is:- "+phone);
			}else {
				logger.log(LogStatus.FAIL, "Unable to validate the Phone No Field. The msg is :-"+phone);
			}
			
			logger.log(LogStatus.INFO, "Click on \"Clear Filter\" and verify the details are cleared");
			my.clickOnClearAllFilterButton();
			
			if(my.verifyEmailError().contains("No Error")) {
				logger.log(LogStatus.PASS, "Successfully cleared all the filters and the error message is not displayed");
			}else {
				logger.log(LogStatus.FAIL, "Email error is still displayed after clicking on Clear All Filter button");
			}
			
		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to \"Active Assignments\" Page");
		}

		logger.log(LogStatus.INFO, "Completed Verifying Tag Existing tab details under Assign Candidate for a Job");

		lp.logout();
		extent.endTest(logger);

	}
}
