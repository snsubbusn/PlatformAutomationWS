package com.scenarios;


import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Candidate_MyEngagementsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC011_VerifyMyEngagementsofCandidate extends Action_Method{
	
	public void VerifyMyEngagementsPage() throws InterruptedException {
		logger = extent.startTest("Candidate_TC011_VerifyMyEngagementsofCandidate");
		logger.assignAuthor("Keerthana");
		logger.assignCategory("Candidate General");
		
		logger.setDescription("Candidate Logs in and click on My Engagements and verify the items per page,pagination and campaign cards to which the candidate is tagged,present in the My Engagements Page");
	
	
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and the Login Page is displayed");

		
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as  candidate
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage, "Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Candidate Profile Landing page is displayed");

		Candidate_MyEngagementsPage me = PageFactory.initElements(driver,Candidate_MyEngagementsPage.class);
		
		if(me.VerifyCandidateLogin()) {
			logger.log(LogStatus.PASS, "Verified the Candidate has logged in successfully");
		}else {
			logger.log(LogStatus.FAIL, "Candidate login failed. candidate profile tab is not displayed.");
		}
		
		logger.log(LogStatus.PASS, "Click on \"My Engagements\" Tab");
		me.ClickOn_MyEngagementsTab();
		
		String vme = me.VerifyMyEngagementsPage();
		if(vme.contains("My Engagements")) {
			logger.log(LogStatus.PASS, "My Engagements Page is displayed successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to Navigate to \"My Engagements\" page.");
		}
		
		if(me.Verify_Pagination())
		{
			logger.log(LogStatus.PASS, "Pagination is displayed successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to display pagination.");
		}

		if(me.ClickOn_ItemsPerPage())
		{
			logger.log(LogStatus.PASS, "Items per page drop down is displayed successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to display drop down of Items per page.");
		}
		
		if(me.Select_Item())
		{
			logger.log(LogStatus.PASS, "Item selected from Items per page drop down successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to select Item from Item per page drop down of Items per page.");
		}

		lp.logout();
		extent.endTest(logger);	
	}
}
