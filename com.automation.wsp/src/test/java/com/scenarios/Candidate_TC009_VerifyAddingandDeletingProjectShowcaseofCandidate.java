package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CandidateProfilePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC009_VerifyAddingandDeletingProjectShowcaseofCandidate extends Action_Method
{

	public void ProjectShowcase() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		logger = extent.startTest("Candidate_TC009_VerifyAddingandDeletingProjectShowcaseofCandidate");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Natasha");
		logger.assignCategory("Candidate General");
		logger.setDescription("Login with valid Candidate Credentials and verify the profile page is displayed. Click on Edit button and verify the user navigated to Work Experience section. Add Project Showcase and verify the added Project Showcase is displayed in the main profile page.Delete the already present Project Showcase and verify the Project Showcase is removed from the main profile page.\r\n" + 
				"Update the Project Showcase details by editing the Project Showcase and verify the updated details are displayed in the main profile page.");
	
	
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "URL launched successfully");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage, "Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Entered valid credentails");

		CandidateProfilePage vr = PageFactory.initElements(driver, CandidateProfilePage.class);
		vr.ProfileTab();
		
		int cnt = vr.getProjectCount();
		if(cnt!=0)
		{
			logger.log(LogStatus.INFO,"The count of project showcase is "+cnt);
		}
		
		vr.click_OnEditButton();
		logger.log(LogStatus.PASS,"Clicked on edit icon and navigated to profile information page ");
		vr.click_OnNext();
		vr.Video_ProfileNext();
		vr.Education_Next();
		if(vr.VerifyWorkExp_Page())
		{
			logger.log(LogStatus.PASS,"Successfully navigated to Project Showcase page");
			
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to navigate to Project showcase page");
		}
		
		if(vr.VerifyAddingOfProjectShowcase())
		{
			logger.log(LogStatus.PASS," Entered all mandatory data from excrl sheet. New project added successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to add new Project showcase page");
		}
		
		int finalCount = vr.getProjectCount();
		logger.log(LogStatus.INFO,"Project Showcase count before adding project data is "+cnt+ "Count after project data is added is "+finalCount);
		if(cnt!=finalCount)
		{
			logger.log(LogStatus.PASS, "Project Showcase added successfully and visible under Profile page");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to add the project showcase");
		}
		logger.log(LogStatus.INFO, "Completed verifying addition of Project Showcase");
		
		//deleting Project Showcase
		
		vr.click_OnEditButton();
		logger.log(LogStatus.PASS,"Clicked on edit icon and navigated to profile information page ");
		vr.click_OnNext();
		vr.Video_ProfileNext();
		vr.Education_Next();
		if(vr.VerifyWorkExp_Page())
		{
			logger.log(LogStatus.PASS,"Successfully navigated to Project Showcase page");
			
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to navigate to Project showcase page");
		}
		
		if(vr.deleteProjtShowcase())
		{
			logger.log(LogStatus.PASS," Added project shocase deleted successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to delete Project showcase ");
		}
		
		int finalDelCount = vr.getProjectCount();
		logger.log(LogStatus.INFO,"Project Showcase count before deleting project data is "+finalCount+ "Count after project data is deleted is "+finalDelCount);
		if(finalDelCount!=finalCount)
		{
			logger.log(LogStatus.PASS, "Project Showcase deleted successfully!");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to delete the project showcase");
		}
		logger.log(LogStatus.INFO, "Completed verifying deletion of Project Showcase");
		
		lp.logout();
		extent.endTest(logger);
	
	}
	
}
