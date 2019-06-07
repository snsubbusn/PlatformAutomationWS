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

public class Candidate_TC017_VerifyAddingDeletingAndUpdatingSkillsofCandidate  extends Action_Method
{

	public void validatingAddDelAndUpdateSkillsField() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException
	{
		logger = extent.startTest("Candidate_TC017_VerifyAddingDeletingAndUpdatingSkillsofCandidate");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Natasha");
		logger.assignCategory("Candidate General");
		logger.setDescription("Login with valid Candidate Credentials and verify the profile edit button, Verify Delete the skills and verify the skills is deleted from the main profile page.Add Skills and verify the skills are displayed in the main profile page.Edit a skill and verify the skills are updated in the main profile page.");


		//launching url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the url successfully");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage,"Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Entered valid credentials");

		CandidateProfilePage cp = PageFactory.initElements(driver, CandidateProfilePage.class);
		cp.ProfileTab();
		//Add Skills and verify the skills are displayed in the main profile page.
		int takeCount = cp.takeSkillCount();
		int finalCount = cp.AddSkillAndVerifyProfile();


		if(takeCount!=(finalCount))
		{
			logger.log(LogStatus.PASS, "Successfully added a new skill, Count before skill added is "+takeCount+" and after skill added is "+finalCount);
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to add a new skill, Count before skill added is "+takeCount+" and after skill added is "+finalCount);
		}

		//Skill Update
		int takeCountBeforeUpdate = cp.takeSkillCount();
		int countAfterUpdation = cp.UpdateSkillAdded();
		if(takeCountBeforeUpdate==countAfterUpdation)
		{
			logger.log(LogStatus.PASS, "Skill updated successfully, Skill count before updation is "+takeCountBeforeUpdate+ " and count for update is " +countAfterUpdation);
		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to update the skill");
		}

		//Skill Delete
		int takeCountBeforeDel = cp.takeSkillCount();
		int countAfterDeletion = cp.DeleteSkillAndVerifyProfile();

		if(takeCountBeforeDel!=countAfterDeletion)
		{
			logger.log(LogStatus.PASS,"Successfully deleted a skill, Skill count before deletion is "+takeCountBeforeDel+ " and Count after deletion is "+countAfterDeletion);

		}
		else
		{
			logger.log(LogStatus.FAIL,"Failed to delete a skill, Skill count before deletion is "+takeCountBeforeDel+ " and Count after deletion is "+countAfterDeletion);
		}

		lp.logout();
		extent.endTest(logger);
	}
}


