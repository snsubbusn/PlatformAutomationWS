package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CorporateDashboardPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_Dashboard_TC001_VerifyDashboard extends Action_Method {

	public void verifyCorpAdminDashboard() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		logger = extent.startTest("Verifying the Dashboard of Corporate Admin__CorpAdm_Dashboard_TC001_VerifyDashboard");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Corporate General");
		logger.setDescription("Corporate Admin verfies the dashboard and its details.");

		//Launcing the URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");

		//LoginPage Object creation
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as corporate admin
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button, Corporate Landing page displayed");
		
		CorporateDashboardPage dash = PageFactory.initElements(driver, CorporateDashboardPage.class);
		
		dash.clickOnDashboardTab();		
		Thread.sleep(1000);		
		String sub = dash.getGuranteedSubmissionsDetails();
		String onb = dash.getOnboardingDetails();
		setExceldata(Variables.testdata, Variables.SetData_Excel, "CorpDashGS", sub);
		setExceldata(Variables.testdata, Variables.SetData_Excel, "CorpDashGO", onb);
		
		
		if(sub.contains("Active")) {
			logger.log(LogStatus.PASS, "Navigated to Corporate Dashboard successfully");
			
			logger.log(LogStatus.PASS, "Details of Guaranteed Submissions are :-"+sub);
			logger.log(LogStatus.PASS, "Details of Onboarding details area :-"+onb);
			
		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to Corporate Dashboard");
		}
		
		lp.logout();
		
		extent.endTest(logger);
	
	
	}

}

