package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminUsersPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC012_VerifyUsersTab extends Action_Method{
	public void verifyUsersTabOfWSAdmin() throws InterruptedException {
		logger = extent.startTest("WSAdmin_TC012_VerifyUsersTab");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("WSAdmin UserManagement");
		logger.setDescription("Login as WS Admin, Verify the Users tab displayed and check for the total no of users added");
		
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
		
		String rec = ws.getTotalRecordsofthePage();
		if(!rec.isEmpty()) {
			logger.log(LogStatus.PASS, "The total no of Admin users are :"+rec);
		}else {
			logger.log(LogStatus.FAIL, "There are no users added");
		}
		
		logger.log(LogStatus.INFO, "Verified the Users Tab of WS Admin");
		
		lp.logout();
		extent.endTest(logger);
	}

}
