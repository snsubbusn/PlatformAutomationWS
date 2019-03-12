package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Corporate_ProfilePage;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC_002_Verify_Corporate_Company_Info_Error_Notification extends Action_Method{
	
	
	public void Verify_Corporate_Company_Info_Page_Dataisdisplayed() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		logger = extent.startTest("TC_002_Verify_Corporate_Company_Info_Error_Notification");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("Corporate General");
		logger.setDescription("Login as Corporate Admin and verify the landing page.");
	
		wait_for_pageload(Variables.url);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		
				
		//Creating instance of login page
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");;
		logger.log(LogStatus.INFO, "Enter valid login credential and click on Login button,Corporate Landing page displayed");
		
		Corporate_ProfilePage landP = PageFactory.initElements(driver, Corporate_ProfilePage.class);

		String land = landP.clickonProfileandVerifyProfilePage();
		
		if(!land.isEmpty()){			
			//Action_Method.veriftText("//div[contains(text(),' Required fields cannot be empty.')]", "Required fields cannot be empty.");
			logger.log(LogStatus.PASS, "Company name is displays properly "+land);
		}
		else{
			logger.log(LogStatus.FAIL, "Improper company name"+land);
			}
		
		String err = landP.Error_Message_For_NoInputs();
		
		if(!err.equalsIgnoreCase("NoError")) {
			logger.log(LogStatus.PASS, "Error message validated for corporate profile page - "+err);
		}else {
			logger.log(LogStatus.FAIL, "Error message not validated. "+err);
		}
				
		extent.endTest(logger);
		lp.logout();
	}
	
}
	

