package testCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGrid {

	@Test
	public void test1() throws InterruptedException
	{
		
		URL url = null;
		try 
		{
			url = new URL("http://localhost:4444/wd/hub");
		} catch (MalformedURLException e) {
			
			System.out.println("Exception "+e.getMessage());
		}
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setBrowserName(BrowserType.CHROME);

		cap.setPlatform(Platform.LINUX);
		
		cap.setVersion("60.0");
		
		WebDriver driver=new RemoteWebDriver(url, cap);
		
		driver.get("http://www.google.com");
		
		Thread.sleep(20000);
			
		
	}
	
	
}
