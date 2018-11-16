package com.objects_pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.controller.Action_Method;

public class Corporate_PostVideoJD_AddSkillsPage extends Action_Method
{
	//Locating all elements present in Add skills page
		
		@FindBy(xpath="//div[contains(text(),'Post Video JD')]")
		WebElement PostVideoJD_Main_PageTitle;
		
		@FindBy(xpath="//div[contains(text(),' Add Skills')]")
		WebElement Aaddskills_PageTitle;
		
		@FindBy(xpath="//input[@id='skillName']")
		WebElement Name;
		
		@FindBy(xpath="//section[contains(text(),'Rating')]")
		WebElement Rating_Text;
		
		@FindBy(xpath="//section[contains(text(),' Type')]")
		WebElement Type_Text;
		
		
		//@FindBy(xpath="//div[contains(text(),'Must Have Skills')]")
		@FindBy(id="mustSkills")
		WebElement MustHaveSkills;
		
		@FindBy(xpath="//div[contains(text(),' Good to have skills')]")
		WebElement GoodToHaveSkills;
		
		@FindBy(xpath="//section[contains(text(),'Experience')]")
		WebElement Experience_Text;
		
		@FindBy(xpath="//input[@id='expYears']")
		WebElement Experience_Years;
		
		@FindBy(xpath="//button[@id='next']/span")
		WebElement Add_Skill_Button;
		
		@FindBy(xpath="//button[@id='next']/span")
		WebElement Add_Skill_text;
		
		@FindBy(xpath="//button[span[contains(text(),'Previous')]]")
		WebElement Previous_Button;
		
		@FindBy(xpath="//span[contains(text(),'Previous')]")
		WebElement Previous_Button_Text;
		
		@FindBy(xpath="//button[span[contains(text(),'Next')]]")
		WebElement Next_Button;
		
		@FindBy(xpath="//span[contains(text(),'Next')]")
		WebElement Next_Button_text;
		
		@FindBy(xpath="//mat-card-title[contains(text(),'Must Have Skills')]")
		WebElement musthaveskills_text_on_MustHaveskillsCard;
		
		@FindBy(xpath="//mat-card-header[div[mat-card-title[contains(text(),'Must Have Skills')]]]/following-sibling::mat-card-content//div[contains(text(),'Skill')]")
		WebElement Skill_text_on_MustHaveskillsCard;
		
		
		@FindBy(xpath="//mat-card-header[div[mat-card-title[contains(text(),'Must Have Skills')]]]/following-sibling::mat-card-content//div[contains(text(),'Rating')]")
		WebElement Rating_text_on_MustHaveskillsCard;
		
		@FindBy(xpath="//mat-card-header[div[mat-card-title[contains(text(),'Must Have Skills')]]]/following-sibling::mat-card-content//div[contains(text(),'Experience')]")
		WebElement Experience_text_on_MustHaveskillsCard;
		
		
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[2]/div/app-skill-display-row/div/div[1]")
		WebElement Skill1_Name_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[3]/div/app-skill-display-row/div/div[1]")
		WebElement Skill2_Name_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[4]/div/app-skill-display-row/div/div[1]")
		WebElement Skill3_Name_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[5]/div/app-skill-display-row/div/div[1]")
		WebElement Skill4_Name_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[6]/div/app-skill-display-row/div/div[1]")
		WebElement Skill5_Name_Musthaveskills;
		
		
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[2]/div/app-skill-display-row/div/div[2]")
		WebElement Skill1_Rating_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[3]/div/app-skill-display-row/div/div[2]")
		WebElement Skill2_Rating_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[4]/div/app-skill-display-row/div/div[2]")
		WebElement Skill3_Rating_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[5]/div/app-skill-display-row/div/div[2]")
		WebElement Skill4_Rating_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[6]/div/app-skill-display-row/div/div[2]")
		WebElement Skill5_Rating_Musthaveskills;
		
		
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[2]/div/app-skill-display-row/div/div[3]")
		WebElement Skill1_Experience_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[3]/div/app-skill-display-row/div/div[3]")
		WebElement Skill2_Experience_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[4]/div/app-skill-display-row/div/div[3]")
		WebElement Skill3_Experience_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[5]/div/app-skill-display-row/div/div[3]")
		WebElement Skill4_Experience_Musthaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[6]/div/app-skill-display-row/div/div[3]")
		WebElement Skill5_Experience_Musthaveskills;
		
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[2]/div//mat-icon[1]")
		WebElement Skill1_Edit_MustHaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[2]/div//mat-icon[2]")
		WebElement Skill1_Delete_MustHaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[3]/div//mat-icon[1]")
		WebElement Skill2_Edit_MustHaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[3]/div//mat-icon[2]")
		WebElement Skill2_Delete_MustHaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[4]/div//mat-icon[1]")
		WebElement Skill3_Edit_MustHaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[4]/div//mat-icon[2]")
		WebElement Skill3_Delete_MustHaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[5]/div//mat-icon[1]")
		WebElement Skill4_Edit_MustHaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[5]/div//mat-icon[2]")
		WebElement Skill4_Delete_MustHaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[6]/div//mat-icon[1]")
		WebElement Skill5_Edit_MustHaveskills;
		@FindBy(xpath="//mat-card[@id='Must Have Skills']//mat-list-item[6]/div//mat-icon[2]")
		WebElement Skill5_Delete_MustHaveskills;
		
		
			
		@FindBy(xpath="//mat-card-title[contains(text(),'Good to Have Skills')]")
		WebElement GoodTohaveskills_text_on_GoodToHaveskillsCard;
		
		@FindBy(xpath="//mat-card-header[div[mat-card-title[contains(text(),'Good to Have Skills')]]]/following-sibling::mat-card-content//div[contains(text(),'Skill')]")
		WebElement Skill_text_on_GoodToHaveskillsCard;
		
		
		@FindBy(xpath="//mat-card-header[div[mat-card-title[contains(text(),'Good to Have Skills')]]]/following-sibling::mat-card-content//div[contains(text(),'Rating')]")
		WebElement Rating_text_on_GoodToHaveskillsCard;
		
		@FindBy(xpath="//mat-card-header[div[mat-card-title[contains(text(),'Good to Have Skills')]]]/following-sibling::mat-card-content//div[contains(text(),'Experience')]")
		WebElement Experience_text_on_GoodToHaveskillsCard;
		
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[2]/div/app-skill-display-row/div/div[1]")
		WebElement Skill1_Name_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[3]/div/app-skill-display-row/div/div[1]")
		WebElement Skill2_Name_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[4]/div/app-skill-display-row/div/div[1]")
		WebElement Skill3_Name_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[5]/div/app-skill-display-row/div/div[1]")
		WebElement Skill4_Name_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[6]/div/app-skill-display-row/div/div[1]")
		WebElement Skill5_Name_GoodToHaveskills;
		
		
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[2]/div/app-skill-display-row/div/div[2]")
		WebElement Skill1_Rating_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[3]/div/app-skill-display-row/div/div[2]")
		WebElement Skill2_Rating_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[4]/div/app-skill-display-row/div/div[2]")
		WebElement Skill3_Rating_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[5]/div/app-skill-display-row/div/div[2]")
		WebElement Skill4_Rating_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[6]/div/app-skill-display-row/div/div[2]")
		WebElement Skill5_Rating_GoodToHaveskills;
		
		
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[2]/div/app-skill-display-row/div/div[3]")
		WebElement Skill1_Experience_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[3]/div/app-skill-display-row/div/div[3]")
		WebElement Skill2_Experience_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[4]/div/app-skill-display-row/div/div[3]")
		WebElement Skill3_Experience_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[5]/div/app-skill-display-row/div/div[3]")
		WebElement Skill4_Experience_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[6]/div/app-skill-display-row/div/div[3]")
		WebElement Skill5_Experience_GoodToHaveskills;
		
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[2]/div//mat-icon[1]")
		WebElement Skill1_Edit_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[2]/div//mat-icon[2]")
		WebElement Skill1_Delete_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[3]/div//mat-icon[1]")
		WebElement Skill2_Edit_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[3]/div//mat-icon[2]")
		WebElement Skill2_Delete_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[4]/div//mat-icon[1]")
		WebElement Skill3_Edit_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[4]/div//mat-icon[2]")
		WebElement Skill3_Delete_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[5]/div//mat-icon[1]")
		WebElement Skill4_Edit_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[5]/div//mat-icon[2]")
		WebElement Skill4_Delete_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[6]/div//mat-icon[1]")
		WebElement Skill5_Edit_GoodToHaveskills;
		@FindBy(xpath="//mat-card[@id='Good to Have Skills']//mat-list-item[6]/div//mat-icon[2]")
		WebElement Skill5_Delete_GoodToHaveskills;
		
		
		@FindBy(xpath="//div[contains(text(),' Required Fields are mandatory')]")
		WebElement Error_Message_Addskill;
		
		@FindBy(xpath="//button[@id='next']/span")
		WebElement Edit_Skill_text;
		
		public void Complete_AddskillsPage(String filename,String sname) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			Actions act=new Actions(driver);
			wait_for_elementpresent(Name);
			//Adding 5 must have skills
			//act.moveToElement(Name).click().sendKeys(Keys.chord(getExceldata(filename, sname,"skill1"),Keys.ESCAPE)).perform();
			Name.sendKeys(getExceldata(filename, sname,"skill1"));
			Name.sendKeys(Keys.TAB);
			MustHaveSkills.click();
			Experience_Years.sendKeys(getExceldata(filename, sname,"Year 1"));
			Add_Skill_Button.click();
			
			Thread.sleep(1000);
			//act.moveToElement(Name).click().sendKeys(Keys.chord(getExceldata(filename, sname,"skill2"),Keys.ESCAPE)).perform();
			Name.sendKeys(getExceldata(filename, sname,"skill2"));
			Name.sendKeys(Keys.TAB);
			MustHaveSkills.click();
			Experience_Years.sendKeys(getExceldata(filename, sname,"Year 2"));
			Add_Skill_Button.click();
			
			Thread.sleep(1000);
			//act.moveToElement(Name).click().sendKeys(Keys.chord(getExceldata(filename, sname,"skill3"),Keys.ESCAPE)).perform();
			Name.sendKeys(getExceldata(filename, sname,"skill3"));
			Name.sendKeys(Keys.TAB);
			MustHaveSkills.click();
			Experience_Years.sendKeys(getExceldata(filename, sname,"Year 3"));
			Add_Skill_Button.click();
			
			Thread.sleep(1000);
			//act.moveToElement(Name).click().sendKeys(Keys.chord(getExceldata(filename, sname,"skill4"),Keys.ESCAPE)).perform();
			Name.sendKeys(getExceldata(filename, sname,"skill4"));
			Name.sendKeys(Keys.TAB);
			MustHaveSkills.click();
			Experience_Years.sendKeys(getExceldata(filename, sname,"Year 4"));
			Add_Skill_Button.click();
			
			Thread.sleep(1000);
			//act.moveToElement(Name).click().sendKeys(Keys.chord(getExceldata(filename, sname,"skill5"),Keys.ESCAPE)).perform();
			Name.sendKeys(getExceldata(filename, sname,"skill5"));
			Name.sendKeys(Keys.TAB);
			MustHaveSkills.click();
			Experience_Years.sendKeys(getExceldata(filename, sname,"Year 5"));
			Add_Skill_Button.click();
			
			//Adding 5 good to have skills
			
			Thread.sleep(1000);
			//act.moveToElement(Name).click().sendKeys(Keys.chord(getExceldata(filename, sname,"skill6"),Keys.ESCAPE)).perform();
			Name.sendKeys(getExceldata(filename, sname,"skill6"));
			Name.sendKeys(Keys.TAB);
			GoodToHaveSkills.click();
			Experience_Years.sendKeys(getExceldata(filename, sname,"Year 1"));
			Add_Skill_Button.click();
			
			Thread.sleep(1000);
			//act.moveToElement(Name).click().sendKeys(Keys.chord(getExceldata(filename, sname,"skill7"),Keys.ESCAPE)).perform();
			Name.sendKeys(getExceldata(filename, sname,"skill7"));
			Name.sendKeys(Keys.TAB);
			GoodToHaveSkills.click();
			Experience_Years.sendKeys(getExceldata(filename, sname,"Year 2"));
			Add_Skill_Button.click();
			
			Thread.sleep(1000);
			//act.moveToElement(Name).click().sendKeys(Keys.chord(getExceldata(filename, sname,"skill8"),Keys.ESCAPE)).perform();
			Name.sendKeys(getExceldata(filename, sname,"skill8"));
			Name.sendKeys(Keys.TAB);
			GoodToHaveSkills.click();
			Experience_Years.sendKeys(getExceldata(filename, sname,"Year 3"));
			Add_Skill_Button.click();
			
			Thread.sleep(1000);
			//act.moveToElement(Name).click().sendKeys(Keys.chord(getExceldata(filename, sname,"skill9"),Keys.ESCAPE)).perform();
			Name.sendKeys(getExceldata(filename, sname,"skill9"));
			Name.sendKeys(Keys.TAB);
			GoodToHaveSkills.click();
			Experience_Years.sendKeys(getExceldata(filename, sname,"Year 4"));
			Add_Skill_Button.click();
			
			Thread.sleep(1000);
			//act.moveToElement(Name).click().sendKeys(Keys.chord(getExceldata(filename, sname,"skill10"),Keys.ESCAPE)).perform();
			Name.sendKeys(getExceldata(filename, sname,"skill10"));
			Name.sendKeys(Keys.TAB);
			GoodToHaveSkills.click();
			Experience_Years.sendKeys(getExceldata(filename, sname,"Year 5"));
			Add_Skill_Button.click();
			
			act.moveToElement(Next_Button).perform();
			Next_Button.click();
			Thread.sleep(5000);
			
			
		}

		
		
		
}
