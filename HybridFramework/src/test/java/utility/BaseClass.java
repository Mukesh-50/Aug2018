package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class BaseClass {
	
	public WebDriver driver;
	public ExtentReports extentReport;
	public ExtentTest logger;
	
	@BeforeSuite
	public void settingUpReport()
	{

		System.out.println("**** Setting up Report ****");
		String path=System.getProperty("user.dir") + "/Reports/Learn_Automation" + Helper.getSystemDate() + ".html";
		System.out.println("**** Report can be checked after execution ****");
		System.out.println(path);
		
		ExtentHtmlReporter report = new ExtentHtmlReporter(path);

		extentReport = new ExtentReports();

		extentReport.attachReporter(report);
	}
	
	@AfterMethod
	public void tearDownReport(ITestResult result) throws IOException
	{
		
		System.out.println("**** Trying to get Result Details and Adding in Report****");
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			
			logger.pass("Test Passed Successfully", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(driver)).build());

		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(driver)).build());

		}
		else
		{
			logger.skip(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(driver)).build());

		}
		
		extentReport.flush();
		
		System.out.println("**** Test Details added in Report****");

	}
	
	
	@Parameters("Browser")
	@BeforeClass
	public void startApplication(String browserDetails)
	{
		driver = BrowserFactory.startBrowser(browserDetails, DataProviderFactory.getConfig().getStagingURL());
	}
	
	

	@AfterClass
	public void closeApplication()
	{
		BrowserFactory.closeBrowser();
	}

}
