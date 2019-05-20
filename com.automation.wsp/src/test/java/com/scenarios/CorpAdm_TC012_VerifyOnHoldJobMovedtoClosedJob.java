package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ManageResponsesPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_TC012_VerifyOnHoldJobMovedtoClosedJob extends Action_Method{
	public void verifyOnHoldJobMovedtoClosedJob() throws InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Corporate General");
		logger.setDescription("Corporate Logs in and clicks on OnHold Jobs. Select any job and click on 'Close Job'. "
				+ "Confirms the movement of job to Closed Jobs Page. Verify the success msg and navigates to Closed Jobs."
				+ "Verify the job has been moved to Closed Job");

		//Launching URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and the Login Page is displayed");

		//LoginPage Object creation
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button, Corporate Landing page displayed");

		ManageResponsesPage man = PageFactory.initElements(driver, ManageResponsesPage.class);

		if(man.Click_On_OnHoldJobs()) {
			logger.log(LogStatus.PASS, "Nagvigated to OnHold Jobs Page");
		}else{
			logger.log(LogStatus.FAIL, "Failed to navigate to OnHold Jobs Page");
		}

		String firstJob = man.getFirstJobId();
		if(!firstJob.contains("NoJob")) {
			logger.log(LogStatus.PASS, "The First Job card under OnHold Job is - "+firstJob);


			String msg = man.clickOnCloseandVerifySuccessMsg(firstJob);

			if(msg.contains("success")) {
				logger.log(LogStatus.PASS, "Job Closed successfully and the message is - "+msg);
			}else {
				logger.log(LogStatus.FAIL, "Failed to close the job. Msg is - "+msg);
			}

			if(man.Click_On_closedJobs()) {
				logger.log(LogStatus.PASS, "Navigated to Closed Jobs");
			}else {
				logger.log(LogStatus.FAIL, "Failed to navigate to Closed Jobs");
			}

			logger.log(LogStatus.INFO, "Verify the job card is present in the Closed Jobs Page");


			if(man.verifyJobisPresent(firstJob)) {
				logger.log(LogStatus.PASS, "Job card is verified under Closed Jobs Page");
			}else {
				logger.log(LogStatus.FAIL, "Job card is not under Closed Jobs Page");
			}
		}else {
			logger.log(LogStatus.WARNING, "No Job in OnHold Job Page."+firstJob);
		}
		logger.log(LogStatus.INFO, "Completed verifying the Job Closed from On hold Jobs and moved to Closed Jobs page");

		lp.logout();
		extent.endTest(logger);
	}
}
