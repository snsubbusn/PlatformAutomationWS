package com.controller;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.scenarios.Sc_005_Verify_LoginPage;
import com.scenarios.Sc_006_Verify_EmailID_Password_LoginPage;
import com.scenarios.Sc_008_Verify_Register;
import com.scenarios.Sc_009_Verify_ForgotPasswordPage;
import com.scenarios.Sc_010_Verify_ErrorMessage_ForgotPasswordPopUP;
import com.scenarios.Sc_011_Verify_PasswordReset;
import com.scenarios.Sc_022_Verify_JobSummaryPage;
import com.scenarios.Sc_023_Verify_ErrorMessage_JobSummaryPage;
import com.scenarios.Sc_028_Post_Video_JD;
import com.scenarios.Sc_032_PerformGuaranteedSubmission;
import com.scenarios.Sc_036_Verify_Shortlist_PendingReview_CorporateAdmin;
import com.scenarios.Sc_068_Verify_AlignOfAnAgency;
import com.scenarios.Sc_080_Verify_Accept_ReviewSubmission;
import com.scenarios.Sc_087_VerifyAccept_GS;
import com.scenarios.Sc_101_VerifyTag_Agencypartner;



//update all the existing test scripts for post a job.

@Listeners(com.controller.Action_Method.class)
public class ScriptExecution extends Action_Method
{
		
		@BeforeMethod
		public void Launch_Browser()
		{
			getbrowser();
		}
		@AfterMethod
		public void Close_Browser() throws InterruptedException
		{
			Thread.sleep(2000);
			close_browser();
		}

		
		//Verify all the elements present in Login page
		@Test
		public void Scenario_005() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Sc_005_Verify_LoginPage s5=PageFactory.initElements(driver, Sc_005_Verify_LoginPage.class);
			s5.Verify_all_elements_present_in_loginPage();
		}
		//Verify error message for mail id and password of Login page
		@Test
		public void Scenario_006() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Sc_006_Verify_EmailID_Password_LoginPage s6=PageFactory.initElements(driver, Sc_006_Verify_EmailID_Password_LoginPage.class);
			s6.Verify_MailId_Password();
		}
		
		//Verify Register
		@Test
		public void Scenario_008() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			Sc_008_Verify_Register s08=PageFactory.initElements(driver,Sc_008_Verify_Register.class);
			s08.Verify_Registration_Of_user();
		}
				
		//Verify All elements and text present in Forgot Password Pop up
		@Test
		public void Scenario_009() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Sc_009_Verify_ForgotPasswordPage s9=PageFactory.initElements(driver, Sc_009_Verify_ForgotPasswordPage.class);
			s9.Verify_ForgotPasswordPage();
		}
		
		//Verify Error message for Forgot Password Pop up
		@Test
		public void Scenario_010() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Sc_010_Verify_ErrorMessage_ForgotPasswordPopUP s10=PageFactory.initElements(driver,Sc_010_Verify_ErrorMessage_ForgotPasswordPopUP.class);
			s10.Verify_ErrorMessage_ForgotPasswordPopUP();
		}
		
		//Verify Password reset
		@Test
		public void Scenario_011() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Sc_011_Verify_PasswordReset s11=PageFactory.initElements(driver,Sc_011_Verify_PasswordReset.class);
			s11.Verify_PasswordReset();
		}
		
		
		//Verify All elements present in Job summary page
		@Test
		public void Scenario_022() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Sc_022_Verify_JobSummaryPage s22=PageFactory.initElements(driver,Sc_022_Verify_JobSummaryPage.class);
			s22.Verify_AllElements_JobSummaryPage();
		}
		
		//Verify Error message for Job Summary page
		@Test
		public void Scenario_023() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Sc_023_Verify_ErrorMessage_JobSummaryPage s23=PageFactory.initElements(driver,Sc_023_Verify_ErrorMessage_JobSummaryPage.class);
			//Verify Error message for No Inputs in Job Summary page
			s23.Verify_ErrorMessage_NoInputs();
			//Verify Error message for minimum experience greater than maximum Experience in Job summary page
			s23.Verify_ErrorMessage_Experience();
			//Verify Error message for minimum salary greater than maximum Salary in Job summary page
			s23.Verify_ErrorMessage_Salary();
			
		}
		
		
		//Verify Post Video JD by corporate User
		@Test
		public void Scenario_028() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Sc_028_Post_Video_JD s28=PageFactory.initElements(driver, Sc_028_Post_Video_JD.class);
			s28.Verify_Post_Video_Jd();
		}
		//Verify Guaranteed Submission
		@Test(dependsOnMethods="Scenario_028")
		public void Scenario_032() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Sc_032_PerformGuaranteedSubmission s32=PageFactory.initElements(driver, Sc_032_PerformGuaranteedSubmission.class);
			s32.Verify_Guaranteed_Submission();
		}
		
		//Shortlist candidate in pending review page by Corporate Admin
		@Test(dependsOnMethods="Scenario_080")
		public void Scenario_036() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			Sc_036_Verify_Shortlist_PendingReview_CorporateAdmin s36=PageFactory.initElements(driver,Sc_036_Verify_Shortlist_PendingReview_CorporateAdmin.class);
			s36.Shortlist_PendingReview();
		}
		
		//Verify align of an agency by workstreets Aadmin
		@Test(dependsOnMethods="Scenario_032")
		public void Scenario_068() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			Sc_068_Verify_AlignOfAnAgency s68=PageFactory.initElements(driver, Sc_068_Verify_AlignOfAnAgency.class);
			s68.Verify_AlignOfAnAgency();
		}
		
		//verify Approve of an candidate in review Submission by workstreets Admin
		@Test(dependsOnMethods="Scenario_101")
		public void Scenario_080() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			Sc_080_Verify_Accept_ReviewSubmission s80=PageFactory.initElements(driver, Sc_080_Verify_Accept_ReviewSubmission.class);
			s80.Accept_ReviewSubmission();
		}
		
		//Accept Guaranteed Submission by Agency Partner
		@Test(dependsOnMethods="Scenario_068")
		public void Scenarion_087() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			Sc_087_VerifyAccept_GS s87=PageFactory.initElements(driver, Sc_087_VerifyAccept_GS.class);
			s87.Accept_GS();
		}
		
		// Tag Candidate by Agency Partner
		@Test(dependsOnMethods="Scenarion_087")
		public void Scenario_101() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			Sc_101_VerifyTag_Agencypartner s101=PageFactory.initElements(driver, Sc_101_VerifyTag_Agencypartner.class);
			s101.Tag_Candidate_AgencyPartner();
		}
	
		
//		//Verify Corporate Landing page
//		@Test
//		public void Scenario_009() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
//		{
//			Verify_CorporateLandingPage s9=PageFactory.initElements(driver,Verify_CorporateLandingPage.class);
//			s9.Verify_CorporateLandingPage();
//		}

		

}
