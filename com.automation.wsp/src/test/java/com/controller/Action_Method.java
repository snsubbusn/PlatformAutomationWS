package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import com.controller.Variables;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Action_Method implements ITestListener, IRetryAnalyzer, IAnnotationTransformer{
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
	
	public static void scrollingToTopofAPage() 
	{
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
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
		System.out.println(All_wid);
		Iterator<String> it=All_wid.iterator();
				

		//String wid1=it.next();
		String wid2 = it.next();
		System.out.println(wid2);
		driver.switchTo().window(wid2);
		
		

	}
	
	public static void Child_Window_Handling01()
	{

	    ArrayList tabs = new ArrayList(driver.getWindowHandles());
	    //System.out.println(tabs.size());
	    driver.switchTo().window((String) tabs.get(1));
	    
	}
	
	public static void Window_Handling()
	{
		String parentWindow= driver.getWindowHandle();
		
		List<String> allWindows = (List<String>) driver.getWindowHandles();
		for(String curWindow : allWindows){
		    driver.switchTo().window(curWindow);
		}
	
		driver.close();
		
		driver.switchTo().window(parentWindow);

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

	public void onFinish(ITestContext context) {

		// TODO Auto-generated method stub
		//extent.flush();
		//extent.close();
		//driver.close();
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}
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
			if(t.getStatus()==ITestResult.FAILURE) {
				String reason = t.getThrowable().toString();
				if(!reason.isEmpty()&&reason.length()>200) {
					logger.log(LogStatus.FAIL, logger.addBase64ScreenShot(Variables.Screenshot+filename+".png")+"Failed Reason : \""+reason.substring(0, 190));
					
				}else {
					logger.log(LogStatus.FAIL, reason);
				}
			}
		}
		catch(Exception e)
		{
			if(t.getStatus()==ITestResult.FAILURE) {
				String reason = t.getThrowable().toString();
				if(!reason.isEmpty()&&reason.length()>200) {
					logger.log(LogStatus.FAIL, "Failed Reason : \""+reason.substring(0, 200));

				}else {
					logger.log(LogStatus.FAIL, reason);
				}				
			}
		}finally{
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
				logger.log(LogStatus.SKIP, "Skipped Reason : "+reason);
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

	
	//Retry class which implements IRetryAnalyzer

	private int retryCount = 0;
	private int maxRetryCount = 1;
	// Below method returns 'true' if the test method has to be retried else 'false' 
	//and it takes the 'Result' as parameter of the test method that just ran
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			System.out.println("Retrying test " + result.getName() + " with status "
					+ getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
			
			logger.log(LogStatus.FAIL, "Test case Failed. Retrying test " + result.getName() + " with status "
					+ getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
			retryCount++;
			return true;
		}
		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if(status==1)
			resultName = "SUCCESS";
		if(status==2)
			resultName = "FAILURE";
		if(status==3)
			resultName = "SKIP";
		return resultName;
	}

	/*@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}*/

	
	//RetryListener class implements IAnnotationTransformer 
	 @Override
	    public void transform(ITestAnnotation testannotation, Class testClass,
	            Constructor testConstructor, Method testMethod) {
	        IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

	        if (retry == null)  {
	            testannotation.setRetryAnalyzer(Action_Method.class);
	        }

	    }
	/*@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub

	}*/

	 public void HandlingMultipleTabs()
	 {
		 Actions action= new Actions(driver);
		 action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
	 }

}
