package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ManageJobPage;
import com.objects_pages.WSAdminProxyPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC028_AdminProxySelectsandVerifyClosedJobsPage extends Action_Method{
	
	public void verifyClosedjobsPageofProxy() throws InterruptedException {
		logger = extent.startTest("WSAdm_TC028_AdminProxySelectsandVerifyClosedJobsPage");
		logger.assignAuthor("Keerthana");
		logger.assignCategory("WSAdmin General");

		logger.setDescription("WS Admin Logs in and click on proxy and verify the proxy page and clicks on any proxy corporate card and navigates to closed jobs page, gets the first closed job card details sort by `updated Date` `Posted Date` and `Title`.");

		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and the Login Page is displayed");

		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");

		logger.log(LogStatus.PASS, "Click on \"Proxy\" Tab");

		WSAdminProxyPage ws = PageFactory.initElements(driver, WSAdminProxyPage.class);
		
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

			if(ws.clickOnFirstProxyCard() ) {
				logger.log(LogStatus.PASS, "Successfully clicked on first proxy card and navigated to 'Active Jobs' page of that respective proxy");
			} else {
				logger.log(LogStatus.FAIL, "Failed to Navigate to Active Jobs page of the respective proxy.");
			}
			if(ws.activeJobsDisplayed() ) {
				logger.log(LogStatus.PASS, "Active job page displayed successfully");
			
			if(ws.clickOnClosedJobs()) {
				logger.log(LogStatus.PASS, "Closed Jobs Page is displayed successfully");
			}
			else {
				logger.log(LogStatus.FAIL, "Failed to Navigate to \"Closed Jobs \" page.");
			}
			
			logger.log(LogStatus.INFO, "Verifying details of Closed Jobs page");
			
			if(!ws.verifyProxyCard()) {
				logger.log(LogStatus.FAIL,"No Closed job cards  viewed");
			} else {		
				logger.log(LogStatus.PASS, "Pagination and Closed job cards are viewed");
				
				String record = ws.getTotalRecordsofthePage();
				
				if(!record.isEmpty()) {
					logger.log(LogStatus.PASS, "There are "+record+" job cards  in the \"Closed Jobs \" Page");
				}else {
					logger.log(LogStatus.FAIL, "There are no records in the \"Closed Jobs \" page");
				}
				
				String rec = ws.getDefaultItemsPerPage();
				int count = Integer.parseInt(rec);
				if(count >= 1) {
					logger.log(LogStatus.PASS, "Multiple job cards are viewed in Closed Jobs page");
					
					logger.log(LogStatus.INFO, "Getting first job card details sort by `updated Date`");
					
					if(ws.clickOnUpdatedDate()) {
						
						String updatedJobDetails =ws.getFirstActiveProxyCardDetails();
						
						logger.log(LogStatus.PASS, "The Job title is "+updatedJobDetails+" of the first proxy\"Closed Job \" card sort by 'updated Date`");
					}else {
						logger.log(LogStatus.FAIL, "Failed to get jobdetails of the first Closed job card sort by `updated Date`");
					}
					
					logger.log(LogStatus.INFO, "Getting first job card details sort by `posted Date`");
					
					if(ws.clickOnPostedDate()) {
						
						String postedJobDetails =  ws.getFirstActiveProxyCardDetails();
					
						logger.log(LogStatus.PASS, "The Job title is "+postedJobDetails+" of the first proxy\"Closed Job \" card sort by `posted Date`");
					}else {
						logger.log(LogStatus.FAIL, "Failed to get jobdetails of the first Closed job card sort by `posted Date`");
					}
					
					logger.log(LogStatus.INFO, "Getting first job card details sort by `Title`");
					
					if(ws.clickOnTitle()) {
						
						String titledJobDetails =  ws.getFirstActiveProxyCardDetails();
					
						logger.log(LogStatus.PASS, "The Job title is "+titledJobDetails+" of the first proxy\"Closed Job \" card sort by `Title`");
					}else {
						logger.log(LogStatus.FAIL, "Failed to get jobdetails of the first new job card sort by `Title`");
					}
				}else {
					logger.log(LogStatus.FAIL, "No Closed Jobs cards present");
			}
		}
			}else {
				logger.log(LogStatus.FAIL, "Failed to display Active Jobs page");
			}
		}
		logger.log(LogStatus.INFO,"Verified the WS Admin Login and Proxy Closed Jobs  Page details");
		extent.endTest(logger);

		lp.logout();
	}
	
}



