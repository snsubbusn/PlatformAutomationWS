package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class MyAssignmentsPage extends Action_Method
{
	@FindBy(xpath="//a[span[contains(text(),'My Assignments')]]")
	WebElement MyAssignment_Tab;
	
//	@FindBy(xpath="//mat-card[div[div[div[app-job-card-square-header[div[div[div[contains(text(),'#46')]]]]]]]]//button[@class='assign-cadidates hidden-xs hidden-sm mat-raised-button mat-primary']")
//	WebElement Assign_Candidate;
	
	//Identifying elements present in tag existing page
	
	@FindBy(xpath="//button[contains(text(),'Tag Existing')]")
	WebElement TagExisting_Tab;
	@FindBy(id="search")
	WebElement TagExisting_Search;
	
	//@FindBy(xpath="//div[div[app-candidate-card-square-header[div[div[div[contains(text(),'Siva 1212')]]]]]]/following::a[span[contains(text(),'Tag')]]")
	
	//Tagging the first candidate
	@FindBy(xpath="//a[span[contains(text(),'Tag')]]")
	WebElement Tag_Button_TagRxisting;
	
	
	public boolean Click_On_MyAssignmentTab()
	{
		try 
		{
			MyAssignment_Tab.click();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	
	public boolean Click_Assign_Candidate(String JobId)
	{
		//WebElement Assign_Candidate=driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[contains(text(),'#"+jobid+"')]]]]]]]]//button[@class='assign-cadidates hidden-xs hidden-sm mat-raised-button mat-primary']"));
		WebElement Assign_Candidate=driver.findElement(By.xpath("//a[contains(@href,'job/"+JobId+"')]/following::button//div[contains(text(),'Assign Candidate')]"));
		try 
		{
			Assign_Candidate.click();
			return true;
		} catch (Exception e) 
		{
			return false;
		}
	}
	public boolean Click_on_TagExistingTab()
	{
		try 
		{
			Actions act = new Actions(driver);
			act.moveToElement(TagExisting_Tab).build().perform();
			TagExisting_Tab.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public boolean Search_Candidate_TagExisting()
	{
		try 
		{
			Actions act = new Actions(driver);
			act.moveToElement(TagExisting_Search).build().perform();
			TagExisting_Search.click();
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}
	public boolean Tag_Candidate()
	{
		try
		{
			//Tagging the first candidate
			Tag_Button_TagRxisting.click();
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}
	
	

}
