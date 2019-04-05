package com.scenarios;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.CandidateProfilePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC005_VerifyValidationOfUploadingCV extends Action_Method
{
	public void VerifyCandidateResumeEdit() throws InterruptedException
	{
		logger = extent.startTest("Candidate_TC005_VerifyValidationOfUploadingCV");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		logger.assignAuthor("Natasha");
		logger.assignCategory("Candidate General");
		logger.setDescription("Login with valid Candidate Credentials and verify the profile edit button. Verify the user navigate to CV page. Upload a new CV and verify the uploaded CV is displayed in the main profile page.");

		//launching url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the url Successfully");

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage,"Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Entered valid credentials");

		CandidateProfilePage re = PageFactory.initElements(driver,CandidateProfilePage.class);
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		String de= re.ResumeSource();
		
		if(re.ClickonEdit())
		{
			logger.log(LogStatus.PASS, "Successfully clicked on edit button");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Failed to click on edit button");
		}

		re.ClickOn_ViewCV();
		if(re.Update())
		{
			logger.log(LogStatus.PASS, "Successfully clicked on View CV and viewed update CV modal");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed to view the update cv modal");
		}
		re.Update_CV();
		String msg = re.verifySuccessMsg();
		if(msg.contains("updated successfully")) {
			logger.log(LogStatus.PASS, "Success message displayed is :" +msg);
		}else {
			logger.log(LogStatus.FAIL, "Success message displayed is :" +msg);
		}
		re.Close_Button();
		Thread.sleep(2000);
		re.ProfileTab();
		String pr = re.ResumeSource();
		if(pr.equals(de))
		{
			logger.log(LogStatus.FAIL,"Resume updation failed");
		}
		else
		{
			logger.log(LogStatus.PASS,"Resume updated successfully");
		}
		lp.logout();
		extent.endTest(logger);
	}


}



