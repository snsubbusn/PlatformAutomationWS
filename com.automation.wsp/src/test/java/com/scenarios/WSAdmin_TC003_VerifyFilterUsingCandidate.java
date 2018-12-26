package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC003_VerifyFilterUsingCandidate extends Action_Method{
	public void verifyInvitePageFilterByCandidate() throws InterruptedException {
		logger = extent.startTest("Verifying the Invite Page using Filter By Candidate_TC003");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		

		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");
		
		WSAdminGenPage ws = PageFactory.initElements(driver, WSAdminGenPage.class);
		
		String def = ws.getDefaultFilterValue();
		if(def.contains("All")) {
			logger.log(LogStatus.PASS, "Verified the default Filter By value is \""+def+"\"");
		}else {
			logger.log(LogStatus.FAIL, "The Default Filter By value is not 'All'. It is "+def);
		}
		
		logger.log(LogStatus.INFO, "Select the Candidate from the 'Filter By' drop down menu");
		
		logger.log(LogStatus.INFO, "Change the Filter By to 'Candidate'");
		String can = ws.filterCandidate();
		if(can.contains("Candidate")) {
			logger.log(LogStatus.PASS, "Filter By value is changed to "+can);
		}else {
			logger.log(LogStatus.FAIL, "The Filter By value is not changed to 'Candidate'. It is "+can);
		}
		
		int c = ws.getCountOfCandidates();
		
		logger.log(LogStatus.PASS, "The Candidate Filter applied successfully and the total no of candidates displayed in first page is "+c);

		logger.log(LogStatus.INFO, "Verified the filter for candidate");
		
		extent.endTest(logger);
		lp.logout();
	}

}
