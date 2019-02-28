package com.scenarios;

import java.sql.Date;
import java.text.DateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC001_VerifyAdminLogin extends Action_Method {
	
	public void VerifyAdminLogin() throws InterruptedException {
		//logger = extent.startTest("Verify the WSAdmin Login_TC001");
		logger = extent.startTest(this.getClass().getSimpleName());
		logger.addBase64ScreenShot(Variables.Screenshot);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("WS Admin Scenarios - Functional Test");
		logger.getRunStatus();
		logger.setDescription("This is to check the set description method under extent report");
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");
		
		WSAdminGenPage ws = PageFactory.initElements(driver, WSAdminGenPage.class);
		
		logger.log(LogStatus.INFO, "Verify the details of the Home page of WS Admin");
		
		String tab = ws.verifyWSAdminHomePagebyGettingTabDetails();
		
		if(tab.contains("Either")) {
			logger.log(LogStatus.FAIL, "The Tabs are missing"+tab);
		}else {
			logger.log(LogStatus.PASS, "Verified the home page of the WS Admin. The Tabs present for Admin are "+tab);
		}

		logger.log(LogStatus.INFO,"Verified the WS Admin Login and Home Page details");
		extent.endTest(logger);
		
		lp.logout();
	}

}
