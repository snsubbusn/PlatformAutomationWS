package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Candidate_MyEngagementsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC012_VerifyItemsPerPage extends Action_Method {
	public void VerifyItemsPerPage() throws InterruptedException {

		logger = extent.startTest("Candidate_TC012_VerifyItemsPerPage");
		logger.assignAuthor("Keerthana");
		logger.assignCategory("Candidate General");

		logger.setDescription("Candidate Logs in and click on My Engagements and verify the items per page default value and  verify the total count of Jobs displayed matches with the selected value.");


		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and the Login Page is displayed");


		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as  candidate
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage, "Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Candidate Profile Landing page is displayed");

		Candidate_MyEngagementsPage myEng = PageFactory.initElements(driver,Candidate_MyEngagementsPage.class);

		if(myEng.VerifyCandidateLogin()) {
			logger.log(LogStatus.PASS, "Verified the Candidate has logged in successfully");
		}
		else {
			logger.log(LogStatus.FAIL, "Candidate login failed. candidate profile tab is not displayed.");
		}

		logger.log(LogStatus.PASS, "Click on \"My Engagements\" Tab");
		myEng.ClickOn_MyEngagementsTab();

		String vme = myEng.VerifyMyEngagementsPage();
		if(vme.contains("My Engagements")) {
			logger.log(LogStatus.PASS, "My Engagements Page is displayed successfully");
		}
		else {
			logger.log(LogStatus.FAIL, "Failed to Navigate to \"My Engagements\" page.");
		}

		if(myEng.ClickOn_ItemsPerPage())
		{
			logger.log(LogStatus.PASS, "Items per page drop down is displayed successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to display drop down of Items per page.");
		}

		String defItem = myEng.getDefaultItemsPerPage();

		logger.log(LogStatus.PASS, "Default Item value displayed is"+defItem+" from Items per page drop down");
		if(!defItem.isEmpty()) {
			logger.log(LogStatus.PASS, "There are "+defItem+" Jobs in the \"My Engagements\" Page");
		}
		else {
			logger.log(LogStatus.FAIL, "Failed to display default  Item from  drop down of Items per page.");
		}

		if(myEng.select36ItemsPerPage())
		{
			logger.log(LogStatus.PASS, "36 is selected as item value in drop down of items per page in the \"My Engagements\" Page");
			String rec = myEng.getTotalRecordsofthePage();
			if(!rec.isEmpty()) {
				logger.log(LogStatus.PASS, "There are "+rec+" Jobs in the \"My Engagements\" Page");
			}
		}
		else {
			logger.log(LogStatus.FAIL, "There are no records in the \"My Engagements\" page");
		}

		lp.logout();
		extent.endTest(logger);	

	}
}

