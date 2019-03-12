package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC005_VerifyFilterUsingAgent extends Action_Method{
	public void verifytheFilterBySelectingAgent() throws InterruptedException {
		logger = extent.startTest("WSAdmin_TC005_VerifyFilterUsingAgent");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("WSAdmin General");
		logger.setDescription("Login as WS Admin, Verify the filter using Agency Partner in the Invite Page");
		
		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");
		
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");
		
		WSAdminGenPage ws = PageFactory.initElements(driver, WSAdminGenPage.class);
		logger.log(LogStatus.INFO, "Verify the default 'Filter By' value displayed");
		
		String def = ws.getDefaultFilterValue();
		
		if(def.contains("All")) {
			logger.log(LogStatus.PASS, "Verified the default value of the 'Filter By' as "+def);
		}else {
			logger.log(LogStatus.FAIL, "The Default value of the 'Filter By' is not All. the value is "+def);
		}
		
		logger.log(LogStatus.INFO, "Change the 'Filter By' value to \"Agency Partner\"");
		
		String cor = ws.filterAgent();
		if(cor.contains("Agency")) {
			logger.log(LogStatus.PASS, "'Filter By' value has been changed to \"Agency Partner\" successfully");
		}else {
			logger.log(LogStatus.FAIL, "Filter By did not changed to \"Agency Partner\". the selected value is "+cor);
		}
		
		logger.log(LogStatus.INFO, "Count the no of Agency Partner displayed in first page");
		int coun = ws.getCountOfAgents();
		
		logger.log(LogStatus.PASS,"The count of Agency Partner in the first page is "+coun);
		
		logger.log(LogStatus.INFO, "Verified the Invite Page using Filter By \"Agency Partner\"");
		
		extent.endTest(logger);
		
		lp.logout();
		
	}
}
