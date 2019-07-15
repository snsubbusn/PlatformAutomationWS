package com.objects_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class AgencyPartnerInvitedCandidatePage extends Action_Method{


	@FindBy(linkText="Invited Candidates")
	WebElement invitedCandidatesTab;

	@FindBy(xpath="//app-pagination/span[@class='pagination-bottom']")
	WebElement paginationBottom;

	@FindBy(xpath="//div[div[contains(text(),'Sort')]]//span/span")
	WebElement sortSelectedValue;

	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Name')]")
	WebElement sortName;

	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Status')]")
	WebElement sortStatus;

	@FindBy(xpath="//div[@class='cdk-overlay-container']//span[contains(text(),'Invited On')]")
	WebElement sortInvitedOn;

	@FindBy(xpath="//span[contains(text(),'Select')]/following::label//input")
	WebElement selectAllCheckBox;


	@FindBy(xpath="//span[contains(text(),'Select')]/following::label//input/parent::div")
	WebElement selectAllCheckBoxClick;

	@FindBy(xpath="//button[contains(text(),'Send Rem')]")
	WebElement sendRemainder;

	@FindBy(xpath="(//div[contains(@class,'candidate-cards-div')]/descendant::div[@class='name-div'])[1]/a")
	WebElement firstCardJoinedName;

	@FindBy(xpath="(//div[contains(@class,'candidate-cards-div')]/descendant::div[@class='name-div'])[1]/span/span")
	WebElement firstCardNotJoinedName;

	@FindBy(xpath="//span[contains(text(),'9')]/ancestor::div[@class='mat-select-trigger']")
	WebElement itemsPerPageDropDowm;

	@FindBy(xpath="//div[text()='Items Per Page']/following::mat-select")
	WebElement selectedItemsPerPage;

	@FindBy(xpath="//span[contains(text(),'45')]")
	WebElement items45PerPage;

	@FindBy(xpath="//a[@title='Go to next page']")
	WebElement paginationNext;

	@FindBy(xpath="//div[contains(@class,'status')]/b")
	WebElement status;

	@FindBy(xpath="//app-pagination")
	WebElement pagination;

	@FindBy(xpath="//button//i[contains(text(),'close')]")
	WebElement successMsgClose;

	@FindBy(xpath="//div[contains(text(),'Reminders Sent Successfully')]")
	WebElement remainderSuccessMsg;

	//Candidate profile page
	@FindBy(xpath="//div[@class='name-wrapper']//div[@class='heading']")
	WebElement candName;

	@FindBy(xpath="//div[text()=\"Email\"]/following-sibling::div[2]")
	WebElement candEmail;


	//Functions for Invited Candidate Page of Agency Partner
	public void clickOnInvitedCandidatesTab() {
		invitedCandidatesTab.click();
	}

	public String verifyInvitedCandidatesTabisSelected() {
		return invitedCandidatesTab.getAttribute("ng-reflect-active");
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
		try {
			String name = firstCardJoinedName.getAttribute("href") ;
			if(name.contains("profile"))
		    {
		    	System.out.println("Joined card");
		    	String candJoinedName = firstCardJoinedName.getText();
		    	return candJoinedName;
		    }
		    else
		    {
		    	System.out.println("not joined card");
		    	String candNotJoinedName = firstCardNotJoinedName.getText();
		    	return candNotJoinedName;
		    }
		}catch(Exception e) {
			return "FAILED";
		}
	}


	public String checkSelectAllCheckboxState() {
		return selectAllCheckBox.getAttribute("aria-checked");
	}


	public void select45ItemsPerPage() {
		itemsPerPageDropDowm.click();
		items45PerPage.click();
	}

	public boolean selectFirstPendingStatusCandidate() {
		try{
			int pageSize = Integer.parseInt(pagination.getAttribute("ng-reflect-size"));
			for(int i=0; i<=pageSize; i++) {
				for(int j =1; j<=9; j++) {
					WebElement stat = driver.findElement(By.xpath("(//div[contains(@class,'status')]/b)["+j+"]"));
					if(stat.getText().equalsIgnoreCase("Pending")) {
						selectAllCheckBoxClick.click();
						return true;
					}
				}
				paginationNext.click();
			}
		}catch(Exception e) {
			return false;
		}
		return false;
	}

	public String clickAndVerifySendReminder() {
		sendRemainder.click();
		String msg = remainderSuccessMsg.getText();
		successMsgClose.click();
		return msg;
	}

	public boolean selectFirstJoinedStatusCandidate() {
		int pageSize = Integer.parseInt(pagination.getAttribute("ng-reflect-size"));
		for(int i=0; i<=pageSize; i++) {
			for(int j =1; j<=9; j++) {
				WebElement stat = driver.findElement(By.xpath("(//div[contains(@class,'status')]/b)["+j+"]"));
				if(stat.getText().equalsIgnoreCase("Joined")) {
					driver.findElement(By.xpath("(//div[contains(@class,'status')]/b)["+j+"]/preceding::div[@class='name-parent-div']//a[contains(@href,'candidate')]")).click();
					return true;
				}
			}
			paginationNext.click();
		}
		return false;
	}

	public String getCandidateDetails() {
		try {
			return "Candidate Name : "+candName.getText()+"; Candidate Email : "+candEmail.getText();
		}catch(Exception e) {
			return e.toString();
		}
	}

}
