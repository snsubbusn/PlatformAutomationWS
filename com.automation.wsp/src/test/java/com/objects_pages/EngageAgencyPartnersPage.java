package com.objects_pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;
import com.controller.Variables;

public class EngageAgencyPartnersPage extends Action_Method
{
	//Locating all the elements in Engage Agency Partner page
	//Locating elements present in Jd Crad
	/*		@FindBy(xpath="//div[div[div[contains(text(),'Engage Agency Partner')]]]/following::div/div/div/div/div[2]//div[@class='jobcode subdued']")
		WebElement Job_Id;*/

	//changed the xpath for the job id (Siva)
	@FindBy(xpath="(//a[contains(text(), 'Software Regression Engineer')]/following::span[2])[1]")
	WebElement Job_Id;

	@FindBy(xpath="//div[contains(text(),'Post Job')]")
	WebElement PostJob_Tab;

	@FindBy(xpath="//a[contains(text(),'Jobs')]")
	WebElement Jobs_Tab;

	@FindBy(xpath="//div[contains(text(),'New Jobs')]")
	WebElement newJobs;

	@FindBy(xpath="//div[contains(text(),'Active Jobs')]")
	WebElement activeJobs;

	@FindBy(xpath="//div[contains(text(),'Archived Jobs')]")
	WebElement archivedJobs;

	//locatring Elements present in Payment page
	@FindBy(xpath="//input[@id='noOfPositions']") 
	WebElement No_Of_Positions;

	@FindBy(id="subReq") 
	WebElement Sub_Req;

	@FindBy(id="skillLevel")
	WebElement Skill_Level_Dropdown;

	@FindBy(xpath="//mat-option[span[contains(text(),'Easy')]]")
	WebElement Select_Skill_Level;

	@FindBy(xpath="//span[contains(text(),'Get Estimate')]")
	WebElement GetEstimate;

	@FindBy(xpath="//button[span[b[contains(text(),'Accept To Pay Later')]]]")
	WebElement Accept_To_PayLater;

	@FindBy(xpath="//span[contains(text(),'Accept to pay as per agreement')]")
	WebElement OnboardingAcceptCheckBox;

	@FindBy(xpath="//span[contains(text(),'Submit')]")
	WebElement GOSubmitButton;

	@FindBy(xpath="//button//i[contains(text(),'close')]")
	WebElement successMsgClose;

	public String GetJobID() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{

		try 
		{
			/*Jobs_Tab.click();
			newJobs.click();
			Thread.sleep(3000);			
			 */String Id1=Job_Id.getText();
			 String Id="";
			 for(int i=1;i<Id1.length();i++)
			 {
				 char ch=Id1.charAt(i);
				 Id=Id+ch;
			 }
			 setExceldata(Variables.testdata, Variables.SetData_Excel, "Job ID", Id.trim());

			 return Id.trim();
		} 
		catch (NoSuchElementException e) 
		{
			// TODO: handle exception
			return null;
		}




	}
	public boolean Click_On_GetGuaranteedResponse(String Job_Id)
	{
		/*WebElement Get_Guaranteed_Response=driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[di"
					+ "v[contains(text(),'#"+Job_Id+"')]]]]]]]]//button[@class='mat-raised-button mat-primary']"));//pending-review mat-raised-button mat-primary

		 */			
		//Changed the locator for Guaranteed Submission button

		try
		{
			WebElement arrow =driver.findElement((By.xpath(("(//span[contains(text(),'"+Job_Id+"')]/following::span/mat-icon[contains(text(),'keyboard_arrow_down')])[1]"))));
			arrow.click();
			WebElement Get_Guaranteed_Response=driver.findElement((By.xpath(("(//span[contains(text(),'"+Job_Id+"')]/following::button/span[contains(text(),'Submission')])[1]"))));

			Get_Guaranteed_Response.click();
			return true;
		}
		catch (NoSuchElementException e) 
		{
			// TODO: handle exception
			return false;
		}
	}
	public boolean Get_Estimate()
	{
		try
		{
			No_Of_Positions.sendKeys("1");
			Skill_Level_Dropdown.click();
			Select_Skill_Level.click();
			GetEstimate.click();
			return true;
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			return false;
		}
	}
	public boolean Aaccept_To_Pay_Later()
	{
		try 
		{
			Thread.sleep(1000);
			Accept_To_PayLater.click();
			return true;
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			return false;
		}
	}

	public boolean Click_On_GuaranteedOnboarding(String Job_Id)
	{
		try
		{
			successMsgClose.click();			
			WebElement GuaranteedOnboarding=driver.findElement((By.xpath(("//span[contains(text(),'"+Job_Id+"')]/following::span[contains(text(),'Onboarding')]"))));
			GuaranteedOnboarding.click();
			return true;
		}
		catch (NoSuchElementException e) 
		{
			// TODO: handle exception
			return false;
		}


	}


	//Method to update the Guaranteed onboarding payment options.
	public String EnterPaymentForGuaranteedOnboarding(String NoOfPositions) {
		try {
			No_Of_Positions.clear();
			No_Of_Positions.sendKeys(NoOfPositions);
			OnboardingAcceptCheckBox.click();
			Actions act = new Actions(driver);
			act.moveToElement(GOSubmitButton);
			/*if(GOSubmitButton.isEnabled()) {
				GOSubmitButton.click();
			}else{
				No_Of_Positions.sendKeys("1");
				OnboardingAcceptCheckBox.click();
				GOSubmitButton.click();
			}*/
			GOSubmitButton.click();
			return "Pass";
		}catch(Exception e) {

			return "Fail"+e;
		}

	}


}
