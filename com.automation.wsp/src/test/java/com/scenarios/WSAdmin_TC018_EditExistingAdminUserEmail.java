package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminUsersPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC018_EditExistingAdminUserEmail extends Action_Method{
	public void verifyEditingExistingAdminUserEmail() throws InterruptedException {
		logger = extent.startTest("WS Admin Users Tab - Verifying Editing Existing WS Admin user Email in Edit User Page.");
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
		
		logger.log(LogStatus.INFO, "Click on Edit Button and verify the Edit User page is navigated");
		
		
		String edit = ws.clickOnFirstUserCardEdit();
		if(edit.contains("Edit")) {
			logger.log(LogStatus.PASS, "Clicked on Edit button of the first admin user card and \"Edit User\" page is displayed");
		}else {
			logger.log(LogStatus.FAIL, "Clicked on Edit button of the first admin user card but failed to navigate to \"Edit User\" page");
		}
		
		logger.log(LogStatus.INFO, "Edit the Email of the First Admin user");
		
	
		String na = "";
		try{
			na = ws.editEmailId();
		}catch(Exception e) {
			na = "edit failed";
		}
		if(na.contains("failed")) {
			logger.log(LogStatus.FAIL, "Failed to edit the Email of the admin user");
		}else {
			logger.log(LogStatus.PASS, "Edited the Email of the admin user successfully");
		}
		
		logger.log(LogStatus.INFO, "Verified editing existing admin user Email successfully");
		lp.logout();
		extent.endTest(logger);

	}
}
