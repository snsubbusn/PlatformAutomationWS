package com.objects_pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.controller.Action_Method;

public class Corporate_ProfilePage extends Action_Method{


	//Locating elements of the landing page of Corporate

	@FindBy(xpath="//a[contains(text(),'Profile')]")
	WebElement profileTab;

	@FindBy(xpath="//section//div/h2")
	WebElement companyNameProfilePage;

	@FindBy(xpath="//div[@class='pull-right']//mat-icon[contains(text(),'mode_edit')]")
	WebElement profileEditButton;

	@FindBy(xpath="//section[@id='companyInfo']//h2")
	WebElement corporateProfileHeading;

	@FindBy(id="companyName")
	WebElement companyName;

	@FindBy(id="founded")
	WebElement foundedYear;

	@FindBy(id="website")
	WebElement website;

	@FindBy(id="industry")
	WebElement industry;

	@FindBy(id="email")
	WebElement email;

	@FindBy(xpath="//div[@class='mat-select-arrow']")
	WebElement companySize;

	@FindBy(xpath="//div/div/mat-option/span[1]")
	WebElement size0_50;

	@FindBy(xpath="//div/div/mat-option/span")
	WebElement size51_100;

	@FindBy(id="address")
	WebElement address;


	@FindBy(id="vision")
	WebElement aboutUs;

	@FindBy(id="mobileNo")
	WebElement mobileNo;

	@FindBy(xpath="//mat-icon[contains(text(),'add')]")
	WebElement mobAddButton;

	@FindBy(xpath="//mat-icon[contains(text(),'clear')]")
	WebElement mobCancel;


	@FindBy(id="next")
	WebElement nextButton;


	@FindBy(xpath="//div[contains(text(),'Success')]")
	WebElement companyInfoSuccessMsg;

	@FindBy(xpath="//div[contains(text(),'email')]")
	WebElement error_MandatoryFieldRequired;

	@FindBy(xpath="//button//i[contains(text(),'close')]")
	WebElement successMsgClose;

	//location

	//Add Inputs in the Office Locations 
	@FindBy(id="location")
	WebElement locationAddress;


	@FindBy(xpath="//div[@class='body ng-star-inserted']")
	WebElement addedLocation;

	@FindBy(xpath="//i[contains(text(),'delete')]")
	WebElement locationsDelete;

	@FindBy(xpath="//span[text()='Proceed']/ancestor::button")
	WebElement confirmProceed;

	@FindBy(xpath="//span[contains(text(),'Yes')]")
	WebElement alertbutton;

	@FindBy(xpath="//app-list-view-box-row[@ng-reflect-body='Bengaluru, Karnataka, India']//i[@class='material-icons'][contains(text(),'edit')]")
	WebElement LocEdit;

	@FindBy(xpath="//button[@id='addOffice']//span")
	WebElement AddButton;

	@FindBy(xpath="//section[text()=' View/Edit Company Details ']")
	WebElement viewEditCompanyDetailsSection;



	public String clickonProfileandVerifyProfilePage() throws InterruptedException {
		profileTab.click();
		Thread.sleep(3000);
		return companyNameProfilePage.getText();
	}

	public String getCompanyName() {
		return companyNameProfilePage.getText();
	}

	public void clickOnProfileEditBtn() {
		profileEditButton.click();
	}

	public String verifyProfileEditPage() {
		return corporateProfileHeading.getText();
	}

	public String enterCompanyInfoDetailsandClickNextButton() throws InterruptedException {
		//try{
		companyName.clear();
		companyName.sendKeys("WIPRO");
		foundedYear.clear();
		foundedYear.sendKeys("2000");
		website.clear();
		website.sendKeys("www.wipro.com");
		industry.clear();
		industry.sendKeys("Software and Services");
		email.clear();
		email.sendKeys("wipro@mailinator.com");
		companySize.click();
		wait_for_elementpresent(size51_100);
		size51_100.click();
		address.clear();
		address.sendKeys("wipro bangalore");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		aboutUs.clear();
		aboutUs.sendKeys("Wipro deliver you optimized business processes, enriched insights, smart applications and intelligent infrastructure by leveraging our expertise in integrating software, infrastructure, business processes, professional services, and industry ecosystems.");
		mobCancel.click();
		mobileNo.sendKeys("9952845872");
		mobAddButton.click();
		nextButton.click();
		return companyInfoSuccessMsg.getText();
		/*}catch(Exception e) {
			return "failure";
		}*/
	}

	public void clickOnEditCompanyDetailsSection() {
		viewEditCompanyDetailsSection.click();
	}
	
	public void clickOnNextButton() {
		nextButton.click();
	}

	public String Error_Message_For_NoInputs() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{	
		try {
			profileEditButton.click();
			Thread.sleep(2000);
			wait_for_elementpresent_Clickable(companyName);
			companyName.clear();
			companyName.sendKeys(" ");
			companyName.sendKeys(Keys.BACK_SPACE);
			email.clear();
			email.sendKeys("s");
			email.sendKeys(Keys.BACK_SPACE);
			//wait_for_elementpresent(NextButton);
			//scrollingToElementofAPage(NextButton);
			scrollingToBottomofAPage();
			nextButton.click();
			companyName.sendKeys(" ");
			//wait_for_elementpresent(Error_MandatoryFieldRequired);
			return error_MandatoryFieldRequired.getText();
		} catch (Exception e) {
			return "NoError"+e.toString();
		}
	}

	public static void veriftText(String locatorValue, String s) {

		String s1=driver.findElement(By.xpath(locatorValue)).getText().trim();
		Assert.assertEquals(s,s1);


	}


	//Office Locations
	Actions action = new Actions(driver);


	public boolean verifyLocationsPresent() {
		try {
			return locationsDelete.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	public String deleteOfficeLocationandAddNew() throws InterruptedException {
		successMsgClose.click();
		locationsDelete.click();
		Thread.sleep(1000);
		confirmProceed.sendKeys(Keys.TAB);
		confirmProceed.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		locationAddress.sendKeys("WIPRO Bengaluru");
		Thread.sleep(3000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		AddButton.click();
		Thread.sleep(2000);
		return addedLocation.getText();
	}

	public String addNewOfficeLocation() throws InterruptedException {
		locationAddress.sendKeys("WIPRO Bengaluru");
		Thread.sleep(3000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		AddButton.click();
		Thread.sleep(2000);
		return addedLocation.getText();
	}

	public boolean Verify_Edit_Office_Locations_Section() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		LocEdit.click();
		locationAddress.clear();
		locationAddress.sendKeys("Bengaluru");
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		wait_for_elementpresent_Clickable(AddButton);
		AddButton.click();
		return false;

	}

	public boolean Verify_Delete_Office_Locations_Section() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		locationsDelete.click();
		locationAddress.sendKeys("Bengaluru");
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		AddButton.click();
		return false;

	}

	public boolean Verify_Office_Locations_Error_Message() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{	
		locationAddress.sendKeys("Bengaluru");
		AddButton.click();
		return false;

	}

}
