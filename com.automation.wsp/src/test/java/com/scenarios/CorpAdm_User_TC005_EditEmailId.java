package com.scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CorporateAdmin_UserManagement_Page;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_User_TC005_EditEmailId extends Action_Method {
	public void editCorpUsersforEmailField() throws InterruptedException {
		logger=extent.startTest("CorporateAdminUserManagement_TC005_EditEmailId");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("CorporateAdmin UserManagement");
		logger.setDescription("Corporate Admin edits the Corporate User to update the Email ID");

		//Launching the URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");

		//LoginPage Object creation
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as corporateAdmin
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
		
		if(used!=0) {
			editUserEmailId(used);
		}else {
			addUserForEdit(used);
			editUserEmailId(used+1);
		}
		
		logger.log(LogStatus.INFO, "Corporate User edited for the Email Id field has been completed successfully");
		
		lp.logout();
		extent.endTest(logger);
	
	
	}



	//Method to edit the Email ID
	public void editUserEmailId(int used) {
		CorporateAdmin_UserManagement_Page user = PageFactory.initElements(driver, CorporateAdmin_UserManagement_Page.class);

		String edit = user.clickOnFirstUserCardEdit();
		if(edit.contains("Edit User")) {
			logger.log(LogStatus.PASS, "Click on Edit icon of First User Card, Clicked on the edit icon of the first user card and the screen navigated to edit page - "+edit);
		}else {
			logger.log(LogStatus.FAIL, "Click on Edit icon of First User Card, Clicked on first user card but failed to navigate to Edit User page");
		}

		logger.log(LogStatus.INFO, "Updating the Email ID and verifying the updated Email ID");
		String upd = user.editEmailId();
		if(upd.contains("User Info Updated Successfully")) {
			logger.log(LogStatus.PASS, "Update the Email Id, Updated the Email Id and the success message displayed '"+upd+"' is verified");
		}else {
			logger.log(LogStatus.FAIL, "Update the Email Id, Updating the Email Id failed");
		}

		user.clickOnUsersTab();
		List <String> li1 = user.getLicensesCount();
		int used1 = Integer.parseInt(li1.get(0));

		logger.log(LogStatus.INFO, "Clicked on Users Tab after updating the first user's Email Id");

		String editemail = user.getFirstUserCardEmail();
		if(used==used1&& editemail.contains("edit")) {
			logger.log(LogStatus.PASS, "Verify the edited Email Id, Verified the edited email id and the Used User count "+used1+" has not changed. \nThe updated name of the user is "+editemail);
		}else {
			logger.log(LogStatus.FAIL, "Verify the edited Email Id, Failed in verifying the updates. Either the user count has changed or the email id is not edited");
		}
	}

	
	//Created a method to add the user if there are no users added for editing the user
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
