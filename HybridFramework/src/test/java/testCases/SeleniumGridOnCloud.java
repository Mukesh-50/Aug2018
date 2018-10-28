package testCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridOnCloud {

	@Test
	public void test1() throws InterruptedException {

		URL url = null;
		try {
			url = new URL("https://mukeshotwani3:s4GTbs4fFzQxJxzpzp2f@hub-cloud.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {

			System.out.println("Exception " + e.getMessage());
		}

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browserName", "iPhone");
		caps.setCapability("device", "iPhone 8 Plus");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "11.0");

		WebDriver driver = new RemoteWebDriver(url, caps);

		driver.get("http://www.google.com");

		driver.findElement(By.name("q")).sendKeys("mukesh Otwani");

		Thread.sleep(5000);

		driver.quit();

	}

}
