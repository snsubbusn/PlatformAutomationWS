package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC013_VerifyAgencyPartnerAbletoDeclineNewAssignment extends Action_Method{

	public void verifyAgencyPartnerAbletoDeclineNewAssignment() throws InterruptedException {
		logger = extent.startTest("Agent_TC013_VerifyAgencyPartnerAbletoDeclineNewAssignment");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner General");
		logger.setDescription("Agency Logs in and click on \"New Assignments\" tab. Verify under New Assignments any job is present. If present click on Decline job and verify the job is declined");

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

		if(ag.verifyJobsAlignedtotheAgent()) {
			logger.log(LogStatus.PASS, "Jobs are aligned to the agent and the Agent can now accept the job");

			String New = ag.getFirstJobCardDetails();
			logger.log(LogStatus.PASS, "The First Job Card details Aligned to the Agent are :- "+New);

			String msg = ag.clickOnFirstJobDeclineButton();
			if(msg.contains("Agency alignment")|| msg.contains("Updated")) {
				logger.log(LogStatus.PASS, "The First Job card has been declined by the Agent. THe Success msg is : "+msg);
			}else {
				logger.log(LogStatus.FAIL, "Failed to Decline the Job. The Error is :"+msg);
			}
		}else {
			logger.log(LogStatus.FAIL, "No Jobs aligned to the agent. So could not verify the Agent able to Decline the job in New Assignments");
		}

		logger.log(LogStatus.INFO, "Completed verification of job aligned agency able to Decline the aligned job");

		lp.logout();
		extent.endTest(logger);

	}
}
