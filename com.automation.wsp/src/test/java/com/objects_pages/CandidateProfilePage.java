package com.objects_pages;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.controller.Action_Method;
import com.controller.Variables;
import com.relevantcodes.extentreports.LogStatus;

public class CandidateProfilePage extends Action_Method
{

	//Elements of Candidate Profile View Page
	@FindBy(xpath="//section/div[@class= \"heading\"]")
	WebElement Profile_Headline;
	@FindBy(xpath ="//a[contains(text(),'Profile')]")
	WebElement Profile;

	@FindBy(xpath="//div/img[@class=\"profile-border\"]")
	WebElement Profile_Picture;

	@FindBy(xpath="//div[@class=\"name-wrapper\"]//span/mat-icon[contains(text(), \"mode_edit\")]")
	WebElement Edit_Button;

	@FindBy(xpath="//span[@class= \"views-wrapper\"]/div[@class=\"views-back\"]")
	WebElement Views_Count;

	@FindBy(xpath="//div[@class=\"name-wrapper\"]//a/mat-icon[contains(text(),\"share\")]")
	WebElement Share_Icon;

	@FindBy(xpath="//div/div[contains(text(),'Experience') and @class=\"heading\" ]")
	WebElement Experience_Data;

	@FindBy(xpath="//div/div[contains(text(),'Skill Rating') and @class=\"heading\" ]")
	WebElement Skill_Rating;

	@FindBy(xpath="//div//div[@class=\"vjs-poster\"]")
	WebElement Video_Profile;

	@FindBy(xpath="//div//button[@class=\"vjs-big-play-button\"]")
	WebElement Play_Button;

	@FindBy(xpath="//div/div[contains(text(), 'Candidate Information') and @class=\"heading\"]")
	WebElement Candidate_Inforamtion;

	@FindBy(xpath= "//div/div[contains(text(), 'Education') and @class=\"heading\"]")
	WebElement Education;

	@FindBy(xpath="//div/div[@class=\"ndfHFb-c4YZDc-cYSp0e-s2gQvd ndfHFb-c4YZDc-s2gQvd\"]")
	WebElement Resume;

	@FindBy(xpath="//div[text()='Email']/following-sibling::div[2]")
	WebElement candEmail;

	@FindBy(xpath="//div[@class= \"headline\"]")
	WebElement Headline_Content;

	@FindBy(xpath="//span[@class=\"views-wrapper\"]/div[@class=\"views-back\"]/span/following-sibling::span[2]")
	WebElement TotalView_Count;


	//Elements of Candidate video Profile Page

		@FindBy(xpath="//a/span[contains(text(),'Re-take')]")
		WebElement Video_Retake;

		@FindBy(xpath="//a/img[@class='img-responsive custom-img' and @src='assets/Record.png']")
		WebElement Record_Button;

		@FindBy(xpath="//div/div[text()='Next' and @class='btn btn-red btn-big transition-opacity']")
		WebElement Video_Next;

		@FindBy(xpath="//div//button[contains(text(),'Start Recording')]")
		WebElement StartRecording_Button;

		@FindBy(xpath="//div//button[contains(text(),'Stop Recording')]")
		WebElement StopRecording_Button;

		@FindBy(xpath="//div/div[text()='Next' and @class='btn btn-big btn-short btn-red iblock-text']")
		WebElement VideoSecNext;

		@FindBy(xpath="//div//div[text()='Retake ?']")
		WebElement VideoSecRetake;

		@FindBy(xpath="//div[@id= 'goToNextStep' and contains(text(), 'Finish')]")
		WebElement VideosecFinish_Button;
		
		@FindBy(xpath="//div//div[text()='Finish' and @class='btn btn-big btn-short btn-red iblock-text validateRecording']")
		WebElement CompleteVideoFinish;
		
		@FindBy(xpath="//button/i[contains(text(),'close')]")
		WebElement closemsg;
		
		@FindBy(xpath="//div/img[@class='profile-video-banner']")
		WebElement gifImage;
		
		@FindBy(xpath="//div/app-video-display")
		WebElement uploadedvideo;
		
	//Elements of Profile Edit

	@FindBy(xpath="//div/span[contains(text(),'Total Experience:')]//following-sibling::span")
	WebElement TotalExp_Data;

	@FindBy(xpath= "//div[text() ='Profile Information']")
	WebElement ProfileInformation_Page;	   

	@FindBy(xpath="//button[text()='Next']")
	WebElement Info_Next;

	@FindBy(xpath="//div/h2[text() ='Video Profile']")
	WebElement VideoProfile_Page;

	@FindBy(xpath="//button//span[text()='Next']")
	WebElement Video_ProfileNext;

	@FindBy(xpath="//div/h2[text() ='Education']")
	WebElement Education_Page;

	@FindBy(xpath="//button//span[text()='Next']")
	WebElement Education_Next;

	@FindBy(xpath="//div/div[text() ='Work Experience']")
	WebElement WorkExp_Page;

	@FindBy(xpath="//button//span[text()='Finish']")
	WebElement Finish_Button;

	@FindBy(xpath="//section/div[@class='heading']")
	WebElement Profile_View;

	//Elements in CV upload

	@FindBy(xpath="//section/div//following-sibling::iframe")
	WebElement Resume_Src;

	@FindBy(xpath="//a[contains(text(),' Profile ')]")
	WebElement Profile_Tab;

	@FindBy(xpath="//div/label[@class=\"upload\"]/img")
	WebElement ViewCV_button;

	@FindBy(xpath= "//div/input[@type=\"file\"]")
	WebElement UpdateCV_filePath;

	@FindBy(xpath= "//button[text()='Update CV']")
	WebElement UpdateCV_Button;

	@FindBy(xpath= "//span/i[text()=\"close\"]")
	WebElement Close;

	@FindBy(xpath="//div[contains(text(),'Resume is updated successfully')]")
	WebElement successMsg;

	@FindBy(xpath="//button/i[contains(text(),'close')]")
	WebElement CloseMsg;
	
	@FindBy(xpath="//a/img[@class='img-responsive custom-img']")
	WebElement Thumbnail;

	public boolean Verify_ProfileHeadline()
	{
		try
		{
			return Profile_Headline.isDisplayed();
		}
		catch( Exception e)
		{
			return false;
		}
	}

	public boolean Verify_Profile_Picture()
	{
		try
		{
			return Profile_Picture.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Verify_EditButton()
	{
		try
		{
			return Edit_Button.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean Verify_Views_Count()
	{
		try
		{
			return Views_Count.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean Verify_Share_Icon()
	{
		try
		{
			return Share_Icon.isDisplayed();
		}
		catch( Exception e)
		{
			return false;
		}
	}

	public boolean Verify_Experience_Data()
	{
		try
		{
			return Experience_Data.isDisplayed();

		}
		catch (Exception e)
		{
			return false;
		}
	}

	public String Display_TotalExpData()
	{
		return TotalExp_Data.getText();
	}


	public boolean Verify_Skill_Rating()
	{
		try
		{
			return Skill_Rating.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean Verify_Video_Profile()
	{
		try
		{
			return Video_Profile.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Verify_Play_Button()
	{
		try
		{
			return Play_Button.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Verify_Candidate_Inforamtion()
	{
		try
		{
			return Candidate_Inforamtion.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Verify_Education()
	{
		try
		{
			return Education.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Verify_Resume()
	{
		try
		{
			return Resume.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}


	public String FetchingCandidate_EmailId()
	{
		try {
			return candEmail.getText();
		}catch(Exception e) {
			return "No Email";
		}
	}

	public String FetchingCandidateProfile_Headline()
	{
		try {
			return Headline_Content.getText();
		}catch(Exception e) {
			return "No Headline";
		}
	}

	public String FetchingProfileView_Count()
	{
		try {
			return TotalView_Count.getText();
		}catch(Exception e) {
			return "No View count";
		}
	}


	public boolean click_OnEditButton()
	{
		try
		{
			Edit_Button.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public boolean VerifyProfileInformation_Page()
	{
		try
		{
			return ProfileInformation_Page.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public boolean click_OnNext()
	{
		try
		{
			Info_Next.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public boolean VerifyVideoProfile_Page()
	{
		try
		{
			return VideoProfile_Page.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Video_ProfileNext()
	{
		try
		{
			Video_ProfileNext.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean VerifyEducation_Page()
	{
		try
		{
			return Education_Page.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Education_Next()
	{
		try
		{
			wait_for_elementpresent_Clickable(Education_Next);
			Education_Next.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean VerifyWorkExp_Page()
	{
		try
		{
			return WorkExp_Page.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Finish_Button()
	{
		try
		{
			wait_for_elementpresent_Clickable(Finish_Button);
			Finish_Button.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean ProfileView_Page()
	{
		try
		{
			return Profile_View.isDisplayed();
		}
		catch (Exception e)
		{
			return false;
		}
	}



	//methods of CV Upload

	public String ResumeSource()
	{
		return  Resume_Src.getAttribute("src"); 	
	}

	public boolean ClickonEdit()
	{
		try
		{
			Edit_Button.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean ClickOn_ViewCV()
	{
		try
		{
			ViewCV_button.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Update()
	{
		try
		{
			wait_for_elementpresent(UpdateCV_Button);
			return UpdateCV_Button.isDisplayed();

		}
		catch( Exception e)
		{
			return false;
		}
	}
	public boolean Update_CV()
	{
		try
		{
			UpdateCV_filePath.sendKeys(Variables.ResumeWithoutContact);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}


	public boolean Close_Button()
	{
		try
		{
			Close.click();

			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public String verifySuccessMsg()
	{
		return successMsg.getText();
	}	

	public boolean ProfileTab()
	{
		try
		{
			Profile_Tab.click();

			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	//Function to return the src of the video if video present else verify image present
		public String getSrcofVideo()  {
			try{
				String src = uploadedvideo.getAttribute("ng-reflect-video-url");
			    if(src.contains("amazonaw"))
			    {
			    	System.out.println("Uploaded Video");
			    	return src+"s3";
			    }
			    
			    else
			    {
			    	System.out.println("Recorded Video");
			    	return src+"MyInterview";
			    }
				
			
			}catch(Exception e) {
				String gif = gifImage.getAttribute("src");
				return gif;
				}
			
		}
			 
		public void captureCandidateVideo() throws InterruptedException {
			MyInterviewPage mip=PageFactory.initElements(driver,MyInterviewPage.class);
			
			if(Video_Retake.isDisplayed()) {
				logger.log(LogStatus.PASS," Candidate has to Retake video");
				Video_Retake.click();
				Thread.sleep(2000);
				mip.candidateProfileVideoCapturing();
				Thread.sleep(5000);
				closemsg.click();
				//wait_for_elementpresent(Video_ProfileNext);
				//Video_ProfileNext.click();
			}
		}
			
			public void captureCandidateNewVideo() throws InterruptedException {
				MyInterviewPage mip=PageFactory.initElements(driver,MyInterviewPage.class);
				
				wait_for_elementpresent(Thumbnail);
				try{
					
					Thumbnail.click();					
				}catch(Exception e) {
					Thumbnail.click();
				}
				logger.log(LogStatus.PASS," Candidate has to upload a new video");
				Thread.sleep(2000);
				mip.candidateProfileVideoCapturing();
				Thread.sleep(5000);
				closemsg.click();
				//wait_for_elementpresent(Video_ProfileNext);
				//Video_ProfileNext.click();
			}

		public boolean Start_Video()
		{
			StartRecording_Button.click();
			return true;
		}

	//Elements for Error validation
	@FindBy(xpath="//div[@class='name-wrapper']//span/mat-icon[@class='mat-icon material-icons']")
	WebElement Edit_button;

	@FindBy(xpath="//div/span[@class=\"file_error\"]")
	WebElement InvalidCV_Format;


	@FindBy(xpath="//div/input[@placeholder='Profile Headline']")
	WebElement Profile_HeadlineInput;

	@FindBy(xpath= "//mat-error/span[@class=\"ng-star-inserted\"]")
	WebElement Headline_WarningMsg;

	/*@FindBy(xpath="//div[@style='position:relative']//mat-icon[contains(text(),'mode_edit')]")
	WebElement Image_Edit;

	@FindBy(xpath="//input[@type='file' and @class='upload']//parent::div")
	WebElement Image_UploadBtn;

	 */

	@FindBy(xpath= "//div/input[@placeholder='Name']")
	WebElement Name;

	@FindBy(xpath="//mat-error/span[@class=\"ng-star-inserted\"]")
	WebElement Name_WarningMsg;

	@FindBy(xpath="//div/input[@placeholder='mm/dd/yyyy']")
	WebElement Birth_Date;

	@FindBy(xpath="//mat-error[contains(text(),'Please enter date of birth')]")
	WebElement DateOfBirth_Warning;

	@FindBy(xpath= "//div/input[@placeholder='Current Location']")
	WebElement Current_Location;

	@FindBy(xpath="//div/mat-error[contains(text(),'Invalid current location.')]")
	WebElement InvalidLocation_Error;

	@FindBy(xpath="//div/mat-error[contains(text(),' Please enter current location')]")
	WebElement NoLocationSelected_Error;

	@FindBy(xpath="//div/input[@name='languages']")
	WebElement Language;

	@FindBy(xpath="//div/mat-error[contains(text(),' Invalid language.')]")
	WebElement InvalidTextInLanguage_Field;	

	@FindBy(xpath="//div/mat-error[contains(text(),' Please select language ')]")
	WebElement NoLanguage_Selected;

	@FindBy(xpath="//mat-option/span")
	WebElement LanguageSelect;

	@FindBy(xpath="//div/mat-error[contains(text(),' Maximum 5 languages are allowed.')]")
	WebElement Language_LimitError;

	@FindBy(xpath="//div/mat-error[contains(text(),' Language is already selected. ')]")
	WebElement Duplicate_Language;

	@FindBy(xpath="//div/input[@placeholder='Current Designation' and @type='text']")
	WebElement Current_Designation;

	@FindBy(xpath="//mat-error/span[contains(text(),'Allowed Characters \"a-z A-Z\" ')]")
	WebElement Invalid_Designation;

	@FindBy(xpath="//mat-error/span[contains(text(),'Please enter current designation')]")
	WebElement No_Designation;

	@FindBy (xpath="//div/input[@id='geo_location']")
	WebElement Nearest_Landmark;

	@FindBy(xpath="//mat-error/span[contains(text(), ' Choose a valid address from the dropdown ')]")
	WebElement Invalid_LandmarkError;

	@FindBy(xpath="//div/input[@name='preferred_location_id']")
	WebElement Relocation_Preference;

	@FindBy(xpath="//mat-error[contains(text(), ' Invalid relocation preference. ')]")
	WebElement RelocationPreference_ErrorForInvalidText;

	@FindBy(xpath="//div/input[@name='exp_year']")
	WebElement TotalExp_Years;

	@FindBy(xpath="//mat-error[contains(text(), ' Please enter work experience in Years ')]")
	WebElement NoWorkExperience_YearsError;

	@FindBy(xpath="//div/input[@name='exp_month']")
	WebElement TotalExp_Months;

	@FindBy(xpath="//mat-error[contains(text(), ' Please enter work experience in Months')]")
	WebElement NoWorkExperience_MonthsError;

	@FindBy(xpath="//input[@id='skillName']")
	WebElement Skills_Title;

	@FindBy(xpath="//div[contains(text(),' Please enter a valid title ')]")
	WebElement InvalidSkillTitle;

	@FindBy(xpath="//button[@id='next']/span[@class='mat-button-wrapper']")
	WebElement AddSkill_Button;

	@FindBy(xpath="//div[contains(text(),' Required fields cannot be empty.')]")
	WebElement NoSkillData_Added;

	@FindBy(xpath="//div/i[contains(text(),'delete')]")
	WebElement Education_DeleteButton;

	@FindBy(xpath="//button/span[contains(text(),'Proceed')]")
	WebElement ProceedDelete;

	@FindBy(xpath="//div[contains(text(),'Should have at-least 1 Education')]")
	WebElement ErrorMsgWhenNoEducationIsAdded;

	@FindBy(xpath="//input[@name='degree']")
	WebElement Degree;

	@FindBy(xpath="//span[contains(text(),' Bachelor of Architecture (B.Arch.) ')]")
	WebElement DegreeType;

	@FindBy(xpath="//mat-error[contains(text(),' Invalid degree.')]")
	WebElement InvalidDegree_Error;

	@FindBy(xpath="//mat-error[contains(text(), 'Please select your degree.')]")
	WebElement NoDegree_Error;

	@FindBy(xpath="//input[@name='university']")
	WebElement University;

	@FindBy(xpath="//span[contains(text(),' Please enter your university ')]")
	WebElement NoUniversity_Error;

	@FindBy(xpath="//input[@name='specialization']")
	WebElement Specialization;

	@FindBy(xpath="//span[contains(text(),' Please enter your specialization ')]")
	WebElement NoSpecialization_Error;

	@FindBy(xpath="//input[@placeholder='From']")
	WebElement From_Duration;

	@FindBy(xpath="//span[contains(text(),' Please select the start date ')]")
	WebElement NoFromDate_Error;

	@FindBy(xpath="//input[@placeholder='To']")
	WebElement To_Duration;

	@FindBy(xpath="//span[contains(text(),' Please select the end date ')]")
	WebElement NoToDate_Error;

	@FindBy(xpath="//div/button[@type='submit']")
	WebElement AddEducation_Button;

	@FindBy(xpath="//form/div[4]/div[2]/button")
	WebElement AddWorkExperience_Button;

	@FindBy(xpath="//input[@placeholder='Job Title']")
	WebElement JobTitle;

	@FindBy(xpath="//span[contains(text(),' Please enter the title ')]")
	WebElement NoJobTitle_Error;

	@FindBy(xpath="//input[@name='company_name']")
	WebElement CompanyOrganization;

	@FindBy(xpath="//span[contains(text(),'Please enter your company name')] ")
	WebElement NoCompanyName_Error;

	@FindBy(xpath="//input[@name='location_id']")
	WebElement Work_Location;

	@FindBy(xpath="//mat-error[contains(text(),' Invalid location ')]")
	WebElement InvalidWorkLocation_Error;

	@FindBy(xpath= "//mat-error[contains(text(),' Please select the work location.')]")
	WebElement NoWorkLocation_Error;

	@FindBy(xpath="//mat-accordion[2]/div[1]/mat-expansion-panel[1]/mat-expansion-panel-header")
	WebElement ProjectShowcase_Accordion;

	@FindBy(xpath="//button[@id='projectSubmitBtn']")
	WebElement AddProject_Btn;

	@FindBy(xpath="//span[contains(text(),'Company Name')]")
	WebElement CompanyName;

	@FindBy(xpath="//mat-error[contains(text(),'Please Select Company Name')]")
	WebElement CompanyName_Error;

	@FindBy(xpath="//input[@name='project_title']")
	WebElement ProjectTitle;

	@FindBy(xpath="//textarea[@name='challenges']")
	WebElement Challenges;

	@FindBy(xpath="//textarea[@name='contribution']")
	WebElement MyContribution;

	@FindBy(xpath="//span[contains(text(),' Please enter your project title ')]")
	WebElement NoProjectTitle_Error;

	@FindBy(xpath="//span[contains(text(),' Please enter the challenges ')]")
	WebElement NoChallenges_Error;

	@FindBy(xpath="//span[contains(text(),' Please enter your contribution ')]")
	WebElement NoContribution_Error;	


	String x,y,z,q,p,r,s,t,u,v;
	public boolean errorValidationForProfileInformation_Page() {


		try {
			//Verifying Invalid CV format
			ViewCV_button.click();
			UpdateCV_filePath.sendKeys(Variables.InvalidResume);
			InvalidCV_Format.isDisplayed();
			x = InvalidCV_Format.getText();
			Close.click();


			//Verifying Profile Headline.

			Profile_HeadlineInput.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			Profile_HeadlineInput.sendKeys(Keys.TAB);
			Headline_WarningMsg.isDisplayed();
			y = Headline_WarningMsg.getText();

			//Verifying Name input text
			Name.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			Name.sendKeys(Keys.TAB);
			Name_WarningMsg.isDisplayed();
			z = Name_WarningMsg.getText();

			//Verifying DateOfBirth field
			Birth_Date.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			Birth_Date.sendKeys(Keys.TAB);
			DateOfBirth_Warning.isDisplayed();
			q = DateOfBirth_Warning.getText();

			//Verifying Current Location field
			Current_Location.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			Current_Location.sendKeys("abc1");
			Current_Location.sendKeys(Keys.TAB);
			InvalidLocation_Error.isDisplayed();
			p = InvalidLocation_Error.getText();

			//Verifying Language field
			/*Select LanguagePills = new Select(driver.findElement(By.xpath("//div/input[@name='languages']")));
			LanguagePills.deselectAll();
			NoLanguage_Selected.isDisplayed();*/
			Language.sendKeys("abc");
			Language.sendKeys(Keys.TAB);
			InvalidTextInLanguage_Field.isDisplayed();
			r = InvalidTextInLanguage_Field.getText();
			Language.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			//Select 6 languages
			Language.sendKeys("English");
			LanguageSelect.click();

			Language.sendKeys("Hindi");
			LanguageSelect.click();

			Language.sendKeys("Kannada");
			LanguageSelect.click();

			/*Language.sendKeys("Marathi");
			LanguageSelect.click();*/

			//Select Duplicate Language
			Language.sendKeys("English");
			LanguageSelect.click();
			Duplicate_Language.isDisplayed();
			s = Duplicate_Language.getText();
			Thread.sleep(1000);
			Language.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));

			//language limit error
			Language.sendKeys("Tamil");
			LanguageSelect.click();
			Language.sendKeys("Konkani");
			LanguageSelect.click();
			Thread.sleep(2000);
			Language_LimitError.isDisplayed();
			t = Language_LimitError.getText();




			//Verifying Current Designation
			Thread.sleep(2000);
			wait_for_elementpresent(Current_Designation);
			Current_Designation.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			Current_Designation.sendKeys(Keys.TAB);
			No_Designation.isDisplayed();
			u = No_Designation.getText();
			Thread.sleep(2000);
			Current_Designation.sendKeys("123");
			Current_Designation.sendKeys(Keys.TAB);
			Invalid_Designation.isDisplayed();	
			v = Invalid_Designation.getText();
			Thread.sleep(3000);






			return true;
		}
		catch(Exception e)
		{
			return false;
		}	
	}	

	public ArrayList<String> getAllErrorMessagesForProfileInfoPage(){
		ArrayList<String> a = new ArrayList<String>();
		a.add(x);
		a.add(y);
		a.add(z);
		a.add(q);
		a.add(p);
		a.add(r);
		a.add(s);
		a.add(t);
		a.add(u);
		a.add(v);
		return a;		
	}



	public boolean errorValidationForProfileInformation_PageOtherDetails() {

		try {

			driver.navigate().refresh();	
			//Verifying Nearest Landmark field
			Thread.sleep(3000);
			Nearest_Landmark.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			Nearest_Landmark.sendKeys("aqazx");
			Info_Next.click();
			Thread.sleep(3000);
			Invalid_LandmarkError.isDisplayed();
			p = Invalid_LandmarkError.getText();

			//Verifying Relocation Preference
			Thread.sleep(3000);
			Relocation_Preference.sendKeys("123");
			Relocation_Preference.sendKeys(Keys.TAB);
			RelocationPreference_ErrorForInvalidText.isDisplayed();
			q = RelocationPreference_ErrorForInvalidText.getText();

			//Verifying Total Work Experience
			TotalExp_Years.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			NoWorkExperience_YearsError.isDisplayed();
			r = NoWorkExperience_YearsError.getText();
			TotalExp_Months.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			NoWorkExperience_MonthsError.isDisplayed();
			s = NoWorkExperience_MonthsError.getText();

			//Verifying Invalid Skill Title
			Skills_Title.sendKeys("1");
			Skills_Title.sendKeys(Keys.TAB);
			Thread.sleep(3000);
			InvalidSkillTitle.isDisplayed();
			t = InvalidSkillTitle.getText();

			Skills_Title.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			AddSkill_Button.click();
			NoSkillData_Added.isDisplayed();
			u = NoSkillData_Added.getText();
			Thread.sleep(2000);

			//No Experience data
			Skills_Title.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			Skills_Title.sendKeys("Selenium");
			AddSkill_Button.click();
			scrollingToBottomofAPage(); 
			NoSkillData_Added.isDisplayed();
			v = NoSkillData_Added.getText();
			Thread.sleep(1000);
			driver.navigate().refresh();
			return true;

		}
		catch(Exception e)
		{
			return false;
		}

	}

	public ArrayList<String> getAllErrorMessagesForOtherDetailsInProfileInfoPage(){
		ArrayList<String> a = new ArrayList<String>();
		a.add(p);
		a.add(q);
		a.add(r);
		a.add(s);
		a.add(t);
		a.add(u);
		a.add(v);
		return a;		
	}


	public boolean errorValidationForEducationPage() {

		try {
			Info_Next.click();
			Thread.sleep(2000);
			Video_ProfileNext.click();
			Thread.sleep(2000);

			//Empty fields
			wait_for_elementpresent(AddEducation_Button);
			AddEducation_Button.click();
			NoDegree_Error.isDisplayed();
			p = NoDegree_Error.getText();
			NoUniversity_Error.isDisplayed();
			q = NoUniversity_Error.getText();
			NoSpecialization_Error.isDisplayed();
			r = NoSpecialization_Error.getText();
			NoFromDate_Error.isDisplayed();
			s = NoFromDate_Error.getText();
			NoToDate_Error.isDisplayed();
			t = NoToDate_Error.getText();
			Thread.sleep(2000);
			driver.navigate().refresh();

			//Verifying degree field
			Degree.sendKeys(Keys.TAB);
			NoDegree_Error.isDisplayed();
			Degree.sendKeys("123");
			Degree.sendKeys(Keys.TAB);
			InvalidDegree_Error.isDisplayed();


			//Verifying University field
			University.sendKeys(Keys.TAB);
			NoUniversity_Error.isDisplayed();

			//Verifying Specialization field
			Specialization.sendKeys(Keys.TAB);
			NoSpecialization_Error.isDisplayed();

			//Verifying Duration field
			From_Duration.sendKeys(Keys.TAB);
			NoFromDate_Error.isDisplayed();
			To_Duration.sendKeys(Keys.TAB);
			NoToDate_Error.isDisplayed();

			Thread.sleep(1000);
			scrollingToBottomofAPage();
			Education_Next.click();
			Finish_Button.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	} 
	
	public ArrayList<String> getAllErrorMessagesForEducationPage(){
		ArrayList<String> a = new ArrayList<String>();
		a.add(p);
		a.add(q);
		a.add(r);
		a.add(s);
		a.add(t);
		return a;		
	}

	public boolean errorValidationForWorkExperienceAndProjectShowcasePage()
	{
		try {

			Info_Next.click();
			Video_ProfileNext.click();
			scrollingToBottomofAPage();
			Thread.sleep(1000);
			Education_Next.click();

			//Verify click on Add Work Exp btn without any data
			Thread.sleep(3000);
			AddWorkExperience_Button.click();
			NoJobTitle_Error.isDisplayed();
			p = NoJobTitle_Error.getText();
			NoCompanyName_Error.isDisplayed();
			q = NoCompanyName_Error.getText(); 
			NoWorkLocation_Error.isDisplayed();
			r = NoWorkLocation_Error.getText();
			NoFromDate_Error.isDisplayed();
			s = NoFromDate_Error.getText();
			NoToDate_Error.isDisplayed();
			t = NoToDate_Error.getText();
			driver.navigate().refresh();


			//Verify Job Title field
			Thread.sleep(3000);
			JobTitle.sendKeys(Keys.TAB);
			NoJobTitle_Error.isDisplayed();

			//Verify Company/Organization field
			CompanyOrganization.sendKeys(Keys.TAB);
			NoCompanyName_Error.isDisplayed();

			//Verify No Location
			Work_Location.sendKeys(Keys.TAB);
			NoWorkLocation_Error.isDisplayed();				

			//Verify Invalid Company Location
			Work_Location.sendKeys("abc");
			Work_Location.sendKeys(Keys.TAB);
			InvalidWorkLocation_Error.isDisplayed();

			//Verifying Duration field
			From_Duration.sendKeys(Keys.TAB);
			NoFromDate_Error.isDisplayed();
			To_Duration.sendKeys(Keys.TAB);
			NoToDate_Error.isDisplayed();

			//Verifying Project Showcase
			ProjectShowcase_Accordion.click();
			AddProject_Btn.click();
			CompanyName_Error.isDisplayed();
			u = CompanyName_Error.getText();
			NoProjectTitle_Error.isDisplayed();
			v = NoProjectTitle_Error.getText();
			NoChallenges_Error.isDisplayed();
			x = NoChallenges_Error.getText();
			NoContribution_Error.isDisplayed();
			y = NoContribution_Error.getText();
			driver.navigate().refresh();

			//Verifying Company name field
			ProjectShowcase_Accordion.click();
			Thread.sleep(1000);

			//Verifying Project title
			ProjectTitle.sendKeys(Keys.TAB);
			NoProjectTitle_Error.isDisplayed();

			//Verifying Challenges
			Challenges.sendKeys(Keys.TAB);
			NoChallenges_Error.isDisplayed();

			//Verifying My Contribution
			MyContribution.sendKeys(Keys.TAB);
			NoContribution_Error.isDisplayed();

			Finish_Button.click();
			Thread.sleep(3000);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public ArrayList<String> getAllErrorMessagesForWorkAndProjectPage(){
		ArrayList<String> a = new ArrayList<String>();
		a.add(p);
		a.add(q);
		a.add(r);
		a.add(s);
		a.add(t);
		a.add(u);
		a.add(v);
		a.add(x);
		a.add(y);
		return a;		
	}


	//Skill fields check

	@FindBy(xpath="//div[contains(text(),'Cannot add more than 25 skills per category')]")
	WebElement MaxSkillError;

	@FindBy(xpath="//input[@placeholder='Years' and @id='expYears']")
	WebElement SkillExpYears;

	@FindBy(xpath="//input[@placeholder='Months' and @id='expMonths']")
	WebElement SkillExpMonths;

	@FindBy(xpath="//div[contains(text(),' Other Skills ')]")
	WebElement OtherSkillsBtn;

	@FindBy(xpath="//div[contains(text(),'Success')]")
	WebElement SkillSuccessMsg;

	@FindBy(xpath="//div[contains(text(), 'Skill is already added')]")
	WebElement DuplicateSkill;

	@FindBy(xpath = "//button/span[contains(text(),'Proceed')]")
	WebElement ProceedDel;

	@FindBy(xpath = "//div[@class='content-holder']")
	WebElement MsgBar;

	@FindBy(xpath="//div[@class='row app-skill-display-row-wrapper skill-display-sizing']/div")
	WebElement SkillText;

	@FindBy(xpath="//mat-icon[@class='skill-icon mat-icon material-icons'][1]")
	WebElement EditSkillBtn;

	@FindBy(xpath="//button[@id='next' and @type='submit']")
	WebElement SkillUpdateIcon;

	public void deleteSkills(int n) throws InterruptedException {


		List<WebElement> skill = driver.findElements(By.xpath("//mat-card["+n+"]//mat-card-content/mat-list[@class='mat-list']//div//mat-icon[2]"));
		int count = skill.size();
		for(int i=count; i>1; i--) 
		{
			driver.findElement(By.xpath("//div//mat-icon[2]")).click();
			Thread.sleep(2000);
			ProceedDel.click();
			CloseMsg.click();
		}
	}
	public boolean verifyMaxSkillLimit() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		String MsgContent;
		int i=1;
		int j=1;
		boolean x=true;;

		Edit_Button.click();
		//Verify Must Have SKills

		Thread.sleep(2000);
		do 
		{
			String title = getExceldata(Variables.testdata,Variables.AddSkillsPage,i,j);
			Thread.sleep(2000);
			wait_for_elementpresent(Skills_Title);
			Skills_Title.click();
			Skills_Title.sendKeys(title);
			SkillExpYears.sendKeys("0");
			SkillExpMonths.sendKeys("0");
			AddSkill_Button.click();
			MsgContent = MsgBar.getText();
			//Check if max met	
			if(MsgContent.contains("Skill Added Successfully"))
			{
				x = true;
				i++;
				CloseMsg.click();

			}
			else if(MsgContent.contains("Skill is already added"))
			{
				i++;
				x = true;
				CloseMsg.click();

			}
			else 
			{
				x = false;
				CloseMsg.click();

			}

		}while(x);

		return true;




	}	 
	//Verify Good to have Skills

	public boolean limitForOtherSkills() throws InterruptedException,IOException, EncryptedDocumentException, InvalidFormatException
	{
		int a=25;
		int b=1;
		boolean c;

		Thread.sleep(2000);
		do 
		{
			String title = getExceldata(Variables.testdata,Variables.AddSkillsPage,a,b);
			Thread.sleep(3000);
			wait_for_elementpresent(Skills_Title);
			//scrollingToElementofAPage(Skills_Title);
			scrollingToTopofAPage();
			Skills_Title.click();
			Skills_Title.sendKeys(title);
			Skills_Title.sendKeys(Keys.TAB);
			Thread.sleep(2000);
			OtherSkillsBtn.click();
			SkillExpYears.sendKeys("0");
			SkillExpMonths.sendKeys("0");
			AddSkill_Button.click();
			String MsgContent = MsgBar.getText();
			//Check if max met	
			if(MsgContent.contains("Skill Added Successfully"))
			{
				c = true;
				a++;
				CloseMsg.click();

			}
			else if(MsgContent.contains("Skill is already added"))
			{
				a++;
				c = true;
				CloseMsg.click();

			}
			else 
			{
				c = false;
				CloseMsg.click();

			}

		}while(c);

		return true;
	}


	//Add Skills and verify the skills are displayed in the main profile page.
	public String getSkillValue() throws InterruptedException
	{
		Thread.sleep(2000);
		Profile.click();
		return SkillText.getText();
	}

	public int takeSkillCount()
	{
		List<WebElement> skill = driver.findElements(By.xpath("//div[@class='row app-skill-display-row-wrapper skill-display-sizing']/div[@class='col-xs-3 no-padding skill-name skill-content']"));
		int Skillcount = skill.size();
		return Skillcount;
	}
	public String getTextOfSkill()
	{
		List<WebElement> skill = driver.findElements(By.xpath("//div[contains(@class,'skill-row-wrapper')]"));
		int Skillcount = skill.size();
		return driver.findElement(By.xpath("//div[contains(@class,'skill-row-wrapper')]["+Skillcount+"]//div/div[contains(@class,'skill-name')]")).getText();

	}
	public int getcountOfSkill()
	{
		List<WebElement> skill = driver.findElements(By.xpath("//div[contains(@class,'skill-row-wrapper')]"));
		int Skillcount = skill.size();
		return Skillcount;

	}
	public int AddSkillAndVerifyProfile() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{ 

		Edit_Button.click();
		int m=1;
		int n=1;
		boolean t;
		String title;
		do
		{

			title = getExceldata(Variables.testdata,Variables.AddSkillsPage,m,n);
			Thread.sleep(2000);
			wait_for_elementpresent(Skills_Title);
			scrollingToTopofAPage();
			Skills_Title.click();
			Skills_Title.sendKeys(title);
			SkillExpYears.sendKeys("0");
			SkillExpMonths.sendKeys("0");
			AddSkill_Button.click();
			String MsgContent = MsgBar.getText();
			if(MsgContent.contains("Skill is already added"))
			{
				m++;
				CloseMsg.click();
				t = true;

			}
			else
			{
				t= false;

			}


		}while(t);
		Thread.sleep(2000);
		Profile.click();
		int cnt = takeSkillCount();
		return cnt;

	}


	//Skill Update 
	public int UpdateSkillAdded() throws InterruptedException
	{

		//Get count of the skill added
		int p = getcountOfSkill();
		System.out.println(" "+p);
		Edit_Button.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//mat-list-item["+(p-1)+"]//mat-icon[@class='skill-icon mat-icon material-icons'][1]")).click();
		Skills_Title.clear();
		Skills_Title.sendKeys("Updated Skill");
		Thread.sleep(2000);
		SkillUpdateIcon.click();
		Thread.sleep(2000);
		Profile.click();
		int finalCount = takeSkillCount();
		return finalCount;
	}


	public int DeleteSkillAndVerifyProfile() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{ 
		int p = getcountOfSkill();
		System.out.println(" "+p);
		Edit_Button.click();
		driver.findElement(By.xpath("//mat-list-item["+(p)+"]//mat-icon[@class='skill-icon mat-icon material-icons'][2]")).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		ProceedDel.click();
		CloseMsg.click();
		Thread.sleep(2000);
		Profile.click();
		int delcnt = takeSkillCount();
		return delcnt;

	}
}
















