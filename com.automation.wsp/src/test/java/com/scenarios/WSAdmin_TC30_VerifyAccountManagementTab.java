package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdmin_TC30_VerifyAccountManagementTab extends Action_Method {

	public void VerifyAccountManagement() throws InterruptedException {
		//logger = extent.startTest(" WSAdmin_TC30_VerifyAccountManagementTab");
		logger = extent.startTest(this.getClass().getSimpleName());
		logger.assignAuthor("Keerthana");
		logger.assignCategory("WSAdmin General");
		logger.setDescription("Login as WS Admin and verify the Account Management tab");
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Super Admin Email","Super Admin Pwd");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed and then navigate to 'Account Management' page");
		
		WSAdminGenPage ws = PageFactory.initElements(driver, WSAdminGenPage.class);
		
		logger.log(LogStatus.INFO, "Verify the details of the Home page of WS Admin");
		
		String tab = ws.verifyWSAdminHomePagebyGettingTabDetails();
		
		if(tab.contains("Either")) {
			logger.log(LogStatus.FAIL, "The Tabs are missing: "+tab);
		}else {
			logger.log(LogStatus.PASS, "Verified the home page of the WS Admin. The Tabs present for Admin are "+tab);
		}

		logger.log(LogStatus.INFO,"Verified the WS Admin Login and Home Page details.");
		
		if(ws.AccountManagementPage()) {
			logger.log(LogStatus.PASS, "Account Management page details are displayed sucessfully.");
		}else {
			logger.log(LogStatus.FAIL, "Failed to display Account Management page.");
		}
		 
		if(ws.ClearfilterforAccMgmnt()) {
		logger.log(LogStatus.PASS, "Filters are applied successfully for Account Management page.");
		}else {
		logger.log(LogStatus.FAIL, "Failed to apply filters for Account Management page");
		}
	
		if(ws.ApplyfilterforAccMgmnt()) {
		logger.log(LogStatus.PASS, "Filters are cleared successfully for Account Management page.");
		}else {
		logger.log(LogStatus.FAIL, "Failed to clear filters for  Account Management page.");
		}
		
		if(ws.deleteselectedpill()) {
			logger.log(LogStatus.PASS, "verified Applied first Filter is deleted successfully for Account Management page.");
		}else {
		logger.log(LogStatus.FAIL, "Failed to delete  filters for  Account Management page");
		}
		
		Thread.sleep(5000);
		
		if(ws.Verify_CorporateCardViewed()) {
			logger.log(LogStatus.PASS, "Corporate cards  viewed for applied filters.");
		if(ws.ClickOnEditbutton()) {
			if(ws.Editvendor()) {
				logger.log(LogStatus.PASS, "Vendors are edited successfully.");
			if(ws.Verify_VendorMgrWarningmsg()) {
				logger.log(LogStatus.PASS, "Only 2 Vendor Managers can be aligned for a corporate.");
			}}
			//ws.Close_Warningmsg();
			
			if(ws.Editaccmgr()) {
				logger.log(LogStatus.PASS, "Account manager is edited successfully.");
			}
			if(ws.Verify_AccountMgrWarningmsg()) {
				logger.log(LogStatus.PASS, "Only 1 Account Manager can be aligned for a corporate.");
			}
			
			if(ws.Align_An_Agency()==true) {
				logger.log(LogStatus.PASS, "Align an agency for a particular corporate","Agency partner successfully aligned.");
			} else {
				logger.log(LogStatus.FAIL, "Align an agency for a particular corporate","Fail,Agency partner not aligned.");
			}
			
			if(ws.Save_EditedAccMgmntdetails()) {
				ws.PreferredVendorDropdown();
				logger.log(LogStatus.PASS, "Account and Vendors mgrs are edited and saved for Account management tab","success message and drop down of preferred vendors is displayed for the corporate.");
			} else {
				logger.log(LogStatus.FAIL, "Failed to edit Accounr and Vendor managers for Account management tab.");
			}
			
		}
		}
		else {
			logger.log(LogStatus.FAIL, "No corporate cards are viewed for applied filters.");
		}
		extent.endTest(logger);
		
		lp.logout();
	}

}



