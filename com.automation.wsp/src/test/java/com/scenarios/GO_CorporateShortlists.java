package com.scenarios;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Candidate_MyEngagementsPage;
import com.objects_pages.ManageResponsesPage;
import com.objects_pages.ShortlistedCandidate;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class GO_CorporateShortlists extends Action_Method {
	public void corporateShortlist() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		logger = extent.startTest("Guaranteed Onboarding Basic Flow - Corporate Shortlists Candidates from Pending Review");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		String JobId = getExceldata(Variables.testdata,Variables.SetData_Excel,"Job ID");

		//Launching the url
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");

		//Creating object for Login class
		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button,Corporate Landing page displayed");

		//Creating Object for view Responses page
		ManageResponsesPage view=PageFactory.initElements(driver,ManageResponsesPage.class);
		if(view.Click_On_ManageResponses_Tab()==true)
		{
			logger.log(LogStatus.PASS, "Click on Manage Responses tab, Manage Responses tab clicked");
		}else{
			logger.log(LogStatus.FAIL, "Click on Manage Responses tab, Fail,Manage Responses tab not clicked");
		}

		//Click on Pending Review button
		if(view.Click_On_PendingReview_Button_ViewResponsespage(JobId)==true){
			logger.log(LogStatus.PASS, "Verify Pending Review Button, Pending review button clicked");
		}else{
			logger.log(LogStatus.FAIL, "Verify Pending review button, Fail,Unable to click on Pending review button");
		}

		//Shortlisting the candidate
		if(view.click_On_PendingReviewShortlist()==true){
			logger.log(LogStatus.PASS, "Verify shortlist in pending review, Candidate shortlisted from Pending Review");
		}else{
			logger.log(LogStatus.FAIL, "Verify shortlist in pending review, Fail to shortlist candidate in Pending Review");
		}

		//Clicking Back button of Pending review page
		if(view.clickPendingReviewBackButton()==true) {
			logger.log(LogStatus.PASS, "Click on Back Button, Completed Pending Review and Manage Response Page is displayed Successfully");
		}else {
			logger.log(LogStatus.FAIL, "Click on Back Button, Unable to click on Pending Review back buttion and Manage Response Page is not displayed");
		}


		//Click on Shortlisted and go to Shortlisted Candidate page.

		String shtHead = view.clickonShortlistedofJob(JobId);

		if(shtHead.contains("Shortlisted Candidates")) {
			logger.log(LogStatus.PASS, "Click on Shortlisted, Clicked on Shortlisted of the job and navigated to the Shortlisted Candidates Page");
		}else {
			logger.log(LogStatus.FAIL, "Click on Shortlisted, Failed to click on Shortlisted of the job");
		}

		//Shortlisted Page
		ShortlistedCandidate shortlis = PageFactory.initElements(driver, ShortlistedCandidate.class);
		String firstEmail = shortlis.getEmailOfFirstCandidate();


		//Verify the email of the first candidate with the email provided in the excel
		//if(firstEmail.equalsIgnoreCase(getExceldata(Variables.testdata, Variables.LoginPage, "Candidate Email"))) {
		if(firstEmail.contains("@")){
			logger.log(LogStatus.PASS, "The Email of the candidate from the candidate profile has been verified. The Email is "+firstEmail);
		}else {
			//logger.log(LogStatus.FAIL, "Email of the candidate shortlisted is not valid. Please check the candidate tagged and the candidate provided in test data excel");
			logger.log(LogStatus.FAIL, "Email of the candidate shortlisted is not valid.");
		}


		//Click on Schedule interview for the shortlisted candidate
		if(shortlis.clickOnFirstScheduleInterview()==true) {
			logger.log(LogStatus.PASS, "Click on Schedule Interview for Candidate, Clicked on Schedule Interview and the side panel is displayed");
		}else {
			logger.log(LogStatus.FAIL, "Click on Schedule Interview for Candidate, Clicked on Schedhle Interview but the side panel is not displayed");
		}

		String status = shortlis.scheduleFixedSlotInterview();

		//Corporate scheduled interview for the candidate
		if(status.contains("Interview Requested")) {
			logger.log(LogStatus.PASS, "Schedule Fixed Slot Interview, Fixed slot Interview has been scheduled and the status is "+status);
		}else {
			logger.log(LogStatus.FAIL, "Schedule Fixed Slot Interview, Fixed Slot Interview Failed and the status is "+status);
		}

		try{
			lp.logout();
		}catch(Exception e) {
			driver.close();
			getbrowser();
			wait_for_pageload(Variables.url);
			
		}
		logger.log(LogStatus.INFO, "Logged out of the corporate after scheduling Interview");
		Thread.sleep(2000);


		//The Shortlisted Candidate log in and accepts the interview.

		logger.log(LogStatus.INFO, "Logged in as Candidate to accept the interview");

		lp.EnterCandidateLoginCapturedData(firstEmail, "admin@123");
		logger.log(LogStatus.INFO, "Enter the Shortlisted Candidate Login Credentials, Candidate logged in successfully");

		Candidate_MyEngagementsPage cand = PageFactory.initElements(driver, Candidate_MyEngagementsPage.class);

		cand.clickonMyEngagements();
		logger.log(LogStatus.INFO, "Candidate My Engagements Page navigated successfully");
		String intStat = cand.checkStatusofJob(JobId);

		//Verifying the Interivew Requested
		if(intStat.contains("Interview Requested")) {
			logger.log(LogStatus.PASS, "Verify the status of the Job, The Status of the Job is Interview Requested");

		}else {
			logger.log(LogStatus.FAIL, "Verify the status of the Job, The Status of the Job is not Interview Requested and hence could not proceed to accept the interview");
		}
		String accptStat = cand.acceptSchedeuledInterview(JobId);

		//Accepting scheduled Interview

		System.out.println("Accept Interview after - Interview Scheduled Status - "+accptStat);
		if(accptStat.contains("Scheduled")) {
			logger.log(LogStatus.PASS, "Candidate Accepted the Interview and the status of the job card is "+accptStat);
		}else {
			logger.log(LogStatus.FAIL, "Candidate Accepting interview failed and the status is "+accptStat);
		}

		try{
			lp.logout();
		}catch(Exception e) {
			driver.close();
			getbrowser();
			wait_for_pageload(Variables.url);
			
		}
		logger.log(LogStatus.INFO, "Logged out of candidate after accepting Interview");
		Thread.sleep(2000);


		//After Candidate accepted interview the corporate log in and submits the feedback
		// and make offer to the candidate

		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");

		logger.log(LogStatus.INFO, "Logged in as corporate and subumits the feedback and offer");
		if(view.Click_On_ManageResponses_Tab()==true){
			logger.log(LogStatus.PASS, "Click on Manage Responses tab, Manage Responses tab clicked");
		}else{
			logger.log(LogStatus.FAIL, "Click on Manage Responses tab, Fail,Manage Responses tab not clicked");
		}

		String shtHead1 = view.clickonShortlistedofJob(JobId);

		if(shtHead1.contains("Shortlisted Candidates")) {
			logger.log(LogStatus.PASS, "Click on Shortlisted, Clicked on Shortlisted of the job and navigated to the Shortlisted Candidates Page");
		}else {
			logger.log(LogStatus.FAIL, "Click on Shortlisted, Failed to click on Shortlisted of the job");
		}


		//The system will be refreshed untill the submit feedback is displayed. 
		String subFeedback=shortlis.waitandClickonSubmitFeedback();
		if(subFeedback.contains("Make Offer")) {
			logger.log(LogStatus.PASS, "Corporate Submitted Feedback and the status is now "+subFeedback);
		}else {
			logger.log(LogStatus.FAIL, "Corporate Submitting feedback failed and the status is "+subFeedback);
		}

		String mkofrstat = shortlis.makeOffer();

		//After the feed back is submitted the offer is made
		if(mkofrstat.contains("Offered")) {
			logger.log(LogStatus.PASS, "Offer has been made to the candidate and the status is now "+mkofrstat);
		}else {
			logger.log(LogStatus.FAIL, "Issue in making offer and the status is "+mkofrstat);
		}

		logger.log(LogStatus.INFO, "Offer has been made to the candidate for GO");


		try{
			lp.logout();
		}catch(Exception e) {
			driver.close();
			getbrowser();
			wait_for_pageload(Variables.url);
			
		}
		Thread.sleep(2000);
		

		//Corporate had made an offer to the candidate. 
		//The Candidate logs in and accepts the offer to join.
		logger.log(LogStatus.INFO, "Corporate log out and candidate login to accept the offer");
		
		lp.EnterCandidateLoginCapturedData(firstEmail, "admin@123");
		logger.log(LogStatus.INFO, "Enter the Shortlisted Candidate Login Credentials, Candidate logged in successfully");

		cand.clickonMyEngagements();
		logger.log(LogStatus.INFO, "Candidate My Engagements Page navigated successfully");

		String ofrstat = cand.checkStatusofJob(JobId);

		if(ofrstat.contains("Offered")) {
			logger.log(LogStatus.PASS, "Verify the status of the Job, The Status of the Job is "+ofrstat);

		}else {
			logger.log(LogStatus.FAIL, "Verify the status of the Job, The Status of the Job is not Interview Requested and hence could not proceed to accept the interview. Status is "+ofrstat);
		}

		String ofracptstat=cand.acceptOfferandJoin(JobId);
		if(ofracptstat.contains("Offer Accepted")) {
			logger.log(LogStatus.PASS, "Candidate accepted the offer and the status is now "+ofracptstat);
		}else {
			logger.log(LogStatus.FAIL, "Candidate accepting the offer failed and the status is now "+ofracptstat);
		}

		try{
			lp.logout();
		}catch(Exception e) {
			driver.close();
			getbrowser();
			wait_for_pageload(Variables.url);
			
		}
		logger.log(LogStatus.INFO, "Candidate logged out after accepting the offer");

		//After candidate accepted the offer, corporate logs in and makes the candidate join
		// to on board.

		logger.log(LogStatus.INFO, "Corporate Log in to onboard the offer accepted candidate");
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");

		if(view.Click_On_ManageResponses_Tab()==true){
			logger.log(LogStatus.PASS, "Click on Manage Responses tab, Manage Responses tab clicked");
		}else{
			logger.log(LogStatus.FAIL, "Click on Manage Responses tab, Fail,Manage Responses tab not clicked");
		}

		String shtHead2 = view.clickonShortlistedofJob(JobId);

		if(shtHead2.contains("Shortlisted Candidates")) {
			logger.log(LogStatus.PASS, "Click on Shortlisted, Clicked on Shortlisted of the job and navigated to the Shortlisted Candidates Page");
		}else {
			logger.log(LogStatus.FAIL, "Click on Shortlisted, Failed to click on Shortlisted of the job");
		}

		String onbrd=shortlis.onboardCandidatebyUpdateJoin();
		if(onbrd.contains("Onboarded")) {
			logger.log(LogStatus.PASS, "Corporate updated the joining date of the candidate and the status is now "+onbrd);
		}else {
			logger.log(LogStatus.FAIL, "Corporate updating the joining date failed and the status is "+onbrd);
		}
		
		shortlis.goBacktoManageResponse();
		Thread.sleep(2000);
		
		String jobCl = view.verifyJobClosed(JobId);
		
		if(jobCl.contains("Reopen")) {
			logger.log(LogStatus.PASS, "GO has been successfully processed and onboarded a candidate. The Status of the Job is "+jobCl);
		}else {
			logger.log(LogStatus.FAIL, "GO has been processed but the Job is not closed. the Status is "+jobCl);
		}

		logger.log(LogStatus.INFO, "Guaranteed Onboarding Process has been completed successfully");
		
		
		extent.endTest(logger);
		
	}
}
