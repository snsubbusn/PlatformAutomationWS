package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.AgencyPartnerInvitedCandidatePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC010_VerifySendReminderForInvitedCandidate extends Action_Method{

	public void verifySendReminderForInvitedCandidateOfAgencyPartner() throws InterruptedException {
		logger = extent.startTest("Agent_TC010_VerifySendReminderForInvitedCandidatePageofAgencyPartner");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner Validation");

		logger.setDescription("Agency Logs in and click on \"Invited Candidates\" tab. Verifies if there are any Pending status sending Reminder to that candidate through Send Reminder");

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

		AgencyPartnerInvitedCandidatePage ic = PageFactory.initElements(driver, AgencyPartnerInvitedCandidatePage.class);
		logger.log(LogStatus.INFO, "Click on \"Invited Candidates\" Tab");

		ic.clickOnInvitedCandidatesTab();

		if(ic.verifyInvitedCandidatesTabisSelected().contains("true")) {
			logger.log(LogStatus.PASS, "Navigated to \"Invited Candidate\" page successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to \"Invited Candidate\" Page");
		}

		String count = ic.getTotalRecordsofthePage();

		if(count.contains("exception")) {
			logger.log(LogStatus.FAIL, "There are no candidates invited by the agency partner. Hence could not verify the Send Reminder");
		}else {

			logger.log(LogStatus.INFO, "Sort the invited candidates by \"Status\"");
			String aft = ic.sortByStatus();
			if(aft.contains("Status")) {
				logger.log(LogStatus.PASS, "The candidates are sorted by \"Status\" successfully");
			}else {
				logger.log(LogStatus.WARNING, "Failed to sort the candidates by \"Status\"");
			}

			String stat = ic.checkSelectAllCheckboxState();
			
			if(stat.contains("false")) {
				logger.log(LogStatus.PASS, "Select CheckBox is not checked, Can go on for selecting pending status candidate");

				if(ic.selectFirstPendingStatusCandidate()&&ic.checkSelectAllCheckboxState().equals("true")) {
					logger.log(LogStatus.PASS, "Selected the candidate with Pending Status.");
				
					logger.log(LogStatus.INFO, "Click on Send Reminder and verify the success message displayed");
					
					String msg = ic.clickAndVerifySendReminder();
					if(msg.contains("Reminder")) {
						logger.log(LogStatus.PASS, "Clicked on Send Reminder and the message displayed is :"+msg);
					}else {
						logger.log(LogStatus.WARNING, "Clicked on Send Reminder and the message displayed is :"+msg);
					}
				
				}else {
					logger.log(LogStatus.WARNING, "There are no candidate with Pending Status");
				}
			}else {
				logger.log(LogStatus.FAIL, "Select Checkbox is already checked");
			}

		}

		logger.log(LogStatus.INFO, "Completed verification of Send Reminder of Invited Candidate Page");

		lp.logout();
		extent.endTest(logger);

	}
}
