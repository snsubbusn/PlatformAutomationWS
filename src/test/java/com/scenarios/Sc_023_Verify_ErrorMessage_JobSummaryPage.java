package com.scenarios;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Corporate_PostVideoJD_JobSummaryPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_023_Verify_ErrorMessage_JobSummaryPage extends Action_Method
{
	//Verify error message for job summary page
	public void Verify_ErrorMessage_Experience() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		logger = extent.startTest("Verifying error message for Minimum Experience greater than Maximum Experience in Job Summary Page");
		
		//Launching the url
		
		driver.navigate().refresh();
		
		//Creating object for Job summary page
		Corporate_PostVideoJD_JobSummaryPage cjs=PageFactory.initElements(driver,Corporate_PostVideoJD_JobSummaryPage.class);
		logger.log(LogStatus.INFO, "Click on \"Post Video Jd\" tab,Job summary page displayed");
		cjs.ClickOnPostVideoJD_Tab();
		logger.log(LogStatus.INFO, "Verifying error message for Minimum Salary greater than mavimum salary");
		if(cjs.Error_Message_For_MinimumExperience_GreaterThan_MaximumExperience()==true) 
		{
			logger.log(LogStatus.PASS, "Verify error message in Job summary page","Error message is available for Minimum Experience greater than Maximum Experience");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","Error message is not available for Minimum Experience greater than Maximum Experience");
		}
		
		
		logger.log(LogStatus.INFO,"Error message verified for Minimum Experience reater than Maximum Experience");
		extent.endTest(logger);
	}
	public void Verify_ErrorMessage_NoInputs()
	{
		logger = extent.startTest("Verifying error message for No inputs in Job Summary Page");
		
		//Launching the url
		
		wait_for_pageload(Variables.url);
		
		//Creating instance of login page
		
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		logger.log(LogStatus.INFO, "Enter valid Username and password for corporate and click on login,Corporate landing page displayed");
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		
		//Creating object for Job summary page
		Corporate_PostVideoJD_JobSummaryPage cjs=PageFactory.initElements(driver,Corporate_PostVideoJD_JobSummaryPage.class);
		logger.log(LogStatus.INFO, "Click on \"Post Video Jd\" tab,Job summary page displayed");
		cjs.ClickOnPostVideoJD_Tab();
		logger.log(LogStatus.INFO, "Verifying error message for no input");
		if(cjs.Error_Message_For_NoInputs()==true) 
		{
			logger.log(LogStatus.PASS, "Verify error message in Job summary page","Error message is available for No Inputs");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","Error message is not available for No Inputs");
		}
		
		
		logger.log(LogStatus.INFO,"Error message verified for No Inputs");
		extent.endTest(logger);
	}
	public void Verify_ErrorMessage_Salary() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
	logger = extent.startTest("Verifying error message for Minimum Salary greater than Maximum Salary in Job Summary Page");
	
	driver.navigate().refresh();
	
	//Creating object for Job summary page
	Corporate_PostVideoJD_JobSummaryPage cjs=PageFactory.initElements(driver,Corporate_PostVideoJD_JobSummaryPage.class);
	logger.log(LogStatus.INFO, "Click on \"Post Video Jd\" tab,Job summary page displayed");
	cjs.ClickOnPostVideoJD_Tab();
	logger.log(LogStatus.INFO, "Verifying error message for Minimum Salary greater than mavimum salary");
	if(cjs.Error_Message_For_MinimumSalary_GreaterThan_MaximumSalary()==true) 
	{
		logger.log(LogStatus.PASS, "Verify error message in Job summary page","Error message is available for Minimum Salary greater than Maximum salary");
	}
	else 
	{
		logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","Error message is not available for Minimum Salary greater than Maximum salary");
	}
	
	
	logger.log(LogStatus.INFO,"Error message verified for Minimum Salary reater than Maximum Salary");
	extent.endTest(logger);
	}
}
