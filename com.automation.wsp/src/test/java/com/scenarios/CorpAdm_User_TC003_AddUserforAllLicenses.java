package com.scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CorporateAdmin_UserManagement_Page;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_User_TC003_AddUserforAllLicenses extends Action_Method{
	public void addCorpUsersforAllLicenses() throws InterruptedException {
		logger = extent.startTest("CorporateAdminUserManagement_TC003_AddUserforAllLicense");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("CorporateAdmin UserManagement");
		logger.setDescription("Corporate admin adds corporate users for all the available Licenses");

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

		if(used<total) {
			logger.log(LogStatus.PASS, "Verify the Pending Licenses, Verified the remaining licenses and the corporate admin can create "+(total-used)+" corporate users");

			for(int i=used;i<total;i++) {
				String add = user.clickonAddButton();
				if(add.contains("Add User")) {
					logger.log(LogStatus.PASS, "Click on Add icon, Clicked on Add icon and the screen navigated to 'Add User' page.");
				}else {
					logger.log(LogStatus.FAIL,"Click on Add icon, Click on Add icon failed to navigate to 'Add User' page");
				}
				//Adding User
				user.addCorporateUser(i+1);
				logger.log(LogStatus.INFO, "Added new Corporate user successfully");
				String userna = user.getFirstUserCardName();
				if(userna.equalsIgnoreCase("Automate"+(i+1))) {
					logger.log(LogStatus.PASS, "Verify the new user, Corporate user added successfully and verified the new user. The Last added user name is "+userna);
				}else {
					logger.log(LogStatus.FAIL, "Verify the new user, Corporate user failed to add and the last added user is "+userna);
				}
			}
			
		}else {
			logger.log(LogStatus.FAIL, "Verify the Pending Licenses, Corporate admin have used all the available licenses and cannot add any more users");
		}
		
		List <String> li1 = user.getLicensesCount();
		int used1 = Integer.parseInt(li1.get(0));
		int total1 = Integer.parseInt(li1.get(1));

		logger.log(LogStatus.INFO,"The corporate has totally "+total1+" licenses. Out of which "+used1+" licenses have been used.");

		//To Verify the error produced license count is exceeded
		String add = user.clickonAddButton();
		if(add.contains("Add User")) {
			logger.log(LogStatus.PASS, "Click on Add icon, Clicked on Add icon and the screen navigated to 'Add User' page.");
		}else {
			logger.log(LogStatus.FAIL,"Click on Add icon, Click on Add icon failed to navigate to 'Add User' page");
		}
		//Adding User
		user.addCorporateUser(used1+1);
		String err = user.getErrorforAllLicenseUsed();
		if(err.contains("You have used up")) {
			logger.log(LogStatus.PASS, "Check for Error, Verified the error when Corp Admin tries the add more users than the available license. The error is "+err);
		}else {
			logger.log(LogStatus.FAIL, "Check for Error, Unable to capture the error."+err);
		}
		logger.log(LogStatus.INFO, "Added all Corporate user successfully");
		
		logger.log(LogStatus.INFO, "Corporate admin adds corporate users for all the available Licenses has been completed");

		lp.logout();
		extent.endTest(logger);
	}
}
