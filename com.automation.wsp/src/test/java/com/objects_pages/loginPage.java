package com.objects_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement Login_Tab;
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement Register_Tab;
	//Locating text present on the top of the video screen
	@FindBy(xpath="//div[contains(text(),'Onboard to Handcraft')]")
	WebElement Text1;
	@FindBy(xpath="//div[contains(text(),'Your career together, Live.')]")
	WebElement Text2;


	//Error message present in Login page
	@FindBy(xpath="//mat-error/div")
	WebElement Error_Invalid_MailId;


	//@FindBy(xpath="//div[contains(text(),'Required fields cannot be empty')]")
	@FindBy(xpath="")
	WebElement Error_MandatoryFieldRequired;


	//Locating elements present under footer part and header part of login page

	@FindBy(xpath="//div[@class='footer-div container-fluid']/div[2]//a[contains(text(),'Privacy Policy')]")
	WebElement Privacy_policy;
	@FindBy(xpath="//div[@class='footer-div container-fluid']/div[2]//div/a[contains(text(),'Terms and Conditions')]")
	WebElement TermsAndConditions;
	@FindBy(xpath="//div[@class='footer-div container-fluid']/div[2]//div[contains(text(),'Copyright Workstreets Internet Technology Pvt Ltd')]")
	WebElement Copyright;


	@FindBy(xpath="//a/img[contains(@class,'logo')]")
	WebElement Workstreets_Logo;

	@FindBy(xpath="//a[contains(text(),'Learnathon')]")
	WebElement Learnathon_Link;

	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement About_Link;


	//Logout webelements

	@FindBy(xpath="//mat-icon[contains(text(),'keyboard_arrow_down')]")
	WebElement logoutArrow;

	//@FindBy(xpath="//button/mat-icon[@class='menu-icon mat-icon']")
	@FindBy(xpath="//div[@class='mat-menu-content']/button")
	WebElement Logout;
	
	@FindBy(xpath="//span[contains(text(),'Got')]")
	WebElement gotItButton;
	
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
		String em = Email.getAttribute("aria-invalid");
		String pa = Password.getAttribute("aria-invalid");
		if(em.contains("true"))
			return true;
		else
			return false;
	}

	//Generic login method for all user
	public void EnterValidLogin(String filename,String sname,String Username,String Password)
	{
		try {
			gotItButton.click();
			Thread.sleep(1000);
			Login_Tab.click();
			Email.sendKeys(getExceldata(filename, sname,Username));
			this.Password.sendKeys(getExceldata(filename, sname,Password));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, "Email and Password details not provided in the excel sheet");
		}
		LoginBtn.click();
	}

	public void EnterCandidateLoginCapturedData(String username, String password)
	{
		try {
			gotItButton.click();
			Thread.sleep(1000);
			Login_Tab.click();
			Email.sendKeys(username);
			this.Password.sendKeys(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, "Could not login with the captured candidate Email and Password details");
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
		try {
			return Workstreets_Logo.isDisplayed();
		}catch(Exception e) {
			return false;
		}

	}
	public boolean LearnathonLink()
	{
		try {
			return Learnathon_Link.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	} 
	public boolean About_link()
	{
		try {
			return About_Link.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	//Verify footer part element present in Login page
	public boolean Copyright()
	{
		try {
			return Copyright.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public boolean PrivacyPolicy()
	{
		try {
			return Privacy_policy.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public boolean TermsAndCondition()
	{
		try {
			return TermsAndConditions.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	//Verify element present under login page body
	public boolean OnboardToHandCraft()
	{
		try {
			return Text1.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public boolean Your_Career_Together_live()
	{
		return Text2.isDisplayed();
	}
	public boolean LoginTab()
	{
		try {
			gotItButton.click();
			Thread.sleep(1000);
			return Login_Tab.isDisplayed();
		}catch(Exception e) {
			return false;
		}

	}
	public boolean RegisterTab()
	{
		try {
			gotItButton.click();
			Thread.sleep(1000);
			return Register_Tab.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	public void clickOnLoginTab() throws InterruptedException {
		gotItButton.click();
		Thread.sleep(1000);
		Login_Tab.click();
	}
	public boolean Login_Text1()
	{
		try {

			return Text1_Under_LoginSection.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public boolean Login_Text2()
	{
		try {

			return Text2_Under_LoginSection.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public boolean Email()
	{
		try {

			return Email.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public boolean Password()
	{
		try {

			return Password.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public boolean Login_Button()
	{
		try {

			return LoginBtn.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	public boolean ForgotPasswordLink()
	{
		try {

			return ForgotPwd.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}


	public void logout() throws InterruptedException{
		Thread.sleep(1000);
		wait_for_elementpresent(logoutArrow);
		logoutArrow.click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(Logout).click().perform();
		//Logout.click();
	}




}
