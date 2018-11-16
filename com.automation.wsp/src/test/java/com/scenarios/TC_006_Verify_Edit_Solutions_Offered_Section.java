package com.scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.Corporate_Profile_OfficeLocations_Page;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC_006_Verify_Edit_Solutions_Offered_Section extends Action_Method {
	
	public void Verify_Edit_Solutions_Offered() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		logger = extent.startTest("Corporate Company Info Page Started.");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		
		wait_for_pageload(Variables.url);

		//Creating instance of login page
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		lp.EnterValidLogin(Variables.testdata,Variables.LoginPage,"Corporate Email","Corporate Password");
		
		Corporate_Profile_OfficeLocations_Page profile2 = PageFactory.initElements(driver, Corporate_Profile_OfficeLocations_Page.class);
		profile2.Verify_Edit_Solutions_Offered();
	}


}
