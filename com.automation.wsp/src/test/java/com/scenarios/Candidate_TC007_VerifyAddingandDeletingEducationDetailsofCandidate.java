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
		   cp.Education_Next();

	}

}
