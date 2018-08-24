package com.objects_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.controller.Action_Method;

public class Corporate_PostVideoJD_AddVideoPage extends Action_Method
{
	//Locating all elements present in Add Video page
	
	@FindBy(xpath="//div[contains(text(),'Post Video JD')]")
	WebElement PostVideoJD_Main_PageTitle;
	@FindBy(xpath="//div[contains(text(),'Add Video')]")
	WebElement AddVideo_PageTitle;
	@FindBy(xpath="//div[contains(text(),'Add Video')]/following-sibling::div")
	WebElement TextPresent_In_AddVideoPage;
	@FindBy(xpath="//div[@class='col-xs-12 col-md-6 hidden-sm hidden-xs btn-margin']/button")
	WebElement Previous_btn;
	@FindBy(xpath="//div[@class='col-xs-12 col-md-6 hidden-sm hidden-xs btn-margin']/button/span")
	WebElement Previous_btn_Text;
	@FindBy(xpath="//div[@class='col-xs-12 col-md-6 btn-margin next-align']/button")
	WebElement Save_btn;
	@FindBy(xpath="//div[@class='col-xs-12 col-md-6 btn-margin next-align']/button/span")
	WebElement Save_btn_text;
//	@FindBy(xpath="//a[@id='open-popup-myinterview']")
//	WebElement Thumbnail;
	
	@FindBy(xpath="//a/img[@class='img-responsive custom-img']")
	WebElement Thumbnail;
	
	
	public void Complete_AddvideoPage() throws InterruptedException
	{
		wait_for_elementpresent(Thumbnail);
		Actions act=new Actions(driver);
		act.moveToElement(Thumbnail).click();
		Thumbnail.click();
		//Creating object for Myinterview page
		MyInterviewPage mip=PageFactory.initElements(driver,MyInterviewPage.class);
		mip.VideoRecording_JobPost();
		Thread.sleep(5000);
		wait_for_elementpresent(Save_btn);
		Save_btn.click();
		
	}
	
}
