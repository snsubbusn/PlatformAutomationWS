package com.objects_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class Corporate_Profile_Media extends Action_Method {
	
	@FindBy(xpath="//div[@class='video-overlay']")
	WebElement highlights;
	
	@FindBy(xpath="//mat-icon[contains(text(),'more_horiz')]")
	WebElement Settings;
	
	@FindBy(xpath="//section[@id='profileVideos']//mat-card[1]//mat-card-content[1]//div[1]//mat-icon[1]")
	WebElement AddVideo;
	
	@FindBy(xpath="//div[@class='btn btn-red btn-big transition-opacity']")
	WebElement NextButton;
	
	@FindBy(xpath="//div[@class='cdk-overlay-container']//div//button[1]")
	WebElement RetakeButton;

//	@FindBy(xpath="//div[@class='cdk-overlay-container']//div//button[2]")
//	WebElement DeleteButton;
	
	@FindBy(xpath="//section[@id='profileVideos']//mat-card[1]//mat-card-content[1]//div[1]//mat-icon[1]")
	WebElement AddButton;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement NextButton1;
	

	
	public boolean Corporate_Media_Profile() throws InterruptedException
	{	
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//wait_for_elementpresent(highlights);
		//wait_for_elementpresent_Clickable(highlights);
		//if(highlights.isDisplayed()==true)
		if(Settings.isDisplayed()==true)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(50, document.body.scrollheight)");
			NextButton1.click();
			return true;
		}
		else
			
//		wait_for_elementpresent_Clickable(Settings);
//		Settings.click();
//		RetakeButton.click();
//		wait_for_elementpresent_Clickable(NextButton);
//		NextButton1.click();
//		RetakeButton.click();
		
		return false;
		
	}

}
