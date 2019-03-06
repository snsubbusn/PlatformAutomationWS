package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.AgencyPartnerInvitedCandidatePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC008_VerifyInvitedCandidateSortByName extends Action_Method{

	public void verifySortByNameofInvitedCandidatePageofAgencyPartner() throws InterruptedException {
		logger = extent.startTest("Agent_TC008_VerifySortByNameofInvitedCandidatePageofAgencyPartner");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner Validation");

		logger.setDescription("Agency Logs in and click on \"Invited Candidates\" tab and verify the Candidates are sorted by \"Name\"");

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
			logger.log(LogStatus.FAIL, "There are no candidates invited by the agency partner. Hence could not verify the sort");
		}else {
			logger.log(LogStatus.INFO, "Verify the Sort by \"Name\" of the Invited Candidate page of Agency Partner");


			String first = ic.getFirstCardDetails();
			if(first.isEmpty()) {
				logger.log(LogStatus.FAIL, "There are no Candidates invited by the agent.");
			}else {
				logger.log(LogStatus.PASS, "The Candidate displayed at the first position is :"+first);
			}

			logger.log(LogStatus.INFO, "Verify the default Sortof the Invited candidates");


			String sor = ic.getDefaultSortValue();
			if(sor.contains("Invited")) {
				logger.log(LogStatus.PASS, "Verified the default Sort By value is \""+sor+"\"");
			}else {
				logger.log(LogStatus.FAIL, "The default Sort By value is not 'Invited On'. It is "+sor);
			}

			logger.log(LogStatus.INFO, "Sort the candidates by \"Name\" and verify the sort value displayed");

			String aft = ic.sortByName();
			if(aft.contains("Name")) {
				logger.log(LogStatus.PASS, "The candidates are sorted by \"Name\" successfully");
			}else {
				logger.log(LogStatus.FAIL, "Failed to sort the candidates by \"Name\"");
			}
		}

		logger.log(LogStatus.INFO, "Completed verification of sorting by Name of Invited Candidate Page");

		lp.logout();
		extent.endTest(logger);

	}
}
