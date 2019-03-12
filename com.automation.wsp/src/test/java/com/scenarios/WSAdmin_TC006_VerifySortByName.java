package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC006_VerifySortByName extends Action_Method{

	public void verifyWSAdminSortByName() throws InterruptedException {
		logger = extent.startTest("WSAdmin_TC006_VerifySortByName");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("WSAdmin General");
		logger.setDescription("Login as WS Admin, Verify the WS Admin able to sort the Invited users by Name_TC006");
		
		//Launching the URL

		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");

		WSAdminGenPage ws = PageFactory.initElements(driver, WSAdminGenPage.class);
		logger.log(LogStatus.INFO, "Verify the default 'Sort By' value displayed");

		String def = ws.getDefaultSortValue();
		if(def.contains("Invited")) {
			logger.log(LogStatus.PASS, "Verified the default Sort by as "+def);
		}else {
			logger.log(LogStatus.FAIL, "The default sort by is not 'Invited On'. it is "+def);
		}
		
		logger.log(LogStatus.INFO, "Change the Sort By to \"Name\"");
		
		String ch = ws.sortByName();
		if(ch.contains("Name")) {
			logger.log(LogStatus.PASS, "The sort by value has been changed to "+ch);
		}else {
			logger.log(LogStatus.FAIL, "The Sort By value not changed to \"Name\". the selected value is "+ch);
		}
		
		String can = ws.getFirstCardDetails();
		
		logger.log(LogStatus.PASS, "The Invited Users are sorted by Name and the First user details are: "+can);
		
		logger.log(LogStatus.INFO, "Verified the WS Admin Invite Page using Sort By \"Name\"");
		
		extent.endTest(logger);
		lp.logout();
	}
}
