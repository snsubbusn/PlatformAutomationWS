package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Settings_And_Preferences;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class General_TC010_VerifySecuritySettingsDetailsandChangePassword extends Action_Method
{

	public void preferenceAndSecurity() throws Exception
	{
		
		logger = extent.startTest("General_TC010_VerifySecuritySettingsDetailsandChangePassword");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		logger.assignAuthor("Natasha");
		logger.assignCategory("General");
		logger.setDescription("Login with any WS user and click on ‘Settings’. Verify a new tab is opened and navigate to the new tab. Navigate to Security Settings and click on Change Password. Enter the details and verify the save button is enabled. Log out and close the browser");

		//launching url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the url Successfully");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage,"Admin Email", "AdminPassword");
		logger.log(LogStatus.PASS, "Entered valid credentials");
		

		Settings_And_Preferences sp = PageFactory.initElements(driver,Settings_And_Preferences.class);
		logger.log(LogStatus.PASS, "Logged in as WS user successfully");
		
		sp.navigateToSettings();
		HandlingMultipleTabs();
		if(sp.verifyNavigationToSettingsTab())
		{
			logger.log(LogStatus.PASS, "Clicked on Settings and navigated to new tab successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed to open new tab after clicking on Settings");
		}
		
		
		if(sp.verifySettingsTab())
		{
			logger.log(LogStatus.PASS, "Sections present in settings tab is verified and validated");
		}
  
		else
		{
			logger.log(LogStatus.FAIL, "Failed to verify settings tab");
		}
		
		String b = "false";
		if(sp.VerifyChangePassword().equals(b))
		{
			logger.log(LogStatus.INFO,"Entered old password,new password and confirm password to verify if Save button is enabled");
			logger.log(LogStatus.PASS, "Save button enabled successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "The Save Button is not enabled");
		}
		lp.logout();
		logger.log(LogStatus.PASS, "Successfully logged out");
		extent.endTest(logger);

	}
}
