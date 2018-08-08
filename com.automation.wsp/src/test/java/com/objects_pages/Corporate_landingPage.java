package com.objects_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Corporate_landingPage
{
	
	//Locating elements of the landing page of Corporate
	
	
	//Locators of Corporate users
	@FindBy(xpath="//*[@id=\"userNavs\"]/div/a[2]")
	WebElement PostVideoJD;
	
	
	//Metehods for corporate users
		public boolean VerifyPostVideoJDLink() {
			if(PostVideoJD.isDisplayed()) {
				return true;
			}else {
				return false;
			}
		}
		
		
		
		
	
	//Locators for Candidate Users
	
	
	// Methods for Candidate Users
		
		
	
	
	
	
	

}
