package com.scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CorporateAdmin_UserManagement_Page;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_User_TC001_VerifyUsersTab extends Action_Method{
	public void checkUserTabandLicenseofCorpAdmin() throws InterruptedException {
		logger = extent.startTest("CorporateAdminUserManagement_TC001_VerifyUsersTab");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("CorporateAdmin UserManagement");
		logger.setDescription("Corp Admin Log in and verify for the user tab and License count");

		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");

		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

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
		
		if(used==0) {
			if(user.verifyEmptyUsersPage()==true) {
				logger.log(LogStatus.PASS, "Check for no users page, 'No Users' Image is displayed has been verified");
			}else {
				logger.log(LogStatus.FAIL, "Check for no users page, 'No Users' image is not displayed");
			}
		}else {
			if(user.verifyFirstUserCard()==true) {
				logger.log(LogStatus.PASS, "Check for User card, First User card is present under the Users Page");
			}else {
				logger.log(LogStatus.FAIL, "Check for User card, No User card is displayed under User Page");
			}			
		}
		
		logger.log(LogStatus.INFO,"The corporate has totally "+total+" licenses. Out of which "+used+" licenses have been used.");
		
		if(user.verifyAddButton()==true) {
			logger.log(LogStatus.PASS, "Verify Add Button, Verified the Add button icon is displayed");
		}else {
			logger.log(LogStatus.FAIL, "Verify Add Button, Add button icon is not displayed");
		}
		
		String add = user.clickonAddButton();
		
		if(add.contains("Add User")) {
			logger.log(LogStatus.PASS, "Click on Add icon, Clicked on Add icon and the screen navigated to 'Add User' page.");
		}else {
			logger.log(LogStatus.FAIL,"Click on Add icon, Click on Add icon failed to navigate to 'Add User' page");
		}
		
		logger.log(LogStatus.INFO, "Verifying the 'Users' tab, add icon and licenses have been completed.");
		
		lp.logout();
		extent.endTest(logger);
	}
	
}
