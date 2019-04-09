package com.controller;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scenarios.Agent_TC001_VerifyAgentLogin;
import com.scenarios.Agent_TC002_VerifyNewAssignmentsPage;
import com.scenarios.Agent_TC003_VerifyActiveAssignmentsPage;
import com.scenarios.Agent_TC004_VerifyOnHoldAssignmentsPage;
import com.scenarios.Agent_TC005_VerifyClosedAssignmentsPage;
import com.scenarios.Agent_TC006_VerifyInvitedCandidatePage;
import com.scenarios.Agent_TC007_VerifyInvitedCandidateSortByInvitedOn;
import com.scenarios.Agent_TC008_VerifyInvitedCandidateSortByName;
import com.scenarios.Agent_TC009_VerifyInvitedCandidateSortByStatus;
import com.scenarios.Agent_TC010_VerifySendReminderForInvitedCandidate;
import com.scenarios.Agent_TC011_VerifyJoinedCandidateProfile;
import com.scenarios.Agent_TC012_VerifyAgencyPartnerAbletoAcceptNewAssignment;
import com.scenarios.Agent_TC013_VerifyAgencyPartnerAbletoDeclineNewAssignment;
import com.scenarios.Agent_TC014_VerifyAgencyPartnerAbletoViewJobDetailsfromNewAssignment;
import com.scenarios.Agent_TC015_VerifyAgencyPartnerAbletoViewJobDetailsfromActiveAssignment;
import com.scenarios.Agent_TC016_VerifyAgencyPartnerAbletoViewJobDetailsfromOnHoldAssignment;
import com.scenarios.Agent_TC017_VerifyAgencyPartnerAbletoViewJobDetailsfromClosedAssignment;
import com.scenarios.Agent_TC018_VerifyAssignCandidateDetailsForJob;
import com.scenarios.Agent_TC019_VerifyValidationOfInviteNewCandidateForJob;
import com.scenarios.Agent_TC020_VerifyInviteNewCandidateForJob;
import com.scenarios.Agent_TC021_VerifyInvitedTabofaJob;
import com.scenarios.Agent_TC022_VerifyTagExistingTabofaJob;
import com.scenarios.Agent_TC023_VerifySearchResultsForNoFiltersandTagCandidate;
import com.scenarios.Agent_TC024_VerifySearchResultsForNameFilterandTagCandidate;
import com.scenarios.Agent_TC025_VerifySearchResultsForEmailFilterandTagCandidate;
import com.scenarios.Agent_TC026_VerifySearchResultsForSkillsFilterandTagCandidate;
import com.scenarios.Agent_TC027_VerifySearchResultsForExperienceFilterandTagCandidate;
import com.scenarios.Agent_TC028_VeriifyTaggedTabofaJob;
import com.scenarios.Candidate_TC001_VerifyCandidateLoginandProfilePage;
import com.scenarios.Candidate_TC002_VerifyEditingCandidateProfilePage;
import com.scenarios.Candidate_TC005_VerifyValidationOfUploadingCV;
import com.scenarios.CorpAdm_Dashboard_TC001_VerifyDashboard;
import com.scenarios.CorpAdm_Dashboard_TC002_VerifyDashafterGS;
import com.scenarios.CorpAdm_Dashboard_TC003_VerifyDashafterGO;
import com.scenarios.CorpAdm_TC010_VerifyActiveJobMovedtoOnHoldJob;
import com.scenarios.CorpAdm_TC011_VerifyOnHoldJobResumedtoActiveJob;
import com.scenarios.CorpAdm_TC012_VerifyOnHoldJobMovedtoClosedJob;
import com.scenarios.CorpAdm_TC013_VerifyClosedJobisRestartedforGS;
import com.scenarios.CorpAdm_TC014_VerifyClosedJobisRestartedforGO;
import com.scenarios.CorpAdm_TC015_VerifyClosedJobisReplicatedtoNewJob;
import com.scenarios.CorpAdm_User_TC001_VerifyUsersTab;
import com.scenarios.CorpAdm_User_TC002_AddUser;
import com.scenarios.CorpAdm_User_TC003_AddUserforAllLicenses;
import com.scenarios.CorpAdm_User_TC004_EditUserName;
import com.scenarios.CorpAdm_User_TC005_EditEmailId;
import com.scenarios.CorpAdm_User_TC006_EditPhone;
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
import com.scenarios.WSAdmin_TC013_VerifyUsersAddUser;
import com.scenarios.WSAdmin_TC014_VerifyAddUserPageValidation;
import com.scenarios.WSAdmin_TC015_AddNewAdminUser;
import com.scenarios.WSAdmin_TC016_AddingExistingUser;
import com.scenarios.WSAdmin_TC017_EditExistingAdminUserName;
import com.scenarios.WSAdmin_TC018_EditExistingAdminUserEmail;
import com.scenarios.WSAdmin_TC019_EditExistingAdminUserPhone;
import com.scenarios.WSAdmin_TC020_DeleteFirstAdminUser;


@Listeners(com.controller.Action_Method.class)
public class ScriptExecution extends Action_Method
{

	@BeforeMethod(alwaysRun = true)
	public void Launch_Browser()
	{
		getbrowser();
	}
	@AfterMethod(alwaysRun = true)
	public void Close_Browser() throws InterruptedException
	{
		Thread.sleep(2000);
		close_browser();
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		extent.flush();
		extent.close();
	}

	
	
	//Verify corporate profile page
	@Test(groups = {"Corporate General"})
	public void CorpProfile1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		TC_016_Create_Save_Corporate_Profile tc_016 = PageFactory.initElements(driver, TC_016_Create_Save_Corporate_Profile.class);
		tc_016.VerifyEditandSaveCorporateCompanyProfilePage();

	} 


	@Test(groups = {"Corporate General"})
	public void CorpProfile2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException 
	{
		TC_002_Verify_Corporate_Company_Info_Error_Notification tc_002 = PageFactory.initElements(driver, TC_002_Verify_Corporate_Company_Info_Error_Notification.class);
		tc_002.Verify_Corporate_Company_Info_Page_Dataisdisplayed();

	}



	//Corporate User Management Test Cases

	@Test (groups = {"CorporateAdmin UserManagement"})
	public void CorpUserMangement01() throws InterruptedException {
		CorpAdm_User_TC001_VerifyUsersTab corp = PageFactory.initElements(driver, CorpAdm_User_TC001_VerifyUsersTab.class);
		corp.checkUserTabandLicenseofCorpAdmin();
	}

	@Test (groups = {"CorporateAdmin UserManagement"})
	public void CorpUserMangement02() throws InterruptedException {
		CorpAdm_User_TC002_AddUser corp = PageFactory.initElements(driver, CorpAdm_User_TC002_AddUser.class);
		corp.addCorporateUser();
	}


	@Test (groups = {"CorporateAdmin UserManagement"})
	public void CorpUserMangement03() throws InterruptedException {
		CorpAdm_User_TC004_EditUserName corp = PageFactory.initElements(driver, CorpAdm_User_TC004_EditUserName.class);
		corp.editCorpUsersforNameField();
	}

	@Test (groups = {"CorporateAdmin UserManagement"})
	public void CorpUserMangement04() throws InterruptedException {
		CorpAdm_User_TC005_EditEmailId corp = PageFactory.initElements(driver, CorpAdm_User_TC005_EditEmailId.class);
		corp.editCorpUsersforEmailField();
	}

	@Test (groups = {"CorporateAdmin UserManagement"})
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
	 

	@Test (groups = {"CorporateAdmin UserManagement"})
	public void CorpUserMangement07() throws InterruptedException {
		CorpAdm_User_TC010_AddDeletedUser corp = PageFactory.initElements(driver, CorpAdm_User_TC010_AddDeletedUser.class);
		corp.addDeletedUser();
	}

	@Test (groups = {"CorporateAdmin UserManagement"})
	public void CorpUserMangement08() throws InterruptedException {
		CorpAdm_User_TC012_ValidateAddUserPageErrors corp = PageFactory.initElements(driver, CorpAdm_User_TC012_ValidateAddUserPageErrors.class);
		corp.validateAddUserPageErrors();
	}

	@Test (groups = {"CorporateAdmin UserManagement"})
	public void CorpUserMangement09() throws InterruptedException {
		CorpAdm_User_TC008_DeleteUser corp = PageFactory.initElements(driver, CorpAdm_User_TC008_DeleteUser.class);
		corp.deleteCorporateUser();
	}

	@Test (groups = {"CorporateAdmin UserManagement"})
	public void CorpUserMangement10() throws InterruptedException {
		CorpAdm_User_TC003_AddUserforAllLicenses corp = PageFactory.initElements(driver, CorpAdm_User_TC003_AddUserforAllLicenses.class);
		corp.addCorpUsersforAllLicenses();
	}

	@Test(groups = {"CorporateAdmin UserManagement"})
	public void CorpUserMangement11() throws InterruptedException {
		CorpAdm_User_TC011_VerifyPagination corp = PageFactory.initElements(driver, CorpAdm_User_TC011_VerifyPagination.class);
		corp.verifyPagination();
	}

	@Test(groups = {"CorporateAdmin UserManagement"})
	public void CorpUserMangement12() throws InterruptedException {
		CorpAdm_User_TC009_DeleteAllUser corp = PageFactory.initElements(driver, CorpAdm_User_TC009_DeleteAllUser.class);
		corp.deleteAllCorporateUser();
	}
	 


	@Test(groups = {"GO","GS","Corporate General"})
	public void CorporateDashboard01() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		CorpAdm_Dashboard_TC001_VerifyDashboard ds = PageFactory.initElements(driver, CorpAdm_Dashboard_TC001_VerifyDashboard.class);
		ds.verifyCorpAdminDashboard();
	}
	
	

	//Verify All elements present in Job summary page
	@Test(groups = {"Corporate General"})
	public void CorporateJob1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_022_Verify_JobSummaryPage s22=PageFactory.initElements(driver,Sc_022_Verify_JobSummaryPage.class);
		s22.Verify_AllElements_JobSummaryPage();
	}

	//Verify Error message for Job Summary page
	@Test (groups = {"Corporate General"})
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
	
	
	@Test (groups = {"Corporate General"})
	public void CorpAdmTC010() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		CorpAdm_TC010_VerifyActiveJobMovedtoOnHoldJob cor=PageFactory.initElements(driver,CorpAdm_TC010_VerifyActiveJobMovedtoOnHoldJob.class);
		cor.verifyActiveJobMovedtoOnHoldJob();
	}
	
	@Test (groups = {"Corporate General"})
	public void CorpAdmTC011() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		CorpAdm_TC011_VerifyOnHoldJobResumedtoActiveJob cor=PageFactory.initElements(driver,CorpAdm_TC011_VerifyOnHoldJobResumedtoActiveJob.class);
		cor.verifyOnHoldJobResumedtoActiveJob();
	}
		
	@Test (groups = {"Corporate General"})
	public void CorpAdmTC012() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		CorpAdm_TC012_VerifyOnHoldJobMovedtoClosedJob cor=PageFactory.initElements(driver,CorpAdm_TC012_VerifyOnHoldJobMovedtoClosedJob.class);
		cor.verifyOnHoldJobMovedtoClosedJob();
	}
	
	@Test (groups = {"Corporate General"})
	public void CorpAdmTC013() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		CorpAdm_TC013_VerifyClosedJobisRestartedforGS cor=PageFactory.initElements(driver,CorpAdm_TC013_VerifyClosedJobisRestartedforGS.class);
		cor.verifyClosedJobisRestartedforGS();
	}
	
	@Test (groups = {"Corporate General"})
	public void CorpAdmTC014() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		CorpAdm_TC014_VerifyClosedJobisRestartedforGO cor=PageFactory.initElements(driver,CorpAdm_TC014_VerifyClosedJobisRestartedforGO.class);
		cor.verifyClosedJobisRestartedforGO();
	}
	
	@Test (groups = {"Corporate General"})
	public void CorpAdmTC015() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		CorpAdm_TC015_VerifyClosedJobisReplicatedtoNewJob cor=PageFactory.initElements(driver,CorpAdm_TC015_VerifyClosedJobisReplicatedtoNewJob.class);
		cor.verifyClosedJobisReplicatedtoNewJob();
	}
	
	//Verify all the elements present in Login page
	@Test (groups = {"General"})
	public void Login1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		TC_001_Verify_LoginPage s5=PageFactory.initElements(driver, TC_001_Verify_LoginPage.class);
		s5.Verify_all_elements_present_in_loginPage();
	}
	//Verify error message for mail id and password of Login page
	@Test (groups = {"General"})
	public void Login2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_006_Verify_EmailID_Password_LoginPage s6=PageFactory.initElements(driver, Sc_006_Verify_EmailID_Password_LoginPage.class);
		s6.Verify_MailId_Password();
	}

	//Verify Register
	@Test (groups = {"General"})
	public void Login3() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Sc_008_Verify_Register s08=PageFactory.initElements(driver,Sc_008_Verify_Register.class);
		s08.Verify_Registration_Of_user();
	}

	//Verify All elements and text present in Forgot Password Pop up
	@Test (groups = {"General"})
	public void Login4() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_009_Verify_ForgotPasswordPage s9=PageFactory.initElements(driver, Sc_009_Verify_ForgotPasswordPage.class);
		s9.Verify_ForgotPasswordPage();
	}


	//Verify Error message for Forgot Password Pop up
	@Test (groups = {"General"})
	public void Login5() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_010_Verify_ErrorMessage_ForgotPasswordPopUP s10=PageFactory.initElements(driver,Sc_010_Verify_ErrorMessage_ForgotPasswordPopUP.class);
		s10.Verify_ErrorMessage_ForgotPasswordPopUP();
	}

	//Verify Password reset
	@Test (groups = {"General"})
	public void Login6() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_011_Verify_PasswordReset s11=PageFactory.initElements(driver,Sc_011_Verify_PasswordReset.class);
		s11.Verify_PasswordReset();
	}




	//Guaranteed Submission Test Cases
	//Verify Post Video JD by corporate User
	@Test(groups = {"GS"})
	public void Submission01() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_028_Post_Video_JD s28=PageFactory.initElements(driver, Sc_028_Post_Video_JD.class);
		s28.Verify_Post_Video_Jd();
	}

	
	//Verify Guaranteed Submission
	@Test(/*dependsOnMethods= "Submission01", */groups = {"GS"})
	public void Submission02() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_032_PerformGuaranteedSubmission s32=PageFactory.initElements(driver, Sc_032_PerformGuaranteedSubmission.class);
		s32.Verify_Guaranteed_Submission();
	}

	//Verify align of an agency by workstreets Admin
	@Test(/*dependsOnMethods="Submission02",*/ groups = {"GS"})
	public void Submission03() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_068_Verify_AlignOfAnAgency s68=PageFactory.initElements(driver, Sc_068_Verify_AlignOfAnAgency.class);
		s68.Verify_AlignOfAnAgency();
	}


	//Accept Guaranteed submission by Agency Partner
	@Test(/*dependsOnMethods="Submission03",*/ groups = {"GS"})
	public void Submission04() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Sc_087_VerifyAccept_GS s87=PageFactory.initElements(driver, Sc_087_VerifyAccept_GS.class);
		s87.Accept_GS();
	}


	// Tag Candidate by Agency Partner
	@Test(/*dependsOnMethods="Submission04",*/ groups = {"GS"})
	public void Submission05() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Sc_101_VerifyTag_Agencypartner s101=PageFactory.initElements(driver, Sc_101_VerifyTag_Agencypartner.class);
		s101.Tag_Candidate_AgencyPartner();
	}



	//verify Approve of an candidate in review submission by workstreets Admin
	@Test(/*dependsOnMethods="Submission05", */groups = {"GS"})
	public void Submission06() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Sc_080_Verify_Accept_ReviewSubmission s80=PageFactory.initElements(driver, Sc_080_Verify_Accept_ReviewSubmission.class);
		s80.Accept_ReviewSubmission();
	}



	//Shortlist candidate in pending review page by Corporate Admin
	@Test(/*dependsOnMethods="Submission06",*/ groups = {"GS"})
	public void Submission07() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Sc_036_Verify_Shortlist_PendingReview_CorporateAdmin s36=PageFactory.initElements(driver,Sc_036_Verify_Shortlist_PendingReview_CorporateAdmin.class);
		s36.Shortlist_PendingReview();
	}
	


	//Guaranteed On boarding Scenarios
	@Test(groups = {"GO"})
	public void onboarding1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		GOCampaignCreation GO = PageFactory.initElements(driver, GOCampaignCreation.class);
		GO.guaranteedOnboardingCampaignCreation();
	}

	@Test(/*dependsOnMethods="onboarding1",*/ groups = {"GO"})
	public void onboarding2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		GO_Admin_AlignAgencies align=PageFactory.initElements(driver, GO_Admin_AlignAgencies.class);
		align.AlignAgentforGO();
	}

	@Test(/*dependsOnMethods="onboarding2", */groups = {"GO"})
	public void onboarding3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		GO_AgentAcceptandTagCandidates agent = PageFactory.initElements(driver, GO_AgentAcceptandTagCandidates.class);
		agent.agentAcceptandTagCandidates();
	}

	@Test(/*dependsOnMethods="onboarding3", */groups = {"GO"})
	public void onboarding4() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		GO_AdminReviewSubmission adminreview = PageFactory.initElements(driver, GO_AdminReviewSubmission.class);
		adminreview.goAdminReviewSubmission();
	}

	@Test (/*dependsOnMethods="onboarding4",*/ groups = {"GO"})
	public void onboarding5() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		GO_CorporateShortlists corshor = PageFactory.initElements(driver, GO_CorporateShortlists.class);
		corshor.corporateShortlist();
	}


	@Test(/*dependsOnMethods ="onboarding5",*/ groups = {"GS","Corporate General"})
	public void CorporateDashboard02() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		CorpAdm_Dashboard_TC002_VerifyDashafterGS ds = PageFactory.initElements(driver, CorpAdm_Dashboard_TC002_VerifyDashafterGS.class);
		ds.verifyCorpAdminDashboardAfterGS();
	}

	@Test(/*dependsOnMethods = "onboarding5",*/ groups = {"GO","Corporate General"})
	public void CorporateDashboard03() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		CorpAdm_Dashboard_TC003_VerifyDashafterGO ds = PageFactory.initElements(driver, CorpAdm_Dashboard_TC003_VerifyDashafterGO.class);
		ds.verifyCorpAdminDashboardAfterGO();
	}
	


	@Test (groups = {"WSAdmin General"})
	public void WSAdmin01() throws InterruptedException {
		WSAdmin_TC001_VerifyAdminLogin ws = PageFactory.initElements(driver, WSAdmin_TC001_VerifyAdminLogin.class);
		ws.VerifyAdminLogin();
	}

	@Test (groups = {"WSAdmin General"})
	public void WSAdmin02() throws InterruptedException {
		WSAdmin_TC002_VerifyInvitePage ws = PageFactory.initElements(driver, WSAdmin_TC002_VerifyInvitePage.class);
		ws.verifyWSAdminInvitePage();
	}
	
	@Test (groups = {"WSAdmin General"})
	public void WSAdmin03() throws InterruptedException {
		WSAdmin_TC003_VerifyFilterUsingCandidate ws = PageFactory.initElements(driver, WSAdmin_TC003_VerifyFilterUsingCandidate.class);
		ws.verifyInvitePageFilterByCandidate();
	}
	
	@Test (groups = {"WSAdmin General"})
	public void WSAdmin04() throws InterruptedException {
		WSAdmin_TC004_VerifyFilterUsingCorporateAdmin ws = PageFactory.initElements(driver,WSAdmin_TC004_VerifyFilterUsingCorporateAdmin.class);
		ws.verifytheFilterBySelectingCorporateAdmin();
	}
	
	@Test (groups = {"WSAdmin General"})
	public void WSAdmin05() throws InterruptedException {
		WSAdmin_TC005_VerifyFilterUsingAgent ws = PageFactory.initElements(driver,WSAdmin_TC005_VerifyFilterUsingAgent.class);
		ws.verifytheFilterBySelectingAgent();
	}
	
	@Test (groups = {"WSAdmin General"})
	public void WSAdmin06() throws InterruptedException {
		WSAdmin_TC006_VerifySortByName ws = PageFactory.initElements(driver, WSAdmin_TC006_VerifySortByName.class);
		ws.verifyWSAdminSortByName();
	}
	
	@Test (groups = {"WSAdmin General"})
	public void WSAdmin07() throws InterruptedException {
		WSAdmin_TC007_VerifySortByStatus ws = PageFactory.initElements(driver, WSAdmin_TC007_VerifySortByStatus.class);
		ws.verifyWSAdminSortByStatus();
	}
	
	@Test (groups = {"WSAdmin General"})
	public void WSAdmin08() throws InterruptedException {
		WSAdmin_TC008_VerifySortByInvitedOn ws = PageFactory.initElements(driver, WSAdmin_TC008_VerifySortByInvitedOn.class);
		ws.verifyWSAdminSortByInvitedOn();
	}

	@Test (groups = {"WSAdmin General"})
	public void WSAdmin09() throws InterruptedException {
		WSAdmin_TC009_VerifyAddNewUserPage ws = PageFactory.initElements(driver, WSAdmin_TC009_VerifyAddNewUserPage.class);
		ws.verifyAddNewUserPage();
	}
	
	@Test (groups = {"WSAdmin General"})
	public void WSAdmin10() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		WSAdmin_TC010_VerifyEditingCorpAdminUnderInvite ws = PageFactory.initElements(driver, WSAdmin_TC010_VerifyEditingCorpAdminUnderInvite.class);
		ws.verifyEditInvitedCorporateAdminUser();
	}
	
	@Test (groups = {"WSAdmin General"})
	public void WSAdmin11() throws InterruptedException {
		WSAdmin_TC011_VerifyJobsTabandCountsofJobs ws = PageFactory.initElements(driver, WSAdmin_TC011_VerifyJobsTabandCountsofJobs.class);
		ws.verifytheJobsTabandGetTheCountOfJobsInEachSection();
	}
	
	@Test (groups = {"WSAdmin UserManagement"})
	public void WSAdmin12() throws InterruptedException {
		WSAdmin_TC012_VerifyUsersTab ws = PageFactory.initElements(driver, WSAdmin_TC012_VerifyUsersTab.class);
		ws.verifyUsersTabOfWSAdmin();
	}
	
	@Test (groups = {"WSAdmin UserManagement"})
	public void WSAdmin13() throws InterruptedException {
		WSAdmin_TC013_VerifyUsersAddUser ws = PageFactory.initElements(driver, WSAdmin_TC013_VerifyUsersAddUser.class);
		ws.verifyUsersTabAddNewUser();
	}
	
	@Test (groups = {"WSAdmin UserManagement"})
	public void WSAdmin14() throws InterruptedException {
		WSAdmin_TC014_VerifyAddUserPageValidation ws = PageFactory.initElements(driver, WSAdmin_TC014_VerifyAddUserPageValidation.class);
		ws.verifyUsersTabAddNewUser();
	}
	
	@Test (groups = {"WSAdmin UserManagement"})
	public void WSAdmin15() throws InterruptedException {
		WSAdmin_TC015_AddNewAdminUser ws = PageFactory.initElements(driver, WSAdmin_TC015_AddNewAdminUser.class);
		ws.verifyAddingNewUser();
	}
	
	
	@Test (groups = {"WSAdmin UserManagement"})
	public void WSAdmin16() throws InterruptedException {
		WSAdmin_TC016_AddingExistingUser ws = PageFactory.initElements(driver, WSAdmin_TC016_AddingExistingUser.class);
		ws.verifyAddingExistingAdminUser();
	}
	
	@Test (groups = {"WSAdmin UserManagement"})
	public void WSAdmin17() throws InterruptedException {
		WSAdmin_TC017_EditExistingAdminUserName ws = PageFactory.initElements(driver, WSAdmin_TC017_EditExistingAdminUserName.class);
		ws.verifyEditingExistingAdminUserName();
	}
	
	@Test (groups = {"WSAdmin UserManagement"})
	public void WSAdmin18() throws InterruptedException {
		WSAdmin_TC018_EditExistingAdminUserEmail ws = PageFactory.initElements(driver, WSAdmin_TC018_EditExistingAdminUserEmail.class);
		ws.verifyEditingExistingAdminUserEmail();
	}
	
	@Test (groups = {"WSAdmin UserManagement"})
	public void WSAdmin19() throws InterruptedException {
		WSAdmin_TC019_EditExistingAdminUserPhone ws = PageFactory.initElements(driver, WSAdmin_TC019_EditExistingAdminUserPhone.class);
		ws.verifyEditingExistingAdminUserPhone();
	}
	
	@Test (groups = {"WSAdmin UserManagement"})
	public void WSAdmin20() throws InterruptedException {
		WSAdmin_TC020_DeleteFirstAdminUser ws = PageFactory.initElements(driver, WSAdmin_TC020_DeleteFirstAdminUser.class);
		ws.verifyDeletingFirstAdminUser();
	}
	
	
	//Agency Partner Test Cases
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent01() throws InterruptedException {
		Agent_TC001_VerifyAgentLogin ag = PageFactory.initElements(driver, Agent_TC001_VerifyAgentLogin.class);
		ag.verifyAgencyPartnerLogin();
	}
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent02() throws InterruptedException {
		Agent_TC002_VerifyNewAssignmentsPage ag = PageFactory.initElements(driver, Agent_TC002_VerifyNewAssignmentsPage.class);
		ag.verifyNewAssignmentsPage();
	}
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent03() throws InterruptedException {
		Agent_TC003_VerifyActiveAssignmentsPage ag = PageFactory.initElements(driver, Agent_TC003_VerifyActiveAssignmentsPage.class);
		ag.verifyActiveAssignmentsPage();
	}
	
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent04() throws InterruptedException {
		Agent_TC004_VerifyOnHoldAssignmentsPage ag = PageFactory.initElements(driver, Agent_TC004_VerifyOnHoldAssignmentsPage.class);
		ag.verifyOnHoldAssignmentsPage();
	}
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent05() throws InterruptedException {
		Agent_TC005_VerifyClosedAssignmentsPage ag = PageFactory.initElements(driver, Agent_TC005_VerifyClosedAssignmentsPage.class);
		ag.verifyClosedAssignmentsPage();
	}
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent06() throws InterruptedException {
		Agent_TC006_VerifyInvitedCandidatePage ag = PageFactory.initElements(driver, Agent_TC006_VerifyInvitedCandidatePage.class);
		ag.verifyInvitedCandidatePageofAgencyPartner();
	}
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent07() throws InterruptedException {
		Agent_TC007_VerifyInvitedCandidateSortByInvitedOn ag = PageFactory.initElements(driver, Agent_TC007_VerifyInvitedCandidateSortByInvitedOn.class);
		ag.verifySortByInvitedOnofInvitedCandidatePageofAgencyPartner();
	}
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent08() throws InterruptedException {
		Agent_TC008_VerifyInvitedCandidateSortByName ag = PageFactory.initElements(driver, Agent_TC008_VerifyInvitedCandidateSortByName.class);
		ag.verifySortByNameofInvitedCandidatePageofAgencyPartner();
	}
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent09() throws InterruptedException {
		Agent_TC009_VerifyInvitedCandidateSortByStatus ag = PageFactory.initElements(driver, Agent_TC009_VerifyInvitedCandidateSortByStatus.class);
		ag.verifySortByStatusofInvitedCandidatePageofAgencyPartner();
	}
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent10() throws InterruptedException {
		Agent_TC010_VerifySendReminderForInvitedCandidate ag = PageFactory.initElements(driver, Agent_TC010_VerifySendReminderForInvitedCandidate.class);
		ag.verifySendReminderForInvitedCandidateOfAgencyPartner();
	}
	
	@Test (groups = {"AgencyPartner General"})
	public void WsAgent11() throws InterruptedException {
		Agent_TC011_VerifyJoinedCandidateProfile ag = PageFactory.initElements(driver, Agent_TC011_VerifyJoinedCandidateProfile.class);
		ag.verifyAgencyPartnerAbletoViewJoinedCandidateProfile();
	}
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent12() throws InterruptedException {
		Agent_TC012_VerifyAgencyPartnerAbletoAcceptNewAssignment ag = PageFactory.initElements(driver, Agent_TC012_VerifyAgencyPartnerAbletoAcceptNewAssignment.class);
		ag.verifyAgencyPartnerAbletoAcceptNewAssignment();
	}
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent13() throws InterruptedException {
		Agent_TC013_VerifyAgencyPartnerAbletoDeclineNewAssignment ag = PageFactory.initElements(driver, Agent_TC013_VerifyAgencyPartnerAbletoDeclineNewAssignment.class);
		ag.verifyAgencyPartnerAbletoDeclineNewAssignment();
	}
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent14() throws InterruptedException {
		Agent_TC014_VerifyAgencyPartnerAbletoViewJobDetailsfromNewAssignment ag = PageFactory.initElements(driver, Agent_TC014_VerifyAgencyPartnerAbletoViewJobDetailsfromNewAssignment.class);
		ag.verifyAgencyPartnerAbletoViewJobDetailsfromNewAssignment();
	}
		
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent15() throws InterruptedException {
		Agent_TC015_VerifyAgencyPartnerAbletoViewJobDetailsfromActiveAssignment ag = PageFactory.initElements(driver, Agent_TC015_VerifyAgencyPartnerAbletoViewJobDetailsfromActiveAssignment.class);
		ag.verifyAgencyPartnerAbletoViewJobDetailsfromActiveAssignment();
	}
		
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent16() throws InterruptedException {
		Agent_TC016_VerifyAgencyPartnerAbletoViewJobDetailsfromOnHoldAssignment ag = PageFactory.initElements(driver, Agent_TC016_VerifyAgencyPartnerAbletoViewJobDetailsfromOnHoldAssignment.class);
		ag.verifyAgencyPartnerAbletoViewJobDetailsfromOnHoldAssignment();
	}
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent17() throws InterruptedException {
		Agent_TC017_VerifyAgencyPartnerAbletoViewJobDetailsfromClosedAssignment ag = PageFactory.initElements(driver, Agent_TC017_VerifyAgencyPartnerAbletoViewJobDetailsfromClosedAssignment.class);
		ag.verifyAgencyPartnerAbletoViewJobDetailsfromClosedAssignment();
	} 
	
	@Test(groups = {"Candidate General"})
	public void Candidate_TC001() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
	Candidate_TC001_VerifyCandidateLoginandProfilePage lp = PageFactory.initElements(driver, Candidate_TC001_VerifyCandidateLoginandProfilePage.class);
	lp.VerifyingCandidateProfileViewPage();
	}
	
	@Test(groups= {"Candidate General"})
	public void Candidate_TC002() throws InterruptedException {
		Candidate_TC002_VerifyEditingCandidateProfilePage vc = PageFactory.initElements(driver,Candidate_TC002_VerifyEditingCandidateProfilePage.class);
		vc.candidateProfileEditVerification();
	}
	
	@Test(groups= {"Candidate General"})
	public void Candidate_TC005() throws InterruptedException {
		Candidate_TC005_VerifyValidationOfUploadingCV cu = PageFactory.initElements(driver, Candidate_TC005_VerifyValidationOfUploadingCV.class);
		cu.VerifyCandidateResumeEdit();
	}
	
	
	
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent18() throws InterruptedException {
		Agent_TC018_VerifyAssignCandidateDetailsForJob ag = PageFactory.initElements(driver, Agent_TC018_VerifyAssignCandidateDetailsForJob.class);
		ag.verifyAssignCandidateDetailsForJob();
	}
	
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent19() throws InterruptedException {
		Agent_TC019_VerifyValidationOfInviteNewCandidateForJob ag = PageFactory.initElements(driver, Agent_TC019_VerifyValidationOfInviteNewCandidateForJob.class);
		ag.verifyValidationOfInviteNewCandidateForJob();
	}
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent20() throws InterruptedException {
		Agent_TC020_VerifyInviteNewCandidateForJob ag = PageFactory.initElements(driver, Agent_TC020_VerifyInviteNewCandidateForJob.class);
		ag.verifyInviteNewCandidateForJob();
	}
	
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent21() throws InterruptedException {
		Agent_TC021_VerifyInvitedTabofaJob ag = PageFactory.initElements(driver, Agent_TC021_VerifyInvitedTabofaJob.class);
		ag.verifyInviteNewCandidateForJob();
	}
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent22() throws InterruptedException {
		Agent_TC022_VerifyTagExistingTabofaJob ag = PageFactory.initElements(driver, Agent_TC022_VerifyTagExistingTabofaJob.class);
		ag.verifyTagExistingTabOfJob();
	}
	
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent23() throws InterruptedException {
		Agent_TC023_VerifySearchResultsForNoFiltersandTagCandidate ag = PageFactory.initElements(driver, Agent_TC023_VerifySearchResultsForNoFiltersandTagCandidate.class);
		ag.verifySearchResultsForNoFiltersandTagCandidate();
	}
	
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent24() throws InterruptedException {
		Agent_TC024_VerifySearchResultsForNameFilterandTagCandidate ag = PageFactory.initElements(driver, Agent_TC024_VerifySearchResultsForNameFilterandTagCandidate.class);
		ag.verifySearchResultsForNameFilterandTagCandidate();
	}
	
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent25() throws InterruptedException {
		Agent_TC025_VerifySearchResultsForEmailFilterandTagCandidate ag = PageFactory.initElements(driver, Agent_TC025_VerifySearchResultsForEmailFilterandTagCandidate.class);
		ag.verifySearchResultsForEmailFilterandTagCandidate();
	}
	
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent26() throws InterruptedException {
		Agent_TC026_VerifySearchResultsForSkillsFilterandTagCandidate ag = PageFactory.initElements(driver, Agent_TC026_VerifySearchResultsForSkillsFilterandTagCandidate.class);
		ag.verifySearchResultsForSkillsFilterandTagCandidate();
	}
	
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent27() throws InterruptedException {
		Agent_TC027_VerifySearchResultsForExperienceFilterandTagCandidate ag = PageFactory.initElements(driver, Agent_TC027_VerifySearchResultsForExperienceFilterandTagCandidate.class);
		ag.verifySearchResultsForExperienceFilterandTagCandidate();
	}
	
	
	@Test(groups= {"AgencyPartner General"})
	public void WSAgent28() throws InterruptedException {
		Agent_TC028_VeriifyTaggedTabofaJob ag = PageFactory.initElements(driver, Agent_TC028_VeriifyTaggedTabofaJob.class);
		ag.veriifyTaggedTabofaJob();;
	}
	
}
