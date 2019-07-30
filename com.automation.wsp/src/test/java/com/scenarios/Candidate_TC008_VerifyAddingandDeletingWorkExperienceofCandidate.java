package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CandidateProfilePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC008_VerifyAddingandDeletingWorkExperienceofCandidate extends Action_Method{

	public void addAndDeleteCandidateWorkExperience() throws InterruptedException
	   {
		   logger = extent.startTest("Candidate_TC008_VerifyAddingandDeletingWorkExperienceofCandidate");
		   driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		   logger.assignAuthor("Keerthana");
		   logger.assignCategory("Candidate General");
		   logger.setDescription("Login with valid Candidate Credentials and verify the profile edit button. Verify education details displayed in profile page based on addition,deletion and updation of education.");

		    
		   //launching url
	       wait_for_pageload(Variables.url);
	       logger.log(LogStatus.PASS, "Launched the url successfully");
	       
		   loginPage lp = PageFactory.initElements(driver, loginPage.class);
		   lp.EnterValidLogin(Variables.testdata, Variables.LoginPage,"Candidate Email", "Candidate Password");
		   logger.log(LogStatus.PASS, "Entered valid credentials");
		   
		   CandidateProfilePage cp = PageFactory.initElements(driver, CandidateProfilePage.class);
		   cp.ProfileTab();
		   String ex = cp.Display_TotalExpData();
		   logger.log(LogStatus.INFO,"Total Experience of candidate before editing the profile is :"+ex);
		   
		   int count = cp.getcountOfProfileWorkExp();
		   
		   if(cp.click_OnEditButton()) {
			   logger.log(LogStatus.PASS, "Candidate logged in successfully and clicked on Profile Edit icon");
		   }else {
			   logger.log(LogStatus.FAIL, "Candidate failed to login and click on Profile Edit icon");
		   }
		  
		   if (cp.VerifyProfileInformation_Page())
		   {
			   logger.log(LogStatus.PASS,"Sucessfully clicked on edit and navigated to Profile Information page");
		   }
		   else
		   {
			   logger.log(LogStatus.FAIL,"Failed to navigate to Profile Information page after clicking on edit");
		   }
		  
		   cp.click_OnNext();
		   
		   if (cp.VerifyVideoProfile_Page())
		   {
			   logger.log(LogStatus.PASS," Sucessfully clicked on next and navigated to Video Profile Page");
		   }
		   else
		   {
			   logger.log(LogStatus.FAIL,"Failed to navigate to Video Profile page when clicked on next");
		   }
		   cp.Video_ProfileNext();
		   
		   if(cp.VerifyVideoProfile_Page())
		   {
			   logger.log(LogStatus.PASS, "Successfully clicked on next and navigated to Education page");
		   }
		   else
		   {
			   logger.log(LogStatus.FAIL, "Failed to navigate to Education page when clicked on next");
		   }
		   scrollingToBottomofAPage();
		   cp.Education_Next();
			 
		   if(cp.VerifyWorkExp_Page())
		   {
			   logger.log(LogStatus.PASS, "Successfully cliked on next and navigated to Work Experience page");
		   }
		   else
		   {
			   logger.log(LogStatus.FAIL, "Failed to navigate to Work Experience page");
		   }
		   
		   if(cp.addWorkExperience()) {
			   logger.log(LogStatus.PASS, "Successfully added new Work Experience details for the candidate.");
		   } else {
			   logger.log(LogStatus.FAIL, "Failed to add new Work Experience details for the candidate.");
		   }
		   
		   cp.clickOnProfile();
		   int addedExpCount = cp.getcountOfProfileWorkExp();
		   
		   if(count!=addedExpCount) {
			   logger.log(LogStatus.PASS, "Before adding new Work Experience details the count was "+count+" Count after Successfully adding the Work Experience is "+addedExpCount+" in profile page");
		   }else {
			   logger.log(LogStatus.FAIL, "Failed to display the added Work Experience in profile page");
		   } 
		   cp.click_OnEditButton();
		   cp.click_OnNext();
		   cp.Video_ProfileNext();
		   cp.Education_Next();
		   if(cp.deleteWorkExperience()) {
			   logger.log(LogStatus.PASS, "Successfully deleted  Work Experience details for the candidate.");
		   } else {
			   logger.log(LogStatus.FAIL, "Failed to delete Work Experience details for the candidate.");
		   } 
		   cp.clickOnProfile();
		   int deletedExpCount = cp.getcountOfProfileWorkExp();
		   
		   if(addedExpCount!=deletedExpCount) {
			   logger.log(LogStatus.PASS, "Before deleting Work Experience details the count was "+addedExpCount+" Count after Successfully deleting the Work Experience is "+deletedExpCount+" in profile page");
		   }else {
			   logger.log(LogStatus.FAIL, "Deleted Work Experience is still viewed in profile page");
		   } 
		   int updatedElement = cp.getcountOfProfileWorkExp();
		   cp.click_OnEditButton();
		   cp.click_OnNext();
		   cp.Video_ProfileNext();
		   cp.Education_Next();
		   
		   if(cp.updateWorkExp()) {
			   logger.log(LogStatus.PASS, "Successfully updated  Work Experience details for the candidate.");
		   } else {
			   logger.log(LogStatus.FAIL, "Failed to update Work Experience details for the candidate.");
		   } 
		   cp.clickOnProfile();
		   int updatedExpCount = cp.getcountOfProfileWorkExp();
		   
		   if(updatedExpCount == updatedElement) {
			   logger.log(LogStatus.PASS, "Before updating Work Experience details the count was "+updatedElement+" Count after Successfully updating the Work Experience is "+updatedExpCount+" in profile page");
		   }else {
			   logger.log(LogStatus.FAIL, "Deleted Work Experience is still viewed in profile page");
		   } 
		   
		   logger.log(LogStatus.INFO, "Vrified the addition,deletion and updation of Work Experience details for the candidate.");
		   
		   lp.logout();
		   extent.endTest(logger); 
	   }
		   
}
