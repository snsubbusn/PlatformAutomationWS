package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC003_VerifyActiveAssignmentsPage extends Action_Method{

	public void verifyActiveAssignmentsPage() throws InterruptedException {
		logger = extent.startTest("Agent_TC003_VerifyActiveAssignmentsPage");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner General");
		
		logger.setDescription("Agency Logs in and click on Active Assignments and verify the total count of Jobs present in the Active Assignments Page");

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
		
		logger.log(LogStatus.INFO, "Click on \"Active Assignments\" Tab");
		ag.clickOnActiveAssignments();
		
		String ass = ag.verifySelectedAssignmentsPage();
		if(ass.contains("Active Assignments")) {
			logger.log(LogStatus.PASS, "Active Assignments Page is displayed successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to Navigate to \"Active Assignements\" page.");
		}
		
		String count = ag.getTotalRecordsofthePage();
		if(count.contains("exception")) {
			logger.log(LogStatus.FAIL, "There are no \"Active Assignments\" aligned to the agent."+count);
		}else {
			logger.log(LogStatus.PASS, "There are "+count+" \"Active Assignments\" aligned to the agent");
		}
	
		
		
		logger.log(LogStatus.INFO, "Completed verification of Active Assignment Page");
	
		lp.logout();
		extent.endTest(logger);
	}
}
