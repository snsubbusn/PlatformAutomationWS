package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class Candidate_MyEngagementsPage extends Action_Method{


	@FindBy(xpath="//a[contains(text(),'My Engagements')]")
	WebElement myEngagementsTab;

	@FindBy(xpath="//button/span[contains(text(),'Accept')]")
	WebElement acceptButton;

	@FindBy(xpath="//div/a[@class='mat-tab-link mat-tab-label-active ng-star-inserted']")
	WebElement CandidateProfileTab;

	@FindBy(xpath="//div/button[@class='engagements-btn mat-flat-button mat-primary']")
	WebElement CandidateJobTagged;

	@FindBy(xpath="//span[@class='pagination-bottom']")
	WebElement PaginationBottom;

	@FindBy(xpath="//li/a[@class='page-num']")
	WebElement PageNum;

	@FindBy(xpath="//div[@class='mat-select-arrow-wrapper']")
	WebElement ItemsPerPage;

	@FindBy(xpath="//span[@class='mat-option-text' and text()=12]")
	WebElement SelectItem;

	@FindBy(xpath="//span[@class='mat-option-text' and text()=36]")
	WebElement Items36perpage;

	@FindBy(xpath="//span[@class='mat-option-text' and text()=12]")
	WebElement DefaultItemValue;

	@FindBy(xpath="//li/a[@class='arrow'  and @title='Go to first page']")
	WebElement FirstPage;

	@FindBy(xpath="//li/a[@class='arrow'  and @title='Go to previous page']")
	WebElement PreviousPage;

	@FindBy(xpath="//li/a[text()=2]")
	WebElement Page2;

	@FindBy(xpath="//li/a[@title='Go to next page']")
	WebElement NextPage;

	@FindBy(xpath="//li/a[@title='Go to last page']")
	WebElement LastPage;

	@FindBy(xpath="//app-pagination/span[@class='pagination-bottom']")
	WebElement Pagination;




	public void clickonMyEngagements() {
		myEngagementsTab.click();
	}

	public String checkStatusofJob(String JobId) {
		return driver.findElement(By.xpath("(//mat-card[div[div[div[app-job-card-square-header[div[div[div[div[span[contains(text(),'"+JobId+"')]]]]]]]]]]//button)[2]/span")).getText();

	}

	public String acceptSchedeuledInterview(String JobId) throws InterruptedException {
		driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[div[span[contains(text(),'"+JobId+"')]]]]]]]]]]//button[span[contains(text(),'Interview')]]")).click();
		acceptButton.click();
		Thread.sleep(2000);
		return driver.findElement(By.xpath("(//mat-card[div[div[div[app-job-card-square-header[div[div[div[div[span[contains(text(),'"+JobId+"')]]]]]]]]]]//button)[2]/span")).getText();

	}


	public String acceptOfferandJoin(String JobId) throws InterruptedException {
		driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[div[span[contains(text(),'"+JobId+"')]]]]]]]]]]//button[span[contains(text(),'Offer')]]")).click();
		Thread.sleep(1000);
		acceptButton.click();
		Thread.sleep(1000);
		return driver.findElement(By.xpath("(//mat-card[div[div[div[app-job-card-square-header[div[div[div[div[span[contains(text(),'"+JobId+"')]]]]]]]]]]//button)[2]/span")).getText();
	}


	public boolean VerifyCandidateLogin()
	{
		if(CandidateProfileTab.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}


	public boolean ClickOn_MyEngagementsTab()
	{
		try {
			myEngagementsTab.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public String VerifyMyEngagementsPage()
	{
		return myEngagementsTab.getText();
	}


	public boolean ClickOn_ItemsPerPage()
	{
		try {
			ItemsPerPage.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean VerifyJobsTagged()
	{
		try {
			return CandidateJobTagged.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean Verify_Pagination()
	{
		try {
			Pagination.isDisplayed();

			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean Select_Item()
	{
		try {
			SelectItem.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public String getDefaultItemsPerPage()
	{

		DefaultItemValue.click();
		String rec = PaginationBottom.getText();
		String [] recd = rec.split(" ");
		return recd[3];

	}



	public Boolean select36ItemsPerPage() {
		ItemsPerPage.click();
		Items36perpage.click();
		return true;

	}

	public String getTotalRecordsofthePage() {
		String rec = PaginationBottom.getText();
		String [] recd = rec.split(" ");
		return recd[5];
	}

	public String getTotalNoOfthePage() {
		String rec = PageNum.getText();
		String [] recd = rec.split(" ");
		return recd[1];
	}

	public void clickOnPage2() {
		Page2.click();		
	}

	public boolean verifyNextPageEnabled() {
		try {
			return NextPage.isEnabled();
		}catch(Exception e) {
			return false;
		}
	}

	public boolean verifyLastPageEnabled() {
		try{
			return LastPage.isEnabled();
		}catch(Exception e) {
			return false;
		}
	}

	public boolean verifyPreviousPageEnabled() {
		try{
			return PreviousPage.isEnabled();
		}catch(Exception e) {
			return false;
		}
	}

	public boolean verifyFirstPageEnabled() {
		try{
			return FirstPage.isEnabled();
		}catch(Exception e) {
			return false;
		}
	}

	public void clickOnPreviousPage() {
		PreviousPage.click();
	}



}
