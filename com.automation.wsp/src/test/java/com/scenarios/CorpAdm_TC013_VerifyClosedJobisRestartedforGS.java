package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.EngageAgencyPartnersPage;
import com.objects_pages.ManageResponsesPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_TC013_VerifyClosedJobisRestartedforGS extends Action_Method{
	public void verifyClosedJobisRestartedforGS() throws InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Corporate General");
		logger.setDescription("Corporate Logs in and clicks on Closed Jobs. Select a GS job and click on 'Restart'. "
				+ "Confirms the GS payment and start a new Campaig. Verify the job is present under Active Jobs");

		//Launching URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and the Login Page is displayed");

		//LoginPage Object creation
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button, Corporate Landing page displayed");

		ManageResponsesPage man = PageFactory.initElements(driver, ManageResponsesPage.class);

		if(man.Click_On_closedJobs()) {
			logger.log(LogStatus.PASS, "Nagvigated to Closed Jobs Page");
		}else{
			logger.log(LogStatus.FAIL, "Failed to navigate to Closed Jobs Page");
		}

		String firstgsJob = man.findJobIdofFirstGSorGO("gs");
		if(!firstgsJob.contains("NoJob")) {
			logger.log(LogStatus.PASS, "The first GS job under Closed job is - "+firstgsJob);

			if(man.clickOnRestartGSorGOCampaign(firstgsJob)) {
				logger.log(LogStatus.PASS, "Clicked on Restart of the GS successfully");
			}else {
				logger.log(LogStatus.FAIL, "Failed to click on Restart of GS Campaign");
			}
			
			EngageAgencyPartnersPage en = PageFactory.initElements(driver, EngageAgencyPartnersPage.class);
					
			if(en.Get_Estimate()) {
				logger.log(LogStatus.PASS, "Entered the GS details and estimate is calculated");
			}else {
				logger.log(LogStatus.FAIL, "Failed to enter GS Details and estimate");
			}

			if(en.Aaccept_To_Pay_Later()){
				logger.log(LogStatus.PASS, "GS campaign has been restarted successfully");
			}else {
				logger.log(LogStatus.FAIL, "Failed to accept to pay later and not able to restart the GS Campaign");
			}
			
			logger.log(LogStatus.INFO, "After the Restart the job has been moved to Active Jobs Page");
			
			if(man.verifyJobisPresent(firstgsJob)) {
				logger.log(LogStatus.PASS, "The Job has been successfully restarted and the Job id is present in the Active job Page");
			}else {
				logger.log(LogStatus.FAIL, "The Job id is not found in the Active Job Page");
			}
		}else {
			logger.log(LogStatus.WARNING, "No GS Job in Closed Job Page."+firstgsJob);
		}
		logger.log(LogStatus.INFO, "Completed verifying the Restarting a GS from Closed Job page");

		lp.logout();
		extent.endTest(logger);
	}
}
