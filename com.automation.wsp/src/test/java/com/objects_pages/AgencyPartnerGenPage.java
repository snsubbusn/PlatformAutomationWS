package com.objects_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.controller.Action_Method;

public class AgencyPartnerGenPage extends Action_Method{

	@FindBy(xpath="//a//span")
	WebElement NewAssignmentsTab;

	@FindBy(xpath="//div[contains(text(),'Active Assignments')]")
	WebElement activeAssignments;

	@FindBy(xpath="//div[contains(text(),'On Hold Assignments')]")
	WebElement onHoldAssignments;

	@FindBy(xpath="//div[contains(text(),'Closed Assignments')]")
	WebElement closedAssignments;

	@FindBy(linkText="Invited Candidates")
	WebElement invitedCandidatesTab;

	@FindBy(linkText="Dashboard")
	WebElement dashboardTab;

	//Assignments Page
	@FindBy(xpath="//app-pagination/span[@class='pagination-bottom']")
	WebElement paginationBottom;

	@FindBy(xpath ="//span[text()='Accept']")
	WebElement acceptButtonGeneral;


	@FindBy(xpath="(//span[text()='Accept']//ancestor::mat-card//a)[1]")
	WebElement firstJobCardJobTitle;

	@FindBy(xpath="(//span[text()='Accept']//ancestor::mat-card//span)[1]")
	WebElement firstJobCardCompanyName;

	@FindBy(xpath="(//span[text()='Accept']//ancestor::mat-card//span)[2]")
	WebElement firstJobCardJobId;

	@FindBy(xpath="//button//i[contains(text(),'close')]")
	WebElement successMsgClose;

	@FindBy(xpath="(//mat-icon[text()='keyboard_arrow_down'])[1]")
	WebElement firstJobDownArrow;

	@FindBy(xpath="(//button/span[text()='Decline'])[1]")
	WebElement firstJobDecline;


	@FindBy(xpath="//div[@class='message-holder']")
	WebElement successMsgUserDetails;

	@FindBy(xpath="//div[contains(@class,'pull-left')]")
	WebElement jobDetailBackButton;



	//Functions for Agency Partner General page
	public boolean verifyAgentLogin() {
		if(NewAssignmentsTab.isDisplayed())
			return true;
		else
			return false;
	}


	public StringBuilder verifyAgentTabsandSubMenuPresent() {
		StringBuilder s = new StringBuilder();
		NewAssignmentsTab.click();
		s.append(NewAssignmentsTab.getText());
		s.append("; "+activeAssignments.getText()+"; "+onHoldAssignments.getText()+"; "+
				closedAssignments.getText()+"; "+invitedCandidatesTab.getText());
		return s;
	}

	public String verifySelectedAssignmentsPage() {
		return NewAssignmentsTab.getText();
	}

	public void clickOnActiveAssignments() {
		NewAssignmentsTab.click();
		Assert.assertEquals(true, activeAssignments.isDisplayed());
		activeAssignments.click();
	}

	public void clickOnOnHoldAssignments() {
		NewAssignmentsTab.click();
		Assert.assertEquals(true, onHoldAssignments.isDisplayed());
		onHoldAssignments.click();
	}

	public void clickOnClosedAssignments() {
		NewAssignmentsTab.click();
		Assert.assertEquals(true, closedAssignments.isDisplayed());
		closedAssignments.click();
	}

	public String getTotalRecordsofthePage() {
		try {
			String rec = paginationBottom.getText();
			String [] recd = rec.split(" ");
			return recd[5];		
		}catch(Exception e){
			return e.toString();
		}
	}

	public boolean verifyJobsAlignedtotheAgent() {
		try {
			return acceptButtonGeneral.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}


	public String getFirstJobCardDetails() {
		return firstJobCardJobTitle.getText()+"; "+firstJobCardCompanyName.getText()+"; "+firstJobCardJobId.getText();
	}

	public boolean clickOnFirstJobAcceptButton() {
		try{
			acceptButtonGeneral.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public void closeSuccessMsg() {
		successMsgClose.click();
	}

	public String clickOnFirstJobDeclineButton() {
		try{
			firstJobDownArrow.click();
			firstJobDecline.click();
			return successMsgUserDetails.getText();
		}catch(Exception e) {
			return e.toString();
		}
	}

	public boolean clickOnFirstJobDetail() {
		try {
			firstJobCardJobTitle.click();
			return jobDetailBackButton.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean clickOnBackButtonfromJobDetail() {
		try {
			jobDetailBackButton.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	

}
