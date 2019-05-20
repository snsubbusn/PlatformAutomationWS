package com.objects_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class Corporate_Add_Management_profile extends Action_Method {
	
	@FindBy(id="name")
	WebElement Name;
	
	@FindBy(id="designation")
	WebElement Designation;
	
	@FindBy(id="email")
	WebElement EmailId;
	
	@FindBy(id="phone")
	WebElement PhoneNum;
	
	@FindBy(id="addManagement")
	WebElement Addbutton;
	
	@FindBy(xpath="//i[contains(text(),'delete')]")
	WebElement Delete;
	
	@FindBy(xpath="//i[contains(text(),'delete')]")
	List<WebElement> deleteList;
	
	@FindBy(xpath="//span[text()='Proceed']")
	WebElement confirmProceed;
	
	@FindBy(xpath="//span[contains(text(),'Done')]")
	WebElement DoneButton;
	
	
	@FindBy(xpath="//div[@id='listManagement']//div[contains(@class,'title')]")
	WebElement addedManagementName;
	
	
	@FindBy(xpath="//a/span[contains(text(),'View Profile')]")
	WebElement finalPageViewProfile;
	
	public int getNoOfManagementProfiles() {
		try {
			return deleteList.size();
		}catch(Exception e) {
			return 0;
		}
	}
	
	public String Corp_AddManagement_Profile() throws InterruptedException
	{
		try {
			if(deleteList.size()>1) {
				Delete.click();
				confirmProceed.click();
				Name.sendKeys("CompanyName");
				Designation.sendKeys("HR Manager");
				//EmailId.sendKeys("com@mailinator.com");
				//PhoneNum.sendKeys("8147506453");
				Addbutton.click();
			}else {
				Name.sendKeys("CompanyName");
				Designation.sendKeys("HR Manager");
				//EmailId.sendKeys("com@mailinator.com");
				//PhoneNum.sendKeys("8147506453");
				Addbutton.click();
			}
			Thread.sleep(2000);
			return addedManagementName.getText();
		}catch(Exception e) {
			Name.sendKeys("CompanyName");
			Designation.sendKeys("HR Manager");
			//EmailId.sendKeys("com@mailinator.com");
			//PhoneNum.sendKeys("8147506453");
			Addbutton.click();
			Thread.sleep(2000);
			return addedManagementName.getText();
		}
	}

	public void clickOnDone() {
		DoneButton.click();
	}

	public void clickOnViewProfile() {
		finalPageViewProfile.click();
	}
}
