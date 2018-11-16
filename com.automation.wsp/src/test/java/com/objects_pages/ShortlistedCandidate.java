package com.objects_pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.controller.Action_Method;

public class ShortlistedCandidate extends Action_Method {

	@FindBy(xpath="//span[contains(@class,'app-header ng-star-inserted')]")
	WebElement ShortlistedCandidatePageHeading;

	@FindBy(xpath="//span[contains(@class,'pull-left accent ng-star-inserted')]")
	WebElement CandidateProfileHeadlineBackButton;

	@FindBy(xpath="//button/span[contains(text(),'Schedule Interview')][1]")
	WebElement FirstScheduleInterviewButton;


	@FindBy(xpath="//mat-radio-button[2]")
	WebElement FixedSlot;

	@FindBy(xpath="//div[@class='mat-input-infix mat-form-field-infix']/input[@formcontrolname='fromDate']")
	WebElement FixedSlotDate;

	@FindBy(xpath="//div[@class='mat-input-infix mat-form-field-infix']/input[@id='time_Control']")
	WebElement FixedSlotTime;

	@FindBy(xpath="//div[@class='mat-input-infix mat-form-field-infix']/input[@id='time_Control']/following::button")
	WebElement FixedSlotScheduleButton;

	@FindBy(id="interviewRequested")
	WebElement InterviewRequested;

	@FindBy(xpath="//button/span[contains(text(),'Submit Feedback')]")
	WebElement submitFeedbackBtn;

	@FindBy(xpath="//button/span[contains(text(),'Interview Scheduled')]")
	WebElement interviewScheduled;
	
	@FindBy(id="comments")
	WebElement comments;


	@FindBy(xpath="//button/span[contains(text(),'Shortlist')]")
	WebElement shortlistBtn;
	
	@FindBy(xpath="//button/span[contains(text(),'Make')]")
	WebElement makeOffer;

	
	@FindBy(xpath="//div[@class='mat-input-infix mat-form-field-infix']/input[@formcontrolname='joiningDate']")
	WebElement joiningDate;
	
	@FindBy(id="billedCTC")
	WebElement billedCTC;
	
	@FindBy(xpath="//div[@class='row form-btn-container ng-star-inserted']/button/span[contains(text(),'Offer')]")
	WebElement offerBtn;
	
	
	@FindBy(id="offered")
	WebElement offeredBtn;
	
	@FindBy(id="joined")
	WebElement joinedBtn;
	
	@FindBy(xpath="//button/span[contains(text(),'Update')]")
	WebElement updateJoiningBtn;
	
	@FindBy(id="onboarded")
	WebElement onboardedbtn;
	
	@FindBy(xpath="//span[contains(@class,'pull-left accent')]")
	WebElement shortlistedCandidatesBackButton;
	
	
	
	public String getEmailOfFirstCandidate() {
		driver.findElement(By.xpath("//a[contains(@href,'candidate/profile')][1]")).click();
		String email = driver.findElement(By.xpath("//div[contains(text(),'Email')]/following::div[2]")).getText();
		CandidateProfileHeadlineBackButton.click();
		return email;
	}

	public boolean clickOnFirstScheduleInterview() {
		try {
			FirstScheduleInterviewButton.click();
			return FixedSlot.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

	public String scheduleFixedSlotInterview() throws InterruptedException {
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		String time = new SimpleDateFormat("hh:mm a").format(new Date(System.currentTimeMillis()+2*60*1000));
		Thread.sleep(1000);
		FixedSlot.click();
		Thread.sleep(1000);
		FixedSlotDate.sendKeys(date);
		FixedSlotTime.sendKeys(time);
		FixedSlotScheduleButton.click();
		Thread.sleep(2000);
		return InterviewRequested.getText();
	}


	public String waitandClickonSubmitFeedback() throws InterruptedException {
		try {
			while(interviewScheduled.isDisplayed()) {
				Thread.sleep(10000);
				driver.navigate().refresh();
			}
		}catch(NoSuchElementException e) {
			System.out.println("Submit feed back button is displayed.");
		}
		submitFeedbackBtn.click();
		Thread.sleep(1000);
		comments.sendKeys("Completed Interview and shortlisting the candidate");
		shortlistBtn.click();
		Thread.sleep(2000);
		return makeOffer.getText();
	}
	
	
	public String makeOffer() throws InterruptedException {
		makeOffer.click();
		Thread.sleep(1000);
		joiningDate.sendKeys(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		billedCTC.sendKeys("12345");
		offerBtn.click();
		return offeredBtn.getText();
	}
	
	
	public String onboardCandidatebyUpdateJoin() throws InterruptedException {
		joinedBtn.click();
		Thread.sleep(1000);
		try {
			updateJoiningBtn.click();
			Thread.sleep(1000);
			return onboardedbtn.getText();
		}catch(Exception e) {
			
			return "ad";
		}
	}
	
	public void goBacktoManageResponse() {
		shortlistedCandidatesBackButton.click();
		driver.navigate().refresh();
		
	}
}
