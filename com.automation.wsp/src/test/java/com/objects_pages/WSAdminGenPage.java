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
	
	@FindBy(xpath="(//div[@class='header-div']/following::div[@class='name-div'])[1]/span/a")
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


	public boolean checkforAddButton() {
		return addButton.isDisplayed();
	}

	public String verifyNewInvitesPage() throws InterruptedException {
		addButton.click();
		Thread.sleep(3000);
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
