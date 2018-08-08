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
		@FindBy(xpath="//div[div[div[contains(text(),'Engage Agency Partner')]]]/following::div/div/div/div/div[1]//div[@class='jobcode subdued']")
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
		
		@FindBy(xpath="//button[span[b[contains(text(),'Get Estimate')]]]")
		WebElement Get_Estimate;
		
		@FindBy(xpath="//button[span[b[contains(text(),'Accept To Pay Later')]]]")
		WebElement Accept_To_PayLater;
		
		
		
		public String GetJobID() throws EncryptedDocumentException, InvalidFormatException, IOException
		{
			try 
			{
				WorkDesk_Tab.click();
				String Id1=Job_Id.getText();
				String Id="";
				for(int i=1;i<=2;i++)
				{
					char ch=Id1.charAt(i);
					Id=Id+ch;
				}
				setExceldata(Variables.testdata, Variables.SetData_Excel, "Job ID", Id);
				
				return Id;
			} 
			catch (NoSuchElementException e) 
			{
				// TODO: handle exception
				return null;
			}
			
			
			
			
		}
		public boolean Click_On_GetGuaranteedResponse(String Job_Id)
		{
			WebElement Get_Guaranteed_Response=driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[di"
					+ "v[contains(text(),'#"+Job_Id+"')]]]]]]]]//button[@class='pending-review mat-raised-button mat-primary']"));
			try
			{
				Get_Guaranteed_Response.click();
				System.out.println(Job_Id);
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
				Get_Estimate.click();
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
				Accept_To_PayLater.click();
				return true;
			} 
			catch (Exception e) 
			{
				// TODO: handle exception
				return false;
			}
		}
				
		
}
