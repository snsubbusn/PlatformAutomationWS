package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CandidateProfilePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC016_VerifyErrorValidationofCandidateProfileEditForWorkExperiencePage extends Action_Method
{

	public void errorValidationWorkExperienceAndProjectShowcase() throws InterruptedException
	{
		logger = extent.startTest("Candidate_TC016_VerifyErrorValidationofCandidateProfileEditForWorkExperiencePage");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.MINUTES);
		logger.assignAuthor("Natasha");
		logger.assignCategory("Candidate General");
		logger.setDescription("Verify error validations for WorkExperience page");
		
		//launching url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS,"Launched url successfully");
		
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage,"Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Entered valid credentials");
		
		CandidateProfilePage cp = PageFactory.initElements(driver,CandidateProfilePage.class); 
		cp.click_OnEditButton();
		if(cp.errorValidationForWorkExperienceAndProjectShowcasePage())
		{
			logger.log(LogStatus.PASS, "Errors for Work Experience and Project Showcase field validated successfully ");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed to validate the errors");
		}

		lp.logout();
		extent.endTest(logger);
	}
	
	
}
