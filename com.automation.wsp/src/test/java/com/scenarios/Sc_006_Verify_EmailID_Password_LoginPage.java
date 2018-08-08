package com.scenarios;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_006_Verify_EmailID_Password_LoginPage extends Action_Method
{
	public void Verify_MailId_Password() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		logger = extent.startTest("verifying error message for Email Id and password");
		
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		logger.log(LogStatus.INFO, "Verifying error message for no inputs");
		//Craeting object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.Login_NoInputs();
		if(lp.Error_MandatoryField()==true)
		{
			logger.log(LogStatus.PASS, "User is getting error message", "For No Inputs User is getting \"Required Fields are mandatory\" error message ");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "User is not getting any error message", "Error message  not available for no inputs");
		}
		driver.navigate().refresh();
		
		logger.log(LogStatus.INFO, "Verifying error message for Invalid mail id");
		
				lp.Login_InvalidMail();
				if(lp.Error_InvalidMail()==true)
				{
					logger.log(LogStatus.PASS, " User is getting error message", "For invalid mail id User is getting \"Please enter a valid email\" error message");
				}
				else
				{
					logger.log(LogStatus.FAIL, "User is not getting any error message", "Error message  not available for invalid mail id");
				}
		
				
				logger.log(LogStatus.INFO, "Email id and password verification completed");
				
				extent.endTest(logger);
		
	}
		
}
