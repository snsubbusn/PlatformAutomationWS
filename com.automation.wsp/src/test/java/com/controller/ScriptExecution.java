package com.controller;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scenarios.CorpAdm_Dashboard_TC001_VerifyDashboard;
import com.scenarios.CorpAdm_Dashboard_TC002_VerifyDashafterGS;
import com.scenarios.CorpAdm_Dashboard_TC003_VerifyDashafterGO;
import com.scenarios.CorpAdm_User_TC001_VerifyUsersTab;
import com.scenarios.CorpAdm_User_TC002_AddUser;
import com.scenarios.CorpAdm_User_TC003_AddUserforAllLicenses;
import com.scenarios.CorpAdm_User_TC004_EditUserName;
import com.scenarios.CorpAdm_User_TC005_EditEmailId;
import com.scenarios.CorpAdm_User_TC006_EditPhone;
import com.scenarios.CorpAdm_User_TC007_EditPasswordChange;
import com.scenarios.CorpAdm_User_TC008_DeleteUser;
import com.scenarios.CorpAdm_User_TC009_DeleteAllUser;
import com.scenarios.CorpAdm_User_TC010_AddDeletedUser;
import com.scenarios.CorpAdm_User_TC011_VerifyPagination;
import com.scenarios.CorpAdm_User_TC012_ValidateAddUserPageErrors;
import com.scenarios.GOCampaignCreation;
import com.scenarios.GO_AdminReviewSubmission;
import com.scenarios.GO_Admin_AlignAgencies;
import com.scenarios.GO_AgentAcceptandTagCandidates;
import com.scenarios.GO_CorporateShortlists;
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
import com.scenarios.TC_001_Verify_LoginPage;
import com.scenarios.TC_002_Verify_Corporate_Company_Info_Error_Notification;
import com.scenarios.TC_003_Verify_Corporate_Company_Edit_OfficeLocations_Solutions_offered;
import com.scenarios.TC_004_Corporate_Delete_OfficeLocation;
import com.scenarios.TC_005_Verify_Error_Notification_office_Location;
import com.scenarios.TC_006_Verify_Edit_Solutions_Offered_Section;
import com.scenarios.TC_016_Create_Save_Corporate_Profile;
import com.scenarios.WSAdmin_TC001_VerifyAdminLogin;
import com.scenarios.WSAdmin_TC002_VerifyInvitePage;
import com.scenarios.WSAdmin_TC003_VerifyFilterUsingCandidate;
import com.scenarios.WSAdmin_TC004_VerifyFilterUsingCorporateAdmin;
import com.scenarios.WSAdmin_TC005_VerifyFilterUsingAgent;
import com.scenarios.WSAdmin_TC006_VerifySortByName;
import com.scenarios.WSAdmin_TC007_VerifySortByStatus;
import com.scenarios.WSAdmin_TC008_VerifySortByInvitedOn;
import com.scenarios.WSAdmin_TC009_VerifyAddNewUserPage;
import com.scenarios.WSAdmin_TC010_VerifyEditingCorpAdminUnderInvite;
import com.scenarios.WSAdmin_TC011_VerifyJobsTabandCountsofJobs;
import com.scenarios.WSAdmin_TC012_VerifyUsersTab;
import com.scenarios.WSAdmin_TC014_VerifyAddUserPageValidation;
import com.scenarios.WSAdmin_TC015_AddNewAdminUser;
import com.scenarios.WSAdmin_TC016_AddingExistingUser;
import com.scenarios.WSAdmin_TC017_EditExistingAdminUserName;
import com.scenarios.WSAdmin_TC018_EditExistingAdminUserEmail;
import com.scenarios.WSAdmin_TC019_EditExistingAdminUserPhone;
import com.scenarios.WSAdmin_TC020_DeleteFirstAdminUser;
import com.scenarios.WSAdmin_TC013_VerifyUsersAddUser;


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


	
	//Verify corporate profile page
	@Test
	public void CorpProfile1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		TC_016_Create_Save_Corporate_Profile tc_016 = PageFactory.initElements(driver, TC_016_Create_Save_Corporate_Profile.class);
		tc_016.VerifyEditandSaveCorporateCompanyProfilePage();

	}


	@Test
	public void CorpProfile2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException 
	{
		TC_002_Verify_Corporate_Company_Info_Error_Notification tc_002 = PageFactory.initElements(driver, TC_002_Verify_Corporate_Company_Info_Error_Notification.class);
		tc_002.Verify_Corporate_Company_Info_Page_Dataisdisplayed();

	}

		/*	@Test(priority=1)
		public void TC_003() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			TC_003_Verify_Corporate_Company_Edit_OfficeLocations_Solutions_offered tc_003 = PageFactory.initElements(driver, TC_003_Verify_Corporate_Company_Edit_OfficeLocations_Solutions_offered.class);
			tc_003.Verify_Company_OfficeLocations();
		}

		@Test(priority=2)
		public void TC_004() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			TC_004_Corporate_Delete_OfficeLocation tc_004 = PageFactory.initElements(driver, TC_004_Corporate_Delete_OfficeLocation.class);
			tc_004.Verify_OfficeLocation_Deletion();
		}

		@Test(priority=3)
		public void TC_005() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			TC_005_Verify_Error_Notification_office_Location tc_005 = PageFactory.initElements(driver, TC_005_Verify_Error_Notification_office_Location.class);
			tc_005.Verify_Error_Message_for_Office_Locations();
		}

		@Test(priority=4)
		public void TC_006() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			TC_006_Verify_Edit_Solutions_Offered_Section tc_006 = PageFactory.initElements(driver, TC_006_Verify_Edit_Solutions_Offered_Section.class);
			tc_006.Verify_Edit_Solutions_Offered();

		}
		 */
	 



	//Corporate User Management Test Cases

	@Test 
	public void CorpUserMangement01() throws InterruptedException {
		CorpAdm_User_TC001_VerifyUsersTab corp = PageFactory.initElements(driver, CorpAdm_User_TC001_VerifyUsersTab.class);
		corp.checkUserTabandLicenseofCorpAdmin();
	}

	@Test 
	public void CorpUserMangement02() throws InterruptedException {
		CorpAdm_User_TC002_AddUser corp = PageFactory.initElements(driver, CorpAdm_User_TC002_AddUser.class);
		corp.addCorporateUser();
	}


	@Test 
	public void CorpUserMangement03() throws InterruptedException {
		CorpAdm_User_TC004_EditUserName corp = PageFactory.initElements(driver, CorpAdm_User_TC004_EditUserName.class);
		corp.editCorpUsersforNameField();
	}

	@Test 
	public void CorpUserMangement04() throws InterruptedException {
		CorpAdm_User_TC005_EditEmailId corp = PageFactory.initElements(driver, CorpAdm_User_TC005_EditEmailId.class);
		corp.editCorpUsersforEmailField();
	}

	@Test 
	public void CorpUserMangement05() throws InterruptedException {
		CorpAdm_User_TC006_EditPhone corp = PageFactory.initElements(driver, CorpAdm_User_TC006_EditPhone.class);
		corp.editCorpUsersforPhoneNumber();
	}

	//This test case has been removed as part of Sprint 24 Since the password
	//field has been removed and the password is auto generated. 
	//https://otpinternet.atlassian.net/browse/W1O2-1734
	/*@Test 
	public void CorpUserMangement06() throws InterruptedException {
		CorpAdm_User_TC007_EditPasswordChange corp = PageFactory.initElements(driver, CorpAdm_User_TC007_EditPasswordChange.class);
		corp.editCorpUsersforPasswordChange();
	}	
*/

	@Test 
	public void CorpUserMangement07() throws InterruptedException {
		CorpAdm_User_TC010_AddDeletedUser corp = PageFactory.initElements(driver, CorpAdm_User_TC010_AddDeletedUser.class);
		corp.addDeletedUser();
	}

	@Test 
	public void CorpUserMangement08() throws InterruptedException {
		CorpAdm_User_TC012_ValidateAddUserPageErrors corp = PageFactory.initElements(driver, CorpAdm_User_TC012_ValidateAddUserPageErrors.class);
		corp.validateAddUserPageErrors();
	}

	@Test 
	public void CorpUserMangement09() throws InterruptedException {
		CorpAdm_User_TC008_DeleteUser corp = PageFactory.initElements(driver, CorpAdm_User_TC008_DeleteUser.class);
		corp.deleteCorporateUser();
	}

	@Test
	public void CorpUserMangement10() throws InterruptedException {
		CorpAdm_User_TC003_AddUserforAllLicenses corp = PageFactory.initElements(driver, CorpAdm_User_TC003_AddUserforAllLicenses.class);
		corp.addCorpUsersforAllLicenses();
	}

	@Test
	public void CorpUserMangement11() throws InterruptedException {
		CorpAdm_User_TC011_VerifyPagination corp = PageFactory.initElements(driver, CorpAdm_User_TC011_VerifyPagination.class);
		corp.verifyPagination();
	}

	@Test
	public void CorpUserMangement12() throws InterruptedException {
		CorpAdm_User_TC009_DeleteAllUser corp = PageFactory.initElements(driver, CorpAdm_User_TC009_DeleteAllUser.class);
		corp.deleteAllCorporateUser();
	}
	 


	@Test
	public void CorporateDashboard01() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		CorpAdm_Dashboard_TC001_VerifyDashboard ds = PageFactory.initElements(driver, CorpAdm_Dashboard_TC001_VerifyDashboard.class);
		ds.verifyCorpAdminDashboard();
	}
	
	

	//Verify All elements present in Job summary page
	@Test
	public void CorporateJob1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_022_Verify_JobSummaryPage s22=PageFactory.initElements(driver,Sc_022_Verify_JobSummaryPage.class);
		s22.Verify_AllElements_JobSummaryPage();
	}

	//Verify Error message for Job Summary page
	@Test 
	public void CorporateJob2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_023_Verify_ErrorMessage_JobSummaryPage s23=PageFactory.initElements(driver,Sc_023_Verify_ErrorMessage_JobSummaryPage.class);
		//Verify Error message for No Inputs in Job Summary page
		s23.Verify_ErrorMessage_NoInputs();
		//Verify Error message for minimum experience greater than maximum Experience in Job summary page
		s23.Verify_ErrorMessage_Experience();
		//Verify Error message for minimum salary greater than maximum Salary in Job summary page
		s23.Verify_ErrorMessage_Salary();

	}
	
	
	//Verify all the elements present in Login page
	@Test 
	public void Login1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		TC_001_Verify_LoginPage s5=PageFactory.initElements(driver, TC_001_Verify_LoginPage.class);
		s5.Verify_all_elements_present_in_loginPage();
	}
	//Verify error message for mail id and password of Login page
	@Test 
	public void Login2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_006_Verify_EmailID_Password_LoginPage s6=PageFactory.initElements(driver, Sc_006_Verify_EmailID_Password_LoginPage.class);
		s6.Verify_MailId_Password();
	}

	//Verify Register
	@Test 
	public void Login3() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Sc_008_Verify_Register s08=PageFactory.initElements(driver,Sc_008_Verify_Register.class);
		s08.Verify_Registration_Of_user();
	}

	//Verify All elements and text present in Forgot Password Pop up
	@Test 
	public void Login4() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_009_Verify_ForgotPasswordPage s9=PageFactory.initElements(driver, Sc_009_Verify_ForgotPasswordPage.class);
		s9.Verify_ForgotPasswordPage();
	}


	//Verify Error message for Forgot Password Pop up
	@Test 
	public void Login5() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_010_Verify_ErrorMessage_ForgotPasswordPopUP s10=PageFactory.initElements(driver,Sc_010_Verify_ErrorMessage_ForgotPasswordPopUP.class);
		s10.Verify_ErrorMessage_ForgotPasswordPopUP();
	}

	//Verify Password reset
	@Test
	public void Login6() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_011_Verify_PasswordReset s11=PageFactory.initElements(driver,Sc_011_Verify_PasswordReset.class);
		s11.Verify_PasswordReset();
	}




	//Guaranteed Submission Test Cases
	//Verify Post Video JD by corporate User
	@Test
	public void Submission01() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_028_Post_Video_JD s28=PageFactory.initElements(driver, Sc_028_Post_Video_JD.class);
		s28.Verify_Post_Video_Jd();
	}


	//Verify Guaranteed Submission
	@Test//(dependsOnMethods= "gS1")
	public void Submission02() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_032_PerformGuaranteedSubmission s32=PageFactory.initElements(driver, Sc_032_PerformGuaranteedSubmission.class);
		s32.Verify_Guaranteed_Submission();
	}

	//Verify align of an agency by workstreets Admin
	@Test//(dependsOnMethods="gS2")
	public void Submission03() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_068_Verify_AlignOfAnAgency s68=PageFactory.initElements(driver, Sc_068_Verify_AlignOfAnAgency.class);
		s68.Verify_AlignOfAnAgency();
	}


	//Accept Guaranteed submission by Agency Partner
	@Test//(dependsOnMethods="gS3")
	public void Submission04() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Sc_087_VerifyAccept_GS s87=PageFactory.initElements(driver, Sc_087_VerifyAccept_GS.class);
		s87.Accept_GS();
	}


	// Tag Candidate by Agency Partner
	@Test//(dependsOnMethods="gS4")
	public void Submission05() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Sc_101_VerifyTag_Agencypartner s101=PageFactory.initElements(driver, Sc_101_VerifyTag_Agencypartner.class);
		s101.Tag_Candidate_AgencyPartner();
	}



	//verify Approve of an candidate in review submission by workstreets Admin
	@Test//(dependsOnMethods="gS5")
	public void Submission06() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_080_Verify_Accept_ReviewSubmission s80=PageFactory.initElements(driver, Sc_080_Verify_Accept_ReviewSubmission.class);
		s80.Accept_ReviewSubmission();
	}



	//Shortlist candidate in pending review page by Corporate Admin
	@Test//(dependsOnMethods="gS6")
	public void Submission07() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Sc_036_Verify_Shortlist_PendingReview_CorporateAdmin s36=PageFactory.initElements(driver,Sc_036_Verify_Shortlist_PendingReview_CorporateAdmin.class);
		s36.Shortlist_PendingReview();
	}
	


	//Guaranteed On boarding Scenarios
	@Test
	public void onboarding1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		GOCampaignCreation GO = PageFactory.initElements(driver, GOCampaignCreation.class);
		GO.guaranteedOnboardingCampaignCreation();
	}

	@Test//(dependsOnMethods="onboarding1")
	public void onboarding2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		GO_Admin_AlignAgencies align=PageFactory.initElements(driver, GO_Admin_AlignAgencies.class);
		align.AlignAgentforGO();
	}

	@Test//(dependsOnMethods="onboarding2")
	public void onboarding3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		GO_AgentAcceptandTagCandidates agent = PageFactory.initElements(driver, GO_AgentAcceptandTagCandidates.class);
		agent.agentAcceptandTagCandidates();
	}

	@Test//(dependsOnMethods="onboarding3")
	public void onboarding4() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		GO_AdminReviewSubmission adminreview = PageFactory.initElements(driver, GO_AdminReviewSubmission.class);
		adminreview.goAdminReviewSubmission();
	}

	@Test// (dependsOnMethods="onboarding4")
	public void onboarding5() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		GO_CorporateShortlists corshor = PageFactory.initElements(driver, GO_CorporateShortlists.class);
		corshor.corporateShortlist();
	}


	@Test(dependsOnMethods ="onboarding5")
	public void CorporateDashboard02() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		CorpAdm_Dashboard_TC002_VerifyDashafterGS ds = PageFactory.initElements(driver, CorpAdm_Dashboard_TC002_VerifyDashafterGS.class);
		ds.verifyCorpAdminDashboardAfterGS();
	}

	@Test(dependsOnMethods = "onboarding5")
	public void CorporateDashboard03() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		CorpAdm_Dashboard_TC003_VerifyDashafterGO ds = PageFactory.initElements(driver, CorpAdm_Dashboard_TC003_VerifyDashafterGO.class);
		ds.verifyCorpAdminDashboardAfterGO();
	}
	


	@Test
	public void WSAdmin01() throws InterruptedException {
		WSAdmin_TC001_VerifyAdminLogin ws = PageFactory.initElements(driver, WSAdmin_TC001_VerifyAdminLogin.class);
		ws.VerifyAdminLogin();
	}

	@Test
	public void WSAdmin02() throws InterruptedException {
		WSAdmin_TC002_VerifyInvitePage ws = PageFactory.initElements(driver, WSAdmin_TC002_VerifyInvitePage.class);
		ws.verifyWSAdminInvitePage();
	}
	
	@Test
	public void WSAdmin03() throws InterruptedException {
		WSAdmin_TC003_VerifyFilterUsingCandidate ws = PageFactory.initElements(driver, WSAdmin_TC003_VerifyFilterUsingCandidate.class);
		ws.verifyInvitePageFilterByCandidate();
	}
	
	@Test
	public void WSAdmin04() throws InterruptedException {
		WSAdmin_TC004_VerifyFilterUsingCorporateAdmin ws = PageFactory.initElements(driver,WSAdmin_TC004_VerifyFilterUsingCorporateAdmin.class);
		ws.verifytheFilterBySelectingCorporateAdmin();
	}
	
	@Test
	public void WSAdmin05() throws InterruptedException {
		WSAdmin_TC005_VerifyFilterUsingAgent ws = PageFactory.initElements(driver,WSAdmin_TC005_VerifyFilterUsingAgent.class);
		ws.verifytheFilterBySelectingAgent();
	}
	
	@Test
	public void WSAdmin06() throws InterruptedException {
		WSAdmin_TC006_VerifySortByName ws = PageFactory.initElements(driver, WSAdmin_TC006_VerifySortByName.class);
		ws.verifyWSAdminSortByName();
	}
	
	@Test
	public void WSAdmin07() throws InterruptedException {
		WSAdmin_TC007_VerifySortByStatus ws = PageFactory.initElements(driver, WSAdmin_TC007_VerifySortByStatus.class);
		ws.verifyWSAdminSortByStatus();
	}
	
	@Test
	public void WSAdmin08() throws InterruptedException {
		WSAdmin_TC008_VerifySortByInvitedOn ws = PageFactory.initElements(driver, WSAdmin_TC008_VerifySortByInvitedOn.class);
		ws.verifyWSAdminSortByInvitedOn();
	}

	@Test
	public void WSAdmin09() throws InterruptedException {
		WSAdmin_TC009_VerifyAddNewUserPage ws = PageFactory.initElements(driver, WSAdmin_TC009_VerifyAddNewUserPage.class);
		ws.verifyAddNewUserPage();
	}
	
	@Test
	public void WSAdmin10() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WSAdmin_TC010_VerifyEditingCorpAdminUnderInvite ws = PageFactory.initElements(driver, WSAdmin_TC010_VerifyEditingCorpAdminUnderInvite.class);
		ws.verifyEditInvitedCorporateAdminUser();
	}
	
	@Test
	public void WSAdmin11() throws InterruptedException {
		WSAdmin_TC011_VerifyJobsTabandCountsofJobs ws = PageFactory.initElements(driver, WSAdmin_TC011_VerifyJobsTabandCountsofJobs.class);
		ws.verifytheJobsTabandGetTheCountOfJobsInEachSection();
	}
	
	@Test
	public void WSAdmin12() throws InterruptedException {
		WSAdmin_TC012_VerifyUsersTab ws = PageFactory.initElements(driver, WSAdmin_TC012_VerifyUsersTab.class);
		ws.verifyUsersTabOfWSAdmin();
	}
	
	@Test
	public void WSAdmin13() throws InterruptedException {
		WSAdmin_TC013_VerifyUsersAddUser ws = PageFactory.initElements(driver, WSAdmin_TC013_VerifyUsersAddUser.class);
		ws.verifyUsersTabAddNewUser();
	}
	
	@Test
	public void WSAdmin14() throws InterruptedException {
		WSAdmin_TC014_VerifyAddUserPageValidation ws = PageFactory.initElements(driver, WSAdmin_TC014_VerifyAddUserPageValidation.class);
		ws.verifyUsersTabAddNewUser();
	}
	
	@Test
	public void WSAdmin15() throws InterruptedException {
		WSAdmin_TC015_AddNewAdminUser ws = PageFactory.initElements(driver, WSAdmin_TC015_AddNewAdminUser.class);
		ws.verifyAddingNewUser();
	}
	
	
	@Test
	public void WSAdmin16() throws InterruptedException {
		WSAdmin_TC016_AddingExistingUser ws = PageFactory.initElements(driver, WSAdmin_TC016_AddingExistingUser.class);
		ws.verifyAddingExistingAdminUser();
	}
	
	@Test
	public void WSAdmin17() throws InterruptedException {
		WSAdmin_TC017_EditExistingAdminUserName ws = PageFactory.initElements(driver, WSAdmin_TC017_EditExistingAdminUserName.class);
		ws.verifyEditingExistingAdminUserName();
	}
	
	@Test
	public void WSAdmin18() throws InterruptedException {
		WSAdmin_TC018_EditExistingAdminUserEmail ws = PageFactory.initElements(driver, WSAdmin_TC018_EditExistingAdminUserEmail.class);
		ws.verifyEditingExistingAdminUserEmail();
	}
	
	@Test
	public void WSAdmin19() throws InterruptedException {
		WSAdmin_TC019_EditExistingAdminUserPhone ws = PageFactory.initElements(driver, WSAdmin_TC019_EditExistingAdminUserPhone.class);
		ws.verifyEditingExistingAdminUserPhone();
	}
	
	@Test
	public void WSAdmin20() throws InterruptedException {
		WSAdmin_TC020_DeleteFirstAdminUser ws = PageFactory.initElements(driver, WSAdmin_TC020_DeleteFirstAdminUser.class);
		ws.verifyDeletingFirstAdminUser();
	}
	
}
