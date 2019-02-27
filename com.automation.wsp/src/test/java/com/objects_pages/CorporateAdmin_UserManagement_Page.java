package com.objects_pages;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.controller.Action_Method;



public class CorporateAdmin_UserManagement_Page extends Action_Method {

	//Locating Users tab of a corporate admin
	@FindBy(xpath="//a[contains(text(),'Users')]")
	WebElement Users;

	//Changing the Xpath due to additional changes in the system by Siva 11-Jan-19
//	@FindBy(xpath="//div[@class='licence_info ng-star-inserted']")
//	WebElement licensecount;

	@FindBy(xpath="//div[contains(@class,'licence_info ng-star-inserted')]")
	WebElement licensecount;
	
	@FindBy(xpath="//div[@class='no-img-wrapper ng-star-inserted']/img")
	WebElement UsersEmptyPage;

	@FindBy(xpath="//mat-icon[contains(text(),'add')]")
	WebElement AddButton;

	@FindBy(xpath="//div[@class='user-card-wrapper '][1]")
	WebElement firstUserCard;

	@FindBy(xpath="//div[@class='user-card-wrapper '][1]//div[@class='name']")
	WebElement firstUserCardName;

	@FindBy(xpath="//div[@class='email']")
	WebElement firstUserCardEmail;

	@FindBy(xpath="//div[@class='phone-no']")
	WebElement firstUserCardPhoneNo;

	@FindBy(xpath="//i[contains(text(),'edit')][1]")
	WebElement firstUserCardEditIcon;

	@FindBy(xpath="//i[contains(text(),'delete')]")
	WebElement firstUserCardDelete;

	@FindBy(xpath="//span[contains(text(),'Proceed')]")
	WebElement confirmProceedButton;

	@FindBy(xpath="//div[contains(text(),'Deleted Successfully')]")
	WebElement deleteSuccessMsg;

	@FindBy(xpath="//button//i[contains(text(),'close')]")
	WebElement successMsgClose;

	//Pagination 
	@FindBy(xpath="//li/a[contains(text(),'1')]")
	WebElement page1;

	@FindBy(xpath="//li/a[contains(text(),'2')]")
	WebElement page2;

	@FindBy(xpath="//li/a[@title='Go to next page']")
	WebElement nextPage;

	@FindBy(xpath="//li/a[@title='Go to last page']")
	WebElement lastPage;

	@FindBy(xpath="//li/a[@title='Go to first page']")
	WebElement firstPage;

	@FindBy(xpath="//li/a[@title='Go to previous page']")
	WebElement previousPage;



	//Add User Page
	@FindBy(xpath="//div[@class='col-xs-12 heading']")
	WebElement addUserHeading;

	@FindBy(xpath="//div[@class='heading']")
	WebElement editUserHeading;

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

	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;

	@FindBy(xpath="//div[contains(text(),'You have used up all')]")
	WebElement allLicenseUsedError;

	@FindBy(xpath="//button[contains(text(),'Update')]")
	WebElement updateButton;

	@FindBy(xpath="//button[contains(text(),'Reset Password')]")
	WebElement resetPasswordButton;

	@FindBy(xpath="//div[contains(text(),'User Info Updated Successfully')]")
	WebElement successMsgUserDetails;

	@FindBy(xpath="//div[contains(text(),'Password Updated Successfully')]")
	WebElement changePwdSuccessMsg;

	//Error validations
	@FindBy(xpath="//div/mat-error/span[contains(text(),'name')]")
	WebElement errorName;

	@FindBy(xpath="//div/mat-error/span[contains(text(),'email')]")
	WebElement errorEmail;

	@FindBy(xpath="//div/mat-error/span[contains(text(),'phone')]")
	WebElement errorPhone;

	@FindBy(xpath="//div/mat-error/span[contains(text(),'password')]")
	WebElement errorpassword;

	@FindBy(xpath="//div/mat-error/span[contains(text(),'onfirm')]")
	WebElement errorconfirmPassword;

	@FindBy(xpath="//div[contains(text(),'Invite request has already been accepted or is pending')]")
	WebElement alreadyInvitedError;



	public String clickOnUsersTab() {
		Users.click();
		return licensecount.getText();
	}

	public String getlicensedetails() {
		return licensecount.getText();
	}

	public List<String> getLicensesCount() {

		String tex = licensecount.getText();
		tex = tex.replaceAll("[^-?0-9]+", " "); 
		List<String> a = Arrays.asList(tex.trim().split(" "));
		return a;
	}

	public boolean verifyEmptyUsersPage() {
		return UsersEmptyPage.isDisplayed();
	}

	public boolean verifyFirstUserCard() {
		return firstUserCard.isDisplayed();
	}

	public boolean verifyAddButton() {
		return AddButton.isDisplayed();
	}

	public String clickonAddButton() {
		AddButton.click();
		return addUserHeading.getText();
	}


	public void addCorporateUser(int userno){
		name.sendKeys("Automate"+userno);
		email.sendKeys("automate"+userno+"@mailinator.com");
		phoneNum.sendKeys("8147506453");
		//password.sendKeys("admin@123");
		//confirmPassword.sendKeys("admin@123");
		saveButton.click();			
	}

	public void addDeletedCorporateUser(String userName, String Email, String Phone){
		name.clear();
		name.sendKeys(userName);
		email.clear();
		email.sendKeys(Email);
		phoneNum.clear();
		phoneNum.sendKeys(Phone);
		/*password.clear();
		password.sendKeys("admin@123");
		confirmPassword.clear();
		confirmPassword.sendKeys("admin@123");
		*/saveButton.click();			
	}

	public String getErrorforAllLicenseUsed() {
		return allLicenseUsedError.getText();
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

	public String clickOnFirstUserCardEdit() {
		firstUserCardEditIcon.click();
		return editUserHeading.getText();
	}

	public String editName() {
		name.clear();
		name.sendKeys("EditedUser");
		updateButton.click();
		return successMsgUserDetails.getText();
	}

	public String editEmailId() {
		email.clear();
		email.sendKeys("editeduser@mailinator.com");
		updateButton.click();
		return successMsgUserDetails.getText();
	}

	public String editPhone() {
		phoneNum.clear();
		phoneNum.sendKeys("9952845872");
		updateButton.click();
		return successMsgUserDetails.getText();
	}

	//changePassword is a redundant method as the password related changes have 
	// been removed as part of 
	//https://otpinternet.atlassian.net/browse/W1O2-1734
	public String changePassword() {
		password.sendKeys("admin@123");
		confirmPassword.sendKeys("admin@123");
		scrollingToBottomofAPage();
		resetPasswordButton.click();
		return changePwdSuccessMsg.getText();
	}

	public String deleteFirstUser() {
		firstUserCardDelete.click();
		confirmProceedButton.click();
		String r = deleteSuccessMsg.getText();
		successMsgClose.click();
		return r;
	}

	public String allErrorValidate() {
		saveButton.click();
		String name = errorName.getText();
		String email = errorEmail.getText();
		String phone = errorPhone.getText();
	/*	String pass = errorpassword.getText();
		String confirm = errorconfirmPassword.getText();
*/
		String a = "'"+name+"'; '"+email+"'; '"+phone+"';";
		return a;
	}

	public String invalidPhoneNo() {
		phoneNum.clear();
		phoneNum.sendKeys("asds");
		return errorPhone.getText();
	}

/*	public String invlaidPassword() {
		password.sendKeys("abds");
		return errorpassword.getText();
	}

	public String passwordNotMatch() {
		password.clear();
		password.sendKeys("admin@123");
		confirmPassword.sendKeys("adm@123432");
		return errorconfirmPassword.getText();
	}
*/
	public String alreadyInvitedUserError() {
		return alreadyInvitedError.getText();
	}

	//Pagination Methods
	public void clickOnPage2() {
		page2.click();		
	}

	public boolean verifyNextPageEnabled() {
		try {
			return nextPage.isEnabled();
		}catch(Exception e) {
			return false;
		}
	}

		public boolean verifyLastPageEnabled() {
			try{
				return lastPage.isEnabled();
			}catch(Exception e) {
				return false;
			}
		}

		public boolean verifyPreviousPageEnabled() {
			try{
				return previousPage.isEnabled();
			}catch(Exception e) {
				return false;
			}
		}

		public boolean verifyFirstPageEnabled() {
			try{
				return firstPage.isEnabled();
			}catch(Exception e) {
				return false;
			}
		}

		public void clickOnPreviousPage() {
			previousPage.click();
		}

	}
