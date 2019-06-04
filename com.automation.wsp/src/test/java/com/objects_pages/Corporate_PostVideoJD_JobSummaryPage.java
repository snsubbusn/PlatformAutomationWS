package com.objects_pages;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;
import com.controller.Variables;

public class Corporate_PostVideoJD_JobSummaryPage extends Action_Method
{
	
	//Locating all elements present in Job summary page
	
	@FindBy(xpath="//div[contains(text(),'Post Job')]")
	WebElement PostJob_Tab;
	
	@FindBy(xpath="//a/span")
	WebElement Jobs_Tab;
	
	@FindBy(xpath="//div[contains(text(),'New Jobs')]")
	WebElement newJobs;
	
	@FindBy(xpath="//div[contains(text(),'Active Jobs')]")
	WebElement activeJobs;
	
	@FindBy(xpath="//div[contains(text(),'Archived Jobs')]")
	WebElement archivedJobs;
	
/*	@FindBy(xpath="//div[contains(text(),'Post Video JD')]")
	WebElement PostVideoJD_Main_PageTitle;
	*/
	@FindBy(xpath="//h2[contains(text(),'Job Summary')]")
	WebElement JobSummary_PageTitle;
	
	@FindBy(xpath="//mat-select[div[div/span[text()='Requirement Type']]]")
	WebElement RequirementType;
	
	@FindBy(xpath="//span[text()='Requirement Type']")
	WebElement RequirementType_Text;
	
	@FindBy(xpath="//mat-option[1]")
	WebElement Select_RequirementType;
	
	@FindBy(xpath="//input[@id='JDTitle']")
	WebElement JD_Title;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement Description;
	
	@FindBy(xpath="//section[contains(text(),'Experience')]")
	WebElement Experience_Text;
	
	@FindBy(xpath="//input[@id='minExp']")
	WebElement Minimum_Years;
	
	@FindBy(xpath="//input[@id='maxExp']")
	WebElement Maximum_Years;
	
	@FindBy(xpath="//section[contains(text(),'Salary')]")
	WebElement Salary_Text;
	
	@FindBy(xpath="//input[@id='minSal']")
	WebElement Minimum_Salary;
	
	
	@FindBy(xpath="//input[@id='maxSal']")
	WebElement Maximum_Salary;
	
//	@FindBy(xpath="//mat-select[div[div/span[text()='Location']]]")
//	WebElement Location;
	
	@FindBy(id="location")
	WebElement Location;
	
	@FindBy(xpath="//span[text()='Location']")
	WebElement Location_Text;
	
	@FindBy(xpath="//mat-option[2]")
	WebElement Select_Location;
	
//	@FindBy(xpath="//mat-select[div[div/span[text()='Education']]]")
	@FindBy(id="education")
	WebElement Eduation;
	
	@FindBy(xpath="//span/label[text()='Education']")
	WebElement Education_Text;
	
	@FindBy(xpath="//mat-option[3]")
	WebElement Select_Eduation;	
	
	@FindBy(xpath="//button[@id='next']")
	WebElement Next_button;
	
	@FindBy(xpath="//button[@id='next']/span")
	WebElement Next_buttonText;
	
	
	
	//Error messages of Job Summary page
	
	@FindBy(xpath="//div[contains(text(),'Minimum value is greater than maximum value')]")
	WebElement Experience_ErrorMessage;
	
	@FindBy(xpath="//div[contains(text(),'Minimum salary is greater than maximum salary')]")
	WebElement Salary_ErrorMessage;
	
	//@FindBy(xpath="//div[contains(text(),'Required fields cannot be empty')]")
	@FindBy(xpath="//mat-error/div")
	WebElement Next_Button_ErrorMessage;
	
	
	//Click on Post video JD tab
	
	public void ClickOnPostVideoJD_Tab()
	{
		Jobs_Tab.click();
		PostJob_Tab.click();
		wait_for_elementpresent(JobSummary_PageTitle);
	}
	
	//Verify all the elements and text for Job summary page
	
	//Verify Main Page title
	
	/*public boolean Verify_Main_pageTitle()
	{
		return PostVideoJD_Main_PageTitle.isDisplayed();
	}
	//Verify Main page title text
	
	public String MainPageTitleText()
	{
		return PostVideoJD_Main_PageTitle.getText();
	}
	*/
	
	//Verify Job Summary page title
	public boolean Verify_JobSummaryPageTitle()
	{
		return JobSummary_PageTitle.isDisplayed();
	}
	//Verify Job Summary page title text
	public String JobSummaryPageTitleText()
	{
		return JobSummary_PageTitle.getText();
	}
	//Verify requirement type field
	public boolean Verify_RequirementType()
	{
		return RequirementType.isDisplayed();
	}
	//Verify text for requirement type field
	
	public String RequirementTypeText()
	{
		return RequirementType_Text.getText();
	}
	//Verify JD Title field
	
	public boolean JdTitle()
	{
		return JD_Title.isDisplayed();
	}
	//Verify text for JD Title
	public String JD_TitleText()
	{
		return JD_Title.getAttribute("placeholder");
	}
	//Verify Description field
	public boolean Description()
	{
		return Description.isDisplayed();
	}
	//Verify text for Description field
	public String Description_Text()
	{
		return Description.getAttribute("placeholder");
	}
	//Verify Experience text
	public String Experience_Text()
	{
		return Experience_Text.getText();
	}
	//verify Minimum Years field
	public boolean MinimumYears()
	{
		return Minimum_Years.isDisplayed();
	}
	//Verify Minimum Years text
	public String MinimumYears_Text()
	{
		return Minimum_Years.getAttribute("placeholder");
	}
	//Verify Maximum years field
	public boolean MaximumYears()
	{
		return Minimum_Years.isDisplayed();
	}
	//Verify Maximum Years text
	public String MaximumYears_Text()
	{
		return Maximum_Years.getAttribute("placeholder");
	}
	
	//Verify Salary text
	public String Salary_Text()
	{
		return Salary_Text.getText();
	} 
	//verify Minimum Salary field 
	public boolean MinimumSalary()
	{
		return Minimum_Salary.isDisplayed();
	}
	//Verify Minimum salary text
	public String MinimumSalary_Text()
	{
		return Minimum_Salary.getAttribute("placeholder");
	}
	//Verify Maximum Salary field
	public boolean MaximumSalary()
	{
		return Maximum_Salary.isDisplayed();
	}
	//Verify Maximum Salary text
	public String MaximumSalary_Text()
	{
		return Maximum_Salary.getAttribute("placeholder");
	}
	//Verify Location field
	public boolean Location()
	{
		return Location.isDisplayed();
	}
	//Verify Location text
	public String Location_Text()
	{
		return Location_Text.getText();
	}
	//Verify Education field
	public boolean Education()
	{
		return Eduation.isDisplayed();
	}
	//Verify Education text
	public String Education_Text()
	{
		return Education_Text.getText();
	}
	//Verify next button
	public boolean Next_Button()
	{
		return Next_button.isDisplayed();
	}
	//Verify text of next button
	public String NextButton_Text()
	{
		return Next_buttonText.getText();
	}
	
	
	// Verifying error message for No inputs
	public String Error_Message_For_NoInputs()
	{
		//scrollingToElementofAPage(Next_button);
		Next_button.click();
		scrollingToBottomofAPage();
		wait_for_elementpresent(Next_Button_ErrorMessage);
		List <WebElement> a = driver.findElements(By.xpath("//mat-error/div"));
		String error = "The Errors are : ";
		for (WebElement e : a) {
			error = error+e.getText()+";";
		}
		return error; 
	}
	//Verifying error message for minimum Experience greater than maximum Experience
	public boolean Error_Message_For_MinimumExperience_GreaterThan_MaximumExperience() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		scrollingToTopofAPage();
		//scrollingToElementofAPage(Minimum_Years);
		Minimum_Years.sendKeys("4");
		Maximum_Years.sendKeys("3");
		Minimum_Salary.click();
		wait_for_elementpresent(Experience_ErrorMessage);
		return Experience_ErrorMessage.isDisplayed();
	}
	//Verifying error message for minimum Salary greater than maximum Salary
	public boolean Error_Message_For_MinimumSalary_GreaterThan_MaximumSalary() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		scrollingToTopofAPage();
		//scrollingToElementofAPage(Minimum_Salary);
		Minimum_Salary.sendKeys("3");
		Maximum_Salary.sendKeys("2");
		Minimum_Years.click();
		wait_for_elementpresent(Salary_ErrorMessage);
		return Salary_ErrorMessage.isDisplayed();
	}
	//Complete Job summary page and click on next with valid inputs
	public void Complete_JobSummaryPage() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		wait_for_elementpresent(RequirementType);
		Thread.sleep(1000);
		RequirementType.click();
		wait_for_elementpresent(Select_RequirementType);
		Select_RequirementType.click();
		wait_for_elementpresent(JD_Title);
		JD_Title.sendKeys(getExceldata(Variables.testdata,Variables.Corporate_JobSummaryPage,"Jd title"));
		Description.sendKeys(getExceldata(Variables.testdata,Variables.Corporate_JobSummaryPage,"Description"));
		Minimum_Years.sendKeys(getExceldata(Variables.testdata,Variables.Corporate_JobSummaryPage,"Min Years"));
		Maximum_Years.sendKeys(getExceldata(Variables.testdata,Variables.Corporate_JobSummaryPage,"Max Years"));
		Minimum_Salary.sendKeys(getExceldata(Variables.testdata,Variables.Corporate_JobSummaryPage,"Min Salary"));
		Maximum_Salary.sendKeys(getExceldata(Variables.testdata, Variables.Corporate_JobSummaryPage,"Max Salary"));
		Location.click();
		Select_Location.click();
		Eduation.click();
		Select_Eduation.click();
		Next_button.click();
		Thread.sleep(5000);
	}
	
	
	
	
	
}
