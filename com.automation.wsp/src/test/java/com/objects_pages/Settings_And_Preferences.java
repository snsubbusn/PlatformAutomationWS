package com.objects_pages;

import java.util.ArrayList;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class Settings_And_Preferences extends Action_Method
{

	//Elements for Settings tab

	@FindBy(xpath = "//mat-icon[contains(text(),'keyboard_arrow_down')]")
	WebElement Arrow_Dropdown;

	@FindBy(xpath = "//a[@class='logout-btn mat-menu-item ng-star-inserted']")
	WebElement Settings;

	@FindBy(xpath = "//a[contains(text(),'Security Settings')]")
	WebElement SecuritySettings_Tab;

	@FindBy(xpath = "//a[contains(text(), ' Preferences ')]")
	WebElement Preferences_Tab;

	@FindBy(xpath = "//div[contains(text(), 'Email Address')]")
	WebElement EmailIdTitle;

	@FindBy(xpath = "//div/div[contains(text(),'Email Address')]//following ::a[1][contains(text(), 'Change')]")
	WebElement EmailChange_Button;

	@FindBy( id="email")
	WebElement NewEmail;

	@FindBy(id="otp")
	WebElement EmailOTP;

	@FindBy(id="saveEmail")
	WebElement Email_SaveButton;

	@FindBy(xpath = "//div[contains(text(),' Mobile Number ')]")
	WebElement MobileNumberTitle;		

	@FindBy(xpath = "//div/div[contains(text(),'Email Address')]//following ::a[2][contains(text(), 'Change')]")
	WebElement NumberChange_Button;

	@FindBy(id="phone")
	WebElement NewNumber;

	@FindBy(id="otp")
	WebElement NumberOTP;

	@FindBy(id="saveMobile")
	WebElement MobileSaveBtn; 

	@FindBy(xpath= "//div[contains(text(),' Change Password ')]")
	WebElement Change_PasswordTitle;

	@FindBy( xpath = "//div/div[contains(text(),'Email Address')]//following ::a[3][contains(text(), 'Change')]")
	WebElement PasswordChange_Button;

	@FindBy(id="oldPassword")
	WebElement OldPassword;

	@FindBy(id="password")
	WebElement NewPass;

	@FindBy(id="confirmPassword")
	WebElement ConfirmPass;

	@FindBy(id="savePassword")
	WebElement PassSaveBtn;


	//Errors 

	@FindBy(xpath = "//div[contains(text(),' Please enter email address.')]")
	WebElement NoEmailError;

	@FindBy(xpath = "//div[contains(text(),' Please enter a valid email')]")
	WebElement InvalidEmail_Error;

	@FindBy(id="sendOTP")
	WebElement EmailOtpBtn;

	@FindBy(xpath = "//div[contains(text(),'OTP verification failed')]")
	WebElement InvalidOtpError;


	@FindBy(xpath = "//div[contains(text(),'Please enter mobile number.')]")
	WebElement NoNumberError;

	@FindBy(id="sendOTP")
	WebElement NumberOtpbtn;

	@FindBy(xpath = "//div[contains(text(),'Please enter a valid mobile number')]")
	WebElement InvalidNumberError;

	@FindBy( xpath = "//div[contains(text(),'otp not_verified')]")
	WebElement InvalidOtpForNumberField;


	@FindBy(xpath = "//div[contains(text(),' A minimum 8 characters password contains a combination of alphabets, numeric digits, special characters @, #, $, %, _ and no spaces ')]")
	WebElement MinCharacterError;


	@FindBy(xpath = "//div[contains(text(),' Confirm Password is not same as New Password ')]")
	WebElement InvalidConfirmPassword;

	@FindBy(xpath = "//div[contains(text(),'Invalid Current Password')]")
	WebElement InvalidCurrentPassword;

	// Methods for General_TC007

	public boolean navigateToSettings()
	{

		try {
			wait_for_elementpresent(Arrow_Dropdown);
			Arrow_Dropdown.click();
			wait_for_elementpresent(Settings);
			Settings.click();
			Child_Window_Handling01();

			return true;
		}
		catch(Exception e)
		{
			return false;
		}


	}

	public boolean verifyNavigationToSettingsTab() throws InterruptedException 
	{
		Thread.sleep(2000);

		SecuritySettings_Tab.isDisplayed();
		Preferences_Tab.isDisplayed();
		return true;
	}

	public boolean verifySettingsTab()
	{
		EmailIdTitle.isDisplayed();
		EmailChange_Button.isDisplayed();
		MobileNumberTitle.isDisplayed();
		NumberChange_Button.isDisplayed();
		Change_PasswordTitle.isDisplayed();
		PasswordChange_Button.isDisplayed();
		return true;
	}


	public String VerifyChangeEmailAddress()
	{
		EmailChange_Button.click();
		NewEmail.sendKeys("abc@nada.email");
		EmailOTP.sendKeys("1234");
		//verify save button
		String a = Email_SaveButton.getAttribute("ng-reflect-disabled");
		System.out.println(a);
		return a;

	}

	String p,q,r;

	public boolean VerifyEmailErrors()
	{

		EmailChange_Button.click();
		try {
			//No email error
			EmailOtpBtn.click();
			EmailOtpBtn.click();
			NoEmailError.isDisplayed();
			p = NoEmailError.getText();

			//Invalid email error
			Thread.sleep(3000);
			NewEmail.sendKeys("1234");
			NewEmail.sendKeys(Keys.TAB);
			InvalidEmail_Error.isDisplayed();
			q = InvalidEmail_Error.getText();
			NewEmail.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));

			//Invalid OTP error
			Thread.sleep(3000);
			NewEmail.sendKeys("1a@nada.email");
			EmailOtpBtn.click();
			EmailOTP.sendKeys("12234");
			Email_SaveButton.click();
			InvalidOtpError.isDisplayed();
			r = InvalidOtpError.getText();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public ArrayList<String> getAllErrorMessagesForEmailField()
	{
		ArrayList<String> a = new ArrayList<String>();
		a.add(p);
		a.add(q);
		a.add(r);
		return a;

	}


	public String VerifyChangeMobileNumber() throws InterruptedException
	{
		NumberChange_Button.click();
		Thread.sleep(3000);
		NewNumber.sendKeys("");
		NewNumber.sendKeys("8951283885");
		NumberOTP.sendKeys("12231");

		//verify Save button
		String a = MobileSaveBtn.getAttribute("ng-reflect-disabled");
		return a;
	}

	public boolean VerifyErrorsForMobileNumber()
	{
		NumberChange_Button.click();
		try 
		{
			//No mobile number error
			NewNumber.sendKeys("");
			NumberOtpbtn.click();
			NoNumberError.isDisplayed();
			p = NoNumberError.getText();

			//Invalid number error
			NewNumber.sendKeys("1234");
			NewNumber.sendKeys(Keys.TAB);
			InvalidNumberError.isDisplayed();
			q = InvalidNumberError.getText();

			//Invalid OTP
			NewNumber.clear();
			NewNumber.sendKeys("7406576530");
			NumberOtpbtn.click();
			NumberOTP.sendKeys("12231");
			MobileSaveBtn.click();
			InvalidOtpForNumberField.isDisplayed();
			r = InvalidOtpForNumberField.getText();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public ArrayList<String> getAllErrorMessagesForNumberField()
	{
		ArrayList<String> a = new ArrayList<String>();
		a.add(p);
		a.add(q);
		a.add(r);
		return a;

	}

	public String VerifyChangePassword() throws InterruptedException
	{
		PasswordChange_Button.click();
		Thread.sleep(2000);
		OldPassword.sendKeys(" ");
		OldPassword.sendKeys("admin@123");
		NewPass.sendKeys("admin@1234");
		ConfirmPass.sendKeys("admin@1234");
		String a = PassSaveBtn.getAttribute("ng-reflect-disabled");
		return a;

	}

	public boolean VerifyErrorsForPasswordField()
	{
		PasswordChange_Button.click();
		try
		{
			//Validate New Password
			NewPass.sendKeys("a12");
			NewPass.sendKeys(Keys.TAB);
			MinCharacterError.isDisplayed();
			p = MinCharacterError.getText();

			//Validate New and confirm password
			NewPass.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			NewPass.sendKeys("aaa12");
			ConfirmPass.sendKeys("a13");
			ConfirmPass.sendKeys(Keys.TAB);
			InvalidConfirmPassword.isDisplayed();
			q = InvalidConfirmPassword.getText();

			//Validate Current Password
			driver.navigate().refresh();
			PasswordChange_Button.click();
			OldPassword.sendKeys("admi");
			NewPass.sendKeys("admin@1234");
			ConfirmPass.sendKeys("admin@1234");
			PassSaveBtn.click();
			InvalidCurrentPassword.isDisplayed();
			r = InvalidCurrentPassword.getText();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}
	public ArrayList<String> getAllErrorMessagesForPasswordField()
	{
		ArrayList<String> a = new ArrayList<String>();
		a.add(p);
		a.add(q);
		a.add(r);
		return a;

	}


	//Candidate Preference paths

	@FindBy(xpath = "//div[contains(text(),'Career Interests')]")
	WebElement CareerInterests_Title;

	@FindBy(xpath = "//div[contains(text(),'Permanent')]")
	WebElement Permamanent_title;

	@FindBy(xpath = "//div[contains(text(),'Contract to hire')]")
	WebElement ContractToHire;

	@FindBy(xpath = "//div[(text()='Contract')]")
	WebElement Contract;

	@FindBy(xpath = "//div[contains(text(),'System Notifications')]")
	WebElement SystemNotification;

	@FindBy(xpath = "//div[contains(text(),'Receive notification over email')]")
	WebElement Email_Notification;

	@FindBy(xpath = "//div[contains(text(),'Receive notification over SMS')]")
	WebElement SMS_Notification;

	@FindBy(xpath = "//div[contains(text(),'Deactivate Account')]")
	WebElement DeactivateAcntTitle;

	@FindBy(xpath = "//div[@class='pref-parent']//div[@class='mat-slide-toggle-bar mat-slide-toggle-bar-no-side-margin']")
	WebElement DeactivateBtn;

	@FindBy(xpath = "//div[contains(text(),'Confirm')]")
	WebElement DeactivationPopUp;

	@FindBy(xpath = "//span[contains(text(),'No')]")
	WebElement NoBtn;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement YesBtn;

	@FindBy(xpath = "//i[contains(text(),'close')]")
	WebElement PopUpCloseBtn;

	@FindBy(id= "mat-slide-toggle-2")
	WebElement CarrerInterestsBtn;

	@FindBy(xpath = "//i[contains(text(),'close')]")
	WebElement CloseBtn;

	@FindBy(id = "mat-checkbox-1-input")
	WebElement permanentChkBox;

	@FindBy(id = "mat-checkbox-2-input")
	WebElement contractToHireChkBox;

	@FindBy(id = "mat-checkbox-3-input")
	WebElement contractChkBox;

	@FindBy(id = "mat-slide-toggle-2")
	WebElement AcceptAssignmentBtn;

	public boolean VerifyPrefernecePageOfWSA()
	{
		Preferences_Tab.click();
		SystemNotification.isDisplayed();
		Email_Notification.isDisplayed();
		DeactivateAcntTitle.isDisplayed();
		return true;
	}

	public boolean verifyDeactivatePopUp() throws InterruptedException
	{
		DeactivateBtn.click();
		Thread.sleep(2000);
		if(DeactivationPopUp.isDisplayed() && YesBtn.isDisplayed() && NoBtn.isDisplayed())
		{
			PopUpCloseBtn.click();
			return true;
		}
		else
		{
			return false;
		}

	}

	public boolean VerifyPrefernecePageOfCandidate()
	{
		Preferences_Tab.click();
		if(SystemNotification.isDisplayed() && Email_Notification.isDisplayed() && DeactivateAcntTitle.isDisplayed() && CareerInterests_Title.isDisplayed() && Permamanent_title.isDisplayed() && ContractToHire.isDisplayed() && Contract.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean verifyCarrerInterest() throws InterruptedException
	{
		try
		{
			if(CarrerInterestsBtn.getAttribute("ng-reflect-checked").equals("false"))
			{
				CarrerInterestsBtn.click();
				CloseBtn.click();

				if((permanentChkBox.getAttribute("aria-checked").equals("true")) && (contractToHireChkBox.getAttribute("aria-checked").equals("true")) && (contractChkBox.getAttribute("aria-checked").equals("true")))
				{
					System.out.println("Buttons enabled successfully");
					Thread.sleep(2000);
					CarrerInterestsBtn.click();
					CloseBtn.click();
				}
			}

			else
			{
				CarrerInterestsBtn.click();
				CloseBtn.click();

				if((permanentChkBox.getAttribute("aria-checked").equals("false")) && (contractToHireChkBox.getAttribute("aria-checked").equals("false")) && (contractChkBox.getAttribute("aria-checked").equals("false")))
				{

					System.out.println("Buttons disabled successfully");
					Thread.sleep(2000);
					CarrerInterestsBtn.click();
					CloseBtn.click();
				}		

			}


			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}

	public boolean verifyAgencyPreferencePage()
	{
		Preferences_Tab.click();
		if(SystemNotification.isDisplayed() && Email_Notification.isDisplayed() && DeactivateAcntTitle.isDisplayed() && AcceptAssignmentBtn.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

    public String getChkBoxValue()
    {
    	return (AcceptAssignmentBtn.getAttribute("ng-reflect-checked"));
    }
}
