package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class ManageResponsesPage extends Action_Method
{
	//Identifying elements present in View Resposes page


	@FindBy(xpath="//a[contains(text(),'Jobs')]")
	WebElement Jobs_Tab;
	
	@FindBy(xpath="//div[contains(text(),'Active Jobs')]")
	WebElement activeJobs;

	@FindBy(xpath="//a[span[contains(text(),'Manage Responses')]]")
	WebElement ManageResponses_tab;
	//	@FindBy(xpath="//mat-card[div[div[div[app-job-card-square-header[div[div[div[contains(text(),'#53')]]]]]]]]//button[@class='pending-review mat-raised-button mat-primary']")



	//	WebElement PendingReview_button_ViewResponsespage;
	//@FindBy(xpath="//div[div[app-candidate-card-square-header[div[div[div[contains(text(),'Siva 1212')]]]]]]/following::button[span[contains(text(),'Shortlist')]]")
	@FindBy(xpath="//button[span[contains(text(),'Shortlist')]]")
	WebElement PendingReviewShortlist;

	@FindBy(xpath="//span[@class='pull-left accent']")
	WebElement PendingReviewBackButton;

	@FindBy(xpath="//span[contains(@class,'app-header ng-star-inserted')]")
	WebElement ShortlistedCandidatePageHeading;

	@FindBy(xpath="//mat-icon[contains(text(),'close')]")
	WebElement closeSideBar;

	public boolean Click_On_ManageResponses_Tab()
	{
		try
		{
			Jobs_Tab.click();
			activeJobs.click();
			//wait_for_elementpresent(ManageResponses_tab);
			//ManageResponses_tab.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Click_On_PendingReview_Button_ViewResponsespage(String JobId)
	{
		//WebElement PendingReview_Button=driver.findElement(By.xpath("(//mat-card[@class='mat-card'])[1]//a[contains(@href,'job/"+JobId+"')]/following::button//div[contains(text(),'Pending Review')]"));
		try
		{
			WebElement PendingReview_Button=driver.findElement(By.xpath("//span[contains(text(),'#"+JobId+"')]/following::button//span[contains(text(),'Pending')]"));
			wait_for_elementpresent(PendingReview_Button);
			PendingReview_Button.click();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	public boolean click_On_PendingReviewShortlist()
	{
		try 
		{
			wait_for_elementpresent(PendingReviewShortlist);
			PendingReviewShortlist.click();
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}

	public String VerifyGOCampaignCreation(String JobId) {
		String CampaignJobRole = driver.findElement(By.xpath("//div/span[contains(text(),'#"+JobId+"')]/ancestor::div/a")).getText();
		driver.findElement(By.xpath("//div/span[contains(text(),'#"+JobId+"')]/following::mat-icon[1]")).click();
		String GOPositions = driver.findElement(By.xpath("//div[contains(text(),'Positions')]/following-sibling::div")).getText();
		//String updated = driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[a[contains(@href,'job/"+JobId+"')]]]]]]]]]//div[contains(@class,'updated-on')]")).getText();
		closeSideBar.click();
		return CampaignJobRole+" - No of Positions - "+GOPositions;
	}

	public boolean clickPendingReviewBackButton() throws InterruptedException {
		PendingReviewBackButton.click();
		Thread.sleep(3000);
		return Jobs_Tab.isDisplayed();
	}

	public String clickonShortlistedofJob(String JobId) throws InterruptedException {
		WebElement shorlist = driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[a[contains(@href,'job/"+JobId+"')]]]]]]]]]//a[contains(text(),'Shortlisted')]"));
		Thread.sleep(3000);
		Actions ac = new Actions(driver);
		ac.moveToElement(shorlist);
		shorlist.click();
		return ShortlistedCandidatePageHeading.getText();
	}


	public String verifyJobClosed(String JobId) {
		return driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[a[contains(@href,'job/"+JobId+"')]]]]]]]]]//button//span[contains(text(),'Reopen')]")).getText();
	}




}

