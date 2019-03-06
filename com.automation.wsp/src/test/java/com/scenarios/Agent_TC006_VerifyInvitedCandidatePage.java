package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.AgencyPartnerInvitedCandidatePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC006_VerifyInvitedCandidatePage extends Action_Method{

	public void verifyInvitedCandidatePageofAgencyPartner() throws InterruptedException {
		logger = extent.startTest("Agent_TC006_VerifyInvitedCandidatePageofAgencyPartner");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner Validation");
		
		logger.setDescription("Agency Logs in and click on \"Invited Candidates\" tab and verify the number of candidates invited by that Agent");

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
		
		
		logger.log(LogStatus.INFO, "Verify the details of the Invited Candidate page of Agency Partner");
		
		
		String count = ic.getTotalRecordsofthePage();
		if(count.contains("exception")) {
			logger.log(LogStatus.FAIL, "There are no Candidates invited by the agent."+count);
		}else {
			logger.log(LogStatus.PASS, "There are "+count+" Candidates invited by the agent");
		}
	
		
		
		
		String sor = ic.getDefaultSortValue();
		if(sor.contains("Invited")) {
			logger.log(LogStatus.PASS, "Verified the default Sort By value is \""+sor+"\"");
		}else {
			logger.log(LogStatus.FAIL, "The default Sort By value is not 'Invited On'. It is "+sor);
		}
		
		
		String sel = ic.checkSelectAllCheckboxState();
		if(sel.equals("false")) {
			logger.log(LogStatus.PASS, "The 'Select All' checkbox by default is not checked");
		}else {
			logger.log(LogStatus.FAIL, "The 'Select All' checkbox by default is checked");
		}
		
		
		logger.log(LogStatus.INFO, "Completed verification of Invited Candidate Page");
	
		lp.logout();
		extent.endTest(logger);
	}
}
