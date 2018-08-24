package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.EngageAgencyPartnersPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_032_PerformGuaranteedSubmission extends Action_Method
{
	public void Verify_Guaranteed_Submission() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		logger = extent.startTest("SC_032_Verifying Guaranteed Submission of posted JOb");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button,Corporate Landing page displayed");
		//Creating object for Engage agency partner page
		EngageAgencyPartnersPage en=PageFactory.initElements(driver,EngageAgencyPartnersPage.class);
		//Click on "Get Guaranteed Response for particular Job
		if(en.Click_On_GetGuaranteedResponse(en.GetJobID())==true)
		{
			logger.log(LogStatus.PASS, "Click on Get guaranteed responses button for particular Job","Get guaranteed responses button clicked successfully");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Click on Get guaranteed responses button for particular Job","Unable to click on Get Guaranteed Responses button of a Job");
			
		}
		//Calculate estimated value before guaranteed submission
		if(en.Get_Estimate()==true)
		{
			logger.log(LogStatus.PASS, "Click on Get estimate in payment page and verify","Successfully estimation done for GS ");
			Thread.sleep(5000);
		}
		else
		{
			logger.log(LogStatus.FAIL,"Click on Get estimate in payment page and verify","Unable to get estimation for GS ");
		}
		
		//Click on accept to pay later in payment page
		if(en.Aaccept_To_Pay_Later()==true)
		{
			logger.log(LogStatus.PASS,"Click On accept to pay later","Accept to pay later successfully verified");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Click On accept to pay later","Not able to click on Accept to pay later");
		}
		
		
		
		logger.log(LogStatus.INFO, "Perform Guaranteed Submissions scenario completed");
		
		extent.endTest(logger);
		
		
	}
}
