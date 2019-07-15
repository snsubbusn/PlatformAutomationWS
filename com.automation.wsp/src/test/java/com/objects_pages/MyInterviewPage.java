package com.objects_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.controller.Action_Method;
import com.relevantcodes.extentreports.LogStatus;

public class MyInterviewPage extends Action_Method
{
	
	//Locating MyInterview frame
	/*@FindBy (xpath="//iframe[contains(@src,'testing.workstreets.com')]")
	WebElement MyInterview_Frame;
	*/
	@FindBy(xpath="//div[contains(@data-iframe-src, 'workstreets.com')]/iframe")
	WebElement MyInterview_Frame;
	
	//Changed the iframe locator (Siva)
	
	@FindBy(id="myInterview")
	WebElement MyInterview_Frame1;
	
	// Locating all elements present in My Interview
//	@FindBy(xpath="//div[@id='first-screen']/div[text()='Next']")
	
	@FindBy(xpath="//div[@class='btn btn-red btn-big transition-opacity']")
	WebElement First_Next_btn;
	
	@FindBy(id="tips-suggestion")
	WebElement checkTips;
	
	@FindBy(xpath="//button[text()='Start Recording']")
	WebElement Start_recording;
	@FindBy(xpath="//button[text()='Stop Recording']")
	WebElement Stop_recording;
	@FindBy(xpath="//div[@id='myinterview-review-btn']/div[text()='Next' and @id='goToNextStep']")
	WebElement Videocapture_Next;
	@FindBy(xpath="//div[@id= 'goToNextStep' and contains(text(), 'Finish')]")
	WebElement Submit;
	@FindBy(xpath="//div[@id='validateRecording']")
	WebElement Finish;
	
	
	public void VideoRecording_JobPost() throws InterruptedException
	{
		//Switch to MyInterview frame
		driver.switchTo().frame(MyInterview_Frame1);
		Thread.sleep(3000);
		driver.switchTo().frame(MyInterview_Frame);
		Thread.sleep(3000);
		//wait_for_elementpresent(First_Next_btn);
		//System.out.println(checkTips.getText());
		Actions act=new Actions(driver);
		act.moveToElement(First_Next_btn).click().perform();
		//First_Next_btn.click();
				wait_for_elementpresent(Start_recording);
		if (Start_recording.isDisplayed()){
		Start_recording.sendKeys(Keys.ENTER);
		//act.doubleClick(Start_recording).perform();

		System.out.println("start");
		}else {
			logger.log(LogStatus.FAIL, "Start Recording is not displayed");
		}
		logger.log(LogStatus.PASS, "Video recording Started for Company Back Ground");
		Thread.sleep(15000);
		Stop_recording.sendKeys(Keys.ENTER);
		wait_for_elementpresent(Videocapture_Next);
		Videocapture_Next.click();
		
		Start_recording.sendKeys(Keys.ENTER);
		logger.log(LogStatus.PASS,"Video recording Started for Job Role");
		Thread.sleep(15000);
		Stop_recording.sendKeys(Keys.ENTER);
		wait_for_elementpresent(Videocapture_Next);
		Videocapture_Next.click();
		wait_for_elementpresent(Start_recording);
		Start_recording.sendKeys(Keys.ENTER);
		logger.log(LogStatus.PASS, "Video recording Started for Must Have Skills");
		Thread.sleep(15000);
		Stop_recording.sendKeys(Keys.ENTER);
		wait_for_elementpresent(Videocapture_Next);
		Videocapture_Next.click();
		wait_for_elementpresent(Start_recording);
		Start_recording.sendKeys(Keys.ENTER);
		logger.log(LogStatus.PASS,"Video recording Started for The Career Growth");
		Thread.sleep(15000);
		wait_for_elementpresent(Stop_recording);
		Stop_recording.sendKeys(Keys.ENTER);
		wait_for_elementpresent(Submit);
		Submit.click();
		wait_for_elementpresent(Finish);
		Thread.sleep(2000);
		Finish.click();
		logger.log(LogStatus.PASS,"Video recorded and submited successfully");
		driver.switchTo().defaultContent();
	}
	
	public void candidateProfileVideoCapturing() throws InterruptedException
	{
		//Switch to MyInterview frame
		driver.switchTo().frame(MyInterview_Frame1);
		Thread.sleep(3000);
		driver.switchTo().frame(MyInterview_Frame);
		Thread.sleep(3000);
		//wait_for_elementpresent(First_Next_btn);
		//System.out.println(checkTips.getText());
		Actions act=new Actions(driver);
		act.moveToElement(First_Next_btn).click().perform();
		//First_Next_btn.click();
		wait_for_elementpresent(Start_recording);
		if (Start_recording.isDisplayed()){
		Start_recording.sendKeys(Keys.ENTER);
		}else {
			logger.log(LogStatus.FAIL, "Start Recording is not displayed");
		}
		logger.log(LogStatus.PASS, "Video recording Started for Personal, Edu. & Professional Intro");
		Thread.sleep(15000);
		Stop_recording.sendKeys(Keys.ENTER);
		wait_for_elementpresent(Videocapture_Next);
		Videocapture_Next.click();
		
		Start_recording.sendKeys(Keys.ENTER);
		logger.log(LogStatus.PASS,"Video recording Started for Job Role");
		Thread.sleep(15000);
		Stop_recording.sendKeys(Keys.ENTER);
		wait_for_elementpresent(Videocapture_Next);
		Videocapture_Next.click();
		wait_for_elementpresent(Start_recording);
		Start_recording.sendKeys(Keys.ENTER);
		logger.log(LogStatus.PASS, "Video recording Started for Must Have Skills");
		Thread.sleep(15000);
		Stop_recording.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		wait_for_elementpresent_Clickable(Submit);
		Submit.click();
		wait_for_elementpresent(Finish);
		Thread.sleep(2000);
		Finish.click();
		logger.log(LogStatus.PASS,"Video recorded and submited successfully");
		driver.switchTo().defaultContent();
	}
	
	/*public void candidateProfileNewVideoCapturing() throws InterruptedException
	{
		//Switch to MyInterview frame
		driver.switchTo().frame(MyInterview_Frame1);
		Thread.sleep(3000);
		driver.switchTo().frame(MyInterview_Frame);
		Thread.sleep(3000);
		//wait_for_elementpresent(First_Next_btn);
		//System.out.println(checkTips.getText());
		Actions act=new Actions(driver);
		act.moveToElement(First_Next_btn).click().perform();
		//First_Next_btn.click();
		wait_for_elementpresent(Start_recording);
		if (Start_recording.isDisplayed()){
		Start_recording.click();
		}else {
			logger.log(LogStatus.FAIL, "Start Recording is not displayed");
		}
		logger.log(LogStatus.PASS, "Video recording Started for Personal, Edu. & Professional Intro");
		Thread.sleep(15000);
		Stop_recording.click();
		wait_for_elementpresent(Videocapture_Next);
		Videocapture_Next.click();
		
		Start_recording.click();
		logger.log(LogStatus.PASS,"Video recording Started for Job Role");
		Thread.sleep(15000);
		Stop_recording.click();
		wait_for_elementpresent(Videocapture_Next);
		Videocapture_Next.click();
		wait_for_elementpresent(Start_recording);
		Start_recording.click();
		logger.log(LogStatus.PASS, "Video recording Started for Must Have Skills");
		Thread.sleep(15000);
		Stop_recording.click();
		Thread.sleep(2000);
		wait_for_elementpresent_Clickable(Submit);
		Submit.click();
		wait_for_elementpresent(Finish);
		Thread.sleep(2000);
		Finish.click();
		logger.log(LogStatus.PASS,"Video recorded and submited successfully");
		driver.switchTo().defaultContent();
	}*/
}
