package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class ManageResponsesPage extends Action_Method
{
	//Identifying elements present in View Resposes page


	@FindBy(xpath="//a//span[contains(text(),'Jobs')]")
	WebElement Jobs_Tab;

	@FindBy(xpath="//div[contains(text(),'Active Jobs')]")
	WebElement activeJobs;

	@FindBy(xpath="//div[contains(text(),'Closed Jobs')]")
	WebElement closedJobs;

	@FindBy(xpath="//div[contains(text(),'On Hold Jobs')]")
	WebElement onHoldJobs;

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


	//Pagination
	@FindBy(xpath="//app-pagination/span[@class='pagination-bottom']")
	WebElement paginationBottom;
	
	@FindBy(xpath="//app-pagination")
	WebElement pagination;
	
	@FindBy(xpath="//span[contains(text(),'9')]/ancestor::div[@class='mat-select-trigger']")
	WebElement itemsPerPageDropDowm;

	@FindBy(xpath="//div[text()='Items Per Page']/following::mat-select")
	WebElement selectedItemsPerPage;

	@FindBy(xpath="//div[contains(@class,'mat-select-content')]//span[contains(text(),'60')]")
	WebElement items60PerPage;

	@FindBy(xpath="//a[@title='Go to next page']")
	WebElement paginationNext;


	@FindBy(xpath="//button//i[contains(text(),'close')]")
	WebElement successMsgClose;

	//Elements of ActiveJobs page

	@FindBy(xpath="(//div[@class='job-description']//span[2])[1]")
	WebElement jobIdFirstCard;
	
	
	@FindBy(xpath="(//div[@class='job-description']//span[2])[2]")
	WebElement jobIdSecondCard;

	@FindBy(xpath="//button/span[text()='Yes']")
	WebElement confirmYesBtn;

	@FindBy(xpath="//div[@class='message-holder']")
	WebElement successMsgDetails;


	//Elements of Closed Jobs
	
	@FindBy(id="1")
	WebElement closeReason1;
	
	@FindBy(id="undefined")
	WebElement submitButton;
	
	public boolean Click_On_ActiveJobs()
	{
		try
		{
			Jobs_Tab.click();
			activeJobs.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Click_On_OnHoldJobs()
	{
		try
		{
			Jobs_Tab.click();
			onHoldJobs.click();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean Click_On_closedJobs()
	{
		try
		{
			Jobs_Tab.click();
			closedJobs.click();
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
		WebElement shorlist = driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[div[span[contains(text(),'"+JobId+"')]]]]]]]]]]//a[contains(text(),'Shortlisted')]"));
		Thread.sleep(3000);
		Actions ac = new Actions(driver);
		ac.moveToElement(shorlist);
		shorlist.click();
		return ShortlistedCandidatePageHeading.getText();
	}


	public String verifyJobClosed(String JobId) {
		Jobs_Tab.click();
		closedJobs.click();
		return driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[div[span[contains(text(),'#"+JobId+"')]]]]]]]]]]//button//span[contains(text(),'Replicate')]")).getText();
	}

	public String getSecondJobId() {
		try{
			return jobIdSecondCard.getText();
		}catch(Exception e) {
			return "NoJob";
		}
	}
	
	public String getFirstJobId() {
		try{
			return jobIdFirstCard.getText();
		}catch(Exception e) {
			return "NoJob"+e.toString();
		}
	}

	public String clickOnOnHoldandVerifySuccessMsg(String jobId) {
		try{
			driver.findElement(By.xpath("//div//span[contains(text(),'"+jobId+"')]/following::button[2]")).click();
			wait_for_elementpresent(confirmYesBtn);
			confirmYesBtn.click();
			return successMsgDetails.getText();
		}catch(Exception e) {
			return e.toString();
		}

	}
	
	public String clickOnResumeandVerifySuccessMsg(String jobId) {
		try{
			driver.findElement(By.xpath("//div//span[contains(text(),'"+jobId+"')]/following::button[3]")).click();
			return successMsgDetails.getText();
		}catch(Exception e) {
			return e.toString();
		}

	}
	
	public String clickOnCloseandVerifySuccessMsg(String jobId) {
		try{
			driver.findElement(By.xpath("//div//span[contains(text(),'"+jobId+"')]/following::button[2]")).click();
			closeReason1.click();
			submitButton.click();
			wait_for_elementpresent(confirmYesBtn);
			confirmYesBtn.click();
			return successMsgDetails.getText();
		}catch(Exception e) {
			return e.toString();
		}

	}
	
	public boolean verifyJobisPresent(String jobId) {
		try {
			return driver.findElement(By.xpath("//div//span[contains(text(),'"+jobId+"')]")).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	
	public String findJobIdofFirstGSorGO(String gsgo) {
		int pageSize = Integer.parseInt(pagination.getAttribute("ng-reflect-size"));
		for(int i=0; i<=pageSize; i++) {
			for(int j =1; j<=12; j++) {
				String src = driver.findElement(By.xpath("(//div[@class='icon-container']//button/following::img[1])["+j+"]")).getAttribute("src");
				if(src.contains(gsgo)) {
					return driver.findElement(By.xpath("(//div[@class='job-description']//span[2])["+j+"]")).getText();
				}
			}
			paginationNext.click();
		}
		return "NoJob";
	}
	
	
	public boolean clickOnRestartGSorGOCampaign(String Job_Id)
	{
		try
		{
			WebElement arrow =driver.findElement((By.xpath(("(//span[contains(text(),'"+Job_Id+"')]/following::span/mat-icon[contains(text(),'keyboard_arrow_down')])[1]"))));
			arrow.click();
			WebElement Restart=driver.findElement((By.xpath(("(//span[contains(text(),'"+Job_Id+"')]/following::button/span[contains(text(),'Restart')])[1]"))));
			Restart.click();
			return true;
		}
		catch (NoSuchElementException e) 
		{
			return false;
		}
	}
	
	
	public String clickOnReplicateofCampaign(String Job_Id)
	{
		try
		{
			WebElement Replicate=driver.findElement((By.xpath(("(//span[contains(text(),'"+Job_Id+"')]/following::button//span[contains(text(),'Replicate')])[1]"))));
			Replicate.click();
			return successMsgDetails.getText();
		}
		catch (NoSuchElementException e) 
		{
			return "Failed"+e.toString();
		}
	}
	
}

