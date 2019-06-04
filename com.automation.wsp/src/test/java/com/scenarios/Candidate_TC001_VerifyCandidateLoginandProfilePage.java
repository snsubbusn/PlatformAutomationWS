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

public class Candidate_TC001_VerifyCandidateLoginandProfilePage extends Action_Method
{
	public void VerifyingCandidateProfileViewPage() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		logger = extent.startTest("Candidate_TC001_VerifyCandidateLoginandProfilePage");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Natasha");
		logger.assignCategory("Candidate General");
		logger.setDescription("Login with valid Candidate credentials and verify the profile page is displayed. Also verify the email of the candidate matches with the logged in email for successful verification.");


		//Launch the URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "URL launched successfully");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage, "Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Entered valid credentails");

		CandidateProfilePage vr = PageFactory.initElements(driver, CandidateProfilePage.class);
		vr.ProfileTab();

		String CandidateEmail_Id = getExceldata(Variables.testdata, Variables.LoginPage,7,1);
		String obt = vr.FetchingCandidate_EmailId();

		if(CandidateEmail_Id.equals(obt))
		{
			logger.log(LogStatus.PASS,"Email of the candidate matches with the logged in email - "+obt);
		}
		else
		{
			logger.log(LogStatus.FAIL, "Email doesnot match.The Email of the candidate is "+obt);
		}

		if(vr.Verify_ProfileHeadline())
		{
			logger.log(LogStatus.PASS, "Profile Headline is verified");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Profile Headline cannot be verified");
		}

		String headline = vr.FetchingCandidateProfile_Headline();

		if(headline.contains("No Headline")) {
			logger.log(LogStatus.FAIL, "There is no profile headline" +headline);
		}
		else
		{
			logger.log(LogStatus.PASS, "The profile headline of the candidate is "+headline);	
		}


		if(vr.Verify_Profile_Picture())
		{
			logger.log(LogStatus.PASS, "Profile picture verified");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Profile picture cannot be verified");
		}

		if(vr.Verify_EditButton())
		{
			logger.log(LogStatus.PASS, "Edit button verified");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Edit button cannot be verified");
		}


		if(vr.Verify_Views_Count())
		{
			logger.log(LogStatus.PASS, "Profile view count is verified");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Profile view count is not verified");
		}

		String vc = vr.FetchingProfileView_Count();
		if(vc.contains("No View count")) {
			logger.log(LogStatus.FAIL, "There is no view count" +vc);
		}
		else
		{
			logger.log(LogStatus.PASS, "The view count of the candidate is "+vc);	
		}
		if(vr.Verify_Share_Icon())
		{
			logger.log(LogStatus.PASS, "Share icon is verified");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Share icon is not verified");
		}

		if(vr.Verify_Experience_Data())
		{
			logger.log(LogStatus.PASS, "Experiece data is verified");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Experience data is not verified");
		}

		if(vr.Verify_Skill_Rating())
		{
			logger.log(LogStatus.PASS, "Skill rating is verified");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Skill rating is not verified");
		}



		if(vr.Verify_Candidate_Inforamtion())
		{
			logger.log(LogStatus.PASS, "Candidate basic Information verified");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Candidate basic Information not verified" );
		}

		if(vr.Verify_Education())
		{
			logger.log(LogStatus.PASS, "Candidate Education Information verified");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Candidate Education Information not verified" );
		}


		lp.logout();
		extent.endTest(logger);
	}

}


