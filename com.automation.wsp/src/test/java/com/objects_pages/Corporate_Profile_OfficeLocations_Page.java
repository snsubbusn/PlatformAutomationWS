package com.objects_pages;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;

public class Corporate_Profile_OfficeLocations_Page extends Action_Method{

	//Add Inputs in the Office Locations 
	@FindBy(id="location")
	WebElement locationAddress;


	@FindBy(xpath="//section[@id='officeLocations']//div[@class='body ng-star-inserted']")
	WebElement addedLocation;

	@FindBy(xpath="//section[@id='officeLocations']//i[contains(text(),'delete')]")
	WebElement locationsDelete;
	
	@FindBy(xpath="//span[text()='Proceed']")
	WebElement confirmProceed;

	@FindBy(xpath="//span[contains(text(),'Yes')]")
	WebElement alertbutton;

	@FindBy(xpath="//app-list-view-box-row[@ng-reflect-body='Bengaluru, Karnataka, India']//i[@class='material-icons'][contains(text(),'edit')]")
	WebElement LocEdit;

	@FindBy(xpath="//button[@id='addOffice']//span")
	WebElement AddButton;


	
	@FindBy(xpath="//section[@id='solutionsOffered']//i[contains(text(),'delete')]")
	WebElement solutionsDelete;
	
	@FindBy(xpath="//section[@id='solutionsOffered']//div[@class='body ng-star-inserted']")
	WebElement addedSolution;

	//Add Solutions offered
	@FindBy(id="solutionType")
	WebElement typeDropDown;

	
	//Solution Type drop down values. Change the [3] to locate the value
	@FindBy(xpath="//mat-option[3]")
	WebElement typeDropDownValue3;
	

	@FindBy(id="title")
	WebElement Title;

	@FindBy(id="desc")
	WebElement Description;

	@FindBy(xpath="//button[@id='addSolutions']//span")
	WebElement solAddbutton;

	@FindBy(xpath="//button[@id='addSolutions']//span[@class='mat-button-wrapper']")
	WebElement SaveSolOffered;

	@FindBy(xpath="//div[@class='box-list-wrapper']//div[2]//app-list-view-box-row[1]//i[contains(text(),'delete')]")
	WebElement SolDelete1;

	@FindBy(xpath="//app-list-view-box-row[@ng-reflect-title='KPO / Research /Analytics']//i[@class='material-icons'][contains(text(),'delete')]")
	WebElement SolDelete;

	@FindBy(xpath="//app-list-view-box-row[@ng-reflect-title='KPO / Research /Analytics']//i[@class='material-icons'][contains(text(),'edit')]")
	WebElement SolEdit;

	@FindBy(xpath="//span[contains(text(),'Yes')]")
	WebElement alertbutton2;

	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement NextButton;

	@FindBy(xpath="//span[contains(text(),'Previous')]")
	WebElement PreviousButton;

	@FindBy(xpath="//button//i[contains(text(),'close')]")
	WebElement successMsgClose;

	Actions action = new Actions(driver);

	public boolean verifyLocationsPresent() {
		try {
			return locationsDelete.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	public String deleteOfficeLocationandAddNew() throws InterruptedException {
		locationsDelete.click();
		confirmProceed.click();
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

	
	public boolean verifySolutionsPresent() {
		try {
			return solutionsDelete.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public String deleteSolutionandAddNew() throws InterruptedException {
		solutionsDelete.click();
		confirmProceed.click();
		typeDropDown.click();
		typeDropDownValue3.click();
		Title.sendKeys("Internatonal Bussiness Machine");
		Description.sendKeys("Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, "
				+ "along with exposition, argumentation, and narration.");
		Description.sendKeys(Keys.TAB);
		solAddbutton.click();
		successMsgClose.click();
		return addedSolution.getText();
	}
	
	
	public String addNewSolution() {
		typeDropDown.click();
		typeDropDownValue3.click();
		Title.sendKeys("Internatonal Bussiness Machine");
		Description.sendKeys("Description is the pattern of narrative development that aims to make vivid a place, object, character, or group. Description is one of four rhetorical modes, "
				+ "along with exposition, argumentation, and narration.");
		Description.sendKeys(Keys.TAB);
		solAddbutton.click();
		successMsgClose.click();
		return addedSolution.getText();
	}
	

	public void clickNextButton() {
		NextButton.click();
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

	public boolean Verify_Edit_Solutions_Offered() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		SolEdit.click();
		Description.clear();
		Description.sendKeys("Solutions offered");
		wait_for_elementpresent(SaveSolOffered);
		scrollingToBottomofAPage();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		SaveSolOffered.click();
		return false;
	}
}






