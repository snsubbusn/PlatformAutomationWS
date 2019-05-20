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

public class Candidate_TC004_VerifyAddingandDeletingSkillsofCandidate extends Action_Method
{

	public void validatingSkillsField() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException
	{
		logger = extent.startTest("Candidate_TC004_VerifyAddingandDeletingSkillsofCandidate");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Natasha");
		logger.assignCategory("Candidate General");
		logger.setDescription("Login with valid Candidate Credentials and verify the profile edit button. Verify the user is able to add skills to the maximum allowed. Delete the skills and verify the skills is deleted from the main profile page.Add Skills and verify the skills are displayed in the main profile page.Edit a skill and verify the skills are updated in the main profile page.");


		//launching url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the url successfully");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage,"Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Entered valid credentials");

		CandidateProfilePage cp = PageFactory.initElements(driver, CandidateProfilePage.class);
		if(cp.verifyMaxSkillLimit())
		{

			logger.log(LogStatus.PASS, "Maximum Must Have Skill limit verified successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to verify maximum limit for Must have Skill limit");
		}
		cp.deleteSkills(1);


		if(cp.limitForOtherSkills())
		{
			logger.log(LogStatus.PASS, "Maximum Good to Have Skill limit verified successful");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to verify maximum limit for Good to have Skill limit");
		}
		cp.deleteSkills(2);
		
		lp.logout();
		extent.endTest(logger);
	}
	
}

