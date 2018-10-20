package unitTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import factory.BrowserFactory;

public class TestBrowserFactory {

	
	@Parameters({"Browser"})
	@Test
	public void checkInstance(String browserDetails)
	{
		WebDriver driver=BrowserFactory.startBrowser(browserDetails,"http://www.google.com");
		System.out.println(driver);
		Assert.assertTrue(driver!=null);
		BrowserFactory.closeBrowser();
		// commited for polling
	}
	
	
}
