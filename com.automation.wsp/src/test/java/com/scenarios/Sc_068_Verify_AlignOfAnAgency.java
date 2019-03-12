package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.ManageJobPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Sc_068_Verify_AlignOfAnAgency extends Action_Method
{
	
	public void Verify_AlignOfAnAgency() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		logger = extent.startTest("GS03_SC_068_Verifying Align of an agency by Workstreets Admin");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Guaranteed Submission - BasicFlow");
		logger.setDescription("Login as WS Admin and Align an Agency partner to the GS Campaign");
	
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button,Admin Landing page displayed");
		
		//Creating object for Manage job page
		ManageJobPage manage=PageFactory.initElements(driver,ManageJobPage.class);
		if(manage.clickOnActiveJobs()==true)
		{
			logger.log(LogStatus.PASS, "Click on manage tab","Manage tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on manage tab","Fail,Manage tab not clicked");
		}
		if(manage.Click_Mangae_Job(getExceldata(Variables.testdata,Variables.SetData_Excel,"Job ID"))==true)
		{
			logger.log(LogStatus.PASS, "Click on manage button for partcular job","Manage button clicked for particular job");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on manage button for partcular job","Fail,Manage button not clicked");
		}
		if(manage.Click_On_AlignAgency_Tab()==true)
		{
			logger.log(LogStatus.PASS, "Click on Align agency tab","Align agency tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on View Responses tab","Fail,Align Agency tab not clicked");
		}
		if(manage.Align_An_Agency()==true)
		{
			logger.log(LogStatus.PASS, "Align an agency for a particular job","Agency partner successfully aligned");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Align an agency for a particular job","Fail,Agency partner not aligned");
		}
		
		
		logger.log(LogStatus.INFO,"Align of an agency by workstreets admin completed");
		extent.endTest(logger);
		
	}
}
