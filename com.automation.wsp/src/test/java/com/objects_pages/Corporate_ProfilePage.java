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

	@FindBy(xpath="//div[@class='edit_profile']/mat-icon")
	WebElement profileEditButton;

	@FindBy(xpath="//h2[@class='app-header']")
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

	@FindBy(xpath="//div[contains(text(),' Required fields cannot be empty.')]")
	WebElement error_MandatoryFieldRequired;


	public String clickonProfileandVerifyProfilePage() throws InterruptedException {
		profileTab.click();
		Thread.sleep(3000);
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


	public String Error_Message_For_NoInputs() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{	
		try {
			profileEditButton.click();
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
			//wait_for_elementpresent(Error_MandatoryFieldRequired);
			return error_MandatoryFieldRequired.getText();
		} catch (Exception e) {
			return "NoError";
		}
	}

	public static void veriftText(String locatorValue, String s) {

		String s1=driver.findElement(By.xpath(locatorValue)).getText().trim();
		Assert.assertEquals(s,s1);


	}





}
