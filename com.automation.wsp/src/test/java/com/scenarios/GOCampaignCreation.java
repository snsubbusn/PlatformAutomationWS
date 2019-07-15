package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Corporate_PostVideoJD_AddSkillsPage;
import com.objects_pages.Corporate_PostVideoJD_AddVideoPage;
import com.objects_pages.Corporate_PostVideoJD_JobSummaryPage;
import com.objects_pages.EngageAgencyPartnersPage;
import com.objects_pages.ManageResponsesPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class GOCampaignCreation extends Action_Method {

	public void guaranteedOnboardingCampaignCreation() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		
		logger = extent.startTest("GOCampaignCreation_01");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Guaranteed Onboarding-BasicFlow");
		logger.setDescription("Guaranteed Onboarding Basic Flow - Corporate Campaign Creation");
		
		// Launching the URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Corporate Landing page displayed");
		//Creating object for Job summary page
		
		Corporate_PostVideoJD_JobSummaryPage Cjs=PageFactory.initElements(driver,Corporate_PostVideoJD_JobSummaryPage.class);     
		EngageAgencyPartnersPage en=PageFactory.initElements(driver,EngageAgencyPartnersPage.class);
		Cjs.ClickOnPostVideoJD_Tab();
		logger.log(LogStatus.PASS, "Clicked on Post video JD tab and Job summary page displayed");
		Cjs.Complete_JobSummaryPage();
		logger.log(LogStatus.PASS, "Complete Job summary page with valid data and click on Next button ,Add skill page displayed");
		
		//Creating object for Add skills page
		
		Corporate_PostVideoJD_AddSkillsPage Cas=PageFactory.initElements(driver,Corporate_PostVideoJD_AddSkillsPage.class);
		Cas.Complete_AddskillsPage(Variables.testdata,Variables.Corporate_AddSkillsPage);
		logger.log(LogStatus.PASS, "Complete Add skill page with valid data and click on Next button ,Add Video page displayed");
		
		//Creating object for Add Video page
		
		Corporate_PostVideoJD_AddVideoPage cav=PageFactory.initElements(driver,Corporate_PostVideoJD_AddVideoPage.class);
		cav.Complete_AddvideoPage();
		logger.log(LogStatus.PASS, "Complete Add Video page with complete video recording and click on save button ,Job posted successfully");
		
		logger.log(LogStatus.PASS, "Post Video JD Test Case Completed");
		
	
		//Perform Guaranteed On boarding
		
		
		//Click on "Get Guaranteed Response for particular Job
		if(en.Click_On_GuaranteedOnboarding(en.GetJobID())==true)
		{
			logger.log(LogStatus.PASS, "Click on Guarnateed Onboarding button for particular Job, Guarnateed Onboarding button clicked successfully");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Click on Guarnateed Onboarding button for particular Job, Unable to click on Guarnateed Onboarding button of a Job");
			
		}
		//Calculate estimated value before guaranteed submission
		String e = en.EnterPaymentForGuaranteedOnboarding("1");
		ManageResponsesPage mrp = PageFactory.initElements(driver, ManageResponsesPage.class);
		
		if(e.equalsIgnoreCase("Pass"))
		{
			logger.log(LogStatus.PASS, "Enter the No of Positions for GO, accept payment and click on Submit, GO positions entered, accepted the payment and clicked on Submit button");
			Thread.sleep(5000);
			String GOdetails = mrp.VerifyGOCampaignCreation(getExceldata(Variables.testdata,Variables.SetData_Excel,"Job ID"));
			logger.log(LogStatus.INFO, "GO Campaign has been created and the details of the campaign are - "+ GOdetails);
			logger.log(LogStatus.INFO, "Guaranteed Onboarding campaign creation flow completed");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Enter the No of Positions for GO, accept payment and click on Submit","Unable to process payment for GO. The Exception is "+e);
			
			logger.log(LogStatus.INFO, "Guaranteed Onboarding campaign creation flow Failed");
		}
	
		lp.logout();
				
		extent.endTest(logger);
	}
}
