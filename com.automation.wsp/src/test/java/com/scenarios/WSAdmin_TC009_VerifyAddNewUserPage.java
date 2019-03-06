package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC009_VerifyAddNewUserPage extends Action_Method{
	public void verifyAddNewUserPage() throws InterruptedException {
		logger = extent.startTest("Verify the WS Admin Add New User Invite Page_TC009");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		//Launching the URL

		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");

		WSAdminGenPage ws = PageFactory.initElements(driver, WSAdminGenPage.class);
		logger.log(LogStatus.INFO, "Verify the Add button in the Invite Page");
		
		if(ws.checkforAddButton()) {
			logger.log(LogStatus.PASS, "Verified the \"Add\" button is displayed in the Invite Page of WS Admin");
		}else {
			logger.log(LogStatus.FAIL, "\"Add\" button is not displayed in the Invite Page of WS Admin");
		}
		
		String hd = ws.verifyNewInvitesPage();
		
		if(hd.contains("New")) {
			logger.log(LogStatus.PASS, "Add Button clicked and navigated to "+hd+" Page");
		}else {
			logger.log(LogStatus.FAIL, "Add Button clicked and Navigated to "+hd+" Page. Insted of \"New Invites\" Page");
		}
		
		logger.log(LogStatus.INFO, "Verified the \"New Invites\" page after clicking on Add button in WS Admin Invite Page");

		extent.endTest(logger);
		lp.logout();
	}

}
