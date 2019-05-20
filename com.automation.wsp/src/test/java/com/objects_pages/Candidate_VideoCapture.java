package com.objects_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;
import com.controller.Variables;

public class Candidate_VideoCapture extends Action_Method{
	
	@FindBy(xpath="//div[@class='name-wrapper']//span/mat-icon[text()='mode_edit']")
	WebElement EditButton;
	
	@FindBy(xpath= "//div[text() ='Profile Information']")
	WebElement ProfileInformation_Page;      
	 
	@FindBy(xpath="//div//button[text()='Next']")
	WebElement ProfileNextButton;
	
	@FindBy(xpath="//a/span[text()='Re-take']")
	WebElement ReTake;
	
	@FindBy(xpath="//a/img[@src='assets/Record.png']")
	WebElement Upload_Video;
	
	@FindBy(xpath="//span/span[text()='Next']")
	WebElement VideoNextButton;
	
	@FindBy(xpath="//span/span[text()='Next']")
	WebElement EducationNextButton;
	
	@FindBy(xpath="//span/span[text()='Finish']")
	WebElement WorkExpFinishButton;
	
	@FindBy(xpath="//div/div[text()='Next' and @class='btn btn-red btn-big transition-opacity']")
	WebElement Video_Next;
	
	@FindBy(xpath="//div//button[text()='Start Recording']")
	WebElement StartRecording;
	
	@FindBy(xpath="//div//button[text()='Stop Recording']")
	WebElement StopRecording;
	
	@FindBy(xpath="//div/div[text()='Next' and @class='btn btn-big btn-short btn-red iblock-text']")
	WebElement PersonalVideoNext;
	
	@FindBy(xpath="//div//div[text()='Retake ?']")
	WebElement VideoRetake;
	
	@FindBy(xpath="//div//div[text()='Finish' and @class='btn btn-big btn-short btn-red iblock-text']")
	WebElement VideoFinish;
	
	@FindBy(xpath="//div//div[text()='Finish' and @class='btn btn-big btn-short btn-red iblock-text validateRecording']")
	WebElement CompleteVideoFinish;
	
	@FindBy(xpath="//div[@class='section-video']//div//div/iframe['https://embed.myinterview.com/player.v2.html?apiKey=cuzmJPer0tz0nD4k7Sru&video=8b5e1830-032e-4e17-a738-17af28ebc0ef']")
	WebElement CandidateProfileVideo;
	
	public boolean ClickOn_EditButton()
	{
		try
		{
			EditButton.click();
			return true;
		}
		catch(Exception e)
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
	
	public boolean ClickOn_ProfileNextButton()
	{
		try
		{
			ProfileNextButton.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public boolean Verify_UploadVideoPage()
	{
		try
		{
			Upload_Video.click();
			Video_Next.click();
			StartRecording.click();
			driver.manage().timeouts().implicitlyWait(Variables.time,TimeUnit.SECONDS);
			StopRecording.click();
			PersonalVideoNext.click();
			StartRecording.click();
			driver.manage().timeouts().implicitlyWait(Variables.time,TimeUnit.SECONDS);
			StopRecording.click();
			VideoRetake.click();
			PersonalVideoNext.click();
			StartRecording.click();
			driver.manage().timeouts().implicitlyWait(Variables.time,TimeUnit.SECONDS);
			StopRecording.click();
			VideoFinish.click();
			CompleteVideoFinish.click();
			VideoNextButton.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public String Verify_RetakeVideoProfilePage()
	{
		try
		{
			ReTake.click();
			Video_Next.click();
			StartRecording.click();
			driver.manage().timeouts().implicitlyWait(Variables.time,TimeUnit.SECONDS);
			StopRecording.click();
			PersonalVideoNext.click();
			StartRecording.click();
			driver.manage().timeouts().implicitlyWait(Variables.time,TimeUnit.SECONDS);
			StopRecording.click();
			VideoRetake.click();
			PersonalVideoNext.click();
			StartRecording.click();
			driver.manage().timeouts().implicitlyWait(Variables.time,TimeUnit.SECONDS);
			StopRecording.click();
			VideoFinish.click();
			CompleteVideoFinish.click();
			VideoNextButton.click();
			return "true";
		
		}
		catch(Exception e)
		{
		return "NoError";
		}
	}
	
	/*public boolean ClickOn_VideoNextButton()
	{
		try
		{
			VideoNextButton.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}*/
	
	public boolean ClickOn_EducationNextButton()
	{
		try
		{
			EducationNextButton.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean ClickOn_WorkExpFinishButton()
	{
		try
		{
			WorkExpFinishButton.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean Verify_CandidateProfileVideo()
	{
		try
		{
			CandidateProfileVideo.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
}
