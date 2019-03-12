package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC010_VerifyEditingCorpAdminUnderInvite extends Action_Method{
	public void verifyEditInvitedCorporateAdminUser() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		logger = extent.startTest("WSAdmin_TC010_VerifyEditingCorpAdminUnderInvite");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("WSAdmin General");
		logger.setDescription("Login as WS Admin, Search for the Corporate admin in the Invite Page and edit the License of the corporate admin");
		
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

		logger.log(LogStatus.INFO, "Filter the No of items per page as 45");

		ws.select45ItemsPerPage();
		logger.log(LogStatus.PASS, "Filtered the No of Items per page as 45");

		logger.log(LogStatus.INFO, "Search for the Corporate Admin to Edit the Invite");


		if(ws.searchForCorporateEmailandClickonCorporateToEdit(getExceldata(Variables.testdata, Variables.LoginPage,"Corporate Email"))) {
			logger.log(LogStatus.PASS, "The Corporate Email is present and the Invited Corporate Admin is selected to update the Invite");
		}else {
			logger.log(LogStatus.FAIL, "The Corporate Email is not present under the Invited Corporate Admin list of WS Admin.");
		}

		logger.log(LogStatus.INFO, "Update the license count of the corporate admin");
		ws.updateLicenceCountofCorporate();
		logger.log(LogStatus.PASS, "Updated the licenses count for the corporate admin");
		
		
		logger.log(LogStatus.INFO, "Verified the Invited Corporate Admin user is able to edit by the WS Admin");
		extent.endTest(logger);

		lp.logout();


	}
}
