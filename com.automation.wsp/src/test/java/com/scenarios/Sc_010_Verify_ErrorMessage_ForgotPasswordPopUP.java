package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ForgotPasswordPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_010_Verify_ErrorMessage_ForgotPasswordPopUP extends Action_Method
{
	public void Verify_ErrorMessage_ForgotPasswordPopUP()
	{
		
		logger = extent.startTest("verifying Error message for Forgot Password Pop up");
		
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating object for Forgot Password Page
		ForgotPasswordPage fp=PageFactory.initElements(driver,ForgotPasswordPage.class);
		
		logger.log(LogStatus.INFO, "Verify Error message");
		//Verify Error message for Invalid Mail id
		
		fp.Click_On_ForgotPasswordlink();
		fp.Enter_Inputs_for_Email("as");
		if(fp.ErrorMessage()==true) 
		{
			logger.log(LogStatus.PASS, "Verify error message","\"Error message\" is available for invalid email");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify error message","\"Error message\" is not available for invalid email");
		}
		
		
		logger.log(LogStatus.INFO, "Error message verification completed");
		
		extent.endTest(logger);
	}
}
