package com.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;
import com.controller.Variables;
import com.objects_pages.loginPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC_001_Verify_LoginPage extends Action_Method
{
	public void Verify_all_elements_present_in_loginPage() throws InterruptedException
	{

		logger = extent.startTest("TC_001_Verifying all elements and text present in Login page");
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		logger.assignAuthor("Sivaprakash");
		logger.assignCategory("General");
		logger.setDescription("Launch the URL and verify the login page elements are displayed and validate the login page");
	
		//Launching the url

		wait_for_pageload(Variables.url);

		//Creating instance of login page

		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		logger.log(LogStatus.INFO, "Launched the URL and login page is displayed");
		logger.log(LogStatus.INFO, "Verify all elements and texts are present in login page");
		//Verify Workstreets logo

		logger.log(LogStatus.INFO, "Verifying \"Workstreets Logo\" in login page");
		if(lp.WorkstreetsLogo()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Workstreets Logo\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Workstreets Logo\" is not available");
		}

		//Learnathon is not present in the new website (Modified on 16-Oct-2018 Siva)
/*		//Verify Learnathon link
		if(lp.LearnathonLink()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Learnathon link\" is available");
		}else{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Learnathon link\" is not available");
		}

		//Verify About link

		if(lp.About_link()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"About Link\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"About Link\" is not available");
		}
*/	
		//Verify Copyright
		if(lp.Copyright()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Copy right\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"copy right\" is not available");
		}

		//Verify Pricavypolicy
		if(lp.PrivacyPolicy()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Privacy policy\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Privacy policy\" is not available");
		}

		//Verify Terms and conditions
		if(lp.TermsAndCondition()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Terms and conditions\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Terms and conditions\" is not available");
		}

		
		//Commented as these features are removed in the new website (Siva- 16-Oct-18)
/*
		//Verify Onboard handcraft text
		if(lp.OnboardToHandCraft()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"On board handcraft\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"On board handcraft\" is not available");
		}

		//Verify Your career Together live
		if(lp.Your_Career_Together_live()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Your career together live\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Your career together live\" is not available");
		}
*/
		//Verify login tab
		if(lp.LoginTab()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Login tab\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Login tab\" is not available");
		}

		//Verify Register tab
		if(lp.RegisterTab()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Register Tab\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Register tab\" is not available");
		}
		
		//Verify the details within the Login Tab
		lp.clickOnLoginTab();

		//Verify "Welcome back!" text
		if(lp.Login_Text1()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Welcome back!\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Welcome back!\" is not available");
		}

		//Verify "Please login to access your account." text
		if(lp.Login_Text2()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Please login to access your account\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Please login to access your account\" is not available");
		}

		//Verify Email field
		if(lp.Email()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Email field\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Email field\" is not available");
		}

		//Verify Password field
		if(lp.Password()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Password field\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"password field\" is not available");
		}

		//Verify Login button
		if(lp.Login_Button()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Login button\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Login button\" is not available");
		}

		//Verify Forgot password link
		if(lp.ForgotPasswordLink()==true) 
		{
			logger.log(LogStatus.PASS, "Verify elements present in Login page","\"Forgot password link\" is available");
		}
		else 
		{
			logger.log(LogStatus.FAIL, "Verify elements present in Login page","\"Forgot password link\" is not available");
		}

		logger.log(LogStatus.INFO,"All elements & text present in Login page verified");
		extent.endTest(logger);

	}
}
