package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ManageJobPage;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC011_VerifyJobsTabandCountsofJobs extends Action_Method{
	public void verifytheJobsTabandGetTheCountOfJobsInEachSection() throws InterruptedException {
		logger = extent.startTest("Verify the Jobs Tab by getting the count of Jobs present in each Job Section_TC011");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");

		WSAdminGenPage ws = PageFactory.initElements(driver, WSAdminGenPage.class);

		ManageJobPage mp = PageFactory.initElements(driver, ManageJobPage.class);
		if(mp.clickOnActiveJobs()) {
			logger.log(LogStatus.PASS, "Navigated to Active Jobs successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to Active Jobs page");
		}
		
		logger.log(LogStatus.INFO, "Get the total count of records present in the Active Jobs page");
	
   
		extent.endTest(logger);
		lp.logout();
	}

}
