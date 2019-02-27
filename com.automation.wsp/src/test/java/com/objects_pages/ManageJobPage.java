package com.objects_pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class ManageJobPage extends Action_Method
{
	@FindBy(xpath="//a[contains(text(),'Manage Jobs')]")
	WebElement Manage_Jobs_Tab;
	
	@FindBy(xpath="//span[contains(text(),'Jobs')]")
	WebElement jobs;
	
	@FindBy(xpath="//div[contains(text(),'Active Jobs')]")
	WebElement activeJobs;
	
	@FindBy(xpath="//div[contains(text(),'On Hold Jobs')]")
	WebElement onHoldJobs; 
	 
	@FindBy(xpath="//div[contains(text(),'Closed Jobs')]")
	WebElement closedJobs; 
	
	
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
	
	@FindBy(xpath="//mat-radio-group[@id='skillRating']/descendant::div[contains(text(),'High')]")
	WebElement skillRatingHigh;
	
	@FindBy(xpath="//mat-radio-group[@id='jobChangeRating']/descendant::div[contains(text(),'High')]")
	WebElement jobChangeRatingHigh;
	
	@FindBy(xpath="//mat-radio-group[@id='jobFitmentRating']/descendant::div[contains(text(),'High')]")
	WebElement jobFitmentRatingHigh;
	
	@FindBy(xpath="//mat-radio-button[@ng-reflect-value='Video']/descendant::div[@class='mat-radio-container']")
	WebElement video;
	
	@FindBy(xpath="//mat-radio-button[@ng-reflect-value='Telephone']/descendant::div[@class='mat-radio-container']")
	WebElement telephone;
	
	@FindBy(xpath="//mat-radio-group[@id='candidateCommunicationRating']/descendant::div[contains(text(),'Excellent')]")
	WebElement excellentCommunication;
	
	@FindBy(xpath="//button/span[text()='Submit']")
	WebElement submitInsights;
	
	@FindBy(xpath="//app-pagination/span[@class='pagination-bottom']")
	WebElement paginationBottom;
	
	
	
	
	public boolean clickOnActiveJobs() throws InterruptedException
	{
		try 
		{
			Thread.sleep(1000);
			jobs.click();
			activeJobs.click();
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
	
	public boolean clickOnOnHoldJobs() throws InterruptedException
	{
		try 
		{
			Thread.sleep(1000);
			jobs.click();
			onHoldJobs.click();
			return true;
		} 
		catch (NoSuchElementException e) 
		{
			return false;
		}
		
	}
	
	public boolean clickOnClosedJobs() throws InterruptedException
	{
		try 
		{
			Thread.sleep(1000);
			jobs.click();
			closedJobs.click();
			return true;
		} 
		catch (NoSuchElementException e) 
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
			wait_for_elementpresent_Clickable(skillRatingHigh);
			skillRatingHigh.click();
			jobChangeRatingHigh.click();
			jobFitmentRatingHigh.click();
			video.click();
			excellentCommunication.click();
			submitInsights.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	
	public String getTotalRecordsofthePage() {
		String rec = paginationBottom.getText();
		String [] recd = rec.split(" ");
		return recd[5];
		/*System.out.println(rec);
		String pattern = "(?<=of)([0-9]+)(?=items)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(rec);
		if(m.find()) {
			System.out.println("reg"+m.group(0));
			//System.out.println(m);
			//System.out.println(m.group(2));
		}
		*/		
	}
	
	
	
	
}
