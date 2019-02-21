package com.scenarios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminUsersPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC015_AddNewAdminUser extends Action_Method{
	public void verifyAddingNewUser() throws InterruptedException {
		logger = extent.startTest("WS Admin Users Tab - Verifying Adding new WS Admin user in Add User Page.");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");

		WSAdminUsersPage ws = PageFactory.initElements(driver, WSAdminUsersPage.class);
		logger.log(LogStatus.INFO, "Verify the Users Tab of WS Admin");

		ws.clickOnUsersTab();
		logger.log(LogStatus.PASS, "Navigated to Users Tab");
		
		logger.log(LogStatus.INFO, "Click on Add Button and verify the Add User page is navigated");
		
		ws.clickOnAddButton();

		String ur = ws.verifyAddUserPage();
		if(ur.contains("Add User")) {
			logger.log(LogStatus.PASS, "Add Button clicked and the page navigated to "+ur+" page successfully");
		}else {
			logger.log(LogStatus.FAIL, "Add Button clicked and failed to navigate to \"Add Users\" page.");
		}
		
		logger.log(LogStatus.INFO, "Add new Admin User and verify the user details are displayed");
		
		ws.addAdminUser();
		String name = ws.getFirstUserCardName();
		String email = ws.getFirstUserCardEmail();
		String phone = ws.getFirstUserCardPhone();
		
		if(!name.isEmpty()&&!email.isEmpty()&&!phone.isEmpty()) {
			logger.log(LogStatus.PASS, "New User has been added successfully. the details are :"+name+"; "+email+"; and "+phone);
		}else {
			logger.log(LogStatus.FAIL, "Failed to add new admin user");
		}
		
		
		logger.log(LogStatus.INFO, "Verified the Addition of new admin user successfully");
		lp.logout();
		extent.endTest(logger);

	}
}
