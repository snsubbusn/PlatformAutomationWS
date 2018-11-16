package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class ManageJobPage extends Action_Method
{
	@FindBy(xpath="//a[contains(text(),'Manage Jobs')]")
	WebElement Manage_Jobs_Tab;
	//Identifying Elements present in Job card under manage job page
//	@FindBy(xpath="//mat-card[div[div[div[app-job-card-square-header[div[div[div[contains(text(),'#55')]]]]]]]]//button[@class='assign-cadidates hidden-xs hidden-sm mat-raised-button mat-primary']")
//	WebElement Manage_Button;
	
	//Identifying elements present in Manage section of a particular job
	
	//Identifying elements present in Align Agency Partners page
	@FindBy(xpath="//button[contains(text(),'Align Agency Partners')]")	
	WebElement AlignAgencyPartner_Tab;
	
	@FindBy(xpath="//mat-chip[contains(text(),'Source One')]")	
	WebElement Align_Agency_SourceOne;
	
	//Identifying elements present in Review Submission page
	@FindBy(xpath="//button[contains(text(),'Review Submissions')]")	
	WebElement ReviewSubmission_Tab;
	
//	@FindBy(xpath="//div[div[app-candidate-card-square-header[div[div[div[contains(text(),'Siva 1212')]]]]]]/following::button[span[contains(text(),'Accept')]]")
	@FindBy(xpath="//button[span[contains(text(),'Accept')]]")
	WebElement Accept_ReviewSubmission;
	
	
	public boolean click_on_Manage_Tab()
	{
		try 
		{
			Manage_Jobs_Tab.click();
			return true;
		} 
		catch (NoSuchElementException e) 
		{
			return false;
		}
		
	}
	public boolean Click_Mangae_Job(String JobId)
	{
		//WebElement Manage_Button=driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[contains(text(),'#"+JobId+"')]]]]]]]]//button[@class='assign-cadidates hidden-xs hidden-sm mat-raised-button mat-primary']"));
		
		WebElement Manage_Button=driver.findElement(By.xpath("//span[contains(text(),'#"+JobId+"')]/following::button[2]"));
		
		try 
		{
			wait_for_elementpresent(Manage_Button);
			Manage_Button.click();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	public boolean Click_On_AlignAgency_Tab()
	{
		try 
		{
			AlignAgencyPartner_Tab.click();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}
	public boolean Align_An_Agency()
	{
		try 
		{
			wait_for_elementpresent(Align_Agency_SourceOne);
			Align_Agency_SourceOne.click();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	public boolean Click_On_ReviewSubmissionTab()
	{
		try 
		{
			ReviewSubmission_Tab.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public boolean Accept_Candidate_ReviewSubmission()
	{
		try
		{
			Accept_ReviewSubmission.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	
	
	
	
}
