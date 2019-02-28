package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Action_Method implements ITestListener {
	public static WebDriver driver;

	public static Logger log;

	public static ExtentReports extent;
	public static ExtentTest logger;
	

	public void TakeScreenshot(String fname) throws IOException
	{
		EventFiringWebDriver ed=new EventFiringWebDriver(driver);
		File src=ed.getScreenshotAs(OutputType.FILE);
		File dst=new File(Variables.Screenshot+fname+".png");
		FileUtils.copyFile(src, dst);
	}

	public static String getExceldata(String filename,String sname,int rnum,int cnum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String filepath=filename;
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sname);
		Row r=sh.getRow(rnum);
		Cell cel=r.getCell(cnum);
		String data=cel.getStringCellValue();
		return data;
	}

	
	public static void setExceldata(String filename,String sname,String word,String New_data) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		//String Ex_Data = "";
		String data="";
		String filepath=filename;
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sname);
		int row_count=sh.getLastRowNum();
		for(int i=0;i<=row_count;i++)
		{
			Row r=sh.getRow(i);
			Cell cel=r.getCell(0);
			data=cel.getStringCellValue();
			if(word.equalsIgnoreCase(data))
			{
				Cell c=r.createCell(1);
				c.setCellType(CellType.STRING);
				c.setCellValue(New_data);
				FileOutputStream fos=new FileOutputStream(filepath);
				wb.write(fos);
				wb.close();
				break;
			}
		}
		
	}

	public static String getExceldata(String filename,String sname,String word) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		String Ex_Data = "";
		String data="";
		String filepath=filename;
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sname);
		int row_count=sh.getLastRowNum();
		for(int i=0;i<=row_count;i++)
		{
			Row r=sh.getRow(i);
			Cell cel=r.getCell(0);
			data=cel.getStringCellValue();
			if(word.equalsIgnoreCase(data))
			{
				Cell c=r.getCell(1);
				Ex_Data=c.getStringCellValue();
				break;
			}
		}
		return Ex_Data;
	}

	public static String getExceldata(String filename,String sname,String word,int c_nom) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String Ex_Data = "";
		String data="";
		String filepath=filename;
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sname);
		int row_count=sh.getLastRowNum();
		for(int i=0;i<=row_count;i++)
		{
			Row r=sh.getRow(i);
			Cell cel=r.getCell(0);
			data=cel.getStringCellValue();
			if(word.equalsIgnoreCase(data))
			{
				Cell c=r.getCell(c_nom);
				Ex_Data=c.getStringCellValue();
				break;
			}
		}
		return Ex_Data;
	}

	public static void scrollingToBottomofAPage() 
	{
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollingToElementofAPage(WebElement element) 
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollingByCoordinatesofAPage(int x,int y) 
	{
		((JavascriptExecutor) driver).executeScript("window.scrollBy("+x+","+y+")");
	}


	public static void Window_Handling(String Title)
	{
		Set<String> All_wid=driver.getWindowHandles();
		Iterator<String> it=All_wid.iterator();
		for(int i=0;i<All_wid.size();i++)

		{
			String wid=it.next();
			driver.switchTo().window(wid);
			String act_title=driver.getTitle();
			if(Title.equals(act_title))
			{
				break;
			}
		}
	}
	public static void Child_Window_Handling()
	{
		Set<String> All_wid=driver.getWindowHandles();
		Iterator<String> it=All_wid.iterator();

		//String wid1=it.next();
		String wid2=it.next();
		driver.switchTo().window(wid2);

	}


	public static void wait_for_pageload(String url)
	{ 
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(Variables.time,TimeUnit.SECONDS);
	}

	public static void wait_for_elementpresent(WebElement wb)
	{
		WebDriverWait wait= new WebDriverWait(driver,Variables.time);
		wait.until(ExpectedConditions.visibilityOf((WebElement) wb));
	}

	public static void wait_for_elementpresent_Clickable(WebElement wb)
	{
		WebDriverWait wait= new WebDriverWait(driver,Variables.time);
		wait.until(ExpectedConditions.elementToBeClickable(wb));
	}

	public static  WebDriver getbrowser()
	{
		if(Variables.browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",Variables.chrome_driver_path);
			ChromeOptions co=new ChromeOptions();
			co.addArguments("disable-extensions");
			co.addArguments("test-type");
			co.addArguments("--start-maximized");
			co.addArguments("disable-infobars");
			co.addArguments("use-fake-ui-for-media-stream");
			//co.addArguments("user-data-dir=/path/to/the/saved/profileDir");
			DesiredCapabilities capbility=DesiredCapabilities.chrome();
				capbility.setCapability("acceptSslCerts",true);
				capbility.setCapability("acceptInsecureCerts", true);
				capbility.setCapability("browserConnectionEnabled", true);
				capbility.setCapability(ChromeOptions.CAPABILITY,co);
				co.merge(capbility);
			driver=new ChromeDriver(co);
			driver.manage().window().maximize();

		}
		else
		{
			FirefoxOptions options=new FirefoxOptions();
			options.addPreference("media.navigator.permission.disabled", true);
			System.setProperty("webdriver.gecko.driver",Variables.gecko_driver_path);			  
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			driver= new FirefoxDriver(options);
			driver.manage().window().maximize();
		}
		return driver;

	}

	public static void close_browser()
	{
		driver.quit();
	}

	public void onFinish(ITestContext arg0) {

		// TODO Auto-generated method stub
		//extent.flush();
		//extent.close();
		//driver.close();

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//ExtentReports(String filePath,Boolean replaceExisting) 
		extent = new ExtentReports (Variables.ExtentReport_Path, true);
		//extent.addSystemInfo("Environment","Environment Name")
		extent
		.addSystemInfo("Host Name", "SoftwareTestingMaterial")
		.addSystemInfo("Environment", "Workstreets Platform Automation");

		//loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		extent.loadConfig(new File(Variables.ExtendConfigFile_Path));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult t)
	{
		String filename=t.getMethod().getMethodName();
		Action_Method am=new Action_Method();
		try
		{
			am.TakeScreenshot(filename);
		}
		catch(Exception e)
		{

		}
		
		if(t.getStatus()==ITestResult.FAILURE) {
			String reason = t.getThrowable().toString();
			if(!reason.isEmpty()&&reason.length()>200) {
				logger.log(LogStatus.FAIL, "Failed Reason : "+reason.substring(0, 200));
			}else {
				logger.log(LogStatus.FAIL, reason);
			}
			
			extent.endTest(logger);
		}
	
	}

	public void onTestSkipped(ITestResult t) {
		// TODO Auto-generated method stub
		if(t.getStatus()==ITestResult.SKIP) {
			String reason = t.getThrowable().toString();
			if(!reason.isEmpty()&&reason.length()>200) {
				logger.log(LogStatus.SKIP, "Skipped Reason : "+reason.substring(0, 200));
			}else {
				logger.log(LogStatus.SKIP, reason);
			}
			
			extent.endTest(logger);
		}
	}
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		

	}


}
