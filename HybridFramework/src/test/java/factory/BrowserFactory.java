package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	static WebDriver driver;
		

	public static WebDriver startBrowser(String browser,String applicationURL)
	{
		
		System.out.println("**** Starting "+ browser + "with "+applicationURL + "****");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver=new ChromeDriver(options);
			
		}else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			FirefoxOptions options=new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			driver=new FirefoxDriver(options);
			
		}else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			InternetExplorerOptions options=new InternetExplorerOptions();
			options.ignoreZoomSettings();
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setAcceptInsecureCerts(true);
			options.merge(cap);
			driver=new InternetExplorerDriver(options);
		}
		else
		{
			System.out.println("Sorry we do not support "+browser + "Please select Chrome, Firefox or IE Options");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(applicationURL + " Loaded");
		
		return driver;
		
	}
	
	public static void closeBrowser()
	{
		System.out.println("**** Trying to close Browser ****");
		driver.quit();
		System.out.println("**** Browser Closed ****");
	}

}
