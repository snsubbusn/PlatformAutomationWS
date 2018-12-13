package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC002_VerifyInvitePage extends Action_Method{
	public void verifyWSAdminInvitePage() throws InterruptedException {
		logger = extent.startTest("Verify the WSAdmin Invite Page_TC001");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");
		
		WSAdminGenPage ws = PageFactory.initElements(driver, WSAdminGenPage.class);
		
		logger.log(LogStatus.INFO, "Verify the details of the Invite page of WS Admin");
		
		String def = ws.getDefaultFilterValue();
		if(def.contains("None")) {
			logger.log(LogStatus.PASS, "Verified the default Filter By value is \""+def+"\"");
		}else {
			logger.log(LogStatus.FAIL, "The Default Filter By value is not 'None'. It is "+def);
		}
		
		
		String sor = ws.getDefaultSortValue();
		if(sor.contains("Invited")) {
			logger.log(LogStatus.PASS, "Verified the default Sort By value is \""+sor+"\"");
		}else {
			logger.log(LogStatus.FAIL, "The default Sort By value is not 'Invited On'. It is "+sor);
		}
		
		if(ws.checkforAddButton()) {
			logger.log(LogStatus.PASS, "Verified the 'Add' button is displayed in the Invite Page");
		}else {
			logger.log(LogStatus.FAIL, "'Add' button is not displayed in the Invite page");
		}
		
		String sel = ws.checkSelectAllCheckboxState();
		if(sel.equals("false")) {
			logger.log(LogStatus.PASS, "The 'Select All' checkbox by default is not checked");
		}else {
			logger.log(LogStatus.FAIL, "The 'Select All' checkbox by default is checked");
		}
		
		logger.log(LogStatus.INFO,"Verified the WS Admin Invite Page details");
		extent.endTest(logger);
		
		lp.logout();
	}

}
