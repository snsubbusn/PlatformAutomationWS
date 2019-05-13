package com.objects_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;


public class Candidate_Edit_EducationdetailsPage extends Action_Method {
	

	//Locating elements of the landing page of Corporate
	
		@FindBy(xpath="//a[contains(text(),'Profile')]")
		WebElement profileTab;
		
		@FindBy(xpath="//div[contains(text(),'Profile Headline')]")
		WebElement Profile_Headline;
		
		@FindBy(xpath="//div[@class='name-wrapper']/div/span[2]")
		WebElement Edit_Button;
		
		@FindBy(xpath="//div[contains(text(),'Profile Information')]")
		WebElement ProfileInformationheading;

		@FindBy(xpath="//button[contains(text(),'Next')]")
		WebElement nextbutton;
		
		@FindBy(xpath="//h2[contains(text(),'Video Profile')]")
		WebElement verifyvideoheading;
		
		@FindBy(xpath="//span[contains(text(),'Next')]")
		WebElement nextbutton1;
		
//		Verify Education heading in the education page
		@FindBy(xpath="//h2[contains(text(),'Education')]")
		WebElement candidateeducationpage;
		
		@FindBy(xpath="//div/i[contains(text(),'delete')]")
		WebElement deleteclick;
		
		@FindBy(xpath="((//div[contains(text(),'Automation University')])[1]/following::div/i[contains(text(),'edit')])[1]")
		WebElement editclick;
		
		@FindBy(xpath="//span[contains(text(),'Proceed')]")
		WebElement deleteeducation;
		
		
		@FindBy(xpath="//span[contains(text(),'Next')]")
		WebElement nextbutton2;
		
		
		@FindBy(xpath="//input[@name='degree']")
		WebElement degree;
		
		@FindBy(xpath="//input[@name='university']")
		WebElement university;
							
		@FindBy(xpath="//span[contains(text(),'Vocational-Training')]")
		WebElement validdegree;
		
		@FindBy(xpath="//input[@name='specialization']")
		WebElement specialization;
		
		@FindBy(xpath="//input[@name='grade']")
		WebElement grade;
		
		@FindBy(xpath="//input[@formcontrolname='from_date']")
		WebElement fromdate;
		
		@FindBy(xpath="//input[@formcontrolname='to_date']")
		WebElement todate;
		
		@FindBy(xpath="//textarea[@name='description']")
		WebElement description;
		
		@FindBy(xpath="//button[@type='submit']")
		WebElement saveeducation;
		
		@FindBy(xpath="//div[@class='title-holder ng-star-inserted']")
		WebElement educationPageSavedSuccessMsg;
		
		@FindBy(xpath="//div[contains(text(),'Anna University')]")
		WebElement verifyuniversity; 
			
		@FindBy(xpath="//div[contains(text(),'B.Tech/B.E (From Top Ranked Colleges)')]")
		WebElement verifydegree; 
		
		@FindBy(xpath="//span[@title='B.Tech/B.E (From Top Ranked Colleges) | Computer Science']")
		WebElement verifydegreeinprofilepage; 
		
		@FindBy(xpath="//span[@title='Chartered Accountant (C.A.) | Information Science']")
		WebElement verifyediteddegreeinprofilepage;
		
		
		@FindBy(xpath="//span[contains(text(),'Anna University')]")
		WebElement verifyuniversityinprofilepage; 
		
		@FindBy(xpath="//span[contains(text(),'Antony University')]")
		WebElement verifyediteduniversityinprofilepage; 
		
		@FindBy(xpath="//div[contains(text(),'Education')]")
		WebElement educationtitle; 
		
		@FindBy(xpath="//mat-panel-title/span[contains(text(),'Vocational-Training')]")
		WebElement degreeundereducation; 
		
		@FindBy(xpath="//mat-panel-title/span[contains(text(),'Chartered Accountant (C.A.)')]")
		WebElement descriptionofeducation; 
		
		@FindBy(xpath="//div[contains(text(),'Bachellors degree with Computer science as major subject')]")
		WebElement descriptionundereducation; 
		
		@FindBy(xpath="//mat-panel-title/span[contains(text(),'Blu Przm')]")
		WebElement specializationundereducation; 
		
		@FindBy(xpath="//mat-panel-title/span[contains(text(),'Information Science')]")
		WebElement editedspecializationundereducation;
		
		//Click on Profile tab and verify profile headline text
		public boolean Verify_ProfileHeadline()
		{
			try
			{
				return Profile_Headline.isDisplayed();
			}
			catch( Exception e)
			{
				return false;
			}
		}
		public boolean Verify_EditButton()
		{
			try
			{
				return Edit_Button.isDisplayed();
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		public boolean navigatetoeducation() {
			Edit_Button.click();
			nextbutton.click();
			nextbutton1.click();
		    candidateeducationpage.isDisplayed();
		    return true;
		}
		
		
	//Add New education
				public String addneweducation() throws InterruptedException {
				{
				degree.sendKeys("Vocational-Training");
				Actions action1 = new Actions(driver);
				action1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
				university.sendKeys("Automation University");
			    specialization.sendKeys("Blu Przm");
			    grade.sendKeys("1st Class with Distinction");
			    fromdate.click();
			    fromdate.sendKeys("4/9/2017");
			    todate.click();
			    todate.sendKeys("4/13/2019");
			    description.click();
			    description.sendKeys("Bachellors degree with Computer science as major subject");
			    saveeducation.click();
			    Thread.sleep(4000);
			    return educationPageSavedSuccessMsg.getText();
			    }
				}
			
				//Verify education is displayed in profile page
				public String clickonProfileandVerifyeducation() {
				    profileTab.click();
				    wait_for_elementpresent(degreeundereducation);
				    degreeundereducation.isDisplayed();
				    degreeundereducation.click();
				    return descriptionundereducation.getText();
				    
				   }
				
				//Update already added education and verify profile page
				public boolean updateeducation() throws InterruptedException  {
					profileTab.click();
					navigatetoeducation();
					Thread.sleep(2000);
					editclick.click();
					degree.clear();
					degree.sendKeys("Chartered Accountant (C.A.)");
					Actions action1 = new Actions(driver);
					action1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
					university.clear();
				    university.sendKeys("Antony University");
				    specialization.click();
				    specialization.clear();
				    specialization.sendKeys("Information Science");
				    grade.click();
				    grade.clear();
				    grade.sendKeys("70% in accademics");
				    description.click();
				    description.sendKeys("Bachellors degree with Computer science as major subject");
				    saveeducation.click();
				    Thread.sleep(4000);
				    educationPageSavedSuccessMsg.isDisplayed();
				    return true;
					}
				    			

				//Verify Updated education is displayed in profile page
				public boolean clickonProfileandVerifyupdatededucation() {
					    profileTab.click();
					    verifyediteddegreeinprofilepage.isDisplayed();
					    verifyediteduniversityinprofilepage.isDisplayed();
					    educationtitle.isDisplayed();
					    descriptionundereducation.getText();
					    editedspecializationundereducation.isDisplayed();
					    return educationtitle.isDisplayed();
						
					}
				
				
				//Delete already added education and verify profile page
				public String deleteeducation() {
					
					Edit_Button.click();
					nextbutton.click();
					nextbutton1.click();
					deleteclick.click();	
					deleteeducation.click();
					return educationPageSavedSuccessMsg.getText();
					}
						
					//Verify deleted education in profile page	
				public boolean clickonProfileandVerifydeletededucationinProfilePage() {
					try {
					profileTab.click();
					verifyediteduniversityinprofilepage.isDisplayed();
					return true;
					}
					catch(Exception e) {
						return false;
					}
}
}

					
				
				
			