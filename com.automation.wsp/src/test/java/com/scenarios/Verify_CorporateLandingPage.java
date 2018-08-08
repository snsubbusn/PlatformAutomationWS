package com.scenarios;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Corporate_landingPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Verify_CorporateLandingPage extends Action_Method{

	public void Verify_CorporateLandingPage() {

		logger = extent.startTest("Corporate Login Scenario Started.");

		//Launching the URL
		wait_for_pageload(Variables.url);

		//Creating instance of login page
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");;

		Corporate_landingPage landP = PageFactory.initElements(driver, Corporate_landingPage.class);

		//Verifying successful login by validating the post video JD link in the landing page		
		if(landP.VerifyPostVideoJDLink()) {
			logger.log(LogStatus.PASS, "Login as Corporate user", "Successfully logged in as corporate user");
		}else {
			logger.log(LogStatus.FAIL, "Login as Corporate user", "User credentials are invalid");
		}
		logger.log(LogStatus.INFO, "Corporate Landing page Verified");
		extent.endTest(logger);
	}
}
