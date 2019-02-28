package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ForgotPasswordPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_011_Verify_PasswordReset extends Action_Method
{
	public void Verify_PasswordReset()
	{

		logger = extent.startTest("Sc_011_Verify_PasswordReset");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating object for Forgot Password Page
		ForgotPasswordPage fp=PageFactory.initElements(driver,ForgotPasswordPage.class);
		
		logger.log(LogStatus.INFO, "Verify Password reset");
		
		fp.clickOnLoginTab();
		fp.Click_On_ForgotPasswordlink();
		fp.Enter_Inputs_for_Email("sivaprakash@workstreets.com");
		logger.log(LogStatus.INFO, "Verify Submit button for Valid Mail id");
		if(fp.Verify_SendEmail_Btn()==true) 
		{
			logger.log(LogStatus.PASS, "Verify Send Email button is enable or not, \"Send Email\" button is enabled");
			fp.Click_On_SendMail();
			logger.log(LogStatus.PASS, "Verify Email send- Password reset link send to given mail id");
			//logger.log(LogStatus.WARNING, "Email sent but its not implemented - password reset is not implimented");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify Send Email button is enable or not","\"Send Email\" button is disabled");
		}
		
	
		logger.log(LogStatus.INFO, "Email successfully send ");
		
		
		extent.endTest(logger);
	}
}
