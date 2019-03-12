package com.scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CorporateAdmin_UserManagement_Page;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_User_TC012_ValidateAddUserPageErrors extends Action_Method{
	public void validateAddUserPageErrors() throws InterruptedException {
		logger = extent.startTest("CorporateAdminUserManagement_TC012_ValidateAddUserPageErrors");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("CorporateAdmin UserManagement");
		logger.setDescription("Corporate Admin validates the error messages displayed in the 'Add Users' Page");

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
		String add = user.clickonAddButton();
		if(add.contains("Add User")) {
			logger.log(LogStatus.PASS, "Click on Add icon, Clicked on Add icon and the screen navigated to 'Add User' page.");
		}else {
			logger.log(LogStatus.FAIL,"Click on Add icon, Click on Add icon failed to navigate to 'Add User' page");
		}
		
		logger.log(LogStatus.INFO, "Click on Save button without entering any values in any of the fields");
		String error = user.allErrorValidate();
		if(error.contains("name")&&error.contains("email")&&error.contains("phone")) {
			logger.log(LogStatus.PASS, "Verify the error, Verified the error by clicking on Save button. Ther errors displayed are - "+error);
		}else {
			logger.log(LogStatus.FAIL, "verify the error, The Error for all the fields are not displayed. The errors displayed are - "+error);
		}
		
		logger.log(LogStatus.INFO, "Verify the error message for invalid phone number");
		String phoneError = user.invalidPhoneNo();
		if(phoneError.contains("Please enter a valid phone no")) {
			logger.log(LogStatus.PASS, "Verified the error message for invlid entry on phone number field. The error is - "+phoneError);
		}else {
			logger.log(LogStatus.FAIL, "The error message displayed is not relevant. The error is - "+phoneError);
		}
		
/*		logger.log(LogStatus.INFO, "Verify the error message for invalid password");
		String passError = user.invlaidPassword();
		if(passError.contains("combination")) {
			logger.log(LogStatus.PASS, "Verified the error message for invlid password. The error is - "+passError);
		}else {
			logger.log(LogStatus.FAIL, "The error message displayed is not relevant. The error is - "+passError);
		}
		
		
		logger.log(LogStatus.INFO, "Verify the error message for password and confirm password doesnot match");
		String notMatchError = user.passwordNotMatch();
		if(notMatchError.contains("does not")) {
			logger.log(LogStatus.PASS, "Verified the error message for password not matching. The error is - "+notMatchError);
		}else {
			logger.log(LogStatus.FAIL, "The error message displayed is not relevant. The error is - "+notMatchError);
		}
*/		
		logger.log(LogStatus.INFO, "Verify the error message for adding the existing user");
		user.addDeletedCorporateUser("NewUser", "new@mailinator.com", "8147506453");
		user.clickonAddButton();
		user.addDeletedCorporateUser("NewUser", "new@mailinator.com", "8147506453");
		
		String alreadyError = user.alreadyInvitedUserError();
		if(alreadyError.contains("already")) {
			logger.log(LogStatus.PASS, "Verified the error message and the error is - "+alreadyError);
		}else {
			logger.log(LogStatus.FAIL, "The error message displayed is not relevant. The error is - "+alreadyError);
		}
		
		logger.log(LogStatus.INFO, "Error Validation of the Add Users Page has been completed.");
		lp.logout();
		extent.endTest(logger);
		
	}
}
