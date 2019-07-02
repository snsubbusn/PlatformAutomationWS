package com.scenarios;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Settings_And_Preferences;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class General_TC012_VerifySecuritySettingsMobileNumberChangeErrorValidation extends Action_Method
{

	public void preferenceAndSecurity() throws Exception
	{

		logger = extent.startTest("General_TC012_VerifySecuritySettingsMobileNumberChangeErrorValidation");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		logger.assignAuthor("Natasha");
		logger.assignCategory("General");
		logger.setDescription("Login with any WS user and click on ‘Settings’. Verify a new tab is opened and navigate to the new tab. Navigate to Security Settings and click on Change Mobile. Enter the details and validate error messages. Log out and close the browser");

		//launching url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the url Successfully");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage,"Admin Email", "AdminPassword");
		logger.log(LogStatus.PASS, "Entered valid credentials");


		Settings_And_Preferences sp = PageFactory.initElements(driver,Settings_And_Preferences.class);
		logger.log(LogStatus.PASS, "Logged in as WS user successfully");

		sp.navigateToSettings();
		if(sp.verifyNavigationToSettingsTab())
		{
			logger.log(LogStatus.PASS, "Clicked on Settings and navigated to new tab successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed to open new tab after clicking on Settings");
		}

		if(sp.VerifyErrorsForMobileNumber())
		{
			logger.log(LogStatus.INFO,"Entered invalid data in phone number and OTP field to verify the errors");
			logger.log(LogStatus.PASS, "Errors for mobile field is validated successfully");
			ArrayList<String> a = sp.getAllErrorMessagesForEmailField();
			logger.log(LogStatus.INFO,"Error Messages verified are : "+a);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed to validate the errors");
		}
		lp.logout();
		logger.log(LogStatus.PASS, "Successfully logged out");
		extent.endTest(logger);
	}



}
