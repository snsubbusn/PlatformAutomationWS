package com.objects_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Corporate_WorkDesk_EngageAgencyPartnerPage 
{
	
	//Locating Work Desk tab
	@FindBy(xpath="//a[contains(text(),'Work Desk')]")
	WebElement WorkDeskTab;
	
	//Locating Engage Agency Partner Tab
	@FindBy(xpath="//a[span[contains(text(),'Engage Agency Partner')]]")
	WebElement EngageAgencyPartnerTab;
	
	
	
}
