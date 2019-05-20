package com.scenarios;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Candidate_MyEngagementsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC013_VerifyPaginationofMyEngagements extends Action_Method {
	public void VerifyPagination() throws InterruptedException
	{
		logger = extent.startTest("Candidate_TC013_VerifyPaginationofMyEngagements");
		logger.assignAuthor("Keerthana");
		logger.assignCategory("Candidate General");
		
		logger.setDescription("Candidate Logs in and click on My Engagements and verifies pagination and campaign cards to which the candidate is tagged,present in the My Engagements Page");
	
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and the Login Page is displayed");

		
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as  candidate
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage, "Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Candidate Profile Landing page is displayed");

		Candidate_MyEngagementsPage myEng = PageFactory.initElements(driver,Candidate_MyEngagementsPage.class);
		
		if(myEng.VerifyCandidateLogin()) {
			logger.log(LogStatus.PASS, "Verified the Candidate has logged in successfully");
		}else {
			logger.log(LogStatus.FAIL, "Candidate login failed. candidate profile tab is not displayed.");
		}
		
		logger.log(LogStatus.PASS, "Click on \"My Engagements\" Tab");
		myEng.ClickOn_MyEngagementsTab();
		
		String vme = myEng.VerifyMyEngagementsPage();
		if(vme.contains("My Engagements")) {
			logger.log(LogStatus.PASS, "My Engagements Page is displayed successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to Navigate to \"My Engagements\" page.");
		}

		Boolean pag = myEng.Verify_Pagination();
		if(pag.booleanValue())
		{	
			logger.log(LogStatus.PASS, "Pagination is displayed successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to display pagination.");
		}
		
		if(myEng.VerifyJobCards()) {
			logger.log(LogStatus.PASS, "Candidate not tagged to any campaigns,No job cards present");
		}else 
		{
			String item = myEng.getDefaultItemsPerPage(); 
			Boolean laspag = myEng.goToLastpage(); 
		
		if(!item.isEmpty())
		{
			logger.log(LogStatus.PASS, "There are "+item+" Jobs per page of \"My Engagements\" Page");
			
			String record = myEng.getTotalRecordsofthePage();
		
			if(!record.isEmpty())
			logger.log(LogStatus.PASS, "There are totally "+record+" Jobs in the \"My Engagements\" Page for the candiadate");
			
		}
		else
		{
			logger.log(LogStatus.PASS, "There are no pages  in the \"My Engagements\" Page");
		}
		
		if(myEng.clickOnPage1()) {
			if(myEng.verifyFirstPageEnabled() && myEng.verifyPreviousPageEnabled()) {			
				logger.log(LogStatus.FAIL, "First Page and Previous Page buttons are enabled and accessible when the page is at 1.");
			}else {
				logger.log(LogStatus.PASS, "Verified the First Page and Previous Page buttons are not enabled and not accessible");
			} }
		
		logger.log(LogStatus.INFO, "Verifying the Next and Last buttons of the pagination is enabled or disabled");
			
		if(myEng.verifyNextPageEnabled()&&myEng.verifyLastPageEnabled()) {
				logger.log(LogStatus.PASS, "Verified the Next Page and Last Page buttons are enabled and accessible");
		}else {
				logger.log(LogStatus.FAIL, "Next Page and Last Page buttons are not enabled and so cannot navigate to next page");
		} 
			
		logger.log(LogStatus.INFO, "User clicks on Page 2 and then verifies the pagination");
		if(myEng.clickOnPage2()) {
			logger.log(LogStatus.PASS, "successfully navigated to page 2");
		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to page 2");
		}
		
		if(myEng.verifyFirstPageEnabled()&&myEng.verifyPreviousPageEnabled()) {
			logger.log(LogStatus.PASS, "First Page and Previous Page buttons are enabled and accessible when the page is at 2.");
		}else {
			logger.log(LogStatus.FAIL, "First Page and Previous Page buttons are not enabled when the page is at 2");
	  	}
			
		logger.log(LogStatus.INFO, "User clicks on previous page and then verifies the first page is navigated");
		if(myEng.clickOnPreviousPage()) {
			logger.log(LogStatus.PASS, "Successfully navigated to previous page");
		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to previous page.");
		}
		
		if(myEng.verifyFirstPageEnabled()&&myEng.verifyPreviousPageEnabled()) {
			logger.log(LogStatus.FAIL, "First Page and Previous Page buttons are enabled and accessible when the page is at 1.");
		}else {
			logger.log(LogStatus.PASS, "Page 1 navigated and verified the First Page and Previous Page buttons are not enabled and not accessible");
		}
			
		}
			lp.logout();
			extent.endTest(logger);	
		
	}
}