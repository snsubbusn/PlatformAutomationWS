package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.AgencyPartnerInvitedCandidatePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC011_VerifyJoinedCandidateProfile extends Action_Method{

	public void verifyAgencyPartnerAbletoViewJoinedCandidateProfile() throws InterruptedException {
		logger = extent.startTest("Agent_TC011_VerifyAgencyPartnerAbletoViewJoinedCandidateProfile");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner Validation");

		logger.setDescription("Agency Logs in and click on \"Invited Candidates\" tab. Verifies if there are any Joined status and click on Name of the candidate to view the profile.");

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
			logger.log(LogStatus.FAIL, "There are no candidates invited by the agency partner. Hence could not verify the Candidate Profile");
		}else {

			logger.log(LogStatus.INFO, "Sort the invited candidates by \"Status\"");
			String aft = ic.sortByStatus();
			if(aft.contains("Status")) {
				logger.log(LogStatus.PASS, "The candidates are sorted by \"Status\" successfully");
			}else {
				logger.log(LogStatus.WARNING, "Failed to sort the candidates by \"Status\"");
			}


			if(ic.selectFirstJoinedStatusCandidate()) {
				logger.log(LogStatus.PASS, "Candidate with Status \"Joined\" found and clickked on the candidate name");

				logger.log(LogStatus.INFO, "Verify the candidate profile is displayed");

				String msg = ic.getCandidateDetails();
				if(msg.contains("Candidate")) {
					logger.log(LogStatus.PASS, "Clicked on Joined Candidate and the candidate details are - "+msg);
				}else {
					logger.log(LogStatus.WARNING, "Clicked on Joined Candidatea and exception occured - "+msg);
				}

			}else {
				logger.log(LogStatus.WARNING, "There are no candidate with Joined Status");
			}

		}

		logger.log(LogStatus.INFO, "Completed verification of Joined Candidate view profile of Invited Candidate Page");

		lp.logout();
		extent.endTest(logger);

	}
}
