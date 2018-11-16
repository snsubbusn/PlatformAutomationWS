package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Corporate_ProfilePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Verify_CorporateLandingPage extends Action_Method{

	public void Verify_CorporateLanding_Page() throws InterruptedException {

		logger = extent.startTest("Corporate Login Scenario Started.");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		//Launching the URL
		wait_for_pageload(Variables.url);

		//Creating instance of login page
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");;

		Corporate_ProfilePage landP = PageFactory.initElements(driver, Corporate_ProfilePage.class);

		//Verifying successful login by validating the post video JD link in the landing page		
		
		String nam = landP.clickonProfileandVerifyProfilePage(); 
		if(!nam.isEmpty()) {
			logger.log(LogStatus.PASS, "Verify the landing page of corporate, Corporate User successfully logged in and the company name is verified - "+nam);
		}else {
			logger.log(LogStatus.FAIL, "Verify the landing page of corporate, Corporate User login failed and the company name is empty - "+nam);
		}
		
		logger.log(LogStatus.INFO, "Corporate Landing page Verified");
		extent.endTest(logger);
	}
}
