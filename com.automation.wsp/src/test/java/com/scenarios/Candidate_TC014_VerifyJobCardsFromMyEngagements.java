package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Candidate_MyEngagementsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Candidate_TC014_VerifyJobCardsFromMyEngagements extends Action_Method {
	public void VerifyJobCards() throws InterruptedException {
		
		logger = extent.startTest("Candidate_TC014_VerifyJobCardsFromMyEngagements");
		logger.assignAuthor("Keerthana");
		logger.assignCategory("Candidate General");

		logger.setDescription("Candidate Logs in and click on My Engagements and verify the job cards displayed and verify the total count of Jobs displayed per page is as value selectd in items per page.");


		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and the Login Page is displayed");


		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as  candidate
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage, "Candidate Email", "Candidate Password");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Candidate Profile Landing page is displayed");

		Candidate_MyEngagementsPage myEng = PageFactory.initElements(driver,Candidate_MyEngagementsPage.class);

		if(myEng.VerifyCandidateLogin()) {
			logger.log(LogStatus.PASS, "Verified the Candidate has logged in successfully");
		}
		else {
			logger.log(LogStatus.FAIL, "Candidate login failed. candidate profile tab is not displayed.");
		}

		logger.log(LogStatus.PASS, "Click on \"My Engagements\" Tab");
		myEng.ClickOn_MyEngagementsTab();

		String vme = myEng.VerifyMyEngagementsPage();
		if(vme.contains("My Engagements")) {
			logger.log(LogStatus.PASS, "My Engagements Page is displayed successfully");
		}
		else {
			logger.log(LogStatus.FAIL, "Failed to Navigate to \"My Engagements\" page.");
		}

		if(!myEng.VerifyJobCards()) {
			logger.log(LogStatus.PASS, "Candidate is tagged to one or more jobs");
			if(myEng.VerifyJobpage())
			{
				logger.log(LogStatus.PASS, "JD Page is displayed successfully,when clicked on job title of any campaign card");
				
				if(myEng.VerifyJobdetails()) {
					logger.log(LogStatus.PASS, "Job details to which the candidate tagged is displayed successfully.");
				}
				else {
						logger.log(LogStatus.FAIL, "Failed to display job details to which the candidate is tagged");
					}

				if(myEng.VerifyJobDescription()) {
					logger.log(LogStatus.PASS, "Job description is displayed successfully.");
				}
				else {
						logger.log(LogStatus.FAIL, "Failed to display job description");
					}

				if(myEng.VerifyJobmustskills()) {
					logger.log(LogStatus.PASS, "Job must have skills is displayed successfully.");
				}
				else {
						logger.log(LogStatus.FAIL, "Failed to display job must have skills");
					}
				
				if(myEng.VerifyJobgoodskills()) {
					logger.log(LogStatus.PASS, "Job good to have skills is displayed successfully.");
				}
				else {
						logger.log(LogStatus.INFO, "Failed to display job good to have skills");
					}
				if(myEng.CorporateWebsitePage()) {
					logger.log(LogStatus.PASS, "Successfully navigated to corporate official website");
				}
				else {
					logger.log(LogStatus.PASS, "Weblink isn't provided");
				}
				myEng.VerifyJobpage();
				if(myEng.Verifybackbutton()) {
					logger.log(LogStatus.PASS, "My Engagements page is displayed successfully,when clicked on back button.");
				}
				else {
						logger.log(LogStatus.FAIL, "Failed to display My Engagements page,when clicked on back button");
				}
			}
			else {
				logger.log(LogStatus.FAIL, "Failed to display Job page,when clicked on job title of any campaign card");
			}
		}
		else {
			logger.log(LogStatus.INFO, "Candidate is not tagged to any Job,No job cards present");
			}
	
			lp.logout();
			extent.endTest(logger);		
		}
	}


