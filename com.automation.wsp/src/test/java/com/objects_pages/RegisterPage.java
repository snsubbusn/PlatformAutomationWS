package com.objects_pages;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;
import com.controller.Variables;

public class RegisterPage extends Action_Method
{
	//Locating all elements present in Register page

		@FindBy(xpath="//a[contains(text(),'Register')]")
		WebElement Register_Tab;
		
		@FindBy(id="name")
		WebElement Full_Name;
		
		@FindBy(id="email")
		WebElement Email;
		
		@FindBy(id="mobile")
		WebElement Mobile_Number;
		
		@FindBy(xpath="//mat-select[@id='mat-select-0']")
		WebElement Join_Us_as;
		
		@FindBy(xpath="// mat-option[1]")
		WebElement Select_Candidate;
		
		@FindBy(id="register")
		WebElement Request_Invite_Button;
		
		public boolean Enter_Inputs_For_All_The_Fields_In_RegisterPage() throws EncryptedDocumentException, IOException, InvalidFormatException
		{
			try
			{
				Register_Tab.click();
				Full_Name.sendKeys("Raghav AT");
				Email.sendKeys(getExceldata(Variables.testdata,Variables.Update_Data,"email"));
				Mobile_Number.sendKeys("8147506453");
				Join_Us_as.click();
				Select_Candidate.click();
				return true;
			} catch (NoSuchElementException e)
			{
				return false;
			}
			
			
		}
		public boolean Request_Invite()
		{
			try 
			{
				Request_Invite_Button.click();
				return true;
			} 
			catch (Exception e) 
			{
				return false;
			}
			
			
			
		}
		
		
	
}
