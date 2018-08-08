package com.objects_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class ForgotPasswordPage extends Action_Method
{
	//Identifying the xpath for Forgot password link
	@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
	WebElement ForgotpasswordLink;
	
	//Locating all the elements & text present in Forgot password pop_up
	@FindBy(xpath="//div[contains(text(),'Forgot Password')]")
	WebElement Forgotpassword_Text;
	
	@FindBy(xpath="//div[contains(text(),' Please enter your email address for the password reset link')]")
	WebElement Forgotpassword_Message;
	
	
	@FindBy(xpath="//auth-forgot-password-dialog[div[contains(text(),'Please enter your email address for the password reset link')]]//input")
	WebElement Forgotpassword_Email;
	
	@FindBy(xpath="//button[@id='undefined']")
	WebElement SendEmail;
	
	
	@FindBy(xpath="//auth-forgot-password-dialog[div[contains(text(),'Please enter your email address for the password reset link')]]//div[contains(text(),'Please enter a valid email')]")
	WebElement ErrorMsg_InvalidEmail;
	public void Click_On_ForgotPasswordlink()
	{
		ForgotpasswordLink.click();
	}
	public boolean ForgotPasswordText()
	{
		return Forgotpassword_Text.isDisplayed();
	}
	
	public boolean ForgotPasswordMessage()
	{
		return Forgotpassword_Message.isDisplayed();
	}
	
	public boolean ForgotPasswordEmail()
	{
		return Forgotpassword_Email.isDisplayed();
	}
	
	public boolean ForgotPasswordSendEmail_Btn()
	{
		return SendEmail.isDisplayed();
	}
	
	public boolean Verify_SendEmail_Btn()
	{
		wait_for_elementpresent(SendEmail);
		return SendEmail.isEnabled();
	}
	public void Enter_Inputs_for_Email(String email)
	{
		Actions act=new Actions(driver);
		act.moveToElement(Forgotpassword_Email).click().sendKeys(Keys.chord(email,Keys.TAB)).perform();
	}
	public void Click_On_SendMail()
	{
		SendEmail.click();
	}
	public boolean ErrorMessage()
	{
		return ErrorMsg_InvalidEmail.isDisplayed();
	}
	
}
