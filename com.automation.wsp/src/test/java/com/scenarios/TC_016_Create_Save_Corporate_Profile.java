package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Corporate_Add_Management_profile;
import com.objects_pages.Corporate_ProfilePage;
import com.objects_pages.Corporate_Profile_OfficeLocations_Page;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC_016_Create_Save_Corporate_Profile extends Action_Method {

	public void VerifyEditandSaveCorporateCompanyProfilePage() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {

		logger = extent.startTest("Edit Corporate Profile Details_TC001", "Corporate Admin Logs in, edits the corporate profile and update the profile");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Corporate General");
		logger.setDescription("Login as Corporate Admin edit profile and save the changes");

		wait_for_pageload(Variables.url);

		//Creating instance of login page
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");

		Corporate_ProfilePage landP = PageFactory.initElements(driver, Corporate_ProfilePage.class);

		String nam = landP.clickonProfileandVerifyProfilePage(); 
		if(!nam.isEmpty()) {
			logger.log(LogStatus.PASS, "Verify the landing page of corporate, Corporate User successfully logged in and the company name is verified - "+nam);
		}else {
			logger.log(LogStatus.FAIL, "Verify the landing page of corporate, Corporate User login failed and the company name is empty - "+nam);
		}

		logger.log(LogStatus.INFO, "Click on Edit Profile button and update the profile details");
		//Click on Profile edit button
		landP.clickOnProfileEditBtn();

		String prf = landP.verifyProfileEditPage();

		if(prf.contains("Corporate Profile")) {
			logger.log(LogStatus.PASS, "Verify Profile Edit page, Clicked on Edit Profile icon and verified the screen navigated to corporate profile edit page - "+prf);
		}else {
			logger.log(LogStatus.FAIL, "Verify Profile Edit page, Clicked on Edit Profile icon and the screen failed to navigate to edit profile page");
		}

		logger.log(LogStatus.INFO, "Edit and update the company info details and verify the success message");
		//Verifying company info page accepts the valid input
		String editCompanyInfo = landP.enterCompanyInfoDetailsandClickNextButton();
		if(editCompanyInfo.equalsIgnoreCase("Success")){
			logger.log(LogStatus.PASS, "Entered the details of Company Info and updated. The message received is - "+editCompanyInfo);
		}else {
			logger.log(LogStatus.FAIL, "Updating the company info page failed. The message received is - "+editCompanyInfo);
		}

		//After reentering the company info, navigated to office locations and solutions offered page.
		landP.clickOnEditCompanyDetailsSection();

		if(landP.verifyLocationsPresent()) {
			logger.log(LogStatus.INFO, "Verified the location is already present. So deleting the locations and adding new location");
			String loc = landP.deleteOfficeLocationandAddNew();
			logger.log(LogStatus.PASS, "Deleted the present location and added new location. The location added is - "+loc);
		}else {
			logger.log(LogStatus.INFO, "Verified No Locations are present. So adding new location");
			String loc = landP.addNewOfficeLocation();
			logger.log(LogStatus.PASS, "Added new location. The location added is - "+loc);
		}

		landP.clickOnNextButton();
		Corporate_Profile_OfficeLocations_Page prof2 = PageFactory.initElements(driver, Corporate_Profile_OfficeLocations_Page.class);
		
		prof2.clickNextButton();
		logger.log(LogStatus.PASS, "Verified the Media Page and navigating to Add Management Page");

		// Verify Solutions type is present. If present delete and add new solution. else directly add new solution
		if(prof2.verifySolutionsPresent()) {
			logger.log(LogStatus.INFO, "Verified the Solution is already present. So deleting the Solution type and adding new solution type");
			String loc = prof2.deleteSolutionandAddNew();
			logger.log(LogStatus.PASS, "Deleted the present Solution type and added new Solution type. The Solution type added is - "+loc);
		}else {
			logger.log(LogStatus.INFO, "Verified No Solution type are present. So adding new Solution type");
			String loc = prof2.addNewSolution();
			logger.log(LogStatus.PASS, "Added new Solution type. The Solution type added is - "+loc);
		}

		logger.log(LogStatus.INFO, "Verified the Office Locations and Solutions Type. Navigating to Media Page");


		Corporate_Add_Management_profile profile4 = PageFactory.initElements(driver, Corporate_Add_Management_profile.class);
		int no = profile4.getNoOfManagementProfiles();
		if(no==0) {
			logger.log(LogStatus.PASS, "There are no Management Profiles added to the profile");
		}else {
			logger.log(LogStatus.PASS, "There are totally "+no+" Management Profiles already added to the profile");
		}

		logger.log(LogStatus.INFO, "Adding the Management details to the Corp Profile");

		String man = profile4.Corp_AddManagement_Profile();

		logger.log(LogStatus.PASS, "Added Management Profile and the details added is :"+man);

		int no1 = profile4.getNoOfManagementProfiles();

		if(no<2&&no==no1) {
			logger.log(LogStatus.FAIL, "No Management Profiles have been added newly.");
		}else {
			logger.log(LogStatus.PASS, "Added 1 Management Profile Successfully");
		}

		profile4.clickOnDone();
		
		profile4.clickOnViewProfile();

		String nam1 = landP.getCompanyName();
		
		if(!nam1.isEmpty()) {
			logger.log(LogStatus.PASS, "Corporate Profile successfully edited and the profile page is displayed. The name of the company displayed in profile page is - "+nam1);
		}else {
			logger.log(LogStatus.FAIL, "Failed to navigate to the profile page.");
		}

		logger.log(LogStatus.INFO, "Completed editing the profile and navigated to the Main Profile page");

		extent.endTest(logger);

		lp.logout();

	}

}

