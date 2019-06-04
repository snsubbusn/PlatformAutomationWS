package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CandidateProfilePage;
import com.objects_pages.Candidate_MyEngagementsPage;
import com.objects_pages.Candidate_VideoCapture;
import com.objects_pages.Corporate_PostVideoJD_AddSkillsPage;
import com.objects_pages.Corporate_PostVideoJD_AddVideoPage;
import com.objects_pages.Corporate_PostVideoJD_JobSummaryPage;
import com.objects_pages.MyInterviewPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC006_VerifyVideoCapturingOfCandidateProfile extends Action_Method {

	public void CandidateVideoCapture() throws InterruptedException
	{
		logger = extent.startTest("Candidate_TC006_VerifyVideoCapturingOfCandidateProfile");
		logger.assignAuthor("Keerthana");
		logger.assignCategory("Candidate General");

		logger.setDescription("Candidate Logs in and click on My Engagements and verifies pagination and campaign cards to which the candidate is tagged,present in the My Engagements Page");

		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and the Login Page is displayed");

		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as  candidate
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage, "Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Candidate Profile Landing page is displayed");

		CandidateProfilePage videopag = PageFactory.initElements(driver, CandidateProfilePage.class);
		videopag.ProfileTab();
		String src = videopag. getSrcofVideo();
		System.out.println(src);
		//System.out.println(src);


		if(src.contains("gif")){

			logger.log(LogStatus.PASS, "No video displayed,Candidate has to upload New video");

			if(videopag.click_OnEditButton()) {
				logger.log(LogStatus.PASS, "Candidate logged in successfully and clicked on Profile Edit icon");
			}else {
				logger.log(LogStatus.FAIL, "Candidate failed to login and click on Profile Edit icon");
			} 

			if (videopag.VerifyProfileInformation_Page()) {
				logger.log(LogStatus.PASS,"Sucessfully clicked on edit and navigated to Profile Information page");
			}else {
				logger.log(LogStatus.FAIL,"Failed to navigate to Profile Information page after clicking on edit");
			}

			videopag.click_OnNext();

			if (videopag.VerifyVideoProfile_Page()) {
				logger.log(LogStatus.PASS," Sucessfully clicked on next and navigated to Video Profile Page");
			}else {
				logger.log(LogStatus.FAIL,"Failed to navigate to Video Profile page when clicked on next");
			}

			logger.log(LogStatus.INFO, "Capturing candidate profile video");
			videopag.captureCandidateNewVideo();
			logger.log(LogStatus.PASS, "Completed Capturing Candidate New Profile Video");

			videopag.Video_ProfileNext();

			if(videopag.VerifyEducation_Page()) {
				logger.log(LogStatus.PASS, "Successfully clicked on next and navigated to Education page");
			} else {
				logger.log(LogStatus.FAIL, "Failed to navigate to Education page when clicked on next");
			}

			videopag.Education_Next();

			if(videopag.VerifyWorkExp_Page()) {
				logger.log(LogStatus.PASS, "Successfully cliked on next and navigated to Work Experience page");
			} else {
				logger.log(LogStatus.FAIL, "Failed to navigate to Work Experience page");
			}

			videopag.Finish_Button();

			if(videopag.ProfileView_Page())   {
				logger.log(LogStatus.PASS, "Successully clicked on Finish and navigate to Profile view page");
			} else  {
				logger.log(LogStatus.FAIL, "Failed to navigate to profile view page");
			}

			String videoafteredit = videopag.getSrcofVideo();

			if(src == videoafteredit) {
				logger.log(LogStatus.FAIL, "Failed to upload the video");
			} else  {
				logger.log(LogStatus.PASS, "New video is uploaded successfully");
			}
		}

		if(src.contains("s3")|| src.contains("MyInterview")) {

			logger.log(LogStatus.PASS, "Video present,Candidate has to update New video");

			if(videopag.click_OnEditButton()) {
				logger.log(LogStatus.PASS, "Candidate logged in successfully and clicked on Profile Edit icon");
			}else {
				logger.log(LogStatus.FAIL, "Candidate failed to login and click on Profile Edit icon");
			} 

			if (videopag.VerifyProfileInformation_Page()) {
				logger.log(LogStatus.PASS,"Sucessfully clicked on edit and navigated to Profile Information page");
			}else {
				logger.log(LogStatus.FAIL,"Failed to navigate to Profile Information page after clicking on edit");
			}

			videopag.click_OnNext();

			if (videopag.VerifyVideoProfile_Page()) {
				logger.log(LogStatus.PASS," Sucessfully clicked on next and navigated to Video Profile Page");
			}else {
				logger.log(LogStatus.FAIL,"Failed to navigate to Video Profile page when clicked on next");
			}

			logger.log(LogStatus.INFO, "Capturing candidate profile video");
			videopag.captureCandidateVideo();
			logger.log(LogStatus.PASS, "Completed Capturing Candidate New Profile Video");

			videopag.Video_ProfileNext();

			if(videopag.VerifyEducation_Page()) {
				logger.log(LogStatus.PASS, "Successfully clicked on next and navigated to Education page");
			} else {
				logger.log(LogStatus.FAIL, "Failed to navigate to Education page when clicked on next");
			}

			videopag.Education_Next();

			if(videopag.VerifyWorkExp_Page()) {
				logger.log(LogStatus.PASS, "Successfully cliked on next and navigated to Work Experience page");
			} else {
				logger.log(LogStatus.FAIL, "Failed to navigate to Work Experience page");
			}

			videopag.Finish_Button();
			Thread.sleep(1000);
			videopag.ProfileTab();
			if(videopag.ProfileView_Page())   {
				logger.log(LogStatus.PASS, "Successully clicked on Finish and navigate to Profile view page");
			} else  {
				logger.log(LogStatus.FAIL, "Failed to navigate to profile view page");
			}

			String videoafteredit = videopag.getSrcofVideo();

			if(src == videoafteredit) {
				logger.log(LogStatus.FAIL, "Failed to update the video");
			} else  {
				logger.log(LogStatus.PASS, "New video is updated successfully");
			}
		}

		lp.logout();
		extent.endTest(logger);	
	}
}





