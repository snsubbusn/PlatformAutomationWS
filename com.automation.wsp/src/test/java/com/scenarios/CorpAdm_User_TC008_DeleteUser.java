package com.scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CorporateAdmin_UserManagement_Page;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_User_TC008_DeleteUser extends Action_Method{
	public void deleteCorporateUser() throws InterruptedException {
		logger = extent.startTest("Deleting Corporate User__CorporateAdminUserManagement_TC008", "Corporate Admin Deletes the corporate users and verify the license count");
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
		List <String> li1 = user.getLicensesCount();
		int used1 = Integer.parseInt(li1.get(0));

		if(used1==0) {
			addUserForEdit(used1);
		}else {
			if(user.verifyFirstUserCard()==true) {
				logger.log(LogStatus.PASS, "Check for User card, First User card is present under the Users Page");
			}else {
				logger.log(LogStatus.FAIL, "Check for User card, No User card is displayed under User Page");
			}			
		}

		List <String> li = user.getLicensesCount();
		int used = Integer.parseInt(li.get(0));
		int total = Integer.parseInt(li.get(1));

		logger.log(LogStatus.INFO,"The corporate has totally "+total+" licenses. Out of which "+used+" licenses have been used.");

		String deleteMsg = user.deleteFirstUser();

		if(deleteMsg.contains("Deleted Successfully")){
			logger.log(LogStatus.PASS, "Check User Deleted, Clicked on Delete of first user and confirmed. The user has been deleted and the message displayed is '"+deleteMsg+"'");
		}else {
			logger.log(LogStatus.FAIL, "Check User Deleted, Cllicked on Delete of first user but failed to Delete the user");
		}
		
		//After Delete verify the license count
		List<String> li2 = user.getLicensesCount();
		int remUsed = Integer.parseInt(li2.get(0));
		
		if(remUsed<used) {
			logger.log(LogStatus.PASS, "User Deleted Successfully. The license count has been decreased from "+used+" licenses to "+remUsed+" licenses. The license details is '"+user.getlicensedetails()+"'");
		}else {
			logger.log(LogStatus.FAIL, "User not deleted. The previous license count was "+used+" and the new used license count is "+remUsed+". License details is "+li2);
		}

		logger.log(LogStatus.INFO, "Corporate Admin deleted corporate user and verified the license count has been completed");

		lp.logout();
		extent.endTest(logger);

	}


	public void addUserForEdit(int used) {
		CorporateAdmin_UserManagement_Page user = PageFactory.initElements(driver, CorporateAdmin_UserManagement_Page.class);
		String add = user.clickonAddButton();
		if(add.contains("Add User")) {
			logger.log(LogStatus.PASS, "Click on Add icon, Clicked on Add icon and the screen navigated to 'Add User' page.");
		}else {
			logger.log(LogStatus.FAIL,"Click on Add icon, Click on Add icon failed to navigate to 'Add User' page");
		}
		//Adding User
		user.addCorporateUser(used+1);
		logger.log(LogStatus.INFO, "Added new Corporate user successfully");
		String userna = user.getFirstUserCardName();
		if(userna.equalsIgnoreCase("AutoUser"+(used+1))) {
			logger.log(LogStatus.PASS, "Verify the new user, Corporate user added successfully and verified the new user. The Last added user name is "+userna);
		}else {
			logger.log(LogStatus.FAIL, "Verify the new user, Corporate user failed to add and the last added user is "+userna);
		}
	}
}
