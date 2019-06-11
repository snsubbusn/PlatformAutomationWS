package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminProxyPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdm_TC024_VerifytheAdminSelectsTheCorporateAndExitProxy extends Action_Method {

	public  void verifyProxyEntryExit() throws InterruptedException {

		logger = extent.startTest("WSAdm_TC024_VerifytheAdminSelectsTheCorporateAndExitProxy");
		logger.assignAuthor("Keerthana");
		logger.assignCategory("WSAdmin General");

		logger.setDescription("WS Admin Logs in and click on proxy and verify the proxy page and clicks on any proxy corporate card and clicks on back button,verifies the navigation of pages.");


		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and the Login Page is displayed");
		
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		
		WSAdminProxyPage ws = PageFactory.initElements(driver, WSAdminProxyPage.class);
		ws.acceptCookie();
		
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");
		
		logger.log(LogStatus.PASS, "Click on \"Proxy\" Tab");
		 
		Thread.sleep(6000);
		if(ws.clickonProxy()) {
			logger.log(LogStatus.PASS, "Proxy Page is displayed successfully");
		}
		else {
			logger.log(LogStatus.FAIL, "Failed to Navigate to \"Proxy \" page.");
		}
		
		if(!ws.verifyProxyCard()) {
			logger.log(LogStatus.FAIL,"No proxy corporate cards are viewed");
		} else {		
			logger.log(LogStatus.PASS, "proxy corporate cards are viewed");
		
			String corp = ws.getFirstProxyCard();
			
			if(ws.clickOnFirstProxyCard() ) {
				logger.log(LogStatus.PASS, "Successfully clicked on first proxy card and navigated to 'Active Jobs' page of that respective proxy");
			} else {
				logger.log(LogStatus.FAIL, "Failed to Navigate to Active Jobs page of the respective proxy.");
			}
			Thread.sleep(5000);
			String corpTab = ws.getProxyCorpTab() ; 
			
			if(corp.equalsIgnoreCase(corpTab)) {
				logger.log(LogStatus.PASS, "Successfully Active Jobs page displayed matches with the first proxy card  selected ");
			} else {
				logger.log(LogStatus.FAIL,"Failed to display the Active jobs page of the selected proxy corporate card");
			}
			
			if(ws.clickOnBackButton()) {
				logger.log(LogStatus.PASS,"Successfully clicked on back button");
			} else {		
				logger.log(LogStatus.FAIL, "Failed to navigate to proxy page");
			}
			Thread.sleep(5000);
			String pro = ws.getProxyCorpTab();
			
			if(pro.contains("Proxy")) {
				logger.log(LogStatus.PASS,"Successfully navigated to proxy page,clicked on back button.");
			}else {
				logger.log(LogStatus.FAIL,"Failed to navigate to proxy page");
			}
		
	}

		logger.log(LogStatus.INFO,"Verified the WS Admin Login and Proxy corporate Entry and Exit");
		extent.endTest(logger);
		
		lp.logout();
	}
}
