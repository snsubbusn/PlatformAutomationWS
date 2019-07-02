package com.objects_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class WSAdminProxyPage extends Action_Method {

	//Elements of WS Admin Proxy page.
	@FindBy(xpath="//a[contains(text(),'Proxy')]")
	WebElement proxyTab;
	
	@FindBy(xpath="//button/span[contains(text(),'Got it!')]")
	WebElement cookieMsg;
	
	@FindBy(xpath="//div[@class='mat-select-arrow']")
	WebElement itemPerPage;
	
	@FindBy(xpath="(//div/a[@class='name'])[1]")
	WebElement firstActiveProxyCard;
	
	@FindBy(xpath="(//span[@class='mat-option-text'])[1]")
	WebElement selectItem;
	
	@FindBy(xpath="(//div[@class='mat-select-arrow-wrapper'])[2]")
	WebElement arrowClickFilter;
	
	@FindBy(xpath="(//div[@class='mat-select-arrow-wrapper'])[3]")
	WebElement arrowClick;
	
	@FindBy(xpath="(//span[@class='mat-option-text'])[1]")
	WebElement updatedDate;
	
	@FindBy(xpath="(//span[@class='mat-option-text'])[2]")
	WebElement postedDate;
	
	@FindBy(xpath="(//span[@class='mat-option-text'])[3]")
	WebElement title;
	
	@FindBy(xpath="(//span[@class='mat-option-text'])[2]")
	WebElement item32PerPage;
	
	@FindBy(xpath="(//div[@class='corporate-name'])[14]")
	WebElement firstProxyCard;
	
	@FindBy(xpath="//span/mat-icon[contains(text(),'add')]")
	WebElement postJobs;
	
	@FindBy(xpath="//span/span[contains(text(),'Active Jobs')]")
	WebElement activeJobs;
	
	@FindBy(xpath="(//span[@class='mat-option-text'])[1]")
	WebElement newJobs;
	
	@FindBy(xpath="(//span[@class='mat-option-text'])[3]")
	WebElement onholdJobs;
	
	@FindBy(xpath="(//span[@class='mat-option-text'])[4]")
	WebElement closedJobs;
	
	@FindBy(xpath="//a[@class='mat-tab-link mat-tab-label-active ng-star-inserted']")
	WebElement proxyCorpTab;
	
	@FindBy(xpath="(//button[@class='back-btn mat-button ng-star-inserted'])[2]")
	WebElement backButton;
	
	@FindBy(xpath="//button[@class='back-btn mat-button ng-star-inserted']")
	WebElement proxyExit;
	
	@FindBy(xpath="//span[@class='mat-option-text' and text()=16]")
	WebElement defaultItemValue;
	
	@FindBy(xpath="//span[@class='pagination-bottom']")
	WebElement paginationBottom;
	
	@FindBy(xpath="//li/a[@title='Go to last page']")
	WebElement lastPage;
	
	@FindBy(xpath="//li/a[@class='arrow'  and @title='Go to first page']")
	WebElement firstPage;
	
	@FindBy(xpath="//li/a[@title = 'Go to next page']")
	WebElement nextPage;
	
	
	public boolean acceptCookie()
	{
		cookieMsg.click();
		return true;
	}
	
	public boolean clickonProxy() {
		try {
			proxyTab.click();
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	public boolean verifyProxyCard()
	{ 	try {
		wait_for_elementpresent(paginationBottom);
		paginationBottom.isDisplayed();
		return true;
	}catch(Exception e) {
		return false;
	} }
	
	public boolean activeJobsDisplayed() {
		activeJobs.isDisplayed();
		return true;
	}
	
	public boolean ClickOn_ItemsPerPage()
	{
		itemPerPage.click();
		selectItem.click();
		return true;
	}
	
	public boolean verifyPagination()
	{	
		paginationBottom.isDisplayed();
		return true;
	}
	
	public String getDefaultItemsPerPage()
	{
		//DefaultItemValue.click();(items per page and pagination scripts make separate functions)
		String rec = paginationBottom.getText();
		String [] recd = rec.split(" ");
		return recd[3];
	}
	
	public Boolean select32ItemsPerPage() {
		//proxyTab.sendKeys(Keys.ESCAPE);
		itemPerPage.click();
		item32PerPage.click();
		return true;
	}
	
	public String getTotalRecordsofthePage() {
		String rec = paginationBottom.getText();
		String [] recd = rec.split(" ");
		return recd[5];
	}
	
	public boolean verifyLastPageEnabled() {
		try{
			//lastPage.click();
			return lastPage.isEnabled();
		}catch(Exception e) {
			return false;
		}
	}

	public boolean verifyFirstPageEnabled() {
		try{
			return firstPage.isEnabled();
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean verifyNextPageEnabled() {
		try{
			return nextPage.isEnabled();
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean clickOnNextPage() {
		try{
			nextPage.click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public String getFirstProxyCard() {
		return firstProxyCard.getText();
	}
	
	public boolean clickOnFirstProxyCard() {
		firstProxyCard.click();
		return true;
	}
	
	public String getProxyCorpTab() {
		return proxyCorpTab.getText();	
	}
	
	public boolean clickOnBackButton() {
		backButton.click();
		//proxyTab.getText();
		return true;
	}
	
	public boolean clickOnProxyExit() {
		proxyExit.click();
		//proxyTab.getText();
		return true;
	}
	
	public boolean clickOnUpdatedDate() {
		arrowClick.click();
		updatedDate.click();
		return true;
	}
	
	public boolean clickOnPostedDate() {
		arrowClick.click();
		postedDate.click();
		return true;
	}
	
	public boolean clickOnTitle() {
		arrowClick.click();
		title.click();
		return true;
	}
	
	public boolean clickOnNewJobs() {
		arrowClickFilter.click();
		newJobs.click();
		return true;
	}
	
	public boolean clickOnHoldJobs() {
		arrowClickFilter.click();
		onholdJobs.click();
		return true;
	}
	
	public boolean clickOnClosedJobs() {
		arrowClickFilter.click();
		closedJobs.click();
		return true;
	}
	
	public boolean clickOnAddButton() {
		postJobs.click();
		return true;
	}
	
	public String getFirstActiveProxyCardDetails() {
		return firstActiveProxyCard.getText();
	}
}
