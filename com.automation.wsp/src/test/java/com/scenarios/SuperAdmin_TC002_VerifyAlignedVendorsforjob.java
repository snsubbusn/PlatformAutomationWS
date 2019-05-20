package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.SuperAdminAccountManagementPage;
import com.objects_pages.WSAdminGenPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class SuperAdmin_TC002_VerifyAlignedVendorsforjob extends Action_Method {

	public void VerifySuperAdminAligendVendors() throws InterruptedException {
		//logger = extent.startTest(" WSAdmin_TC30_VerifyAccountManagementTab");
		logger = extent.startTest(this.getClass().getSimpleName());
		logger.assignAuthor("Keerthana");
		logger.assignCategory("SuperAdmin General");
		logger.setDescription("Login as Super WS Admin and verify the Account Management tab and aligned vendors are displayed for job under 'Not Aligned'.");
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Super Admin Email","Super Admin Pwd");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed and then navigate to 'Account Management' page");
		
		WSAdminGenPage sa = PageFactory.initElements(driver, WSAdminGenPage.class);
		
		logger.log(LogStatus.INFO, "Verify the details of the Home page of WS Admin");
		
		String tab = sa.verifyWSAdminHomePagebyGettingTabDetails();
		
		if(tab.contains("Either")) {
			logger.log(LogStatus.FAIL, "The Tabs are missing: "+tab);
		}else {
			logger.log(LogStatus.PASS, "Verified the home page of the WS Admin. The Tabs present for Admin are "+tab);
		}

		logger.log(LogStatus.INFO,"Verified the WS Admin Login and Home Page details.");
		
		if(sa.AccountManagementPage()) {
			logger.log(LogStatus.PASS, "Account Management page details are displayed sucessfully.");
		}else {
			logger.log(LogStatus.FAIL, "Failed to display Account Management page.");
		}
		
		if(sa.Verify_CorporateCardViewed()) {
			logger.log(LogStatus.PASS, "Corporate cards  viewed.");
		if(sa.ClickOnEditbutton()) {
			logger.log(LogStatus.PASS, "Account Management page details are displayed sucessfully.");
		}else {
			logger.log(LogStatus.FAIL, "Failed to display Account Management page.");
		}
		if(sa.Align_An_Agency()==true) {
			logger.log(LogStatus.PASS, "Align an agency for a particular corporate","Agency partner successfully aligned.");
		} else {
			logger.log(LogStatus.FAIL, "Align an agency for a particular corporate","Fail,Agency partner not aligned.");
		}
		
		if(sa.Save_EditedAccMgmntdetails()) {
			logger.log(LogStatus.PASS, "Account and Vendors mgrs are edited and saved for Account management tab","success message and drop down of preferred vendors is displayed for the corporate.");
		} else {
			logger.log(LogStatus.FAIL, "Failed to edit Accounr and Vendor managers for Account management tab.");
		}
		sa.getfirstcorporate();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		//Thread.sleep(3000);
		if(sa.goToJobspage()) {
			logger.log(LogStatus.PASS, "Navigated to Active Jobs page sucessfully.");
		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to active jobs page.");
		}
		sa.FilterbyCorporates();
		
		sa.FilterbyCorporates();
		
		//sa.filterWithGivenCorporate(corp);
		}	
		extent.endTest(logger);
		lp.logout();
	}
}

