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

	@FindBy(xpath="//a[contains(text(),'Account Management')]")
	WebElement accoungtManagementTab;

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
	WebElement sortName;

	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Status')]")
	WebElement sortStatus;

	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Invited On')]")
	WebElement sortInvitedOn;

	@FindBy(xpath="//div[@class='add-button ng-star-inserted']//button/span/mat-icon")
	WebElement addButton;

	@FindBy(xpath="//span[contains(text(),'Select')]/following::label//input")
	WebElement selectAllCheckBox;


	@FindBy(xpath="//span[contains(text(),'Send Rem')]")
	WebElement sendRemainder;

	@FindBy(xpath="(//div[@class='header-div'])[1]/span")
	WebElement firstCardHeader;

	@FindBy(xpath="(//div[@class='header-div']/following::div[@class='name-div'])[1]/span/span")
	WebElement firstCardName;
	
	@FindBy(xpath="(//div[@class='header-div']/following::div[@class='name-div'])[1]/a")
	WebElement firstCardCorName;

	@FindBy(xpath="(//div[@class='header-div']/following::div[@class='name-div'])[1]//div[1]")
	WebElement firstCardInvitedOn;

	@FindBy(xpath="(//div[@class='header-div']/following::div[@class='name-div'])[1]//div[2]")
	WebElement firstCardInviteExpiryOn;

	@FindBy(xpath="//div[@class='row heading-block']//h2")
	WebElement newInviteHeading;

	@FindBy(xpath="//div[@class='invite email']")
	WebElement emailintheCard;

	@FindBy(xpath="//span[contains(text(),'9')]/ancestor::div[@class='mat-select-trigger']")
	WebElement itemsPerPageDropDowm;

	@FindBy(xpath="//div[text()='Items Per Page']/following::mat-select")
	WebElement selectedItemsPerPage;
	
	@FindBy(xpath="//span[contains(text(),'45')]")
	WebElement items45PerPage;

	@FindBy(xpath="//a[@title='Go to next page']")
	WebElement paginationNext;
	
	@FindBy(xpath="(//div/input)[4]")
	WebElement noOfLicenses;
	
	@FindBy(xpath="//div/button[contains(text(),'Update')]")
	WebElement updateLicenseButton;
	
	//Elements for Super Admin Account Management Tab
	
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
	
	@FindBy(xpath="//mat-chip[contains(text(),'Source One') and @class='chip-box mat-chip mat-primary mat-standard-chip ng-star-inserted']")
	WebElement Align_Agency_SourceOne;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement Savebutton;
	
	@FindBy(xpath="//div[@class='message-holder'  and contains(text(),'Success')]")
	WebElement Successmsg;
	
	@FindBy(xpath="//div[@class='am-element-detail ng-trigger ng-trigger-detailExpand']")
	WebElement Prefervendorlist;
	
	@FindBy(xpath="//div[contains(text(),'Active Jobs')]")
	WebElement Activejobs;
	
	@FindBy(xpath="//div//div[@class='mat-select-arrow-wrapper'][4]")
	WebElement Filterbycorp;
	
	//Methods for WS Admin scenarios.

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
			if(accoungtManagementTab.isDisplayed()) {
				a=a+"\""+accoungtManagementTab.getText()+"\"";
			}
		}catch(Exception e) {
			a="Either 'Invite' or 'Jobs' or 'Users' or 'Proxy' or 'Account Management' tab is missing";
		}		
		return a;
	}


	public String getDefaultFilterValue() {
		return filterSelectedValue.getText();
	}


	public boolean checkforAddButton() {
		return addButton.isDisplayed();
	}

	public String verifyNewInvitesPage() throws InterruptedException {
		Thread.sleep(1000);
		addButton.click();
		Thread.sleep(2000);
		return newInviteHeading.getText();
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

	public String filterAgent() {
		filterSelectedValue.click();
		filterAgencyPartner.click();
		return filterSelectedValue.getText();
	}

	public String getDefaultSortValue() {
		return sortSelectedValue.getText();
	}

	public String sortByName() {
		sortSelectedValue.click();
		sortName.click();
		return sortSelectedValue.getText();
	}

	public String sortByStatus() {
		sortSelectedValue.click();
		sortStatus.click();
		return sortSelectedValue.getText();
	}

	public String sortByInvitedOn() {
		sortSelectedValue.click();
		sortInvitedOn.click();
		return sortSelectedValue.getText();
	}

	public String getFirstCardDetails() {

		String head = firstCardHeader.getText();
		String name;
		try{ 
			name = firstCardName.getText();
		}catch(Exception e) {
			name = firstCardCorName.getText();
		}
		String inv = firstCardInvitedOn.getText();
		String exp = firstCardInviteExpiryOn.getText();
		String det = "Role - "+head+"; Name - "+name+"; "+inv+"; "+exp;
		return det;
	}


	public String checkSelectAllCheckboxState() {
		return selectAllCheckBox.getAttribute("aria-checked");
	}

	public int getCountOfCandidates() {
		List <WebElement> can = driver.findElements(By.xpath("//div[@class='header-parent']//span[contains(text(),'Candidate')]"));
		return can.size();
	}

	public int getCountOfCorporates() {
		List <WebElement> cor = driver.findElements(By.xpath("//div[@class='header-parent']//span[contains(text(),'Corporate')]"));
		return cor.size();
	}

	public int getCountOfAgents() {
		List <WebElement> agn = driver.findElements(By.xpath("//div[@class='header-parent']//span[contains(text(),'Agency')]"));
		return agn.size();
	}

	public void select45ItemsPerPage() {
		itemsPerPageDropDowm.click();
		items45PerPage.click();
	}
	
	//Methods for Super Admin
	
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
			//Successmsg.isDisplayed();
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
		
	public boolean searchForCorporateEmailandClickonCorporateToEdit(String email) {
		String page = driver.findElement(By.tagName("app-pagination")).getAttribute("ng-reflect-size");
		String item = selectedItemsPerPage.getAttribute("ng-reflect-model");
		for(int k=1; k<=Integer.parseInt(page); k++) {
			for(int i=1; i<=Integer.parseInt(item); i++) {
				if(driver.findElement(By.xpath("(//div[@class='invite email'])["+i+"]")).getText().equals(email)) {
					driver.findElement(By.xpath("(//a[contains(@href,'/admin/edit-invite')])["+i+"]")).click();
					return true;
				}
			}
			paginationNext.click();
		}

		return false;
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
	
	public boolean FilterbyCorporates() {
		Filterbycorp.click();
		return true;
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
	}
	
	public void updateLicenceCountofCorporate() throws InterruptedException {
		noOfLicenses.clear();
		noOfLicenses.sendKeys("22");
		
		/*String license = noOfLicenses.getText();
		if(Integer.parseInt(license)>20) {
			noOfLicenses.clear();			
			noOfLicenses.sendKeys(Integer.toString((Integer.parseInt(license)-1)));
		}else {
			noOfLicenses.clear();			
			noOfLicenses.sendKeys(Integer.toString((Integer.parseInt(license)+1)));
		}*/
		
		updateLicenseButton.click();		
	}

}
