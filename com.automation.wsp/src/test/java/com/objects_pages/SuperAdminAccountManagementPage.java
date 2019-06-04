package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class SuperAdminAccountManagementPage extends Action_Method{
	
	@FindBy(xpath="//a[contains(text(),'Invite')]")
	WebElement inviteTab;

	@FindBy(xpath="//span[contains(text(),'Jobs')]")
	WebElement jobsTab;
	
	@FindBy(xpath="//div[contains(text(),'Active Jobs')]")
	WebElement Activejobs;

	@FindBy(xpath="//a[contains(text(),'Users')]")
	WebElement usersTab;

	@FindBy(xpath="//a[contains(text(),'Proxy')]")
	WebElement proxyTab;

	@FindBy(xpath="//div/a[contains(text(),'Account Management')]")
	WebElement AccManagementTab;
		
	@FindBy(xpath="//tr/th[contains(text(),'Corporate Name')]")
	WebElement CorpName;
		
	@FindBy(xpath="//tr/th[contains(text(),'Account Manager')]")
	WebElement AccMgrName;
		
	@FindBy(xpath="//tr/th[contains(text(),'Vendor Manager')]")
	WebElement VendorMgrName;
		
	@FindBy(xpath="//span[contains(text(),'Filters')]")
	WebElement Filtersbutton;
	
	@FindBy(xpath="(//div[@class='mat-form-field-infix']//input)[1]")
	WebElement FilterbyCorp;
	
	@FindBy(xpath="(//div[@class='mat-form-field-infix']//input)[2]")
	WebElement FilterbyAccMgr;
	
	@FindBy(xpath="(//div[@class='mat-form-field-infix']//input)[3]")
	WebElement FilterbyVdrMgr;
	
	@FindBy(xpath="(//div[@class='mat-form-field-infix']//input)[4]")
	WebElement FilterbyVendors;
	
	@FindBy(xpath="(//mat-option//span//div)[1]")
	WebElement FirstCorpPill;
	
	@FindBy(xpath="(//mat-option//span//div)[1]")
	WebElement FirstAccMgrPill;
	
	@FindBy(xpath="(//mat-option//span//div)[2]")
	WebElement FirstVdrMgrPill;
	
	@FindBy(xpath="(//mat-option//span//div)[2]")
	WebElement FirstVendorPill;
	
	@FindBy(xpath="//button/span[contains(text(),'Apply')]")
	WebElement Applyfilter;
	
	@FindBy(xpath="//button/span[contains(text(),'Clear Filter')]")
	WebElement Clearfilter;
	
	@FindBy(xpath="(//div[@class='mat-chip-list-wrapper']//mat-chip/mat-icon)[2]")
	WebElement deletefirstpill;
	
	@FindBy(xpath="(//span/mat-icon[contains(text(),'edit')])[1]")
	WebElement firstcorporateEdit;
	
	@FindBy(xpath="(//tbody//tr/td)[1]")
	WebElement firstcorpcard;
	
	@FindBy(xpath="//div[@class='mat-form-field-infix']/input[@placeholder='Vendor Managers']")
	WebElement EditVendorMgr;
	
	@FindBy(xpath="//div[@class='mat-form-field-infix']/input[@placeholder='Account Managers']")
	WebElement EditAccountMgr;
	
	@FindBy(xpath="(//mat-option/span)[1]")
	WebElement SelectVendorMgr;
	
	@FindBy(xpath="(//mat-option/span)[2]")
	WebElement SelectAccountMgr;
	
	@FindBy(xpath="//mat-chip/mat-icon[contains(text(),'clear')]")
	WebElement ClearVendorMgr;
	
	@FindBy(xpath="//div[contains(text(),'You can select maximum of 2 vendor managers')]")
	WebElement Vendormgrwarningmsg;
	
	@FindBy(xpath="//div[contains(text(),'You can select maximum of 1 account manager')]")
	WebElement accountmgrwarningmsg;
	
	@FindBy(xpath="//button/i[contains(text(),'close')]")
	WebElement closewarningmsg;
	
	@FindBy(xpath="//mat-chip[contains(text(),'Source One')]")
	WebElement Align_Agency_SourceOne;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement Savebutton;
	
	@FindBy(xpath="//div[@class='message-holder'  and contains(text(),'Success')]")
	WebElement Successmsg;
	
	@FindBy(xpath="//div[@class='am-element-detail ng-trigger ng-trigger-detailExpand']")
	WebElement Prefervendorlist;
	
	public String verifyWSAdminHomePagebyGettingTabDetails() {
		String a=null;
		try {
			if(inviteTab.isDisplayed()) {
				a="\""+inviteTab.getText()+"\", ";
			}
			if(jobsTab.isDisplayed()) {
				a=a+"\""+jobsTab.getText()+"\", ";
			}
			if(usersTab.isDisplayed()) {
				a=a+"\""+usersTab.getText()+"\", ";
			}
			if(proxyTab.isDisplayed()) {
				a=a+"\""+proxyTab.getText()+"\", ";
			}
			if(AccManagementTab.isDisplayed()) {
				a=a+"\""+AccManagementTab.getText()+"\"";
			}
		}catch(Exception e) {
			a="Either 'Invite' or 'Jobs' or 'Users' or 'Proxy' or 'Account Management' tab is missing";
		}		
		return a;
	}
	
	public boolean AccountManagementPage()
	{
		AccManagementTab.click();
		CorpName.isDisplayed();
		AccMgrName.isDisplayed();
		VendorMgrName.isDisplayed();
		firstcorpcard.click();
		return true;
	}
	public boolean ClearfilterforAccMgmnt() throws InterruptedException
	{
		Filtersbutton.click();
		FilterbyCorp.click();
		Thread.sleep(5000);
		FirstCorpPill.click();
		FilterbyAccMgr.click();
		FirstAccMgrPill.click();
		FilterbyVdrMgr.click();
		FirstVdrMgrPill.click();
		FilterbyVendors.click();
		FirstVendorPill.click();
		Clearfilter.click();
		Filtersbutton.click();
		return true;
	}
	
	public boolean ApplyfilterforAccMgmnt() throws InterruptedException
	{
		Filtersbutton.click();
		Thread.sleep(5000);
		FilterbyCorp.click();
		//Thread.sleep(5000);
		FirstCorpPill.click();
		FilterbyAccMgr.click();
		FirstAccMgrPill.click();
		FilterbyVdrMgr.click();
		FirstVdrMgrPill.click();
		FilterbyVendors.click();
		FirstVendorPill.click();
		Applyfilter.click();
		return true;
	}
	
	public boolean deleteselectedpill()
	{
		deletefirstpill.click();
		return true;
	}
	
	public boolean ClickOnEditbutton() throws InterruptedException
	{
		firstcorporateEdit.click();
		return true;
	}
	
	public boolean Editvendor()
	{	
		EditVendorMgr.click();
		SelectVendorMgr.click();
		return true;
	}
	
	public boolean Editaccmgr()
	{	
		EditAccountMgr.click();
		SelectAccountMgr.click();
		return true;
	}
	public boolean Verify_VendorMgrWarningmsg()
	{
		Vendormgrwarningmsg.isDisplayed();
		return true;
	}
	
	public boolean Verify_AccountMgrWarningmsg()
	{
		accountmgrwarningmsg.isDisplayed();
		return true;
	}
	
	public boolean Close_Warningmsg()
	{
		closewarningmsg.click();
		return true;
	}
	
	public boolean Align_An_Agency()
	{
		try 
		{
			wait_for_elementpresent(Align_Agency_SourceOne);
			Align_Agency_SourceOne.click();
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}
	
	public boolean Save_EditedAccMgmntdetails()
	{
		Savebutton.click();
		Successmsg.isDisplayed();
		return true;
	}
	
	public boolean Verify_CorporateCardViewed()
	{	try {
				firstcorpcard.isEnabled();
				return true;
			}
			catch(Exception e) {
				return false;
			}
	}
	
	public boolean PreferredVendorDropdown()
	{
		Prefervendorlist.isDisplayed();
		return true;
	}
	
	public boolean goToJobspage()
	{
		jobsTab.click();
		Activejobs.click();
		return true;
	}
	
	public String getfirstcorporate() {
		return firstcorpcard.getText();
	}
	
	public void setfirstcorporate() {
		String corp1 = getfirstcorporate();
		  filterWithGivenCorporate(corp1) ;
	}
	
	
		
	
	public void filterWithGivenCorporate(String corp) {
		int count = driver.findElements(By.xpath("//div[@class='cdk-overlay-pane']//mat-option")).size();
		for(int i=1; i<count; i++) {
			if(driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']//mat-option["+i+"]/span")).getText().equals(corp)) {
				driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']//mat-option["+i+"]/span")).click();
			}
		}
		
		//div[@class='cdk-overlay-pane']//mat-option/span
	}
}
