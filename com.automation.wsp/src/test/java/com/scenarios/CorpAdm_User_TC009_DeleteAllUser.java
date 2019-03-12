package com.scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CorporateAdmin_UserManagement_Page;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class CorpAdm_User_TC009_DeleteAllUser extends Action_Method{
	public void deleteAllCorporateUser() throws InterruptedException {
		logger = extent.startTest("CorporateAdminUserManagement_TC009_DeleteAllUser");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("CorporateAdmin UserManagement");
		logger.setDescription("Corporate Admin Deletes all the available corporate users and verify the license count");

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
			logger.log(LogStatus.PASS, "There are "+used1+" available for deletion");	

			for(int i=used1; i>0; i--) {
				List <String> li = user.getLicensesCount();
				int used = Integer.parseInt(li.get(0));
				int total = Integer.parseInt(li.get(1));
								
				String deleteMsg = user.deleteFirstUser();

				if(deleteMsg.contains("Deleted Successfully")){
					logger.log(LogStatus.PASS, "Check User Deleted, Clicked on Delete of "+used+" user and confirmed. The user has been deleted and the message displayed is '"+deleteMsg+"'");
				}else {
					logger.log(LogStatus.FAIL, "Check User Deleted, Cllicked on Delete of "+used+" user but failed to Delete the user");
				}

				logger.log(LogStatus.PASS,"The License details is "+used+" Out of "+total+"licenses used");

				logger.log(LogStatus.INFO, "Corporate Admin deleted corporate user and verified the license count has been completed");

			}
		}


		lp.logout();
		extent.endTest(logger);

	}
}
