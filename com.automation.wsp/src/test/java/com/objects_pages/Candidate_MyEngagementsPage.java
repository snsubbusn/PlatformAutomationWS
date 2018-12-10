package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class Candidate_MyEngagementsPage extends Action_Method{
	
	
	@FindBy(xpath="//a[contains(text(),'My Engagements')]")
	WebElement myEngagementsTab;
	
	@FindBy(xpath="//button/span[contains(text(),'Accept')]")
	WebElement acceptButton;
	
	public void clickonMyEngagements() {
		myEngagementsTab.click();
	}
	
	public String checkStatusofJob(String JobId) {
		return driver.findElement(By.xpath("(//mat-card[div[div[div[app-job-card-square-header[div[div[div[a[contains(@href,'job/"+JobId+"')]]]]]]]]]//button)[2]/span")).getText();

	}
	
	public String acceptSchedeuledInterview(String JobId) throws InterruptedException {
		driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[a[contains(@href,'job/"+JobId+"')]]]]]]]]]//button[span[contains(text(),'Interview')]]")).click();
		acceptButton.click();
		Thread.sleep(2000);
		return driver.findElement(By.xpath("(//mat-card[div[div[div[app-job-card-square-header[div[div[div[a[contains(@href,'job/"+JobId+"')]]]]]]]]]//button)[2]/span")).getText();

	}
	
	
	public String acceptOfferandJoin(String JobId) throws InterruptedException {
		driver.findElement(By.xpath("//mat-card[div[div[div[app-job-card-square-header[div[div[div[a[contains(@href,'job/"+JobId+"')]]]]]]]]]//button[span[contains(text(),'Offer')]]")).click();
		Thread.sleep(1000);
		acceptButton.click();
		Thread.sleep(1000);
		return driver.findElement(By.xpath("(//mat-card[div[div[div[app-job-card-square-header[div[div[div[a[contains(@href,'job/"+JobId+"')]]]]]]]]]//button)[2]/span")).getText();
	}

}
