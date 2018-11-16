package com.scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CorporateAdmin_UserManagement_Page;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_User_TC010_AddDeletedUser extends Action_Method{
	public void addDeletedUser() throws InterruptedException {
		logger = extent.startTest("Add the Deleted Corporate User__CorporateAdminUserManagement_TC010", "Corporate Admin Deletes the corporate user and add the same user again. Verify the user is added and license count is not changed");
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
			logger.log(LogStatus.FAIL,"No Users to Delete. Hence the script failed");
		}else {
			
			logger.log(LogStatus.PASS, "Users available for delete");
			
			String userName = user.getFirstUserCardName();
			String userEmail = user.getFirstUserCardEmail();
			String userPhone = user.getFirstUserCardPhone();
			
			logger.log(LogStatus.INFO, "The user details are: User Name - "+userName+", Email id - "+userEmail+", Phone No - "+userPhone);
			logger.log(LogStatus.INFO, "User details captured before deleting the user");
			
			String delteMsg = user.deleteFirstUser();
			if(delteMsg.contains("Deleted Successfully")) {
				List <String> li = user.getLicensesCount();
				int used = Integer.parseInt(li.get(0));
				logger.log(LogStatus.PASS, "Check User Deleted, The user has been deleted and the message displayed is '"+delteMsg+"'");
				logger.log(LogStatus.PASS, "Verify the License count, After deleting the details of the license is as - "+user.getlicensedetails());
				
				//Adding the deleted user
				String add = user.clickonAddButton();
				if(add.contains("Add User")) {
					logger.log(LogStatus.PASS, "Click on Add icon, Clicked on Add icon and the screen navigated to 'Add User' page.");
				}else {
					logger.log(LogStatus.FAIL,"Click on Add icon, Click on Add icon failed to navigate to 'Add User' page");
				}
				//Adding User
				user.addDeletedCorporateUser(userName, userEmail, userPhone);
				logger.log(LogStatus.INFO, "Added new Corporate user successfully");
				
				String userName1 = user.getFirstUserCardName();
				String userEmail1 = user.getFirstUserCardEmail();
				String userPhone1 = user.getFirstUserCardPhone();
				
				logger.log(LogStatus.INFO, "User details captured before deleting the user");
				logger.log(LogStatus.INFO, "The user details are: User Name - "+userName1+", Email id - "+userEmail1+", Phone No - "+userPhone1);
				
				if(userName.equals(userName1)&& userEmail.equals(userEmail1)&& userPhone.equals(userPhone1)) {
					logger.log(LogStatus.PASS, "The deleted user was added and verified the details to remain the same");
					logger.log(LogStatus.PASS, "Verify the new user, Corporate user added successfully and verified the new user. The Last added user name is "+userName1);
				}else {
					logger.log(LogStatus.FAIL, "The deleted user and the newly added user are not same");
					logger.log(LogStatus.FAIL, "Verify the new user, Corporate user failed to add and the last added user is "+userName1);
				}
				
				logger.log(LogStatus.PASS, "Verify the License count after adding, After adding the deleted user the details of the license is as - "+user.getlicensedetails());
				
				
			}else {
				logger.log(LogStatus.FAIL, "Check user Deleted, Deleting the user failed.");
			}
			
		}
		
		logger.log(LogStatus.INFO, "Adding the deleted user details has been completed successfully");
		
		lp.logout();
		extent.endTest(logger);

	}

}
