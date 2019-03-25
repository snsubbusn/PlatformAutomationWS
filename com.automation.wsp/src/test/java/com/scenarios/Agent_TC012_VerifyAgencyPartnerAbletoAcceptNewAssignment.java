package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.AgencyPartnerInvitedCandidatePage;
import com.objects_pages.MyAssignmentsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC012_VerifyAgencyPartnerAbletoAcceptNewAssignment extends Action_Method {

	public void verifyAgencyPartnerAbletoAcceptNewAssignment() throws InterruptedException {
		logger = extent.startTest("Agent_TC012_VerifyAgencyPartnerAbletoAcceptNewAssignment");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner General");
		logger.setDescription("Agency Logs in and click on \"New Assignments\" tab. Verify under New Assignments any job is present. If present click on accept job and verify the job has been moved to Active assignment");

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

			if(ag.clickOnFirstJobAcceptButton()) {
				logger.log(LogStatus.PASS, "Clicked on the Accept button of the First Job Card aligned to the agent");
				ag.closeSuccessMsg();
				int start = New.indexOf("#");
				String jobId = New.substring(start);
				MyAssignmentsPage my = PageFactory.initElements(driver, MyAssignmentsPage.class);
				if(my.click_On_ActiveAssignmentTab()) {
					logger.log(LogStatus.PASS, "Navigated to \"Active Assignments\" Page");

					String acceptJob = my.findJobCardMatchesAcdeptedJobCard(jobId);

					if(New.equals(acceptJob)) {
						logger.log(LogStatus.PASS, "Verified the Job Accepted is displayed in the \"Active Assignments\" page. The job details are - "+acceptJob);
					}else {
						logger.log(LogStatus.FAIL, "The Accepted Job is not present in the \"Active Assignements\" page. the details are - "+acceptJob);
					}

				}else {
					logger.log(LogStatus.FAIL, "Failed to Click on Accept button of the first job card aligned");
				}
			}else {
				logger.log(LogStatus.FAIL, "Failed to navigate to \"Active Assignments\" page.");
			}
		}else {
			logger.log(LogStatus.WARNING, "No Jobs aligned to the agent. So could not verify the Agent able to accept the job in New Assignments");
		}

		logger.log(LogStatus.INFO, "Completed verification of job aligned agency able to accept the aligned job");

		lp.logout();
		extent.endTest(logger);

	}
}
