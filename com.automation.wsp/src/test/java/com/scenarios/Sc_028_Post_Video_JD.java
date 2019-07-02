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
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;
// Verify Post video JD by corporate admin
public class Sc_028_Post_Video_JD extends Action_Method
{
	public void Verify_Post_Video_Jd() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		logger = extent.startTest("GS_01_SC_028_Verifying video Posting by Corporate");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Guaranteed Submission - BasicFlow");
		logger.setDescription("Login as Corporate and Post Job by entering the Job Summary, Skills and capture the Job Description Video");
	
		//Launching the url
		
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button,Corporate Landing page displayed");
	
		//Creating object for Job summary page
		Corporate_PostVideoJD_JobSummaryPage Cjs=PageFactory.initElements(driver,Corporate_PostVideoJD_JobSummaryPage.class);
		//Corporate_ProfilePage cpp = PageFactory.initElements(driver,Corporate_ProfilePage.class);
		Cjs.ClickOnPostVideoJD_Tab();
		logger.log(LogStatus.INFO, "Clicked on Post video JD tab and Job summary page displayed");
		Cjs.Complete_JobSummaryPage();
		logger.log(LogStatus.INFO, "Complete Job summary page with valid data and click on Next button ,Add skill page displayed");
		
		//Creating object for Add skills page
		
		Corporate_PostVideoJD_AddSkillsPage Cas=PageFactory.initElements(driver,Corporate_PostVideoJD_AddSkillsPage.class);
		Cas.Complete_AddskillsPage(Variables.testdata,Variables.Corporate_AddSkillsPage);
		logger.log(LogStatus.INFO, "Complete Add skill page with valid data and click on Next button ,Add Video page displayed");
		
		//Creating object for Add Video page
		
		Corporate_PostVideoJD_AddVideoPage cav=PageFactory.initElements(driver,Corporate_PostVideoJD_AddVideoPage.class);
		cav.Complete_AddvideoPage();
		logger.log(LogStatus.INFO, "Complete Add Video page with complete video recording and click on save button ,Job posted successfully");
		
		logger.log(LogStatus.INFO, "Post Video JD Test Case Completed");
		
		extent.endTest(logger);
	}
	
}
