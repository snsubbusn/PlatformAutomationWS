package com.objects_pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgencyInviteNewPage {

	//Elements of Invite New Page under My Assignements of Agency partner
	@FindBy(xpath="//button[text()='Invite']")
	WebElement inviteButton;

	@FindBy(xpath="//mat-error/span[contains(text(),'Resume')]")
	WebElement resumeError;

	@FindBy(xpath="//mat-error/span[contains(text(),'headline')]")
	WebElement headlineError;

	@FindBy(xpath="//mat-error/span[contains(text(),'name')]")
	WebElement nameError;

	@FindBy(xpath="//mat-error[contains(text(),'current location')]")
	WebElement currentLocationError;

	@FindBy(xpath="//mat-error[contains(text(),'birth')]")
	WebElement dobError;

	@FindBy(xpath="//mat-error[contains(text(),'gender')]")
	WebElement genderError;

	@FindBy(xpath="//mat-error/span[contains(text(),'phone')]")
	WebElement phoneError;

	@FindBy(xpath="//mat-error/span[contains(text(),'email')]")
	WebElement emailError;

	@FindBy(xpath="//mat-error/span[contains(text(),'designation')]")
	WebElement designationError;

	@FindBy(xpath="//mat-error[contains(text(),'language')]")
	WebElement languageError;

	@FindBy(xpath="//mat-error[contains(text(),'degree')]")
	WebElement degreeError;

	@FindBy(xpath="//mat-error/span[contains(text(),'specialization')]")
	WebElement specializationError;

	@FindBy(xpath="//mat-error/span[contains(text(),'University')]")
	WebElement universityError;

	@FindBy(xpath="//mat-error/span[contains(text(),'start date')]")
	WebElement startDateError;

	@FindBy(xpath="//mat-error/span[contains(text(),'end date')]")
	WebElement endDateError;

	@FindBy(xpath="//mat-error[contains(text(),'Years')]")
	WebElement yearsError;

	@FindBy(xpath="//mat-error[contains(text(),'Months')]")
	WebElement monthsError;

	@FindBy(xpath="//input[@formcontrolname='headLine']")
	WebElement headLine;

	@FindBy(xpath="//input[@type='file']")
	WebElement uploadResume;

	@FindBy(xpath="//input[@formcontrolname='name']")
	WebElement name;

	@FindBy(xpath="//input[@formcontrolname='currentLocation']")
	WebElement currentLocation;

	@FindBy(xpath="//input[@formcontrolname='dob']")
	WebElement dob;

	@FindBy(xpath="//span[text()='Gender']")
	WebElement gender;

	@FindBy(xpath="//span[contains(text(),'Male')]")
	WebElement male;

	@FindBy(xpath="//input[@formcontrolname='phone']")
	WebElement phone;

	@FindBy(xpath="//input[@formcontrolname='email']")
	WebElement email;

	@FindBy(xpath="//input[@formcontrolname='current_designation']")
	WebElement current_designation;

	@FindBy(xpath="//input[@formcontrolname='languages']")
	WebElement languages;

	@FindBy(xpath="//input[@formcontrolname='degree']")
	WebElement degree;

	@FindBy(xpath="//input[@formcontrolname='specialization']")
	WebElement specialization;

	@FindBy(xpath="//input[@formcontrolname='university']")
	WebElement university;

	@FindBy(xpath="//input[@formcontrolname='from_date']")
	WebElement from_date;

	@FindBy(xpath="//input[@formcontrolname='to_date']")
	WebElement to_date;

	@FindBy(xpath="//input[@formcontrolname='exp_year']")
	WebElement exp_year;

	@FindBy(xpath="//input[@formcontrolname='exp_month']")
	WebElement exp_month;

	@FindBy(id="skillName")
	WebElement skillTitle;

	@FindBy(id="expYears")
	WebElement skillExpYears;

	@FindBy(id="expMonths")
	WebElement skillExpMonths;

	@FindBy(id="next")
	WebElement addSkillButton;
	
	@FindBy(xpath="(//mat-option/span)[1]")
	WebElement dropDownOption1;
	
	@FindBy(xpath="//div[@class='message-holder']")
	WebElement successMsgUserDetails;


	//Invited Tab
	@FindBy(id="Invited_Cloud_Roboto")
	WebElement noInvitesImage;
	
	
	public boolean clickOnInviteButton() {
		try {
			inviteButton.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public ArrayList<String> getAllErrorForBlankInvite(){
		ArrayList<String> a = new ArrayList<String>();
		a.add(resumeError.getText());
		a.add(headlineError.getText());
		a.add(nameError.getText());
		a.add(currentLocationError.getText());
		a.add(dobError.getText());
		a.add(genderError.getText());
		a.add(phoneError.getText());
		a.add(emailError.getText());
		a.add(designationError.getText());
		a.add(languageError.getText());
		a.add(degreeError.getText());
		a.add(specializationError.getText());
		a.add(universityError.getText());
		a.add(startDateError.getText());
		a.add(endDateError.getText());
		a.add(yearsError.getText());
		a.add(monthsError.getText());
		return a;		
	}


	public void enterCandidateDetailstoInvite() {
		headLine.sendKeys("An Experienced Candidate with 5 years of Experience in all relevant field");
		uploadResume.sendKeys("E:\\PlatformAutomation\\com.automation.wsp\\src\\main\\resources\\ResumeWithoutContact.docx");
		name.sendKeys("AutomationCandidate");
		currentLocation.click();
		dropDownOption1.click();
		dob.sendKeys("01/01/1990");
		gender.click();
		male.click();
		phone.sendKeys("8147506453");
		email.sendKeys("can1@nada.email");
		current_designation.sendKeys("Experienced");
		languages.click();
		dropDownOption1.click();
		degree.click();
		dropDownOption1.click();
		specialization.sendKeys("Special");
		university.sendKeys("University");
		from_date.sendKeys("01/01/2000");
		to_date.sendKeys("01/01/2004");
		exp_year.sendKeys("5");
		exp_month.sendKeys("5");
		skillTitle.sendKeys("Java");
		try{
			if(dropDownOption1.isDisplayed()) {
				dropDownOption1.click();
			}
		}
		catch(Exception e) {
			System.out.println("No first Element");
		}
		skillExpYears.sendKeys("2");
		skillExpMonths.sendKeys("2");
		addSkillButton.click();
	}
	
	public String getSuccessMsg() {
		return successMsgUserDetails.getText();
	}
	
	
	public boolean verifyCandidateInvitedUnderInvitedTab() {
		try {
			noInvitesImage.isDisplayed();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
