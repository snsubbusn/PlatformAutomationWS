package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ManageResponsesPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_TC010_VerifyActiveJobMovedtoOnHoldJob extends Action_Method{
	public void verifyActiveJobMovedtoOnHoldJob() throws InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Corporate General");
		logger.setDescription("Corporate Logs in and clicks on Active Jobs. Select any job and click on 'On Hold Jobs'. "
				+ "Confirms the movement of job to on hold. Verify the success msg and navigates to On Hold Jobs."
				+ "Verify the job has been moved to OnHold Job");

		//Launching URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and the Login Page is displayed");

		//LoginPage Object creation
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button, Corporate Landing page displayed");

		ManageResponsesPage man = PageFactory.initElements(driver, ManageResponsesPage.class);

		if(man.Click_On_ActiveJobs()) {
			logger.log(LogStatus.PASS, "Nagvigated to Active Jobs Page");
		}else{
			logger.log(LogStatus.FAIL, "Failed to navigate to Active Jobs Page");
		}

		String secJob = man.getSecondJobId();
		if(!secJob.equals("NoJob")) {
			logger.log(LogStatus.PASS, "The Second Job card under Active Job is - "+secJob);

			String msg = man.clickOnOnHoldandVerifySuccessMsg(secJob);

			if(msg.contains("success")) {
				logger.log(LogStatus.PASS, "Moved the Job to OnHold and the message is - "+msg);
			}else {
				logger.log(LogStatus.FAIL, "Failed to move the job to on hold. Msg is - "+msg);
			}

			logger.log(LogStatus.INFO, "Verify the job card is present in the On Hold Jobs Page");

			if(man.Click_On_OnHoldJobs()) {
				logger.log(LogStatus.PASS, "Navigated to On Hold Jobs");
			}else {
				logger.log(LogStatus.FAIL, "Failed to navigate to ON Hold Jobs page");
			}

			if(man.verifyJobisPresent(secJob)) {
				logger.log(LogStatus.PASS, "Job card is verified under On Hold Jobs Page");
			}else {
				logger.log(LogStatus.FAIL, "Job card is not under On Hold Jobs Page");
			}
		}else {
			logger.log(LogStatus.FAIL, "No Job under Active Jobs Page");
		}
		logger.log(LogStatus.INFO, "Completed verifying the Job moved to On hold Jobs page");

		lp.logout();
		extent.endTest(logger);
	}
}
