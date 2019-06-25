package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	
	@FindBy(xpath="(//div[@class='parent-div ng-star-inserted']//div/a)[1]")
	WebElement FirstJobcardtitle;
	
	@FindBy(xpath="//a/img[@class='profile-border']")
	WebElement CorpWeblink;
	
	@FindBy(xpath="//button[@title='Play Video']")
	WebElement JobVideo;
	
	@FindBy(xpath="//div[contains(text(),'Experience') and @class='title']")
	WebElement JobExperience;
	
	@FindBy(xpath="//div[contains(text(),'Education')]")
	WebElement JobEducation;
	
	@FindBy(xpath="//div[contains(text(),'Location')]")
	WebElement JobLocation;
	
	@FindBy(xpath="//div[contains(text(),'Salary')]")
	WebElement JobSalary;
	
	@FindBy(xpath="//div/h4[contains(text(),'Description')]")
	WebElement Jobdescription;
	
	@FindBy(xpath="//span[contains(text(),'About Us')]")
	WebElement JobInfo;
	
	@FindBy(xpath="//div/div[contains(text(),'Must have skills')]")
	WebElement Jobmusthaveskills;
	
	@FindBy(xpath="//div[contains(text(),'Good To have skills')]")
	WebElement Jobgoodtohaveskills;
	
	@FindBy(xpath="//span[@class='pagination-bottom']")
	WebElement PaginationBottom;

	@FindBy(xpath="//li[@class='active ng-star-inserted']/a[@class='page-num']")
	WebElement Paginationlastarrow;

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
	
	@FindBy(xpath="//li[@class='active ng-star-inserted']/a[@class='page-num']")
	WebElement totalPages;

	@FindBy(xpath="//li/a[text()=2]")
	WebElement Page2;
	
	@FindBy(xpath="//li/a[text()=1]")
	WebElement Page1;
	
	@FindBy(xpath="//span[contains(text(),'No Engagements')]")
	WebElement NoEngagements;
	
	@FindBy(xpath="//div[@class=\"pull-left arroy ng-star-inserted\"]")
	WebElement Jobbackbutton;
	
	@FindBy(xpath="//div[@class=\"pull-left arroy ng-star-inserted\"]")
	WebElement Corpbackbutton;

	@FindBy(xpath="//li/a[@title='Go to next page']")
	WebElement NextPage;
	
	@FindBy(xpath="//li/a[@class='page-num']")
	WebElement Pagenum;

	@FindBy(xpath="//li/a[@title='Go to last page']")
	WebElement LastPage;
	
	@FindBy(xpath="//li[@class='disabled ng-star-inserted']/span[@title='Go to next page']")
	WebElement DisabledNextPage;

	@FindBy(xpath="//app-pagination/span[@class='pagination-bottom']")
	WebElement Pagination;
	
	//WebElement LastPageNumber = driver.findElement(By.xpath("//*[@text='>>]/preceding::/span[1]")); 


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

	public boolean VerifyJobCards()
	{
		try {
			NoEngagements.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
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

	public boolean CorporateWebsitePage()
	{
		try {
			CorpWeblink.click();
			Child_Window_Handling();
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
	
	public boolean EnabledLastPage()
	{
		try {
			LastPage.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean VerifyJobpage()
	{
		try {
			FirstJobcardtitle.click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean VerifyJobvideo()
	{
		   JobVideo.isEnabled();
		   return true;
	}
	
	public boolean VerifyJobdetails()
	{
		JobExperience.isDisplayed();
		JobEducation.isDisplayed();
		JobLocation.isDisplayed();
		JobSalary.isDisplayed();
		JobInfo.isDisplayed();
		return true;
	}	 
	public boolean VerifyJobDescription()
	{ 	
		try {
			 Jobdescription.isDisplayed();
			 return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}	 	 
	public boolean VerifyJobmustskills()
	{
		try {
		   Jobmusthaveskills.isDisplayed();
		   return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}	 	 
	public boolean VerifyJobgoodskills()
	{
		try {
			Jobgoodtohaveskills.click();
			Jobgoodtohaveskills.isDisplayed();
		  return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}	 	 	 
	public boolean Verifybackbutton()
	{
		
		   Jobbackbutton.click();
		   return true;
	}	 	 
		
	public boolean VerifyCorpbackbutton()
	{
		
		   Corpbackbutton.click();
		   return true;
	}
	
	public boolean VerifyJdDisplayed()
	{
		JobVideo.isDisplayed();
		return true;
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
		//DefaultItemValue.click();(items per page and pagination scripts make separate functions)
		String rec = PaginationBottom.getText();
		String [] recd = rec.split(" ");
		return recd[3];
	}
	
	public boolean goToLastpage() {
		try{
			LastPage.click();
			return LastPage.isEnabled();
		}catch(Exception e) {
			return false;
		}
	}
	
	public Boolean select36ItemsPerPage() {
		myEngagementsTab.sendKeys(Keys.ESCAPE);
		ItemsPerPage.click();
		Items36perpage.click();
		return true;

	}

	public String getTotalRecordsofthePage() {
		String rec = PaginationBottom.getText();
		String [] recd = rec.split(" ");
		return recd[5];
	}
	
	public boolean clickOnPage1() {
		Page1.click();
		return true;
	}
	
	public boolean clickOnPage2() {
		try {
			Page2.click();	
			return true;
			}catch(Exception e) {
				return false;
			}
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
			//LastPage.click();
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

	public boolean clickOnPreviousPage() {
		try{
			PreviousPage.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}



}
