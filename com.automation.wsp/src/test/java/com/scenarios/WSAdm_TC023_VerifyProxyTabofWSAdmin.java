package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.WSAdminProxyPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdm_TC023_VerifyProxyTabofWSAdmin extends Action_Method {
	public void verifyProxyPage() throws InterruptedException {
		
		logger = extent.startTest("WSAdm_TC023_VerifyProxyTabofWSAdmin");
		logger.assignAuthor("Keerthana");
		logger.assignCategory("WSAdmin General");

		logger.setDescription("WS Admin Logs in and click on proxy and verify the items per page default value and  verify the total count of proxy corporate cards  displayed matches with the selected value and also verifies pagination for proxy.");


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
			
			if(ws.ClickOn_ItemsPerPage()) {
				logger.log(LogStatus.PASS, "Items per page drop down is displayed successfully");
			}else {
				logger.log(LogStatus.FAIL, "Failed to display drop down of Items per page.");
			}
			
			if(ws.verifyPagination())
			{	
				logger.log(LogStatus.PASS, "Pagination is displayed successfully");
			}else {
				logger.log(LogStatus.FAIL, "Failed to display pagination.");
			}
			
			String defItem = ws.getDefaultItemsPerPage();

			logger.log(LogStatus.PASS, "Default Item value displayed is"+defItem+" from Items per page drop down");
			
			if(!defItem.isEmpty()) {
				logger.log(LogStatus.PASS, "There are "+defItem+" corporate cards in the \"Proxy \" Page");
			}
			else {
				logger.log(LogStatus.FAIL, "Failed to display default  Item from  drop down of Items per page.");
			}
			
			if(ws.select32ItemsPerPage()) {
				logger.log(LogStatus.PASS, "32 is selected as item value in drop down of items per page in the \"Proxy \" Page");
				
				String rec = ws.getTotalRecordsofthePage();
				
				if(!rec.isEmpty()) {
					logger.log(LogStatus.PASS, "There are "+rec+" corporate cards in the \"Proxy \" Page");
				}
			}
			else {
				logger.log(LogStatus.FAIL, "There are no records in the \"Proxy \" page");
			}
			
			if(ws.verifyLastPageEnabled()) {
				logger.log(LogStatus.PASS, "Verified the  Last Page button are enabled and accessible");
			}else {
				logger.log(LogStatus.FAIL, " Last Page button is not enabled and so cannot navigate to next page");
			} 
			
			if(ws.verifyFirstPageEnabled() ) {
				logger.log(LogStatus.PASS, "Verified first page button is enabled and accessible");
			}else {
				logger.log(LogStatus.FAIL, "first Page button is not enabled and so cannot navigate to next page");
			} 
			
		}
		
		logger.log(LogStatus.INFO,"Verified the WS Admin Login and Proxy Page details");
		extent.endTest(logger);
		
		lp.logout();
		
	}

}
