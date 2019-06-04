package com.scenarios;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CandidateProfilePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC003_VerifyErrorValidationofCandidateProfileEdit extends Action_Method
{
	public void errorValidation() throws InterruptedException{
		
		   logger = extent.startTest("Candidate_TC003_VerifyErrorValidationofCandidateProfileEdit");
		   driver.manage().timeouts().implicitlyWait(30,TimeUnit.MINUTES);
		   logger.assignAuthor("Natasha");
		   logger.assignCategory("Candidate General");
		   logger.setDescription("Login with valid Candidate Credentials and verify the profile edit button. Verify the error validations for each and every fields");

		    
		   //launching url
	       wait_for_pageload(Variables.url);
	       logger.log(LogStatus.PASS, "Launched the url successfully");
	       
		   loginPage lp = PageFactory.initElements(driver, loginPage.class);
		   lp.EnterValidLogin(Variables.testdata, Variables.LoginPage,"Candidate Email", "Candidate Password");
		   logger.log(LogStatus.PASS, "Entered valid credentials");
		   
		   CandidateProfilePage cp = PageFactory.initElements(driver, CandidateProfilePage.class);
		   cp.ProfileTab();
		   cp.click_OnEditButton();
		   if(cp.errorValidationForProfileInformation_Page())
		   {
			   logger.log(LogStatus.PASS, "Errors on Profile Information Personal info is validated successfully");
			   ArrayList<String> a = cp.getAllErrorMessagesForProfileInfoPage();
			   logger.log(LogStatus.INFO,"Error Messages verified are : "+a);
		   }
		   else
		   {
			   logger.log(LogStatus.FAIL, "Failed to validate the errors");
		   }
		   
		  
		   
		   if(cp.errorValidationForProfileInformation_PageOtherDetails())
		   {
			   logger.log(LogStatus.PASS, "Errors on Profile Information Page, Other details is validated successfully");
			   ArrayList<String> a = cp.getAllErrorMessagesForOtherDetailsInProfileInfoPage();
			   logger.log(LogStatus.INFO,"Error Messages verified are : "+a );
		   }
		   else
		   {
			   logger.log(LogStatus.FAIL, "Failed to validate the errors for Other details on Profile Information page");
		   }
		   
		    		   
		   lp.logout();
		   extent.endTest(logger);
		   
		   }
		   
	       
	   
	}

