package com.scenarios;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.RegisterPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_008_Verify_Register extends Action_Method
{
	public void Verify_Registration_Of_user() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		logger = extent.startTest("verifying Registration of an user");
		logger.log(LogStatus.INFO, "Verify all elements,texts present in Forgot Password pop up");
		
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating Instance for Register page
		RegisterPage rp=PageFactory.initElements(driver, RegisterPage.class);
		
	
		//Enter valid data for all fields in Register page
		if(rp.Enter_Inputs_For_All_The_Fields_In_RegisterPage()==true)
		{
			logger.log(LogStatus.PASS, "Enter valid inputs for all the field in Register page and verify","Sucessfully Value entered for all the fields in Register page");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Enter valid inputs for all the field in Register page and verify","Failed during entering value in to register page");
		}
		
		//verify request invite in Register page
		if(rp.Request_Invite()==true)
		{
			logger.log(LogStatus.PASS, "Verify request Invite in Register page","Request Invite successfully verified");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Verify request Invite in Register page","Failed to send Request Invite ");
		}
		
		logger.log(LogStatus.INFO, "Register verification completed in Register page");
		
		extent.endTest(logger);
		
	}
	
	
}
