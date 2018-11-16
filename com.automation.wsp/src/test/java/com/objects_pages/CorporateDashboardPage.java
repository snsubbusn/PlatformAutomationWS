package com.objects_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CorporateDashboardPage {
	
	@FindBy(xpath="//a[contains(text(),'Dashboard')]")
	WebElement dashboardTab;
	
	@FindBy(xpath="//div[contains(text(),'Active')]/preceding-sibling::div")
	WebElement activeJDs;
	
	@FindBy(xpath="//div[contains(text(),'Profiles Received')]/preceding-sibling::div")
	WebElement profilesReceived;
	
	@FindBy(xpath="//div[contains(text(),'Expenses')]/preceding-sibling::div")
	WebElement expenses;
	
	@FindBy(xpath="//div[contains(text(),'Offered')]/preceding-sibling::div")
	WebElement offered;
	
	@FindBy(xpath="//div[contains(text(),'Onboarded')]/preceding-sibling::div")
	WebElement onboarded;
	
	@FindBy(xpath="//div[contains(text(),'Total Money')]/preceding-sibling::div")
	WebElement totalMoneySaved;

	public void clickOnDashboardTab() {
		dashboardTab.click();
	}
	
	public String getGuranteedSubmissionsDetails() {
		String active = activeJDs.getText();
		String profiles = profilesReceived.getText();
		String expe = expenses.getText();
		return "Active JDs - "+active+"; Profiles Received - "+profiles+"; Expenses - "+expe;
	}
	
	public String getOnboardingDetails() {
		String off = offered.getText();
		String onbo = onboarded.getText();
		String total = totalMoneySaved.getText();
		return "Offered - "+off+"; Onboarded - "+onbo+"; TotalMoneySaved - "+total;
	}
}
