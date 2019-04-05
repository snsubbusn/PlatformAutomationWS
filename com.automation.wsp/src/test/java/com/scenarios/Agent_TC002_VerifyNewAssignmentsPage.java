package com.scenarios;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC002_VerifyNewAssignmentsPage extends Action_Method{
	
	public void verifyNewAssignmentsPage() throws InterruptedException {
		logger = extent.startTest("Agent_TC002_VerifyNewAssignmentsPage");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner General");
		
		logger.setDescription("Agency Logs in and click on New Assignments and verify the total count of Jobs present in the New Assignments Page");

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
		
		String ass = ag.verifySelectedAssignmentsPage();
		if(ass.contains("New Assignments")) {
			logger.log(LogStatus.PASS, "New Assignments Page is displayed successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to Navigate to \"New Assignements\" page.");
		}
		
		String count = ag.getTotalRecordsofthePage();
		if(count.contains("exception")) {
			logger.log(LogStatus.WARNING, "There are no \"New Assignments\" aligned to the agent.");
		}else {
			logger.log(LogStatus.PASS, "There are "+count+" \"New Assignments\" aligned to the agent");
		}
	
		
		
		logger.log(LogStatus.INFO, "Completed verification of New Assignment Page");
	
		lp.logout();
		extent.endTest(logger);
	}
}
