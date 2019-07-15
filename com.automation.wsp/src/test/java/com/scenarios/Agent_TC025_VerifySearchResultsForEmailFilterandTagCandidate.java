package com.scenarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.AgencyPartnerGenPage;
import com.objects_pages.MyAssignmentsPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Agent_TC025_VerifySearchResultsForEmailFilterandTagCandidate extends Action_Method{

	public void verifySearchResultsForEmailFilterandTagCandidate() throws InterruptedException {
		logger = extent.startTest("Agent_TC025_VerifySearchResultsForEmailFilterandTagCandidate");
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Agency Partner General");
		logger.setDescription("Agency Logs in and click on \"Active Assignments\" tab. Verify Jobs present under Active Assignments and click on 'Assign Candidates'. Click on \"Tag Existing\" Tab and search with Email filters");

		//Launching URL
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and the Login Page is displayed");


		//LoginPage Object creation
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		//Login as Agency Partner
		lp.EnterValidLogin(Variables.testdata, Variables.LoginPage, "Agency Email", "Agency Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button, Agency Partner Landing page is displayed");

		AgencyPartnerGenPage ag = PageFactory.initElements(driver, AgencyPartnerGenPage.class);

		if(ag.verifyAgentLogin()) {
			logger.log(LogStatus.PASS, "Verified the Agent has logged in successfully");
		}else {
			logger.log(LogStatus.FAIL, "Agency partner login failed. NewAssignments tab is not displayed.");
		}

		MyAssignmentsPage my = PageFactory.initElements(driver, MyAssignmentsPage.class);
		if(my.click_On_ActiveAssignmentTab()) {
			logger.log(LogStatus.PASS, "Navigated to \"Active Assignments\" Page");

			String New = my.getFirstJobCardDetails();
			logger.log(LogStatus.PASS, "The First Job Card details under Active Assignments of the Agent are :- "+New);
			int start = New.indexOf("#");
			String jobId = New.substring(start+1);
			if(my.Click_Assign_Candidate(jobId)) {
				logger.log(LogStatus.PASS, "Clicked on the first job card Assign Candidate.");
			}else {
				logger.log(LogStatus.FAIL, "Failed to click on Assign Candidate of first job card");
			}

			String myass = my.verifyNavigatedtoMyAssignmentsPage();
			if(myass.contains("My Assignments")) {
				logger.log(LogStatus.PASS, "Navigated to \"My Assignments\" Page of the selected Job Id.");
			}else {
				logger.log(LogStatus.FAIL, "Failed to navigate to \"My Assignments\" Page of the selected Job Id");
			}

			String select = my.getSelectedTabDetails();
			if(select.contains("Tag Existing")) {
				logger.log(LogStatus.PASS, "The default tab displayed for the My Assignments of the Job is - "+select);
			}else {
				logger.log(LogStatus.FAIL, "The default tab displayed is not Tag Existing. It is - "+select);
			}


			if(my.verifySearchTalentImageIsDisplayed()) {
				logger.log(LogStatus.PASS, "Verified the Search Talent image is displayed. Hence no search has been performed by default");
			}else {
				logger.log(LogStatus.FAIL, "Could not find the Search Talent Image. There might be search result displayed by default");
			}


			logger.log(LogStatus.INFO, "Verify the no of results for Search with No Filters applied");
			my.clickOnSearchButton();

			String result = my.getResultsDetails();

			if(result.contains("Found")) {
				logger.log(LogStatus.PASS, "Clicked on Search button without any filters. The details displayed are :-"+result);
			}else {
				logger.log(LogStatus.FAIL, "Failed to Clicked on Search button and no results are displayed:- "+result);
			}
			
			if(my.clickOnFirstCandidateSearchResult()) {
				logger.log(LogStatus.PASS, "First Candidate Clicked successfully");
			}else {
				logger.log(LogStatus.FAIL, "No First Candidate available to click in the search results");
			}
			
			String email = my.getEmailOfCandidate();
			if(my.clickBackButtonofCandidateProfile()) {
				logger.log(LogStatus.PASS, "Obtained the Email of the first candidate and clicked on back button to the search results. The Email is - "+email);
			}else {
				logger.log(LogStatus.FAIL, "Failed to click on back button");
			}
			
			logger.log(LogStatus.INFO, "Clear the filter and search with the obtained email");

			my.clickOnClearAllFilterButton();

			logger.log(LogStatus.PASS, "Cleared the filter successfully");

			my.searchForEmailFilter(email);

			my.clickOnSearchButton();
			String result1 = my.getResultsDetails();


			String pattern = "([0-9]+)";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(result);
			Matcher n = r.matcher(result1);
			if(m.find()&&n.find()) {
				logger.log(LogStatus.PASS, "Before the email filter the results had "+m.group(0)+" candidates. After applying Email filer the results had "+n.group(0)+" candidate");
			}else {
				logger.log(LogStatus.FAIL, "Before the email filter the results had "+m.group(0)+" candidates. After applying Email filer the results had "+n.group(0)+" candidate");
			}

		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to \"Active Assignments\" Page");
		}

		logger.log(LogStatus.INFO, "Completed Verifying searching Tag Existing with EMail filters");

		lp.logout();
		extent.endTest(logger);

	}
}
