package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminUsersPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC020_DeleteFirstAdminUser extends Action_Method{
	public void verifyDeletingFirstAdminUser() throws InterruptedException {
		logger = extent.startTest("WSAdmin_TC020_DeleteFirstAdminUser");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("WSAdmin UserManagement");
		logger.setDescription("Login as WS Admin, WS Admin Users Tab - Verifying Deleting the first WS Admin user");
		

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
		
		logger.log(LogStatus.INFO, "Click on Delete button of the First Admin User and confirm");
		
		
		String delete = ws.deleteFirstUser();
		if(delete.contains("Deleted")) {
			logger.log(LogStatus.PASS, "Deleted the first user successfully and the message is :"+delete);
		}else {
			logger.log(LogStatus.FAIL, "Failed to delete the first ws admin user");
		}
		
		logger.log(LogStatus.INFO, "Verified Deleting existing admin user successfully");
		lp.logout();
		extent.endTest(logger);

	}
}
