package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.EngageAgencyPartnersPage;
import com.objects_pages.ManageResponsesPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_TC014_VerifyClosedJobisRestartedforGO extends Action_Method{
	public void verifyClosedJobisRestartedforGO() throws InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Corporate General");
		logger.setDescription("Corporate Logs in and clicks on Closed Jobs. Select a GO job and click on 'Restart'. "
				+ "Confirms the GO payment and start a new Campaig. Verify the job is present under Active Jobs");

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

		String firstgoJob = man.findJobIdofFirstGSorGO("go");
		if(!firstgoJob.equals("NoJob")) {
			logger.log(LogStatus.PASS, "The first GO job under Closed job is - "+firstgoJob);

			if(man.clickOnRestartGSorGOCampaign(firstgoJob)) {
				logger.log(LogStatus.PASS, "Clicked on Restart of the GO successfully");
			}else {
				logger.log(LogStatus.FAIL, "Failed to click on Restart of GO Campaign");
			}
			
			EngageAgencyPartnersPage en = PageFactory.initElements(driver, EngageAgencyPartnersPage.class);
					
			if(en.EnterPaymentForGuaranteedOnboarding("1").contains("Pass")) {
				logger.log(LogStatus.PASS, "Entered the GO details and restarted the campaign");
			}else {
				logger.log(LogStatus.FAIL, "Failed to enter GO Details and restart the campaign");
			}

			
			logger.log(LogStatus.INFO, "After the Restart the job has been moved to Active Jobs Page");
			
			if(man.verifyJobisPresent(firstgoJob)) {
				logger.log(LogStatus.PASS, "The Job has been successfully restarted and the Job id is present in the Active job Page");
			}else {
				logger.log(LogStatus.FAIL, "The Job id is not found in the Active Job Page");
			}
		}else {
			logger.log(LogStatus.WARNING, "No GO Job in Closed Job Page."+firstgoJob);
		}
		logger.log(LogStatus.INFO, "Completed verifying the Restarting a GO from Closed Job page");

		lp.logout();
		extent.endTest(logger);
	}
}
