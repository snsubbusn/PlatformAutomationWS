package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Candidate_Edit_EducationdetailsPage;
import com.objects_pages.Corporate_Add_Management_profile;
import com.objects_pages.Corporate_ProfilePage;
import com.objects_pages.Corporate_Profile_OfficeLocations_Page;
import com.objects_pages.WSAdminUsersPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC007_VerifyAddingandDeletingEducationDetailsofCandidate extends Action_Method{
	
	public void VerifyAddingandDeletingEducationDetailsofCandidate() throws InterruptedException {
		logger = extent.startTest("Candidate_TC007_VerifyAddingandDeletingEducationDetailsofCandidate");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		logger.assignAuthor("Subramanya");
		logger.assignCategory("Edit Candidate profile - Education page");
		logger.setDescription("Login as Candidate, Edit profile, Navigate to Education page, Add New education, Update education, Delete education and verify in the profile page ");
		
		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and login page is displayed");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Candidate Email","Candidate Password");
		
		

		Candidate_Edit_EducationdetailsPage landP = PageFactory.initElements(driver, Candidate_Edit_EducationdetailsPage.class);

        
		
		if(landP.Verify_ProfileHeadline()){
			logger.log(LogStatus.PASS, "Profile Headline is verified Successfully");
		}else {
			logger.log(LogStatus.FAIL, "Profile Headline verification is failed");
		}
		
		logger.log(LogStatus.INFO, "Click on Edit Profile button, Navigate to education page and verify Education heading");
		
		//Click on Profile edit button and navigate to Education page
		
		boolean edu = landP.navigatetoeducation();
        
		if(edu){
			logger.log(LogStatus.PASS, "@ Education page Heading is verified successfully.");
		}else {
			logger.log(LogStatus.FAIL, "@ Education page Heading verification is failed");
		}
		
		logger.log(LogStatus.INFO, "Add New Education in the education page");
		
		//Add New Education in the education page
		String addedu = landP.addneweducation();
       		
		if(addedu.equalsIgnoreCase("Success")) {
			logger.log(LogStatus.PASS, "Education added successfully in the education page");
		}else {
			logger.log(LogStatus.FAIL, "Adding Education in eduation page is failed");
		}
		
		
		//Verify added education in the Profile page
		
		String getedu = landP.clickonProfileandVerifyeducation();
		
		if(getedu.equals("Bachellors degree with Computer science as major subject")){
			logger.log(LogStatus.PASS, "Education added is verified in the profile page successfully.");
		}else {
			logger.log(LogStatus.FAIL, "Education added verification in the profile page failed.");
		}
		
		logger.log(LogStatus.INFO, "Update previously added Education in the education page");
		
		//Add Update Education in the education page
		
		if(landP.updateeducation()) {
			logger.log(LogStatus.PASS, "Verify Profile Edit page and navigate successfully to Education page ");
		}else {
			logger.log(LogStatus.FAIL, "Verify Profile Edit page and the screen failed to navigate to Education page");
		}
		//Verify updated education in the Profile page
				
				
				if(landP.clickonProfileandVerifyupdatededucation()){
					logger.log(LogStatus.PASS, "Education added is verified in the profile page successfully. The message received is ");
				}else {
					logger.log(LogStatus.FAIL, "Education added verification in the profile page failed. The message received is ");
				}
				
				logger.log(LogStatus.INFO, "Click on above added education and delete it");
				
		//Delete eduation and verify in the Profile page
				
				String deleteeducation = landP.deleteeducation();
				
				if(deleteeducation.equalsIgnoreCase("Success")){
					logger.log(LogStatus.PASS, "Education updated successfully. The message received is - "+deleteeducation);
				}else {
					logger.log(LogStatus.FAIL, "Adding new education is failed. The message received is - "+deleteeducation);
				}
		
		
		if(landP.clickonProfileandVerifydeletededucationinProfilePage()){
			logger.log(LogStatus.FAIL, "Deleted education is displayed");
		}else {
			logger.log(LogStatus.PASS, "Deleted education is not displayed");
		}
		
	
		logger.log(LogStatus.INFO, "Completed editing the profile and navigated to the Main Profile page");
		

		extent.endTest(logger);
		
		lp.logout();
		
	}
	
}
