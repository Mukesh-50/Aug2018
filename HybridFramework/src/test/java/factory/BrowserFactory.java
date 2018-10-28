package factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver startBrowser(String browser, String applicationURL) {

		System.out.println("**** Starting " + browser + " with " + applicationURL + "****");

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(options);

		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.ignoreZoomSettings();
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setAcceptInsecureCerts(true);
			options.merge(cap);
			driver = new InternetExplorerDriver(options);
		} else {
			System.out.println("Sorry we do not support " + browser + "Please select Chrome, Firefox or IE Options");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println(applicationURL + " Loaded");

		return driver;

	}

	public static WebDriver startSessionOnCloud(String Platform, String PlatformVersion, String Browser, String version,
			String appURL) {

		URL url = null;
		try {
			url = new URL("https://mukeshotwani3:s4GTbs4fFzQxJxzpzp2f@hub-cloud.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {

			System.out.println("Exception " + e.getMessage());
		}

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browser", Browser);
		caps.setCapability("browser_version", version);
		caps.setCapability("os", Platform);
		caps.setCapability("os_version", PlatformVersion);

		WebDriver driver = new RemoteWebDriver(url, caps);

		driver.get(appURL);

		return driver;

	}

	public static WebDriver startSessionOnDevice(String Browser,String device,boolean realDevice,String version, String appURL) {

		URL url = null;
		try {
			url = new URL("https://mukeshotwani3:s4GTbs4fFzQxJxzpzp2f@hub-cloud.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {

			System.out.println("Exception " + e.getMessage());
		}

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browserName", Browser);
		caps.setCapability("device",device);
		caps.setCapability("realMobile",realDevice);
		caps.setCapability("os_version",version);

		WebDriver driver = new RemoteWebDriver(url, caps);

		driver.get(appURL);

		return driver;

	}

	public static void closeBrowser() {
		System.out.println("**** Trying to close Browser ****");
		driver.quit();
		System.out.println("**** Browser Closed ****");
	}

}
