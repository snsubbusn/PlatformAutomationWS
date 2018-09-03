package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class ManageResponsesPage extends Action_Method
{
	//Identifying elements present in View Resposes page

	@FindBy(xpath="//a[contains(text(),'Work Desk')]")
	WebElement WorkDesk_Tab;

	@FindBy(xpath="//a[span[contains(text(),'Manage Responses')]]")
	WebElement ManageResponses_tab;
	//	@FindBy(xpath="//mat-card[div[div[div[app-job-card-square-header[div[div[div[contains(text(),'#53')]]]]]]]]//button[@class='pending-review mat-raised-button mat-primary']")
	
	
	
	//	WebElement PendingReview_button_ViewResponsespage;
	//@FindBy(xpath="//div[div[app-candidate-card-square-header[div[div[div[contains(text(),'Siva 1212')]]]]]]/following::button[span[contains(text(),'Shortlist')]]")
	@FindBy(xpath="//button[span[contains(text(),'Shortlist')]]")
	WebElement Shortlist_Viewresponses;

	public boolean Click_On_ManageResponses_Tab()
	{
		try
		{
			WorkDesk_Tab.click();
			wait_for_elementpresent(ManageResponses_tab);
			ManageResponses_tab.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Click_On_PendingReview_Button_ViewResponsespage(String JobId)
	{
		WebElement PendingReview_Button=driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[a[contains(@href,'job/"+JobId+"')]]]]]]]]]//button"));
		//WebElement PendingReview_Button=driver.findElement(By.xpath("(//mat-card[@class='mat-card'])[1]//a[contains(@href,'job/"+JobId+"')]/following::button//div[contains(text(),'Pending Review')]"));
		try
		{
			wait_for_elementpresent(PendingReview_Button);
			PendingReview_Button.click();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	public boolean Click_On_Shortlist_ViewResponses()
	{
		try 
		{
			wait_for_elementpresent(Shortlist_Viewresponses);
			Shortlist_Viewresponses.click();
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

}
