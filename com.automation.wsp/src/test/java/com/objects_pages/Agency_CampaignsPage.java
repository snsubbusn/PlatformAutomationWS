package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class Agency_CampaignsPage extends Action_Method
{
	//@FindBy(xpath="//a[span[contains(text(),'Guaranteed Submissions')]]")
	
	@FindBy(xpath="//a//span")
	WebElement NewAssignments;
	
	
//	@FindBy(xpath="//mat-card[div[div[div[app-job-card-square-header[div[div[div[contains(text(),'#13')]]]]]]]]//button[@class='btn-class gs-button mat-raised-button mat-primary']")
//	WebElement Accept_Button;

	@FindBy(xpath="//mat-card[div[div[div[app-job-card-square-header[div[div[div[contains(text(),'#13')]]]]]]]]//button[@class='btn-class gs-button decline mat-raised-button']")
	WebElement Decline_Button;
	
	@FindBy(xpath="//button//i[contains(text(),'close')]")
	WebElement successMsgClose;
	
	public boolean Click_on_Campaigns_Tab()
	{
		try
		{
			if(NewAssignments.getText().contains("New"))
				return true;
			else
				return false;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	public boolean Accept_Job(String JobId)
	{
		//WebElement Accept_Button=driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[contains(text(),'#"+JobId+"')]]]]]]]]//button[@class='btn-class gs-button mat-raised-button mat-primary']"));
		WebElement Accept_Button=driver.findElement(By.xpath("//a[contains(@href,'job/"+JobId+"')]/following::button[2]"));
		
		try
		{
			Accept_Button.click();
			successMsgClose.click();
			return true;
		} 
		catch (Exception e)
		{
			return false;
		}
	}
}
