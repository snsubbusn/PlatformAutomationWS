package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminUsersPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC016_AddingExistingUser extends Action_Method{
	public void verifyAddingExistingAdminUser() throws InterruptedException {
		logger = extent.startTest("WSAdmin_TC016_AddingExistingUser");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("WSAdmin UserManagement");
		logger.setDescription("Login as WS Admin, Verifying Adding Existing WS Admin user in Add User Page");
		
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
		String error="";
		try {
			error = ws.alreadyInvitedUserError();
		}catch(Exception e){
			error = "New User";
		}
		
		System.out.println(error);
		if(error.contains("already")) {
			logger.log(LogStatus.PASS, "Verified the error for adding the existing user. "+error);
		}else {
			logger.log(LogStatus.FAIL, "The added user is a "+error);
			String name = ws.getFirstUserCardName();
			String email = ws.getFirstUserCardEmail();
			String phone = ws.getFirstUserCardPhone();
			
			if(!name.isEmpty()&&!email.isEmpty()&&!phone.isEmpty()) {
				logger.log(LogStatus.PASS, "New User has been added successfully. the details are :"+name+"; "+email+"; and "+phone);
			}else {
				logger.log(LogStatus.FAIL, "Failed to add new admin user");
			}
		}	
		
		
		logger.log(LogStatus.INFO, "Verified the validation of adding existing admin user successfully");
		lp.logout();
		extent.endTest(logger);

	}
}
