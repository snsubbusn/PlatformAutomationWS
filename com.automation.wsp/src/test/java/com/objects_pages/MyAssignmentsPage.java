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

}
