package com.objects_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.relevantcodes.extentreports.LogStatus;

public class CandidateProfilePage extends Action_Method
{

	//Elements of Candidate Profile View Page
	@FindBy(xpath="//section/div[@class= \"heading\"]")
	WebElement Profile_Headline;

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
	
	@FindBy(xpath="//iframe[contains(@src,'myinterview')]")
	WebElement videoFrame;
	
	@FindBy(xpath="//div/img[@class='profile-video-banner']")
	WebElement gifImage;
	
	@FindBy(xpath="//div/app-video-display")
	WebElement uploadedvideo;
	
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
			 Education.isDisplayed();
			 return true;
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
	
	public boolean Education_Next()
	{
		try
		{
			//wait_for_elementpresent_Clickable(Education_Next);
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
	
}




