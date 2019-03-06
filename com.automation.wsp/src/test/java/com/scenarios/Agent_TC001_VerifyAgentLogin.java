package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC001_VerifyAgentLogin extends Action_Method{

	public void verifyAgencyPartnerLogin() throws InterruptedException {
		logger = extent.startTest("Agent_TC001_VerifyAgencyPartnerLogin");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner Validation");
		logger.setDescription("Agency Logs in and Verifies the details of tabs displayed for his view.");

		//Launching URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and the Login Page is displayed");


		//LoginPage Object creation
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as Agency Partner
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage, "Agency Email", "Agency Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button, Agency Partner Landing page is displayed");
	
		AgencyPartnerGenPage ag = PageFactory.initElements(driver, AgencyPartnerGenPage.class);
		
		if(ag.verifyAgentLogin()) {
			logger.log(LogStatus.PASS, "Verified the Agent has logged in successfully");
		}else {
			logger.log(LogStatus.FAIL, "Agency partner login failed. NewAssignments tab is not displayed.");
		}
		
		logger.log(LogStatus.INFO, "Verify the tabs and page layout of Agency Partner");
		
		StringBuilder s = ag.verifyAgentTabsandSubMenuPresent();
		
		if(!s.toString().isEmpty()) {
			logger.log(LogStatus.PASS, "The Tabs, Menu for Agency Partner are : "+s);
		}else {
			logger.log(LogStatus.FAIL, "No Tab or Sub Menu are displayed for Agency partner login");
		}
	
		logger.log(LogStatus.INFO, "Completed Agent login and verification of tabs present.");
	
		lp.logout();
		extent.endTest(logger);
	}

}
