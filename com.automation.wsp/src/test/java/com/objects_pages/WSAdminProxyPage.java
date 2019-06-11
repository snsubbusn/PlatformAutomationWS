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
	
	@FindBy(xpath="(//span[@class='mat-option-text'])[1]")
	WebElement selectItem;
	
	@FindBy(xpath="(//span[@class='mat-option-text'])[2]")
	WebElement item32PerPage;
	
	@FindBy(xpath="(//div[@class='corporate-name'])[1]")
	WebElement firstProxyCard;
	
	@FindBy(xpath="//a[@class='mat-tab-link mat-tab-label-active ng-star-inserted']")
	WebElement proxyCorpTab;
	
	@FindBy(xpath="//button[@class='back-btn mat-button ng-star-inserted']")
	WebElement backButton;
	
	@FindBy(xpath="//span[@class='mat-option-text' and text()=16]")
	WebElement defaultItemValue;
	
	@FindBy(xpath="//span[@class='pagination-bottom']")
	WebElement paginationBottom;
	
	@FindBy(xpath="//li/a[@title='Go to last page']")
	WebElement lastPage;
	
	@FindBy(xpath="//li/a[@class='arrow'  and @title='Go to first page']")
	WebElement firstPage;
	
	
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
		paginationBottom.isDisplayed();
		return true;
	}catch(Exception e) {
		return false;
	} }
	
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
	
	public String ProxyCorpTab() {
		return proxyTab.getText();
	}
	
}
