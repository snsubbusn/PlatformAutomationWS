package com.objects_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.controller.Action_Method;

public class WSAdminUsersPage extends Action_Method {

	//Elements under Workstreets Admin Users Tab
	@FindBy(xpath="//a[contains(text(),' Users')]")
	WebElement usersTab;

	@FindBy(xpath="//app-pagination/span[@class='pagination-bottom']")
	WebElement paginationBottom;
	
	@FindBy(xpath="//button//mat-icon[contains(text(),'add')]")
	WebElement addButton;

	@FindBy(xpath="(//div[@class='user-card-wrapper '])[1]")
	WebElement firstUserCard;

	@FindBy(xpath="(//div[@class='user-card-wrapper '])[1]//div[@class='name']")
	WebElement firstUserCardName;

	@FindBy(xpath="//div[@class='email']")
	WebElement firstUserCardEmail;

	@FindBy(xpath="//div[@class='phone-no']")
	WebElement firstUserCardPhoneNo;

	@FindBy(xpath="(//i[contains(text(),'edit')])[1]")
	WebElement firstUserCardEditIcon;

	@FindBy(xpath="(//i[contains(text(),'delete')])[1]")
	WebElement firstUserCardDelete;

	@FindBy(xpath="//span[contains(text(),'Proceed')]")
	WebElement confirmProceedButton;

	@FindBy(xpath="//div[contains(text(),'Deleted Successfully')]")
	WebElement deleteSuccessMsg;

	@FindBy(xpath="//button//i[contains(text(),'close')]")
	WebElement successMsgClose;
	

	
	//Add Users page elements
	
	
	@FindBy(xpath="//div[contains(text(),'User')]")
	WebElement addUserHeading;
	
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	@FindBy(xpath="//input[@formcontrolname='name']")
	WebElement name;

	@FindBy(xpath="//input[@formcontrolname='email']")
	WebElement email;

	@FindBy(xpath="//input[@formcontrolname='phone_no']")
	WebElement phoneNum;

	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement password;

	@FindBy(xpath="//input[@formcontrolname='confirmPassword']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//mat-error//span[contains(text(),'name')]")
	WebElement nameError;
	
	@FindBy(xpath="//mat-error//span[contains(text(),'email')]")
	WebElement emailError;
	
	@FindBy(xpath="//mat-error//span[contains(text(),'phone')]")
	WebElement phoneNoError;
	
	@FindBy(xpath="//mat-error//span[contains(text(),'enter password')]")
	WebElement passwordError;
	
	@FindBy(xpath="//mat-error//span[contains(text(),'confirm password')]")
	WebElement confirmPasswordError;
	
	@FindBy(xpath="//div[contains(text(),'User Info Updated Successfully')]")
	WebElement successMsgUserDetails;

	@FindBy(xpath="//div[contains(text(),'Password Updated Successfully')]")
	WebElement changePwdSuccessMsg;
	
	//Methods
	public void clickOnUsersTab() throws InterruptedException {
		Thread.sleep(2000);
		usersTab.click();
	}


	public String getTotalRecordsofthePage() {
		String rec = paginationBottom.getText();
		String [] recd = rec.split(" ");
		return recd[5];
	}
	
	public void clickOnAddButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
	public String verifyAddUserPage() {
		return addUserHeading.getText();
	}
	
	public String verifyErrorMessageforAllField() {
		saveButton.click();
		return nameError.getText()+"; "+emailError.getText()+"; "+phoneNoError.getText()+"; "+
				passwordError.getText()+"; "+confirmPasswordError.getText();
	}
	
	public void addAdminUser(){
		name.sendKeys("RegressionAdminUser");
		email.sendKeys("Regress@mailinator.com");
		phoneNum.sendKeys("8147506453");
		password.sendKeys("admin@123");
		confirmPassword.sendKeys("admin@123");
		saveButton.click();			
	}
	
	public String getFirstUserCardName() {
		return firstUserCardName.getText();
	}

	public String getFirstUserCardEmail() {
		return firstUserCardEmail.getText();
	}

	public String getFirstUserCardPhone() {
		return firstUserCardPhoneNo.getText();
	}

}
