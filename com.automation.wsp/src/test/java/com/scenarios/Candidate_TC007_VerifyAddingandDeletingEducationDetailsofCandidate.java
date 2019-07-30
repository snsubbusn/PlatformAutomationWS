package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CandidateProfilePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC007_VerifyAddingandDeletingEducationDetailsofCandidate extends Action_Method {

	public void addAndDeleteCandidateEducation() throws InterruptedException
	   {
		   logger = extent.startTest("Candidate_TC007_VerifyAddingandDeletingEducationDetailsofCandidate");
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
		   
		   int count = cp.getcountOfProfileEducation();
		   
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
		   
		   
		   if(cp.addEducation()) {
			   logger.log(LogStatus.PASS, "Successfully new education details is added for the candidate");
		   }else {
			   logger.log(LogStatus.FAIL, "Failed to add new education details for the candidate");
		   }
		   cp.clickOnProfile();
		   int finaladdedCount = cp.getcountOfProfileEducation();
		   
		   if(finaladdedCount!=count) {
			   logger.log(LogStatus.PASS, "Before adding new education details the count was "+count+" Count after Successfully adding the Education is "+finaladdedCount+" in profile page");
		   }else {
			   logger.log(LogStatus.FAIL, "Failed to display the added Education in profile page");
		   }
		   cp.closeSuccessMessage();
		   cp.click_OnEditButton();
		   cp.click_OnNext();
		   cp.Video_ProfileNext();
		   if(cp.deleteEducation()) {
			   logger.log(LogStatus.PASS, "Successfully education details is deleted for the candidate");
		   }else {
			   logger.log(LogStatus.FAIL, "Failed to delete the education details for the candidate");
		   }
		   cp.closeSuccessMessage();
		   cp.clickOnProfile();
		   
		   int finaldeletedCount = cp.getcountOfProfileEducation();
		   //int finaldeletedCount1 = cp.getcountOfProfileEducation();
		   
		   if(finaladdedCount!=finaldeletedCount) {
			   logger.log(LogStatus.PASS, "Before deleting  education details the count was "+finaladdedCount+" Count after Successfully deleting the Education is "+finaldeletedCount+" in profile page");
		   }else {
			   logger.log(LogStatus.FAIL, "Deleted Education is still displayed  in profile page");
		   }
		  //cp.closeSuccessMessage();
		   int updatedElement = cp.getcountOfProfileEducation();
		   cp.click_OnEditButton();
		   cp.click_OnNext();
		   cp.Video_ProfileNext();
		   
		   if(cp.updateEducation()) {
			   logger.log(LogStatus.PASS, "Successfully education details is updated for the candidate");
		   }else {
			   logger.log(LogStatus.FAIL, "Failed to delete the education details for the candidate");
		   }
		  
		   cp.clickOnProfile();
		   int updatedEduCount = cp.getcountOfProfileEducation();
		   
		   if(updatedEduCount == updatedElement) {
			   logger.log(LogStatus.PASS, "Before updating the Education details the count was "+updatedElement+" Count after Successfully updating Education details is "+updatedEduCount+" in profile page");
		   }else {
			   logger.log(LogStatus.FAIL, "Education isn't updated  in profile page");
		   } 
		   
		   logger.log(LogStatus.INFO, "Vrified the addition,deletion and updation of Education details for the candidate.");
		   
		   lp.logout();
		   extent.endTest(logger);
	}

}
