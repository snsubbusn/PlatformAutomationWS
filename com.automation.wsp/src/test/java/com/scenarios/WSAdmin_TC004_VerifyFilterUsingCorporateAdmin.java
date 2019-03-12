package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC004_VerifyFilterUsingCorporateAdmin extends Action_Method{
	public void verifytheFilterBySelectingCorporateAdmin() throws InterruptedException {
		logger = extent.startTest("WSAdmin_TC004_VerifyFilterUsingCorporateAdmin");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("WSAdmin General");
		logger.setDescription("Login as WS Admin, Verify the filter using Corporate Admin in the Invite Page");
		
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
			logger.log(LogStatus.FAIL, "The Default value of the 'Filter By' is not 'All'. the value is "+def);
		}
		
		logger.log(LogStatus.INFO, "Change the 'Filter By' value to \"Corporate Admin\"");
		
		String cor = ws.filterCorporate();
		if(cor.contains("Corporate")) {
			logger.log(LogStatus.PASS, "'Filter By' value has been changed to \"Corporate Admin\" successfully");
		}else {
			logger.log(LogStatus.FAIL, "Filter By did not changed to \"Corporate Admin\". the selected value is "+cor);
		}
		
		logger.log(LogStatus.INFO, "Count the no of Corporate Admin displayed in first page");
		int coun = ws.getCountOfCorporates();
		
		logger.log(LogStatus.PASS,"The count of Corporate Admin in the first page is "+coun);
		
		logger.log(LogStatus.INFO, "Verified the Invite Page using Filter By \"Corporate Admin\"");
		
		extent.endTest(logger);
		
		lp.logout();
		
	}

}
