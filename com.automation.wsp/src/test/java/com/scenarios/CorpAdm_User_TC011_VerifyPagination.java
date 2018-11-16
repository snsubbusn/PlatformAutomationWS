package com.scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CorporateAdmin_UserManagement_Page;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_User_TC011_VerifyPagination extends Action_Method {
	public void verifyPagination() throws InterruptedException {
		logger = extent.startTest("Verify Pagination of User Management__CorporateAdminUserManagement_TC011", "Corporate Admin verifies the pagination after checking the licenses used");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		//Launcing the URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");

		//LoginPage Object creation
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as corporate admin
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button, Corporate Landing page displayed");

		CorporateAdmin_UserManagement_Page user = PageFactory.initElements(driver, CorporateAdmin_UserManagement_Page.class);

		String license = user.clickOnUsersTab();
		if(license.contains("licenses used")) {
			logger.log(LogStatus.PASS, "Click on Users Tab, Clicked on Users tab and the licenses details are displayed as "+license);
		}else {
			logger.log(LogStatus.FAIL, "Click on Users Tab, Clicked on Users tab but not navigated to Users page");
		}
		List <String> li = user.getLicensesCount();
		int used = Integer.parseInt(li.get(0));
		int total = Integer.parseInt(li.get(1));

		logger.log(LogStatus.INFO, "Verifying the total licenses to validate the pagination");
		if(total>9) {
			logger.log(LogStatus.PASS, "Pagination can be validated as the total license - "+total+" allows the pagination enabled to validate");
		}else {
			logger.log(LogStatus.FAIL, "Pagination cannot be validated as there are only "+total+" licenses can be added and it doesnot allow pagination.");
		}

		logger.log(LogStatus.INFO, "Verifying the used licenses to validate the pagination");
		if(used>9) {
			logger.log(LogStatus.PASS, "Pagination can be validated as the used license - "+used+" is greater than 9 and pagination is enabled to validate");
			
			logger.log(LogStatus.INFO, "Verifying the First and Previos buttons of the pagination is enabled or disabled");
			if(user.verifyFirstPageEnabled()&&user.verifyPreviousPageEnabled()) {			
				logger.log(LogStatus.FAIL, "First Page and Previous Page buttons are enabled and accessible when the page is at 1. This is an issue");
			}else {
				logger.log(LogStatus.PASS, "Verified the First Page and Previous Page buttons are not enabled and not accessible");
			}
		
			logger.log(LogStatus.INFO, "Verifying the Next and Last buttons of the pagination is enabled or disabled");
			
			if(user.verifyNextPageEnabled()&&user.verifyLastPageEnabled()) {
				logger.log(LogStatus.PASS, "Verified the Next Page and Last Page buttons are enabled and accessible");
			}else {
				logger.log(LogStatus.FAIL, "Next Page and Last Page buttons are not enabled and so cannot navigate to next page");
			}
			
			logger.log(LogStatus.INFO, "User clicks on Page 2 and then verifies the pagination");
			user.clickOnPage2();
			if(user.verifyFirstPageEnabled()&&user.verifyPreviousPageEnabled()) {
				logger.log(LogStatus.PASS, "First Page and Previous Page buttons are enabled and accessible when the page is at 2.");
			}else {
				logger.log(LogStatus.FAIL, "First Page and Previous Page buttons are not enabled when the page is at 2. This is an issue");
			}
			
			logger.log(LogStatus.INFO, "User clicks on previous page and then verifies the first page is navigated");
			user.clickOnPreviousPage();
			if(user.verifyFirstPageEnabled()&&user.verifyPreviousPageEnabled()) {
				logger.log(LogStatus.FAIL, "First Page and Previous Page buttons are enabled and accessible when the page is at 1. This is an issue");
			}else {
				logger.log(LogStatus.PASS, "Page 1 navigated and verified the First Page and Previous Page buttons are not enabled and not accessible");
			}
			
			
		}else {
			logger.log(LogStatus.FAIL, "Pagination cannot be validated as there are only "+used+" licenses added and it doesnot allow pagination.");
		}
		
		logger.log(LogStatus.INFO, "Verified the Pagination functionality");
		
		lp.logout();
		
		extent.endTest(logger);

	}

}
