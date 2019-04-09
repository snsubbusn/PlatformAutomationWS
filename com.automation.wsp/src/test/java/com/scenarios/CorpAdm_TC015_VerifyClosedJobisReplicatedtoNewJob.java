package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ManageResponsesPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_TC015_VerifyClosedJobisReplicatedtoNewJob extends Action_Method{
	public void verifyClosedJobisReplicatedtoNewJob() throws InterruptedException {
		logger = extent.startTest(this.getClass().getSimpleName());
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Corporate General");
		logger.setDescription("Corporate Logs in and clicks on Closed Jobs. Select 'Replicate' of any job "
				+ "Verify the job is replicated and a new job is created in New Jobs");

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

		String firstJob = man.getFirstJobId();
		if(!firstJob.equals("NoJob")) {
			logger.log(LogStatus.PASS, "The first GO job under Closed job is - "+firstJob);

			String rep = man.clickOnReplicateofCampaign(firstJob);
			if(!rep.contains("Failed")) {
				logger.log(LogStatus.PASS, "Clicked on Replicate of the Job and the msg is - "+rep);
			}else {
				logger.log(LogStatus.FAIL, "Failed to Replicate. The msg is - "+rep);
			}
		}else {
			logger.log(LogStatus.WARNING, "No Job in Closed Job Page."+firstJob);
		}
		logger.log(LogStatus.INFO, "Completed verifying the Replicate job from Closed Job page");

		lp.logout();
		extent.endTest(logger);
	}
}
