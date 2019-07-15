package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Settings_And_Preferences;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class General_TC017_VerifyPreferencesPageForAgency extends Action_Method
{

	public void preferenceAndSecurity() throws Exception
	{

		logger = extent.startTest("General_TC017_VerifyPreferencesPageForAgency");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		logger.assignAuthor("Natasha");
		logger.assignCategory("General");
		logger.setDescription("Login with any agency and click on ‘Settings’. Verify a new tab is opened and navigate to the new tab. Navigate to Preferences verify the details in the page. Log out and close the browser");

		//launching url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the url Successfully");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage,"Agency Email", "Agency Password");
		logger.log(LogStatus.PASS, "Entered valid credentials");


		Settings_And_Preferences sp = PageFactory.initElements(driver,Settings_And_Preferences.class);
		logger.log(LogStatus.PASS, "Logged in as agency successfully");

		sp.navigateToSettings();
		if(sp.verifyNavigationToSettingsTab())
		{
			logger.log(LogStatus.PASS, "Clicked on Settings and navigated to new tab successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed to open new tab after clicking on Settings");
		}

		if(sp.verifyAgencyPreferencePage())
		{
			logger.log(LogStatus.PASS, "Clicked on Preferences tab and navigated successfully");
			String value = sp.getChkBoxValue();
			logger.log(LogStatus.INFO,"Value of Accept button is "+value);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed to navigate to preference tab");
		}

		
		
		lp.logout();
		logger.log(LogStatus.PASS, "Successfully logged out");
		extent.endTest(logger);

	}
}
