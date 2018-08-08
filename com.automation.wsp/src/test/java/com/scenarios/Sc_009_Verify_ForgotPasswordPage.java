package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ForgotPasswordPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_009_Verify_ForgotPasswordPage extends Action_Method
{
	
	public void Verify_ForgotPasswordPage()
	{
		logger = extent.startTest("verifying All elements and text present in Forgot password pop up");
		logger.log(LogStatus.INFO, "Verify all elements,texts present in Forgot Password pop up");
		
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		ForgotPasswordPage fp=PageFactory.initElements(driver,ForgotPasswordPage.class);
		fp.Click_On_ForgotPasswordlink();
		
		logger.log(LogStatus.INFO, "Verifying \"Forgot password\" text in Forgot password pop up");
		if(fp.ForgotPasswordText()==true) 
		{
			logger.log(LogStatus.PASS, "Verify Forgot password text in Forgot Password pop up","\"Forgot Password\" text is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify Forgot password text in Forgot Password pop up","\"Forgot Password\" text is not available");
		}
		
		logger.log(LogStatus.INFO, "Verifying message present in Forgot password pop up");
		if(fp.ForgotPasswordMessage()==true) 
		{
			logger.log(LogStatus.PASS, "Verify Message present in Forgot Password pop up","\"Please enter your email address for the password reset link\" text is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify Message present in Forgot Password pop up","\"Please enter your email address for the password reset link\" text is not available");
		}
		
		logger.log(LogStatus.INFO, "Verifying \"Email Id\" field in Forgot password pop up");
		if(fp.ForgotPasswordEmail()==true) 
		{
			logger.log(LogStatus.PASS, "Verify email id field in Forgot Password pop up","\"Email id\" field is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify email id field in Forgot Password pop up","\"Email id\" field is not available");
		}
		
		logger.log(LogStatus.INFO, "Verifying \"Send Email\" field in Forgot password pop up");
		if(fp.ForgotPasswordSendEmail_Btn()==true) 
		{
			logger.log(LogStatus.PASS, "Verify Send Email field in Forgot Password pop up","\"Send Email\" button is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify Send Email field in Forgot Password pop up","\"Send Email\" button is not available");
		}
		
		logger.log(LogStatus.INFO, "Verification for Forgot Password pop up completed");
		
		extent.endTest(logger);
		
		
	}
	
}
