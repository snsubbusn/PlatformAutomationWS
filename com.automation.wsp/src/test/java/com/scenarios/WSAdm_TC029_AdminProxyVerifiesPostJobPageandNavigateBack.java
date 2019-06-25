package com.scenarios;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Corporate_PostVideoJD_JobSummaryPage;
import com.objects_pages.ManageJobPage;
import com.objects_pages.WSAdminProxyPage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class WSAdm_TC029_AdminProxyVerifiesPostJobPageandNavigateBack extends Action_Method {
	
	public void verifyPostjobsPageofProxy() throws InterruptedException {
		logger = extent.startTest("WSAdm_TC029_AdminProxyVerifiesPostJobPageandNavigateBack");
		logger.assignAuthor("Keerthana");
		logger.assignCategory("WSAdmin General");

		logger.setDescription("WS Admin Logs in and click on proxy and verify the proxy page and clicks on '+' icon and verifies all the fields in the job summary page and navigates back to proxy page.");


		wait_for_pageload(Variables.url);
		logger.log(LogStatus.PASS, "Launched the URL and the Login Page is displayed");

		loginPage lp=PageFactory.initElements(driver,loginPage.class);

		ManageJobPage mp = PageFactory.initElements(driver, ManageJobPage.class);
		
		Corporate_PostVideoJD_JobSummaryPage cjs=PageFactory.initElements(driver,Corporate_PostVideoJD_JobSummaryPage.class);
		
		WSAdminProxyPage ws = PageFactory.initElements(driver, WSAdminProxyPage.class);
		ws.acceptCookie();

		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Admin Email","AdminPassword");
		logger.log(LogStatus.PASS, "Enter valid login credential and click on Login button,Admin Landing page displayed");

		logger.log(LogStatus.PASS, "Click on \"Proxy\" Tab");

		Thread.sleep(6000);
		if(ws.clickonProxy()) {
			logger.log(LogStatus.PASS, "Proxy Page is displayed successfully");
		}
		else {
			logger.log(LogStatus.FAIL, "Failed to Navigate to \"Proxy \" page.");
		}

		if(!ws.verifyProxyCard()) {
			logger.log(LogStatus.FAIL,"No proxy corporate cards are viewed");
		} else {		
			logger.log(LogStatus.PASS, "proxy corporate cards are viewed");

			if(ws.clickOnFirstProxyCard() ) {
				logger.log(LogStatus.PASS, "Successfully clicked on first proxy card and navigated to 'Active Jobs' page of that respective proxy");
			} else {
				logger.log(LogStatus.FAIL, "Failed to Navigate to Active Jobs page of the respective proxy.");
			}
			if(ws.activeJobsDisplayed() ) {
				logger.log(LogStatus.PASS, "Active job page displayed successfully");
			}
			if(ws.clickOnAddButton()) {
				logger.log(LogStatus.PASS, "Successfully clicked on '+' icon and navigated to Job summary page of that respective proxy");
			} else {
				logger.log(LogStatus.FAIL, "Failed to Navigate to Job summary page of that respective proxy.");
			}
			
			//Verifying Job Summary text in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Job Summary\" text in Job Summary page");
			if(cjs.Verify_JobSummaryPageTitle()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"Job Summary\" text is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"Job Summary\" text is not available");
			}
			
			if(cjs.JobSummaryPageTitleText().trim().equals("Job Summary")) {
				logger.log(LogStatus.PASS, "Verify text of job summary page title in Job summary page","\"Job Summary\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of job summary page title in Job summary page","Text is not as per the requirement,Expected-\"Job Summary\" ,Actual-\""+cjs.JobSummaryPageTitleText().trim()+"\"");
			}

			//Verifying Requirement type field in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Requirement Type\" field in Job Summary page");
			if(cjs.Verify_RequirementType()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"Requirement Type\" field is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"Requirement Type\" field is not available");
			}
			
			if(cjs.RequirementTypeText().trim().equals("Requirement Type")) {
				logger.log(LogStatus.PASS, "Verify text of Requirement Type in Job summary page","\"Requirement Type\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of job summary page title in Job summary page","Text is not as per the requirement,Expected-\"Requirement Type\" ,Actual-\""+cjs.RequirementTypeText().trim()+"\"");
			}

			//Verifying JD Title field in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"JD Title\" field in Job Summary page");
			if(cjs.JdTitle()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"JD Title\" field is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"JD Title\" field is not available");
			}
			
			if(cjs.JD_TitleText().trim().equals("JD Title")) {
				logger.log(LogStatus.PASS, "Verify text of JD Title in Job summary page","\"JD Title\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of JD Title in Job summary page","Text is not as per the requirement,Expected-\"JD Title\" ,Actual-\""+cjs.JD_TitleText().trim()+"\"");
			}

			//Verifying Description field in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Description\" field in Job Summary page");
			if(cjs.Description()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"Description\" field is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"Description\" field is not available");
			}
			
			if(cjs.Description_Text().trim().equals("Description")) {
				logger.log(LogStatus.PASS, "Verify text of Description field in Job summary page","\"Description\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of Description field in Job summary page","Text is not as per the requirement,Expected-\"Description\" ,Actual-\""+cjs.Description_Text().trim()+"\"");
			}

			//Verify Experience text in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Experience\" text in Job Summary page");
			if(cjs.Experience_Text().trim().equals("Experience")) {
				logger.log(LogStatus.PASS, "Verify text of Experience in Job summary page","\"Experience\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of Experience in Job summary page","Text is not as per the requirement,Expected-\"Experience\" ,Actual-\""+cjs.Experience_Text().trim()+"\"");
			}
			
			//Verifying Minimum Years field in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Minimum Years\" field in Job Summary page");
			if(cjs.MinimumYears()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"Minimum Years\" field is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"Minimum Years\" field is not available");
			}
			
			if(cjs.MinimumYears_Text().trim().equals("Min. Years")) {
				logger.log(LogStatus.PASS, "Verify text of Minimum Years field in Job summary page","\"Minimum Years\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of Minimum Years field in Job summary page","Text is not as per the requirement,Expected-\"Min. Years\" ,Actual-\""+cjs.MinimumYears_Text().trim()+"\"");
			}

			//Verifying Maximum Years field in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Maximum Years\" field in Job Summary page");
			if(cjs.MaximumYears()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"Maximum Years\" field is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"Maximum Years\" field is not available");
			}
			
			if(cjs.MaximumYears_Text().trim().equals("Max. Years")) {
				logger.log(LogStatus.PASS, "Verify text of Maximum Years field in Job summary page","\"Maximum Years\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of Maximum Years field in Job summary page","Text is not as per the requirement,Expected-\"Max. Years\" ,Actual-\""+cjs.MaximumYears_Text().trim()+"\"");
			}

			//Verify Salary text in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Salary\" text in Job Summary page");
			if(cjs.Salary_Text().trim().equals("Salary")) {
				logger.log(LogStatus.PASS, "Verify text of Salary in Job summary page","\"Salary\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of Salary in Job summary page","Text is not as per the requirement,Expected-\"Salary\" ,Actual-\""+cjs.Salary_Text().trim()+"\"");
			}

			//Verifying Minimum Salary field in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Minimum Salary\" field in Job Summary page");
			if(cjs.MinimumSalary()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"Minimum Salary\" field is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"Minimum Salary\" field is not available");
			}
			
			if(cjs.MinimumSalary_Text().trim().equals("Min. Salary")) {
				logger.log(LogStatus.PASS, "Verify text of Minimum Salary field in Job summary page","\"Minimum Salary\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of Minimum Salary field in Job summary page","Text is not as per the requirement,Expected-\"Min. Salary (In Lakhs)\" ,Actual-\""+cjs.MinimumSalary_Text().trim()+"\"");
			}

			//Verifying Maximum Salary field in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Maximum Salary\" field in Job Summary page");
			if(cjs.MaximumSalary()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"Maximum Salary\" field is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"Maximum Salary\" field is not available");
			}
			
			if(cjs.MaximumSalary_Text().trim().equals("Max. Salary")) {
				logger.log(LogStatus.PASS, "Verify text of Maximum Salary field in Job summary page","\"Maximum Salary\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of Maximum Salary field in Job summary page","Text is not as per the requirement,Expected-\"Max. Salary (In Lakhs)\" ,Actual-\""+cjs.MaximumSalary_Text().trim()+"\"");
			}

			//Verifying Location field in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Location\" field in Job Summary page");
			if(cjs.Location()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"Location\" field is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"Location\" field is not available");
			}
							
			//Verifying Education field in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Education\" field in Job Summary page");
			if(cjs.Education()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"Education\" field is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"Education\" field is not available");
			}

			if(cjs.Education_Text().trim().contains("Education")) {
				logger.log(LogStatus.PASS, "Verify text of Education field in Job summary page","\"Education\" text is as per the requirement");
			} else {
				logger.log(LogStatus.FAIL, "Verify text of Education field in Job summary page","Text is not as per the requirement,Expected-\"Education\" ,Actual-\""+cjs.Education_Text().trim()+"\"");
			}

			//Verifying Next Button in Job Summary page
			logger.log(LogStatus.INFO, "Verifying \"Next\" button in Job Summary page");
			if(cjs.Next_Button()==true) {
				logger.log(LogStatus.PASS, "Verify elements present in Job summary page","\"Next\" button is available");
			} else {
				logger.log(LogStatus.FAIL, "Verify elements present in Job summary page","\"Next\" button is not available");
			}
			
			if(ws.clickOnBackButton()) {
				logger.log(LogStatus.PASS,"Successfully clicked on back button");
			} else {		
				logger.log(LogStatus.FAIL, "Failed to navigate to proxy page");
			}
			Thread.sleep(5000);
			String pro = ws.getProxyCorpTab();
			
			if(pro.contains("Proxy")) {
				logger.log(LogStatus.PASS,"Successfully navigated to proxy page,clicked on back button.");
			}else {
				logger.log(LogStatus.FAIL,"Failed to navigate to proxy page");
			}
		}
			logger.log(LogStatus.INFO,"All elements & text present in Job Summary page verified");
			extent.endTest(logger);

	}
}