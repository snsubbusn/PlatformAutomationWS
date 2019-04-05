package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;
import com.controller.Variables;

public class MyAssignmentsPage extends Action_Method
{
	@FindBy(xpath="//a//span")
	WebElement NewAssignmentsTab;

	@FindBy(xpath="//div[contains(text(),'Active Assignments')]")
	WebElement activeAssignments;

	@FindBy(xpath="//div[contains(text(),'On Hold Assignments')]")
	WebElement onHoldAssignments;

	@FindBy(xpath="//div[contains(text(),'Closed Assignments')]")
	WebElement closedAssignments;

	//	@FindBy(xpath="//mat-card[div[div[div[app-job-card-square-header[div[div[div[contains(text(),'#46')]]]]]]]]//button[@class='assign-cadidates hidden-xs hidden-sm mat-raised-button mat-primary']")
	//	WebElement Assign_Candidate;

	//Identifying elements present in tag existing page

	@FindBy(xpath="//button[contains(text(),'Tag Existing')]")
	WebElement TagExisting_Tab;

	@FindBy(xpath="//button[@class='mat-raised-button button button-border-radius mat-primary']")
	WebElement selectedTab;


	@FindBy(id="search")
	WebElement TagExisting_Search;

	//@FindBy(xpath="//div[div[app-candidate-card-square-header[div[div[div[contains(text(),'Siva 1212')]]]]]]/following::a[span[contains(text(),'Tag')]]")

	//Tagging the first candidate
	@FindBy(xpath="//a[span[contains(text(),'Tag')]]")
	WebElement Tag_Button_TagExisting;

	@FindBy(xpath="//div[contains(text(), 'Salary')]/preceding-sibling::div")
	WebElement salaryHikeReasonRadioBtn;

	@FindBy(xpath="//button//span[contains(text(), 'Done')]")
	WebElement doneButton;

	@FindBy(id="email")
	WebElement Email;


	@FindBy(xpath="//div[text()='Items Per Page']/following::mat-select")
	WebElement selectedItemsPerPage;

	@FindBy(xpath="//a[@title='Go to next page']")
	WebElement paginationNext;

	@FindBy(xpath="(//mat-card//a)[1]")
	WebElement firstJobCardJobTitle;

	@FindBy(xpath="(//mat-card//span)[1]")
	WebElement firstJobCardCompanyName;

	@FindBy(xpath="(//mat-card//span)[2]")
	WebElement firstJobCardJobId;

	@FindBy(xpath="//div[contains(@class,'pull-left')]")
	WebElement jobDetailBackButton;



	//Assign Candidate - My Assignments Page Elements
	@FindBy(xpath="//span[text()='My Assignments']")
	WebElement myAssignmentsHeading;

	@FindBy(xpath="//a[@class='ng-star-inserted']/span[1]")
	WebElement jobTitle;

	@FindBy(xpath="//a[@class='ng-star-inserted']/span[2]")
	WebElement companyName;

	@FindBy(xpath="//button[text()='Invite New']")
	WebElement inviteNewTab;

	@FindBy(xpath="//button[text()='Invited']")
	WebElement invitedTab;

	@FindBy(xpath="//button[text()='Tagged']")
	WebElement taggedTab;


	//TagExisting Elements

	@FindBy(id="jobImage")
	WebElement searchTalentImage;

	@FindBy(id="name")
	WebElement name;

	@FindBy(id="email")
	WebElement email;

	@FindBy(id="phone_no")
	WebElement phoneNo;

	@FindBy(id="skills")
	WebElement skills;

	@FindBy(id="minExp")
	WebElement minExp;

	@FindBy(id="maxExp")
	WebElement maxExp;


	@FindBy(xpath="//button[@id='reset']/span")
	WebElement clearAllFiltersButton;

	@FindBy(id="search")
	WebElement searchButton;

	@FindBy(xpath="//mat-error/div[contains(text(),'email')]")
	WebElement emailError;

	@FindBy(xpath="//mat-error/div[contains(text(),'phone')]")
	WebElement phoneError;
	
	@FindBy(xpath="//div/label[contains(text(),'Found')]")
	WebElement foundResults;
	
	@FindBy(xpath="(//span[@mattooltip='Candidate Name'])[1]")
	WebElement firstSearchResult;
	
	@FindBy(xpath="//div[text()='Email']/following-sibling::div[2]")
	WebElement emailOfCandidate;

	@FindBy(xpath="//span[contains(@class,'pull-left')]")
	WebElement backButtonofCandidateProfileFromSearchResult;

	@FindBy(xpath="//mat-option[1]")
	WebElement firstDropDownValue;
	
	@FindBy(xpath="(//button//i[contains(text(),'close')])[1]")
	WebElement successMsgClose;

	public boolean click_On_ActiveAssignmentTab()
	{
		try 
		{
			NewAssignmentsTab.click();
			activeAssignments.click();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}

	public boolean click_On_OnHoldAssignment()
	{
		try 
		{
			NewAssignmentsTab.click();
			onHoldAssignments.click();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}


	public boolean click_On_ClosedAssignment()
	{
		try 
		{
			NewAssignmentsTab.click();
			closedAssignments.click();
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
		try 
		{
			//driver.findElement(By.xpath("//button//i[contains(text(),'close')]")).click();
			//Thread.sleep(3000);
			WebElement Assign_Candidate=driver.findElement(By.xpath("//span[contains(text(),'#"+JobId+"')]/following::button[2]"));

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
	public boolean GO_Search_Candidate_TagExisting()
	{
		try 
		{
			//Email.sendKeys(getExceldata(Variables.testdata,Variables.LoginPage,"Candidate Email"));
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
			Tag_Button_TagExisting.click();
			salaryHikeReasonRadioBtn.click();
			doneButton.click();
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
	}


	public String findJobCardMatchesAcdeptedJobCard(String jobId) {
		String page = driver.findElement(By.tagName("app-pagination")).getAttribute("ng-reflect-size");
		String item = selectedItemsPerPage.getAttribute("ng-reflect-model");
		for(int k=1; k<=Integer.parseInt(page); k++) {
			for(int i=1; i<=Integer.parseInt(item); i++) {
				if(driver.findElement(By.xpath("(//mat-card//div[@class='job-description']/span[2])["+i+"]")).getText().equals(jobId)) {
					String title = driver.findElement(By.xpath("(//mat-card//a)["+i+"]")).getText();
					String companyName = driver.findElement(By.xpath("(//mat-card//div[@class='job-description']/span[1])["+i+"]")).getText();
					String JobId = driver.findElement(By.xpath("(//mat-card//div[@class='job-description']/span[2])["+i+"]")).getText();
					return title+"; "+companyName+"; "+JobId;
				}
			}
			paginationNext.click();
		}

		return "Job Not Matched";
	}

	public String getFirstJobCardDetails() {
		return firstJobCardJobTitle.getText()+"; "+firstJobCardCompanyName.getText()+"; "+firstJobCardJobId.getText();
	}

	public boolean clickOnFirstJobDetail() {
		try {
			firstJobCardJobTitle.click();
			return jobDetailBackButton.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	public boolean clickOnBackButtonfromJobDetail() {
		try {
			jobDetailBackButton.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public String verifyNavigatedtoMyAssignmentsPage() {
		return myAssignmentsHeading.getText();
	}

	public String getJobDetailsinMyAssignmentsPage() {
		return jobTitle.getText()+"; Company Name- "+companyName.getText()+"; \n Tab Details are - "+inviteNewTab.getText()+"; "+invitedTab.getText()+"; "+TagExisting_Tab.getText()+"; "+taggedTab.getText();
	}

	public boolean clickOnInviteNewTab() {
		try {
			inviteNewTab.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean clickOnInvitedTab() {
		try {
			invitedTab.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	public String getSelectedTabDetails() {
		return selectedTab.getText();
	}


	public boolean verifySearchTalentImageIsDisplayed() {
		try {
			return searchTalentImage.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}


	public String verifyAllSearchCriteriaIsDisplayed() {
		String de = "Either Name, Email, Phone No, Skills, Min Exp, Max Exp fields is/are missing";
		try {
			if(name.isDisplayed()&&email.isDisplayed()&&phoneNo.isDisplayed()
					&&skills.isDisplayed()&&minExp.isDisplayed()&&maxExp.isDisplayed()) {
				return "Name, Email, Phone No, Skills, Min Exp and Max Exp are the search options displayed";
			}else {
				return de;
			}
		}catch(Exception e) {
			return de;
		}

	}

	public String validateEmailSearchField() {
		try{
			email.sendKeys("random");
			name.click();
			return emailError.getText();
		}catch(Exception e) {
			return "No Error";
		}
	}

	public String validatePhoneNoSearchField() {
		try{
			phoneNo.sendKeys("1234");
			name.click();
			return phoneError.getText();
		}catch(Exception e) {
			return "No Error";
		}
	}
	
	public void clickOnClearAllFilterButton() {
		clearAllFiltersButton.click();
	}
	
	public String verifyEmailError() {
		try{
			return emailError.getText();
		}catch(Exception e) {
			return "No Error";
		}
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
		
	public String getResultsDetails() {
		try{
			return foundResults.getText();
		}catch(Exception e) {
			return "Error";
		}
	}
	
	public void searchForNameFilter() {
		name.sendKeys("e");
	}
	
	public boolean clickOnFirstCandidateSearchResult() {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(firstSearchResult).build().perform();
			
			firstSearchResult.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public String getEmailOfCandidate() {
		return emailOfCandidate.getText();
	}
	
	public boolean clickBackButtonofCandidateProfile() {
		try {
			backButtonofCandidateProfileFromSearchResult.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public void searchForEmailFilter(String Email) {
		email.sendKeys(Email);
	}
	
	public void searchForSkillsFilter() {
		skills.sendKeys("Java");
		firstDropDownValue.click();
	}
	
	public void searchForExperienceFilter() {
		minExp.sendKeys("2");
		maxExp.sendKeys("10");
	}
	
	
	public void clickOnTaggedTab() throws InterruptedException {
		//successMsgClose.click();
		Actions act = new Actions(driver);
		act.moveToElement(taggedTab).build().perform();
		//Thread.sleep(6000);
		taggedTab.click();
	}
	
}
