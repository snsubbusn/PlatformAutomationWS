package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.MyAssignmentsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC016_VerifyAgencyPartnerAbletoViewJobDetailsfromOnHoldAssignment extends Action_Method{

	public void verifyAgencyPartnerAbletoViewJobDetailsfromOnHoldAssignment() throws InterruptedException {
		logger = extent.startTest("Agent_TC016_VerifyAgencyPartnerAbletoViewJobDetailsfromOnHoldAssignment");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner General");
		logger.setDescription("Agency Logs in and click on \"OnHold Assignments\" tab. Verify under OnHold Assignments any job is present. If present click on first job to view the Job Details");

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
		if(my.click_On_OnHoldAssignment()) {
			logger.log(LogStatus.PASS, "Navigated to \"OnHold Assignments\" Page");
			
			String New = my.getFirstJobCardDetails();
			logger.log(LogStatus.PASS, "The First Job Card details Aligned to the Agent are :- "+New);

			if(my.clickOnFirstJobDetail()) {
				logger.log(LogStatus.PASS, "The First Job card has been clicked by the Agent. Verified the Job Details is displayed.");
			}else {
				logger.log(LogStatus.FAIL, "Failed to Click on the First Job card.");
			}
			
			if(my.clickOnBackButtonfromJobDetail()) {
				logger.log(LogStatus.PASS, "Clicked on Back Button from the Job Detail page");
			}else {
				logger.log(LogStatus.FAIL, "Failed to click on Back Button from the Job Detail Page");
			}
			
			String New1 = my.getFirstJobCardDetails();
			logger.log(LogStatus.PASS, "The Job Card Detail after coming back from view Job Detail are :- "+New1);

		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to \"OnHold Assignments\" Page");
		}

		logger.log(LogStatus.INFO, "Completed verification of job details of the first job card in \"OnHold Assignments\" page");

		lp.logout();
		extent.endTest(logger);

	}
}
