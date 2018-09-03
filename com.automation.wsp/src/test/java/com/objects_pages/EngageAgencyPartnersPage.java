package com.objects_pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
		@FindBy(xpath="(//mat-card[@class='mat-card']//span[contains(text(), 'Software Regression Engineer')])[1]/following::div[contains(@class, 'jobcode subdued')][1]")
		WebElement Job_Id;
		
			
		@FindBy(xpath="//a[contains(text(),'Work Desk')]")
		WebElement WorkDesk_Tab;
		
		//locatring Elements present in Payment page
		@FindBy(xpath="//input[@id='noOfPositions']") 
		WebElement No_Of_Positions;
		
		@FindBy(id="subReq") 
		WebElement Sub_Req;
		
		@FindBy(id="skillLevel")
		WebElement Skill_Level_Dropdown;
		
		@FindBy(xpath="//mat-option[span[contains(text(),'Easy')]]")
		WebElement Select_Skill_Level;
		
		@FindBy(xpath="//b[contains(text(),'Get Estimate')]")
		WebElement GetEstimate;
		
		@FindBy(xpath="//button[span[b[contains(text(),'Accept To Pay Later')]]]")
		WebElement Accept_To_PayLater;
		
		
		
		public String GetJobID() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			
			try 
			{
				WorkDesk_Tab.click();
				Thread.sleep(5000);
				String Id1=Job_Id.getText();
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
			WebElement Get_Guaranteed_Response=driver.findElement((By.xpath(("//mat-card[@class='mat-card'][1]//div[contains(text(),"
					+ "'"+Job_Id+"')]//following::button[2]/span[contains(text(),'Submission')]"))));
			try
			{
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
				No_Of_Positions.sendKeys("5");
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
				/*Actions act = new Actions(driver);
				act.moveToElement(Accept_To_PayLater).build().perform();
				*/Accept_To_PayLater.click();
				return true;
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
				return false;
			}
		}
				
		
}
