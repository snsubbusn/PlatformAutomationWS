package com.objects_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class WSAdminGenPage extends Action_Method{

	//Elements that are present in the WS Admin landing page.
	@FindBy(xpath="//a[contains(text(),'Invite')]")
	WebElement inviteTab;
	
	@FindBy(xpath="//span[contains(text(),'Jobs')]")
	WebElement jobsTab;
	
	@FindBy(xpath="//a[contains(text(),'Users')]")
	WebElement usersTab;
	
	@FindBy(xpath="//a[contains(text(),'Proxy')]")
	WebElement proxyTab;
	
	
	@FindBy(xpath="//div[div[contains(text(),'Filter')]]//span/span")
	WebElement filterSelectedValue;
	
	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Candidate')]")
	WebElement filterCandidate;
	
	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Corporate Admin')]")
	WebElement filterCorpAdmin;
	
	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Agency Partner')]")
	WebElement filterAgencyPartner;
	
	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'None')]")
	WebElement none;
	
	
	@FindBy(xpath="//div[div[contains(text(),'Sort')]]//span/span")
	WebElement sortSelectedValue;
	
	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Name')]")
	WebElement name;
	
	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Status')]")
	WebElement status;
	
	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Invited On')]")
	WebElement invitedOn;
	
	@FindBy(xpath="//div[@class='add-button ng-star-inserted']//button/span/mat-icon")
	WebElement addButton;
	
	@FindBy(xpath="//span[contains(text(),'Select')]/ancestor::label//input")
	WebElement selectAllCheckBox;
	
	
	@FindBy(xpath="//span[contains(text(),'Send Rem')]")
	WebElement sendRemainder;
	
	//Methods for WS Admin scenarios.
	
	public String verifyWSAdminHomePagebyGettingTabDetails() {
		String a=null;
		try {
			if(inviteTab.isDisplayed()) {
				a="\""+inviteTab.getText()+"\"";
			}
			if(jobsTab.isDisplayed()) {
				a=a+"\""+jobsTab.getText()+"\"";
			}
			if(usersTab.isDisplayed()) {
				a=a+"\""+usersTab.getText()+"\"";
			}
			if(proxyTab.isDisplayed()) {
				a=a+"\""+proxyTab.getText()+"\"";
			}
		}catch(Exception e) {
			a="Either 'Invite' or 'Jobs' or 'Users' or 'Proxy' tab is missing";
		}		
		return a;
	}
	
	
	public String getDefaultFilterValue() {
		return filterSelectedValue.getText();
	}
	
	public String getDefaultSortValue() {
		return sortSelectedValue.getText();
	}
	
	
	public boolean checkforAddButton() {
		return addButton.isDisplayed();
	}
	
	public String filterCandidate() {
		filterSelectedValue.click();
		filterCandidate.click();
		return filterSelectedValue.getText();
	}
	
	public String filterCorporate() {
		filterSelectedValue.click();
		filterCorpAdmin.click();
		return filterSelectedValue.getText();
	}
	
	public String checkSelectAllCheckboxState() {
		return selectAllCheckBox.getAttribute("aria-checked");
	}
	
	public int getCountOfCandidates() {
		List <WebElement> can = driver.findElements(By.xpath("//div[@class='header-parent']//span[contains(text(),'Candidate')]"));
		return can.size();
	}
	
	public int getCountOfCorporates() {
		List <WebElement> can = driver.findElements(By.xpath("//div[@class='header-parent']//span[contains(text(),'Corporate')]"));
		return can.size();
	}
	
	public int getCountOfAgents() {
		List <WebElement> can = driver.findElements(By.xpath("//div[@class='header-parent']//span[contains(text(),'Agency')]"));
		return can.size();
	}
	
}
