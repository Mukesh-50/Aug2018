package unitTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BrowserFactory;

public class TestBrowserFactory {

	
	@Test
	public void checkInstance()
	{
		WebDriver driver=BrowserFactory.startBrowser("Chrome","http://www.google.com");
		System.out.println(driver);
		Assert.assertTrue(driver!=null);
		BrowserFactory.closeBrowser();
	}
	
	
}
