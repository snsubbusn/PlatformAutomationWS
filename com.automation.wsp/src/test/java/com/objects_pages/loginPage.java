package com.objects_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;
import com.relevantcodes.extentreports.LogStatus;

public class loginPage extends Action_Method {

	//Locating all the elements in the login page body

	@FindBy(id="email")
	WebElement Email;

	@FindBy(id="password")
	WebElement Password;

	@FindBy(id="login")
	WebElement LoginBtn;

	@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
	WebElement ForgotPwd;
	
	@FindBy(xpath="//div[contains(text(),' Welcome')]")
	WebElement Text1_Under_LoginSection;
	@FindBy(xpath="//div[contains(text(),'Please login to access your account')]")
	WebElement Text2_Under_LoginSection;
	@FindBy(xpath="//span[contains(text(),'Log in')]")
	WebElement Login_Tab;
	@FindBy(xpath="//span[contains(text(),'Register')]")
	WebElement Register_Tab;
	//Locating text present on the top of the video screen
	@FindBy(xpath="//div[contains(text(),'Onboard to Handcraft')]")
	WebElement Text1;
	@FindBy(xpath="//div[contains(text(),'Your career together, Live.')]")
	WebElement Text2;
	
	
	//Error message present in Login page
	@FindBy(xpath="//mat-error/div")
	WebElement Error_Invalid_MailId;
	@FindBy(xpath="//div[contains(text(),'Required fields cannot be empty')]")
	WebElement Error_MandatoryFieldRequired;
	

	//Locating elements present under footer part and header part of login page
	
	@FindBy(xpath="//div[@class='footer-div container-fluid']/div[2]//a[contains(text(),'Privacy Policy')]")
	WebElement Privacy_policy;
	@FindBy(xpath="//div[@class='footer-div container-fluid']/div[2]//div/a[contains(text(),'Terms and Conditions')]")
	WebElement TermsAndConditions;
	@FindBy(xpath="//div[@class='footer-div container-fluid']/div[2]//div[contains(text(),'Copyright Workstreets Internet Technology Pvt Ltd')]")
	WebElement Copyright;
	
	
	@FindBy(xpath="//div[button[span[mat-icon[contains(text(),'menu')]]]]/following-sibling::div/a")
	WebElement Workstreets_Logo;
	
	@FindBy(xpath="//a[contains(text(),'Learnathon')]")
	WebElement Learnathon_Link;
	
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement About_Link;
	
	//Actionable methods to be created 
	
	
	//Verify Login page for no inputs
	public void Login_NoInputs()
	{
		LoginBtn.click();
	}
	
	//verify login page for invalid mail id
	public void Login_InvalidMail()
	{
		Email.sendKeys("asd");
		Text1_Under_LoginSection.click();
	}
	
	//Verify invalid mail id error message
	public boolean Error_InvalidMail()
	{
		return Error_Invalid_MailId.isDisplayed();
	}
	
	//Verify Required fields are mandatory error message
	public boolean Error_MandatoryField()
	{
		return Error_MandatoryFieldRequired.isDisplayed();
	}
	
	//Generic login method for all user
	public void EnterValidLogin(String filename,String sname,String Username,String Password)
	{
		try {
			Email.sendKeys(getExceldata(filename, sname,Username));
			this.Password.sendKeys(getExceldata(filename, sname,Password));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, "Email and Password details not provided in the excel sheet");
		}
		LoginBtn.click();
	}

	public boolean VerifyLoginFailure() {
		if(Email.isDisplayed()) 
		{
			return false;		
		}else 
		{
			return true;
		}
	}
	//Verify Header part element present in Login Page
	 public boolean WorkstreetsLogo()
	 {
		 return Workstreets_Logo.isDisplayed();
		 
	 }
	 public boolean LearnathonLink()
	 {
		 return Learnathon_Link.isDisplayed();
		 
	 } 
	 public boolean About_link()
	 {
		 return About_Link.isDisplayed();
		 
	 }
	 
	 //Verify footer part element present in Login page
	 public boolean Copyright()
	 {
		 return Copyright.isDisplayed();
	 }
	 public boolean PrivacyPolicy()
	 {
		 return Privacy_policy.isDisplayed();
	 }
	 public boolean TermsAndCondition()
	 {
		 return TermsAndConditions.isDisplayed();
	 }
	 
	 //Verify element present under login page body
	 public boolean OnboardToHandCraft()
	 {
		 return Text1.isDisplayed();
	 }
	 public boolean Your_Career_Together_live()
	 {
		 return Text2.isDisplayed();
	 }
	 public boolean LoginTab()
	 {
		 return Login_Tab.isDisplayed();
		 
	 }
	 public boolean RegisterTab()
	 {
		 return Register_Tab.isDisplayed();
	 }
	 public boolean Login_Text1()
	 {
		 return Text1_Under_LoginSection.isDisplayed();
	 }
	 public boolean Login_Text2()
	 {
		 return Text2_Under_LoginSection.isDisplayed();
	 }
	 public boolean Email()
	 {
		 return Email.isDisplayed();
	 }
	 public boolean Password()
	 {
		 return Password.isDisplayed();
	 }
	 public boolean Login_Button()
	 {
		 return LoginBtn.isDisplayed();
	 }
	 public boolean ForgotPasswordLink()
	 {
		 return ForgotPwd.isDisplayed();
	 }
	 
	 
	
	 
	

}
