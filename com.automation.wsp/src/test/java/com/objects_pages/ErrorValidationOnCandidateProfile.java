package com.objects_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class ErrorValidationOnCandidateProfile extends Action_Method {

	@FindBy(xpath="//div[@class='name-wrapper']//span/mat-icon[@class='mat-icon material-icons']")
	WebElement Edit_button;
	
	@FindBy(xpath="//div/label[@class=\"upload\"]/img")
	WebElement ViewCV_button;
	
	@FindBy(xpath= "//div/input[@type=\"file\"]")
	WebElement UpdateCV_filePath;
	
	@FindBy(xpath= "//button[text()='Update CV']")
	WebElement UpdateCV_Button;
	@FindBy(xpath="//div/span[@class=\"file_error\"]")
	WebElement InvalidCV_Format;
	
	@FindBy(xpath= "//span/i[text()=\"close\"]")
	WebElement Close;
	
	@FindBy(xpath="//div/input[@class= \"mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-dirty ng-touched ng-valid\"]")
	WebElement Profile_Headline;
	
	@FindBy(xpath= "//mat-error/span[@class=\"ng-star-inserted\"]")
	WebElement Headline_WarningMsg;
	
	@FindBy(xpath= "//div/input[@class= \"mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-pristine ng-valid ng-touched\"]")
	WebElement Name;
	
	@FindBy(xpath="//mat-error/span[@class=\"ng-star-inserted\"]")
	WebElement Name_WarningMSg;
	
	@FindBy(xpath="//div/input[@class=\"mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-pristine ng-valid ng-touched\"]")
	WebElement Birth_Date;
	
	@FindBy(xpath="//div/mat-error[@class=\"mat-error ng-star-inserted\" and @id=\"mat-error-60\"]")
	WebElement DateOfBirth_Warning;
	
	@FindBy(xpath= "//div/input[@class=\"mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-dirty ng-touched ng-valid\"]")
	WebElement Current_Location;
	
	@FindBy(xpath="//div/mat-error[contains(text(),'Invalid current location.')and @class=\"mat-error ng-star-inserted\"]")
    WebElement InvalidLocation_Error;
	
	@FindBy(xpath="//div/mat-error[contains(text(),' Please enter current location')]")
	WebElement NoLocationSelected_Error;
	
	@FindBy(xpath="//div/input[@class=\"mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-touched ng-dirty ng-invalid\"]")
	WebElement Language;
	
	@FindBy(xpath="//div/mat-error[contains(text(),' Invalid language.')]")
	WebElement InvalidTextInLanguage_Field;	
	
	@FindBy(xpath="//div/mat-error[contains(text(),' Please select language ')]")
	WebElement NoLanguage_Selected;
	
	@FindBy(xpath="//div/mat-error[contains(text(),' Maximum 5 languages are allowed.')]")
	WebElement Language_LimitError;
	
	@FindBy(xpath="//div/mat-error[contains(text(),' Language is already selected. ')]")
	WebElement Duplicate_Language;
	
	@FindBy(xpath="//div/input[@placeholder=\"Current Designation\" and @class =\"mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-valid\"]")
    WebElement Current_Designation;
	
	@FindBy(xpath="//mat-error/span[contains(text(),'Allowed Characters \"a-z A-Z\" ')]")
	WebElement Invalid_Designation;
	
	@FindBy(xpath="//mat-error/span[contains(text(),'Please enter current designation')]")
	WebElement No_Designation;
	
	@FindBy (xpath="//div/input[@class=\"mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-dirty ng-touched ng-valid\"]")
	WebElement Nearest_Landmark;
	
	@FindBy(xpath="//mat-error/span[contains(text(), ' Choose a valid address from the dropdown ')]")
	WebElement Invalid_LandmarkError;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement Info_Next;
	
	@FindBy(xpath="//div/input[@class=\"mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-touched ng-dirty ng-valid\"]")
	WebElement Relocation_Preference;
	
	@FindBy(xpath="//mat-error[contains(text(), ' Invalid relocation preference. ')]")
	WebElement RelocationPreference_ErrorForInvalidText;
	
	@FindBy(xpath="//mat-error[contains(text(), ' Please enter work experience in Years ')]")
	WebElement NoWorkExperience_YearsError;
	
	@FindBy(xpath="//mat-error[contains(text(), ' Please enter work experience in Months')]")
	WebElement NoWorkExperience_MonthsError;

	
	
}
