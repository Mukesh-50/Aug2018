package testCases;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import factory.BrowserFactory;

public class JavaSample {

	public static final String USERNAME = "mukeshotwani3";
	public static final String AUTOMATE_KEY = "s4GTbs4fFzQxJxzpzp2f";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName(BrowserType.CHROME);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("BrowserStack");
		element.submit();

		System.out.println(driver.getTitle());
		driver.quit();

	}
}