package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Settings_And_Preferences;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class General_TC015_VerifyPreferencesPageDeactivateAccountPopUp extends Action_Method
{

	public void preferenceAndSecurity() throws Exception
	{

		logger = extent.startTest("General_TC015_VerifyPreferencesPageDeactivateAccountPopUp");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		logger.assignAuthor("Natasha");
		logger.assignCategory("General");
		logger.setDescription("Login with any WS user and click on ‘Settings’. Verify a new tab is opened and navigate to the new tab. Navigate to Preferences verify the details in the page. Click on Deactivate account and verify the pop up is displayed. Log out and close the browser");

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

		if(sp.VerifyPrefernecePageOfWSA())
		{
			logger.log(LogStatus.INFO, "Clicked on Preference tab");
			logger.log(LogStatus.PASS, "Successfully verified Preference page of WSA");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to verify preference page");
		}
		
		if(sp.verifyDeactivatePopUp())
		{
			logger.log(LogStatus.INFO,"Enabled deactivation button to verify if confirmation pop up is displayed");
			logger.log(LogStatus.PASS, "Confirmation pop up is displayed and the buttons are verified");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Confirmation pop up is not viewed even after enabling the deaction button");
		}
		lp.logout();
		logger.log(LogStatus.PASS, "Successfully logged out");
		extent.endTest(logger);

	}
}
