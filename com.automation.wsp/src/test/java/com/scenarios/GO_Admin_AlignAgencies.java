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

public class GO_Admin_AlignAgencies extends Action_Method {
	
	public void AlignAgentforGO() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		logger = extent.startTest("Guaranteed Onboarding Basic Flow - Admin Aligning Agencies for the campaign");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");
		
		//Creating object for Manage job page
		ManageJobPage manage=PageFactory.initElements(driver,ManageJobPage.class);
		if(manage.clickOnActiveJobs()==true)
		{
			logger.log(LogStatus.PASS, "Click on manage jobs tab","Manage Jobs tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on manage job tab","Fail,Manage Job tab not clicked");
		}
		if(manage.Click_Mangae_Job(getExceldata(Variables.testdata,Variables.SetData_Excel,"Job ID"))==true)
		{
			logger.log(LogStatus.PASS, "Click on manage button for the GO Campaign","Manage button clicked for the GO Campaign");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on manage button for the GO Campaign","Fail,Manage button not clicked");
		}
		if(manage.Click_On_AlignAgency_Tab()==true)
		{
			logger.log(LogStatus.PASS, "Click on Align agency tab","Align agency tab clicked");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Click on Align agency tab","Fail,Align Agency tab not clicked");
		}
		if(manage.Align_An_Agency()==true)
		{
			logger.log(LogStatus.PASS, "Align an agency for the GO Campaign","Agency partner successfully aligned the GO Campaign");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Align an agency for the GO Campaign","Fail,Agency partner not aligned");
		}
		
		
		logger.log(LogStatus.INFO,"Aligning Agent for GO by WS Admin completed");
		extent.endTest(logger);
		
		lp.logout();
	}

}
